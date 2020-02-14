<?php
//File Name: PHPDateExample2.php
//Purpose: Prewritten Functions date_create
//Author: Mike H Chase
//Version 2.0
//Date: 12-15-2019

$dateTime = date_create( "2019-12-15" );
$theDate = date_format( $dateTime,"Y/m/d H:i:s" );
echo $theDate;

?>