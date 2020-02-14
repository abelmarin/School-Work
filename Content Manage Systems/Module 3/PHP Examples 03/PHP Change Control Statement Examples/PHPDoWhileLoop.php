<?php
//File Name: PHPDoWhileLoop.php
//Purpose: Introduce PHP Do While loop statement
//Author: Mike H Chase
//Date: 4-01-2014

$myCounter = 0;
$j = 10;

//While $myCounter is less than 100, echo $myCounter value
//  then add 10 to $myCounter
//
while ( $myCounter < 100 )
{
      $myCounter = $myCounter + $j;
      echo $myCounter . " ";
}

?>