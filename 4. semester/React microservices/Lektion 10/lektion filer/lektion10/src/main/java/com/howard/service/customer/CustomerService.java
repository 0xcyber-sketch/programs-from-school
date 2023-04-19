package com.howard.service.customer;

import org.jboss.logging.Logger;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
public class CustomerService {

    @Inject //Field injection
    Logger log;

    public void test() {
        log.info("YYYtest is called on object before sleep " + this.toString());
        log.info("test is called on Thread before sleep " + Thread.currentThread().getName());
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("test is called on object after sleep " + this.toString());
        log.info("test is called on Thread after sleep " + Thread.currentThread().getName());
    }
}
