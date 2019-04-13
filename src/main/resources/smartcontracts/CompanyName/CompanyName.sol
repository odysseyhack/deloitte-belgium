pragma solidity ^0.5.1;
contract KVKList {

    address owner;
    string kvkNumber;
    mapping(address => bool) public purchasePermissions;
    mapping(address => bool) public salesPermissions;

    constructor(string memory _kvkNumber) public {
        owner = msg.sender;
        kvkNumber = _kvkNumber;
    }

    modifier onlyKVK{
        require(
            msg.sender == owner,
            "Only KVK can perform this action."
        );
        _;
    }


    function grantAccessPurchases(address _publicKey) public onlyKVK{
        purchasePermissions[_publicKey] = true;
    }

    function grantAccessSales(address _publicKey) public onlyKVK{
        salesPermissions[_publicKey] = true;
    }

    function removeAccessPurchases(address _publicKey) public onlyKVK{
        purchasePermissions[_publicKey] = false;
    }

    function removeAccessSales(address _publicKey) public onlyKVK{
        salesPermissions[_publicKey] = false;
    }

    function isAuthorizedForPurchases(address _publicKey) public view returns (bool purchasesApproved){
        return purchasePermissions[_publicKey];
    }

    function isAuthorizedForSales(address _publicKey) public view returns (bool salesApproved){
        return salesPermissions[_publicKey];
    }

}

contract CompanyName {

    // ---- DOCUMENTATION ----

    // ---- EVENTS ----

    event CompanyCertificationStatus(address indexed company, bool status);

    // ---- STATE VARIABLES ----

    //Define the KVK address (hardcoded)
    address kvkAddress;

    //Define the owner of the contract (at creation)
    address contractOwner1;
    address contractOwner2;
    address contractOwner3;

    //This state will be true after KVK registration, KVK al revert this later

    bool certificationByKVK = true;

    //KVKnumber

    uint KVKnumber;

    //KVK certified addresses contract

    KVKList listContract;

    //Address metadata
    struct permissionnedAddress{
        address ethereumAddress;
        bool active;
        bool admin;
        uint spendingLimit;
    }

    //A mapping keeping track of permissioned addressess
    uint counter = 0;
    mapping (address => permissionnedAddress) addressMapping;

    // ---- CONSTRUCTOR ----

    //The owner is the one who created the contract
    constructor (address _contractOwner1, address _contractOwner2, address _contractOwner3, uint _KVKnumber, address _listContract) public{
        kvkAddress = msg.sender;
        KVKnumber = _KVKnumber;
        listContract = KVKList (_listContract);
        contractOwner1 = _contractOwner1;
        contractOwner1 = _contractOwner2;
        contractOwner1 = _contractOwner3;
        addressMapping[_contractOwner1] = permissionnedAddress(_contractOwner1, true, true, 10000);
        addressMapping[_contractOwner1] = permissionnedAddress(_contractOwner2, true, true, 10000);
        addressMapping[_contractOwner1] = permissionnedAddress(_contractOwner3, true, true, 10000);
    }

    // ---- MODIFIERS ----

    modifier certificationNeeded{
        require( certificationByKVK == true,
        "Your company is not certified by the KVK anymore.");
        _;
    }

    modifier onlyKVK{
        require (msg.sender == kvkAddress,
        "Only the KVK can certify.");
        _;
    }

    modifier onlyAdmin{
        require (addressMapping[msg.sender].admin == true,
        "Only admins can run this function.");
        _;
    }

    modifier checkSpendingLimit (uint amount){
        require (addressMapping[msg.sender].spendingLimit > amount,
        "You are not authorized for transactions of this kind.");
        _;
    }


    // ---- FUNCTIONS ----

    // -- PAYABLE FALLBACK FUNCTION --

    function() external payable {
    }
    // -- KVK FUNCTIONS --

    //Let the KVK confirm/reject the certificateion

    function editCertificate (bool _validation) public onlyKVK{
        certificationByKVK = _validation;
        emit CompanyCertificationStatus(address(this), _validation);
    }

    // -- ADMIN FUNCTIONS --

    //Add new persons
    function addPermissionedPersons (address _newPerson, bool _admin, uint _spendingLimit) public onlyAdmin{
        addressMapping[_newPerson] = permissionnedAddress(_newPerson, true, _admin, _spendingLimit);
    }

    //Activate or deactivate users
    function changeActivationStatus (address _address, bool _status) public onlyAdmin{
        addressMapping[_address].active = _status;
    }

    //Change the spending limit
    function changeSpendingLimit (address _address, uint _limit) public onlyAdmin{
        addressMapping[_address].spendingLimit = _limit;
    }

    // -- USER FUNCTIONS --

    // Get user rights

    function getAddressInfo(address _address) public view returns(address, bool, bool, uint){
        permissionnedAddress storage addressInfo = addressMapping[_address];
        return(_address, addressInfo.active, addressInfo.admin, addressInfo.spendingLimit);
    }

    // Get company balance

    function getCompanyInformation() public view returns(address companyAddress, uint kvkNumber, uint balance){
        return(address(this), KVKnumber, address(this).balance);
    }

    // Send funds as purchase

    function makePurchasePayment(address payable receiverAddress, uint paymentAmount) public {
        receiverAddress.transfer(paymentAmount);
    }

    // Send funds as sales

    function makeSalesPayment(address payable receiverAddress, uint paymentAmount) public {
        receiverAddress.transfer(paymentAmount);
    }

}