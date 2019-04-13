package com.smecosystem_rest.smecosystem_rest.model_tests;

import com.smecosystem_rest.smecosystem_rest.repositories.UserRepositoryImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;


public class UserRepositoryImplTest {

    @Autowired
    private UserRepositoryImpl userRepositoryImpl;

    @Test
    public void testGetUserByName() {
        Assert.notNull(userRepositoryImpl.findByFirstName("peter"), "should not be null");
    }

    @Test
    public void testGetUserById() {
        Assert.notNull(userRepositoryImpl.findById(1l), "should not be null");
    }
}
