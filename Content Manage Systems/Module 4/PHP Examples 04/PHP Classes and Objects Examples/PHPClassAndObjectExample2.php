<?php
//File Name: PHPClassExample1.php
//Purpose: Demonstrate PHP Class + Property
//Author: Mike H Chase
//Date: 4-10-2015

class human {
  public $gender = "Male"; 
}

$my_object = new human( );

echo $my_object -> gender  . "</br>";

$my_object -> gender = "Female";

echo $my_object -> gender  . "</br>";


?>

