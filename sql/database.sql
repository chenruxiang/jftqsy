



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
 `productcategory` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
alter table attribute comment '属性';


CREATE TABLE `attribute_option` (
 `id` varchar(255)  NOT NULL,
 `createdate` datetime NOT NULL default '0',
 `modifydate` datetime DEFAULT NULL,
 `attributeid` varchar(255) NOT NULL,
 `options` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
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


CREATE TABLE `specification` (
  `id` varchar(255) NOT NULL ,
  `createdate` datetime NOT NULL default '0',
  `modifydate` datetime DEFAULT NULL,
  `orders` int(11) DEFAULT NULL,
  `memo` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `type` int(11) NOT NULL,
  PRIMARY KEY (`id`)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8;
alter table specification comment '规格';

CREATE TABLE `specification_value` (
  `id` varchar(255) NOT NULL ,
  `createdate` datetime NOT NULL default '0',
  `modifydate` datetime DEFAULT NULL,
  `orders` int(11) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `specification` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8;
alter table specification_value comment '规格值';



CREATE TABLE `product` (
  `id` varchar(255) NOT NULL ,
  `createdate` datetime NOT NULL default '0',
  `modifydate` datetime DEFAULT NULL,
  `allocatedstock` int(11) NOT NULL,
  `attributevalue0` varchar(255) DEFAULT NULL,
  `attributevalue1` varchar(255) DEFAULT NULL,
  `attributevalue10` varchar(255) DEFAULT NULL,
  `attributevalue11` varchar(255) DEFAULT NULL,
  `attributevalue12` varchar(255) DEFAULT NULL,
  `attributevalue13` varchar(255) DEFAULT NULL,
  `attributevalue14` varchar(255) DEFAULT NULL,
  `attributevalue15` varchar(255) DEFAULT NULL,
  `attributevalue16` varchar(255) DEFAULT NULL,
  `attributevalue17` varchar(255) DEFAULT NULL,
  `attributevalue18` varchar(255) DEFAULT NULL,
  `attributevalue19` varchar(255) DEFAULT NULL,
  `attributevalue2` varchar(255) DEFAULT NULL,
  `attributevalue3` varchar(255) DEFAULT NULL,
  `attributevalue4` varchar(255) DEFAULT NULL,
  `attributevalue5` varchar(255) DEFAULT NULL,
  `attributevalue6` varchar(255) DEFAULT NULL,
  `attributevalue7` varchar(255) DEFAULT NULL,
  `attributevalue8` varchar(255) DEFAULT NULL,
  `attributevalue9` varchar(255) DEFAULT NULL,
  `cost` decimal(21,6) DEFAULT NULL,
  `fullname` varchar(255) NOT NULL,
  `hits` bigint(20) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `introduction` longtext,
  `isgift` bit(1) NOT NULL,
  `islist` bit(1) NOT NULL,
  `ismarketable` bit(1) NOT NULL,
  `istop` bit(1) NOT NULL,
  `keyword` varchar(255) DEFAULT NULL,
  `marketprice` decimal(21,6) NOT NULL,
  `memo` varchar(255) DEFAULT NULL,
  `monthhits` bigint(20) NOT NULL,
  `monthhitsdate` datetime NOT NULL,
  `monthsales` bigint(20) NOT NULL,
  `monthsalesdate` datetime NOT NULL,
  `name` varchar(255) NOT NULL,
  `point` bigint(20) NOT NULL,
  `price` decimal(21,6) NOT NULL,
  `sales` bigint(20) NOT NULL,
  `score` float NOT NULL,
  `scorecount` bigint(20) NOT NULL,
  `seodescription` varchar(255) DEFAULT NULL,
  `seokeywords` varchar(255) DEFAULT NULL,
  `seotitle` varchar(255) DEFAULT NULL,
  `sn` varchar(255) NOT NULL,
  `stock` int(11) DEFAULT NULL,
  `stockmemo` varchar(255) DEFAULT NULL,
  `totalscore` bigint(20) NOT NULL,
  `unit` varchar(255) DEFAULT NULL,
  `weekhits` bigint(20) NOT NULL,
  `weekhitsdate` datetime NOT NULL,
  `weeksales` bigint(20) NOT NULL,
  `weeksalesdate` datetime NOT NULL,
  `weight` int(11) DEFAULT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `goods` varchar(255) NOT NULL,
  `productcategory` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8;
alter table product comment '产品';


CREATE TABLE `xx_product_product_image` (
  `product` bigint(20) NOT NULL,
  `large` varchar(255) DEFAULT NULL,
  `medium` varchar(255) DEFAULT NULL,
  `orders` int(11) DEFAULT NULL,
  `source` varchar(255) DEFAULT NULL,
  `thumbnail` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  KEY `FK66470ABC79F8D99A` (`product`),
  CONSTRAINT `FK66470ABC79F8D99A` FOREIGN KEY (`product`) REFERENCES `xx_product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
alter table product comment '产品TUO';



