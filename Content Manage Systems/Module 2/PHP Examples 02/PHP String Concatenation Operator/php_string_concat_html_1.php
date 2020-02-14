<?php
//File Name: php_string_concat_html_1.php
//Purpose: Introduce PHP variables and the dot operator
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

//Use the DOT operator to concatenate two strings, 3 times
//
echo "<p>" . $name . " is " . $height  . "</p>" . "</br>"; // Output a line of text

echo "<p>" . $name . " is " . $height  . "</p>";

echo "<p>" .$name . " is "  . $height  . "</p>";

?>