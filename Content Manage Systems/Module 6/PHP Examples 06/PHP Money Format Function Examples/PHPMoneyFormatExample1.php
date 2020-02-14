<?php
//File Name: PHPMoneyFormat1.php
//Purpose: Prewritten Functions Money Format Funciton
//Author: Mike H Chase
//Date: 4-10-2015

   $priceAmount = 1234.56;
   
   setlocale( LC_MONETARY, "en_US" );
   $priceOut1 = money_format( "%i",  $priceAmount);
   echo "Price with " . '"%i"' . "  " . $priceOut1 . "</br>";

   setlocale( LC_MONETARY, "en_US" );
   $priceOut2 = money_format( "%.2n",  $priceAmount);
   echo "Price with " . '"%.2n"' . "  " . $priceOut2 . "</br>";
	
    
   setlocale( LC_MONETARY, "de_DE" );
   $priceOut3 = money_format( "%i",  $priceAmount);
   echo "Price with " . 'de_DE and "%i"' . "  " . $priceOut3 . "</br>";

?>

