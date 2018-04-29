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
Execute following commands as root user. 
### DB Schema
![PWI Database Schema](https://github.com/maliknabeel/warehouseinventorymanager/blob/master/db-schema/pwi.png)

### Schema Creation
``` CREATE SCHEMA `vtb_pwi` ; ```

### Create User
```create user 'vtbpwi'@'localhost' identified by 'vtb@pwi@123456';```

### Grant Permissions
```grant all on vtb_pwi.* to 'vtbpwi'@'localhost';```

### Import Database Schema with Sample Data
Exit from MySQL shell.
 
 Go to  ``` <Workspace>\warehouseinventorymanager\db-schema```
 ````
 mysql pwi < pwi.sql -u vtbpwi -p
 Enter password: vtb@pwi@123456
````
## Application Deployment

### Tests Execution
* Project is already imported into the IntelliJ IDE. 
* Right click on the project and select ```Run All Tests ...```
![Run ALl Tests](https://github.com/maliknabeel/warehouseinventorymanager/blob/master/images/run-tests.png)

### Maven application build
* Go to ```Run``` > ```Edit Configuration```
![Run ALl Tests](https://github.com/maliknabeel/warehouseinventorymanager/blob/master/images/edit-config.png)

* Click the ```+``` on top left corner of dialog box and select ```Maven```. 
![Select Maven](https://github.com/maliknabeel/warehouseinventorymanager/blob/master/images/sel-maven.png)

* Give maven profile a name and maven execution command ```clean compile tomcat:redloy```. 
![Select Maven](https://github.com/maliknabeel/warehouseinventorymanager/blob/master/images/maven-build-deploy.png)

### Tomcat Build Deploy
* Project is already imported into the IntelliJ IDE. 

* Go to ```Run``` > ```Edit Configuration```
![Run ALl Tests](https://github.com/maliknabeel/warehouseinventorymanager/blob/master/images/edit-config.png)

* Click the ```+``` on top left corner of dialog box and select ```Tomcat``` and then ```local```. 
![Tomcat Profile](https://github.com/maliknabeel/warehouseinventorymanager/blob/master/images/tomcat-deploy.png)

* Give tomcat profile a name.

* Select ```Configure``` from the ```Server``` tab and set the tomcat directory path.

* On the bottom of screen click `````+````` and select ```Build Artifect```. 

* On the screen select the war file ```pwi.war``` to be deployed in the ```WebApps``` folder as ```ROOT``` application.    
![Tomcat Build Deploy](https://github.com/maliknabeel/warehouseinventorymanager/blob/master/images/tomcat-build-deploy.png)

* On the main the screen, first build the using ```Maven Profile``` and then deploy using the ```Tomcat Profile```.  
![Maven and Tomcat Build then Deploy](https://github.com/maliknabeel/warehouseinventorymanager/blob/master/images/running-maven-tomcat.png)

### Accessing Services via Postman
The services can be access via Postman. Important services are

##### Warehouse Inventory Report by Country
**Description:** ```Get warehouse wise inventory status for a given country.```
**URI: ** ```country/{countryId}/inventory```

##### Product Report by Brand Name
**Description:** ```Get details of produts for a given brand.```
**URI: ** ```brands/{brandId}/products```

##### Packaging Information for a Product
**Description:** ```Get details of packaging for a particular product.```
**URI: ** ```product/{productId}/measurements```  

Beside this other entities such as ```warehouse``` , ```brands``` , ```countries``` , ```packagaing``` all have there respective CRUD operations. 








