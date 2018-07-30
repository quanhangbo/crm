drop database hibernate_crm;
create database hibernate_crm;
use hibernate_crm;

drop table if exists cst_customer;
drop table if exists cst_linkman;

CREATE TABLE `cst_customer` (
	  `cust_id` BIGINT(32) NOT NULL AUTO_INCREMENT COMMENT '客户编号(主键)',
	  `cust_name` VARCHAR(32) NOT NULL COMMENT '客户名称(公司名称)',
	  `cust_source` VARCHAR(32) DEFAULT NULL COMMENT '客户信息来源',
	  `cust_linkman` BIGINT(32) DEFAULT NULL COMMENT '联系人',
	  `cust_phone` VARCHAR(64) DEFAULT NULL COMMENT '固定电话',
	  `cust_mobile` VARCHAR(16) DEFAULT NULL COMMENT '移动电话',
	  PRIMARY KEY (`cust_id`)
	) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `cst_linkman` (
		  `lkm_id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '联系人编号(主键)',
		  `lkm_name` varchar(16) DEFAULT NULL COMMENT '联系人姓名',
		  `lkm_cust_id` bigint(32) NOT NULL COMMENT '客户id',
		  `lkm_gender` char(1) DEFAULT NULL COMMENT '联系人性别',
		  `lkm_phone` varchar(16) DEFAULT NULL COMMENT '联系人办公电话',
		  `lkm_mobile` varchar(16) DEFAULT NULL COMMENT '联系人手机',
		  `lkm_email` varchar(64) DEFAULT NULL COMMENT '联系人邮箱',
		  `lkm_qq` varchar(16) DEFAULT NULL COMMENT '联系人qq',
		  `lkm_position` varchar(16) DEFAULT NULL COMMENT '联系人职位',
		  `lkm_memo` varchar(512) DEFAULT NULL COMMENT '联系人备注',
		  PRIMARY KEY (`lkm_id`)
		) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*

alter table cst_customer add constraint customer_linkman foreign key (cust_linkman) references  cst_linkman(lkm_id) on delete restrict on update restrict;*/

