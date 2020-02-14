//File: Optional Arguments FuncGetArgsExample.php
//
//
//
<?php

//
//
//
function foo( ) {
	
	//returns an array of the passed in arguments
	//
	$args = func_get_args();

	if ( sizeof( $args) == 0 ) {
	   echo "funciton called with zero arguments";	
	}

	foreach ($args as $key => $value ) {
		
		echo "arg" . "$key" . " value: " . $value . " ";
	}
	
	echo "<br><br>";
	
}


//
//
foo( );

foo( 'FIRST');

foo( 'hello', 'world');

foo( "now", "and", "then" );

?>