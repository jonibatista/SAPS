<?php foreach($content as $post): ?>
    <?php echo Form::open(NULL,NULL) ?>  
    <div class="img">
        <div class="desc"><?php echo $post->namest;?></div>
        <p></p>
        <a href="#">
        <img class="thumbnail" src="<?php echo '/SAPSWebSite/upload/'.$post->imagec ?>" alt="" width="110" height="90"> </img>
        </a>
        <p></p>
        <div class="desc"><?php echo $post->info;?></div>
        <p></p>

        <?php echo Form::close() ?>
    </div>
    <hr/>
<?php endforeach; ?>




