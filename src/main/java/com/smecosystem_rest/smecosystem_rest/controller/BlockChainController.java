package com.smecosystem_rest.smecosystem_rest.controller;


import com.smecosystem_rest.smecosystem_rest.exception.ResourceNotFoundException;
import com.smecosystem_rest.smecosystem_rest.model.smartcontracts.DefaultContractGasProvider;
import com.smecosystem_rest.smecosystem_rest.model.smartcontracts.HelloWorld;
import com.smecosystem_rest.smecosystem_rest.model.smartcontracts.MultiSig23;
import com.smecosystem_rest.smecosystem_rest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/blockchainRestService")
public class BlockChainController {

    @Autowired
    private UserService userService;

    private final String DEFAULT_ADDRESS = "http://127.0.0.1:7545";

    private final Web3j web3j = Web3j.build(new HttpService(DEFAULT_ADDRESS));

    @GetMapping("/getCurrentBlock")
    public ResponseEntity<EthBlockNumber> getCurrentBlock() throws ResourceNotFoundException {
        EthBlockNumber result;
        try {
            result = this.web3j.ethBlockNumber()
                    .sendAsync()
                    .get();
            return ResponseEntity.ok().body(result);
        } catch (InterruptedException | ExecutionException e) {
            throw new ResourceNotFoundException("Current block could not be found at the moment, try later");
        }
    }

    @GetMapping("/getAccounts")
    public ResponseEntity<List<String>> getAccounts() throws IOException {
        List<String> accountList = this.web3j.ethAccounts().send().getAccounts();
        return ResponseEntity.ok().body(accountList);
    }

    @GetMapping("/getBalanceByAddress/{address}")
    public ResponseEntity<EthGetBalance> getBalanceByAddress(@PathVariable(value = "address") String address) throws ResourceNotFoundException {
        EthGetBalance result;
        try {
            result = web3j.ethGetBalance(address,
                    DefaultBlockParameter.valueOf("latest"))
                    .sendAsync()
                    .get();
            return ResponseEntity.ok().body(result);
        } catch (InterruptedException | ExecutionException e) {
            throw new ResourceNotFoundException("Current block could not be found at the moment, try later");
        }
    }

    @GetMapping("/transferEther/{password}/{userId}/{targetAddress}/{amount}")
    public void transferEther(@PathVariable(value = "password") String password,
                                                @PathVariable(value = "userId") Long userId,
                                                @PathVariable(value = "targetAddress") String targetAddress,
                                                @PathVariable(value = "amount") Long amount) throws CipherException, IOException {
        Credentials cred = this.userService.getCredentials(password, userId);
        try {
            TransactionReceipt transactionReceipt = Transfer.sendFunds(web3j, cred, targetAddress, BigDecimal.valueOf(amount), Convert.Unit.ETHER).send();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/deployHelloWorldContract/{password}/{userId}")
    public ResponseEntity<String> deployHelloWorldContract(@PathVariable(value = "password") String password,
                                                @PathVariable(value = "userId") Long userId) throws Exception {
        Credentials cred = this.userService.getCredentials(password, userId);
        HelloWorld contract = HelloWorld.deploy(web3j, cred, new DefaultContractGasProvider()).send();
        return ResponseEntity.ok().body("The contract address is: " +contract.getContractAddress());
    }

    @GetMapping("/deployMultiSigContract/{password}/{userId}")
    public ResponseEntity<String> deployMultiSigContract(@PathVariable(value = "password") String password,
                                                @PathVariable(value = "userId") Long userId) throws Exception {
        Credentials cred = this.userService.getCredentials(password, userId);
        MultiSig23 contract = MultiSig23.deploy(web3j, cred, new DefaultContractGasProvider(),"0x2499316Ba3F9fbB9f52EdeEbF4eD998f625Fa44a","0xdFEC90a1C280dEcc45FEAF1994cff6E0d4F8772e","0x7190e7eCBdeA76CEA608C616E21cbEEbc71A7C6a").send();
        return ResponseEntity.ok().body("The contract address is: " +contract.getContractAddress());
    }


    @GetMapping("/deployKVKList/{password}/{userId}")
    public ResponseEntity<String> deployKVKList(@PathVariable(value = "password") String password,
                                                @PathVariable(value = "userId") Long userId) throws Exception {
        Credentials cred = this.userService.getCredentials(password, userId);
        return null;
    }
}
