package com.hani.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.hani.beans.Category;
import com.hani.beans.Coupon;
import com.hani.connectionPool.ConnectionPool;
import com.hani.exception.CouponSystemException;

/**
 * 
 * @author Hleihil a class that allows us to make CRUD operations on the DB. it
 *         takes java beans classes or primitive values as arguments and makes
 *         sql queries from it. these classes use connectionPool in order to
 *         make a connection to the DB to make other actions
 */
public class CouponsDBDAO implements CouponsDAO {

	@Override
	public void addCoupon(Coupon coupon) throws CouponSystemException {
		String sql = "insert into coupons(company_id,category_id, title, description," + "start_date,end_date,"
				+ "amount,price,image)values(?,?,?,?,?,?,?,?,?)";
		Connection con = ConnectionPool.getInstance().getConnection();
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, coupon.getCompanyID());
			pstmt.setInt(2, coupon.getCategory_id().ordinal());
			pstmt.setString(3, coupon.getTitle());
			pstmt.setString(4, coupon.getDescription());
			pstmt.setString(5, coupon.getStartDate().toString());
			pstmt.setString(6, coupon.getEndDate().toString());
			pstmt.setInt(7, coupon.getAmount());
			pstmt.setDouble(8, coupon.getPrice());
			pstmt.setString(9, coupon.getImage());

