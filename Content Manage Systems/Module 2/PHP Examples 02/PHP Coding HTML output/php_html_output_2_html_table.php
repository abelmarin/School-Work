<?php
//File Name: php_html_output_2_html_table.php
//Purpose: Introduce PHP HTML OUTPUT - Break
//Author: Mike H Chase
//Date: 4-01-2014

/*
*  PLEASE NOTE
*  IF YOUR PHP WEB TESTER DOES NOT DISPLAY OUTPUT FROM THIS FILE ASA N HTML TABLE,
*  then it does not support HTML output.
*  IF THAT IS THE CASE, please use a different PHP web tester, one that
*  does support HTML output.
*/

// This how you buiild a table in PHP using HTML
// (1) 1 line table
// 
echo "<TABLE>" . "<TR>" . "<TD>" . "SOME TEXT IN A TABLE" . "</TD>" . "</TR>" . "</TABLE>"; 

// This how you buiild a table in PHP using HTML
// TABLE no border
//  Use .= to append the next part of the TABLE expression to the variable
//
$var = "<TABLE>";
$var .="<TR>";
$var .="<TD>";
$var .="SOME TEXT IN A TABLE";
$var .="</TD>";
$var .="</TR>";
$var .="</TABLE>"; 

echo $var;

// This how you buiild a table in PHP using HTML
// Table with Border
//  Use .= to append the next part of the TABLE expression to the variable
//
$var = "<TABLE border='1'>";
$var .="<TR>";
$var .="<TD>";
$var .="SOME TEXT IN A TABLE";
$var .="</TD>";
$var .="</TR>";
$var .="</TABLE>"; 

echo $var;


?>