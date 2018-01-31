



CREATE TABLE `admin` (
 `id` varchar(255) NOT NULL,
 `create_date` datetime NOT NULL default '0',
 `modify_date` datetime DEFAULT NULL,
 `department` varchar(255) DEFAULT NULL,
 `email` varchar(255) NOT NULL default '0',
 `is_enabled` bit(1) NOT NULL default 0,
 `is_locked` bit(1) NOT NULL default 0,
 `locked_date` datetime DEFAULT NULL,
 `login_date` datetime DEFAULT NULL,
 `login_failure_count` int(11) NOT NULL default 0,
 `login_ip` varchar(255) DEFAULT NULL,
 `name` varchar(255) DEFAULT NULL,
 `password` varchar(255) NOT NULL default '0',
 `username` varchar(255) NOT NULL default '0',
 PRIMARY KEY (`id`),
 UNIQUE KEY `username` (`username`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
alter table admin comment '管理员';


CREATE TABLE `member` (
  `id` varchar(255) NOT NULL ,
  `create_date` datetime NOT NULL default '0',
  `modify_date` datetime DEFAULT NULL,
  `username` varchar(255) NOT NULL default '0',
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL default '0',
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL default '0',
  `mobile` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



