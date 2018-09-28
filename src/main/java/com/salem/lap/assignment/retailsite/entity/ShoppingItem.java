/**
 * 
 */
package com.salem.lap.assignment.retailsite.entity;

/**
 * @author AhmedSalem
 *
 */
public class ShoppingItem {

	private String itemName;
	private Double itemCost;
	private int count;
	private ShoppingItemCategory category;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getItemCost() {
		return itemCost;
	}

	public void setItemCost(Double itemCost) {
		this.itemCost = itemCost;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public ShoppingItemCategory getCategory() {
		return category;
	}

	public void setCategory(ShoppingItemCategory category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "[itemName=" + getItemName() + ", itemCost=" + getItemCost() + ", count=" + getCount() + ", category="
				+ getCategory() + "]";
	}

}
