# Product Inventory Warehouse
The code hosted by this repository is related to management of products inventory in the organizations warehouse.

## Design Scenario
Company A has two brands Brand1 and Brand2 where each brand has multiple products with multiple sizes. 
Company has their offices in following locations:  
* USA 
* Ireland 
* Netherlands 
* Dubai 
* Australia 
* Italy 
* Pakistan 
* Mexico

In future, they can start a new office in some other location as well.
They have warehouses where they manage their inventory.
Let’s suppose they have warehouses in USA, Ireland, Netherlands, Dubai, Australia, Italy.   Each warehouse can have all products or some products and they manage their inventory according to the warehouse inventory.

There are some technical terms being used in Company A which are:  
* **In Stock**: Number of products physically available.
* **Available Quantity**: Number of products which can be sold (This can be different than In Stock quantity since in stock is physical quantity but all physical quantity might not be available for next order to process)  
* **In Transit**: Quantity ordered by the Company A from some party company and party company has shipped the quantity but it’s not yet received by Company A.   
* **MOQ**: Minimum order quantity means if Company A wants to purchase this particular product, a minimum of this much quantity needs to be ordered.  
* **QPB**: Quantity Per Box is the quantity of the product that can be added in 1 box.
* **Reorder Point**: Minimum quantity when system should alert to place an order for this product.

A product can be of 3 types:  
* Finished Product 
* Component
* Packaging Material   

Components are not sellable and only internal to the company and same goes for packaging material. Only Finished product can be sold via Ecommerce Company A has. 
Each product, component and packaging material can have different sizes.

## Requirements
* Java 8 +
* Apache tomcat 8.5.xx
* MySql 5.7.20
* Git 2.14.3
* IntelliJ IDEA or any other IDE

## Project Setup
### Github Checkout
#### Https
```https://github.com/maliknabeel/warehouseinventorymanager.git```
#### Ssh
```git@github.com:maliknabeel/warehouseinventorymanager.git```

## Database

### DB Schema
![PWI Database Schema](https://github.com/maliknabeel/warehouseinventorymanager/blob/master/db-schema/pwi.png)

