<?php
//File Name: PHPReturnExample2.php
//Purpose: Introduce PHP Return statement
//Author: Mike H Chase
//Date: 6-15-2015

//Call to the function "return_a_integer"
//
$rtn_value = return_a_integer();

//Echo out the value of the returned integer
echo $rtn_value;
echo "</br>";
echo gettype($rtn_value);
 
//Function return_a_integer. 
//
//
function return_a_integer( )  {

   $var = 56;
   return $var;
}


?>