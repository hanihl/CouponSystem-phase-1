package com.hani.facade;

import com.hani.beans.Category;
import com.hani.exception.CouponSystemException;

public class FacadeTest {
	public static void main(String[] args) {
		// -------AdminFacade test-----------///
		AdminFacade af = new AdminFacade();

		af.login("admin@admin.com", "admin");

//		try {
//			af.addCompany(new Company("han22hl", "hl12@mail", "passs"));
//		} catch (CouponSystemException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
//		}

//		try {
//			af.updateCompany(new Company(32, "hanihl", "hlhani@mail", "paswws"));
//		} catch (CouponSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			af.deleteCompany(8);
//		} catch (CouponSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			af.getAllCompanies();
//		} catch (CouponSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
////		}
//		try {
//			af.getOneCompany(31);
//		} catch (CouponSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			af.addCustomer(new Customer("hani", "hl", "hleihl@mail", "pass"));
//		} catch (CouponSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			af.updateCustomer(new Customer(3, "hani", "hl", "hleihl@mail", "pass", null));
//		} catch (CouponSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			af.deleteCustomer(10);
//		} catch (CouponSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			af.getAllCustomers();
//		} catch (CouponSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			af.getoneCustomer(1);
//		} catch (CouponSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		// -----------CompanyFacade test-------------//

		CompanyFacade cf = new CompanyFacade();

		try {
			cf.login("ibm@mil", "123");
		} catch (CouponSystemException e1) {
			e1.printStackTrace();
		}
//		Coupon coupon1 = new Coupon(2, Category.RESTAURANT, "newccs22", "amazing food", LocalDate.parse("2019-09-30"),
//				LocalDate.parse("2020-09-01"), 10, 99.9, "img");
//		Coupon coup = new Coupon(1, Category.ELECTRICITY, "s33", "ele22ctrics", LocalDate.parse("2010-08-15"),
//				LocalDate.parse("2013-04-15"), 3, 133.41, "image");

//		try {
//			cf.addCoupon(coup);
//		} catch (CouponSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			cf.updateCoupon(coup);
//		} catch (CouponSystemException e) {
//			e.printStackTrace();
//		}
//		try {
//			cf.deleteCoupon(7);
//		} catch (CouponSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			cf.getCompanyCoupons();
//		} catch (CouponSystemException e1) {
//			e1.printStackTrace();
//		}

//		try {
//			cf.getCompanyCoupons(Category.ELECTRICITY);
//		} catch (CouponSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			cf.getCompanyCoupons(10.44);
//		} catch (CouponSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			cf.getCompanyDetails();
//		} catch (CouponSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		// ------------CustomerFacade test---------------------///

		CustomerFacade cusf = new CustomerFacade();
//		Coupon coup2 = new Coupon(1, Category.ELECTRICITY, "dwwdd", "eweq", LocalDate.parse("2020-09-01"),
//				LocalDate.parse("2020-10-01"), 2, 99.9, "img");
		try {
			cusf.login("hleihl@mail", "pass");
		} catch (CouponSystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//		try {
//			cusf.purchaseCoupon(coup2);
//		} catch (CouponSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			cusf.getCustomerCoupons();
//		} catch (CouponSystemException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		try {
			cusf.getCustomerCoupons(Category.FOOD);
		} catch (CouponSystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		try {
//			cusf.getCustomerCoupons(100.1);
//		} catch (CouponSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			cusf.getCustomerDetails();
//		} catch (CouponSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		// ------------test complete-------------//////////

	}

}
