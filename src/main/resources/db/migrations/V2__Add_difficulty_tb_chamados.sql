-- V2  Migrationb of add colum 'difficulty' for my table of chamados

ALTER TABLE tb_chamados
ADD COLUMN difficulty VARCHAR(255); -- the 'varchar' is the equivalent of a 'string' and '255' is the number of caracters allowed

--After they are initialized they become immutable, if you want modify you have to create a new version file