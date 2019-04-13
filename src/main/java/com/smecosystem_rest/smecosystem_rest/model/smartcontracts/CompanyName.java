package com.smecosystem_rest.smecosystem_rest.model.smartcontracts;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tuples.generated.Tuple4;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.2.0.
 */
public class CompanyName extends Contract {
    private static final String BINARY = "60806040526001600360146101000a81548160ff021916908315150217905550600060065534801561003057600080fd5b5060405160a080611453833981018060405260a081101561005057600080fd5b810190808051906020019092919080519060200190929190805190602001909291908051906020019092919080519060200190929190505050336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508160048190555080600560006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555084600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555083600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555082600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060405180608001604052808673ffffffffffffffffffffffffffffffffffffffff168152602001600115158152602001600115158152602001612710815250600760008773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060208201518160000160146101000a81548160ff02191690831515021790555060408201518160000160156101000a81548160ff0219169083151502179055506060820151816001015590505060405180608001604052808573ffffffffffffffffffffffffffffffffffffffff168152602001600115158152602001600115158152602001612710815250600760008773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060208201518160000160146101000a81548160ff02191690831515021790555060408201518160000160156101000a81548160ff0219169083151502179055506060820151816001015590505060405180608001604052808473ffffffffffffffffffffffffffffffffffffffff168152602001600115158152602001600115158152602001612710815250600760008773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060208201518160000160146101000a81548160ff02191690831515021790555060408201518160000160156101000a81548160ff021916908315150217905550606082015181600101559050505050505050610f358061051e6000396000f3fe60806040526004361061007b5760003560e01c8063440a20841161004e578063440a2084146101d9578063aa8513eb1461023e578063ebb0079614610299578063f2f706da146103475761007b565b80630ceae1711461007d578063152828b3146100e457806318c4baae146101415780633794f0b21461017e575b005b34801561008957600080fd5b506100e2600480360360608110156100a057600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803515159060200190929190803590602001909291905050506103a2565b005b3480156100f057600080fd5b5061013f6004803603604081101561010757600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803515159060200190929190505050610562565b005b34801561014d57600080fd5b5061017c6004803603602081101561016457600080fd5b8101908080351515906020019092919050505061066c565b005b34801561018a57600080fd5b506101d7600480360360408110156101a157600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291908035906020019092919050505061079d565b005b3480156101e557600080fd5b506101ee610a29565b604051808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001838152602001828152602001935050505060405180910390f35b34801561024a57600080fd5b506102976004803603604081101561026157600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050610a58565b005b3480156102a557600080fd5b506102e8600480360360208110156102bc57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610ce4565b604051808573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001841515151581526020018315151515815260200182815260200194505050505060405180910390f35b34801561035357600080fd5b506103a06004803603604081101561036a57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050610d67565b005b60011515600760003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000160159054906101000a900460ff1615151461044e576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401808060200182810382526022815260200180610ec26022913960400191505060405180910390fd5b60405180608001604052808473ffffffffffffffffffffffffffffffffffffffff168152602001600115158152602001831515815260200182815250600760008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060208201518160000160146101000a81548160ff02191690831515021790555060408201518160000160156101000a81548160ff02191690831515021790555060608201518160010155905050505050565b60011515600760003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000160159054906101000a900460ff1615151461060e576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401808060200182810382526022815260200180610ec26022913960400191505060405180910390fd5b80600760008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000160146101000a81548160ff0219169083151502179055505050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161461072e576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f4f6e6c7920746865204b564b2063616e20636572746966792e0000000000000081525060200191505060405180910390fd5b80600360146101000a81548160ff0219169083151502179055503073ffffffffffffffffffffffffffffffffffffffff167f751e4b584aa64165dc1e5b1398b27060da47d6e51ec2b2cc8ab1031d73f4511c82604051808215151515815260200191505060405180910390a250565b8080600760003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206001015411610838576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401808060200182810382526035815260200180610e8d6035913960400191505060405180910390fd5b60011515600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16634674c93e336040518263ffffffff1660e01b8152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060206040518083038186803b1580156108db57600080fd5b505afa1580156108ef573d6000803e3d6000fd5b505050506040513d602081101561090557600080fd5b810190808051906020019092919050505015151461096e576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252602e815260200180610e5f602e913960400191505060405180910390fd5b813073ffffffffffffffffffffffffffffffffffffffff1631116109dd576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401808060200182810382526026815260200180610ee46026913960400191505060405180910390fd5b8273ffffffffffffffffffffffffffffffffffffffff166108fc839081150290604051600060405180830381858888f19350505050158015610a23573d6000803e3d6000fd5b50505050565b6000806000306004543073ffffffffffffffffffffffffffffffffffffffff1631829250925092509250909192565b8080600760003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206001015411610af3576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401808060200182810382526035815260200180610e8d6035913960400191505060405180910390fd5b60011515600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663c2aa4fea336040518263ffffffff1660e01b8152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060206040518083038186803b158015610b9657600080fd5b505afa158015610baa573d6000803e3d6000fd5b505050506040513d6020811015610bc057600080fd5b8101908080519060200190929190505050151514610c29576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252602e815260200180610e5f602e913960400191505060405180910390fd5b813073ffffffffffffffffffffffffffffffffffffffff163111610c98576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401808060200182810382526026815260200180610ee46026913960400191505060405180910390fd5b8273ffffffffffffffffffffffffffffffffffffffff166108fc839081150290604051600060405180830381858888f19350505050158015610cde573d6000803e3d6000fd5b50505050565b6000806000806000600760008773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000209050858160000160149054906101000a900460ff168260000160159054906101000a900460ff1683600101549450945094509450509193509193565b60011515600760003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000160159054906101000a900460ff16151514610e13576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401808060200182810382526022815260200180610ec26022913960400191505060405180910390fd5b80600760008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060010181905550505056fe596f7520617265206e6f7420617574686f72697a656420666f722073616c6573207472616e73616374696f6e732e596f7520617265206e6f7420617574686f72697a656420666f72207472616e73616374696f6e73206f662074686973206b696e642e4f6e6c792061646d696e732063616e2072756e20746869732066756e6374696f6e2e54686520636f6d70616e7920646f6573206e6f74206f776e20656e6f7567682066756e64732ea165627a7a72305820c3c1790f22d04f0bf88e723a5a0f987750b162e4fafb3b98b7e5e8e50ccc69f10029";

