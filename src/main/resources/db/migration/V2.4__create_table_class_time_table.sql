create table tb_class_time_table (
	id bigint not null auto_increment,
	time varchar(200) not null,
	id_subject bigint not null,
	id_teacher bigint not null,
	primary key(id),
    constraint fksubjectclasstimetable foreign key (id_subject) references tb_subject(id),
    constraint fkteacherclasstimetable foreign key (id_teacher) references tb_teacher(id)
)engine=InnoDB default charset=utf8;