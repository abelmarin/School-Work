<?php
//File Name: php_html_output_3_table.php
//Purpose: Introduce PHP HTML Table with header
// <TABLE> <TR> <
//Author: Mike H Chase
//Date: 4-01-2014

/*
*  PLEASE NOTE
*  IF YOUR PHP WEB TESTER DOES NOT DISPLAY OUTPUT FROM THIS FILE
*  WITH LINE BREAKS and PARAGRAPH BREAKS then it does not support HTML output.
*  IF THAT IS THE CASE, please use a different PHP web tester, one that
*  does support HTML output
*/

// This how you buiild a table in PHP using HTML
// Table with Border and headers
//  Use .= to append the next part of the
//       TABLE expression to the variable
//
$var  = "<TABLE border='1'>";
$var .= "<TR>";
$var .= "<TH>";
$var .= "A HEADER";
$var .= "</TD>";
$var .= "</TR>";
$var .= "<TR>";
$var .= "<TD>";
$var .= "SOME TEXT IN A TABLE";
$var .= "</TD>";
$var .= "</TR>";
$var .= "</TABLE>"; 

echo $var;


?>