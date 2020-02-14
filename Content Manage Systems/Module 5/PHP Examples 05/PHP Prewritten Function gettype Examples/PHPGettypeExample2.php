<?php
//File Name: PHPGetTypeExample.php
//Purpose: Introduce PHP prewritten Funciton gettype 
//Author: Mike H Chase
//Date: 9-24-2015

$myVarInt = 10;
$myVarStr = "Im a string";
$myVarBool = true;  //thisis a Boolean true is actual a constant or 1. Its not a string.

$rtn = my_gettype_function( $myVarInt  );
echo $rtn . "<br>";
$rtn = my_gettype_function( $myVarStr  );
echo $rtn . "<br>";
$rtn = my_gettype_function( $myVarBool  );
//
//Use prewritten function var_export so that the returning
// Boolean false will be dispalyed as false. Without this nothing
// is displayed on most Web PHP testers
//
echo var_export($rtn) . "<br>";

//Function my_gettype_function
// has 1 entry argument $a
// Returns Boolean true (which is 1) when $ is of type integer
// Returns the string length when $a is of type string
// Returns false when $a is of type Boolean 
//  - uses getttype to determine the type of $a entry argument
//
function my_gettype_function( $a ) {

    //the gettype prewritten function returns the variable type
	$theTypeOfVar = gettype( $a );

	if ( $theTypeOfVar == "integer" )  {
		return true;
	}
	if (  $theTypeOfVar == "string" ) {
		//string length prewritten fucntion strlen
		//
		$lenOfStr = strlen( $a );
		return $lenOfStr;
	}
	if (  $theTypeOfVar == "boolean" ) {	
		return false;
	}

}


?>