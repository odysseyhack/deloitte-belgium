package com.smecosystem_rest.smecosystem_rest.model.smartcontracts;

import org.web3j.tx.gas.ContractGasProvider;

import java.math.BigInteger;

public class DefaultContractGasProvider implements ContractGasProvider {
    @Override
    public BigInteger getGasPrice(String contractFunc) {
        return BigInteger.valueOf(22_000_000_000L);
    }

    @Override
    public BigInteger getGasPrice() {
        return BigInteger.valueOf(22_000_000_000L);
    }

    @Override
    public BigInteger getGasLimit(String contractFunc) {
        return BigInteger.valueOf(444_300_000);
    }

    @Override
    public BigInteger getGasLimit() {
        return BigInteger.valueOf(444_300_000);
    }
}
