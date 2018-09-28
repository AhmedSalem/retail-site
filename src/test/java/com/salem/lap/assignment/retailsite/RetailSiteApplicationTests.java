package com.salem.lap.assignment.retailsite;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.salem.lap.assignment.retailsite.builder.BillBuilder;
import com.salem.lap.assignment.retailsite.builder.RetailSiteBill;
import com.salem.lap.assignment.retailsite.builder.UserBuilder;
import com.salem.lap.assignment.retailsite.entity.Bill;
import com.salem.lap.assignment.retailsite.entity.ShoppingItem;
import com.salem.lap.assignment.retailsite.entity.ShoppingItemCategory;
import com.salem.lap.assignment.retailsite.entity.User;
import com.salem.lap.assignment.retailsite.entity.UserType;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RetailSiteApplicationTests {

	@Mock
	Bill userBill;

	@Autowired
	UserBuilder userBilder;

	@Autowired
	BillBuilder billBilder;

	@Mock
	List<ShoppingItem> shoopingItemList;

	@InjectMocks
	RetailSiteBill retailSite;

	@Before
	public void before() {
		System.out.println("Before");

		shoopingItemList = new ArrayList<ShoppingItem>();

		ShoppingItem item = new ShoppingItem();
		item.setItemName("Cat Food");
		item.setItemCost(300.50);
		item.setCount(1);
		item.setCategory(ShoppingItemCategory.ANIMALS_FOOD);
		shoopingItemList.add(item);

		item = new ShoppingItem();
		item.setItemName("Troser");
		item.setItemCost(100.00);
		item.setCount(1);
		item.setCategory(ShoppingItemCategory.CLOTHS);
		shoopingItemList.add(item);

		item = new ShoppingItem();
		item.setItemName("Frutes VEG");
		item.setItemCost(50.00);
		item.setCount(1);
		item.setCategory(ShoppingItemCategory.GROCERIES);
		shoopingItemList.add(item);

		item = new ShoppingItem();
		item.setItemName("TILD RICE 10KG");
		item.setItemCost(250.00);
		item.setCount(1);
		item.setCategory(ShoppingItemCategory.GROCERIES);
		shoopingItemList.add(item);

		item = new ShoppingItem();
		item.setItemName("Tomoto 1KG");
		item.setItemCost(20.00);
		item.setCount(1);
		item.setCategory(ShoppingItemCategory.GROCERIES);
		shoopingItemList.add(item);

		item = new ShoppingItem();
		item.setItemName("Iphone 6 plus");
		item.setItemCost(1200.999);
		item.setCount(1);
		item.setCategory(ShoppingItemCategory.ELECTRONICS);
		shoopingItemList.add(item);

		item = new ShoppingItem();
		item.setItemName("steck of wood");
		item.setItemCost(0.5);
		item.setCount(1);
		item.setCategory(ShoppingItemCategory.OTHER);
		shoopingItemList.add(item);

		item = new ShoppingItem();
		item.setItemName("Matt for BMW");
		item.setItemCost(30.5);
		item.setCount(1);
		item.setCategory(ShoppingItemCategory.CAR_ACCESSORIES);
		shoopingItemList.add(item);

		userBill = billBilder.totalBill(0.0).shoopingItemList(shoopingItemList).totalBillAfterUserTypeDiscount(0.0)
				.finalbillCost(0.0).Build();

	}

	@Test
	public void contextLoads() {
		System.out.println("---------- Context Loaded ----------");

	}

	@Test
	public void main() {
		RetailSiteApplication.main(new String[] {});
	}

	@Test
	// 30 % Discount
	public void testEmployeeSegmentDicount() {

		retailSite.collectUserInfo(userBilder.firstName("Omar").lastName("Hamed").telephone("971 025322412")
				.userType(UserType.EMOLOYEE).build());

		Double billCost = retailSite.collectPurchasedItems(shoopingItemList);

		Double billCostAfterDiscount = retailSite.userTypeDiscountApply(billCost);

		Double deductionAmount = (billCost - retailSite.getGroceriedItemCost(shoopingItemList));

		assertEquals(new Double(billCost - new Double((deductionAmount * 30) / 100)), billCostAfterDiscount);
	}

	@Test
	// 20 % Discount
	public void testAffelinateSegmentDicount() {
		retailSite.collectUserInfo(userBilder.firstName("Omar").lastName("Hamed").telephone("971 025322412")
				.userType(UserType.AFFILIATE).build());

		Double billCost = retailSite.collectPurchasedItems(shoopingItemList);

		Double billCostAfterDiscount = retailSite.userTypeDiscountApply(billCost);

		Double deductionAmount = (billCost - retailSite.getGroceriedItemCost(shoopingItemList));

		assertEquals(new Double(billCost - new Double((deductionAmount * 10) / 100)), billCostAfterDiscount);
	}

	@Test
	// 10% Discount
	public void testOldCustomerSegmentDicount() {
		retailSite.collectUserInfo(userBilder.firstName("Omar").lastName("Hamed").telephone("971 025322412")
				.userType(UserType.OLD_CUSTOMER).build());

		Double billCost = retailSite.collectPurchasedItems(shoopingItemList);

		Double billCostAfterDiscount = retailSite.userTypeDiscountApply(billCost);

		Double deductionAmount = (billCost - retailSite.getGroceriedItemCost(shoopingItemList));

		assertEquals(new Double(billCost - new Double((deductionAmount * 5) / 100)), billCostAfterDiscount);
	}

	@Test
	public void testCollectPurchasedItems() {

		Double billCost = retailSite.collectPurchasedItems(shoopingItemList);
		assertEquals(new Double(1952.499), billCost);
	}

	@Test
	public void testFinalDicount() {

		retailSite.collectUserInfo(userBilder.firstName("Omar").lastName("Hamed").telephone("971 025322412")
				.userType(UserType.OLD_CUSTOMER).build());

		Double billCost = retailSite.collectPurchasedItems(shoopingItemList);

		Double billCostAfterDiscount = retailSite.userTypeDiscountApply(billCost);
		Double billCostAfterFinalDiscount = retailSite.totalBillDiscountApply(billCostAfterDiscount);

		Double expectedValue = billCostAfterDiscount - (Math.floor(Math.floor(billCostAfterDiscount) / 100) * 5);

		assertEquals(expectedValue, billCostAfterFinalDiscount);

	}

	@Test
	public void testOLD_CustomerUserType() {
		assertEquals(UserType.OLD_CUSTOMER, UserType.valueOf("OLD_CUSTOMER"));
	}
	
	public void testCustomerTypesValues() {
		assertEquals(3, UserType.values().length);
	}
	
	@Test
	public void testShoppingItemCategory() {
		assertEquals(ShoppingItemCategory.GROCERIES, ShoppingItemCategory.valueOf("GROCERIES"));
	}
	
	public void testShopingCategoryValues() {
		assertEquals(6, ShoppingItemCategory.values().length);
	}

	@Test
	public void testPrintBillStatment() {

		retailSite.collectUserInfo(userBilder.firstName("Omar").lastName("Hamed").telephone("971 025322412")
				.userType(UserType.OLD_CUSTOMER).build());

		Double billCost = retailSite.collectPurchasedItems(shoopingItemList);

		Double totalBillAfterUserTypeDiscount = retailSite.userTypeDiscountApply(billCost);
		Double billCostAfterFinalDiscount = retailSite.totalBillDiscountApply(totalBillAfterUserTypeDiscount);

		Bill myBill = billBilder.totalBill(billCost).totalBillAfterUserTypeDiscount(totalBillAfterUserTypeDiscount)
				.finalbillCost(billCostAfterFinalDiscount).shoopingItemList(shoopingItemList).Build();

		String expected = "User Details:[firstName=Omar, lastName=Hamed, telephone=971 025322412, userType=OLD_CUSTOMER]Shop the following:[[itemName=Cat Food, itemCost=300.5, count=1, category=ANIMALS_FOOD], [itemName=Troser, itemCost=100.0, count=1, category=CLOTHS], [itemName=Frutes VEG, itemCost=50.0, count=1, category=GROCERIES], [itemName=TILD RICE 10KG, itemCost=250.0, count=1, category=GROCERIES], [itemName=Tomoto 1KG, itemCost=20.0, count=1, category=GROCERIES], [itemName=Iphone 6 plus, itemCost=1200.999, count=1, category=ELECTRONICS], [itemName=steck of wood, itemCost=0.5, count=1, category=OTHER], [itemName=Matt for BMW, itemCost=30.5, count=1, category=CAR_ACCESSORIES]] Total Bill Amount : 1952.499 Bill Amount After User Discount:1870.8740500000001 Bill Amount After final Discount:1780.8740500000001";

		System.out.println("exp:" + expected);
		System.out.println("res:" + retailSite.printBillDetails(myBill));
		assertEquals(expected, retailSite.printBillDetails(myBill));
	}

}
