package com.hani.DAO;

import java.util.List;

import com.hani.beans.Coupon;
import com.hani.exception.CouponSystemException;

public interface CouponsDAO {
	public void addCoupon(Coupon coupon) throws CouponSystemException;

	public void updateCoupon(Coupon coupon) throws CouponSystemException;

	public void deleteCoupon(int couponID) throws CouponSystemException;

	public void deleteAllCompanyCoupons(int companyID) throws CouponSystemException;

	public List<Coupon> getAllCoupons() throws CouponSystemException;

	public List<Coupon> getCouponsByCompanyID(int companyID) throws CouponSystemException;

	public List<Coupon> getCouponsByCustomerID(int customerID) throws CouponSystemException;

	public Coupon getOneCoupon(int couponID) throws CouponSystemException;

	public void addCouponPurchase(int customerID, int couponID) throws CouponSystemException;

	public void deleteCouponPurchase(int customerID, int couponID) throws CouponSystemException;

	public void deleteCouponPurchase(int couponID) throws CouponSystemException;

	public void deleteCouponPurchaseByCustomer(int customerID) throws CouponSystemException;

	public List<Coupon> getExpiredCoupons() throws CouponSystemException;

}
