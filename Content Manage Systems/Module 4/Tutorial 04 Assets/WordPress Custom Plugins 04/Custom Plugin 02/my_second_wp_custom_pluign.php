<?php
   /*
   Plugin Name: My Second WP Custom Plugin
   Description: WP custom plugin to deomstrate PHP Classes and object interation
   Version: 1.0
   Author: Michael X. Chase
   File: my_secondwp_custum_plugin.php
   SQL Import File: n/a
   Folder to create: my-second-wp-custom-plugin
   Short code: [my-second-wp-plugin-shortcode]
   License: GPL2
   */
   
  add_shortcode( 'my-second-wp-plugin-shortcode', 'my_second_wp_plugin_entry_point' );



function my_second_wp_plugin_entry_point ( $attributes ) {
	
	global $wpdb;
 
 	class person {
 	    public $name;
    	public $age;

		function set_name($new_name) {
			$this->name = $new_name;
		}
		function set_age($new_age) {
			$this->age = $new_age;
		}
		function get_name() {
			return $this->name;
		}
		function get_age() {
			return $this->age;
		}

	}
	
    $person1 = new person(); 
    $person1->set_name("Stephan Mischhok");
	$person1->set_age(49); 

	$person2 = new person(); 
	$person2->set_name("Mike Chase");
	$person2->set_age(57); 

 	//Create the array variable
 	$personArray = array();

	//Use array_push to add person ojcts to the array
	//
	array_push( $personArray, $person1, $person2 );

	//Echo a statis text HTML Table Header
	//
	echo '<TABLE border="3" align="left" >';

	echo "<TR>";
	echo '<TH align="left">' . "Name" . "</TH>";
	echo "<TH>" . "Age" .  "</TH>";
	echo "</TR>";
	
	//Iterate through the person object array
	//
	foreach($personArray as $obj)
	{
   	echo "<TR>";
   		//Access the object's memebr data using the get method
   		//
   		echo "<TD>" .  $obj->get_name()   . "</TD>";
   		echo "<TD>" .  $obj->get_age()    . "</TD>";
   		echo "</TR>";
	}

	echo "</TABLE>";
}
?>