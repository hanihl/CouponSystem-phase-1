package com.hani.DAO;

import java.util.List;

import com.hani.beans.Customer;
import com.hani.exception.CouponSystemException;

public interface CustomersDAO {

	public boolean isCustomerExists(String email, String password) throws CouponSystemException;

	public void addCustomer(Customer customer) throws CouponSystemException;

	public void updateCustomer(Customer customer) throws CouponSystemException;

	public void deleteCustomer(int cusotmerID) throws CouponSystemException;

	public List<Customer> getAllCustomers() throws CouponSystemException;

	public Customer getOneCustomer(int customerID) throws CouponSystemException;

	public int getCustomerIdByEmail(String email) throws CouponSystemException;

}
