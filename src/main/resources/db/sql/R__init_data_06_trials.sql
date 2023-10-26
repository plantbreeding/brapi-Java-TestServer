
-- trial1
INSERT INTO trial (auth_user_id, id, active, documentationurl, end_date, start_date, trial_description, trial_name, trialpui, program_id, crop_id) VALUES('anonymousUser', 'trial1', true, 'https://brapi.org', '2013-07-05', '2013-01-01', 'Peru Yield Trial for Jan-Jul 2013', 'Peru Yield Trial 1', 'doi:10.15454/fake/12345', 'program1', '1');
INSERT INTO person(auth_user_id, id, description, email_address, institute_name, first_name, last_name, mailing_address, middle_name, phone_number, userid) VALUES ('anonymousUser', 'trial_contact_1', 'Breeder', 'a.breeder@brapi.org', 'Plant Science Institute', 'Alan', 'Breeder', '123 Road Street, City, State, Country, 98765', '', '+19876543210', '0000-0002-0607-8728');
INSERT INTO trial_contact (trial_db_id, person_db_id) VALUES('trial1', 'trial_contact_1');
INSERT INTO trial_dataset_authorship (id, datasetpui, license, public_release_date, submission_date, trial_id) VALUES('trial_dataset_authorship_1', 'doi:10.15454/fake/12345', 'https://creativecommons.org/licenses/by/4.0', '2014-09-01', '2014-01-01', 'trial1');
INSERT INTO trial_publication(id, publicationpui, publication_reference, trial_id) VALUES('trial_publication_1', 'doi:10.15454/fake/12345', 'https://brapi.org/publication', 'trial1');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('trial_er_1', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO trial_external_references(trial_entity_id, external_references_id) VALUES ('trial1', 'trial_er_1');

-- trial2
INSERT INTO trial (auth_user_id, id, active, documentationurl, end_date, start_date, trial_description, trial_name, trialpui, program_id, crop_id) VALUES('anonymousUser', 'trial2', true, 'https://brapi.org', '2013-07-05', '2013-02-02', 'Peru Yield Trial for Jan-Jul 2013', 'Peru Yield Trial 2', 'doi:10.25454/fake/22345', 'program2', '1');
INSERT INTO person(auth_user_id, id, description, email_address, institute_name, first_name, last_name, mailing_address, middle_name, phone_number, userid) VALUES ('anonymousUser', 'trial_contact_2', 'Breeder', 'b.breeder@brapi.org', 'Plant Science Institute', 'Bonnie', 'Breeder', '123 Road Street, City, State, Country, 98765', '', '+19876543210', '0000-0002-0607-6682');
INSERT INTO trial_contact (trial_db_id, person_db_id) VALUES('trial2', 'trial_contact_2');
INSERT INTO trial_dataset_authorship (id, datasetpui, license, public_release_date, submission_date, trial_id) VALUES('trial_dataset_authorship_2', 'doi:10.25454/fake/22345', 'https://creativecommons.org/licenses/by/4.0', '2014-09-02', '2014-02-02', 'trial2');
INSERT INTO trial_publication(id, publicationpui, publication_reference, trial_id) VALUES('trial_publication_2', 'doi:10.25454/fake/22345', 'https://brapi.org/publication', 'trial2');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('trial_er_2', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO trial_external_references(trial_entity_id, external_references_id) VALUES ('trial2', 'trial_er_2');

-- trial3
INSERT INTO trial (auth_user_id, id, active, documentationurl, end_date, start_date, trial_description, trial_name, trialpui, program_id, crop_id) VALUES('anonymousUser', 'trial3', true, 'https://brapi.org', '2013-07-05', '2013-03-03', 'Peru Yield Trial for Jan-Jul 2013', 'Peru Yield Trial 3', 'doi:10.35454/fake/32345', 'program3', '1');
INSERT INTO person(auth_user_id, id, description, email_address, institute_name, first_name, last_name, mailing_address, middle_name, phone_number, userid) VALUES ('anonymousUser', 'trial_contact_3', 'Breeder', 'c.breeder@brapi.org', 'Plant Science Institute', 'Chris', 'Breeder', '123 Road Street, City, State, Country, 98765', '', '+19876543210', '0000-0002-0617-1114');
INSERT INTO trial_contact (trial_db_id, person_db_id) VALUES('trial3', 'trial_contact_3');
INSERT INTO trial_dataset_authorship (id, datasetpui, license, public_release_date, submission_date, trial_id) VALUES('trial_dataset_authorship_3', 'doi:10.35454/fake/32345', 'https://creativecommons.org/licenses/by/4.0', '2014-09-03', '2014-03-03', 'trial3');
INSERT INTO trial_publication(id, publicationpui, publication_reference, trial_id) VALUES('trial_publication_3', 'doi:10.35454/fake/32345', 'https://brapi.org/publication', 'trial3');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('trial_er_3', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO trial_external_references(trial_entity_id, external_references_id) VALUES ('trial3', 'trial_er_3');

