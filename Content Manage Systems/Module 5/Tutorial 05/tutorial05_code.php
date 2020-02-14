<?php

# problem 1
$numbersArray = array(1,2,3,4,5,6,7);

$sizeOfArray = sizeof($numbersArray);

echo $sizeOfArray;

# problem 2
$cars = array('Ford', 'Mazda', 'Telsa');
$name = "Bill";
$age = 35;
$weight = 189.35;
$isTrue = false;
$carsAssocArray = array('a' => 'Alpha', 'B' => 'Bentley');

echo gettype($cars) . "<br>"; 
echo gettype($name) . "<br>";
echo gettype($age) . "<br>"; 
echo gettype($weight) . "<br>"; 
echo gettype($isTrue) . "<br>"; 
echo gettype($carsAssocArray) . "<br>";

# problem 3

# problem 4
$string1 = "     abcdef     ";

$strLen = strlen($string1);
echo "Length before TRIM: " . $strLen . "<br>";

$string1 = trim($string1);

$strLen = strlen($string1);
echo "Length after TRIM: " . $strLen;

# problem 5
$a = 1;
print_r($a);
echo "<br>";

$b = "Abel";
print_r($b);
echo "<br>";

$c = array(1,2,3,4,5,6);
print_r($c);
echo "<br>";

$d = array("Abel" => 1234, "Steve" => 4567);
print_r($d);
echo "<br>";

?>