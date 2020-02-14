<?php
//File Name: PHPArrayExample4A.php
//Purpose: More PHP Iterating Associative Arrays
//Author: Mike H Chase
//Date: 4-01-2014

$xarray = array('FirstName' => 'Mike', 
	'LastName' => 'Chase', 
	'Height' => 5.2, 
	'EyeColor' => 'Blue', 
	'ShoeSize' => 10.5);

//Iterate the Associative Array for Keys and Values
//
foreach ($xarray as $key => $value) {
 echo "KEY: " . $key . " VALUE: " . $value . "<br>";
}

?>