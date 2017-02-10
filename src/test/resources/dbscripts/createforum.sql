/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/2/10 14:26:05                           */
/*==============================================================*/


drop table if exists t_board;

drop table if exists t_board_manager;

drop table if exists t_login_log;

drop index user_id_index on t_post;

drop index topic_title_index on t_post;

drop table if exists t_post;

drop table if exists t_topic;

drop table if exists t_user;

drop table if exists t_user_password;

/*==============================================================*/
/* Table: t_board                                               */
/*==============================================================*/
create table t_board
(
   board_id             varchar(32) not null,
   board_name           varchar(150),
   board_desc           varchar(255),
   topic_num            int(11),
   primary key (board_id)
);

alter table t_board comment '论坛版块';

/*==============================================================*/
/* Table: t_board_manager                                       */
/*==============================================================*/
create table t_board_manager
(
   board_id             varchar(32) not null,
   user_id              varchar(32) not null,
   primary key (board_id, user_id)
);

alter table t_board_manager comment '用于维护t_board与t_user之间的关系';

/*==============================================================*/
/* Table: t_login_log                                           */
/*==============================================================*/
create table t_login_log
(
   login_log_id         varchar(32) not null,
   user_id              varchar(32) not null,
   ip                   varchar(20) not null,
   login_datetime       datetime not null,
   primary key (login_log_id)
);

alter table t_login_log comment '登录日志表';

/*==============================================================*/
/* Table: t_post                                                */
/*==============================================================*/
create table t_post
(
   post_id              varchar(32) not null,
   board_id             varchar(32) not null,
   topic_id             varchar(32) not null,
   user_id              varchar(32) not null,
   post_type            tinyint(4) not null,
   post_title           varchar(50) not null,
   post_text            text not null,
   create_time          datetime not null,
   primary key (post_id)
);

alter table t_post comment '论坛帖子表';

/*==============================================================*/
/* Index: topic_title_index                                     */
/*==============================================================*/
create unique index topic_title_index on t_post
(
   post_title
);

/*==============================================================*/
/* Index: user_id_index                                         */
/*==============================================================*/
create unique index user_id_index on t_post
(
   user_id
);

/*==============================================================*/
/* Table: t_topic                                               */
/*==============================================================*/
create table t_topic
(
   topic_id             varchar(32) not null,
   board_id             varchar(32) not null,
   topic_title          varchar(100) not null,
   user_id              varchar(32) not null,
   create_time          datetime not null,
   last_post            datetime not null,
   topic_views          int(11) not null,
   topic_replies        int(11) not null,
   digest               int(11) not null,
   primary key (topic_id)
);

alter table t_topic comment '论坛主题';

/*==============================================================*/
/* Table: t_user                                                */
/*==============================================================*/
create table t_user
(
   user_id              varchar(32) not null,
   user_name            varchar(30) not null,
   user_no              varchar(32) not null,
   user_type            tinyint(4) not null,
   locked               tinyint(4) not null,
   credit               int(11),
   last_visit           datetime not null,
   last_ip              varchar(20) not null,
   primary key (user_id)
);

/*==============================================================*/
/* Table: t_user_password                                       */
/*==============================================================*/
create table t_user_password
(
   user_no_id           varchar(32) not null,
   user_no              varchar(36) not null,
   password             varchar(30) not null,
   mobile               varchar(11),
   primary key (user_no_id)
);

alter table t_user_password comment '用户密码';

