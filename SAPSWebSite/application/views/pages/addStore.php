<div class="row">
    <?php if (FALSE != ($adv_error = Arr::get($message, 'valid'))) : ?>
    <div class="alert-message success">
        <a class="close" href="#">×</a>
        <p><strong>Sucesso!</strong><?php echo $adv_error ?></p>
    </div>
    <?php endif ?>
    <?php if (FALSE != ($adv_error = Arr::get($message, 'error'))) : ?>
    <div class="alert-message error">
        <a class="close" href="#">×</a>
        <p><strong>Erro!</strong><?php echo $adv_error ?></p>
    </div>
    <?php endif ?>
    <?php echo Form::open(NULL, array('enctype' => 'multipart/form-data')) ?>
        <div class="clearfix">
            <label for="nameadv">Store: </label>
            <div class="input">
                <input class="xlarge" id="xlInput" name="namest" size="30" type="text" />
         <?php if (FALSE != ($adv_error = Arr::get($errors,'namest'))) : ?>
            <div class="alert-message error">
                <a class="close" href="#">×</a>
                <p><strong>Erro!</strong><?php echo $adv_error ?></p>
            </div>
        <?php endif ?>       
            </div>
        </div>
        <div class="clearfix">
            <label for="address">Address: </label>
            <div class="input">
                <input class="xlarge" id="xlInput" name="address" size="30" type="text" />
                <?php if (FALSE != ($adv_error = Arr::get($errors,'address'))) : ?>
                    <div class="alert-message error">
                        <a class="close" href="#">×</a>
                        <p><strong>Erro!</strong><?php echo $adv_error ?></p>
                    </div>
                <?php endif ?> 
            </div>
        </div><!-- /clearfix -->
        <div class="clearfix">
            <label for="info">Info: </label>
            <div class="input">
                <input class="xlarge" id="xlInput" name="info" size="30" type="text" />
                <?php if (FALSE != ($adv_error = Arr::get($errors,'info'))) : ?>
                    <div class="alert-message error">
                        <a class="close" href="#">×</a>
                        <p><strong>Erro!</strong><?php echo $adv_error ?></p>
                    </div>
                <?php endif ?> 
            </div>
        </div><!-- /clearfix -->
        <div class="clearfix">
            <label for="xlInput">User: </label>
            <div class="input">

                <?php echo Form::select('user', ORM::factory('user')->find_all()->as_array('id','username')); ?>

            </div>
        </div><!-- /clearfix -->
        <div class="clearfix">
            <label for="info">Imagem: </label>
            <div class="input">
                <input class="xlarge" id="xlInput" name="image" size="30" type="file" />
            </div>
        <?php
        if (FALSE != ($image_error = Arr::path($errors,'image')))
            echo Form::label('image',$image_error, array('class'=>'error'))
        ?>
        </div><!-- /clearfix -->
        <div class="clearfix">
            <div class="actions">

                <input type="submit" class="btn primary" value="Add Store"/>
            </div>         
        </div>
        
    <?php echo Form::close() ?>
</div>