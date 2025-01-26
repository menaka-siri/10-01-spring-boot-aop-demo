package com.example.aopdemo.dao;

import com.example.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{

    @Override
    public void addAccount(Account theAccount) {
        System.out.println(getClass() + ": Doing my DB work: Adding an account");
    }
}
