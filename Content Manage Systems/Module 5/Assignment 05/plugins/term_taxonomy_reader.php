<?php
/*
*   Plugin Name: Term Taxonomy Reader
*   Description: plugin to read the MySQL DB Term Taxonomy table
*   Version: 1.0 
*   Author: Mr. Michael H Chase and Abel Marin
*   File: term_taxonomy_reader.php
*   Folder to create: term-taxonomy-tbl-reader
*   Short code: [term-taxonomy-reader-shortcode]
*/
   
  add_shortcode( 'term-taxonomy-reader-shortcode', 'wp_term_taxonomy_reader_entry_point' );


function wp_term_taxonomy_reader_entry_point ( $attributes ) {
	
	global $wpdb;
 
	// PLEASE NOTE
	//    "term taxonomy" is the database table name without the prefix
	//    *** YOU MUST add the prefix before the table name***
	//    ***  We will use the $wpdb object prefix value ***
	
	//Use the concatinaiton operator to join the table prefix to the word comments
	// to create the correct db prefix + table name
	$tableName =   $wpdb->prefix . "term_taxonomy"; 

	//Echo out the $tablename varaible, which is the db prefix + table name
	echo "$tableName";

	//Query the vomments table and assign the returned array of table row objects
	// to the $result variable
	$result = $wpdb->get_results( "SELECT * FROM $tableName");

    //Echo out a table header using start string values
	echo "<table border=\"1\">";
	echo "<tr>";
	echo "<th>"  . "Term Taxonomy ID"        . "</th>" 
		. "<th>" . "Term ID"    . "</th>" 
        . "<th>" . "Taxonomy" . "</th>"
        . "<th>" . "Count" . "</th>";
	echo "</tr>";

	//Iterate the array of DB row objects and put them in HTML table cells
	foreach($result as $row)  {
        if ($row->count > 0) {
            echo "<tr>";
        
            //Each table row column data item is accessed using it's column name
            
            echo   "<td>" . $row->term_taxonomy_id . "</td>"
                . "<td>" . $row->term_id  . "</td>"
                . "<td>" . $row->taxonomy . "</td>"
                . "<td>" . $row->count . "</td>";
                
            echo "</tr>";
        }
	}
	echo "</table>";
}
?>