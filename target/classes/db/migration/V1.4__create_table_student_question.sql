create table tb_student_question (
	id bigint not null auto_increment,
	id_question bigint not null,
	id_alternative_chosen bigint not null,
	correct boolean,
	primary key(id),
	constraint fk_student_question_question foreign key (id_question) references tb_question(id),
	constraint fk_student_question_alternative foreign key (id_alternative_chosen) references tb_alternative(id)
)engine=InnoDB default charset=utf8;

commit;