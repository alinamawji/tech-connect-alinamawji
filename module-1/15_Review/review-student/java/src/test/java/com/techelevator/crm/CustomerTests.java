package com.techelevator.crm;

import com.techelevator.crm.Customer;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class CustomerTests {

    @Test
    public void getBalanceDueTests() {
        Customer customer = new Customer("New", "Customer");

        HashMap<String, Double> servicesRendered = new HashMap<String, Double>();
        servicesRendered.put("Walking", 10.00);
        servicesRendered.put("Grooming", 15.00);
        servicesRendered.put("Sitting", 9.00);

        assertEquals("Walking: 10.00, Grooming: 15.00, Sitting: 9.00",34.00, customer.getBalanceDue(servicesRendered), 0.0);
    }

}