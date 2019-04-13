package com.smecosystem_rest.smecosystem_rest.controller;

import com.smecosystem_rest.smecosystem_rest.exception.ResourceNotFoundException;
import com.smecosystem_rest.smecosystem_rest.model.User;
import com.smecosystem_rest.smecosystem_rest.model.transfer_objects.LoginData;
import com.smecosystem_rest.smecosystem_rest.repositories.UserRepository;
import com.smecosystem_rest.smecosystem_rest.repositories.UserRepositoryImpl;
import com.smecosystem_rest.smecosystem_rest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.WalletUtils;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/userRestService")
public class UserController {

    @Autowired
    private UserRepositoryImpl userRepository;


    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<User> getUserById(
            @PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found on :: "+ userId));
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/login")
    public  ResponseEntity<User> login(@Valid @RequestBody LoginData loginData) throws IllegalAccessException {
        User user = userService.login(loginData.getFirstName(), loginData.getPassword());
        return ResponseEntity.ok(user);
    }

    @GetMapping("/getUserWalletAddress/{id}")
    public ResponseEntity<String> getUserWalletAddress(
            @PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found on :: "+ userId));
        return ResponseEntity.ok().body(user.getWalletAddress());
    }

    @PostMapping("/createUser")
    public User createUser(@Valid @RequestBody User user) {
        this.userService.createUser(user);
        return userRepository.save(user);
    }


    @GetMapping("/addCompanyToUser/{id}/{company_id}")
    public ResponseEntity<User> addCompanyToUser( @PathVariable(value = "id") Long user_id,
                                                  @PathVariable(value = "company_id") Long company_id) throws IllegalAccessException {

        User user = this.userService.addCompanyToUser(user_id, company_id);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<User> updateUser(
            @PathVariable(value = "id") Long userId,
            @Valid @RequestBody User userDetails) throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found on :: "+ userId));

        user.setEmailAddress(userDetails.getEmailAddress());
        user.setLastName(userDetails.getLastName());
        user.setFirstName(userDetails.getFirstName());
        final User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/user/{id}")
    public Map<String, Boolean> deleteUser(
            @PathVariable(value = "id") Long userId) throws Exception {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found on :: "+ userId));

        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @GetMapping("/createNewWallet/{password}/{userId}")
    public ResponseEntity<String> createNewWallet(@PathVariable(value = "password") String password, @PathVariable(value = "userId") Long userId) throws ResourceNotFoundException, NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException, CipherException, IOException {

        // ideally this comes from the user repository
        Optional<User> user = this.userRepository.findById(userId);
        if(user.isPresent()) {
            User foundUser = user.get();
            String filename = WalletUtils.generateNewWalletFile(password, new File(User.getWalletPath()));
            foundUser.setWalletAddress(filename);
            userRepository.save(foundUser);
            return ResponseEntity.ok().body("User wallet created with name: " + filename);
        } else {
            throw new ResourceNotFoundException("User not found on :: "+ userId);
        }
    }

    @GetMapping("/getWallet/{password}/{userId}")
    public ResponseEntity<String> getWallet(@PathVariable(value = "password") String password, @PathVariable(value = "userId") Long userId) throws ResourceNotFoundException, NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException, CipherException, IOException {
        // ideally this comes from the user repository
        String walletAddress = this.userService.getWalletAddressById(userId, password);
        return ResponseEntity.ok().body("User wallet found with address with name: " + walletAddress);
    }

}