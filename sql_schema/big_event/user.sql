create table user
(
    id          int unsigned auto_increment comment 'ID'
        primary key,
    username    varchar(20)  not null comment '用户名',
    password    varchar(32)  not null comment '密码',
    nickname    varchar(10)  null comment '昵称',
    email       varchar(128) null comment '邮箱',
    user_pic    varchar(128) null comment '头像',
    create_time datetime     not null comment '更新时间',
    update_time datetime     not null comment '修改时间',
    constraint user_pk
        unique (username)
)
    comment '用户表';

