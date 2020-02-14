<?php
//File Name: PHPDateExample3.php
//Purpose: Prewritten Functions to get todays date and time depending on your timezone
//Author: Mike H Chase
//Version 2.0
//Date: 12-15-2019

// Simply:
$date = date('Y-m-d H:i:s');
echo $date . "<br>";

// Or:
$date = date('Y/m/d H:i:s');
echo $date . "<br>";


/** 
 * This time is based on the default server time zone.
 * If you want the date in a different time zone,
 * say if you come from Nairobi, Kenya like I do, you can set
 * the time zone to Nairobi as shown below.
 */

date_default_timezone_set('Africa/Nairobi');

// Then call the date functions
$date = date('Y-m-d H:i:s');
echo $date . "<br>";

// Or
$date = date('Y/m/d H:i:s');
echo $date . "<br>";

// date_default_timezone_set() function is however
// supported by PHP version 5.1.0 or above.

?>