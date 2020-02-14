<?php
//File Name: PHPClassExample6B.php
//Purpose: Demonstrate PHP Classes + property + method
//Author: Mike H Chase
//Date: 4-18-2015

class SimpleClass  
{
    // property declarations 
    private $var1 = 0;
    private $var2 = 0;
    private $var3 = 0;
    
    // method declaration 
    public function setAndCalcVariables($inp1, $inp2, $inp3) {
	    $this->var1 = $inp1;
		$this->var2 = $inp2;
		$this->var3 = $inp3;
        return ( ( $this->var1 + $this->var2) / $this->var3 );
    }    
}
$my_object = new SimpleClass();
echo  $my_object->setAndCalcVariables(10, 4, 2);
?>

