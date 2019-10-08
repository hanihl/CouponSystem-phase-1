package com.hani.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hani.beans.Customer;
import com.hani.connectionPool.ConnectionPool;
import com.hani.exception.CouponSystemException;

/**
 * 
 * @author Hleihil a class that allows us to make CRUD operations on the DB. it
 *         takes java beans classes or primitive values as arguments and makes
 *         sql queries from it. these classes use connectionPool in order to
 *         make a connection to the DB to make other actions
 */
public class CustomersDBDAO implements CustomersDAO {

	@Override
	public boolean isCustomerExists(String email, String password) throws CouponSystemException {
		String sql = "select * from customers where email=? and password=?";
		boolean isCustomerExists = false;
		Connection con = ConnectionPool.getInstance().getConnection();
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();

			isCustomerExists = rs.next();
			System.out.println("Customer: " + rs.getString("first_name") + " " + rs.getString("last_name") + ", "
					+ "id: " + rs.getInt("id") + "-->" + "  Exists");
		} catch (Exception e) {
			throw new CouponSystemException("No such customer Exists", e);
		} finally {
			ConnectionPool.getInstance().restoreConnection(con);
		}
		return isCustomerExists;
	}

	@Override
	public void addCustomer(Customer customer) throws CouponSystemException {
		String sql = "insert into customers (first_name, last_name, email, password) values (?, ?, ?, ?)";
		Connection con = ConnectionPool.getInstance().getConnection();
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, customer.getFirst_name());
			pstmt.setString(2, customer.getLast_name());
			pstmt.setString(3, customer.getEmail());
			pstmt.setString(4, customer.getPassword());
			pstmt.executeUpdate();
			System.out.println(
					"Customer: " + customer.getFirst_name() + " " + customer.getLast_name() + " Added Successfully");
		} catch (SQLException e) {
			throw new CouponSystemException("Error Adding Customer", e);
		} finally {
			ConnectionPool.getInstance().restoreConnection(con);
		}

	}

	@Override
	public void updateCustomer(Customer customer) throws CouponSystemException {
		String sql = "update customers set first_name=?, last_name=?, email=?, password=? where id=?";
		Connection con = ConnectionPool.getInstance().getConnection();
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, customer.getFirst_name());
			pstmt.setString(2, customer.getLast_name());
			pstmt.setString(3, customer.getEmail());
			pstmt.setString(4, customer.getPassword());
			pstmt.setInt(5, customer.getId());
			if (pstmt.executeUpdate() != 0) {
				System.out.println("Customer Updated successfully");
			} else {
				System.out.println("Customer update failed");
			}
		} catch (SQLException e) {
			throw new CouponSystemException("Error-Customer Failed to Update", e);
		} finally {
			ConnectionPool.getInstance().restoreConnection(con);
		}

	}

	@Override
	public void deleteCustomer(int cusotmerID) throws CouponSystemException {
		String sql = "delete from customers where id=?";
		Connection con = ConnectionPool.getInstance().getConnection();
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, cusotmerID);
			if (pstmt.executeUpdate() != 0) {
				System.out.println("customer deleted successfully");
			} else {
				System.out.println("delete customer failed");
			}
		} catch (SQLException e) {
			throw new CouponSystemException("Error-failed to delete ");
		} finally {
			ConnectionPool.getInstance().restoreConnection(con);
		}
	}

	@Override
	public List<Customer> getAllCustomers() throws CouponSystemException {
		String sql = "select * from customers";
		List<Customer> allCustomers = new ArrayList<Customer>();
		Customer customer = new Customer();
		Connection con = ConnectionPool.getInstance().getConnection();
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			ResultSet rs = pstmt.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					customer.setId(rs.getInt("id"));
					customer.setFirst_name(rs.getString("first_name"));
					customer.setLast_name(rs.getString("last_name"));
					customer.setEmail(rs.getString("email"));
					customer.setPassword(rs.getString("password"));
					allCustomers.add(customer);
					System.out.println(customer);
				}
			}

		} catch (SQLException e) {
			throw new CouponSystemException("Can't retreive customers Info", e);

		} finally {
			ConnectionPool.getInstance().restoreConnection(con);
		}

		return allCustomers;
	}

	@Override
	public Customer getOneCustomer(int customerID) throws CouponSystemException {
		String sql = "select * from customers where id=?";
		Customer customer = new Customer();
		Connection con = ConnectionPool.getInstance().getConnection();
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, customerID);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next() == true) {
				customer.setId(rs.getInt("id"));
				customer.setFirst_name(rs.getString("first_name"));
				customer.setLast_name(rs.getString("last_name"));
				customer.setEmail(rs.getString("email"));
				customer.setPassword(rs.getString("password"));
				System.out.println(customer);

			} else {
				System.out.println("Customer id not found");
			}
		} catch (SQLException e) {
			throw new CouponSystemException("Error-Cant find Customer's Info ", e);
		} finally {
			ConnectionPool.getInstance().restoreConnection(con);
		}
		return customer;

	}

	@Override
	public int getCustomerIdByEmail(String email) throws CouponSystemException {
		String sql = "select id from customers where email=?";
		Connection con = ConnectionPool.getInstance().getConnection();
		Customer customer = new Customer();
		int customerID = customer.getId();
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next() == true) {
				customer.setId(rs.getInt("id"));
				System.out.println("Customer ID: " + customer.getId());
			} else
				System.out.println("Email not Found");
		} catch (SQLException e) {
			throw new CouponSystemException("Error-an error just occured");
		} finally {
			ConnectionPool.getInstance().restoreConnection(con);
		}
		return customer.getId();

	}

}
