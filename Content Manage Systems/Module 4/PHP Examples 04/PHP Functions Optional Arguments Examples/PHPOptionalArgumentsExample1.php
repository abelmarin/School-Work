<?php
//File Name: PHPOptionalArgumentsExample1.php
//Purpose: Prewritten Functions Optional Arguments
//Author: Mike H Chase
//Date: 4-10-2015

function foo($arg1 = '' ,  $arg2 = '' ) {

	echo "arg1: $arg1 </br>";
	echo "arg2: $arg2 </br>";
}

foo();

foo('hello');

foo ('hello', 'world');


?>

