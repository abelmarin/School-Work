<?php

//File Name: PHPStringCompare01.php
//Purpose: Prewritten Function String Compare strcmp print
//Author: Mike H Chase
//Date: 1-01-2020   

$strA = "Mike";
$strB = "Bill";
$strC = "Mike";

//strcmp returns:
//   0 - if the two strings are equal
//  <0 - if string1 is less than string2
//  >0 - if string1 is greater than string2
//

//These 2 strings are not equal, so the return value is 1 
//
echo strcmp($strA,$strB); // the two strings are not equal
echo  "<br>";

//These 2 strings are equal, so the return value is 0
//
echo strcmp($strA,$strC); // the two strings are equal
echo  "<br>";

//Use strcmp in an if statement
//
if ( strcmp($strA,$strC) == 0 ) {

	echo "the 2 strings values are equal" . "<br>";
}


//Use strcmp in an if statement
//
if ( strcmp($strA,$strB) != 0 ) {

	echo "the 2 strings values are not equal" . "<br>";
}



?>