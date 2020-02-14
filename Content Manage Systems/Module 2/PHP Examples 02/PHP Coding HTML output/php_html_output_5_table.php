<?php
//File Name: php_html_output_5_table.php
//Purpose: Introduce PHP HTML Table
// <TABLE> <TR> <
//Author: Mike H Chase
//Date: 4-01-2014

// This how you buiild a table in PHP using HTML
// Table with Border 2 cells with data

$var1 = 4;
$var2 = 5;
$var3 = 6;

echo "<table border='1'>";
echo "<tr>";
echo "<td>";
echo $var1;
echo "</td>";
echo "<td>";
echo $var2 + $var3;
echo "</td>";

echo "</tr>";
echo "<table>";


?>