			pstmt.executeUpdate();

		} catch (

		SQLException e) {

			throw new CouponSystemException("failed to add coupon !", e);
		} finally {
			ConnectionPool.getInstance().restoreConnection(con);
		}
	}

	@Override
	public void updateCoupon(Coupon coupon) throws CouponSystemException {
		String sql = "update coupons set company_id=?," + " category_id=?," + "" + "title=?, description=?,"
				+ " start_date=?," + "end_date=?, amount=?, price=?, image=?" + "where id=?";
		Connection con = ConnectionPool.getInstance().getConnection();
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, coupon.getCompanyID());
			pstmt.setInt(2, coupon.getCategory_id().ordinal());
			pstmt.setString(3, coupon.getTitle());
			pstmt.setString(4, coupon.getDescription());
			pstmt.setString(5, coupon.getStartDate().toString());
			pstmt.setString(6, coupon.getEndDate().toString());
			pstmt.setInt(7, coupon.getAmount());
			pstmt.setDouble(8, coupon.getPrice());
			pstmt.setString(9, coupon.getImage());
			pstmt.setInt(10, coupon.getId());
			pstmt.executeUpdate();
		} catch (

		SQLException e) {
			throw new CouponSystemException("Error-Updating Coupon Failed,!", e);
		} finally {
			ConnectionPool.getInstance().restoreConnection(con);
		}
	}

	@Override
	public void deleteCoupon(int couponID) throws CouponSystemException {
		String sql = " delete from coupons where id =? ";
		Connection con = ConnectionPool.getInstance().getConnection();
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, couponID);
			if (pstmt.executeUpdate() == 0) {
				System.out.println("failed to delete coupon " + couponID);
			} else {
				System.out.println("Coupon Deleted!");
			}
		} catch (SQLException e) {
			throw new CouponSystemException("Error-Failed to delete coupon", e);
		} finally {
			ConnectionPool.getInstance().restoreConnection(con);
		}

	}

	@Override
	public List<Coupon> getAllCoupons() throws CouponSystemException {
		Coupon coupon = new Coupon();
		List<Coupon> allCoupons = new ArrayList<Coupon>();
		Connection con = ConnectionPool.getInstance().getConnection();
		String sql = "select * from coupons";
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			ResultSet rs = pstmt.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					coupon.setId(rs.getInt("id"));
					coupon.setCompanyID(rs.getInt("company_id"));
					coupon.setCategory_id((com.hani.beans.Category.values()[rs.getInt("category_id")]));
					coupon.setTitle(rs.getString("title"));
					coupon.setDescription(rs.getString("description"));
					coupon.setStartDate(LocalDate.parse(rs.getString("start_date")));
					coupon.setEndDate(LocalDate.parse(rs.getString("end_date")));
					coupon.setAmount(rs.getInt("amount"));
					coupon.setPrice(rs.getDouble("price"));
					coupon.setImage(rs.getString("image"));

					allCoupons.add(coupon);
//					System.out.println(coupon);
				}
			}

		} catch (SQLException e) {
			throw new CouponSystemException("Failed to retrieve Coupons !", e);
		} finally {
			ConnectionPool.getInstance().restoreConnection(con);
		}
		return allCoupons;

	}

	@Override
	public Coupon getOneCoupon(int couponID) throws CouponSystemException {
		Connection con = ConnectionPool.getInstance().getConnection();
		String sql = "select * from coupons where id=?";
		Coupon coupon = new Coupon();
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, couponID);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next() == true) {
				coupon.setId(rs.getInt("id"));
				coupon.setCompanyID(rs.getInt("company_id"));
				coupon.setCategory_id((Category.values()[rs.getInt("category_id")]));
				coupon.setTitle(rs.getString("title"));
				coupon.setDescription(rs.getString("description"));
				coupon.setStartDate(LocalDate.parse(rs.getString("start_date")));
				coupon.setEndDate(LocalDate.parse(rs.getString("end_date")));
				coupon.setAmount(rs.getInt("amount"));
				coupon.setPrice(rs.getDouble("price"));
				coupon.setImage(rs.getString("image"));
//				System.out.println(coupon);
			} else {
				System.out.println("can not get coupon");
			}
		} catch (SQLException e) {

			throw new CouponSystemException("Error-Can't get coupon", e);
		} finally {
			ConnectionPool.getInstance().restoreConnection(con);

		}
		return coupon;
	}

	@Override
	public void addCouponPurchase(int customerID, int couponID) throws CouponSystemException {
		Connection con = ConnectionPool.getInstance().getConnection();
		String sql = "insert into customers_vs_coupons(customer_id, coupon_id) values (?, ?)";

		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, customerID);
			pstmt.setInt(2, couponID);
			if (pstmt.executeUpdate() != 0) {

				System.out.println("Coupon Purchased!");
			} else {
				System.out.println("failed to addCouponPurchase");
			}
		} catch (SQLException e) {
			throw new CouponSystemException("Error-Failed to purchase Coupon", e);
		} finally {
			ConnectionPool.getInstance().restoreConnection(con);
		}
	}

	@Override
	public void deleteCouponPurchase(int customerID, int couponID) throws CouponSystemException {
		String sql = "delete from customers_vs_coupons where customer_id=? and coupon_id=?";
		Connection con = ConnectionPool.getInstance().getConnection();
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, customerID);
			pstmt.setInt(2, couponID);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new CouponSystemException("Error-Failed to delete couponPurchase", e);
		} finally {
			ConnectionPool.getInstance().restoreConnection(con);
		}

	}

	@Override
	public void deleteCouponPurchase(int couponID) throws CouponSystemException {
		String sql = "delete from customers_vs_coupons where coupon_id=?";
		Connection con = ConnectionPool.getInstance().getConnection();
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, couponID);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new CouponSystemException("Error-Failed to delete couponPurchase", e);
		} finally {
			ConnectionPool.getInstance().restoreConnection(con);
		}

	}

	@Override
	public List<Coupon> getCouponsByCompanyID(int companyID) throws CouponSystemException {
		String sql = "select * from coupons where company_id=?";
		List<Coupon> allCoupons = new ArrayList<Coupon>();
		Connection con = ConnectionPool.getInstance().getConnection();
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, companyID);
			ResultSet rs = pstmt.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Coupon coupon = new Coupon();
					coupon.setId(rs.getInt("id"));
					coupon.setCompanyID(rs.getInt("company_id"));
					coupon.setCategory_id((Category.values()[rs.getInt("category_id")]));
					coupon.setTitle(rs.getString("title"));
					coupon.setDescription(rs.getString("description"));
					coupon.setStartDate(LocalDate.parse(rs.getString("start_date")));
					coupon.setEndDate(LocalDate.parse(rs.getString("end_date")));
					coupon.setAmount(rs.getInt("amount"));
					coupon.setPrice(rs.getDouble("price"));
					coupon.setImage(rs.getString("image"));

					allCoupons.add(coupon);
