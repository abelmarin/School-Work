<?php
//File Name: PHPArrayExample1.php
//Purpose: Introduce PHP arrays
//Author: Mike H Chase
//Date: 4-01-2014

$cars = array('Volvo', 'Ford', 'Tesla', 'Honda', 'BMW', 'Volkswagen');
//echo 'I like ' . $cars[0] . ", " . $cars[1] . ' and ' . $cars[2] . '.';


//Iterate the Array with Foreach statement
// 
foreach ($cars as $value) {
 echo $value . "<br>";
}

//Iterate with For Statment statement
//
$max = sizeof($cars);

echo $max . "<br>";

for ($i=0; $i < $max; $i++) {
  echo $cars[$i] . "<br>";
}

?>