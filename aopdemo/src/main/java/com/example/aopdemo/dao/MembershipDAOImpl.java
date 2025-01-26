package com.example.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{

    @Override
    public void addMember() {
        System.out.println(getClass() + ": Doing my DB work: Adding an membership");
    }
}
