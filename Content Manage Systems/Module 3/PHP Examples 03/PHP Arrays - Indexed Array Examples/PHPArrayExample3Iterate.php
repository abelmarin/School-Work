<?php
//File Name: PHPArrayExample3Iterate.php
//Purpose: Introduce PHP arrays and how to iterate through them
//Author: Mike H Chase
//Date: 4-01-2014

$flowers = array('Rose','AMARYLLIS','Aster', 'BELLS OF IRELAND');
//var_dump($flowers);

//Iterate the Array with a foreach statement
//
foreach ($flowers as $item) {
 echo $item . "<br>";
}

echo('Exampel of a for statement iteration' . "<br>");

//We need to size of the array to Iterate the array with for statement. 
//
$max = sizeof($flowers);

echo $max . "<br>";

for ($i=0; $i < $max; $i++) {

  echo $flowers[$i] . "<br>";
  
}

?>