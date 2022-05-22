package com.quarkus.saga.rafamrqs.beans;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named("customerBean")
public class CustomerBean {
 
    public String hello(String name) {
        return "Hello " + name + " from the NamedBean";
    }
}
