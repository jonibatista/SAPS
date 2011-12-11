<?php defined('SYSPATH') or die('No direct script access.'); ?>

<?php

/**
 * Description of gallery
 *
 * @author cesar
 */
class Controller_User extends Controller_Saps {

    public function before() {
        parent::before();
    }


    /**
     * Login Page
     */
    public function action_login() {


        if (Person::$isLoggedIn) {
            Request::current()->redirect("store/addContent");
        }
        $this->template->context = "login";
        $this->template->page_title = 'Login';
        $this->template->page_subtitle = 'Login';
        $this->template->login_fail = FALSE;


        $session = Session::instance();



        if ($_POST != NULL) {

            $post = Validation::factory($_POST);
            $post->rule('username', 'not_empty');
            $post->rule('password', 'not_empty');


            if ($post->check()) {

                // fazer save, ou create session
                $user = ORM::factory('user');

               // echo base64_encode($post['password']);
                // falta mter a pass tb
                $user->where('username', '=', $post['username'])
                        ->where('password', '=', hash('sha256',$post['password']))
                        ->find();

                if (!empty($user->username)) {

                    // criar sessao
                    $session->set('user_session', $user);
                    
                    Person::$isLoggedIn = TRUE;
                    Request::current()->redirect("store/addContent");
                    
                } else {
                    $this->template->login_fail = TRUE;
                }
            } else {
                $this->template->login_fail = TRUE;
            }
        }

        $this->template->content = View::factory('pages/loginView')
                ->bind('login_fail', $this->template->login_fail);
        ;
    }

    /**
     * Register Page
     */
    public function action_register() {

        if (!Person::$isLoggedIn) {
            Request::current()->redirect("user/login");
        }

        $this->template->context = "register";
        $this->template->page_title = 'Registar';
        $this->template->page_subtitle = 'Registar';
        $this->template->create_success = FALSE;
        $this->template->create_fail = FALSE;

        if ($_POST != NULL) {

            $post = Validation::factory($_POST);
            $post->rule('username', 'not_empty');
            $post->rule('password', 'not_empty');
            $post->rule('email', 'not_empty');
            $post->rule('email', 'email');
            $post->rule('role', 'not_empty');


            if ($post->check()) {

                $model = ORM::factory('user');
                $model->values(array(
                    'username' => $post['username'],
                    'email' => $post['email'],
                    'password' => hash('sha256',$post['password']),
                   
                ));

                if ($model->save()) {
                    $this->template->create_success = TRUE;
                    
                    $role = ORM::factory('rolesuser');
                    $data = array(
                            'user_id' => $model->id ,
                            'role_id' => $post['role']
                            );
                    $role->values($data);
                    $role->save();
                        
                }
            } else {
                $this->template->create_fail = TRUE;
            }
        }

        $this->template->content = View::factory('pages/registerView')
                ->bind('create_success', $this->template->create_success)
                ->bind('create_fail', $this->template->create_fail);
    }

    /**
     * 
     */
    public function action_logout() {


        $session = Session::instance();

        $session->delete('user_session');
        // Redirect back to the login page

        Person::$isLoggedIn = FALSE;
        Person::$isAdmin = FALSE;

        Request::current()->redirect("user/login");
    }

    
    
    
    
}
?>



