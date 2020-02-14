<?php

//MATH echo statement and parentheses
//
//

$a = 5; 
$b = 6;
$c = 10;
$d = 12;

echo "WITH parentheses - THIS WORKS AS EXPECTED" . "<br>";
echo ($a + $b) . "<br>"
	. ($a - $b) . "<br>" 
	. ($b * $c) . "<br>" 
	. ($c / $d) . "<br>" 
	. ($d % $a) . "<br>";

echo "<p>";

echo "WITHOUT parentheses - THIS DOES NOT WORK AS EXPECTED" . "<br>";
echo $a + $b . "<br>"
	. $a - $b . "<br>" 
	. $b * $c . "<br>" 
	. $c / $d . "<br>" 
	. $d % $a . "<br>";