//PHP Presentation 
// Foreach loop array iteration example
//
<?php   

$flowers = array(
	'Rose',  
	'AMARYLLIS',  
	'Aster', 
	'BELLS OF IRELAND');

//Iterate and display the arary item value
//
foreach ( $flowers as $value ) {

  echo $value  .  "<br>";

}

echo "<br>" . "<br>";

//Iterate and display the aray item Index ($key) 
//  and the array item value ($value)
//
foreach ( $flowers as $key=>$value ) {

  echo $value  .  ' ' . $key . "<br>";

}