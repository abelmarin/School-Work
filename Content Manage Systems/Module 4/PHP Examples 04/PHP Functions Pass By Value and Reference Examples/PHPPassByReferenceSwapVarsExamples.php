<?php
//File Name: PHPPassByReferenceSwapVarsExamples.php
//Purpose: Demonstrate Pass ByReference Swap Vars Examples
//         Use pass by reference to swap variable values
//Author: Mike H Chase
//Date: 4-19-2015

//Using Bitwise Xor to do the var swap
//http://php.net/manual/en/language.operators.assignment.php
//
function swap1(&$x,&$y) {
    $x ^= $y ^= $x ^= $y;
}
//Use an array and the list function to do the swap
//list to Assign variables as if they were an array
//http://php.net/manual/en/function.list.php
//
function swap2(&$x,&$y) {
    list($x,$y) = array($y,$x);
}
// Use a temporary third var to to the swap
//
function swap3(&$x,&$y) {
    $tmp=$x;
    $x=$y;
    $y=$tmp;
}

$a = 5;
$b = 100;
echo '$a:' . $a . ' $b:' . $b . " Before call to swap1 function" . "</br>";
swap1($a, $b);
echo '$a:' . $a . ' $b:' . $b . " After call to swap1 function" . "</br>";

echo '$a:' . $a . ' $b:' . $b . " Before call to swap2 function" . "</br>";
swap2($a, $b);
echo '$a:' . $a . ' $b:' . $b . " After call to swap2 function" . "</br>";

echo '$a:' . $a . ' $b:' . $b . " Before call to swap3 function" . "</br>";
swap3($a, $b);
echo '$a:' . $a . ' $b:' . $b . " After call to swap3 function" . "</br>";


?>

