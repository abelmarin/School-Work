<?php
//
//
//

 //The setlocale can be called first
 //
 setlocale( LC_MONETARY, "en_US" );


 $priceAmount = 1234.56;
 
 
 //Call function to display cost
 //
 display_dolar_value(  $priceAmount );


//Fucntion to display cost in money format
//
//
function display_dolar_value(  $cost ) {
  
   $costOutput = money_format( "%i",  $cost);
   echo "Price is $costOutput ". "</br>";
}




?>