<?php
//File Name: PHPArrayExample1C.php
//Purpose: Introduce PHP arrays + For Statement + HTML in PHP
//Author: Mike H Chase
//Date: 4-01-2014

$cars = array('Volvo', 'Ford', 'Tesla', 'Honda', 'BMW', 'Volkswagen');

//Iterate with For Statment
//
$max = sizeof($cars);

echo $max . "<br>";

echo "<table>";


for ($i=0; $i < $max; $i++) {
   echo "<tr>";
   echo "<td>" . $cars[$i] . "</td>";
   echo "</tr>";
}

echo "</table>";

?>