<?php
//File Name: PHPClassExample2.php
//Purpose: Demonstrate PHP Classes + property + method
//Author: Mike H Chase
//Date: 4-18-2015

class SimpleClass  
{
    // property declaration 
    public $var = 'a default value';

    // method declaration 
    public function displayVar() {
        echo $this->var;
    }
    
    // method declaration 
    public function setVar($argIn) {
        $this->var = $argIn;;
    }  
    
}

$simp_object = new SimpleClass();

echo "Class Property:" . $simp_object->var . "</br>"; //access class property

echo "Class Method: "; 
echo $simp_object->displayVar() . "</br>";; //access class method

echo $simp_object->setVar('my new value') . "</br>";; //access class method

echo "Class Method: "; 
echo $simp_object->displayVar() . "</br>";; //access class method

?>

