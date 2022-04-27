create table IF NOT EXISTS  table_demo
(
    id   int auto_increment comment '唯一标识'  primary key,
    name             varchar(40)     not null comment '名称',
    configuration    varchar(2000)   not null comment '配置',
    create_at    timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
    update_at    timestamp default CURRENT_TIMESTAMP not null  comment '随其他字段更新更新到当前时间'
) ;
