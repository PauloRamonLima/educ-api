ALTER TABLE tb_class_time_table ADD class_id bigint, add constraint fkclasstime foreign key(class_id) REFERENCES tb_class(id);
COMMIT;