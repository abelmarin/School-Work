<?php
//File Name: php_html_output_7_table.php
//Purpose: Introduce PHP HTML Table
// <TABLE> <TR> <
//Author: Mike H Chase
//Date: 4-01-2014

// This how you buiild a table in PHP using HTML
// Table with Border 3 cells with data

$var1 = "Mike";
$var2 = "Bill";
$var3 = "Ethan";

echo "<table border='1'>";
echo "<tr>";
echo "<td>";
echo $var1;
echo "</td>";
echo "<td>";
echo $var2;
echo "</td>";
echo "<td>";
echo $var3;
echo "</td>";
echo "</tr>";
echo "<table>";


?>
