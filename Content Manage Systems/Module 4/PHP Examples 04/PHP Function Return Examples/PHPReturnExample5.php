<?php
//File Name: PHPReturnExample5.php
//Purpose: Introduce PHP Return statement + var_export + gettype + ragged arrays
//Author: Mike H Chase
//Date: 6-15-2015

//Ragged array example - integers and strings
//
$num_array = array ( 1,2,3,4,5,6,7,8,9,10, "a", "ball", "is", "round");

foreach ($num_array as $value ) {

	//Call to the function "return_a_boolean" with the array value
	//
	$rtn_value = return_a_boolean_on_type_integer( $value);

	//Echo the value being used to call the return a boolean Function
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

 
//Function return_a_boolean_on_type_integer. 
// if the entry argument an integer returns true
//   else (not an integer ) returns the length of the string (if its a string)
//
function return_a_boolean_on_type_integer( $a )  {

	$entryArgType = gettype($a);

   // If its an integer, return true
   if ( $entryArgType == 'integer' )   {
      return true;
   }
   else {   
   		//else not an integer, make sure its a string before calling strlen
   		//
		if (   $entryArgType == 'string' ) {
			return strlen($a);
  	    }
   }
      
}


?>