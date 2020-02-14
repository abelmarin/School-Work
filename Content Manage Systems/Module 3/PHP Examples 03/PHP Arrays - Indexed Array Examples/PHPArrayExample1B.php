<?php
//File Name: PHPArrayExample1B.php
//Purpose: Introduce PHP arrays + For Statement + HTML in PHP
//Author: Mike H Chase
//Date: 4-01-2014

$cars = array('Volvo', 'Ford', 'Tesla', 'Honda', 'BMW', 'Volkswagen');

//Iterate with For Statment
//
$max = sizeof($cars);

echo $max . "<br>";

echo "<table>";
echo "<tr>";

for ($i=0; $i < $max; $i++) {
   echo "<td>" . $cars[$i] . "</td>";
}

echo "</tr>";
echo "</table>";

?>