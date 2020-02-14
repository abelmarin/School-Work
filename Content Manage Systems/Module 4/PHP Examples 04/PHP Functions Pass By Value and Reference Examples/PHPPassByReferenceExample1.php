<?php
//File Name: PHPPassByReferenceExample1.php
//Purpose: Demonstrate Pass By Reference - Change to $var is successful
//Author: Mike H Chase
//Date: 4-10-2015

function foo( &$var1 ) {

   $var1++;
}

$a = 5;
echo $a . " - Before call to function" . "</br>";
foo($a);
echo $a . " - After call to function" . "</br>";


?>

