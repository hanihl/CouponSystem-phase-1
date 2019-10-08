package Test;

import com.hani.connectionPool.ConnectionPool;
import com.hani.exception.CouponSystemException;
import com.hani.facade.AdminFacade;
import com.hani.facade.CompanyFacade;
import com.hani.facade.CustomerFacade;
import com.hani.job.CouponExpirationDailyJob;
import com.hani.login.ClientType;
import com.hani.login.LoginManager;

public class AppTest {
	public static void testAll() throws CouponSystemException, InterruptedException {
		CouponExpirationDailyJob job = new CouponExpirationDailyJob();
		Thread t = new Thread(job);
		job.setThread(t);
		t.start();
		try {

			LoginManager loginManager = LoginManager.getInstance();
			AdminFacade adminFacade = (AdminFacade) loginManager.login("admin@admin.com", "admin",
					ClientType.ADMINISTRATOR);
//			adminFacade.addCompany(new Company(29, "johnBryce1", "JB22@mail", "pass", null));
//			adminFacade.updateCompany(new Company(35, "johnBryce1", "JB322@mail", "pass", null));
//			adminFacade.deleteCompany(35);
//			adminFacade.getOneCompany(11);
//			adminFacade.getAllCompanies();

//			Customer customer = new Customer("DAVID22", "DIV22", "DIV2@mail", "password", null);
//			adminFacade.addCustomer(customer);
//			customer.setId(17);
//			customer.setEmail("newmail");
//			customer.setFirst_name("Devo");
//			adminFacade.updateCustomer(customer);
//			adminFacade.deleteCustomer(17);
//			adminFacade.getAllCustomers();
//			adminFacade.getoneCustomer(3);

//----------------------------companyFacade----------------------------------------------------//

			CompanyFacade companyFacade = (CompanyFacade) loginManager.login("ibm@mil", "123", ClientType.COMPANY);
//			Coupon coupon1 = new Coupon(55, 1, Category.FOOD, "m2iddleEast", "amazing food",
//					LocalDate.parse("2019-09-30"), LocalDate.parse("2020-09-01"), 10, 99.9, "img");
//			companyFacade.addCoupon(coupon1);
//			companyFacade.updateCoupon(new Coupon(55, 1, Category.RESTAURANT, "m2iddleEast", "amazing food",
//					LocalDate.parse("2019-09-30"), LocalDate.parse("2020-09-01"), 10, 99.9, "img"));
//			companyFacade.deleteCoupon(55);
//			companyFacade.getCompanyCoupons();
//			companyFacade.getCompanyCoupons(Category.FOOD);
//			companyFacade.getCompanyCoupons(14);
//			companyFacade.getCompanyDetails();

// -------------------customerFacade------------------------------------------//
			CustomerFacade customerFacade = (CustomerFacade) loginManager.login("hleihl@mail", "pass",
					ClientType.CUSTOMER);
//			customerFacade.purchaseCoupon(coup1);
//			customerFacade.getCustomerCoupons();
//			customerFacade.getCustomerCoupons(Category.VACATION);
//			customerFacade.getCustomerCoupons(100);
//			customerFacade.getCustomerDetails();
		} catch (Exception e) {
			System.out.println("Error: " + e);
		} finally {
			job.stop();
			t.join();
			ConnectionPool.getInstance().closeAllConnections();
		}

	}
}
