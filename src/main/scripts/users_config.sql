## Use to run mysql db docker image, optional if you're not using a local mysqldb
# docker run --name mysqldb -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -d mysql

# connect to mysql and run as root user
#Create Databases
CREATE DATABASE easyrider_dev;
CREATE DATABASE easyrider_prod;

#Create database service accounts
CREATE USER 'er_dev_user'@'localhost' IDENTIFIED BY 'rider';
CREATE USER 'er_prod_user'@'localhost' IDENTIFIED BY 'rider';
CREATE USER 'er_dev_user'@'%' IDENTIFIED BY 'rider';
CREATE USER 'er_prod_user'@'%' IDENTIFIED BY 'rider';

#Database grants
GRANT SELECT ON easyrider_dev.* to 'er_dev_user'@'localhost';
GRANT INSERT ON easyrider_dev.* to 'er_dev_user'@'localhost';
GRANT DELETE ON easyrider_dev.* to 'er_dev_user'@'localhost';
GRANT UPDATE ON easyrider_dev.* to 'er_dev_user'@'localhost';
GRANT SELECT ON easyrider_prod.* to 'er_prod_user'@'localhost';
GRANT INSERT ON easyrider_prod.* to 'er_prod_user'@'localhost';
GRANT DELETE ON easyrider_prod.* to 'er_prod_user'@'localhost';
GRANT UPDATE ON easyrider_prod.* to 'er_prod_user'@'localhost';
GRANT SELECT ON easyrider_dev.* to 'er_dev_user'@'%';
GRANT INSERT ON easyrider_dev.* to 'er_dev_user'@'%';
GRANT DELETE ON easyrider_dev.* to 'er_dev_user'@'%';
GRANT UPDATE ON easyrider_dev.* to 'er_dev_user'@'%';
GRANT SELECT ON easyrider_prod.* to 'er_prod_user'@'%';
GRANT INSERT ON easyrider_prod.* to 'er_prod_user'@'%';
GRANT DELETE ON easyrider_prod.* to 'er_prod_user'@'%';
GRANT UPDATE ON easyrider_prod.* to 'er_prod_user'@'%';