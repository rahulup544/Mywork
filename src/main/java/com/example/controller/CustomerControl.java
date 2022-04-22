package com.example.controller;
import com.example.demo.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CustomerControl {
@Autowired
CustomerService service;
@RequestMapping("/customerclass")
public String test()
{
	return "Customer Controller class";
}
@RequestMapping("/fetchcustomerdetails")
List<Customer> getList()
{
	List<Customer> list=service.getCustomerList();
	for(Customer c:list)
	{
		System.out.println(c+"\n");
	}
	return list;
}
@GetMapping("customer/{id}")
public String read(@PathVariable("id") int id){
	Customer c=service.getById(id);
	String st=c.toString();
	return st;
}
@RequestMapping("/getCustomer/{id}")
public ResponseEntity<Customer> findOne(@PathVariable(value="id") Integer id){
	Customer cust=service.getById(id);
	if(cust!=null)
	{
		return new ResponseEntity<>(cust,HttpStatus.OK);
	}
	else {
		return new ResponseEntity<>(cust,HttpStatus.NOT_FOUND);
	}
}
@PostMapping("/save")
public ResponseEntity<Customer> saveCustomer(@RequestBody Customer c)
{
	 Customer cust=c;
	service.saveCustomer(cust);
	return new ResponseEntity<Customer>(cust,HttpStatus.OK);
}
@PutMapping("/update")
public ResponseEntity<Customer> updateCustomer(@RequestBody Customer c)
{
	service.updateCustomer(c, c.getCustomer_id());
	return new ResponseEntity<Customer>(c,HttpStatus.OK); 
}

@DeleteMapping("/delete/{id}")
public ResponseEntity<Customer> deleteCustomer(@PathVariable(value="id") Integer id){
	Customer c=service.deleteCustomerById(id);
	return new ResponseEntity<Customer>(c,HttpStatus.OK);
}

}
