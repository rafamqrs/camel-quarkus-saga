package com.quarkus.saga.rafamrqs.beans;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import org.apache.camel.Exchange;
import org.bson.Document;

@ApplicationScoped
@Named("customerBean")
public class CustomerBean {
 
    public Document setRegistrationDate(Exchange ex) {
        Document docForSave = ex.getIn().getBody(Document.class);
        Date in = new Date();
        docForSave.replace("registrationDate", LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault()));
        return docForSave;
    }
}
