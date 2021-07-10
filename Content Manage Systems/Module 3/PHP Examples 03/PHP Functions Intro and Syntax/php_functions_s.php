<?php
//File Name: php_functions_s.php
//Purpose: Writing a php function with no entry arguments that returns a string value
//Author: Mike H Chase
//Date: 12-09-2019

$rtn = '';

//Call the fucntion without variables.
//
$rtn = my_new_function( );
echo $rtn;

// My New Funciton - No entry arguments
// The funciotn does return a string value.
//
function my_new_function( ) {
  
  $a = "Hi";
  $b = "There";
  $z = $a . ' ' . $b;
  return $z;
  
}


?>

