<?php
//File Name: PHPTrimExample1.php
//Purpose: Prewritten Functions Trim
//Author: Mike H Chase
//Date: 4-10-2015

$string1 = "          A sting with spaces        ";

$strLen = strlen ( $string1 );
echo "Sting length before TRIM: " . $strLen . "</br>";
echo "String before TRIM: " . $string1 . "</br>";

$string1 = trim($string1);

$strLen = strlen ( $string1 );
echo "String length after TRIM: " . $strLen . "</br>";
echo "String after TRIM: " . $string1 . "</br>";

?>