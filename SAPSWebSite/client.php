<?php
    $wsdl = "http://localhost/saps/soap/wsdl";
    $client = new SoapClient($wsdl ,array(
    "trace"      => 1,
    "exceptions" => 0));
 
    $functions = $client->__getFunctions();
    foreach($functions as $function)
    {
        print_r($function);
    }
 
    $client->DoSomething('test');
 
    print "<pre>";
    print "Request :\n".htmlspecialchars($client->__getLastRequest()) ."\n";
    print "Response:\n".htmlspecialchars($client->__getLastResponse())."\n";
    print "</pre>";
?>