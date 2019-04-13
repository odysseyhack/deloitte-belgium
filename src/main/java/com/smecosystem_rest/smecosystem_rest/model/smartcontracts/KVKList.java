package com.smecosystem_rest.smecosystem_rest.model.smartcontracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
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
public class KVKList extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b506040516109dd3803806109dd8339810180604052602081101561003357600080fd5b81019080805164010000000081111561004b57600080fd5b8281019050602081018481111561006157600080fd5b815185600182028301116401000000008211171561007e57600080fd5b5050929190505050336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555080600190805190602001906100dc9291906100e3565b5050610188565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061012457805160ff1916838001178555610152565b82800160010185558215610152579182015b82811115610151578251825591602001919060010190610136565b5b50905061015f9190610163565b5090565b61018591905b80821115610181576000816000905550600101610169565b5090565b90565b610846806101976000396000f3fe608060405234801561001057600080fd5b50600436106100885760003560e01c80639751d0c71161005b5780639751d0c7146101cd578063c2aa4fea14610229578063e30456b014610285578063f5deb07e146102c957610088565b8063103ea4411461008d578063132c66e7146100d15780634674c93e1461011557806360d13df214610171575b600080fd5b6100cf600480360360208110156100a357600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061030d565b005b610113600480360360208110156100e757600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061040d565b005b6101576004803603602081101561012b57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061050d565b604051808215151515815260200191505060405180910390f35b6101b36004803603602081101561018757600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610563565b604051808215151515815260200191505060405180910390f35b61020f600480360360208110156101e357600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610583565b604051808215151515815260200191505060405180910390f35b61026b6004803603602081101561023f57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506105a3565b604051808215151515815260200191505060405180910390f35b6102c76004803603602081101561029b57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506105f9565b005b61030b600480360360208110156102df57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506106f9565b005b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16146103b2576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260218152602001806107fa6021913960400191505060405180910390fd5b6001600360008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff02191690831515021790555050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16146104b2576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260218152602001806107fa6021913960400191505060405180910390fd5b6001600260008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff02191690831515021790555050565b6000600360008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff169050919050565b60036020528060005260406000206000915054906101000a900460ff1681565b60026020528060005260406000206000915054906101000a900460ff1681565b6000600260008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff169050919050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161461069e576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260218152602001806107fa6021913960400191505060405180910390fd5b6000600360008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff02191690831515021790555050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161461079e576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260218152602001806107fa6021913960400191505060405180910390fd5b6000600260008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff0219169083151502179055505056fe4f6e6c79204b564b2063616e20706572666f726d207468697320616374696f6e2ea165627a7a723058201003e2e8307bd34e213740663f9b5b36cd427671ebd3ccb264395de616a48efd0029";

    public static final String FUNC_GRANTACCESSSALES = "grantAccessSales";

    public static final String FUNC_GRANTACCESSPURCHASES = "grantAccessPurchases";

    public static final String FUNC_ISAUTHORIZEDFORSALES = "isAuthorizedForSales";

    public static final String FUNC_SALESPERMISSIONS = "salesPermissions";

    public static final String FUNC_PURCHASEPERMISSIONS = "purchasePermissions";

    public static final String FUNC_ISAUTHORIZEDFORPURCHASES = "isAuthorizedForPurchases";

    public static final String FUNC_REMOVEACCESSSALES = "removeAccessSales";

    public static final String FUNC_REMOVEACCESSPURCHASES = "removeAccessPurchases";

    @Deprecated
    protected KVKList(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected KVKList(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected KVKList(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected KVKList(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<TransactionReceipt> grantAccessSales(String _publicKey) {
        final Function function = new Function(
                FUNC_GRANTACCESSSALES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_publicKey)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> grantAccessPurchases(String _publicKey) {
        final Function function = new Function(
                FUNC_GRANTACCESSPURCHASES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_publicKey)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Boolean> isAuthorizedForSales(String _publicKey) {
        final Function function = new Function(FUNC_ISAUTHORIZEDFORSALES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_publicKey)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<Boolean> salesPermissions(String param0) {
        final Function function = new Function(FUNC_SALESPERMISSIONS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<Boolean> purchasePermissions(String param0) {
        final Function function = new Function(FUNC_PURCHASEPERMISSIONS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<Boolean> isAuthorizedForPurchases(String _publicKey) {
        final Function function = new Function(FUNC_ISAUTHORIZEDFORPURCHASES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_publicKey)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> removeAccessSales(String _publicKey) {
        final Function function = new Function(
                FUNC_REMOVEACCESSSALES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_publicKey)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> removeAccessPurchases(String _publicKey) {
        final Function function = new Function(
                FUNC_REMOVEACCESSPURCHASES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_publicKey)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static KVKList load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new KVKList(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static KVKList load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new KVKList(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static KVKList load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new KVKList(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static KVKList load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new KVKList(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<KVKList> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _kvkNumber) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_kvkNumber)));
        return deployRemoteCall(KVKList.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<KVKList> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _kvkNumber) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_kvkNumber)));
        return deployRemoteCall(KVKList.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<KVKList> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _kvkNumber) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_kvkNumber)));
        return deployRemoteCall(KVKList.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<KVKList> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _kvkNumber) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_kvkNumber)));
        return deployRemoteCall(KVKList.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
