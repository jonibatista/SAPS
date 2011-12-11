<?php defined('SYSPATH') or die('No direct script access.'); ?>

<?php

/**
 * Description of gallery
 *
 * @author cesar
 */
class Controller_Store extends Controller_Saps {

    public function before() {
        parent::before();
//        Auth::instance()->get_user()
    }

    public function action_addContent() {
        if (!Person::$isLoggedIn) {
            Request::current()->redirect("user/login");
        }

        $this->template->context = "addContent";
        $this->template->page_title = 'Adicionar conteudo';
        $this->template->page_subtitle = 'Adicionar';
        $this->template->content = View::factory('pages/addContentView');
        
        $this->template->login_fail = FALSE;


        $session = Session::instance();



        if ($_POST != NULL) {

            $post = Validation::factory($_POST);
            $post->rule('username', 'not_empty');
            $post->rule('password', 'not_empty');


            if ($post->check()) {

                // fazer save, ou create session
                $user = ORM::factory('advertisment');

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

    public function action_gallery() {

        if (!Person::$isLoggedIn) {
            Request::current()->redirect("user/login");
        }
        $this->template->context = "gallery";
        $this->template->page_title = 'Galeria';
        $this->template->page_subtitle = 'Galeria';
        $this->template->content = View::factory('pages/galleryView');

    }

    public function action_adv()
    {
        if (!Person::$isLoggedIn) {
            Request::current()->redirect("user/login");
        }
        
        $this->template->context = "Anuncios Publicados";
        $this->template->page_title = 'Anuncios Publicados';
        $this->template->page_subtitle = 'Anuncios Publicados';
        
        if (HTTP_Request::POST == $this->request->method())
        {
                
            $post = $_POST;
            
            $user = ORM::factory('advertisment')->find($post['id']);
            $user->delete();

        }

        $shops = ORM::factory('advertisment')->find_all();
        $ko3 = array ();
        $ko3['content'] = $shops;
 
        $this->template->content = View::factory('pages/advertismentView', $ko3);
       
        
        
        
    }
    

    
    public function action_addadv() {
                
        
        if (!Person::$isLoggedIn) {
            Request::current()->redirect("store/addContent");
        }

        $this->template->context = "Adicionar Anuncio";
        $this->template->page_title = 'Adicionar Anuncio';
        $this->template->page_subtitle = 'Adicionar Anuncio';
        

         if (HTTP_Request::POST == $this->request->method())
        {
             $file = array ();
            $file = $_FILES['image'];
             
            try
            {   
                 $post = array();
                 $post = $_POST;
                 // Read the file 
                 if (isset($_FILES['image']) && $_FILES['image']['size'] > 0) {
                      $tmpName  = $_FILES['image']['tmp_name'];  
                      $fp      = fopen($tmpName, 'r');
                      $data = fread($fp, filesize($tmpName));
                      $data = addslashes($data);
                      fclose($fp);
                      $filename = uniqid().Inflector::humanize($file['name']);
                      $path = Upload::save($file, $filename);
                      
                 }
                  $session = Session::instance();
                  $utilizador = $session->get('user_session');
                  
                  $storeid = new Model_storeuser;
                  $storeid->where('id_user', '=', $utilizador->id )->find();

                 $data = array(
                     'nameadv' => $post['nameadv'],
                     'info' => $post['info'],
                     'image' => $data,
                     'imagec' => $filename,
                     'id_s' => $storeid->id_store
                     
                 );
        
                $adv = new Model_advertisment();
                $adv->values($data);
                $adv->save();
                
                //devolve mensagem de successo
                    $message = array(
                        'valid' => ' Advertisment Successful Created'
                    );
                
            }
            catch(ORM_Validation_Exception $e)
            {
                $message = array(
                    'error' => 'error'
                );
                $errors = $e->errors('users');
            }
        }
 
        $this->template->content=View::factory('pages/addAdvertisment')
                ->bind('errors',$errors)
                ->bind('message',$message);
        
        
        
        
       // $post = Validation::factory( $_POST );
       // $file = Validation::factory( $_FILES );
        
       // $file->rule( 'form', array( 'Upload', 'not_empty' ) );
       // $file->rule( 'form', array( 'Upload', 'valid' ) );  
        
/*
        if ( Request::current()->method() == Request::POST && $post->check() && $file->check() ) 
        {
	// the request is valid, do your processing

	// save the uploaded file with the name 'form' to our destination
            $filename = Upload::save( $file['form'] );

            if ( $filename === false ) {
                    throw new Exception( 'Unable to save uploaded file!' );
            }
            
            $adv = new Model_advertisment();
            //$adv->add($alias, $far_keys)
            $adv->values($_POST);
            $adv->save();


            $shops = ORM::factory('advertisment')->find_all();
            $ko3 = array ();
            $ko3['content'] = $shops;
            $this->template->content = View::factory('pages/posts',$ko3)
                ->bind('errors',$errors)
                ->bind('message',$message);
            
            
            
        }
        
        $errors = Arr::merge( $post->errors( 'some/messages/post' ), $file->errors( 'some/messages/file' ) );
	
        if ($_POST != NULL) {

            $post = Validation::factory($_POST);
            $post->rule('name', 'not_empty');
            $post->rule('type', 'not_empty');
            $post->rule('info', 'not_empty');
            $post->rule('store', 'not_empty');


            if ($post->check()) {

                // fazer save, ou create session
                $adv = new Model_advertisment();
                //$adv->add($alias, $far_keys)
                $adv->name = $post['name'];
                $adv->type = $post['type'];
                $adv->info = $post['info'];
                $adv->store = $post['store'];
                $adv->save();
        
                $this->template->content = View::factory('pages/posts');

            } 
        } */

       }
       
       public function action_addstores() {
                
        
        if (!Person::$isLoggedIn) {
            Request::current()->redirect("store/addContent");
        }

        $this->template->context = "Add Store";
        $this->template->page_title = 'Add Store';
        $this->template->page_subtitle = 'Add Store';
        
        if (HTTP_Request::POST == $this->request->method())
        {
            
            $file = array ();
            $file = $_FILES['image'];
            try
            {   
                  // Temporary file name stored on the server
                  if (isset($_FILES['image']) && $_FILES['image']['size'] > 0) {
                      
                      $tmpName  = $_FILES['image']['tmp_name'];  
                      $fp      = fopen($tmpName, 'r');
                      $data = fread($fp, filesize($tmpName));
                      $data = addslashes($data);
                      fclose($fp);
                      $filename = uniqid().Inflector::humanize($file['name']);
                      $path = Upload::save($file, $filename);
                      //$image = Image::factory($_FILES['image']['tmp_name']);
                      //$data = base64_encodefile_get_contents($_FILES['image']['tmp_name']));
                      //$size = filesize($image->file);
                      
                      
                 }

                 $post = array();
                 $post = $_POST;
                 $data = array(
                     'namest' => $post['namest'],
                     'address' => $post['address'],
                     'info' => $post['info'],
                     'image' => $data,
                     'imagec' => $filename
                     
                 );
          
                $str = new Model_store();
                $str->values($data);
                $str->save();
                    
                    $dtr = array(
                        'id_user' => $post['user'],
                        'id_store' => $str->id
                        
                        
                    );
                    
                    $roleuser = new Model_storeuser();
                    $roleuser->values($dtr);
                    $roleuser->save();
                        //devolve mensagem de successo
                    $message = array(
                        'valid' => ' Store Successful Created'
                    );
                    
                    
                    
                                
            }
            catch(ORM_Validation_Exception $e)
            {
                $message = array(
                    'error' => 'error'
                );

                $errors = $e->errors('stores');
            }
        }
 
        $this->template->content=View::factory('pages/addStore')
                ->bind('errors',$errors)
                ->bind('message',$message);

       }
       
       public function action_stores() {
                
        
        if (!Person::$isLoggedIn) {
            Request::current()->redirect("store/addContent");
        }

        $this->template->context = "Lojas";
        $this->template->page_title = 'Lojas';
        $this->template->page_subtitle = 'Lojas';
       
        
        $shops = ORM::factory('store')->find_all();
        $ko3 = array ();
        $ko3['content'] = $shops;
        
       // $this->template->header
         //   >headers('Content-Type','image/png')
           // ->body($image->image)
        $this->template->content = View::factory('pages/storeView', $ko3);

  

        //$this->response->headers('content-type', 'image/jpeg') = View::factory('pages/storeView', $ko3);
        //$this->response->request = View::factory('pages/storeView')->bind('content', $ko3);
        //$this->template->response->
          //              ->body($ko3);
       }
       
       public function action_addap() {
                
        
        if (!Person::$isLoggedIn) {
            Request::current()->redirect("store/addContent");
        }

        $this->template->context = "Adicionar AP";
        $this->template->page_title = 'Adicionar AP';
        $this->template->page_subtitle = 'Adicionar AP';
       
        
         
        if (HTTP_Request::POST == $this->request->method())
        {
            try
            {   
                 $post = array();
                 $post = $_POST;
                 $data = array(
                     'apmac' => $post['mac'],
                     'position' => $post['position']
                     
                 );
          
                $ap = new Model_ap();
                $ap->values($data);
                $ap->save();
                    
                    $dtr = array(
                        'id_s' => $post['store'],
                        'id_a' => $ap->ida,
                        'valuest' => $post['valuest']
                        
                        
                    );
                    
                    $storeap = new Model_storeap;
                    $storeap->values($dtr);
                    $storeap->save();
                        //devolve mensagem de successo
                    $message = array(
                        'valid' => ' AP Successful Created'
                    );
                                 
            }
            catch(ORM_Validation_Exception $e)
            {
                $message = array(
                    'error' => 'error'
                );

                $errors = $e->errors('ap');
            }
        }
 
        $this->template->content=View::factory('pages/addAp')
                ->bind('errors',$errors)
                ->bind('message',$message);
        
       }
       
       
       public function action_ap() {
                
        
        if (!Person::$isLoggedIn) {
            Request::current()->redirect("store/addContent");
        }

        $this->template->context = "AP";
        $this->template->page_title = 'AP';
        $this->template->page_subtitle = 'AP';
       
        
        if (HTTP_Request::POST == $this->request->method())
        {
            $post = $_POST;
            
            $storeid = new Model_storeap;
            $storeid->where('id_a', '=', $post['id'])->find();
            
            $apstore = ORM::factory('storeap')->find($storeid->idsa);
            $apstore->delete();
            
            $ap = ORM::factory('ap')->find($post['id']);
            $ap->delete();
              
            
        }
        
        
        $shops = ORM::factory('ap')->find_all(); 
        $ko3 = array ();
        $ko3['content'] = $shops;
        
        $this->template->content = View::factory('pages/apView', $ko3);
        
       }
       
       
       
}
?>



