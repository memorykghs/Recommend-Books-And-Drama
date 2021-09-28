create table Ashley.AUTHOR_INFO (
	AUTHOR_ID varchar(6) not null comment '作者ID',
    AUTHOR_NAME nvarchar(30) not null comment '作者名稱',
    DESCRIPTION nvarchar(500) comment '作者介紹',
    UPD_ID varchar(20) comment '更新人員',
    UPD_TIME timestamp comment '更新時間',
    primary key (AUTHOR_ID)
) engine=InnoDB default charset=utf8;

create table Ashley.TAG_INFO (
	TAG_ID varchar(6) not null comment '標籤ID',
    NAME nvarchar(50) comment '標籤名稱',
    primary key (TAG_ID)
) engine=InnoDB default charset=utf8;

create table Ashley.CATEGORY_INFO (
	CATEGORY_ID varchar(6) not null comment '分類ID',
    NAME nvarchar(20) not null comment '分類名稱',
    primary key (CATEGORY_ID)
) engine=InnoDB default charset=utf8;

create table Ashley.TYPE_INFO (
	TYPE_ID varchar(6) not null comment '類別ID',
    NAME varchar(10) not null comment '類別名稱',
    primary key (TYPE_ID)
) engine=InnoDB default charset=utf8;

create table Ashley.USER_INFO (
	USER_ID nvarchar(50) not null comment '使用者ID',
    USER_NAME nvarchar(50) not null comment '使用者姓名',
    PASSWORD nvarchar(50) not null comment '密碼',
    EMAIL nvarchar(50) comment '信箱',
    primary key (USER_ID)
) engine=InnoDB default charset=utf8;

create table Ashley.ITEM_INFO (
	ITEM_ID varchar(12) not null comment '物件ID',
    TAG varchar(6) comment '標籤',
    AUTHOR_ID varchar(8) not null comment '作者',
    ITEM_NAME nvarchar(100) not null comment '書名',
    TYPE varchar(7) not null comment '類型',
    CATEGORY varchar(7) not null comment '分類',
    DESCRIPTION nvarchar(1000) comment '說明',
    RECOMMEND float(2,1) comment '推薦度',
    UPD_ID varchar(20) comment '更新人員',
    UPD_TIME timestamp comment '更新時間', 
    primary key (ITEM_ID, TAG)
) engine=InnoDB default charset=utf8;

create table Ashley.ITEM_COMMENT (
	UPD_TIME timestamp not null comment '更新時間',
    UPD_ID  nvarchar(50) not null comment '更新者ID',
    ITEM_ID varchar(12) not null comment '書籍ID',
    COMMENTS nvarchar(1000) not null comment '留言',
    primary key (UPD_TIME, USER_ID)
) engine=InnoDB default charset=utf8;

create table Ashley.ITEM_TAG (
	ITEM_ID varchar(12) not null comment '物件ID',
    TAG_ID varchar(6) not null comment '標籤ID',
    primary key (ITEM_ID, TAG_ID)
) engine=InnoDB default charset=utf8;

create table Ashley.RECOMMEND (
	ITEM_ID varchar(12) not null comment '物件ID',
    USER_ID nvarchar(50) not null comment '使用者ID',
    RECOMMEND float(2,1) comment '推薦度',
    primary key (ITEM_ID, USER_ID)
) engine=InnoDB default charset=utf8;

insert into USER_INFO values ('BigAppentice', '大師兄', 'BigAppentice', '');
insert into USER_INFO values ('Master', '師傅', 'Master', '');