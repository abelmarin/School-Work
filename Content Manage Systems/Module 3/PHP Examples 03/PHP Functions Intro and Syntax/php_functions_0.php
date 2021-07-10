<?php
//File Name: php_functions_1.php
//Purpose: Writing a php function
//Author: Mike H Chase
//Date: 4-10-2015

$x = 5;
$y = 7;

//Call the fucntion with the two variables 
//
multi_two_numbers( $x, $y);

//Function Multiplies two numbers that come in as entry arguments
// Notice how the entry arguments are not named the same as the
// variables above.
//
function multi_two_numbers( $a, $b) {
  
  $z = $a * $b;
  
  echo $z;

}


?>

