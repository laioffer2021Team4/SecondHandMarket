How to deploy the backend

1.Git clone backend_master branch to your local

$git checkout --track origin/backend_master

2. Open your AWS account and set up an IAM with S3 permissions

Tutorial: https://medium.com/@postullat2/java-spring-boot-and-aws-s3-bucket-integration-cff480d94e3f

After setting up S3, write info into the application.properties file s3.endpointUrl= s3.accessKeyId=
s3.secretKey= s3.bucketName= s3.region=us-west-2

3.Set up your AWS RDS in the file named ApplicationConfig the same as the one used in the onlineshop
class

dataSource.setUrl(""); dataSource.setUsername(""); dataSource.setPassword("");

Note that when setting the URL, change the Schema name to something else. Don’t use ecommerce
anymore. ecommerce is the database used in the Onlineshop class. For example, let’s change ecommerce
to secondhandmarket.

jdbc:mysql://laiproject-instance.c2cnafv9el5c.us-west-2.rds.amazonaws.com:
3306/secondhandmarket?createDatabaseIfNotExist=true&serverTimezone=UTC

4. Load pom dependencies

5. In Intellij, select run → edit configuration and select spring boot. Enter
   com.laioffer.secondhandmarket.Application Short Command Line in the main class field and select
   Jar Manifest

6.Before running, deploy Redis Mac: https://phoenixnap.com/kb/install-redis-on-mac Windows: After
downloading, unzip and run redis-server Redis-x64-3.0.504.zip Run Redis in a terminal as shown
below. Don't turn off when running the backend, you need to open the Redis cache at the same time
every time you deploy the backend.

7.Click to run Spring Boot, the Intellij Console displays the following to indicate successful
deployment

8.After successfully creating the SQL database, run the following SQL commands in the SQL console to
add enum to the database

INSERT INTO roles(name) VALUES('ROLE_USER'); INSERT INTO roles(name) VALUES('ROLE_ADMIN'); INSERT
INTO address_type(address_type) VALUES('Selling'); INSERT INTO address_type(address_type) VALUES('
Billing' );

