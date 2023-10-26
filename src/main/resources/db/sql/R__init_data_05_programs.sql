INSERT INTO person(auth_user_id, id, description, email_address, first_name, last_name, mailing_address, middle_name, phone_number, userid) VALUES ('anonymousUser', 'program_person_1', 'Program Director', 'bob@bob.com', 'Bob', 'Robertson', '123 Road Street, City, State, Country, 98765', 'Danger', '+19876543210', 'bdr45');
INSERT INTO program (auth_user_id, crop_id, id, abbreviation, lead_person_id, documentationurl, objective, name, program_type, funding_information) VALUES ('anonymousUser', '1', 'program1', 'P1', 'program_person_1', 'https://brapi.org', 'Global Population Improvement', 'The BrAPI Breeding Program', 0, 'Generic funding information');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('program_er_1', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO program_external_references(program_entity_id, external_references_id) VALUES ('program1', 'program_er_1');

UPDATE location SET program_id = 'program1', crop_id = '1'  WHERE id = 'location_01';

INSERT INTO person(auth_user_id, id, description, email_address, first_name, last_name, mailing_address, middle_name, phone_number, userid) VALUES ('anonymousUser', 'program_person_2', 'Program Director', 'bob@bob.com', 'Bob', 'Robertson', '123 Road Street, City, State, Country, 98765', 'Danger', '+19876543210', 'bdr45');
INSERT INTO program (auth_user_id, crop_id, id, abbreviation, lead_person_id, documentationurl, objective, name, program_type, funding_information) VALUES ('anonymousUser', '1', 'program2', 'P2', 'program_person_2', 'https://brapi.org', 'XYZ', 'The Fake Tomatillo Breeding Program', 0, 'USDA Grant 0123456789');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('program_er_2', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO program_external_references(program_entity_id, external_references_id) VALUES ('program2', 'program_er_2');

UPDATE location SET program_id = 'program2', crop_id = '1'  WHERE id = 'location_02';

INSERT INTO person(auth_user_id, id, description, email_address, first_name, last_name, mailing_address, middle_name, phone_number, userid) VALUES ('anonymousUser', 'program_person_3', 'Program Director', 'bob@bob.com', 'Bob', 'Robertson', '123 Road Street, City, State, Country, 98765', 'Danger', '+19876543210', 'bdr45');
INSERT INTO program (auth_user_id, crop_id, id, abbreviation, lead_person_id, documentationurl, objective, name, program_type, funding_information) VALUES ('anonymousUser', '2', 'program3', 'P3', 'program_person_3', 'https://brapi.org', 'XYZ', 'The Fake Pawpaw Breeding Program', 1, 'Elixir Project 0123456789');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('program_er_3', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO program_external_references(program_entity_id, external_references_id) VALUES ('program3', 'program_er_3');

UPDATE location SET program_id = 'program3', crop_id = '2'  WHERE id = 'location_03';

