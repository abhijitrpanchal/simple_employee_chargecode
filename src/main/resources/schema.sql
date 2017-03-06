DROP TABLE IF EXISTS CHARGECODE;
DROP TABLE IF EXISTS EMPLOYEE;
DROP TABLE IF EXISTS CHARGE_CODE_EMPLOYEE;

CREATE TABLE CHARGECODE(charge_code VARCHAR(10) NOT NULL,
					engagement VARCHAR(100) NOT NULL,
					company VARCHAR(100) NOT NULL,
					status VARCHAR(100) NOT NULL,
					PRIMARY KEY (charge_code));

CREATE TABLE EMPLOYEE(employee_id INTEGER NOT NULL,
					 name VARCHAR(100) NOT NULL,
					 address VARCHAR(100) NOT NULL,
					 PRIMARY KEY (employee_id));
					 
CREATE TABLE CHARGE_CODE_EMPLOYEE(charge_code VARCHAR(10) NOT NULL,
								   employee_id INTEGER NOT NULL
								  ); 
								  


								


					
