<?php
//File Name: PHPExamplePrintFunction.php
//Purpose: Prewritten Functions Print within a function
// print works for numbers and strings but not arrays - for thsoe use print_r or echo
//Author: Mike H Chase
//Date: 4-10-2015

$a = 5;
$b = 15;
$c = 13.78;
$d = 567.87;
$e = array (1,2,3,4,5);  # this will cause an error

my_func_test($a);
echo "<br>";
my_func_test($b);
echo "<br>";
my_func_test($c);
echo "<br>";
my_func_test($d);
echo "<br>";
my_func_test($e);


function my_func_test( $x ) {
	
   //print works for numbers and strings but not arrays - for thsoe use print_r or echo
   //
   print ($x);
   echo "<p>";
}


?>
