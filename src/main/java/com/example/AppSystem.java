package com.example;

import java.util.Map;

public class AppSystem extends TheSystem {
    AppSystem() {
    	
    }

    @Override
    public void display() {
        // display the system items
    	String header = "App System Inventory:";
        System.out.printf("%-25s%-20s%-20s%-10s%-10s\n",header,"Name","Description","Price", "Available Quantity");
    	for(Item itemInTheSystem : getItemCollection().values()) {
    		System.out.format("%-25s%-20s%-20s%-10.2f%-10d\n", " ",itemInTheSystem.getItemName(), itemInTheSystem.getItemDesc(), itemInTheSystem.getItemPrice(), itemInTheSystem.getAvailableQuantity());
    	}
    	
    }

    @Override      // this overwrites the parents class add method 
    public Boolean add(Item item) {
        // add item to the system
    	if(item.equals(null)) {
    		return false;
    	}else if(getItemCollection().containsKey(item.getItemName())){
    		
    			 System.out.printf("already available????");
    			 return true;
    		
    	}else if(!getItemCollection().containsKey(item.getItemName())) {
    		getItemCollection().put(item.getItemName(), item);
    		return true;
    	}else {
    		return false;
    	}
    }

    public Item reduceAvailableQuantity(String item_name) {
        // check if item is available
    	Item result = null; 
    	//check if the item already exists
		for(Item itemInTheSystem : getItemCollection().values()) {
    		if(itemInTheSystem.getItemName().equals(item_name)) {
    			result = itemInTheSystem;
    			if(itemInTheSystem.getAvailableQuantity() > 0) {
    				itemInTheSystem.setAvailableQuantity(itemInTheSystem.getAvailableQuantity() - 1);
    			}else {
    				result = null;
    			}
    			break;
    			
    		}else {
    		result = null;
    		}
    	}
    	return result;
    }
}
