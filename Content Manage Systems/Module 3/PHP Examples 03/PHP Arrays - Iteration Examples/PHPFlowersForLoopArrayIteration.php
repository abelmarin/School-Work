//PHP Presentation 
// For loop array iteration example
//
<?php   

$flowers = array(
	'Rose',  
	'AMARYLLIS',  
	'Aster', 
	'BELLS OF IRELAND');

$max = sizeof( $flowers );

echo $max . "<br>";

for ( $i=0;  $i < $max;  $i++) {

  echo $flowers[$i]  .  "<br>";

}