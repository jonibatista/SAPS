<?php foreach($content as $post): ?>
<h1>
    <?php echo $post->namest;
    ?>
</h1>
    <?php echo $post->address;  ?>
    <?php echo $post->info; ?>
    <?php echo $post->address;  ?>
<img class="thumbnail" src="/SAPSWebSite/application/upload/<?php echo $post->imagec ?>" alt=""> </img>
<hr/>
    <?php endforeach; ?>



