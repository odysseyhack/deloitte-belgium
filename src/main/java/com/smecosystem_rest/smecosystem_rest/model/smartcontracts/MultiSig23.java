package com.smecosystem_rest.smecosystem_rest.model.smartcontracts;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
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
public class MultiSig23 extends Contract {
    private static final String BINARY = "6080604052600060015560028055600060035534801561001e57600080fd5b506040516060806113b883398101806040528101908080519060200190929190805190602001909291908051906020019092919050505060008090508073ffffffffffffffffffffffffffffffffffffffff168473ffffffffffffffffffffffffffffffffffffffff16141515156100fe576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260018152602001807f310000000000000000000000000000000000000000000000000000000000000081525060200191505060405180910390fd5b8073ffffffffffffffffffffffffffffffffffffffff168373ffffffffffffffffffffffffffffffffffffffff16141515156101a2576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260018152602001807f310000000000000000000000000000000000000000000000000000000000000081525060200191505060405180910390fd5b8073ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff1614151515610246576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260018152602001807f310000000000000000000000000000000000000000000000000000000000000081525060200191505060405180910390fd5b8273ffffffffffffffffffffffffffffffffffffffff168473ffffffffffffffffffffffffffffffffffffffff16141515156102ea576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260018152602001807f310000000000000000000000000000000000000000000000000000000000000081525060200191505060405180910390fd5b8173ffffffffffffffffffffffffffffffffffffffff168373ffffffffffffffffffffffffffffffffffffffff161415151561038e576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260018152602001807f310000000000000000000000000000000000000000000000000000000000000081525060200191505060405180910390fd5b8173ffffffffffffffffffffffffffffffffffffffff168473ffffffffffffffffffffffffffffffffffffffff1614151515610432576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260018152602001807f310000000000000000000000000000000000000000000000000000000000000081525060200191505060405180910390fd5b60016000808673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff02191690831515021790555060016000808573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff02191690831515021790555060016000808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff02191690831515021790555050505050610e6e8061054a6000396000f30060806040526004361061006d576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806323eb861c146100bd578063843b1a09146100e8578063a7dd7a5914610113578063bb6d203c1461013e578063d0590bad146101dd575b7fc4c14883ae9fd8e26d5d59e3485ed29fd126d781d7e498a4ca5c54c8268e49363073ffffffffffffffffffffffffffffffffffffffff16316040518082815260200191505060405180910390a1005b3480156100c957600080fd5b506100d2610246565b6040518082815260200191505060405180910390f35b3480156100f457600080fd5b506100fd61024c565b6040518082815260200191505060405180910390f35b34801561011f57600080fd5b50610128610252565b6040518082815260200191505060405180910390f35b34801561014a57600080fd5b506101db600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190803560ff16906020019092919080356000191690602001909291908035600019169060200190929190803560ff16906020019092919080356000191690602001909291908035600019169060200190929190505050610258565b005b3480156101e957600080fd5b50610228600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050610432565b60405180826000191660001916815260200191505060405180910390f35b60025481565b60015481565b60035481565b863073ffffffffffffffffffffffffffffffffffffffff1631101515156102e7576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260018152602001807f330000000000000000000000000000000000000000000000000000000000000081525060200191505060405180910390fd5b6102f788888888888888886105f7565b151561036b576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260018152602001807f340000000000000000000000000000000000000000000000000000000000000081525060200191505060405180910390fd5b60018054016001819055508773ffffffffffffffffffffffffffffffffffffffff166108fc889081150290604051600060405180830381858888f193505050501580156103bc573d6000803e3d6000fd5b507fd3eec71143c45f28685b24760ea218d476917aa0ac0392a55e5304cef40bd2b68888604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019250505060405180910390a15050505050505050565b6000803073ffffffffffffffffffffffffffffffffffffffff168473ffffffffffffffffffffffffffffffffffffffff16141515156104d9576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260018152602001807f320000000000000000000000000000000000000000000000000000000000000081525060200191505060405180910390fd5b600154308486604051602001808581526020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166c010000000000000000000000000281526014018381526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166c010000000000000000000000000281526014019450505050506040516020818303038152906040526040518082805190602001908083835b6020831015156105be5780518252602082019150602081019050602083039250610599565b6001836020036101000a038019825116818451168082178552505050505050905001915050604051809103902090508091505092915050565b6000806000806106078c8c6107a6565b9250600183601b8c018b8b604051600081526020016040526040518085600019166000191681526020018460ff1660ff1681526020018360001916600019168152602001826000191660001916815260200194505050505060206040516020810390808403906000865af1158015610683573d6000803e3d6000fd5b505050602060405103519150600183601b89018888604051600081526020016040526040518085600019166000191681526020018460ff1660ff1681526020018360001916600019168152602001826000191660001916815260200194505050505060206040516020810390808403906000865af1158015610709573d6000803e3d6000fd5b50505060206040510351905061071f828261092a565b1515610793576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260018152602001807f350000000000000000000000000000000000000000000000000000000000000081525060200191505060405180910390fd5b6001935050505098975050505050505050565b6000806060806107b68686610432565b92506107c183610b5a565b91506040805190810160405280601c81526020017f19457468657265756d205369676e6564204d6573736167653a0a363400000000815250905080826040516020018083805190602001908083835b6020831015156108355780518252602082019150602081019050602083039250610810565b6001836020036101000a03801982511681845116808217855250505050505090500182805190602001908083835b6020831015156108885780518252602082019150602081019050602083039250610863565b6001836020036101000a038019825116818451168082178552505050505050905001925050506040516020818303038152906040526040518082805190602001908083835b6020831015156108f257805182526020820191506020810190506020830392506108cd565b6001836020036101000a0380198251168184511680821785525050505050509050019150506040518091039020935050505092915050565b60008173ffffffffffffffffffffffffffffffffffffffff168373ffffffffffffffffffffffffffffffffffffffff16141515156109d0576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260018152602001807f350000000000000000000000000000000000000000000000000000000000000081525060200191505060405180910390fd5b6000808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff161515610a90576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260018152602001807f350000000000000000000000000000000000000000000000000000000000000081525060200191505060405180910390fd5b6000808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff161515610b50576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260018152602001807f350000000000000000000000000000000000000000000000000000000000000081525060200191505060405180910390fd5b6001905092915050565b606080600080600080604080519080825280601f01601f191660200182016040528015610b965781602001602082028038833980820191505090505b509450600093505b6020841015610d45578684602081101515610bb557fe5b1a7f01000000000000000000000000000000000000000000000000000000000000000292506010837f0100000000000000000000000000000000000000000000000000000000000000900460ff16811515610c0c57fe5b047f0100000000000000000000000000000000000000000000000000000000000000029150817f01000000000000000000000000000000000000000000000000000000000000009004601002837f01000000000000000000000000000000000000000000000000000000000000009004037f0100000000000000000000000000000000000000000000000000000000000000029050610caa82610d52565b8585600202815181101515610cbb57fe5b9060200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a905350610cf481610d52565b8560018660020201815181101515610d0857fe5b9060200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a9053508380600101945050610b9e565b8495505050505050919050565b6000600a7f010000000000000000000000000000000000000000000000000000000000000002827effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff19161015610df1576030827f01000000000000000000000000000000000000000000000000000000000000009004017f0100000000000000000000000000000000000000000000000000000000000000029050610e3d565b6057827f01000000000000000000000000000000000000000000000000000000000000009004017f01000000000000000000000000000000000000000000000000000000000000000290505b9190505600a165627a7a72305820f8806aab6242a610155500013c077aab6b6962bd00a0fe779587e15b8e9541410029";

