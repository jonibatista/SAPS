<div class="topbar" data-dropdown="dropdown" >
    <div class="topbar-inner">
        <div class="container">
            <h3><a href="#">IPL</a></h3>
            <ul class="nav">
                <li><a href="/SAPSWebSite/">Home</a></li>
                <?php if (Person::$isLoggedIn) : ?>
                    <li <?php echo ($context == "gallery") ? 'class="active"' : ''; ?>><a href="/SAPSWebSite/store/gallery">Galeria</a></li>
                    <li <?php echo ($context == "addContent") ? 'class="active"' : ''; ?>><a href="/SAPSWebSite/store/addContent">Adicionar Conteúdo</a></li>
                    <li <?php echo ($context == "adv") ? 'class="active"' : ''; ?>><a href="/SAPSWebSite/store/adv">Anuncios</a></li>
                    <li <?php echo ($context == "addadv") ? 'class="active"' : ''; ?>><a href="/SAPSWebSite/store/addadv">Adicionar Anuncios</a></li>
                    <?php  if (Person::$isAdmin): ?>
                    <li <?php echo ($context == "register") ? 'class="active"' : ''; ?>><a href="/SAPSWebSite/user/register">Registar</a></li>
                    <li <?php echo ($context == "stores") ? 'class="active"' : ''; ?>><a href="/SAPSWebSite/store/stores">Lojas</a></li>
                    <li <?php echo ($context == "addstores") ? 'class="active"' : ''; ?>><a href="/SAPSWebSite/store/addstores">Adicionar Lojas</a></li>
                    <li <?php echo ($context == "ap") ? 'class="active"' : ''; ?>><a href="/SAPSWebSite/store/ap">Aps</a></li>
                    <li <?php echo ($context == "addap") ? 'class="active"' : ''; ?>><a href="/SAPSWebSite/store/addap">Adicionar Aps</a></li>
                    
                    <?php endif ?>
                <?php else: ?>
                    <li <?php echo ($context == "login") ? 'class="active"' : ''; ?>><a href="/SAPSWebSite/user/login">Login</a></li>
                <?php endif ?>
                
                
                   

            </ul>
            <?php if (Person::$isLoggedIn) : ?>
                <ul class="nav secondary-nav">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle"><?php echo $user; ?></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Alterar definições</a></li>
                            <li><a href="#">Mudar password</a></li>
                            <li class="divider"></li>
                            <li><a href="/SAPSWebSite/user/logout">Sair</a></li>
                        </ul>
                    </li>
                </ul>
            <?php endif ?>
        </div>
    </div><!-- /topbar-inner -->
</div><!-- /topbar -->
