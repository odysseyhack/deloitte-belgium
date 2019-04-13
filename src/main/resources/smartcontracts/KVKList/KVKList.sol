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