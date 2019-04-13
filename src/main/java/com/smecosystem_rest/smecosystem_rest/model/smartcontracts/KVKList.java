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
    private static final String BINARY = "608060405234801561001057600080fd5b506040516105953803806105958339810180604052602081101561003357600080fd5b81019080805164010000000081111561004b57600080fd5b8201602081018481111561005e57600080fd5b815164010000000081118282018710171561007857600080fd5b5050600080546001600160a01b0319163317905580519093506100a492506001915060208401906100ab565b5050610146565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106100ec57805160ff1916838001178555610119565b82800160010185558215610119579182015b828111156101195782518255916020019190600101906100fe565b50610125929150610129565b5090565b61014391905b80821115610125576000815560010161012f565b90565b610440806101556000396000f3fe608060405234801561001057600080fd5b50600436106100885760003560e01c80639751d0c71161005b5780639751d0c71461013b578063c2aa4fea14610161578063e30456b014610187578063f5deb07e146101ad57610088565b8063103ea4411461008d578063132c66e7146100b55780634674c93e146100db57806360d13df214610115575b600080fd5b6100b3600480360360208110156100a357600080fd5b50356001600160a01b03166101d3565b005b6100b3600480360360208110156100cb57600080fd5b50356001600160a01b0316610243565b610101600480360360208110156100f157600080fd5b50356001600160a01b03166102b3565b604080519115158252519081900360200190f35b6101016004803603602081101561012b57600080fd5b50356001600160a01b03166102d1565b6101016004803603602081101561015157600080fd5b50356001600160a01b03166102e6565b6101016004803603602081101561017757600080fd5b50356001600160a01b03166102fb565b6100b36004803603602081101561019d57600080fd5b50356001600160a01b0316610319565b6100b3600480360360208110156101c357600080fd5b50356001600160a01b0316610386565b6000546001600160a01b0316331461021f57604051600160e51b62461bcd0281526004018080602001828103825260218152602001806103f46021913960400191505060405180910390fd5b6001600160a01b03166000908152600360205260409020805460ff19166001179055565b6000546001600160a01b0316331461028f57604051600160e51b62461bcd0281526004018080602001828103825260218152602001806103f46021913960400191505060405180910390fd5b6001600160a01b03166000908152600260205260409020805460ff19166001179055565b6001600160a01b031660009081526003602052604090205460ff1690565b60036020526000908152604090205460ff1681565b60026020526000908152604090205460ff1681565b6001600160a01b031660009081526002602052604090205460ff1690565b6000546001600160a01b0316331461036557604051600160e51b62461bcd0281526004018080602001828103825260218152602001806103f46021913960400191505060405180910390fd5b6001600160a01b03166000908152600360205260409020805460ff19169055565b6000546001600160a01b031633146103d257604051600160e51b62461bcd0281526004018080602001828103825260218152602001806103f46021913960400191505060405180910390fd5b6001600160a01b03166000908152600260205260409020805460ff1916905556fe4f6e6c79204b564b2063616e20706572666f726d207468697320616374696f6e2ea165627a7a72305820522930f789cd34a1da5634ef6b20a2d1eefcacdd2516b52e993c3ea693fff79a0029";

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
