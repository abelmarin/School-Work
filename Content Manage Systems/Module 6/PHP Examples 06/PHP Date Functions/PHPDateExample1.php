<?php
//File Name: PHPDateExample1.php
//Purpose: Prewritten Functions date and date_default_timezone_get
//Author: Mike H Chase
//Version 2.0
//Date: 12-15-2019

date_default_timezone_set('America/Chicago');

$script_tz = date_default_timezone_get();

echo $script_tz . "<br>";

$date = date('Y-m-d H:i:s');     

echo $date;

?>