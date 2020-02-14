<?php
//File Name: PHP-Numeric-Compare-Example-A1.php
//Purpose: Introduce PHP comparison <, <=, >, >=)
//Author: Mike H Chase
//Date: 4-01-2014

$myVar1 = 9;

// "<" measn less than
// "<=" means less than or equal
// ">" means greater than
// ">=" means greater than or equal
// "===" means that they are identical  
// "==" means that they are equal  
// "!=" means that they aren't equal.

// Check for less than 10
//
if ($myVar1 < 10 )
{
    echo "myVar1 $myVar1 is less than 10 " .  "<br>";
} 
else
{
    echo "myVar1 $myVar1 is not less than 10 " . "<br>";
}


// Check for less than or equal to 10
//
if ($myVar1 <= 10 )
{
    echo "myVar1 $myVar1 is less than or equal to 10 " .  "<br>";
} 
else
{
    echo "myVar1 $myVar1 is not less than or equal to 10 " . "<br>";
}

// Check for greater than or equal to 10
//
if ($myVar1 >= 10 )
{
    echo "myVar1 $myVar1 is greater than or equal to 10 " .  "<br>";
} 
else
{
    echo "myVar1 $myVar1 is not greater than or equal to 10 " . "<br>";
}