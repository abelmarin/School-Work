<?php
//File Name: PHPNumbersArrayExample1.php
//Purpose: Introduce PHP arrays + HTML in PHP
//Author: Mike H Chase
//Date: 4-16-2015

$numbers_array= array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13);

//Iterate the Array with Foreach
// 
echo "<table>";

// Using a foreach statement to iterate though the array
//
foreach ($numbers_array as $num_value) {

  echo "<tr>";
  
  if ( $num_value  < 10 ) {
     echo "<td>" . $num_value . " I am less than 10" . "</td>";
  }
  else if ( $num_value  > 10 ) {
     echo "<td>" . $num_value . " I am greater than 10" . "</td>";
  }
  else if ( $num_value  == 10 ) {
   echo "<td>" . $num_value . " I am equal to 10" . "</td>";
  }
  
  echo "</tr>";
}

echo "</table>";


?>