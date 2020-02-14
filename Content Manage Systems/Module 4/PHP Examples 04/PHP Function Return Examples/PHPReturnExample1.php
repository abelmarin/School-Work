<?php
//File Name: PHPReturnExample1.php
//Purpose: Introduce PHP Return statement
//Author: Mike H Chase
//Date: 6-15-2015

//Call to the function "return_a_string"
//
$rtn_value = return_a_string();

//Echo out the value of the returned string
echo $rtn_value;
echo "</br>";
echo gettype($rtn_value);
 
//Function return_a_string. 
//
//
function return_a_string( )  {

   $var = "mike";
   return $var;
}


?>