package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public abstract class TheSystem {

        private HashMap<String, Item> itemCollection;
        TheSystem() {
        // initialize itemCollection to an empty collection
            this.itemCollection = new HashMap<String, Item>();
            if(getClass().getSimpleName().equals("AppSystem")){
            //READ THE FILE

                try {
            	   
            	   String location = "./resources/sample.txt";
                   File file = new File(location);
                   Scanner input = new Scanner(file);
                   while (input.hasNextLine()){
                	    String[] itemInfo = input.nextLine().split("  ");
                        String key = itemInfo[0];
                       	double price = Double.parseDouble(itemInfo[2]);
                       	int quantity = Integer.parseInt(itemInfo[3]);
                       	String desc = itemInfo[1];
                       	Item item =  new Item(itemInfo[0],desc,price,quantity);
                        itemCollection.put(key, item);
                         
                }
                
	            }
	            catch (FileNotFoundException e){
	                System.out.println("file not found");
	                e.printStackTrace();
	            }
                    

            }
    }
    
    public HashMap<String, Item> getItemCollection(){
        // set the itemCollection getter 
    	return itemCollection;
    }
    
    public Boolean checkAvailability(Item item) {
        	// check availability method
    		boolean status = true;
    		if(item != null) {
    			if(item.getQuantity() >= item.getAvailableQuantity()) {
    				System.out.println("System is unable to add " + item.getItemName() + "to the cart.System has only " + item.getAvailableQuantity() + " " + item.getItemName() );
    				status = false;
    			}else {
    				status = true;
    			}
    		}
    		return status;
    }
    
    public Boolean add(Item item) {
        // add item to the system
    	boolean status = false;
    	if(item == null ) {
    		status = false;
    	}else{
    		//check if the item already exists in the collection
    		for(Item itemInTheSystem : itemCollection.values()) {
        		if(itemInTheSystem.getItemName().equals(item.getItemName())) {
        			itemInTheSystem.setQuantity(itemInTheSystem.getQuantity() + 1);
        			status = true;
        			break;
        		}else {
        		 status = false;
        		}
        	}
    		if(status == false) {
    			itemCollection.put(item.getItemName(), item);
    			status = true;
    		}
    	}
    	return status;
    }

    public Item remove(String itemName) {
        // remove item from the system collection
    	Item result = null;
    	boolean found = false;
    	//check if the item is in the list
    	for(Item item : itemCollection.values()) {
    		if(item.getItemName().equals(itemName)) {
    			found = true;
    			break;
    		}else {
    		 found = false;
    		}
    	}
    	//delete the item
    	if(found == true) {
    			result = itemCollection.get(itemName);
        		itemCollection.remove(itemName);
        	
    	}else {
    		result = null;
    	}
    	  
    	
    	return result;
    }

    public abstract void display();
}
