
INSERT INTO trial (id, active, documentationurl, end_date, start_date, trial_description, trial_name, trialpui, program_id) VALUES('trial1', true, 'https://brapi.org', '2013-07-05', '2013-01-01', 'Peru Yield Trial for Jan-Jul 2013', 'Peru Yield Trial 1', 'doi:10.15454/fake/12345', 'program1');

INSERT INTO contact(id, email, institute_name, "name", orcid, study_db_id, trial_db_id, "type") VALUES('trial_contact_1', 'a.breeder@brapi.org', 'Plant Science Institute', 'A. Breeder', '0000-0002-0607-8728', null, 'trial1', 'Breeder');
INSERT INTO trial_contact (trial_db_id, contact_db_id) VALUES('trial1', 'trial_contact_1');
INSERT INTO trial_dataset_authorship (id, datasetpui, license, public_release_date, submission_date, trial_id) VALUES('trial_dataset_authorship_1', 'doi:10.15454/fake/12345', 'https://creativecommons.org/licenses/by/4.0', '2014-09-01', '2014-01-01', 'trial1');
INSERT INTO trial_publication(id, publicationpui, publication_reference, trial_id) VALUES('trial_publication_1', 'doi:10.15454/fake/12345', 'https://brapi.org/publication', 'trial1');

INSERT INTO additional_info(id, key, value) VALUES ('trial_ai_1', 'dummyData', 'True');
INSERT INTO trial_additional_info(trial_entity_id, additional_info_id) VALUES ('trial1', 'trial_ai_1');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('trial_er_1', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO trial_external_references(trial_entity_id, external_references_id) VALUES ('trial1', 'trial_er_1');
