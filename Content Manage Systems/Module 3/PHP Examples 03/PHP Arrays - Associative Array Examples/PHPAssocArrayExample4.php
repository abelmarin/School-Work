<?php
//File Name: PHPArrayExample4.php
//Purpose: More PHP Iterating Associative Arrays 
//Author: Mike H Chase
//Date: 4-01-2014

$fruit_array = array('a' => 'apple', 'b' => 'banana', 'c' => 'cherry');

//Iterate the Associative Array for Values
//
echo "VALUES: ";
 foreach($fruit_array as $v){
    echo($v) . " ";    // Value1, Value2, Value10
 }

echo "<br>";

//Iterate the Associative Array for Keys & Values
//
foreach ($fruit_array as $key => $value) {
 echo "KEY: " . $key . " VALUE: " . $value ."<br>";
}

?>