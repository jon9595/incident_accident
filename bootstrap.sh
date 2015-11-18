#!/usr/bin/env bash

# Use single quotes instead of double quotes to make it work with special-character passwords
PASSWORD='12345678'

# update / upgrade
echo updating os
sudo apt-get update > /dev/null
#sudo apt-get -y upgrade

# install apache 2.5 and php 5.5
echo installing apache
sudo apt-get install -y apache2 > /dev/null
echo installing php5
sudo apt-get install -y php5 > /dev/null

# install mysql and give password to installer
sudo debconf-set-selections <<< "mysql-server mysql-server/root_password password $PASSWORD"
sudo debconf-set-selections <<< "mysql-server mysql-server/root_password_again password $PASSWORD"
echo installing mysql-server
sudo apt-get -y install mysql-server > /dev/null
echo installing php5-mysql
sudo apt-get install php5-mysql > /dev/null

# install phpmyadmin and give password(s) to installer
# for simplicity I'm using the same password for mysql and phpmyadmin
sudo debconf-set-selections <<< "phpmyadmin phpmyadmin/dbconfig-install boolean true"
sudo debconf-set-selections <<< "phpmyadmin phpmyadmin/app-password-confirm password $PASSWORD"
sudo debconf-set-selections <<< "phpmyadmin phpmyadmin/mysql/admin-pass password $PASSWORD"
sudo debconf-set-selections <<< "phpmyadmin phpmyadmin/mysql/app-pass password $PASSWORD"
sudo debconf-set-selections <<< "phpmyadmin phpmyadmin/reconfigure-webserver multiselect apache2"
echo installing phpmyadmin
sudo apt-get -y install phpmyadmin > /dev/null

# Setup database
echo creating database incident_accident
mysql -uroot -p12345678 -e "CREATE DATABASE incident_accident;"

# Make MySQL external accessible
echo `mysql -uroot -p$PASSWORD -e "GRANT ALL PRIVILEGES ON *.* TO 'iaf'@'%' IDENTIFIED BY 'iaf';"`
echo `mysql -uroot -p$PASSWORD -e "GRANT ALL PRIVILEGES ON *.* TO 'iaf'@'localhost' IDENTIFIED BY 'iaf';"`
echo `mysql -uroot -p$PASSWORD -e "GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' IDENTIFIED BY '$PASSWORD';"`
echo `mysql -uroot -p$PASSWORD -e "GRANT ALL PRIVILEGES ON *.* TO 'root'@'localhost' IDENTIFIED BY '$PASSWORD';"`
sed -i 's/^bind-address/#bind-address/' /etc/mysql/my.cnf
sed -i 's/^skip-external-locking/#skip-external-locking/' /etc/mysql/my.cnf
sudo service mysql restart

# Import bootstrap SQL
echo importing database objects
#mysql -uroot -p12345678 iaf < /vagrant/sql/create.sql

# setup hosts file
#VHOST=$(cat <<EOF
#<VirtualHost *:80>
#    DocumentRoot "/var/www/html/${PROJECTFOLDER}"
#    <Directory "/var/www/html/${PROJECTFOLDER}">
#        AllowOverride All
#        Require all granted
#    </Directory>
#</VirtualHost>
#EOF
#)
#echo "${VHOST}" > /etc/apache2/sites-available/000-default.conf

# enable mod_rewrite
sudo a2enmod rewrite

# restart apache
service apache2 restart

# install git
#echo installing git
#sudo apt-get -y install git > /dev/null

# activate mcrypt
cd /etc/php5/mods-available
sudo php5enmod mcrypt

# restart apache
sudo service apache2 restart

