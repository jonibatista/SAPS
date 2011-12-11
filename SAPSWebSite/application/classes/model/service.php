<?php
 
/**
 * include the library files and the model
 */
 
class Model_Service extends Model
{
 
    /**
     * default constructor
     *
     * @param   void
     * @return  void
     */
    public function __construct()
    {
        parent::__construct();
    }
	
	/**
     * Add method
     *
     * @param Int $param1
     * @param Int $param2
     * @return Int
     */
	public function math_add($param1, $param2) {
        return $param1+$param2; 
    }
    	
}
 
?>