package com.smecosystem_rest.smecosystem_rest.model_tests;

import com.smecosystem_rest.smecosystem_rest.model.Company;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CompanyTest {

    @Test
    public void companyMethods() {
        Company testCompany= new Company(); // MyClass is tested
        testCompany.setKvkNummer("testCompanyNumber");

        // assert statements
        assertEquals("testCompanyNumber", testCompany.getKvkNummer());
        assertEquals(testCompany.getId(),0);
        assertNull(testCompany.getWalletAddress());
    }

}
