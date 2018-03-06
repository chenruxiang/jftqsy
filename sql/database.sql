



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

CREATE TABLE `product_specification` (
  `id` varchar(255) NOT NULL ,
  `createdate` datetime NOT NULL default '0',
  `modifydate` datetime DEFAULT NULL,
  `orders` int(11) NOT NULL default 1,
  `memo` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `type` int(11) NOT NULL,
  `productid` varchar(255) NOT NULL ,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
alter table product_specification comment '产品规格';


CREATE TABLE `product_specification_value` (
  `id` varchar(255) NOT NULL ,
  `createdate` datetime NOT NULL default '0',
  `modifydate` datetime DEFAULT NULL,
  `orders` int(11) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `productspecificationid` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
alter table product_specification comment '产品规格值';

CREATE TABLE `product_sku` (
  `id` varchar(255) NOT NULL ,
  `createdate` datetime NOT NULL default '0',
  `modifydate` datetime DEFAULT NULL,
  `allocatedstock` int(11) DEFAULT 0,
  `sn` varchar(255) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `stockmemo` varchar(255) DEFAULT NULL,
  `productspecificationvalueid1` varchar(255) DEFAULT NULL,
  `productspecificationvalueid2` varchar(255) DEFAULT NULL,
  `productid` varchar(255) NOT NULL ,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
alter table product_sku comment '产品规格SKU';

CREATE TABLE `product` (
  `id` varchar(255) NOT NULL ,
  `createdate` datetime NOT NULL default '0',
  `modifydate` datetime DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `introduction` longtext,
  `isgift` bit(1) NOT NULL,
  `islist` bit(1) NOT NULL,
  `ismarketable` bit(1) NOT NULL,
  `istop` bit(1) NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` decimal(21,6) NOT NULL,
  `productcategoryid` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8;
alter table product comment '产品';


CREATE TABLE `product_product_image` (
  `id` varchar(255) NOT NULL ,
  `createdate` datetime NOT NULL default '0',
  `modifydate` datetime DEFAULT NULL,
  `productid` varchar(255) NOT NULL,
  `large` varchar(255) DEFAULT NULL,
  `medium` varchar(255) DEFAULT NULL,
  `orders` int(11) DEFAULT NULL,
  `source` varchar(255) DEFAULT NULL,
  `thumbnail` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
alter table product_product_image comment '产品图片';


CREATE TABLE `product_parameter_value` (
  `id` varchar(255) NOT NULL ,
  `createdate` datetime NOT NULL default '0',
  `modifydate` datetime DEFAULT NULL,
  `productid` varchar(255) NOT NULL,
  `parametervalue` varchar(255) DEFAULT NULL,
  `parametervaluekey` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
alter table product_parameter_value comment '产品参数';

CREATE TABLE `product_attribute_value` (
  `id` varchar(255) NOT NULL ,
  `createdate` datetime NOT NULL default '0',
  `modifydate` datetime DEFAULT NULL,
  `productid` varchar(255) NOT NULL,
  `attributevalue` varchar(255) DEFAULT NULL,
  `attributevaluekey` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
alter table product_attribute_value comment '产品属性';


CREATE TABLE `cart` (
  `id` varchar(255) NOT NULL ,
  `createdate` datetime NOT NULL default '0',
  `modifydate` datetime DEFAULT NULL,
  `cartkey` varchar(255) NOT NULL,
  `memberid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
alter table cart comment '购物车';

CREATE TABLE `cart_item` (
  `id` varchar(255) NOT NULL ,
  `createdate` datetime NOT NULL default '0',
  `modifydate` datetime DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `cartid` varchar(255) NOT NULL,
  `productid` varchar(255) NOT NULL,
  `productskuid` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
alter table cart_item comment '购物车明细';








