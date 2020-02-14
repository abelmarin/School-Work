//PHP Car Array Iteration using For Statement
//
//
<?php 

$cars = array('Volvo',  'BMW',  'Toyota');

$array_length = count($cars);

for ( $x=0;  $x < $array_length;  $x++ )
{
  echo $cars[$x] . "<br>";
}

?>
