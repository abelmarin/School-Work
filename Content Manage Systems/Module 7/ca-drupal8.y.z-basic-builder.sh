#!/bin/sh

# Linux

 
#Check that argument is provided
if [ $# -eq 0 ]; then
    echo "ca-drupal8.y.z-basic-builder.sh a Drupal 8.y.z install script"
    echo "Drupal 8.y.z version argument required"
    echo "Please enter the current Drupal 8.y.z Core Version number"
    echo "Example 8.8.0"
    exit 1
fi

echo " ca-drupal8.y.z-basic-builder.sh a Drupal 8.y.z Install script

    Copyright (C) <2018> <Mike Chase> <https://github.com/mikehchase>

	Codeanywhere Drupal 8.y.z Basic Build Script
	
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.  
    "
sleep 5s

echo " INSTRUCTIONS
    (1) Go to Drupal.org - get the latest Druapl 8.y.z CORE version number   
      
    (2) Logon to your Codeanywhere account 
    
 *  (3) Create a new connection of type PHP - PHP Development stack with Apache, PHP, MySQL, 
          phpMyAdmin and Composer pre-installed 
        We are using a shared Codeanywhere space - prepend your initials to the connection name

    (4) On the container info TAB 
    	 Record the root username on the first line 
    	 [root user without password]
    	 
    (5) From the container info page, select and access and log int phpMyAdmin on another TAB   
     
    (6) Login to phpMyAdmin as root user name and no password    
    
    (7) Select Databases TAB  
       
    (8) Create a database named drupalxyz# - where xyz are your initials and number is a single digit number
        - we are using a shared Codeanywhere account, so the database name must be unique    
        
    (9) Back on the Codeanywhere dashboard, upload this script file to the workspace
    
    (10) Open the bash command window and run the following BASH command to make the script executable
        [your-name:/~workspace $] chmod +x ca-drupal8.y.z-basic-builder.sh 
        
    (11) In the BASH command window run this script
        [your-name:/~workspace $] ./ca-drupal8.y.z-basic-builder.sh 8.8.0 
        the script will download the Drupal 8.y.z core files and establish folders for running the Drupal 8 install script 
        
    (12) In another TAB Enter the URL of the application over HTTPS - this will start the Drupal 8 site building script 
    
    (13) Fill out the required fields and build your Drupal 8 site
         (1) use a short all lowercase UNIQUE Drupal 8 site name - using your initials
         (2) The database (DB) is what you named it in step 8
	     (3) Always set the country and city & check both the update checkboxes 
	        
    (14) This script copies the example.settings.local.php to create the settings.local.php in the sites/default folders
       
    (15) When the build script completes, press the 'Visit your new site link' and record the URL of this site    
    
sleep 3s
"

DRUPAL_VERSION_ZIP="drupal-"$1".tar.gz"
DRUPAL_VERSION='drupal-'$1

cd $HOME 

wget https://ftp.drupal.org/files/projects/$DRUPAL_VERSION_ZIP

tar xzvf $DRUPAL_VERSION_ZIP

mv $DRUPAL_VERSION/* workspace/
mv $DRUPAL_VERSION/.htaccess workspace/

cd $HOME/workspace

cd sites/default/
cp default.settings.php settings.php
chmod a+w settings.php
mkdir files
chmod a+w files/

cd $HOME/workspace/sites
cp example.settings.local.php ./default/settings.local.php

sleep 3s

# set the ownership to druapl flders to www-data
cd $HOME 
cd $HOME/workspace

sleep 3s

sudo chown www-data:www-data sites/default
sudo chown -R www-data:www-data modules
sudo chown  -R www-data:www-data themes

echo " DONE Building Drupal 8 Basic CMS site"
