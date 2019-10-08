package com.hani.Test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.hani.DAO.CompaniesDBDAO;
import com.hani.DAO.CouponsDBDAO;
import com.hani.DAO.CustomersDBDAO;
import com.hani.beans.Company;
import com.hani.beans.Coupon;
import com.hani.exception.CouponSystemException;

public class DbDAOTest {

	public static void main(String[] args) {

		CompaniesDBDAO comTest = new CompaniesDBDAO();
		/*
		 * 1. a test to check if the company inserted exists in the DB
		 */
//		try {
//			comTest.isCompanyExists("intel@mail", "int");
//		} catch (CouponSystemException e) {
//			e.printStackTrace();
//
//		}

		// -----------------------------------------------------------------------//

		// 2.add company
		Date date1 = new Date((new GregorianCalendar(2010, Calendar.AUGUST, 15).getTimeInMillis()));
		Date date2 = new Date((new GregorianCalendar(2011, Calendar.OCTOBER, 15).getTimeInMillis()));
		Date date3 = new Date((new GregorianCalendar(2012, Calendar.JANUARY, 15).getTimeInMillis()));
		Date date4 = new Date((new GregorianCalendar(2013, Calendar.APRIL, 15).getTimeInMillis()));
//
		ArrayList<Coupon> comp1 = new ArrayList<>();
//		Coupon cou1 = new Coupon(1, Category.FOOD, "food", "italian food", date1, date2, 3, 3.99, "food img");
//		Coupon cou2 = new Coupon(1, Category.ELECTRICITY, "electricity", "elecs", date3, date4, 3, 13.99, "elec img");
//		Coupon cou3 = new Coupon(1, Category.CLOTHES, "jeans", "t-shirt", date1, date2, 3, 32.99, "clothes img");
//		Coupon cou4 = new Coupon(1, Category.RESTAURANT, "mangos", "french", date1, date3, 3, 22.99, "italian img");
//		Coupon cou5 = new Coupon(1, Category.VACATION, "food", "blad", date1, date4, 3, 5.99, "italy img");
//		comp1.add(cou1);
//		comp1.add(cou2);
//		comp1.add(cou3);
//		comp1.add(cou4);
//		comp1.add(cou5);

		Company c = new Company("new", "Jnew@mail", "pass", comp1);
//		c.setName("nCompany");
//		c.setEmail("cp@mail");
//		c.setPassword("ps12");
//		c.setCoupons(comp1);

//		try {
//			comTest.addCompany(c);
//		} catch (CouponSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//------------------------------------------------------------//

		// 3. Delete Company
//		try {
//			comTest.deleteCompany(2);
//		} catch (CouponSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//-----------------------------------------------------------------------------//
//		4. update company

//		c.setName("NewMyCom");
//		c.setEmail("newMyCompany@gmail.com");
//		c.setPassword("pass");
//		c.setId(51);
//		try {
//			comTest.updateCompany(c);
//			;
//		} catch (CouponSystemException e) {
//			// TODO Auto-generated catch block
//			e.getMessage();
//		}
//-------------------------------------------------------------------------------//
//		 5. get allCompanies
		try {
			comTest.getAllCompanies();
		} catch (CouponSystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
////--------------------------------------------------------------------------------//
		// 6. get oneCompany
//		try {
//			comTest.getOneCompany(1);
//		} catch (CouponSystemException e) {
//			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
//		}
		//// --------------------------------------------------------------------------------//

//		7. get allcoupones by companyID
//		try {
//			comTest.getCouponsByCompanyID(0);
//		} catch (CouponSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		// -------------------------------------------------------------------------------------

		// 8/get id by email

//		try {
//			comTest.getCompanyidByEmail("cp@masil");
//		} catch (CouponSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		**********************************************************************

//		*CustomersDBDAO test*

		CustomersDBDAO cusTest = new CustomersDBDAO();

		// 1. a test to check if the customer inserted exists in the DB

//		try {
//			cusTest.isCustomerExists("hahl@gmail.com", "han123");
//		} catch (CouponSystemException e) {
//			e.printStackTrace();
//		}

//------------------------------------------------------------------------------------//
//		// 2. Delete Customer
//		try {
//			cusTest.deleteCustomer(544);
//
//		} catch (CouponSystemException e) {
//			e.printStackTrace();
//		}

		// ------------------------------------------------------------------------------------//

//		// 3. Add Customer
//		Customer c = new Customer();
//		c.setFirstName("johnny");
//		c.setLastName("danny");
//		c.setEmail("jod@gmail.com");
//		c.setPassword("jd1d23");
//		try {
//			cusTest.addCustomer(c);
//			;
//		} catch (CouponSystemException e) {
//			e.printStackTrace();
//		}
//	}
		// ------------------------------------------------------------------------------------//

//		 4. update customer
//		c.setFirstName("johnew");
//		c.setLastName("doe");
//		c.setEmail("jd@gmail.com");
//		c.setPassword("jd123");
//		c.setId(5);
//		try {
//			cusTest.updateCustomer(c);
//		} catch (CouponSystemException e) {
//			e.printStackTrace();
//		}
		// ------------------------------------------------------------------------------------//

//		// 5. get allCustomers
//		try {
//			cusTest.getAllCustomers();
//		} catch (CouponSystemException e) {
//			e.printStackTrace();
//		}
		// ------------------------------------------------------------------------------------//

//		 6. get oneCustomer
//		try {
//			cusTest.getOneCustomer(11);
//		} catch (CouponSystemException e) {
//			e.printStackTrace();
//		}
//
//       ***********************************************************************************

		// CouponsDBDAO Test

		CouponsDBDAO couTest = new CouponsDBDAO();
		// -----------------------------------------------------------------//

		// 1.add coupon to the db
//		Coupon c = new Coupon(2, Category.RESTAURANT, "la dolce", "italian restaurant", date3, date4, 3, 33.99,
//				"venice image");

//		Coupon c = new Coupon();
//		c.setCompanyID(1);
//		c.setCategory_id(Category.FOOD);
//		c.setTitle("food");
//		c.setDescription("bon apetite");
//		c.setStartDate(date1);
//		c.setEndDate(date4);
//		c.setAmount(42);
//		c.setPrice(133.41);
//		c.setImage("image");
////
//		try {
//			couTest.addCoupon(c);
//		} catch (CouponSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//------------------------------------------------------------------------//

		// 2.update coupon
//		Coupon c = new Coupon();
//		c.setCompanyID(4);
//		c.setCategory_id(Category.ELECTRICITY);
//		c.setTitle("electricityyyyLights");
//		c.setDescription("lamps,fridge...");
//		c.setStartDate(date1);
//		c.setEndDate(date3);
//		c.setAmount(3);
//		c.setPrice(64.41);
//		c.setImage("image");
//		c.setId(4);
//		try {
//			couTest.updateCoupon(c);
//		} catch (CouponSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		// --------------------------------------------------//

		// 3.delete coupon
////
//		try {
//			couTest.deleteCoupon(3);
//		} catch (CouponSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		// ---------------------------------------------------//

		// 4.getAllCoupons

//		try {
//			couTest.getAllCoupons();
//		} catch (CouponSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		// ----------------------------------------------------//

		// 5.getOneCoupon

//		try {
//			couTest.getOneCoupon(4);
//		} catch (CouponSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		// ----------------------------------------------------//

		// 6.delete couponPurchase

//		try {
//			couTest.deleteCouponPurchase(1, 2);
//		} catch (CouponSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		// -----------------------------------------------------//

		// 7.add couponPurchase

//		try {
//			couTest.addCouponPurchase(3, 3);
//		} catch (CouponSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//
//		}
	}
}
