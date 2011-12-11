<?php if ($create_success == TRUE): ?>
    <div class="alert-message success">
        <a class="close" href="#">×</a>
        <p><strong>Sucesso!</strong> Utilizador criado</p>
    </div>
<?php endif ?>

<?php if ($create_fail == TRUE): ?>
    <div class="alert-message error">
        <a class="close" href="#">×</a>
        <p><strong>Erro!</strong> dados inválidos</p>
    </div>
<?php endif ?>

<div class="row">
    <form action="<?php echo $_SERVER['PHP_SELF'] ?>" method="post" id="form">
        <div class="clearfix">
            <label for="usernameInput">Username: </label>
            <div class="input">
                <input class="xlarge" id="username" name="username" size="30" type="text" />
            </div>
        </div>
        <div class="clearfix">
            <label for="passwordInput">Password: </label>
            <div class="input">
                <input class="xlarge" id="password" name="password" size="30" type="password" />
            </div>
        </div><!-- /clearfix -->

        <div class="clearfix">
            <label for="xlInput">E-mail: </label>
            <div class="input">

                <input class="xlarge" id="email" name="email" size="30" type="text" />


            </div>
        </div><!-- /clearfix -->

        <div class="clearfix">
            <label for="xlInput">Roles: </label>
            <div class="input">

                <?php echo Form::select('role', ORM::factory('role')->find_all()->as_array('id','name')); ?>


            </div>
        </div><!-- /clearfix -->
        

        <div class="clearfix">
            <div class="actions">

                <input type="submit" class="btn primary" value="registrar">
            </div>         
        </div>
    </form>
</div>