--study 1
INSERT INTO study(auth_user_id, id, active, cultural_practices, documentationurl, end_date, license, observation_units_description, start_date, study_code, study_description, study_name, studypui, study_type, location_id, trial_id, program_id, crop_id) VALUES ('anonymousUser', 'study1', true, 'Irrigation was applied according needs during summer to prevent water stress', 'https://brapi.org', '2014-01-01', 'https://creativecommons.org/licenses/by/4.0', 'Observation units consisted in individual plots themselves consisting of a row of 15 plants at a density of approximately six plants per square meter.', '2013-01-01', 'Yield_2013', 'This is a yield trial for 2013', 'Paw paw 2013 yield trial', 'doi:10.155454/fake/12345', 'Phenotyping','location_01', 'trial1', 'program1', '1');

INSERT INTO person(auth_user_id, id, description, email_address, institute_name, first_name, last_name, mailing_address, middle_name, phone_number, userid) VALUES ('anonymousUser', 'study_contact_1', 'Breeder', 'd.breeder@brapi.org', 'Plant Science Institute', 'Dave', 'Breeder', '123 Road Street, City, State, Country, 98765', '', '+19876543210', '0000-0002-0617-9556');
INSERT INTO study_contact (study_db_id, person_db_id) VALUES('study1', 'study_contact_1');
INSERT INTO study_data_link (id, data_format, description, file_format, "name", provenance, scientific_type, url, "version", study_id) VALUES('datalink_1', 'Image Archive', 'Raw drone images collected for this study', 'application/zip', 'image-archive.zip', 'Image Processing Pipeline, built at the University of Antarctica: https://github.com/antarctica/pipeline', 'Environmental', 'https://brapi.org/image-archive.zip', '1.0.3', 'study1');
INSERT INTO study_environment_parameter (id, description, parameter_name, parameterpui, unit, unitpui, value, valuepui, study_id) VALUES('study_environment_parameter_1', 'the soil type was clay', 'soil type', 'PECO:0007155', 'pH', 'PECO:0007059', 'clay soil', 'ENVO:00002262', 'study1');
INSERT INTO study_experimental_design (id, pui, description, study_id) VALUES('study_experimental_design_1', 'CO_715:0000145', 'Lines were repeated twice at each location using a complete block design. In order to limit competition effects, each block was organized into four sub-blocks corresponding to earliest groups based on a prior information.', 'study1');
INSERT INTO study_growth_facility (id, pui, description, study_id) VALUES('study_growth_facility_1', 'CO_715:0000162', 'field environment condition, greenhouse', 'study1');
INSERT INTO study_last_update (id, "timestamp", "version", study_id) VALUES('study_last_update_1', '2020-04-02T20:55:19.177Z', '1.2.3', 'study1');
INSERT INTO study_observation_level (id, level_name, level_order, study_id) VALUES('study_observation_level_1', 'field', 0, 'study1');
INSERT INTO study_observation_level (id, level_name, level_order, study_id) VALUES('study_observation_level_2', 'block', 1, 'study1');
INSERT INTO study_observation_level (id, level_name, level_order, study_id) VALUES('study_observation_level_3', 'plot', 2, 'study1');
INSERT INTO study_observation_level (id, level_name, level_order, study_id) VALUES('study_observation_level_4', 'plant', 3, 'study1');
INSERT INTO study_season (study_db_id, season_db_id) VALUES('study1', 'spring_2013');
INSERT INTO study_season (study_db_id, season_db_id) VALUES('study1', 'summer_2013');
INSERT INTO study_season (study_db_id, season_db_id) VALUES('study1', 'fall_2013');
INSERT INTO study_season (study_db_id, season_db_id) VALUES('study1', 'winter_2013');

INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('study_er_1', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO study_external_references(study_entity_id, external_references_id) VALUES ('study1', 'study_er_1');


--study 2
INSERT INTO study(auth_user_id, id, active, cultural_practices, documentationurl, end_date, license, observation_units_description, start_date, study_code, study_description, study_name, studypui, study_type, location_id, trial_id, program_id, crop_id) VALUES ('anonymousUser', 'study2', true, 'Irrigation was applied according needs during summer to prevent water stress', 'https://brapi.org', '2014-02-02', 'https://creativecommons.org/licenses/by/4.0', 'Observation units consisted in individual plots themselves consisting of a row of 15 plants at a density of approximately six plants per square meter.', '2013-02-02', 'Yield_2013', 'This is a yield trial for 2013', 'Paw paw 2013 yield trial', 'doi:10.255454/fake/22345', 'Phenotyping','location_02', 'trial2', 'program2', '1');

INSERT INTO person(auth_user_id, id, description, email_address, institute_name, first_name, last_name, mailing_address, middle_name, phone_number, userid) VALUES ('anonymousUser', 'study_contact_2', 'Breeder', 'e.breeder@brapi.org', 'Plant Science Institute', 'Eve', 'Breeder', '123 Road Street, City, State, Country, 98765', '', '+19876543210', '0000-0002-0632-8751');
INSERT INTO study_contact (study_db_id, person_db_id) VALUES('study2', 'study_contact_2');
INSERT INTO study_data_link (id, data_format, description, file_format, "name", provenance, scientific_type, url, "version", study_id) VALUES('datalink_2', 'Image Archive', 'Raw drone images collected for this study', 'application/zip', 'image-archive.zip', 'Image Processing Pipeline, built at the University of Antarctica: https://github.com/antarctica/pipeline', 'Environmental', 'https://brapi.org/image-archive.zip', '2.0.3', 'study2');
INSERT INTO study_environment_parameter (id, description, parameter_name, parameterpui, unit, unitpui, value, valuepui, study_id) VALUES('study_environment_parameter_2', 'the soil type was clay', 'soil type', 'PECO:0007255', 'pH', 'PECO:0007059', 'clay soil', 'ENVO:00002262', 'study2');
INSERT INTO study_experimental_design (id, pui, description, study_id) VALUES('study_experimental_design_2', 'CO_725:0000245', 'Lines were repeated twice at each location using a complete block design. In order to limit competition effects, each block was organized into four sub-blocks corresponding to earliest groups based on a prior information.', 'study2');
INSERT INTO study_growth_facility (id, pui, description, study_id) VALUES('study_growth_facility_2', 'CO_725:0000262', 'field environment condition, greenhouse', 'study2');
INSERT INTO study_last_update (id, "timestamp", "version", study_id) VALUES('study_last_update_2', '2020-04-02T20:55:29.277Z', '2.2.3', 'study2');
INSERT INTO study_observation_level (id, level_name, level_order, study_id) VALUES('study_observation_level_5', 'field', 0, 'study2');
INSERT INTO study_observation_level (id, level_name, level_order, study_id) VALUES('study_observation_level_6', 'block', 1, 'study2');
INSERT INTO study_observation_level (id, level_name, level_order, study_id) VALUES('study_observation_level_7', 'plot', 2, 'study2');
INSERT INTO study_observation_level (id, level_name, level_order, study_id) VALUES('study_observation_level_8', 'plant', 3, 'study2');
INSERT INTO study_season (study_db_id, season_db_id) VALUES('study2', 'spring_2012');
INSERT INTO study_season (study_db_id, season_db_id) VALUES('study2', 'summer_2012');
INSERT INTO study_season (study_db_id, season_db_id) VALUES('study2', 'fall_2012');
INSERT INTO study_season (study_db_id, season_db_id) VALUES('study2', 'winter_2012');

INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('study_er_2', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO study_external_references(study_entity_id, external_references_id) VALUES ('study2', 'study_er_2');


--study 3
INSERT INTO study(auth_user_id, id, active, cultural_practices, documentationurl, end_date, license, observation_units_description, start_date, study_code, study_description, study_name, studypui, study_type, location_id, trial_id, program_id, crop_id) VALUES ('anonymousUser', 'study3', true, null, 'https://brapi.org', '2023-02-02', 'https://creativecommons.org/licenses/by/4.0', null, '2023-02-02', 'Geno_2023', 'Dummy Genotyping Study', 'Dummy Genotyping Study', 'doi:10.255454/fake/32345', 'genotype','location_02', 'trial2', 'program2', '1');

INSERT INTO person(auth_user_id, id, description, email_address, institute_name, first_name, last_name, mailing_address, middle_name, phone_number, userid) VALUES ('anonymousUser', 'study_contact_3', 'Breeder', 'e.breeder@brapi.org', 'Plant Science Institute', 'Eve', 'Breeder', '123 Road Street, City, State, Country, 98765', '', '+19876543210', '0000-0002-0632-8751');
INSERT INTO study_contact (study_db_id, person_db_id) VALUES('study3', 'study_contact_3');
INSERT INTO study_last_update (id, "timestamp", "version", study_id) VALUES('study_last_update_3', '2020-04-02T20:55:29.277Z', '2.2.3', 'study3');
INSERT INTO study_observation_level (id, level_name, level_order, study_id) VALUES('study_observation_level_9', 'field', 0, 'study3');
INSERT INTO study_observation_level (id, level_name, level_order, study_id) VALUES('study_observation_level_10', 'block', 1, 'study3');
INSERT INTO study_observation_level (id, level_name, level_order, study_id) VALUES('study_observation_level_11', 'plot', 2, 'study3');
INSERT INTO study_observation_level (id, level_name, level_order, study_id) VALUES('study_observation_level_12', 'plant', 3, 'study3');
INSERT INTO study_season (study_db_id, season_db_id) VALUES('study3', 'spring_2012');
INSERT INTO study_season (study_db_id, season_db_id) VALUES('study3', 'summer_2012');
INSERT INTO study_season (study_db_id, season_db_id) VALUES('study3', 'fall_2012');
INSERT INTO study_season (study_db_id, season_db_id) VALUES('study3', 'winter_2012');

INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('study_er_3', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO study_external_references(study_entity_id, external_references_id) VALUES ('study3', 'study_er_3');
