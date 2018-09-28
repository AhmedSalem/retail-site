/**
 * 
 */
package com.salem.lap.assignment.retailsite.builder;

import java.util.List;

import org.springframework.stereotype.Component;

import com.salem.lap.assignment.retailsite.entity.Bill;
import com.salem.lap.assignment.retailsite.entity.ShoppingItem;

/**
 * @author AhmedSalem
 *
 */
@Component
public class BillBuilder {

	private List<ShoppingItem> shoopingItemList;
	private Double totalBill;
	private Double totalBillAfterUserTypeDiscount;
	private Double finalbillCost;

	public BillBuilder shoopingItemList(List<ShoppingItem> shoopingItemList) {
		this.shoopingItemList = shoopingItemList;
		return this;
	}

	public BillBuilder totalBill(Double totalBill) {
		this.totalBill = totalBill;
		return this;

	}

	public BillBuilder totalBillAfterUserTypeDiscount(Double totalBillAfterUserTypeDiscount) {
		this.totalBillAfterUserTypeDiscount = totalBillAfterUserTypeDiscount;
		return this;
	}

	public BillBuilder finalbillCost(Double finalbillCost) {
		this.finalbillCost = finalbillCost;
		return this;
	}

	public Bill Build() {
		return new Bill(shoopingItemList, totalBill, totalBillAfterUserTypeDiscount, finalbillCost);
	}

}
