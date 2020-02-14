<?php
//File Name: SpaceshipOperatorExample.php
//Purpose: Introduce PHP spaceship operator '<=>'
//Author: Mike H Chase
//Date: 9-25-2018

  //Return 0 if values on either side are equal
  //Return 1 if value on the left is greater
  //Return -1 if the value on the right is greater
   
 //Comparing Integers

    echo 1 <=> 1; //ouputs 0
    echo 3 <=> 4; //outputs -1
    echo 4 <=> 3; //outputs 1

    //String Comparison

    echo "x" <=> "x"; // 0
    echo "x" <=> "y"; //-1
    echo "y" <=> "x"; //1

?>