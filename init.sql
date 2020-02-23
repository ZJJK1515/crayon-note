-- auto-generated definition
create table sys_menu
(
    menu_id     int(20) auto_increment comment '菜单 ID'
        primary key,
    menu_name   varchar(20)                         not null,
    uri         varchar(100)                        not null comment '菜单路径',
    icon        varchar(20)                         null comment '菜单图标',
    parent_id   int(20)                             not null comment '父菜单 ID',
    create_time timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间'
);

INSERT INTO crayonnote.sys_menu (menu_id, menu_name, uri, icon, parent_id, create_time, update_time) VALUES ('1231146873176068321', '首页', 'dashboard', 'dashboard', '0', '2020-02-22 19:19:17', '2020-02-22 19:19:36');
INSERT INTO crayonnote.sys_menu (menu_id, menu_name, uri, icon, parent_id, create_time, update_time) VALUES ('1231146873177067522', '系统管理', '#', 'settings', '0', '2020-02-22 15:17:39', '2020-02-22 17:21:13');
INSERT INTO crayonnote.sys_menu (menu_id, menu_name, uri, icon, parent_id, create_time, update_time) VALUES ('1231146877325234177', '用户管理', 'system/usermanage', 'person', '1231146873177067522', '2020-02-22 15:17:39', '2020-02-23 17:30:40');
INSERT INTO crayonnote.sys_menu (menu_id, menu_name, uri, icon, parent_id, create_time, update_time) VALUES ('1231146879493689345', '博客管理', '#', 'settings', '0', '2020-02-22 15:42:52', '2020-02-22 17:21:13');
