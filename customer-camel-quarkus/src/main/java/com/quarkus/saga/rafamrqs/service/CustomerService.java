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

        .post()
        .to("direct:postCustomer");




        from("direct:postCustomer")
        .bean("customerBean", "hello")
        .log("Testando... ${body}")
        .to("mongodb:camelMongoClient?database=camel-saga&collection=customers&operation=findAll");

//        from("direct:insert")
//        .to("mongodb:camelMongoClient?database=local&collection=myCollection&operation=save");


//        from("mongodb:mongoClient1?database=local&collection=cart&operation=findAll")
//        .log("Testando");                
    }
    
}
