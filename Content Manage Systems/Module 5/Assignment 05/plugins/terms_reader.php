<?php
/*
*   Plugin Name: Terms Reader
*   Description: plugin to read the MySQL DB Terms table
*   Version: 1.0 
*   Author: Mr. Michael H Chase and Abel Marin
*   File: terms_reader.php
*   Folder to create: terms-tbl-reader
*   Short code: [terms-reader-shortcode]
*/
   
  add_shortcode( 'terms-reader-shortcode', 'wp_terms_reader_entry_point' );


function wp_terms_reader_entry_point ( $attributes ) {
	
	global $wpdb;
 
	// PLEASE NOTE
	//    "terms" is the database table name without the prefix
	//    *** YOU MUST add the prefix before the table name***
	//    ***  We will use the $wpdb object prefix value ***
	
	//Use the concatinaiton operator to join the table prefix to the word comments
	// to create the correct db prefix + table name
	$tableName =   $wpdb->prefix . "terms"; 

	//Echo out the $tablename varaible, which is the db prefix + table name
	echo "$tableName";

	//Query the vomments table and assign the returned array of table row objects
	// to the $result variable
	$result = $wpdb->get_results( "SELECT * FROM $tableName");

    //Echo out a table header using start string values
	echo "<table border=\"1\">";
	echo "<tr>";
	echo "<th>"  . "Term ID"        . "</th>" 
		. "<th>" . "Name"    . "</th>" 
		. "<th>" . "Slug" . "</th>";
	echo "</tr>";

	//Iterate the array of DB row objects and put them in HTML table cells
	// 
	foreach($result as $row)  {
        if (strcmp($row->name, "Uncategorized") != 0) {
            echo "<tr>";
        
            //Each table row column data item is accessed using it's column name
            
            echo   "<td>" . $row->term_id . "</td>"
                . "<td>" . $row->name  . "</td>"
                . "<td>" . $row->slug . "</td>";
                
            echo "</tr>";
        }
	}
	echo "</table>";
}
?>