package com.smecosystem_rest.smecosystem_rest.services;

import com.smecosystem_rest.smecosystem_rest.model.Company;
import com.smecosystem_rest.smecosystem_rest.model.User;
import com.smecosystem_rest.smecosystem_rest.repositories.CompanyRepositoryImpl;
import com.smecosystem_rest.smecosystem_rest.repositories.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;

import javax.persistence.NoResultException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepositoryImpl userRepository;

    @Autowired
    private CompanyRepositoryImpl companyRepository;

    public String getWalletAddressById(Long userId, String password) throws IOException, CipherException {
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()) {
            User foundUser = user.get();
            String walletAddress = foundUser.getWalletAddress();
            Credentials credentials = WalletUtils.loadCredentials(password, User.getWalletPath() + "/" + foundUser.getWalletAddress());
            return credentials.getAddress();
        }
        else {
            return "User or wallet not found, please create a wallet first";
        }
    }

    public com.smecosystem_rest.smecosystem_rest.model.transfer_objects.Credentials getCredentials(Long userId, String password) throws IOException, CipherException, IllegalAccessException {
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()) {
            User foundUser = user.get();
            String walletAddress = foundUser.getWalletAddress();
            Credentials credentials = WalletUtils.loadCredentials(password, User.getWalletPath() + "/" + foundUser.getWalletAddress());
            com.smecosystem_rest.smecosystem_rest.model.transfer_objects.Credentials creds = new com.smecosystem_rest.smecosystem_rest.model.transfer_objects.Credentials();
            creds.setAddress(credentials.getAddress());
            creds.setPrivateKey(credentials.getEcKeyPair().getPrivateKey().toString(16));
            creds.setPublicKey(credentials.getEcKeyPair().getPublicKey().toString(16));
            return creds;
        }
        else {
            throw new IllegalAccessException("User not found in the database");
        }
    }

    public Credentials getCredentials(String password, Long userId) throws IOException, CipherException {
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()) {
            User foundUser = user.get();
            String walletAddress = foundUser.getWalletAddress();
            return WalletUtils.loadCredentials(password, User.getWalletPath() + "/" + foundUser.getWalletAddress());
        }
        else {
            throw new NoResultException();
        }
    }

    public User login(String firstName, String password) throws IllegalAccessException {
        User user = userRepository.findByFirstName(firstName);
        if(user == null) {
            return null;
        } else {
            if(user.getPassword().equals(password)) {
                return user;
            } else {
                throw new IllegalAccessException("The wrong password was used");
            }
        }
    }

    public User createUser(User user) {

        return null;
    }

    public User addCompanyToUser(Long user_id, Long company_id) throws IllegalAccessException {
        Optional<User> user = this.userRepository.findById(user_id);
        Optional<Company> company = this.companyRepository.findById(company_id);
        if(user.isPresent() && company.isPresent()) {
            User foundUser = user.get();
            Company foundCompany = company.get();
            foundUser.setCompany(foundCompany);
            this.save(foundUser);
            return this.userRepository.findById(user_id).get();
        }else {
            throw new IllegalAccessException("User or company not found in the system");
        }
    }

    public User save(User user) {
        return this.userRepository.save(user);
    }

    public Optional<User> findById(Long userId) {
        return this.userRepository.findById(userId);
    }

    public List<User> findAll() {
       return this.userRepository.findAll();
    }

    public void delete(User user) {
        this.userRepository.delete(user);
    }
}
