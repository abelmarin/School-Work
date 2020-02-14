<?php
//File Name: MoneyExample44.php
//Purpose: Prewritten Functions Money Example
//Author: Mike H Chase
//Date: 4-14-2016   
	
<?php

$a = AddOneToNum(5.559999) . "<br>";
$a .= AddOneToNum(10.55) . "<br>";
$a .= AddOneToNum(100.55);
echo $a;

function AddOneToNum($number) {
	$number += 1;
	setlocale( LC_MONETARY,  'en_US' );
	return money_format('%.2n', $number);
}

