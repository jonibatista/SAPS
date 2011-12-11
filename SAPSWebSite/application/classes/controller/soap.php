<?php defined('SYSPATH') or die('No direct script access.');
 
/**
 * include the library files and the model
 */
ini_set('include_path', ini_get('include_path').PATH_SEPARATOR.APPPATH.'vendor/');
include Kohana::find_file('vendor','Zend/Soap/AutoDiscover');
include Kohana::find_file('vendor','Zend/Soap/Server');
include Kohana::find_file('classes','model/service');
 
class Controller_Soap extends Controller
{
    /**
     * Soap controller
     *
     * @param void
     * @return void
     */
    public function __construct()
    {
        // The default headers are set to html by default
        Request::current()->headers['Content-Type'] = 'text/xml; charset='.Kohana::$charset;
    }
 
    /**
     * Soap service
     *
     * @param void
     * @return void
     */
    public function action_service()
    {
        // disable wsdl cache
        ini_set('soap.wsdl_cache_enabled', '0');
 
        $wsdl = 'http://' . $_SERVER['HTTP_HOST'] . '/soap/wsdl';
        $server = new SoapServer($wsdl);
        $server->setClass('Model_Service');
        $server->handle();
 
    }
 
    /**
     * Soap wsdl
     *
     * @param void
     * @return void
     */
    public function action_wsdl()
    {
        // disable wsdl cache
        ini_set('soap.wsdl_cache_enabled', '0');
 
        $wsdl = new Zend_Soap_AutoDiscover();
        $wsdl->setOperationBodyStyle(array('use' => 'literal','namespace' => 'http://framework.zend.com'));
        $wsdl->setUri('http://' . $_SERVER['HTTP_HOST'] . '/soap/service');
        $wsdl->setClass('Model_Service');
        $wsdl->handle();
     }
}