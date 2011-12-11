<?php 

foreach($content as $post):

?>
<h1>
    <?php echo $post->apmac;
    ?>
</h1>

    <?php echo $post->position; ?>

<hr/>
    <?php endforeach;
?>

