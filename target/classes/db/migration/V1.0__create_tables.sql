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
	id_subject bigint not null,
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

create table tb_student (
	id bigint not null auto_increment,
	registration varchar(100) not null,
	name varchar(200) not null,
	bornDate date,
	phoneNumber varchar(30),
	id_contact bigint,
	id_class bigint,
	primary key(id),
	constraint fk_class_student foreign key (id_class) references tb_class(id),
    constraint fk_contact_student foreign key (id_contact) references tb_contact(id)
)engine=InnoDB default charset=utf8;

create table tb_teacher (
	id bigint not null auto_increment,
	name varchar(200) not null,
	cpf varchar(15) not null,
	phoneNumber varchar(30),
	bornDate date,
	primary key(id)
)engine=InnoDB default charset=utf8;

create table tb_teacher_class (
	id_teacher bigint not null,
	id_class bigint not null,
	constraint fk_class_teacher foreign key (id_class) references tb_class(id),
    constraint fk_teacher_class foreign key (id_teacher) references tb_teacher(id)
)engine=InnoDB default charset=utf8;

create table tb_test (
	id bigint not null auto_increment,
	id_class bigint not null,
	id_subject bigint not null,
	id_teacher bigint not null,
	primary key(id),
	constraint fk_class_test foreign key (id_class) references tb_class(id),
    constraint fk_teacher_test foreign key (id_teacher) references tb_teacher(id),
    constraint fk_subject_test foreign key (id_subject) references tb_subject(id) 
)engine=InnoDB default charset=utf8;

create table tb_question (
	id bigint not null auto_increment,
	description MEDIUMTEXT not null,
	id_test bigint not null,
	primary key(id),
	constraint fk_test_question foreign key (id_test) references tb_test(id)
)engine=InnoDB default charset=utf8;

create table tb_alternative (
	id bigint not null auto_increment,
	description TEXT not null,
	correct BOOLEAN not null,
	id_question bigint not null,
	primary key(id),
	constraint fk_question_alternative foreign key (id_question) references tb_question(id)
)engine=InnoDB default charset=utf8;

ALTER TABLE tb_question
ADD COLUMN alternative_chosen BIGINT,
ADD CONSTRAINT FK_alternative_chosen
  FOREIGN KEY (alternative_chosen) REFERENCES tb_alternative (id);

create table tb_student_test(
	id bigint not null auto_increment,
	id_student bigint not null,
	id_test bigint not null,
	grade int not null,
	approved BOOLEAN not null,
	primary key(id),
	constraint fk_student_test foreign key (id_student) references tb_student(id),
	constraint fk_test_student foreign key (id_test) references tb_test(id)
)engine=InnoDB default charset=utf8;