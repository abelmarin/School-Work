<?php
//File Name: PHPClassAndObjectExample2.php
//Purpose: Class and Object Examples 
//Author: Mike H Chase
//Date: 4-10-2015

class person {
    public $name;
    protected $age;
    private $weight;

	function set_name($new_name) {
		$this->name = $new_name;
	}
	function set_age($new_age) {
		$this->age = $new_age;
	}
	function set_weight($new_weight) {
		$this->weight = $new_weight;
	}
	function get_name() {
		return $this->name;
	}
	function get_age() {
		return $this->age;
	}
	function get_weight() {
		return $this->weight;
	}
}
   $person1 = new person();
   
   $person1->set_name("Stephan Mischhok");
   $person1->set_age(49); 
   $person1->set_weight(150);
   
   //$name variable is public, this means we can access it directlty with an ->
   // NOTICE that its not ->$name, but ->name
   //     this is the same as in the plugin code we will look at later in class
   //
   echo '$person1' . "'s name is " . $person1->name . "</br>";
   
   //$age and $weight variables are not public, can only access with a get function
   //
   echo '$person1' . "'s age is " . $person1->get_age() . "</br>";
   echo '$person1' . "'s weight is " . $person1->get_weight() . "</br>";

?>

