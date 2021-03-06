CREATE DATABASE MyBelfast;

USE MyBelfast;

create table CREW
(
    id int auto_increment comment '船员id',
    crewName varchar(10) not null comment '船员姓名',
    phoneNum VARCHAR(20) not null comment '电话号码',
    mail VARCHAR(30) not null comment '电子邮件',
    crewMessage TEXT null comment '船员个人简介',
    avatarUrl varchar(100) not null comment '头像地址',
    passwordMd5 VARCHAR(32) not null comment '密码的md5值',
    lastOfflineTime VARCHAR(16) null comment '最后下线时间',
    createTime VARCHAR(16) not null comment '注册时间',
    filed1 VARCHAR(10) null comment '空余字段1',
    constraint CREW_pk
        primary key (id)
)
    comment '船员表';

create unique index CREW_crewName_uindex
    on CREW (crewName);

create unique index CREW_phoneNum_uindex
    on CREW (phoneNum);


--

create table NEWS
(
	id int auto_increment comment '新闻表id
',
	title VARCHAR(40) default '无标题' not null comment '新闻标题',
	hits int default 0 not null comment '点击数
',
	outTime VARCHAR(8) not null comment '发布时间',
	tag VARCHAR(10) not null comment '分类标签',
	url VARCHAR(100) not null comment '新闻链接
',
	constraint NEWS_pk
		primary key (id)
)
comment '新闻表';

alter table NEWS modify title VARCHAR(50) default '无标题' not null comment '新闻标题';

alter table NEWS modify title VARCHAR(100) default '无标题' not null comment '新闻标题';

