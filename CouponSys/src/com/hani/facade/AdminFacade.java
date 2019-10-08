package com.hani.facade;

import java.util.List;

import com.hani.DAO.CompaniesDBDAO;
import com.hani.DAO.CouponsDBDAO;
import com.hani.DAO.CustomersDBDAO;
import com.hani.beans.Company;
import com.hani.beans.Coupon;
import com.hani.beans.Customer;
import com.hani.exception.CouponSystemException;

public class AdminFacade extends ClientFacade {

	public AdminFacade() {
		companiesDAO = new CompaniesDBDAO();
		customersDAO = new CustomersDBDAO();
		couponsDAO = new CouponsDBDAO();
	}

	public boolean login(String email, String password) {
		if (email.equals("admin@admin.com") && password.equals("admin")) {
//			System.out.println("Connected as admin");
			return true;
		}
		return false;
	}

	public void addCompany(Company company) throws CouponSystemException {

		List<Company> allCompanies = companiesDAO.getAllCompanies();
		for (Company existCompany : allCompanies) {
			if (existCompany.getName().equals(company.getName())) {
				throw new CouponSystemException("company name already exists!");
			}
			if (existCompany.getEmail().equals(company.getEmail())) {
				throw new CouponSystemException("company email already exists!");
			}

		}
		companiesDAO.addCompany(company);
	}

	public void updateCompany(Company company) throws CouponSystemException {
		Company existCompany = companiesDAO.getOneCompany(company.getId());
		if (company.getName().equals(existCompany.getName()) && (company.getId() == existCompany.getId())) {
			companiesDAO.updateCompany(company);
		} else {
			throw new CouponSystemException("Updating company Failed");
		}
	}

	public void deleteCompany(int companyID) throws CouponSystemException {
		List<Coupon> companyCoupons = couponsDAO.getCouponsByCompanyID(companyID);
		for (Coupon coupon : companyCoupons) {
			couponsDAO.deleteCouponPurchase(coupon.getId());
			couponsDAO.deleteAllCompanyCoupons(companyID);
		}
		companiesDAO.deleteCompany(companyID);

	}

	public List<Company> getAllCompanies() throws CouponSystemException {
		return companiesDAO.getAllCompanies();
	}

	public Company getOneCompany(int companyID) throws CouponSystemException {
		return companiesDAO.getOneCompany(companyID);
	}

	public void addCustomer(Customer customer) throws CouponSystemException {
		List<Customer> allCustomers = customersDAO.getAllCustomers();
		for (Customer existCustomer : allCustomers) {
			if (existCustomer.getEmail().equals(customer.getEmail())) {
				throw new CouponSystemException("email address already exists");
			}
		}
		customersDAO.addCustomer(customer);
	}

	public void updateCustomer(Customer customer) throws CouponSystemException {
		Customer existCustomer = customersDAO.getOneCustomer(customer.getId());
		if (customer.getId() != existCustomer.getId()) {
			throw new CouponSystemException("cannot change customer ID");
		}
		customersDAO.updateCustomer(customer);
	}

	public void deleteCustomer(int customerID) throws CouponSystemException {
		couponsDAO.deleteCouponPurchaseByCustomer(customerID);
		customersDAO.deleteCustomer(customerID);
		// another solution
//		ArrayList<Coupon> customerCoupons = couponsDAO.getCouponsByCustomerID(customerID);
//		for (Coupon coupon : customerCoupons) {
//			couponsDAO.deleteCouponPurchase(coupon.getId());
//		}
//		customersDAO.deleteCustomer(customerID);
//	}
	}

	public List<Customer> getAllCustomers() throws CouponSystemException {
		return customersDAO.getAllCustomers();
	}

	public Customer getoneCustomer(int customerID) throws CouponSystemException {
		return customersDAO.getOneCustomer(customerID);
	}

}
