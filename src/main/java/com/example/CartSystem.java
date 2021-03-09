package com.example;

import java.util.Map;

public class CartSystem extends TheSystem {
    CartSystem() {
    	
    }

    @Override
    public void display() {
    	 // display cart items
    	final double TAX_RATE = 0.05;
    	double total = 0;
    	double tax =0;
    	String header = "Cart:";
        System.out.printf("%-20s%-20s%-20s%-10s%-10s%-10s\n",header,"Name","Description","Price", "Quantity","Sub Total");
    	for(Item itemInTheCart : getItemCollection().values()) {
    		double sub_total = itemInTheCart.getItemPrice() * itemInTheCart.getQuantity();
    		total += sub_total;
    		System.out.format("%-20s%-20s%-20s%-10.2f%-10d%-10.2f\n", " ",itemInTheCart.getItemName(), itemInTheCart.getItemDesc(), itemInTheCart.getItemPrice(), itemInTheCart.getQuantity(),sub_total);
    	}
    	tax = total * TAX_RATE;
    	double Post_tax_total = total + tax;
    	System.out.format("%-20s%-20.2f\n", "Pre-tax Total", total);
    	System.out.format("%-20s%-20.2f\n", "Tax", tax);
    	System.out.format("%-20s%-20.2f\n", "Total", Post_tax_total);
    }
}
