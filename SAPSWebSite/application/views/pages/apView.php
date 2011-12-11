<?php foreach($content as $post): ?>
    <?php echo Form::open(NULL,NULL) ?>  
    <div class="img">
        <div class="desc"><?php echo $post->apmac;?></div>
        <p></p>
        <div class="desc"><?php echo $post->position;?></div>
        <p></p>
        <input name="id" type="hidden" value="<?php $post->ida ?>"/>
        <p></p>
        <div class="action">
                <input type="submit" class="btn primary" value="Delete"/>
       </div>  
        <?php echo Form::close() ?>
    </div>
    <hr/>
<?php endforeach; ?>

