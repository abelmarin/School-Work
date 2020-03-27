<?php
   /*
   Plugin Name: Employee Reader Page
   Description: reads the content of the employee table
   Version: 1.0
   Author: Abel Marin
   File: employee_table_reader.php
   SQL Import File: n/a
   Folder to create: employee-table-reader
   Short code: [employee-table-reader-shortcode]
   License: GPL2
   */
   
  add_shortcode( 'employee-table-reader-shortcode', 'employee_table_reader_plugin_entry_point' );

function employee_table_reader_plugin_entry_point( $attributes ) {
	
	global $wpdb;

	//Set the Local for Money function calls
    setlocale(LC_MONETARY, 'en_US');
	
	//Prepend the employee table name with the current table prefix
	$tableName =   $wpdb->prefix . "employee"; 
	
	//Query the adapter_plug_tbl table and get all the rows in the $result object
	$result = $wpdb->get_results( "SELECT * FROM $tableName"); 

	echo "<table>";

	echo "<tr>";
    echo  '<th colspan="5"> EMPLOYEE TABLE </th>';
    echo "</tr>";

	echo "<tr>";
	echo  "<th>" . "ID"        	 .  "</th>" 
		. "<th>" . "Name"      	 .  "</th>" 
		. "<th>" . "Age" 		 .  "</th>" 
		. "<th>" . "EyeColor"    .  "</th>"
		. "<th>" . "Salary"    	 .  "</th>";
	echo "</tr>";

	// Iterate through the $results object. Each $row is a row of the table
	// row is also an object
	foreach($result as $row)  {

   		#Create a temp variable to hold the age display value
   		$age_display =  "unknown";
   		
  		#Use a if statements to set the age display value
   		if ($row->Age <= 21) {
			$age_display = "Young";
		} 
		elseif ($row->Age > 21 && $row->Age < 45) {
			$age_display = "Young Adult";
		} 
		elseif ($row->Age >= 45 && $row->Age < 65) {
			$age_display = "Adult";
		} 
		elseif ($row->Age > 65) {
			$age_display = "Old Adult";
		}
   		
   		#Format the database table salary data as US currency with a $
        $number =  $row->Salary;
        $salary_display = money_format('%(#10n',$number);  
 
   		#Format the color dislay value as an HTML font color statement
   		#First use the strtolower function to get the color value to all lowercase
  		$color_display = $row->EyeColor;
  		$color_display = strtolower( $color_display );
  		$color_display_html = "<font color=\"$color_display\">$color_display</font>";
  
        echo "<tr>";
   
   		echo  "<td>" . $row->ID             . "</td>"
   		    . "<td>" . $row->Name           . "</td>"
   		    . "<td>" . $age_display         . "</td>"
   		    . "<td>" . $color_display_html  . "</td>"
       		. "<td>" . $salary_display  	. "</td>";
        
  		echo "</tr>";
   }
   echo "</table>";
}
?>