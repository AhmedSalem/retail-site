package com.salem.lap.assignment.retailsite.entity;

/**
 * @author AhmedSalem
 *
 */
public enum UserType {

	EMOLOYEE(1, 30), AFFILIATE(2, 10), OLD_CUSTOMER(3, 5);

	private final int typeId;
	private final int discPercentage;

	/**
	 * 
	 */
	private UserType(Integer type, Integer discPercentage) {
		this.typeId = type;
		this.discPercentage = discPercentage;
	}

	public int getDiscountPercentage() {
		return this.discPercentage;
	}

	public int getUserTypeId() {
		return this.typeId;
	}

}
