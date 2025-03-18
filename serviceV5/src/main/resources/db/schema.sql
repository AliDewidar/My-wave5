CREATE TABLE IF NOT EXISTS students (
    id UUID PRIMARY KEY,
    fullName VARCHAR(255) NOT NULL,
    age INT NOT NULL,
    email VARCHAR(255) NOT NULL unique ,
    gender VARCHAR(255) NOT NULL
)

DROP TABLE students;

CREATE TABLE IF NOT EXISTS address (
    id UUID PRIMARY KEY,
    continent VARCHAR(255) NOT NULL,
    country VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    street VARCHAR(255) NOT NULL,
    building_number VARCHAR(255) NOT NULL,
    floor INT NOT NULL,
    apartment_number INT NOT NULL
)

DROP TABLE address;

ALTER TABLE addresses
RENAME COLUMN buliding_number TO building_number;


ALTER TABLE students
ADD COLUMN address_id UUID,
ADD CONSTRAINT fk_students_address
FOREIGN KEY (address_id) REFERENCES address(id);
