<?php

defined('SYSPATH') or die('No direct script access.');

class Cookie extends Kohana_Cookie {

    public static $encryption = 'default';
    public static $salt = '2AS&!($sad';
    public static $expiration = Date::WEEK;

}

// End Cookie
