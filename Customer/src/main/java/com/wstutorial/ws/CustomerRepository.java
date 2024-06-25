package com.wstutorial.ws;

import com.wstutorial.ws.commonservice.AcknowledgementCode;
import com.wstutorial.ws.customerservice.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {

    List<Customer> customers = new ArrayList<>();

    public CustomerRepository() {
        Customer cus1 = new Customer();
        cus1.setPhoneNumber("01796092925");
        cus1.setId(201l);
        cus1.setName("Md Siam");
        cus1.setEmail("bsse1104@iit.du.ac.bd");


        Customer cus2 = new Customer();
        cus2.setPhoneNumber("01518988953");
        cus2.setId(202l);
        cus2.setName("Ashaduzzaman Nur");
        cus2.setEmail("something@iit.du.ac.bd");

        customers.add(cus1);
        customers.add(cus2);
    }
    public List<Customer> getCustomers() {
        return customers;
    }

    public Customer getCustomerById(Long id) {
        for(Customer c: customers) {
            if(c.getId() == id) {
                return c;
            }
        }
        System.out.println("can not delete: customer not found with id: " + id);
        return null;
    }

    public AcknowledgementCode deleteCustomerById(Long id) {

        for(Customer c: customers) {
            if(c.getId() == id) {
                customers.remove(c);
                return AcknowledgementCode.DELETED;
            }
        }
        System.out.println("can not delete: customer not found with id: " + id);
        return AcknowledgementCode.FAILED;
    }

    public AcknowledgementCode updateCustomerById(Long id, Customer customer) {
        if (id == null || customer == null) {
            System.out.println("Invalid input: id or customer is null");
            return AcknowledgementCode.FAILED;
        }

        for (int i = 0; i < customers.size(); i++) {
            Long customerId = customers.get(i).getId();
            if (customerId.equals(id)) {
                customers.set(i, customer);
                return AcknowledgementCode.UPDATED;
            }
        }
        System.out.println("Cannot update: customer not found with id: " + id);
        return AcknowledgementCode.FAILED;
    }


    public void createNewCustomer(Customer customer) {
        customer.setId(customers.size()+201);
        customers.add(customer);
    }

}
