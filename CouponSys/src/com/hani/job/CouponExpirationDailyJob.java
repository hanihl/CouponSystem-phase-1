package com.hani.job;

import java.util.Collection;

import com.hani.DAO.CouponsDAO;
import com.hani.DAO.CouponsDBDAO;
import com.hani.beans.Coupon;
import com.hani.exception.CouponSystemException;

/**
 * This Class defines
 * 
 * @author Hleihil
 *
 */
public class CouponExpirationDailyJob implements Runnable {
	/**
	 * CouponsDAO object used for performing actions on the DataBase
	 */
	private CouponsDAO couponsDao;

	/** if quit==true the program stops */
	private boolean quit;

	Thread thread;

	public void setThread(Thread thread) {
		this.thread = thread;
	}

	public CouponExpirationDailyJob() {
		this.couponsDao = new CouponsDBDAO();
		this.quit = false;
	}

	/** this method is used for starting the DailyJob */
	@Override
	public void run() {
		System.out.println("thread started");
		while (quit == false) {
			System.out.println("delete expired started");
			try {
				Collection<Coupon> list = couponsDao.getExpiredCoupons();
				for (Coupon coupon : list) {
					couponsDao.deleteCouponPurchase(coupon.getId());
					couponsDao.deleteCoupon(coupon.getId());
				}
				Thread.sleep(1000 * 60 * 60 * 24);
			} catch (CouponSystemException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				break;
			}

		}
		System.out.println("thread terminated");

	}

	/**
	 * this method is used to stop the dailyJob
	 */
	public void stop() {
		quit = true;
		thread.interrupt();

	}

}
