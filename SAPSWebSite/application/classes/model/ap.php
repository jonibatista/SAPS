<?php defined('SYSPATH') OR die('No direct access allowed.');  
  
class Model_ap extends ORM  
{  
    protected $_primary_key = 'ida';
    
    public function rules() {
       
        
        return array(   
           
        'apmac' => array(array('not_empty')),
          
		);
    
    }
    
    protected $_has_many = array( 
    
   'ida'  =>  array('through'  =>  'store_ap') 
    );
    
    
}  
?>