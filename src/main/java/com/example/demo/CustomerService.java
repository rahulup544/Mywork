package com.example.demo;
import java.util.List;

import org.springframework.stereotype.Service;
@Service
public interface CustomerService  {
List<Customer> getCustomerList();
Customer getById(int id);
void saveCustomer(Customer c);
Customer updateCustomer(Customer c,int customerid);
Customer deleteCustomerById(int curomerid);
}
 