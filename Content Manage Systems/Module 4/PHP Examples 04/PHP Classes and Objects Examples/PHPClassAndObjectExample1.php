<?php
//File Name: PHPClassAndObjectExample1.php
//Purpose: Class and Object Examples 
//Author: Mike H Chase
//Date: 4-10-2015

class person {
	var $name;
	function set_name($new_name) {
		$this->name = $new_name;
	}
	function get_name() {
		return $this->name;
	}
}
   $person1 = new person();
   $person2 = new person();
   $person3 = new person();
   $person4 = new person();
   
   $person1->set_name("Stephan Mischhok");
   $person2->set_name("Nick Waddles");
   
   echo '$person1' . "'s name is " . $person1->get_name() . "</br>";
   echo '$person2' . "'s name is " . $person2->get_name() . "</br>";
   echo '$person3' . "'s name is " . $person3->get_name() . "</br>";
   echo '$person4' . "'s name is " . $person4->get_name() . "</br>";
?>

