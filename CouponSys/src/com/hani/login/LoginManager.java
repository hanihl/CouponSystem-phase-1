package com.hani.login;

import com.hani.exception.CouponSystemException;
import com.hani.facade.AdminFacade;
import com.hani.facade.ClientFacade;
import com.hani.facade.CompanyFacade;
import com.hani.facade.CustomerFacade;

public class LoginManager {

	private AdminFacade adminFacade = new AdminFacade();
	private CompanyFacade companyFacade = new CompanyFacade();
	private CustomerFacade customerFacade = new CustomerFacade();

	/** define an instance of LoginManager */
	private static LoginManager instance;

	/** private CTOR to prevent others from instantiating this calss */
	private LoginManager() {
	}

	/** Lazily create the instance when it is accessed for the first time */
	public static synchronized LoginManager getInstance() {
		if (instance == null) {
			instance = new LoginManager();
		}
		return instance;
	}

	public ClientFacade login(String email, String password, ClientType clientType) throws CouponSystemException {

		switch (clientType) {

		case ADMINISTRATOR:
			if (adminFacade.login(email, password) == true) {
				System.out.println("Logged In As ADMINISTRATOR");
				return adminFacade;
			} else
				System.out.println("Access Denied");
			return null;

		case COMPANY:
			if (companyFacade.login(email, password) == true) {
				System.out.println("Logged In As COMPANY");
				return companyFacade;
			} else
				System.out.println("Accsess Denied");
			return null;

		case CUSTOMER:
			if (customerFacade.login(email, password) == true) {
				System.out.println("Logged In As CUSTOMER");
				return customerFacade;
			} else
				System.out.println("Access Denied");
			return null;
		}
		return null;
	}
}
