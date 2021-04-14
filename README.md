如何部署后端

1.Git clone backend_master branch 到你的本地

$git checkout --track origin/backend_master


2.打开你的AWS 账户 设置一个拥有S3 权限的 IAM

教程：
https://medium.com/@postullat2/java-spring-boot-and-aws-s3-bucket-integration-cff480d94e3f

设置好S3 后 把info 写入 application.properties 文件
s3.endpointUrl=<your S3 endpointUrl>
s3.accessKeyId=<your aws accessKey>
s3.secretKey=<your aws secretKey>
s3.bucketName=<your bucket name>
s3.region=us-west-2



3. 在名为ApplicationConfig的文件里设置你的AWS RDS 和onlineshop 课上用的一样

   dataSource.setUrl("<your RDS url>");
   dataSource.setUsername("<your username>");
   dataSource.setPassword("<your password>");



注意就是设置URL的时候 Schema 名称改成 别的，不要再用 ecommerce，ecommerce是Onlineshop课上用的数据库
例如 下面把ecommerce 改成了 secondhandmarket

jdbc:mysql://laiproject-instance.c2cnafv9el5c.us-west-2.rds.amazonaws.com:3306/secondhandmarket?createDatabaseIfNotExist=true&serverTimezone=UTC

4.加载pom dependencies

5.在intellij里选run → edit configuration 选择 spring boot。
main class 栏里输入com.laioffer.secondhandmarket.Application
Short Command Line 里 选择 Jar Manifest

 6. 运行之前，部署Redis
Mac ： https://phoenixnap.com/kb/install-redis-on-mac
Windows：下载 后解压运行redis-server Redis-x64-3.0.504.zip


把Redis 运行在一个terminal如下图。运行后端时不要关掉，每次部署后端都需要同时打开Redis 缓存。


点击运行 Spring Boot， Intellij Console 显示如下代表部署成功




创建SQL 数据库 成功后， 在SQL console 运行下面这些SQL 命令 添加enum 到 数据库

INSERT INTO roles(name) VALUES('ROLE_USER'); 
INSERT INTO roles(name) VALUES('ROLE_ADMIN'); 
INSERT INTO address_type(address_type) VALUES('Selling'); 
INSERT INTO address_type(address_type) VALUES('Billing');

