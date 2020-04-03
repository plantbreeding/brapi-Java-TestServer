INSERT INTO person(id, description, email_address, first_name, last_name, mailing_address, middle_name, phone_number, userid) VALUES ('program_person_1', 'Program Director', 'bob@bob.com', 'Bob', 'Robertson', '123 Road Street, City, State, Country, 98765', 'Danger', '+19876543210', 'bdr45');
INSERT INTO program (crop_id, id, abbreviation, lead_person_id, documentationurl, objective, name) VALUES ('1', 'program1', 'P1', 'program_person_1', 'https://brapi.org', 'Global Population Improvement', 'The BrAPI Breeding Program');
INSERT INTO additional_info(id, key, value) VALUES ('program_ai_1', 'dummyData', 'True');
INSERT INTO program_additional_info(program_entity_id, additional_info_id) VALUES ('program1', 'program_ai_1');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('program_er_1', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO program_external_references(program_entity_id, external_references_id) VALUES ('program1', 'program_er_1');

INSERT INTO person(id, description, email_address, first_name, last_name, mailing_address, middle_name, phone_number, userid) VALUES ('program_person_2', 'Program Director', 'bob@bob.com', 'Bob', 'Robertson', '123 Road Street, City, State, Country, 98765', 'Danger', '+19876543210', 'bdr45');
INSERT INTO program (crop_id, id, abbreviation, lead_person_id, documentationurl, objective, name) VALUES ('1', 'program2', 'P2', 'program_person_2', 'https://brapi.org', 'XYZ', 'The Fake Tomatillo Breeding Program');
INSERT INTO additional_info(id, key, value) VALUES ('program_ai_2', 'dummyData', 'True');
INSERT INTO program_additional_info(program_entity_id, additional_info_id) VALUES ('program2', 'program_ai_2');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('program_er_2', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO program_external_references(program_entity_id, external_references_id) VALUES ('program2', 'program_er_2');

INSERT INTO person(id, description, email_address, first_name, last_name, mailing_address, middle_name, phone_number, userid) VALUES ('program_person_3', 'Program Director', 'bob@bob.com', 'Bob', 'Robertson', '123 Road Street, City, State, Country, 98765', 'Danger', '+19876543210', 'bdr45');
INSERT INTO program (crop_id, id, abbreviation, lead_person_id, documentationurl, objective, name) VALUES ('2', 'program3', 'P3', 'program_person_3', 'https://brapi.org', 'XYZ', 'The Fake Pawpaw Breeding Program');
INSERT INTO additional_info(id, key, value) VALUES ('program_ai_3', 'dummyData', 'True');
INSERT INTO program_additional_info(program_entity_id, additional_info_id) VALUES ('program3', 'program_ai_3');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('program_er_3', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO program_external_references(program_entity_id, external_references_id) VALUES ('program3', 'program_er_3');

