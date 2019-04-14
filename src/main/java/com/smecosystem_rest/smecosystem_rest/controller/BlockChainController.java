package com.smecosystem_rest.smecosystem_rest.controller;


import com.smecosystem_rest.smecosystem_rest.exception.ResourceNotFoundException;
import com.smecosystem_rest.smecosystem_rest.model.Company;
import com.smecosystem_rest.smecosystem_rest.model.smartcontracts.*;
import com.smecosystem_rest.smecosystem_rest.repositories.CompanyRepositoryImpl;
import com.smecosystem_rest.smecosystem_rest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tuples.generated.Tuple4;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/blockchainRestService")
public class BlockChainController {

    @Autowired
    private UserService userService;

    @Autowired
    private CompanyRepositoryImpl companyRepository;

    private final String DEFAULT_ADDRESS = "http://127.0.0.1:9545";

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


    @GetMapping("/deployCompanySmartWallet/{password}/{userId}")
    public ResponseEntity<String> deployCompanySmartWallet(@PathVariable(value = "password") String password,
                                                @PathVariable(value = "userId") Long userId) throws Exception {
        Optional<Company> company = companyRepository.findById(5l);
        if(company.isPresent()) {
            Credentials credentials = this.userService.getCredentials(password, userId);
            Company foundCompany = company.get();

            KVKList kvkContract = KVKList.deploy(web3j, credentials, new DefaultContractGasProvider(), foundCompany.getKvkNummer()).send();
            
            
            CompanyName multiSigWallet = CompanyName.deploy(web3j,credentials, new DefaultContractGasProvider(), "0x41857224b19186d27b8aa71b31ca19ca055ee572", "0xe2b29592bc6a24fd69db0207fe2ee3c6b652d735", "0x6aa372365e02f2bdde203be983e3affe48ed3ef6", BigInteger.valueOf(123456789), kvkContract.getContractAddress()).send();

            foundCompany.setKvkListAddress(kvkContract.getContractAddress());
            foundCompany.setWalletAddress(multiSigWallet.getContractAddress());
            boolean kvkValid = kvkContract.isValid();
            companyRepository.save(foundCompany);
            return ResponseEntity.ok().body("The contract address is: " + multiSigWallet.getContractAddress());
        } else {
            throw new IllegalAccessException("Company not found in the database");
        }
    }

    @GetMapping("/addPermissions")
    public ResponseEntity<String> addPermissions() throws Exception {
        Optional<Company> company = companyRepository.findById(5l);
        if(company.isPresent()) {
            Credentials credentials = this.userService.getCredentials("password", 1l);
            Company foundCompany = company.get();
            KVKList contract = KVKList.load(company.get().getKvkListAddress(), web3j, credentials, new DefaultContractGasProvider());
            contract.grantAccessPurchases("0x1abe1dc73dfc3dc085f66a8dcf73b9e1617a34e0").send();
            contract.grantAccessSales("0x1abe1dc73dfc3dc085f66a8dcf73b9e1617a34e0").send();
            contract.grantAccessPurchases("0x9631a13eacb39884beb8414cc7f820ac504418da").send();
            contract.grantAccessSales("0x9631a13eacb39884beb8414cc7f820ac504418da").send();
            return ResponseEntity.ok().body("Permissions added");
        } else {
            throw new IllegalAccessException("Company not found in the database");
        }
    }

    @GetMapping("/viewPermissions")
    public ResponseEntity<String> viewPermissions() throws Exception {
        Optional<Company> company = companyRepository.findById(5l);
        if(company.isPresent()) {
            Credentials credentials = this.userService.getCredentials("password", 1l);
            Company foundCompany = company.get();
            KVKList contract = KVKList.load(company.get().getKvkListAddress(), web3j, credentials, new DefaultContractGasProvider());
            Boolean purches = contract.isAuthorizedForPurchases("0x41857224b19186d27b8aa71b31ca19ca055ee572").send();
            Boolean sales = contract.isAuthorizedForSales("0x41857224b19186d27b8aa71b31ca19ca055ee572").send();
            return ResponseEntity.ok().body("Permissions checked");
        } else {
            throw new IllegalAccessException("Company not found in the database");
        }
    }

    @GetMapping("/increaseLimit")
    public ResponseEntity<String> increaseLimit() throws Exception {
        Optional<Company> company = companyRepository.findById(5l);
        if(company.isPresent()) {
            Credentials credentials = this.userService.getCredentials("password", 1l);
            Company foundCompany = company.get();
            CompanyName contract = CompanyName.load(company.get().getWalletAddress(), web3j, credentials, new DefaultContractGasProvider());
            contract.changeSpendingLimit("0x41857224b19186d27b8aa71b31ca19ca055ee572", BigInteger.valueOf(1000000000000000000L)).send();
            return ResponseEntity.ok().body("Limit adjusted");
        } else {
            throw new IllegalAccessException("Company not found in the database");
        }
    }


    @GetMapping("/decreaseLimit")
    public ResponseEntity<String> decreaseLimit() throws Exception {
        Optional<Company> company = companyRepository.findById(5l);
        if(company.isPresent()) {
            Credentials credentials = this.userService.getCredentials("password", 1l);
            Company foundCompany = company.get();
            CompanyName contract = CompanyName.load(company.get().getWalletAddress(), web3j, credentials, new DefaultContractGasProvider());
            contract.changeSpendingLimit("0x41857224b19186d27b8aa71b31ca19ca055ee572", BigInteger.valueOf(1000L)).send();
            return ResponseEntity.ok().body("Limit adjusted");
        } else {
            throw new IllegalAccessException("Company not found in the database");
        }
    }

   @GetMapping("/transferFunds/{companyId}")
   public ResponseEntity<String> transferFundsFromCompanyWallet(@PathVariable(value = "companyId") Long companyId) throws Exception {
        Optional<Company> company = companyRepository.findById(5l);
        if(company.isPresent()) {
           Credentials credentials = this.userService.getCredentials("password", 1l);
            CompanyName contract = CompanyName.load(company.get().getWalletAddress(), web3j, credentials, new DefaultContractGasProvider());
            RemoteCall<Tuple3<String, BigInteger, BigInteger>> info = contract.getCompanyInformation();
            Tuple4<String, Boolean, Boolean, BigInteger> userInfo = contract.getAddressInfo("0x41857224b19186d27b8aa71b31ca19ca055ee572").send();
            BigInteger price = contract.requestCurrentGasPrice();
            TransactionReceipt transfer = contract.makePurchasePayment("0xDDF220D8740FE1f302Ede1d7B738CEaDe508EB1D", BigInteger.valueOf((long) 500000000)).send();
            contract.makePurchasePayment("0xDDF220D8740FE1f302Ede1d7B738CEaDe508EB1D", BigInteger.valueOf(1000000000000000000L)).send();
            return ResponseEntity.ok().body(transfer.getBlockNumber().toString());
        } else {
            throw new IllegalAccessException("Company not found in the database");
        }
    }
}
