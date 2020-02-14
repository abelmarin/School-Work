<?php
//File Name: PHPGetTypeExample1.php
//Purpose: Prewritten Functions gettype
//Author: Mike H Chase
//Version 2.0
//Date: 4-24-2019

$cars = array('Volvo', 'Ford');
$name = "Mike";
$age = 55;
$weight = 210.56;
$cars2 = array('a' => 'Alpha', 'B' => 'Bently');
$isTrue = false;
$undefVar;


echo gettype($cars) . "</br>";
echo gettype($name) . "</br>";
echo gettype($age) . "</br>";
echo gettype($weight) . "</br>";
echo gettype($cars2) . "</br>";
echo gettype($isTrue) . "</br>";
echo gettype($undefVar) . "</br>";

?>

