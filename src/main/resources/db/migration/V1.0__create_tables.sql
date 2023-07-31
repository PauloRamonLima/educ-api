create table tb_subject (
	id bigint not null auto_increment,
	name varchar(200) not null,
	primary key(id)
) engine=InnoDB default charset=utf8;

create table tb_class (
	id bigint not null auto_increment,
	name varchar(200) not null,
	primary key(id)
)engine=InnoDB default charset=utf8;

create table tb_class_subject (
	id_class bigint not null,
	id_subject not null,
	constraint fk_class foreign key (id_class) references tb_class(id),
    constraint fk_subject foreign key (id_subject) references tb_subject(id)
)engine=InnoDB default charset=utf8;

create table tb_contact (
	id bigint not null auto_increment,
	name varchar(200) not null,
	phone varchar(20),
	email varchar(200),
	primary key(id)
)engine=InnoDB default charset=utf8;