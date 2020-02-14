<?php
/*
*   Plugin Name: WP Money Test Codeanywhere
*   Description: plugin to test money format functions on Codeanywhere
*   Version: 1.0
*   Author: Mr. Michael Chase
*   License: GPL2
*   File Name: wp_money_test_codeanywhere.php
*   Plugin Folder name: money-test-codeanywhere
*   Short Code: [money-test-codeanywhere-shortcode]
*   
*/
   
  add_shortcode( 'money-test-codeanywhere-shortcode', 'money_test_codeanywhere_entrypoint' );

function money_test_codeanywhere_entrypoint( $attributes ) {
	
	global $wpdb;
	
	$priceAmount = 1234.56;
   
    setlocale( LC_MONETARY, "en_US" );
    $priceOut1 = money_format( "%i",  $priceAmount);
    
    echo $priceOut1 . "</br>";
       
    if (! strstr($priceOut1, '$')) {
  
  		##
  		##
  		#echo "Money Format function failed. No #$ on string value" . "<br>";

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
    	
    	#$priceOut1 = money_format('$%(#10n', $priceAmount); 
    	#echo $priceOut1 . "</br>";
	}

}
?>