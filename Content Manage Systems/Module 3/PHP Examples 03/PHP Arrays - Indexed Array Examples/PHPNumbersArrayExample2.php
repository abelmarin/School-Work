<?php
//File Name: PHPNumbersArrayExample2.php
//Purpose: Introduce PHP arrays + HTML in PHP
//Author: Mike H Chase
//Date: 4-16-2015

$numbers_array= array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13);

//Iterate the Array with Foreach
// 
echo "<table>";

// Using a for statement to iterate though the array
//

$max = sizeof($numbers_array);

echo "Array Length max: "  . $max . "\n";

for ($i=0; $i < $max; $i++) {

  echo "<tr>";
  
  if ( $numbers_array[$i]  < 10 ) {
     echo "<td>" . $numbers_array[$i] . " I am less than 10" . "</td>";
  }
  else if ( $numbers_array[$i]  > 10 ) {
     echo "<td>" . $numbers_array[$i] . " I am greater than 10" . "</td>";
  }
  else if ( $numbers_array[$i]  == 10 ) {
   echo "<td>" . $numbers_array[$i] . " I am equal to 10" . "</td>";
  }
  
  echo "</tr>";
}

echo "</table>";


?>