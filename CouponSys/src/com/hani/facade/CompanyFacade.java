package com.hani.facade;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.hani.DAO.CompaniesDBDAO;
import com.hani.DAO.CouponsDBDAO;
import com.hani.DAO.CustomersDBDAO;
import com.hani.beans.Category;
import com.hani.beans.Company;
import com.hani.beans.Coupon;
import com.hani.exception.CouponSystemException;

public class CompanyFacade extends ClientFacade {

	private int companyID;

	public CompanyFacade() {
		companiesDAO = new CompaniesDBDAO();
		customersDAO = new CustomersDBDAO();
		couponsDAO = new CouponsDBDAO();
	}

	public boolean login(String email, String password) throws CouponSystemException {
		boolean isCompanyExists = companiesDAO.isCompanyExists(email, password);
		if (isCompanyExists == true) {
			companyID = companiesDAO.getCompanyidByEmail(email);

		}
		return isCompanyExists;
	}

	public void addCoupon(Coupon coupon) throws CouponSystemException {
		List<Coupon> companyCoupons = new ArrayList<Coupon>(couponsDAO.getCouponsByCompanyID(coupon.getCompanyID()));
		boolean isExist = false;
		for (Coupon coupon2 : companyCoupons) {
			if (coupon2.getTitle().equals(coupon.getTitle())) {
				isExist = true;
				System.out.println("coupon title already exists!");
			}
		}
		if (!isExist) {
			couponsDAO.addCoupon(coupon);
			System.out.println("coupon added!");
		}

	}

	public void updateCoupon(Coupon coupon) throws CouponSystemException {
		Coupon coup = couponsDAO.getOneCoupon(coupon.getId());
		if (coup.getId() == coupon.getId() && (coup.getCompanyID() == coupon.getCompanyID())) {

			couponsDAO.updateCoupon(coupon);
			System.out.println("Coupon Updated");
		} else {

			throw new CouponSystemException("Update Failed! update companyID or CouponID is not possible");
		}
	}

	public void deleteCoupon(int couponID) throws CouponSystemException {
		couponsDAO.deleteCouponPurchase(couponID);
		couponsDAO.deleteCoupon(couponID);
	}

	public List<Coupon> getCompanyCoupons() throws CouponSystemException {
		List<Coupon> companyCoupons = couponsDAO.getCouponsByCompanyID(companyID);
		System.out.println(companyCoupons);
		return companyCoupons;
	}

	public List<Coupon> getCompanyCoupons(Category category) throws CouponSystemException {
		List<Coupon> list = couponsDAO.getCouponsByCompanyID(companyID);
		Iterator<Coupon> it = list.iterator();
		while (it.hasNext()) {
			Coupon c = it.next();
			if (c.getCategory_id().equals(category)) {
				System.out.println(c);
			}
		}
		return list;

	}

	public List<Coupon> getCompanyCoupons(double maxPrice) throws CouponSystemException {
		List<Coupon> list = couponsDAO.getCouponsByCompanyID(companyID);
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

	public Company getCompanyDetails() throws CouponSystemException {
		return companiesDAO.getOneCompany(companyID);
	}

}
