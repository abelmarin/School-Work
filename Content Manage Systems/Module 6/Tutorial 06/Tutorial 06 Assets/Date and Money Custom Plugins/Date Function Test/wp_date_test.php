<?php
/*
*   Plugin Name: WP Date Test
*   Description: plugin to test date functions
*   Version: 1.0
*   Author: Mr. Michael Chase
*   License: GPL2
*   File Name: wp_date_test.php
*   Plugin Folder name: date-test
*   Short Code: [date-test-shortcode]
*   
*/
   
  add_shortcode( 'date-test-shortcode', 'date_test_entrypoint' );

function date_test_entrypoint( $attributes ) {
	
	global $wpdb;
	
	$date = date('Y-m-d H:i:s');
	echo $date . "<br>";

	// Or:
	$date = date('Y/m/d H:i:s');
	echo $date . "<br>";

	#String to Upper and String To Lower
	#
	#
	$string1 = "i am an all lowercase string";
	
	echo strtoupper( $string1 ) .  "<br>";
	
	echo $string1 .  "<br>";
	
	$str2 = strtoupper( $string1 );
	
	echo $str2 .  "<br>";


	/** 
	 * This time is based on the default server time zone.
	 * If you want the date in a different time zone,
	 * say if you come from Nairobi, Kenya like I do, you can set
	 * the time zone to Nairobi as shown below.
	 */

	date_default_timezone_set('Africa/Nairobi');

	// Then call the date functions
	$date = date('Y-m-d H:i:s');
	echo $date . "<br>";

	// Or
	$date = date('Y/m/d H:i:s');
	echo $date . "<br>";

	// date_default_timezone_set() function is however
	// supported by PHP version 5.1.0 or above.
   
}
?>