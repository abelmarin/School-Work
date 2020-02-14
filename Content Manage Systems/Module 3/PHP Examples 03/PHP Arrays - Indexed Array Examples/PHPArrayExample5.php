<?php
//File Name: PHPArrayExample5.php
//Purpose: More PHP Iterating through Associative Arrays 
//         A nested Foreach statement
//Author: Mike H Chase 
//Date: 4-09-2014

$result = array( array( 'What' => 'rose',
                      'Price' => 1.25,
                      'Number' => 15
                    ),
               array( 'What' => 'daisy',
                      'Price' => 0.75,
                      'Number' => 25,
                    ),
               array( 'What' => 'orchid', 
                      'Price' => 1.15,
                      'Number' => 7 
                    )
             );


foreach($result as $row)
{
    foreach($row as $key => $value)
    {
        echo  $key . " :" . $value . "<br>";
     }
}

?>