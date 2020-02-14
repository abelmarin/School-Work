<?php

/*
*   Plugin Name: PHP Money Format Hack For Codeanywhere
*   Description: plugin as a way to explain and review the Money Format Hack
*   Version: 2.0 
*   Author: Mr. Michael H Chase
*   License: GPL2
*/

#  Author Note: Oct 2018
#
#  As I was testing my WordPress plugins on Codeanywhere 
#  I noticed that my money DB column dta was ot displaying with a $.
#  I started digging into it and found out that Codeanywee servers
#  were missing libraries.
#  In this program I wil outline what works where and why.
#

$numberNoDollarSign =  123.56;

setlocale(LC_MONETARY, 'en_US.UTF-8');

# For simulating the error on phptester:
# Dont call money_format funciton, instead call with double
#
# $priceDisplay = money_format('%(#10n',$number);  

check_money_format_function( $numberNoDollarSign );

/* Function to check the price display. 
 * Entry argumen is Call by refernce 
 *  If the entry string has no $, it will be repalced with one that does (by reference)
 *
 */

echo "Money Format Output: " . $numberNoDollarSign . "<br>";

function check_money_format_function( &$var_to_check) {

	// Check if money_format was successful but looking for a $
	//
	if (! strstr($var_to_check, '$')) {
  
  		##
  		##
  		echo "Money Format funciotn failed. No #$ on string value" . "<br>";

        
   		## Following works on Codenaywhere - But do not use on any environment where 
   	 	##  the money formt works. Thast why its within a if statment 
   	 	##  that checks to see if a $
    	##  was prepended by the fist call to money_format
    	##
		##  NOTE: When running on phptester, you will see 2 $
    	##  
    	// If money_format fails, hack the format string and hard code a $
    	// WORKS on Codeanywhere
    	//
    	
    	$var_to_check = money_format('$%(#10n',$var_to_check); 
	}
}