    public static final String FUNC_UNCHAINEDMULTISIGVERSIONMAJOR = "unchainedMultisigVersionMajor";

    public static final String FUNC_SPENDNONCE = "spendNonce";

    public static final String FUNC_UNCHAINEDMULTISIGVERSIONMINOR = "unchainedMultisigVersionMinor";

    public static final String FUNC_SPEND = "spend";

    public static final String FUNC_GENERATEMESSAGETOSIGN = "generateMessageToSign";

    public static final Event FUNDED_EVENT = new Event("Funded", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    public static final Event SPENT_EVENT = new Event("Spent", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected MultiSig23(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected MultiSig23(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected MultiSig23(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected MultiSig23(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<BigInteger> unchainedMultisigVersionMajor() {
        final Function function = new Function(FUNC_UNCHAINEDMULTISIGVERSIONMAJOR, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> spendNonce() {
        final Function function = new Function(FUNC_SPENDNONCE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> unchainedMultisigVersionMinor() {
        final Function function = new Function(FUNC_UNCHAINEDMULTISIGVERSIONMINOR, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> spend(String destination, BigInteger value, BigInteger v1, byte[] r1, byte[] s1, BigInteger v2, byte[] r2, byte[] s2) {
        final Function function = new Function(
                FUNC_SPEND, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(destination), 
                new org.web3j.abi.datatypes.generated.Uint256(value), 
                new org.web3j.abi.datatypes.generated.Uint8(v1), 
                new org.web3j.abi.datatypes.generated.Bytes32(r1), 
                new org.web3j.abi.datatypes.generated.Bytes32(s1), 
                new org.web3j.abi.datatypes.generated.Uint8(v2), 
                new org.web3j.abi.datatypes.generated.Bytes32(r2), 
                new org.web3j.abi.datatypes.generated.Bytes32(s2)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<byte[]> generateMessageToSign(String destination, BigInteger value) {
        final Function function = new Function(FUNC_GENERATEMESSAGETOSIGN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(destination), 
                new org.web3j.abi.datatypes.generated.Uint256(value)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public List<FundedEventResponse> getFundedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(FUNDED_EVENT, transactionReceipt);
        ArrayList<FundedEventResponse> responses = new ArrayList<FundedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            FundedEventResponse typedResponse = new FundedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.newBalance = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<FundedEventResponse> fundedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, FundedEventResponse>() {
            @Override
            public FundedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(FUNDED_EVENT, log);
                FundedEventResponse typedResponse = new FundedEventResponse();
                typedResponse.log = log;
                typedResponse.newBalance = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<FundedEventResponse> fundedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(FUNDED_EVENT));
        return fundedEventFlowable(filter);
    }

    public List<SpentEventResponse> getSpentEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(SPENT_EVENT, transactionReceipt);
        ArrayList<SpentEventResponse> responses = new ArrayList<SpentEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            SpentEventResponse typedResponse = new SpentEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.to = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.transfer = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<SpentEventResponse> spentEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, SpentEventResponse>() {
            @Override
            public SpentEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(SPENT_EVENT, log);
                SpentEventResponse typedResponse = new SpentEventResponse();
                typedResponse.log = log;
                typedResponse.to = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.transfer = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<SpentEventResponse> spentEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(SPENT_EVENT));
        return spentEventFlowable(filter);
    }

    @Deprecated
    public static MultiSig23 load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new MultiSig23(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static MultiSig23 load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new MultiSig23(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static MultiSig23 load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new MultiSig23(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static MultiSig23 load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new MultiSig23(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<MultiSig23> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String owner1, String owner2, String owner3) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(owner1), 
                new org.web3j.abi.datatypes.Address(owner2), 
                new org.web3j.abi.datatypes.Address(owner3)));
        return deployRemoteCall(MultiSig23.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<MultiSig23> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String owner1, String owner2, String owner3) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(owner1), 
                new org.web3j.abi.datatypes.Address(owner2), 
                new org.web3j.abi.datatypes.Address(owner3)));
        return deployRemoteCall(MultiSig23.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<MultiSig23> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String owner1, String owner2, String owner3) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(owner1), 
                new org.web3j.abi.datatypes.Address(owner2), 
                new org.web3j.abi.datatypes.Address(owner3)));
        return deployRemoteCall(MultiSig23.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<MultiSig23> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String owner1, String owner2, String owner3) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(owner1), 
                new org.web3j.abi.datatypes.Address(owner2), 
                new org.web3j.abi.datatypes.Address(owner3)));
        return deployRemoteCall(MultiSig23.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class FundedEventResponse {
        public Log log;

        public BigInteger newBalance;
    }

    public static class SpentEventResponse {
        public Log log;

        public String to;

        public BigInteger transfer;
    }
}