//					System.out.println(coupon);
				}
			}
		} catch (SQLException e) {
			throw new CouponSystemException("Error-cannot get allCoupons", e);
		} finally {
			ConnectionPool.getInstance().restoreConnection(con);
		}
		return allCoupons;
	}

	@Override
	public List<Coupon> getCouponsByCustomerID(int customerID) throws CouponSystemException {
		String sql = "SELECT coupons.* FROM coupons inner join customers_vs_coupons on coupons.id = customers_vs_coupons.coupon_id where customers_vs_coupons.customer_id = ?";
		List<Coupon> allCoupons = new ArrayList<Coupon>();
		Connection con = ConnectionPool.getInstance().getConnection();
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, customerID);
			ResultSet rs = pstmt.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Coupon coupon = new Coupon();
					coupon.setId(rs.getInt("id"));
					coupon.setCompanyID(rs.getInt("company_id"));
					coupon.setCategory_id((Category.values()[rs.getInt("category_id")]));
					coupon.setTitle(rs.getString("title"));
					coupon.setDescription(rs.getString("description"));
					coupon.setStartDate(LocalDate.parse(rs.getString("start_date")));
					coupon.setEndDate(LocalDate.parse(rs.getString("end_date")));
					coupon.setAmount(rs.getInt("amount"));
					coupon.setPrice(rs.getDouble("price"));
					coupon.setImage(rs.getString("image"));

					allCoupons.add(coupon);
//					System.out.println(coupon);
				}
			}
		} catch (SQLException e) {
			throw new CouponSystemException("Error-cannot get allCoupons", e);
		} finally {
			ConnectionPool.getInstance().restoreConnection(con);
		}
		return allCoupons;
	}

	@Override
	public void deleteAllCompanyCoupons(int companyID) throws CouponSystemException {
		String sql = "delete from coupons where company_id=?";
		Connection con = ConnectionPool.getInstance().getConnection();
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, companyID);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new CouponSystemException("Error-delete company coupons Failed!", e);
		} finally {
			ConnectionPool.getInstance().restoreConnection(con);
		}

	}

	@Override
	public void deleteCouponPurchaseByCustomer(int customerID) throws CouponSystemException {
		String sql = " delete from customers_vs_coupons where customer_id =? ";
		Connection con = ConnectionPool.getInstance().getConnection();
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, customerID);
			if (pstmt.executeUpdate() == 0) {
				System.out.println("failed to delete coupon");
			} else {
				System.out.println("Coupon Deleted!");
			}
		} catch (SQLException e) {
			throw new CouponSystemException("Error-Failed to delete coupon", e);
		} finally {
			ConnectionPool.getInstance().restoreConnection(con);
		}

	}

	@Override
	public List<Coupon> getExpiredCoupons() throws CouponSystemException {
		String sql = "select * from coupons where end_date <now();";
		List<Coupon> allCoupons = new ArrayList<Coupon>();
		Connection con = ConnectionPool.getInstance().getConnection();
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			ResultSet rs = pstmt.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Coupon coupon = new Coupon();
					coupon.setId(rs.getInt("id"));
					coupon.setCompanyID(rs.getInt("company_id"));
					coupon.setCategory_id((Category.values()[rs.getInt("category_id")]));
					coupon.setTitle(rs.getString("title"));
					coupon.setDescription(rs.getString("description"));
					coupon.setStartDate(LocalDate.parse(rs.getString("start_date")));
					coupon.setEndDate(LocalDate.parse(rs.getString("end_date")));
					coupon.setAmount(rs.getInt("amount"));
					coupon.setPrice(rs.getDouble("price"));
					coupon.setImage(rs.getString("image"));

					allCoupons.add(coupon);
					System.out.println(coupon);
				}
			}

		} catch (SQLException e) {
			throw new CouponSystemException("Error-cannot get allCoupons", e);
		} finally {
			ConnectionPool.getInstance().restoreConnection(con);
		}
		return allCoupons;
	}

}
