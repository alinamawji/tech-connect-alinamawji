BEGIN TRANSACTION;

CREATE TABLE pet (
    pet_id serial,
    name varchar(50) NOT NULL,
    type varchar(50) NOT NULL,
    age int NOT NULL,
    owner varchar(50) NOT NULL,
    CONSTRAINT PK_pet_id PRIMARY KEY(pet_id),
);

CREATE TABLE procedures (
    procedure_num serial,
    visit_date date NOT NULL,
    procedure varchar(50) NOT NULL,
    CONSTRAINT PK_procedure PRIMARY(procedure_num),
);

-- foreign keys
ALTER TABLE procedures ADD CONSTRAINT FK_pet_id FOREIGN KEY(pet_id) REFERENCES pet(pet_id);

COMMIT;