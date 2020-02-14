<?php
//File Name: PHPArrayExample1A.php
//Purpose: Introduce PHP arrays + HTML in PHP
//Author: Mike H Chase
//Date: 4-01-2014

$cars = array('Volvo', 'Ford', 'Tesla', 'Honda', 'BMW', 'Volkswagen');

//Iterate the Array with Foreach statement
// 
echo "<table>";
echo "<tr>";

foreach ($cars as $value) {

 echo "<td>" . $value . "</td>";

}

echo "</tr>";
echo "</table>";

?>