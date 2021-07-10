<?php

namespace Drupal\my_first_d8cm\Controller;

class d8cmController {
  public function d8cm() {
    return array(
        '#title' =>  'My First D8CM',
        '#markup' => 'This is My First Drupal 8 Custom Module'
      );
  }
}