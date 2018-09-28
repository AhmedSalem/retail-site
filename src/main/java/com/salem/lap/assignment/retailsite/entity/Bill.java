/**
 * 
 */
package com.salem.lap.assignment.retailsite.entity;

import java.util.List;

/**
 * @author AhmedSalem
 *
 */
public class Bill {

	private List<ShoppingItem> shoopingItemList;
	private Double totalBill;
	private Double totalBillAfterUserTypeDiscount;
	private Double finalbillCost;

	/**
	 * 
	 */
	public Bill() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param user
	 * @param shoopingItemList
	 * @param totalBill
	 * @param totalBillAfterUserTypeDiscount
	 * @param finalbillCost
	 */
	public Bill(List<ShoppingItem> shoopingItemList, Double totalBill, Double totalBillAfterUserTypeDiscount,
			Double finalbillCost) {
		super();

		this.shoopingItemList = shoopingItemList;
		this.totalBill = totalBill;
		this.totalBillAfterUserTypeDiscount = totalBillAfterUserTypeDiscount;
		this.finalbillCost = finalbillCost;
	}

	public List<ShoppingItem> getShoopingItemList() {
		return shoopingItemList;
	}

	public void setShoopingItemList(List<ShoppingItem> shoopingItemList) {
		this.shoopingItemList = shoopingItemList;
	}

	public Double getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(Double totalBill) {
		this.totalBill = totalBill;
	}

	public Double getTotalBillAfterUserTypeDiscount() {
		return totalBillAfterUserTypeDiscount;
	}

	public void setTotalBillAfterUserTypeDiscount(Double totalBillAfterUserTypeDiscount) {
		this.totalBillAfterUserTypeDiscount = totalBillAfterUserTypeDiscount;
	}

	public Double getFinalbillCost() {
		return finalbillCost;
	}

	public void setFinalbillCost(Double finalbillCost) {
		this.finalbillCost = finalbillCost;
	}

}
