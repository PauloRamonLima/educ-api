create table tb_user (
	id bigint not null auto_increment,
	login varchar(255) not null,
	password varchar(255),
	user_type varchar(50),
	primary key(id)
)engine=InnoDB default charset=utf8;

commit;