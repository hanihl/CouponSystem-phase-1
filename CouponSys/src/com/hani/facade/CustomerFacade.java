package com.hani.facade;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import com.hani.DAO.CompaniesDBDAO;
import com.hani.DAO.CouponsDBDAO;
import com.hani.DAO.CustomersDBDAO;
import com.hani.beans.Category;
import com.hani.beans.Coupon;
import com.hani.beans.Customer;
import com.hani.exception.CouponSystemException;

public class CustomerFacade extends ClientFacade {

	private int customerID;

	public CustomerFacade() {
		companiesDAO = new CompaniesDBDAO();
		customersDAO = new CustomersDBDAO();
		couponsDAO = new CouponsDBDAO();
	}

	public boolean login(String email, String password) throws CouponSystemException {
		boolean isCustomerExist = customersDAO.isCustomerExists(email, password);
		if (isCustomerExist == true) {
			customerID = customersDAO.getCustomerIdByEmail(email);
		}
		return isCustomerExist;
	}

	public void purchaseCoupon(Coupon coupon) throws CouponSystemException {
		List<Coupon> customerCoupons = couponsDAO.getCouponsByCustomerID(customerID);
		if (coupon.getAmount() == 0) {
			throw new CouponSystemException("coupon is out of stock");
		}
		if (LocalDate.now().isAfter(coupon.getEndDate())) {
			throw new CouponSystemException("coupon is out of date");
		}

		for (Coupon cou : customerCoupons) {
			if (cou.equals(coupon)) {
				throw new CouponSystemException("coupon already purchased");
			}

		}
		couponsDAO.addCouponPurchase(customerID, coupon.getId());
		int couponAmount = coupon.getAmount();
		coupon.setAmount(couponAmount - 1);
		couponsDAO.updateCoupon(coupon);
	}

	public List<Coupon> getCustomerCoupons() throws CouponSystemException {
		List<Coupon> customerCoupons = couponsDAO.getCouponsByCustomerID(customerID);
		System.out.println(customerCoupons);
		return customerCoupons;
	}

	public List<Coupon> getCustomerCoupons(Category category) throws CouponSystemException {
		List<Coupon> list = couponsDAO.getCouponsByCustomerID(customerID);
		Iterator<Coupon> it = list.iterator();
		while (it.hasNext()) {
			Coupon c = it.next();
			if (c.getCategory_id().equals(category)) {
				System.out.println(c);
			}
		}
		return list;

	}

	public List<Coupon> getCustomerCoupons(double maxPrice) throws CouponSystemException {
		List<Coupon> list = couponsDAO.getCouponsByCustomerID(customerID);
		Iterator<Coupon> it = list.iterator();
		while (it.hasNext()) {
			Coupon c = it.next();
			if (c.getPrice() > maxPrice) {
				it.remove();
			}
		}
		System.out.println(list);
		return list;

	}

	public Customer getCustomerDetails() throws CouponSystemException {
		return customersDAO.getOneCustomer(customerID);
	}
}
