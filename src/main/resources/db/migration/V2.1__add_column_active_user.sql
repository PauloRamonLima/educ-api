ALTER TABLE tb_user DROP COLUMN login;
ALTER TABLE tb_user ADD active boolean;
COMMIT;