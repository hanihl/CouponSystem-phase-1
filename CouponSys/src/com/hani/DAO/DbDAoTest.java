package com.hani.DAO;

import com.hani.exception.CouponSystemException;

public class DbDAoTest {
	public static void main(String[] args) {

		// -------------companiesDBDAO test-------------------//

		CompaniesDBDAO comp = new CompaniesDBDAO();
//		try {
//			comp.addCompany(new Company("name", "email", "password"));
//		} catch (CouponSystemException e) {
//			e.printStackTrace();
//		}
//		try {
//			comp.updateCompany(new Company(302, "f", "ff", "fff"));
//		} catch (CouponSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			comp.deleteCompany(30);
//		} catch (CouponSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			comp.getAllCompanies();
//		} catch (CouponSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			comp.getOneCompany(4);
//		} catch (CouponSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		try {
//			comp.getCompanyidByEmail("1233dddl@mail");
//		} catch (CouponSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		// -------------------customersDBDAO test-------------------------------///

		CustomersDBDAO cust = new CustomersDBDAO();

//		try {
//			cust.addCustomer(new Customer( "first", "last", "email", "password"));
//		} catch (CouponSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		try {
//			cust.updateCustomer(new Customer(8, "last", "first", "mail", "pass", null));
//
//		} catch (CouponSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			cust.deleteCustomer(12);
//		} catch (CouponSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			cust.getAllCustomers();
//		} catch (CouponSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			cust.getOneCustomer(1);
//		} catch (CouponSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			cust.getCustomerIdByEmail("hl@mail");
//		} catch (CouponSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		// ----------------couponsDBDAO test---------------------------//

		CouponsDBDAO coup = new CouponsDBDAO();

//		try {
//			coup.addCoupon(new Coupon(3, Category.RESTAURANT, "title", "description", LocalDate.parse("2020-03-12"),
//					LocalDate.parse("2021-09-12"), 4, 99.99, "image"));
//		} catch (CouponSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			coup.updateCoupon(new Coupon(21, 3, Category.FOOD, "title", "description", LocalDate.parse("2020-03-12"),
//					LocalDate.parse("2021-09-12"), 4, 99.99, "image"));
//		} catch (CouponSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			coup.deleteCoupon(21);
//		} catch (CouponSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			coup.getAllCoupons();
//		} catch (CouponSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			coup.getOneCoupon(20);
//		} catch (CouponSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			coup.addCouponPurchase(1, 5);
//		} catch (CouponSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			coup.deleteCouponPurchase(19);
//		} catch (CouponSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			coup.deleteCouponPurchase(1, 5);
//		} catch (CouponSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			System.out.println(coup.isCouponExistByTitle(1, "vacation"));
//		} catch (
//
//		CouponSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			System.out.println(coup.getCouponsByCompanyID(1));
//		} catch (CouponSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			System.out.println(coup.getCouponsByCustomerID(1));
//		} catch (CouponSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			coup.deleteAllCompanyCoupons(1);
//		} catch (CouponSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			coup.deleteCouponPurchaseByCustomer(1);
//		} catch (CouponSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		try {
			coup.getExpiredCoupons();
		} catch (CouponSystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/// -----All Works!---///

	}
}
