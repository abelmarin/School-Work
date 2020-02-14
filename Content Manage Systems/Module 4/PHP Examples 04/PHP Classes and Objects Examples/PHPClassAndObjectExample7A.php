<?php
//File Name: PHPClassExample6A.php
//Purpose: Demonstrate PHP Classes + property + method
//Author: Mike H Chase
//Date: 4-18-2015

class SimpleClass  
{
    // property declarations 
    private $var1 = 10;
    private $var2 = 4;
    private $var3 = 2;

    
    // method declaration 
    public function calcVariables() {
        return ( ( $this->var1 + $this->var2) / $this->var3 );
    }       
}

$my_object = new SimpleClass();
$my_object->var1 = 3;

?>

