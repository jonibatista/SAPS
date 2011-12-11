<?php 

foreach($content as $post):

?>
<h1>
    <?php echo $post->nameadv;
    ?>
</h1>

    <?php echo $post->info; ?>

<hr/>
    <?php endforeach;
?>



