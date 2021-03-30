CREATE DATABASE `bases`;
USE `bases`;
CREATE TABLE `user` (
                        `id` INT ( 20 ) NOT NULL PRIMARY KEY,
                        `name` VARCHAR ( 30 ) DEFAULT NULL,
                        `pwd` VARCHAR ( 30 ) DEFAULT NULL
)ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO `bases`.`user` (`id`, `name`, `pwd`) VALUES (1, '狂神', '123456');
INSERT INTO `bases`.`user` (`id`, `name`, `pwd`) VALUES (2, '张三', '123456');
INSERT INTO `bases`.`user` (`id`, `name`, `pwd`) VALUES (3, '李四', '123890');

