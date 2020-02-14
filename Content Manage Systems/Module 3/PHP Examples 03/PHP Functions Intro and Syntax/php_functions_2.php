<?php
//File Name: php_functions_2.php
//Purpose: Writing a php function
//Author: Mike H Chase
//Date: 12-09-2019

$x = "My";
$y = "name is";
$z = "Mike";

//Call the function with the two variables 
//
join_three_strings( $x, $y, $z);

//This Function is named "join_three_strings"
// It has 3 entry arguments, $a, $b, $c
// The function processing joins 3 strings, adding spaces between them
// anf then echos out the resulting concatinated string.
// Notice how the entry arguments are not named the same as the
// variables above.
//
function join_three_strings( $a, $b, $c) {
  
  $new_var = $a . "  " . $b . "  " . $c;
  
  
  echo $new_var;

}


?>

