<?php
//File Name: PHPExamplePrint.php
//Purpose: Prewritten Functions print
//  print works with numbers and strings but not arrays - for arrays use print_r or echo
//Author: Mike H Chase
//Date: 4-14-2016   
	
//print works with numbers and strings but not arrays - for those use print_r or echo
//
$a = 1;
print($a);
echo "<br>";

$b = 345/.67;
print($b);
echo "<br>";

//Following code should work
$q = "I am a string";
print($q);
echo "<br>";


//Following code should give you an error
$z =  array( 1, 2, 3, 4);
print($z);
echo "<br>";

//Following code should give you an error
$w =  array( 'a', 'b', 'c', 'd');
print($w);
echo "<br>";

//Following code should give you an error
$w =  array( "a", "b", "c", "d");
print($w);
echo "<br>";

?>