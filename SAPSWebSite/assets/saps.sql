-- phpMyAdmin SQL Dump
-- version 3.4.5deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Oct 28, 2011 at 06:02 AM
-- Server version: 5.1.58
-- PHP Version: 5.3.6-13ubuntu3.2

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `saps`
--

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE IF NOT EXISTS `roles` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `description` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_name` (`name`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`id`, `name`, `description`) VALUES
(1, 'login', 'Login privileges, granted after account confirmation'),
(2, 'admin', 'Administrative user, has access to everything.'),
(3, 'shopkeeper', ''),
(4, 'shopmanager', '');

-- --------------------------------------------------------

--
-- Table structure for table `roles_users`
--

CREATE TABLE IF NOT EXISTS `roles_users` (
  `user_id` int(10) unsigned NOT NULL,
  `role_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `fk_role_id` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `sessions`
--

CREATE TABLE IF NOT EXISTS `sessions` (
  `session_id` varchar(24) NOT NULL,
  `last_active` int(10) unsigned NOT NULL,
  `contents` text NOT NULL,
  PRIMARY KEY (`session_id`),
  KEY `last_active` (`last_active`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `email` varchar(127) NOT NULL,
  `username` varchar(32) NOT NULL DEFAULT '',
  `password` char(64) NOT NULL,
  `logins` int(10) unsigned NOT NULL DEFAULT '0',
  `last_login` int(10) unsigned DEFAULT NULL,
  `reset_token` char(64) NOT NULL DEFAULT '',
  `status` varchar(20) NOT NULL DEFAULT '',
  `last_failed_login` datetime NOT NULL,
  `failed_login_count` int(11) NOT NULL DEFAULT '0',
  `created` datetime NOT NULL,
  `modified` datetime NOT NULL,
  `id_store` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_username` (`username`),
  UNIQUE KEY `uniq_email` (`email`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `email`, `username`, `password`, `logins`, `last_login`, `reset_token`, `status`, `last_failed_login`, `failed_login_count`, `created`, `modified`, `id_store`) VALUES
(1, 'admin@admin.com', 'admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', 0, NULL, '', '', '0000-00-00 00:00:00', 0, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 0);

-- --------------------------------------------------------

--
-- Table structure for table `user_identity`
--

CREATE TABLE IF NOT EXISTS `user_identity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `provider` varchar(255) NOT NULL,
  `identity` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `user_tokens`
--

CREATE TABLE IF NOT EXISTS `user_tokens` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) unsigned NOT NULL,
  `user_agent` varchar(40) NOT NULL,
  `token` varchar(40) NOT NULL,
  `created` int(10) unsigned NOT NULL,
  `expires` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_token` (`token`),
  KEY `fk_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `roles_users`
--
ALTER TABLE `roles_users`
  ADD CONSTRAINT `roles_users_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `roles_users_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `user_tokens`
--
ALTER TABLE `user_tokens`
  ADD CONSTRAINT `user_tokens_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- comando para criar a tabela store
CREATE TABLE IF NOT EXISTS stores(
	ids			int(10) unsigned NOT NULL AUTO_INCREMENT,
	namest		character varying(255) NOT NULL,
	address		character varying(255) NOT NULL,
	info		character varying(255),
	image       LONGBLOB      NOT NULL,
	imagec        character varying(255) NOT NULL,
CONSTRAINT stores_pkey PRIMARY KEY (ids)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8;

-- comando para criar a tabela AP

CREATE TABLE IF NOT EXISTS aps (
	ida			int(10)	unsigned	NOT NULL AUTO_INCREMENT,
	apmac       character varying(50) NOT NULL,
	position	character varying(255),
CONSTRAINT aps_pkey PRIMARY KEY (ida)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8;


-- comando para criar a tabela Store_AP

CREATE TABLE IF NOT EXISTS store_ap(
	idsa	    int(10)	unsigned	NOT NULL AUTO_INCREMENT,
	id_s      	int(10)	unsigned	NOT NULL,
	id_a     	int(10) unsigned 	NOT NULL,
	valuest		INTEGER     NOT NULL,
	CONSTRAINT storeap_pkey PRIMARY KEY (idsa),
CONSTRAINT fk_store_id FOREIGN KEY (id_s)
      REFERENCES stores (ids),
CONSTRAINT fk_ap_id_ FOREIGN KEY (id_a)
      REFERENCES aps (ida)

)ENGINE=InnoDB  DEFAULT CHARSET=utf8;

-- comando para criar a tabela Advertisments

CREATE TABLE IF NOT EXISTS advertisments(
	ida	    int(10)	unsigned	NOT NULL AUTO_INCREMENT,
	nameadv	  character varying(55) NOT NULL,
	info   	character varying(255),
	image       LONGBLOB      NOT NULL,
	imagec        character varying(255) NOT NULL,
	id_s   int(10) unsigned NOT NULL,
CONSTRAINT advertisments_pkey PRIMARY KEY (ida),    
CONSTRAINT fk_stores_advertisments_id FOREIGN KEY (id_s)
      REFERENCES stores (ids)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8;


--
-- Table structure for table store_sser
--

CREATE TABLE IF NOT EXISTS `stores_users` (
  `id_user` int(10) unsigned NOT NULL,
  `id_store` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id_user`,`id_store`),
CONSTRAINT fk_stores_id FOREIGN KEY (id_store)
      REFERENCES stores (ids),   
CONSTRAINT fk_users_id FOREIGN KEY (id_user)
      REFERENCES users (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--Inserir role admin admin
INSERT INTO `saps`.`roles_users` (`user_id`, `role_id`) VALUES ('1', '2');

