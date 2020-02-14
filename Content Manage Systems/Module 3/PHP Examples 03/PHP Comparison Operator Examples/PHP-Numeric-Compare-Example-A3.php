<?php
//File Name: PHP-Numeric-Compare=Example-A3.php
//Purpose: Introduce PHP comparison <, <=, >, >=) using an Array of values HTML Table output
//Author: Mike H Chase
//Date: 4-01-2014

//Create an array of numbers
//
$numbers = array( 1, 3, 9, 10, 11, 12 );

echo "<table border='1'>";

//Iterate the Array with Foreach statement
// 
foreach ($numbers as $valueToTest ) {
	
	// Check for less than 10
	//
	if ($valueToTest < 10 )
	{
		echo "<tr>";
		echo "<td>";
    	echo "valueToTest $valueToTest is less than 10";
    	echo "</td>";
		echo "</tr>";
	} 
	else
	{
		echo "<tr>";
		echo "<td>";
    	echo "valueToTest $valueToTest is not less than 10";
    	echo "</td>";
		echo "</tr>";
	}

	// Check for less than or equal to 10
	//
	if ($valueToTest <= 10 )
	{
		echo "<tr>";
		echo "<td>";
    	echo "valueToTest $valueToTest is less than or equal to 10";
    	echo "</td>";
		echo "</tr>";
	} 
	else
	{
		echo "<tr>";
		echo "<td>";
    	echo "valueToTest $valueToTest is not less than or equal to 10";
    	echo "</td>";
		echo "</tr>";
	}

	// Check for greater than or equal to 10
	//
	if ($valueToTest >= 10 )
	{
		echo "<tr>";
		echo "<td>";
    	echo "mvalueToTest $valueToTest is greater than or equal to 10";
    	echo "</td>";
		echo "</tr>";
	} 
	else
	{
		echo "<tr>";
		echo "<td>";
    	echo "valueToTest $valueToTest is not greater than or equal to 10";
    	echo "</td>";
		echo "</tr>";
	}
	
}

echo "</table>";
