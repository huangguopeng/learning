CREATE DATABASE learning;

CREATE TABLE `user` (
    `id` int(11) not null auto_increment,
    `name` varchar(200) not null comment '姓名',
    `age` int(3) comment '年龄',
    `birthday` date comment '出生日期',
    `sex` char(1) comment '性别',
    `create_time` timestamp comment '创建时间',
    primary key(id)

)DEFAULT CHARSET=utf8;
