<?php
//File Name: PHPClassAndObjectExample1x.php
//Purpose: Class and Object Examples 
//Author: Mike H Chase
//Date: 4-10-2015

class person {
	var $first_name;
	var $middle_name;
	var $last_name;
	
	
	function set_first_name($new_first_name ) {
		$this->first_name = $new_first_name;
	}
	function set_middle_name($new_middle_name) {
		$this->middle_name = $new_middle_name;
	}
	function set_last_name($new_last_name) {
		$this->last_name = $new_last_name;
	}
		
	function get_first_name() {
		return $this->first_name;
	}	
	function get_middle_name() {
		return $this->middle_name;
	}	
	function get_last_name() {
		return $this->last_name;
	}	
	
}
   $person1 = new person();
   
   $person1->set_first_name("Stephan");
   $person1->set_middle_name( "J" );
   $person1->set_last_name( "Mischhok");
   
	print_r ( $person1 );
	
   
   echo "<br>" . '$person1' . "'s name is " 
   	. $person1->get_first_name() . " "
   	. $person1->get_middle_name() . " "
   	. $person1->get_last_name() . "</br>";


?>

