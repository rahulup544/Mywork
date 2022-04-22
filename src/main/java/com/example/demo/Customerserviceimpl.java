package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Customerserviceimpl implements CustomerService{
	@Autowired
	Customerrepo repo;
	@Override
	public List<Customer> getCustomerList() {
		// TODO Auto-generated method stub
		List<Customer> list=repo.findAll();
		return list;
	}

	@Override
	public Customer getById(int id) {
		// TODO Auto-generated method stub
		Customer c=repo.getById(id);
		return c;
	}

	@Override
	public void saveCustomer(Customer c) {
		// TODO Auto-generated method stub
		repo.save(c);
	}

	@Override
	public Customer updateCustomer(Customer c, int customerid) {
		// TODO Auto-generated method stub
		Customer ct=repo.getById(customerid);
		ct.setCustomer_name(c.getCustomer_name());
		ct.setAge(c.getAge());
		ct.setGender(c.getGender());
		ct.setCity(c.getCity());
		repo.save(ct);
		return ct;
	}

	@Override
	public Customer deleteCustomerById(int customerid) {
		// TODO Auto-generated method stub
		Customer c=repo.getById(customerid);
		repo.deleteById(customerid);;
		return c;
	}

}
