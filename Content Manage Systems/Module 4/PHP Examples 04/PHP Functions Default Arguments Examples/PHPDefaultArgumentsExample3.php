<?php
//File Name: PHPDefaultArgumentsExample3.php
//Purpose: Prewritten Functions Default Arguments
//Author: Mike H Chase
//Date: 4-10-2015

function foo($arg1 = 12,  $arg2 = 5) {

	echo "arg1: " . $arg1 . "</br>";
	echo "arg2: " . $arg2 . "</br>";
}


//Called with zero arguments, both default values will be used
//
foo( );

//Called with 1 argument, 2nd argument will be default value of 5
//
foo ( 9 );

//Called with 2 arguments, both passed values will be used
//
foo ( 9, 11 );

//Its not an error to call with 3 arguments, the function will not use #3
// Its not good coding though
//
foo ( 1, 2, 3 );  

?>

