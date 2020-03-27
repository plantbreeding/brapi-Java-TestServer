INSERT INTO person(id, description, email_address, first_name, last_name, mailing_address, middle_name, phone_number, userid) VALUES ('person1', 'Example Person', 'bob@bob.com', 'Bob', 'Robertson', '123 Road Street, City, State, Country, 98765', 'Danger', '+19876543210', 'bdr45');
INSERT INTO additional_info(id, key, value) VALUES ('person_ai_1', 'dummyData', 'True');
INSERT INTO person_additional_info(person_entity_id, additional_info_id) VALUES ('person1', 'person_ai_1');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('person_er_1', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO person_external_references(person_entity_id, external_references_id) VALUES ('person1', 'person_er_1');

INSERT INTO person(id, description, email_address, first_name, last_name, mailing_address, middle_name, phone_number, userid) VALUES ('person2', 'Example Person', 'rob@bob.com', 'Rob', 'Robertson', '123 Road Street, City, State, Country, 98765', 'Danger', '+19876543210', 'rdr45');
INSERT INTO additional_info(id, key, value) VALUES ('person_ai_2', 'dummyData', 'True');
INSERT INTO person_additional_info(person_entity_id, additional_info_id) VALUES ('person2', 'person_ai_2');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('person_er_2', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO person_external_references(person_entity_id, external_references_id) VALUES ('person2', 'person_er_2');