<?php
//File Name: php_string_concat.php
//Purpose: Introduce PHP variables
//Author: Mike H Chase
//Date: 4-01-2014

/*
*  PLEASE NOTE
*  IF YOUR PHP WEB TESTER DOES NOT DISPLAY OUTPUT FROM THIS FILE
*  WITH LINE BREAKS and PARAGRAPH BREAKS then it does not support HTML output.
*  IF THAT IS THE CASE, please use a different PHP web tester, one that
*  does support HTML output
*/

//Variable Examples
//
$name = "mike";
$height = "5 foot 10 inches";
$weight = 194;  //Comment: in pounds

//Use the DOT operator to concatinate two strings, 3 times
//
echo $name . "is" . $height  . "<br>"; // Output a line of text
echo $name . "is" . $height  . "<p>";
echo $name . "is" . $height  . "<br>";

?>