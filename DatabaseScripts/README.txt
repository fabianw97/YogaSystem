Author : Fabian Woodman
Date : 22/02/2019

The DB is ran on a Xampp server using MySQL and Apache services.
It is hosted on phpMyAdmin so you will need this to host this database.

Once you have Xampp running and you can load phpMyAdmin you can import the database by selecting the server: Localhost and going on the import tab, from here you can select the 'yogaDB.sql' file which is saved in the 'DatabaseScripts' folder.

Once you have imported the file in should have created a new 'yogaDB' database in phpMyAdmin with all the tables and data required to run this application properly.

Note. You may need to update User accounts so that is matches the Username, url and password in the 'dev-persistence.properties' file which is in src/main/resources.

Admin details for the yoga system is 

username : test@test.com
password : password