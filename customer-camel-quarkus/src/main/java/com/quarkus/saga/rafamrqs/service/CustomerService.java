package com.quarkus.saga.rafamrqs.service;

import javax.enterprise.context.ApplicationScoped;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;

@ApplicationScoped
public class CustomerService extends RouteBuilder{

//    @Inject
//    @MongoClientName("mongoClient1")
//    MongoClient mongoClient1;    

    @Override
    public void configure() throws Exception {
        restConfiguration()
        .bindingMode(RestBindingMode.json)
        .dataFormatProperty("prettyPrint", "true")
        .apiContextPath("api-doc")
        .apiVendorExtension(true)
            .apiProperty("api.title", "Customer API").apiProperty("api.version", "1")
            .apiProperty("api.contact.name", "Rafael Marques")
            .apiProperty("cors", "true");

        rest("/api/customer")
        .consumes("application/json")
        .produces("application/json")

        .get()
        .to("direct:getCustomers")

        .post()
        .to("direct:saveCustomer");




        from("direct:getCustomers")
        .to("mongodb:camelMongoClient?database=camel-saga&collection=customers&operation=findAll");

        from("direct:saveCustomer")
        .bean("customerBean", "setRegistrationDate")
        .to("mongodb:camelMongoClient?database=camel-saga&collection=customers&operation=save");

    }
    
}
