/**
 * 
 */
package com.salem.lap.assignment.retailsite.entity;

/**
 * @author AhmedSalem
 *
 */

public class User {

	private String firstName;
	private String lastName;
	private String telephone;
	private UserType userType;

	/**
	 * @param firstName
	 * @param lastName
	 * @param telephone
	 * @param userType
	 */
	public User(String firstName, String lastName, String telephone, UserType userType) {
		super();
		setFirstName(firstName);
		setLastName(lastName);
		setTelephone(telephone);
		setUserType(userType);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public UserType getUserType() {
		return userType;
	}

	@Override
	public String toString() {
		return "[firstName=" + getFirstName() + ", lastName=" + getLastName() + ", telephone=" + getTelephone()
				+ ", userType=" + getUserType() + "]";
	}

}
