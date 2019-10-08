package com.hani.DAO;

import java.util.List;

import com.hani.beans.Company;
import com.hani.exception.CouponSystemException;

/**
 * 
 * @author Hleihil interface that will be implemented later
 */
public interface CompaniesDAO {

	/**
	 * this method checks if the company exists in the DB
	 * 
	 * @param email
	 * @param password
	 * @return
	 * @throws CouponSystemException
	 */
	public boolean isCompanyExists(String email, String password) throws CouponSystemException;

	/**
	 * this method takes company as parameter and add it to the DB
	 * 
	 * @param company
	 * @throws CouponSystemException
	 */
	public void addCompany(Company company) throws CouponSystemException;

	/**
	 * this method takes company as parameter and update it in the DB
	 * 
	 * @param company
	 * @throws CouponSystemException
	 */
	public void updateCompany(Company company) throws CouponSystemException;

	/**
	 * This method get Company and delete it in the Company table.
	 * 
	 * @param companyID
	 * @throws CouponSystemException
	 */
	public void deleteCompany(int companyID) throws CouponSystemException;

	/**
	 * this method get company by it's id from the DB and show it to us
	 * 
	 * @param companyID
	 * @return
	 * @throws CouponSystemException
	 */
	public Company getOneCompany(int companyID) throws CouponSystemException;

	/**
	 * this method returns all the companies exist in the DB
	 * 
	 * @return
	 * @throws CouponSystemException
	 */
	public List<Company> getAllCompanies() throws CouponSystemException;

	/**
	 * this method takes email as parameter and returns companyID
	 * 
	 * @param email
	 * @return
	 * @throws CouponSystemException
	 */
	public int getCompanyidByEmail(String email) throws CouponSystemException;

}
