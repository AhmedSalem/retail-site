/**
 * 
 */
package com.salem.lap.assignment.retailsite.builder;

import java.util.List;

import com.salem.lap.assignment.retailsite.entity.Bill;
import com.salem.lap.assignment.retailsite.entity.ShoppingItem;
import com.salem.lap.assignment.retailsite.entity.ShoppingItemCategory;
import com.salem.lap.assignment.retailsite.entity.User;

/**
 * @author AhmedSalem
 *
 */
public class RetailSiteBill implements BillOperations {

	private Bill userBill;

	private User user;

	/*
	 * Init User Info and Bill
	 */
	@Override
	public void collectUserInfo(User user) {

		userBill = new Bill();

		this.user = user;

	}


	
	/*
	 *  This function used to prepare shopping list for bill calculation
	 * @param shoopingItemList list of item user buy
	 * 
	 * @return total bill cost
	 */
	@Override
	public Double collectPurchasedItems(List<ShoppingItem> shoopingItemList) {

		userBill.setShoopingItemList(shoopingItemList);

		return getTotalBillCost(shoopingItemList);

	}

	/*
	 * This function to calculate shopping cost for all items
	 * 
	 * @param shoopingItemList list of item user buy
	 * 
	 * @return total bill cost
	 */
	private Double getTotalBillCost(List<ShoppingItem> shoopingItemList) {
		Double cost = 0.0;

		for (ShoppingItem shoppingItem : shoopingItemList) {
			cost += shoppingItem.getItemCost();
		}
		return cost;
	}

	/**
	 * This function user to apply discount per user segment as the following
	 * Employee of the store, he gets a 30% discount 
	 * Affiliate of the store, he gets a 10% discount 
	 * Customer for over 2 years, he gets a 5% discount
	 * 
	 * @param shoopingItemList  list of item user buy
	 * @return total bill cost after user type discount
	 */
	@Override
	public Double userTypeDiscountApply(Double cost) {
		userBill.setTotalBill(cost);
		Double discountAmount = 0.0;
		int discountPercentage = user.getUserType().getDiscountPercentage();
		Double groceriesAmount = getGroceriedItemCost(userBill.getShoopingItemList());
		System.out.println("Total Bill Amount is :" + userBill.getTotalBill());
		System.out.println(
				"User Type is: " + user.getUserType().getUserTypeId() + "Discount: " + discountPercentage + " %");

		System.out.println("Total GROCERIES items is :" + groceriesAmount);
		discountAmount = (cost - groceriesAmount);
		System.out.println("Total Bill Amount Without GROCERIES is :" + discountAmount);

		discountAmount = ((discountAmount * discountPercentage) / 100);
		System.out.println("Total user Type discount Amount: " + discountAmount);

		userBill.setTotalBillAfterUserTypeDiscount(cost - discountAmount);

		System.out.println(
				"Total Bill Amount After User Type Discount is :" + userBill.getTotalBillAfterUserTypeDiscount());

		return userBill.getTotalBillAfterUserTypeDiscount();
	}

	/*
	 * This function used to calculate final discount on bill using the following
	 * For every $100 on the bill, there would be a $ 5 discount (e.g. for $ 990, you get $ 45 as a discount).
	 * 
	 * @param billCost after apply first discount for user type
	 * @return final bill amount after apply discount
	 */
	@Override
	public Double totalBillDiscountApply(Double billCost) {

		System.out.println("Bill Amount Beofre Final Discount is : " + billCost);

		// Decrease 5 for each 100
		userBill.setFinalbillCost(billCost - (Math.floor(Math.floor(billCost) / 100) * 5));
		System.out.println("Bill Amount After Final Discount is : " + userBill.getFinalbillCost());

		return userBill.getFinalbillCost();

	}

	/*
	 * This function used to return the total of grocieres items
	 * 
	 * @param shoopingItemList  list of item user buy
	 * @return cost of groceries items
	 */
	@Override
	public Double getGroceriedItemCost(List<ShoppingItem> shoopingItemList) {
		Double cost = 0.0;
		for (ShoppingItem shoppingItem : userBill.getShoopingItemList()) {
			if (shoppingItem.getCategory().equals(ShoppingItemCategory.GROCERIES)) {
				cost += shoppingItem.getItemCost();
			}
		}

		return cost;
	}

	/*
	 * This function used to print full trace of bill statment
	 * @param Bill 
	 * 
	 */
	@Override
	public String printBillDetails(Bill bill) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("User Details:");
		stringBuilder.append(user.toString());
		stringBuilder.append("Shop the following:");
		stringBuilder.append(bill.getShoopingItemList().toString());
		stringBuilder.append(" Total Bill Amount : ");
		stringBuilder.append(bill.getTotalBill());
		stringBuilder.append(" Bill Amount After User Discount:");
		stringBuilder.append(bill.getTotalBillAfterUserTypeDiscount());
		stringBuilder.append(" Bill Amount After final Discount:");
		stringBuilder.append(bill.getFinalbillCost());
		return stringBuilder.toString();

	}

}
