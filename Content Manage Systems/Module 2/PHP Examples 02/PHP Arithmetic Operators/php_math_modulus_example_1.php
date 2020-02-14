<?php
//File Name: php_math_modulus_example_1.php
//Purpose: Introduce PHP arithetic operators MODULUS in function
//Author: Mike H Chase
//Date: 4-01-2014

//Variable Examples
//
$x = 3;
$y = 56;

//Call the funciton passing in argument variables
//
mod_two_numbers ($x, $y);

/* Function to MOD two numbers and echo out the result
* For Help With PHP MOD function:
* http://php.net/manual/en/internals2.opcodes.mod.php
*/
function mod_two_numbers( $a, $b ) {

  echo ($a % $b);
  
}

?>