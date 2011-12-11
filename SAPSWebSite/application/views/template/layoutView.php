<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title><?php echo $page_title; ?></title>
        <meta name="description" content="">
        <meta name="author" content="">
        <!-- Le javascript -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>

        <script src="/SAPSWebSite/assets/js/bootstrap-modal.js"></script>
        <script src="/SAPSWebSite/assets/js/bootstrap-alerts.js"></script>
        <script src="/SAPSWebSite/assets/js/bootstrap-twipsy.js"></script>
        <script src="/SAPSWebSite/assets/js/bootstrap-popover.js"></script>
        <script src="/SAPSWebSite/assets/js/bootstrap-dropdown.js"></script>
        

        <?php echo HTML::style('assets/css/bootstrap.css'); ?>
        <!-- Le styles -->
        <link href="assets/css/docs.css" rel="stylesheet">
        <link href="assets/js/google-code-prettify/prettify.css" rel="stylesheet">
        <!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
        <!--[if lt IE 9]>
          <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

        <!-- Le styles -->
        <link href="../bootstrap.css" rel="stylesheet">
        <style type="text/css">
            body {
                padding-top: 60px;

            }
            .hero-unit {
                padding-top: 30px !important;
                padding-bottom: 30px !important;
            }
        </style>

        <link rel="shortcut icon" href="images/favicon.ico">

    </head>

    <body>




        <?php echo View::factory('template/menuView')->bind('user', $username)->bind('context', $context) ?>


        <div class="container">

            <!-- Main hero unit for a primary marketing message or call to action -->
            <div class="hero-unit">
                <h1>SAPS</h1>
                <p>Shopping Advertisement Positioning System</p>
            </div>
            <!--
            -->
            <h1><?php echo $page_subtitle; ?></h1>



<!--            <p>Zara Fashion</p>-->



            <?php echo $content; ?>




            <footer>
                <p>&copy; IPL 2011</p>
            </footer>

        </div> <!-- /container -->

    </body>
</html>
