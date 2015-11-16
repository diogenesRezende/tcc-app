INSERT INTO periods("number", year)
    VALUES ( 1, now());
INSERT INTO periods("number", year)
    VALUES ( 2, now());
INSERT INTO periods("number", year)
    VALUES ( 3, now());
INSERT INTO periods("number", year)
    VALUES ( 4, now());
INSERT INTO periods("number", year)
    VALUES ( 5, now());
INSERT INTO periods("number", year)
    VALUES ( 6, now());
INSERT INTO periods("number", year)
    VALUES ( 7, now());
INSERT INTO periods("number", year)
    VALUES ( 8, now());
INSERT INTO periods("number", year)
    VALUES ( 9, now());
INSERT INTO periods("number", year)
    VALUES ( 10, now());
--
--
--
-----------------------------------------------
INSERT INTO users( password,username)
    VALUES ('Abc123','98004095');
INSERT INTO users( password,username)
    VALUES ('Abc123','98004096');
INSERT INTO users( password,username)
    VALUES ('Abc123','98004097');
INSERT INTO users( password,username)
    VALUES ('Abc123','98004098');
--
--
--
-----------------------------------------------
INSERT INTO students(email, name, id_external, id_user, id_period)
    VALUES ('diogenes@gmail.com', 'Diogenes',98004095, 1, 8);
INSERT INTO students(email, name, id_external, id_user, id_period)
    VALUES ('nilo@gmail.com', 'Nilo',98004096, 2, 8);
INSERT INTO students(email, name, id_external, id_user, id_period)
    VALUES ('otavio@gmail.com', 'Otavio',98004097, 3, 8);
INSERT INTO students(email, name, id_external, id_user, id_period)
    VALUES ('diego@gmail.com', 'Diego',98004098, 4, 8);
--
--
--
-----------------------------------------------
INSERT INTO disciplines(description, id_external, name, id_period)
    VALUES ('Qualidade de Software', 1032, 'Qualidade de Software', 8);
INSERT INTO disciplines(description, id_external, name, id_period)
    VALUES ('Engenharia de Software', 1033, 'Engenahria de Software', 8);
INSERT INTO disciplines(description, id_external, name, id_period)
    VALUES ('Tópicos Avançados', 1034, 'Tópicos Avançados', 8);
INSERT INTO disciplines(description, id_external, name, id_period)
    VALUES ('TCC', 1035, 'TCC', 8);
--
--
--
-----------------------------------------------
INSERT INTO events(description, effective_date, event_type, note, release_date, value, id_student, id_discpline)
    VALUES ('Prova', now(), 'PROVA_AGENDADA',30, now(),35,1,1);
INSERT INTO events(description, effective_date, event_type, note, release_date, value, id_student, id_discpline)
    VALUES ('Prova', now(), 'PROVA_AGENDADA',30, now(),35,2,2);
INSERT INTO events(description, effective_date, event_type, note, release_date, value, id_student, id_discpline)
    VALUES ('Prova', now(), 'PROVA_AGENDADA',30, now(),35,3,3);
INSERT INTO events(description, effective_date, event_type, note, release_date, value, id_student, id_discpline)
    VALUES ('Prova', now(), 'PROVA_AGENDADA',30, now(),35,4,4);
INSERT INTO events(description, effective_date, event_type, note, release_date, value, id_student, id_discpline)
    VALUES ('Prova', now(), 'PROVA_APLICADA',30, now(),35,1,1);
INSERT INTO events(description, effective_date, event_type, note, release_date, value, id_student, id_discpline)
    VALUES ('Prova', now(), 'PROVA_APLICADA',30, now(),35,2,2);
INSERT INTO events(description, effective_date, event_type, note, release_date, value, id_student, id_discpline)
    VALUES ('Prova', now(), 'PROVA_APLICADA',30, now(),35,3,3);
INSERT INTO events(description, effective_date, event_type, note, release_date, value, id_student, id_discpline)
    VALUES ('Prova', now(), 'PROVA_APLICADA',30, now(),35,3,3);
INSERT INTO events(description, effective_date, event_type, note, release_date, value, id_student, id_discpline)
    VALUES ('Falta', now(), 'FALTAS',0, now(),4,1,1);
INSERT INTO events(description, effective_date, event_type, note, release_date, value, id_student, id_discpline)
    VALUES ('Falta', now(), 'FALTAS',0, now(),3,2,2);
INSERT INTO events(description, effective_date, event_type, note, release_date, value, id_student, id_discpline)
    VALUES ('Falta', now(), 'FALTAS',0, now(),2,3,3);
INSERT INTO events(description, effective_date, event_type, note, release_date, value, id_student, id_discpline)
    VALUES ('Falta', now(), 'FALTAS',0, now(),1,4,4);
--
--
--
-----------------------------------------------
commit;