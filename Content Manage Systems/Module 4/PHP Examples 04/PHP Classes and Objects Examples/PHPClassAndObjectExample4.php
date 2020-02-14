<?php
//File Name: PHPClassExample3.php
//Purpose: Demonstrate PHP Classes + property + method
//Author: Mike H Chase
//Date: 4-18-2015

class Horse {
	private $running = false;
    function run() {
        $this->running = true;
    }
function isRunning() {
if ($this->running == true ) 
echo "YES, the horse is running";
else
echo "No the horse is not running";
    }
}

    
$my_horse_obj = new Horse();
$my_horse_obj -> run();
$my_horse_obj-> isRunning();

?>

