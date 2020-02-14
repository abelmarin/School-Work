<?php
   /*
   Plugin Name: My First WP Custom Plugin
   Description: a very basic HTML table output WP custom plugin
   Version: 1.0
   Author: Michael X. Chase
   File: my_first_wp_custum_plugin.php
   SQL Import File: n/a
   Folder to create: my-first-wp-custom-plugin
   Short code: [my-first-wp-plugin-shortcode]
   License: GPL2
   */
   
  add_shortcode( 'my-first-wp-plugin-shortcode', 'my_first_wp_plugin_entry_point' );

function my_first_wp_plugin_entry_point( $attributes ) {
	
	global $wpdb;

	echo "<table border=\"1\">";
	
	echo "<tr>" . "<td>"  . "My"        . "</td>" . "</tr>"
		. "<tr>" . "<td>" . "First"     . "</td>" . "</tr>"
		. "<tr>" . "<td>" . "Custom WP" . "</td>" . "</tr>"
		. "<tr>" . "<th>" . "Plugin"    . "</td>" . "</tr>";
	echo "</tr>";

	echo "</table>";
}
?>