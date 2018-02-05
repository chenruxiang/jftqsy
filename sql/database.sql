



CREATE TABLE `admin` (
 `id` varchar(255) NOT NULL,
 `createdate` datetime NOT NULL default '0',
 `modifydate` datetime DEFAULT NULL,
 `department` varchar(255) DEFAULT NULL,
 `email` varchar(255) NOT NULL default '0',
 `isenabled` bit(1) NOT NULL default 0,
 `islocked` bit(1) NOT NULL default 0,
 `lockeddate` datetime DEFAULT NULL,
 `logindate` datetime DEFAULT NULL,
 `loginfailure_count` int(11) NOT NULL default 0,
 `loginip` varchar(255) DEFAULT NULL,
 `name` varchar(255) DEFAULT NULL,
 `password` varchar(255) NOT NULL default '0',
 `username` varchar(255) NOT NULL default '0',
 PRIMARY KEY (`id`),
 UNIQUE KEY `username` (`username`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
alter table admin comment '管理员';


CREATE TABLE `member` (
  `id` varchar(255) NOT NULL ,
  `createdate` datetime NOT NULL default '0',
  `modifydate` datetime DEFAULT NULL,
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
alter table member comment '会员';


CREATE TABLE `product_category` (
  `id` varchar(255) NOT NULL,
  `createdate` datetime NOT NULL default '0',
  `modifydate` datetime DEFAULT NULL,
  `orders` int(11) DEFAULT NULL,
  `grade` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `seodescription` varchar(255) DEFAULT NULL,
  `seokeywords` varchar(255) DEFAULT NULL,
  `seotitle` varchar(255) DEFAULT NULL,
  `treepath` varchar(255) NOT NULL,
  `parent` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
alter table product_category comment '目录';


CREATE TABLE `attribute` (
 `id` varchar(255)  NOT NULL,
 `createdate` datetime NOT NULL default '0',
 `modifydate` datetime DEFAULT NULL,
 `orders` int(11) DEFAULT NULL,
 `name` varchar(255) NOT NULL,
 `propertyindex` int(11) DEFAULT NULL,
 `productcategory` varchar(255) NOT NULL,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
alter table attribute comment '属性';


CREATE TABLE `attribute_option` (
 `attribute` varchar(255) NOT NULL,
 `options` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
alter table attribute_option comment '属性集';


CREATE TABLE `parameter` (
 `id` varchar(255)  NOT NULL,
 `createdate` datetime NOT NULL default '0',
 `modifydate` datetime DEFAULT NULL,
 `orders` int(11) DEFAULT NULL,
 `name` varchar(255) NOT NULL,
 `parametergroup` varchar(255) NOT NULL,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
alter table parameter comment '参数';


CREATE TABLE `parameter_group` (
 `id` varchar(255) NOT NULL ,
 `createdate` datetime NOT NULL default '0',
 `modifydate` datetime DEFAULT NULL,
 `orders` int(11) DEFAULT NULL,
 `name` varchar(255) NOT NULL,
 `productcategory` varchar(255) NOT NULL,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
alter table parameter_group comment '参数组';


