<?php
//File Name: PHP-Numeric-Compare-Example-A2.php
//Purpose: Introduce PHP comparison <, <=, >, >=) 
//Author: Mike H Chase
//Date: 4-01-2014

//Create an array of numbers
//
$numbers = array(1, 3, 9, 10, 11, 12);


//Iterate the numbers array with a foreach statement
// 
foreach ($numbers as $valueToTest ) {

	// Check for less than 10
	//
	if ($valueToTest < 10 )
	{
    	echo "valueToTest $valueToTest is less than 10 " .  "<br>";
	} 
	else
	{
    	echo "valueToTest $valueToTest is not less than 10 " . "<br>";
	}

	// Check for less than or equal to 10
	//
	if ($valueToTest <= 10 )
	{
    	echo "valueToTest $valueToTest is less than or equal to 10 " .  "<br>";
	} 
	else
	{
    	echo "valueToTest $valueToTest is not less than or equal to 10 " . "<br>";
	}

	// Check for greater than or equal to 10
	//
	if ($valueToTest >= 10 )
	{
    echo "mvalueToTest $valueToTest is greater than or equal to 10 " .  "<br>";
	} 
	else
	{
    	echo "valueToTest $valueToTest is not greater than or equal to 10 " . "<br>";
	}
}