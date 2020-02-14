<?php
//File Name: PHPIFElse.php
//Purpose: Introduce PHP IF-ELSE statement and isset function
//Author: Mike H Chase
//Date: 4-01-2014

$mySetVar = "hello";
$myEmptyVar = "";
$myUnsetVar;

if (isset($mySetVar))
{
    echo "mySetVar is set." .  "<br>";
} 
else
{
    echo "mySetVar is not set" . "<br>";
}

if (isset($myEmptyVar))
{
    echo "\$myEmptyVar is set." . "<br>";
} 
else
{
    echo "\$myEmptyVar is not set" . "<br>";
}

if (isset($myUnSetVar))
{
    echo "\$myUnSetVar is set" . "<br>";
} 
else
{
    echo "\$myUnSetVar is not set" . "<br>";
}

?>