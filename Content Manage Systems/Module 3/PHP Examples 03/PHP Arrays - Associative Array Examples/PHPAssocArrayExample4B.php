<?php
//File Name: PHPArrayExample4B.php
//Purpose: More PHP Iterating Associative Arrays + HTML in PHP
//Author: Mike H Chase
//Date: 4-01-2014

$xarray = array('FirstName' => 'Mike', 
	'LastName' => 'Chase', 
	'Height' => 5.2, 
	'EyeColor' => 'Blue', 
	'ShoeSize' => 10.5);

//Iterate the Associative Array for Keys
//
echo "<table>";
echo "<tr>";
echo "<th> KEY </th>";
echo "<th> VALUE </th>";
echo "</tr>";

foreach ($xarray as $key => $value) {
   echo "<tr>";
   echo "<td> $key </td> <td> $value </td>";
   echo "</tr>";
}


echo "</table>";
?>