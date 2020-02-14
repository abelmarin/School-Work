<?php

//Sandbox PHP code
// - Sandbox does not do <br>'s
// - Sandbox does not hide spaces on strings
//Enter your code here, enjoy!

$var = "     my string     ";
echo $var . "\n";
$len = strlen( $var );
echo $len . "\n";

$var = trim( $var );
$len = strlen( $var );
echo trim( $var ). " " . $len . "\n";


//PHPtester PHP Code
// - PHPTester does do <br>'s 
// - PHPTester does hide leading spaces on strings
//
$var = "     my string     ";
echo $var . "<br>";
$len = strlen( $var );
echo $len . "<br>";

$var = trim( $var );
$len = strlen( $var );
echo trim( $var ). " " . $len . "<br>";

?>