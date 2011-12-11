<?php defined('SYSPATH') OR die('No direct access allowed.');  
  
class Model_advertisment extends ORM  
{  
    protected $_attach_allow = true;
    protected $_attach_allowed_extensions = 'jpg jpeg pdf tif tiff';
    
    public function rules() {
       
        
        return array(   
           
        'nameadv' => array(array('not_empty')),
            
            
        'info' => array(array('not_empty')),
            
        'id_s' => array(array('not_empty')),  
            
    );
    
    }
    
}  
?>