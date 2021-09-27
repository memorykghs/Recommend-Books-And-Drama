drop table if exists Ashley.all_sequences;
create table Ashley.all_sequences (
	sequence_name varchar(20) not null,
    min_value int not null default 0,
    max_value int not null default 999,
    increment_by int not null default 1,
    primary key (sequence_name)
);

insert into all_sequences values ('ITEM_SEQ', 0, 999, 1);
insert into all_sequences values ('DEFUALT_SEQ', 0, 999, 1);
insert into all_sequences values ('CAT_SEQ', 0, 999, 1);
insert into all_sequences values ('AUTH_SEQ',0 , 999, 1);
insert into all_sequences values ('TAG_SEQ', 0, 999, 1);
insert into all_sequences values ('TYPE_SEQ', 0, 999, 1);