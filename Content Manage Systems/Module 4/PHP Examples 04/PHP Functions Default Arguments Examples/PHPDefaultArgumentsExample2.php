<?php
//File Name: PHPDefaultArgumentsExample2.php
//Purpose: Prewritten Functions Default Arguments
//Author: Mike H Chase
//Date: 4-10-2015

function foo($arg1,  $arg2 = 5) {

	echo "arg1: " . $arg1 . "</br>";
	echo "arg2: " . $arg2 . "</br>";
}


foo('hello');

foo ('hello', 8);


?>

