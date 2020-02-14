<?php
//File Name: PHPReturnExample4.php
//Purpose: Introduce PHP Return statement + var_export 
//Author: Mike H Chase
//Date: 6-15-2015


$num_array = array ( 1,2,3,4,5,6,7,8,9,10);

foreach ($num_array as $value ) {

	//Call to the function "return_a_boolean" with the array value
	//
	$rtn_value = return_a_boolean( $value);

	//Echo the value being used to call the return a boolean funciton
	// 
	echo $value .  "<br>";

	//Echo the value of the returned boolean AS IS
	// FALSE will dispaly as blank and TRUE will display as 1
	echo $rtn_value .  "<br>";
	
	//Echo the value of the Retrned Boolean using Gettype prewritten Function
	// gettype wil be 'boolean'
	echo gettype($rtn_value) .  "<br>";
	
	//Echo the value of the Retrned Boolean using var_export prewritten Function
	// False and true wil both disaply correctly 'false' and 'true'
	echo var_export($rtn_value) .  "<br>";
}

 
//Function return_a_boolean. 
// if the entry argument is > 7, returns true
//   else (not > 7 ) returns false
//
function return_a_boolean( $a )  {

   if ( $a > 7 )   {
      return true;
   }
   else {
    return false;
   }
      
}


?>