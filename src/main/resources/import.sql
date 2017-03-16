insert into CHARGECODE(charge_code, engagement, company, status) values ('AAAAA', 'COE', 'Accenture','Active');
insert into CHARGECODE(charge_code, engagement, company, status) values ('A12345', 'COE', 'Accenture','Active');
insert into CHARGECODE(charge_code, engagement, company, status) values ('AB6578', 'COE', 'Accenture','Active');
insert into EMPLOYEE(employee_id, name, address) values ('1233', 'Anil', 'Bangalore');
insert into EMPLOYEE(employee_id, name, address) values ('13333', 'Sharukh', 'Bangalore');
insert into EMPLOYEE(employee_id, name, address) values ('12345', 'Aditya', 'Bangalore');
insert into CHARGE_CODE_EMPLOYEE(charge_code,employee_id) values ('AAAAA', '1233');
insert into CHARGE_CODE_EMPLOYEE(charge_code,employee_id) values ('A12345', '13333');
insert into CHARGE_CODE_EMPLOYEE(charge_code,employee_id) values ('AB6578', '12345');
commit;

