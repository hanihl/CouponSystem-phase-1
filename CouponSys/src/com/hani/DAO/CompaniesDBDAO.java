package com.hani.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hani.beans.Company;
import com.hani.connectionPool.ConnectionPool;
import com.hani.exception.CouponSystemException;

/**
 * 
 * @author Hleihil a class that allows us to make CRUD operations ont the DB. it
 *         takes java beans classes or primitive values as arguments and makes
 *         sql queries from it. these classes use connectionPool in order to
 *         make a connection to the DB to make other actions
 */
public class CompaniesDBDAO implements CompaniesDAO {

	@Override
	public boolean isCompanyExists(String email, String password) throws CouponSystemException {
		String sql = "SELECT * FROM companies WHERE email = ? and password = ?";
		boolean isCompanyExists = false;
		Connection conn = ConnectionPool.getInstance().getConnection();
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, email);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();

			isCompanyExists = rs.next();
			System.out.println(
					"the Company: " + rs.getString("name") + ", " + "id:" + rs.getInt("id") + "-->" + "  Exists");
		} catch (Exception e) {
			throw new CouponSystemException("company does not exist", e);
		} finally {
			ConnectionPool.getInstance().restoreConnection(conn);
		}
		return isCompanyExists;
	}

	@Override
	public void addCompany(Company company) throws CouponSystemException {
		String sql = " insert into companies (name, email, password) values (?,?,?)";
		Connection con = ConnectionPool.getInstance().getConnection();
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, company.getName());
			pstmt.setString(2, company.getEmail());
			pstmt.setString(3, company.getPassword());
			pstmt.executeUpdate();
			System.out.println("Company " + company.getName() + " Added Successfully");
		} catch (SQLException e) {
			throw new CouponSystemException("Error-Company Not Added Properly", e);
		} finally {
			ConnectionPool.getInstance().restoreConnection(con);
		}

	}

	@Override
	public void updateCompany(Company company) throws CouponSystemException {

		String sql = "update companies set name=?, email=?, password=? where id=?";
		Connection con = ConnectionPool.getInstance().getConnection();

		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, company.getName());
			pstmt.setString(2, company.getEmail());
			pstmt.setString(3, company.getPassword());
			pstmt.setInt(4, company.getId());
			if (pstmt.executeUpdate() != 0) {
				System.out.println("company updated successfully");
			} else {
				System.out.println("failed to update company");
			}

		} catch (Exception e) {
			throw new CouponSystemException("Error-Can not update company ", e);
		} finally {
			ConnectionPool.getInstance().restoreConnection(con);
		}

	}

	@Override
	public void deleteCompany(int companyID) throws CouponSystemException {
		String sql = "delete from companies where id=?";
		Connection con = ConnectionPool.getInstance().getConnection();
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, companyID);
			if (pstmt.executeUpdate() != 0) {
				System.out.println("Company DELETED Successfully");
			} else {
				System.out.println("Error-deleting company failed, no such company exist");
			}
		} catch (

		SQLException e) {
			throw new CouponSystemException("Error-failed to delete company !", e);
		} finally {
			ConnectionPool.getInstance().restoreConnection(con);
		}

	}

	@Override
	public Company getOneCompany(int companyID) throws CouponSystemException {
		Connection con = ConnectionPool.getInstance().getConnection();
		Company company = new Company();
		String sql = "select * from companies where id = ?";
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, companyID);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next() == true) {

				company.setId(rs.getInt("id"));
				company.setName(rs.getString("name"));
				company.setEmail(rs.getString("email"));
				company.setPassword(rs.getString("password"));
				System.out.println(company);
			} else {
				System.out.println("there is no such company in the DB");
			}
		} catch (SQLException e) {
			throw new CouponSystemException("Error-cannot get company info", e);
		} finally {
			ConnectionPool.getInstance().restoreConnection(con);
		}
		return company;
	}

	@Override
	public List<Company> getAllCompanies() throws CouponSystemException {
		String sql = "select * from companies";
		List<Company> allCompanies = new ArrayList<Company>();
		Connection con = ConnectionPool.getInstance().getConnection();
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			ResultSet rs = pstmt.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Company company = new Company();
					company.setId(rs.getInt(1));
					company.setName(rs.getString(2));
					company.setEmail(rs.getString(3));
					company.setPassword(rs.getString(4));
					allCompanies.add(company);
					System.out.println(company);
				}
			}
		} catch (SQLException e) {
			throw new CouponSystemException("cannot get allCompanies", e);
		} finally {
			ConnectionPool.getInstance().restoreConnection(con);
		}
		return allCompanies;
	}

	@Override
	public int getCompanyidByEmail(String email) throws CouponSystemException {
		String sql = "select id from companies where email=?";
		Connection con = ConnectionPool.getInstance().getConnection();
		Company company = new Company();
		int companyID = company.getId();
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next() == true) {
				company.setId(rs.getInt("id"));
				System.out.println("Company ID: " + company.getId());
			} else {
				System.out.println("no such Email in the DB");
			}
		} catch (SQLException e) {
			throw new CouponSystemException("an error just occured");
		} finally {
			ConnectionPool.getInstance().restoreConnection(con);
		}
		return company.getId();

	}

}
