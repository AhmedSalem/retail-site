/**
 * 
 */
package com.salem.lap.assignment.retailsite.builder;

import java.util.List;

import com.salem.lap.assignment.retailsite.entity.Bill;
import com.salem.lap.assignment.retailsite.entity.ShoppingItem;
import com.salem.lap.assignment.retailsite.entity.User;

/**
 * @author AhmedSalem
 *
 */
public interface BillOperations {

	public void collectUserInfo(User user);

	public Double getGroceriedItemCost(List<ShoppingItem> shoopingItemList);

	public Double collectPurchasedItems(List<ShoppingItem> shoopingItemList);

	public Double userTypeDiscountApply(Double cost);

	public Double totalBillDiscountApply(Double cost);
	
	public String printBillDetails(Bill bill);

}
