<?php
   /*
   Plugin Name: My Adapter Plug Table Reader Custom Plugin
   Description: a very basic HTML table output WP custom plugin
   Version: 1.0
   Author: Michael X. Chase
   File: my_adapter_plug_reader.php
   SQL Import File: n/a
   Folder to create: my-adapter-plug-reader
   Short code: [my-adapter-plug-reader-shortcode]
   License: GPL2
   */
   
  add_shortcode( 'my-adapter-plug-reader-shortcode', 'my_adapter_reader_plugin_entry_point' );

function my_adapter_reader_plugin_entry_point( $attributes ) 
{
	
	global $wpdb;

	//Set the Local for Money fnction calls
	//
    setlocale(LC_MONETARY, 'en_US');
	
	//Prepend the adapter_plug_tbl table name with the current table prefix
	//
	$tableName =   $wpdb->prefix . "adapter_plug"; 
	
	//Query the  adapter_plug_tbl table and get all the rows in the $result object
	//
	$result = $wpdb->get_results( "SELECT * FROM $tableName"); 

	echo "<table>";

	echo "<tr>";
    echo  '<th colspan="6"> ADAPTER PLUG TABLE </th>';
    echo "</tr>";

	echo "<tr>";
	echo  "<th>" . "ID"        	 .  "</th>" 
		. "<th>" . "name"      	 .  "</th>" 
		. "<th>" . "description" .  "</th>" 
		. "<th>" . "size"    	 .  "</th>"
		. "<th>" . "cost"    	 .  "</th>"
        . "<th>" . "color"   	 .  "</th>";
		
	echo "</tr>";

	//Iterate through the $results object. Each $row is a row of the table
	// row is also an object
	//
	foreach($result as $row)  {

   		#Create a temp variable to hold the size display value
   		#
   		$size_display =  "unknown";
   		
  		#Use a SWITCH statement to set the size display value
   		#
   		switch ($row->size) {
    		case 1:
    		case 2:
    		case 3:
      			$size_display =  "SMALL";
        		break;
    		case 4:
    		case 5:
    		case 6:
    		case 7:
    		    $size_display =  "MEDUIUM";
        		break;
     		case 8:
    		case 9:
    		case 10:
      			$size_display =  "LARGE";
        		break;
        	default:
       			$size_display = "Unknown size value";
		}
   		
   		#Format the database table price data as US currency with a $
   		#
        $number =  $row->cost;
        $cost_display = money_format('%(#10n',$number);  
 
   		#Format the color dislay value as an HTML font color statement
   		# First use the strtolower function to get the color value to all lowercase
   		#
  		$color_display = $row->color;
  		$color_display = strtolower( $color_display );

  		$color_display_html = "<font color=\"$color_display\">$color_display</font>";
  
        echo "<tr>";
   
   		echo  "<td>" . $row->ID             . "</td>"
   		    . "<td>" . $row->name           . "</td>"
   		    . "<td>" . $row->description    . "</td>"
   		    . "<td>" . $size_display        . "</td>"
       		. "<td>" . $cost_display        . "</td>"
       		. "<td>" . $color_display_html  . "</td>";
        
  		 echo "</tr>";
 
   }

   echo "</table>";
	
}
?>