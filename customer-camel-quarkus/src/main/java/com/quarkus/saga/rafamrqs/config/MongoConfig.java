package com.quarkus.saga.rafamrqs.config;

import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;

import io.quarkus.runtime.annotations.RegisterForReflection;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.mongodb.MongoClient;


/**
 * Update the application.properties with the value of @Named if you want to use different database instances.
 * 
 */

@ApplicationScoped
@Named("mongoBean")
@RegisterForReflection
public class MongoConfig {


    public MongoClient getMongoClient(){
        return new MongoClient(new ServerAddress("localhost:27017"), new MongoClientOptions.Builder().build());
    }
}
