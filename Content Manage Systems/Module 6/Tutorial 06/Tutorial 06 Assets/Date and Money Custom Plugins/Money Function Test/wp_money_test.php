<?php
/*
*   Plugin Name: WP Money Test
*   Description: plugin to test money format functions
*   Version: 1.0
*   Author: Mr. Michael Chase
*   License: GPL2
*   File Name: wp_money_test.php
*   Plugin Folder name: money-test
*   Short Code: [money-test-shortcode]
*   
*/
   
  add_shortcode( 'money-test-shortcode', 'money_test_entrypoint' );

function money_test_entrypoint( $attributes ) {
	
	global $wpdb;
	
	$priceAmount = 1234.56;
   
    setlocale( LC_MONETARY, "en_US" );
    $priceOut1 = money_format( '%i',  $priceAmount);
    echo "Price with " . '"%i"' . " ---> " . $priceOut1 . "</br>";

    setlocale( LC_MONETARY, "en_US" );
    $priceOut1 = money_format( '%(#10n',  $priceAmount);
    echo "Price with " . '"%(#10n"' . " ---> " . $priceOut1 . "</br>";

    setlocale( LC_MONETARY, "en_US" );
    $priceOut2 = money_format( '%.2n',  $priceAmount);
    echo "Price with " . '"%.2n"' . " ---> " . $priceOut2 . "</br>";
	
    
    setlocale( LC_MONETARY, "de_DE" );
    $priceOut3 = money_format( '%i',  $priceAmount);
    echo "Price with " . 'de_DE and "%i"' . " ---> " . $priceOut3 . "</br>";
   
}
?>