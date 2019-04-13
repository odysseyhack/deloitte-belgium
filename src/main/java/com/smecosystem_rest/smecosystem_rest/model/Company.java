package com.smecosystem_rest.smecosystem_rest.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "company")
@EntityListeners(AuditingEntityListener.class)
public class Company {

    private long id;
    private String kvkNummer;
    private String name;
    private String walletAddress;
    private String kvkListAddress;
    private List<User> users;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "kvk_nummer", nullable = false)
    public String getKvkNummer() {
        return kvkNummer;
    }

    public void setKvkNummer(String kvkNummer) {
        this.kvkNummer = kvkNummer;
    }

    @Column(name = "wallet_address")
    public String getWalletAddress() {
        return walletAddress;
    }

    public void setWalletAddress(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Column(name = "kvk_list_address")
    public String getKvkListAddress() {
        return kvkListAddress;
    }

    public void setKvkListAddress(String kvkListAddress) {
        this.kvkListAddress = kvkListAddress;
    }

    @OneToMany(mappedBy="company")
    @JsonManagedReference
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
