package com.hani.beans;

import java.util.ArrayList;

/**
 * 
 * @author Hleihil
 *
 */
public class Customer {
	/**
	 * attributes
	 */
	private int id;
	private String first_name;
	private String last_name;
	private String email;
	private String password;
	private ArrayList<Coupon> coupons;

	/**
	 * Ctors
	 * 
	 * @param idCustomer's id sent to the ctor.
	 * @param first_name   Customer's firstName sent to the ctor.
	 * @param last_name    Customer's lastName sent to the ctor.
	 * @param email        Customer's email sent to the ctor.
	 * @param password     Customer's password sent to the ctor.
	 * @param coupons      Customer's Coupons's array sent to the ctor.
	 */
	public Customer() {
		super();
	}

	public Customer(int id) {
		this.id = id;
	}

	public Customer(int id, String first_name, String last_name, String email, String password,
			ArrayList<Coupon> coupons) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
		this.coupons = coupons;
	}

	public Customer(String first_name, String last_name, String email, String password, ArrayList<Coupon> coupons) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
		this.coupons = coupons;
	}

	public Customer(String first_name, String last_name, String email, String password) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
	}

	/**
	 * Getters & Setters
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<Coupon> getCoupons() {
		return coupons;
	}

	public void setCoupons(ArrayList<Coupon> coupons) {
		this.coupons = coupons;
	}

	/**
	 * HashCode
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coupons == null) ? 0 : coupons.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result + id;
		result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	/**
	 * Equals
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Customer)) {
			return false;
		}
		Customer other = (Customer) obj;
		if (coupons == null) {
			if (other.coupons != null) {
				return false;
			}
		} else if (!coupons.equals(other.coupons)) {
			return false;
		}
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (first_name == null) {
			if (other.first_name != null) {
				return false;
			}
		} else if (!first_name.equals(other.first_name)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (last_name == null) {
			if (other.last_name != null) {
				return false;
			}
		} else if (!last_name.equals(other.last_name)) {
			return false;
		}
		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
			return false;
		}
		return true;
	}

	/**
	 * toString
	 */
	@Override
	public String toString() {
		return "Customer With ID number of " + id + ":\n" + " ID: " + this.id + "\n" + " First Name: " + this.first_name
				+ "\n" + " Last Name: " + this.last_name + "\n" + " Email: " + this.email + "\n" + " Password: "
				+ this.password + "\n" + " Coupons: " + this.coupons + "\n\n";
	}

}
