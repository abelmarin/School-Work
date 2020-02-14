<?php
//File Name: PHPExamplePrintR.php
//Purpose: Prewritten Functions print_r
// print_r works with everything: numebrs, arrays (index and associative)
//Author: Mike H Chase
//Date: 4-14-2016   
	
//print_r works with everything: numebrs, arrays (index and associative)
//
$a = 1;
print_r($a);
echo "<br>";

$b = "Mike";
print_r($b);
echo "<br>";

$c = array( 1,2,3,4,5);
print_r($c);
echo "<br>";


$d = array( "Bill" => 1123, "Mike" => 456);
print_r($d);
echo "<br>";


$e = array( 12 => "BILL", 123 => "MIKE");
print_r($e);
echo "<br>";

?>