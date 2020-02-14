<?php
//File Name: php_string_concat_html_2.php
//Purpose: Introduce PHP variablesand functions
//Author: Mike H Chase
//Date: 4-01-2014

/*
*  PLEASE NOTE
*  IF YOUR PHP WEB TESTER DOES NOT DISPLAY OUTPUT FROM THIS FILE
*  as an HTML TABLE then it does not support HTML output.
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
echo "<table border='1'>";

echo "<tr>" . "<td>" . $name . " is " . $height  . "</td>" . "</tr>"; // Output a line of text

echo "<tr>" . "<td>" . $name . " is " . $height  . "</td>" . "</tr>";

echo "<tr>" . "<td>" . $name . " is " . $height  . "</td>" . "</tr>";

echo "</table>";

?>