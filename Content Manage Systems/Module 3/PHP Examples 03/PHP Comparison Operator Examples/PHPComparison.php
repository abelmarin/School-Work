<?php
//File Name: PHPComparison.php
//Purpose: Introduce PHP comparison =, ==, === 
//Author: Mike H Chase
//Date: 4-01-2014

$myVar1 = "hello";
$myVar2 = "goodby";
$myVar3 = "hello";

// "===" means that they are identical  
// "==" means that they are equal  
// "!=" means that they aren't equal.

// Check for Equal, ==
//
if ($myVar1 == $myVar2)
{
    echo "myVar1 $myVar1 is equal to myVar2 $myVar2" .  "<br>";
} 
else
{
    echo "myVar1 $myVar1 is not equal to myVar2 $myVar2" . "<br>";
}

//Check for Not Equal, !=
//
if ($myVar1 != $myVar2)
{
    echo "myVar1 $myVar1 is not equal to myVar2 $myVar2" . "<br>";
} 
else
{
     echo "myVar1 $myVar1 is equal to myVar2 $myVar2" .  "<br>";
}

// Check for Equal, ==
//
if ($myVar1 == $myVar3)
{
    echo "myVar1 $myVar1 is equal to myVar3 $myVar3" .  "<br>";
} 
else
{
    echo "myVar1 $myVar1 is not equal to myVar3 $myVar3" . "<br>";
}
// Check for Identical,  ===
//
if ($myVar1 === $myVar3)
{
    echo "myVar1 $myVar1 is identical to myVar3 $myVar3" .  "<br>";
} 
else
{
    echo "myVar1 $myVar1 is not identical to myVar3 $myVar3" . "<br>";
}

//Here's a table I put together showing how variables compare to each other.
//
// "===" means that they are identical  
// "==" means that they are equal  
// "!=" means that they aren't equal.
//
//        false   null    array()  0      "0"     0x0     "0x0"   "000"    "0000"
//false    ===     ==      ==       ==      ==     ==      !=      !=       !=    
//null     ==      ===     ==       ==      !=     ==      !=      !=       !=    
//array()  ==      ==      ===      !=      !=     !=      !=      !=       !=    
//0        ==      ==      !=       ===     ==     ===     ==      ==       ==    
//"0"      ==      !=      !=       ==      ===    ==      ==      ==       ==    
//0x0      ==      ==      !=       ===     ==     ===     ==      ==       ==    
//"0x0"    !=      !=      !=       ==      ==     ==      ===     ==       ==    
//"000"    !=      !=      !=       ==      ==     ==      ==      ===      ==    
//"0000"   !=      !=      !=       ==      ==     ==      ==      ==       ===  
 
?>