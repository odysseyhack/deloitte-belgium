package com.smecosystem_rest.smecosystem_rest.model;

import java.util.Date;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
public class User {

    // path on the system where the wallet file should be stored
    private static final String walletPath = "/home/peter/IdeaProjects/smecosystem_rest/src/main/resources/credentialFiles";

    private long id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String walletAddress;
    private String password;
    private String kvkNumber;
    private Company company;
    private boolean purchaseRights;
    private boolean salesRights;

    public static String getWalletPath() {
        return walletPath;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "email_address", nullable = false)
    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Column(name = "wallet_address")
    public String getWalletAddress() {
        return walletAddress;
    }

    public void setWalletAddress(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "kvk_number", nullable = false)
    public String getKvkNumber() {
        return kvkNumber;
    }

    public void setKvkNumber(String kvkNumber) {
        this.kvkNumber = kvkNumber;
    }

    @ManyToOne
    @JoinColumn(name = "company_id")
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Column(name = "purchase_rights", nullable = false)
    public boolean isPurchaseRights() {
        return purchaseRights;
    }

    public void setPurchaseRights(boolean purchaseRights) {
        this.purchaseRights = purchaseRights;
    }

    @Column(name = "sales_rights", nullable = false)
    public boolean isSalesRights() {
        return salesRights;
    }

    public void setSalesRights(boolean salesRights) {
        this.salesRights = salesRights;
    }
}