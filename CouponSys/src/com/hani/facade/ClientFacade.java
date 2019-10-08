package com.hani.facade;

import com.hani.DAO.CompaniesDAO;
import com.hani.DAO.CouponsDAO;
import com.hani.DAO.CustomersDAO;

public abstract class ClientFacade {

	CompaniesDAO companiesDAO;
	CustomersDAO customersDAO;
	CouponsDAO couponsDAO;

}
