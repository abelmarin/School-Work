<?php
// PHP Iterate through an Array of objects - Example 2
// Example 2 - HTML Table output + Use Get Methods
//
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
   
$person1 = new person(); 
$person1->set_name("Stephan Mischhok");
$person1->set_age(49); 
$person1->set_weight(150);
   
$person2 = new person(); 
$person2->set_name("Mike Chase");
$person2->set_age(57); 
$person2->set_weight(204);


$personArray = array();
//Use array_push to add person ojcts to the array
//
array_push($personArray, $person1, $person2 );
//
//NOTE array_push - arg 1 is the array
// http://php.net/manual/en/function.array-push.php
// Array push Relaces the followng code:
//$personArray[] = $person1;
//$personArray[] = $person2;

//Use print_r to dump the object array
//
//print_r($personArray);
//echo "<p>";

echo '<TABLE border="2" align="left" >';

echo "<TR>";
echo '<TH align="left">' . "Name" . "</TH>";
echo "<TH>" . "Age" .  "</TH>";
echo "<TH>" . "Weight" . "</TH>";
echo "</TR>";

foreach($personArray as $obj)
{
   echo "<TR>";
   //Access the object's memebr data using the get method
   //
   echo "<TD>" .  $obj->get_name()   . "</TD>";
   echo "<TD>" .  $obj->get_age()    . "</TD>";
   echo "<TD>" .  $obj->get_weight() . "</TD>";

   echo "</TR>";
}

echo "</TABLE>";