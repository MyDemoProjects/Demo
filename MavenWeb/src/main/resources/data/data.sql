CREATE TABLE `NewTable` (
`id`  int(11) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
`code`  varchar(32) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '唯一标示用户' ,
`name`  varchar(12) NOT NULL ,
`password`  varchar(32) NOT NULL ,
`age`  int(4) NULL ,
`sex`  char(1) NOT NULL ,
`remark`  text NULL ,
PRIMARY KEY (`id`)
)
;
