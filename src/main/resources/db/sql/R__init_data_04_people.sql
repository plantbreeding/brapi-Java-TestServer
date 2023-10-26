INSERT INTO person(auth_user_id, id, description, email_address, first_name, last_name, mailing_address, middle_name, phone_number, userid) VALUES ('anonymousUser', 'person1', 'Example Person', 'bob@bob.com', 'Bob', 'Robertson', '123 Road Street, City, State, Country, 98765', 'Danger', '+19876543210', 'bdr45');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('person_er_1', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO person_external_references(person_entity_id, external_references_id) VALUES ('person1', 'person_er_1');

INSERT INTO person(auth_user_id, id, description, email_address, first_name, last_name, mailing_address, middle_name, phone_number, userid) VALUES ('anonymousUser', 'person2', 'Example Person', 'rob@bob.com', 'Rob', 'Robertson', '123 Road Street, City, State, Country, 98765', 'Danger', '+19876543210', 'rdr45');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('person_er_2', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO person_external_references(person_entity_id, external_references_id) VALUES ('person2', 'person_er_2');