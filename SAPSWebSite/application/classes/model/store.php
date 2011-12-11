<?php defined('SYSPATH') OR die('No direct access allowed.');  
  
class Model_store extends ORM  
{  
    public function rules() {
       
        
        return array(   
           
        'namest' => array(array('not_empty')),
            
        'info' => array(array('not_empty')),
            
        'address' => array(array('not_empty')),    
            
        );
    
    }
    
    protected $_has_many = array( 
    
   'ids'  =>  array('through'  =>  'store_ap') 
    );
    
    
}  
?>