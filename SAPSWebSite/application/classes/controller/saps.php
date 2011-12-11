<?php

defined('SYSPATH') or die('No direct script access.');

/**
 * Description of gallery
 *
 * @author cesar
 */
class Controller_SAPS extends Controller_Template {

    public $template = 'template/layoutView';
    public $session;

    public function before() {
        parent::before();

        $this->template->page_title = 'Default';
        $this->template->page_subtitle = 'Default';
        $this->template->menu = View::factory('template/menuView');
        $this->template->controller_name = $this->request->param('controller');
        $this->template->content = "default";

        // Get the session instance
        $session = Session::instance();

        $utilizador = $session->get('user_session');

        if (isset($utilizador)) {
            $this->template->username = $utilizador->username;
            Person::$isLoggedIn = TRUE;
            $role = ORM::factory('rolesuser');
            $user= ORM::factory('user');
            $user->where('username', '=', $utilizador->username )->find();
            $role->where('user_id', '=', $user->id )->find();
            if($role->role_id == 2){
                Person::$isAdmin = TRUE;
            }
            
            
        } else {
            $this->template->username = 'Guest'; // IR BUSCAR A QQ LADO
        }
    }

}
?>



