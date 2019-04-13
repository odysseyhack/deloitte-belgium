package com.smecosystem_rest.smecosystem_rest.model_tests;

import com.smecosystem_rest.smecosystem_rest.model.Smartcontract;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SmartcontractTest {

    @Test
    public void userMethods() {
        Smartcontract testSmartContract = new Smartcontract(); // MyClass is tested
        testSmartContract.setDiscount(10d);
        testSmartContract.setContent("test content, description of the smartcontract");
        assertEquals("test content, description of the smartcontract", testSmartContract.getContent());
        testSmartContract.setContent("new description");
        assertEquals("new description", testSmartContract.getContent());

        assertNull(testSmartContract.getBlockAddress());
        assertEquals(testSmartContract.getId(),0);

        testSmartContract.setBlockAddress("0x0");
        assertEquals("0x0", testSmartContract.getBlockAddress());
        // assert statements
    }

}
