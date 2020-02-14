<?php
//File Name: PHPReturnExample3.php
//Purpose: Introduce PHP Return statement
//Author: Mike H Chase
//Date: 6-15-2015

//Call to the function "return_a_boolean" with 10
//
$rtn_value = return_a_boolean( 10 );

//Echo out the value of the returned integer
echo $rtn_value;
echo "<br>";
echo gettype($rtn_value);

//Call to the function "return_a_boolean" with 2
//  NOTE: false may not be visiable on all PHP
//   test sites
$rtn_value = return_a_boolean( 2 );

//Echo out the value of the returned integer
echo "<br>";
echo $rtn_value;
echo "<br>";
echo gettype($rtn_value);
 
//Function return_a_boolean. 
// if the entry argument is > 3, returns true
//   else returns false
//
function return_a_boolean( $a )  {

   if ( $a > 3 )   {
      return true;
   }
   else {
    return false;
   }
      
}


?>