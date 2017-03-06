insert into CHARGE_CODE(charge_code, engagement, company, status) values ('AAAAA', 'COE', 'Accenture','Active');
insert into CHARGE_CODE(charge_code, engagement, company, status) values ('A12345', 'COE', 'Accenture','Active');
insert into CHARGE_CODE(charge_code, engagement, company, status) values ('AB6578', 'COE', 'Accenture','Active');
insert into EMPLOYEE(employee_id, name, address) values ('10000', 'Anil', 'Bangalore');
insert into EMPLOYEE(employee_id, name, address) values ('10001', 'Sharukh', 'Bangalore');
insert into EMPLOYEE(employee_id, name, address) values ('10002', 'Aditya', 'Bangalore');
insert into CHARGE_CODE_EMPLOYEE(charge_code,employee_id) values ('AAAAA', '10000');
insert into CHARGE_CODE_EMPLOYEE(charge_code,employee_id) values ('A12345', '10000');
insert into CHARGE_CODE_EMPLOYEE(charge_code,employee_id) values ('A12345', '10001');
insert into CHARGE_CODE_EMPLOYEE(charge_code,employee_id) values ('AB6578', '10002');
insert into CHARGE_CODE_EMPLOYEE(charge_code,employee_id) values ('A12345', '10002');