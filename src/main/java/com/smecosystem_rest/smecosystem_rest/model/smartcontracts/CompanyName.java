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
    private static final String BINARY = "608060405260038054600160a01b60ff02191674010000000000000000000000000000000000000000179055600060065534801561003c57600080fd5b5060405160a0806109a7833981018060405260a081101561005c57600080fd5b810190808051906020019092919080519060200190929190805190602001909291908051906020019092919080519060200190929190505050336000806101000a8154816001600160a01b0302191690836001600160a01b031602179055508160048190555080600560006101000a8154816001600160a01b0302191690836001600160a01b0316021790555084600160006101000a8154816001600160a01b0302191690836001600160a01b0316021790555083600160006101000a8154816001600160a01b0302191690836001600160a01b0316021790555082600160006101000a8154816001600160a01b0302191690836001600160a01b031602179055506040518060800160405280866001600160a01b0316815260200160011515815260200160011515815260200161271081525060076000876001600160a01b03166001600160a01b0316815260200190815260200160002060008201518160000160006101000a8154816001600160a01b0302191690836001600160a01b0316021790555060208201518160000160146101000a81548160ff02191690831515021790555060408201518160000160156101000a81548160ff021916908315150217905550606082015181600101559050506040518060800160405280856001600160a01b0316815260200160011515815260200160011515815260200161271081525060076000876001600160a01b03166001600160a01b0316815260200190815260200160002060008201518160000160006101000a8154816001600160a01b0302191690836001600160a01b0316021790555060208201518160000160146101000a81548160ff02191690831515021790555060408201518160000160156101000a81548160ff021916908315150217905550606082015181600101559050506040518060800160405280846001600160a01b0316815260200160011515815260200160011515815260200161271081525060076000876001600160a01b03166001600160a01b0316815260200190815260200160002060008201518160000160006101000a8154816001600160a01b0302191690836001600160a01b0316021790555060208201518160000160146101000a81548160ff02191690831515021790555060408201518160000160156101000a81548160ff0219169083151502179055506060820151816001015590505050505050506105c2806103e56000396000f3fe60806040526004361061007b5760003560e01c8063440a20841161004e578063440a20841461015e578063aa8513eb14610125578063ebb007961461019b578063f2f706da146101fe5761007b565b80630ceae1711461007d578063152828b3146100be57806318c4baae146100f95780633794f0b214610125575b005b34801561008957600080fd5b5061007b600480360360608110156100a057600080fd5b506001600160a01b0381351690602081013515159060400135610237565b3480156100ca57600080fd5b5061007b600480360360408110156100e157600080fd5b506001600160a01b0381351690602001351515610328565b34801561010557600080fd5b5061007b6004803603602081101561011c57600080fd5b503515156103bd565b34801561013157600080fd5b5061007b6004803603604081101561014857600080fd5b506001600160a01b038135169060200135610478565b34801561016a57600080fd5b506101736104b3565b604080516001600160a01b039094168452602084019290925282820152519081900360600190f35b3480156101a757600080fd5b506101ce600480360360208110156101be57600080fd5b50356001600160a01b03166104bd565b604080516001600160a01b0390951685529215156020850152901515838301526060830152519081900360800190f35b34801561020a57600080fd5b5061007b6004803603604081101561022157600080fd5b506001600160a01b0381351690602001356104f8565b33600090815260076020526040902054600160a81b900460ff16151560011461029457604051600160e51b62461bcd0281526004018080602001828103825260228152602001806105756022913960400191505060405180910390fd5b604080516080810182526001600160a01b039485168082526001602080840182815296151584860190815260608501968752600093845260079091529390912091518254955193511515600160a81b02600160a81b60ff0219941515600160a01b02600160a01b60ff0219929098166001600160a01b03199097169690961716959095179190911692909217825551910155565b33600090815260076020526040902054600160a81b900460ff16151560011461038557604051600160e51b62461bcd0281526004018080602001828103825260228152602001806105756022913960400191505060405180910390fd5b6001600160a01b0390911660009081526007602052604090208054911515600160a01b02600160a01b60ff0219909216919091179055565b6000546001600160a01b0316331461041f5760408051600160e51b62461bcd02815260206004820152601960248201527f4f6e6c7920746865204b564b2063616e20636572746966792e00000000000000604482015290519081900360640190fd5b60038054821515600160a01b8102600160a01b60ff021990921691909117909155604080519182525130917f751e4b584aa64165dc1e5b1398b27060da47d6e51ec2b2cc8ab1031d73f4511c919081900360200190a250565b6040516001600160a01b0383169082156108fc029083906000818181858888f193505050501580156104ae573d6000803e3d6000fd5b505050565b6004543091823190565b6001600160a01b03811660009081526007602052604090208054600190910154919260ff600160a01b8304811693600160a81b909304169190565b33600090815260076020526040902054600160a81b900460ff16151560011461055557604051600160e51b62461bcd0281526004018080602001828103825260228152602001806105756022913960400191505060405180910390fd5b6001600160a01b0390911660009081526007602052604090206001015556fe4f6e6c792061646d696e732063616e2072756e20746869732066756e6374696f6e2ea165627a7a7230582046c262e76e4a15db8cbaaca6d9a7cf67964b82d8997fde78a34767e8878f633f0029";

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