    public static final String FUNC_ADDPERMISSIONEDPERSONS = "addPermissionedPersons";

    public static final String FUNC_CHANGEACTIVATIONSTATUS = "changeActivationStatus";

    public static final String FUNC_EDITCERTIFICATE = "editCertificate";

    public static final String FUNC_MAKESALESPAYMENT = "makeSalesPayment";

    public static final String FUNC_GETCOMPANYINFORMATION = "getCompanyInformation";

    public static final String FUNC_MAKEPURCHASEPAYMENT = "makePurchasePayment";

    public static final String FUNC_GETADDRESSINFO = "getAddressInfo";

    public static final String FUNC_CHANGESPENDINGLIMIT = "changeSpendingLimit";

    public static final Event COMPANYCERTIFICATIONSTATUS_EVENT = new Event("CompanyCertificationStatus", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Bool>() {}));
    ;

    @Deprecated
    protected CompanyName(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected CompanyName(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected CompanyName(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected CompanyName(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<TransactionReceipt> addPermissionedPersons(String _newPerson, Boolean _admin, BigInteger _spendingLimit) {
        final Function function = new Function(
                FUNC_ADDPERMISSIONEDPERSONS, 
                Arrays.<Type>asList(new Address(_newPerson),
                new Bool(_admin),
                new Uint256(_spendingLimit)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> changeActivationStatus(String _address, Boolean _status) {
        final Function function = new Function(
                FUNC_CHANGEACTIVATIONSTATUS, 
                Arrays.<Type>asList(new Address(_address),
                new Bool(_status)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> editCertificate(Boolean _validation) {
        final Function function = new Function(
                FUNC_EDITCERTIFICATE, 
                Arrays.<Type>asList(new Bool(_validation)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> makeSalesPayment(String receiverAddress, BigInteger paymentAmount) {
        final Function function = new Function(
                FUNC_MAKESALESPAYMENT, 
                Arrays.<Type>asList(new Address(receiverAddress),
                new Uint256(paymentAmount)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Tuple3<String, BigInteger, BigInteger>> getCompanyInformation() {
        final Function function = new Function(FUNC_GETCOMPANYINFORMATION, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple3<String, BigInteger, BigInteger>>(
                new Callable<Tuple3<String, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple3<String, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<String, BigInteger, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> makePurchasePayment(String receiverAddress, BigInteger paymentAmount) {
        final Function function = new Function(
                FUNC_MAKEPURCHASEPAYMENT, 
                Arrays.<Type>asList(new Address(receiverAddress),
                new Uint256(paymentAmount)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Tuple4<String, Boolean, Boolean, BigInteger>> getAddressInfo(String _address) {
        final Function function = new Function(FUNC_GETADDRESSINFO, 
                Arrays.<Type>asList(new Address(_address)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bool>() {}, new TypeReference<Bool>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple4<String, Boolean, Boolean, BigInteger>>(
                new Callable<Tuple4<String, Boolean, Boolean, BigInteger>>() {
                    @Override
                    public Tuple4<String, Boolean, Boolean, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple4<String, Boolean, Boolean, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (Boolean) results.get(1).getValue(), 
                                (Boolean) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> changeSpendingLimit(String _address, BigInteger _limit) {
        final Function function = new Function(
                FUNC_CHANGESPENDINGLIMIT, 
                Arrays.<Type>asList(new Address(_address),
                new Uint256(_limit)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public List<CompanyCertificationStatusEventResponse> getCompanyCertificationStatusEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(COMPANYCERTIFICATIONSTATUS_EVENT, transactionReceipt);
        ArrayList<CompanyCertificationStatusEventResponse> responses = new ArrayList<CompanyCertificationStatusEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            CompanyCertificationStatusEventResponse typedResponse = new CompanyCertificationStatusEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.company = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.status = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<CompanyCertificationStatusEventResponse> companyCertificationStatusEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, CompanyCertificationStatusEventResponse>() {
            @Override
            public CompanyCertificationStatusEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(COMPANYCERTIFICATIONSTATUS_EVENT, log);
                CompanyCertificationStatusEventResponse typedResponse = new CompanyCertificationStatusEventResponse();
                typedResponse.log = log;
                typedResponse.company = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.status = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<CompanyCertificationStatusEventResponse> companyCertificationStatusEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(COMPANYCERTIFICATIONSTATUS_EVENT));
        return companyCertificationStatusEventFlowable(filter);
    }

    @Deprecated
    public static CompanyName load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new CompanyName(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static CompanyName load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new CompanyName(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static CompanyName load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new CompanyName(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static CompanyName load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new CompanyName(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<CompanyName> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _contractOwner1, String _contractOwner2, String _contractOwner3, BigInteger _KVKnumber, String _listContract) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(_contractOwner1),
                new Address(_contractOwner2),
                new Address(_contractOwner3),
                new Uint256(_KVKnumber),
                new Address(_listContract)));
        return deployRemoteCall(CompanyName.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<CompanyName> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _contractOwner1, String _contractOwner2, String _contractOwner3, BigInteger _KVKnumber, String _listContract) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(_contractOwner1),
                new Address(_contractOwner2),
                new Address(_contractOwner3),
                new Uint256(_KVKnumber),
                new Address(_listContract)));
        return deployRemoteCall(CompanyName.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<CompanyName> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _contractOwner1, String _contractOwner2, String _contractOwner3, BigInteger _KVKnumber, String _listContract) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(_contractOwner1),
                new Address(_contractOwner2),
                new Address(_contractOwner3),
                new Uint256(_KVKnumber),
                new Address(_listContract)));
        return deployRemoteCall(CompanyName.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<CompanyName> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _contractOwner1, String _contractOwner2, String _contractOwner3, BigInteger _KVKnumber, String _listContract) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(_contractOwner1),
                new Address(_contractOwner2),
                new Address(_contractOwner3),
                new Uint256(_KVKnumber),
                new Address(_listContract)));
        return deployRemoteCall(CompanyName.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class CompanyCertificationStatusEventResponse {
        public Log log;

        public String company;

        public Boolean status;
    }
}
