package com.hani.beans;

import java.util.ArrayList;

/**
 * 
 * @author Hleihil
 *
 *         java bean class with
 */
public class Company {
	/**
	 * attributes
	 */
	private int id;
	private String name;
	private String email;
	private String password;
	private ArrayList<Coupon> coupons;

	/**
	 * Company CTOR's
	 * 
	 * @param name     - company's name sent to the constructor
	 * @param email    - company's email sent to the constructor
	 * @param password - company's password sent to the constructor
	 * @param coupon   - company's array of coupons sent to the constructor
	 */
	public Company() {
		super();
	}

	public Company(int id) {
		this.id = id;
	}

	public Company(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public Company(String name, String email, String password, ArrayList<com.hani.beans.Coupon> coupons) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.coupons = coupons;
	}

	public Company(int id, String name, String email, String password, ArrayList<Coupon> coupons) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.coupons = coupons;
	}

	public Company(int id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	/**
	 * Getters & Setters
	 * 
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	 * HashCode & Equals
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Company)) {
			return false;
		}
		Company other = (Company) obj;
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
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
	 * ToString
	 * 
	 * @return the string representation of the object
	 */
	@Override
	public String toString() {
		return "Company With ID number of " + id + ";\n" + " ID: " + this.id + "\n" + " Name: " + this.name + "\n"
				+ " Email: " + this.email + "\n" + " Password: " + this.password + "\n" + " Coupons: " + this.coupons
				+ "\n\n";
	}

}
