<?php
//File Name: PHPClassAndObjectExample1z.php
//Purpose: Class and Object Examples 
//Author: Mike H Chase
//Date: 4-10-2015

class person_full_name {
	var $first_name;
	var $middle_name;
	var $last_name;
	
	//Accessor funciton to set all 3 names at once
	//
	//
	function set_name($new_first_name, $new_middle_name, $new_last_name) {
		$this->first_name = $new_first_name;
		$this->middle_name = $new_middle_name;
		$this->last_name = $new_last_name;
	}
	
	function set_first_name($new_first_name, ) {
		$this->first_name = $new_first_name;
	}
	function set_middle_name($new_middle_name) {
		$this->middle_name = $new_middle_name;
	}
	function set_last_name($new_last_name) {
		$this->last_name = $new_last_name;
	}
		
	
	function get_name() {
		return $this->first_name .  ' ' . $this->middle_name . ' ' . $this->last_name;
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
   
   $person1->set_name("Stephan", "J",  "Mischhok");
   
	print_r ( $person1 );
	
   
   echo "<br>" . '$person1' . "'s name is " . $person1->get_name() . "</br>";


?>

