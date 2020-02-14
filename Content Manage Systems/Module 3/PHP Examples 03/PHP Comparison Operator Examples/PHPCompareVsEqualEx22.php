<?php
//File Name: PHPCompareVsEqualEx22.php
//Purpose: Introduce PHP assign "=' vs is equal '=='
// Also show how to properly define and differentiate body and function variable's 
//Author: Mike H Chase
//Date: 4-01-2014

$myVar1 = 13;   ;   #Assignment Operator
$myVar2 = 14;

if ( $myVar1 == $myVar2 ) { #Equal Comparison Operator

	echo "Hey these body variable's  are equal" . "<br>";
}
else  {
	echo "Hey these body variable's  are NOT equal" . "<br>";
}
	

//Call the funciton with the two body variables
//
check_is_equal( $myVar1, $myVar2);

	

// Always make function arguments a different name than the body variable's 
// Body variables are $myVar1 and $myVar2
// Function variables are $x and $y
//
function check_is_equal( $x, $y ) {


	if ( $x == $y ) {
		echo "Hey these function variable's  are equal" . "<br>";
	}
	else  {
		echo "Hey these function variable's  are NOT equal" . "<br>";
	}
}

?>