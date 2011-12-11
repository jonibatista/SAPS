
<?php if ($login_fail == TRUE): ?>
    <div class="alert-message error">
        <a class="close" href="#">×</a>
        <p><strong>Erro!</strong> login falhou</p>
    </div>
<?php endif ?>
<div class="row">
    <form action="<?php echo $_SERVER['PHP_SELF'] ?>" method="post" id="form">
        <div class="clearfix">
            <label for="xlInput">Username: </label>
            <div class="input">
                <input class="xlarge" id="username" name="username" size="30" type="text" />
            </div>
        </div>
        <div class="clearfix">
            <label for="xlInput">Password: </label>
            <div class="input">
                <?php /*echo Form::password('password', NULL, array('size' => '30', 'class' => 'xlarge');*/ ?>
                <input class="xlarge" id="password" name="password" size="30" type="password" />
            </div>
        </div><!-- /clearfix -->


        <div class="clearfix">
            <div class="actions">

                <input type="submit" class="btn primary" value="login">
            </div>         
        </div>
    </form>
</div>