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
            <label for="mac">Mac: </label>
            <div class="input">
                <input class="xlarge" id="xlInput" name="mac" size="30" type="text" />
         <?php if (FALSE != ($adv_error = Arr::get($errors,'mac'))) : ?>
            <div class="alert-message error">
                <a class="close" href="#">×</a>
                <p><strong>Erro!</strong><?php echo $adv_error ?></p>
            </div>
        <?php endif ?>       
            </div>
        </div>
        <div class="clearfix">
            <label for="position">Position: </label>
            <div class="input">
                <input class="xlarge" id="xlInput" name="position" size="30" type="text" />
                <?php if (FALSE != ($adv_error = Arr::get($errors,'position'))) : ?>
                    <div class="alert-message error">
                        <a class="close" href="#">×</a>
                        <p><strong>Erro!</strong><?php echo $adv_error ?></p>
                    </div>
                <?php endif ?> 
            </div>
        </div><!-- /clearfix -->
        <div class="clearfix">
            <label for="xlInput">Store: </label>
            <div class="input">
                <?php echo Form::select('store', ORM::factory('store')->find_all()->as_array('ids','namest')); ?>
            </div>
        </div><!-- /clearfix -->
        <div class="clearfix">
            <label for="valuest">Value: </label>
            <div class="input">
                <input class="xlarge" id="xlInput" name="valuest" size="30" type="text" />
                <?php if (FALSE != ($adv_error = Arr::get($errors,'valuest'))) : ?>
                    <div class="alert-message error">
                        <a class="close" href="#">×</a>
                        <p><strong>Erro!</strong><?php echo $adv_error ?></p>
                    </div>
                <?php endif ?> 
            </div>
        </div><!-- /clearfix -->
        <div class="clearfix">
            <div class="actions">

                <input type="submit" class="btn primary" value="Add AP"/>
            </div>         
        </div>
        
    <?php echo Form::close() ?>
</div>