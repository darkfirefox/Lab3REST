CREATE TABLE Doctor (
                id SERIAL PRIMARY KEY,
                firstName VARCHAR NOT NULL,
                fatherName VARCHAR NOT NULL,
                lastName VARCHAR NOT NULL,
                specification VARCHAR NOT NULL)

CREATE TABLE Patient (
                id SERIAL PRIMARY KEY,
                firstName VARCHAR NOT NULL,
                fatherName VARCHAR NOT NULL,
                lastName VARCHAR NOT NULL,
                phone VARCHAR NOT NULL)

CREATE TABLE Prescription (
                id SERIAL PRIMARY KEY,
                dateTime timestamp NOT NULL,
                description VARCHAR NOT NULL,
                priority VARCHAR NOT NULL,
                idDoctor INTEGER REFERENCES Doctor(id) ON DELETE CASCADE,
		            idPatient INTEGER REFERENCES Patient(id) ON DELETE CASCADE)