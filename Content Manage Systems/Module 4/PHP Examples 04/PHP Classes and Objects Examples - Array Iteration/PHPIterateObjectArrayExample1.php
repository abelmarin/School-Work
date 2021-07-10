<?php
//File Name: PHPIterateObjectArrayExample1.php
//Purpose: Example of how to dump and iterate an Array of Objects
//Author: Mike H Chase
//Date: 12-12-2019

class person {
    public $name;
    public $age;
    public $weight;

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

//Create 2 Person objects and add memeber var data
// 
$person1 = new person(); 
$person1->set_name("Stephan Mischhok");
$person1->set_age(49); 
$person1->set_weight(150);
   
$person2 = new person(); 
$person2->set_name("Mike Chase");
$person2->set_age(57); 
$person2->set_weight(204);

//Create the array variable
$personArray = array();

//Use array_push to add person ojcts to the array
//
array_push( $personArray, $person1, $person2 );
//
//NOTE array_push - arg 1 is the array
// http://php.net/manual/en/function.array-push.php
// Array push Relaces the followng code:
//$personArray[] = $person1;
//$personArray[] = $person2;

//Use print_r to dump the object array
//
print_r($personArray);
echo "<p>";

//Iterate through the person object array
//
foreach($personArray as $key=>$obj)
{
   #Echo the object array $key - which is really the index
   #
   echo "Person $key" . "<br>";
   
   #Echo the object's memebr variable data
   #
   echo "Name:" . $obj->name . "<br>";
   echo "Age:" . $obj->age . "<br>";
   echo "Weight:" . $obj->weight . "<br>" . "<p>";
}
