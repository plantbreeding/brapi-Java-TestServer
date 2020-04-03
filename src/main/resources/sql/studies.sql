
INSERT INTO study(id, active, cultural_practices, documentationurl, end_date, license, observation_units_description, start_date, study_code, study_description, study_name, studypui, study_type, location_id, trial_id) VALUES ('study1', true, 'Irrigation was applied according needs during summer to prevent water stress', 'https://brapi.org', '2014-01-01', 'https://creativecommons.org/licenses/by/4.0', 'Observation units consisted in individual plots themselves consisting of a row of 15 plants at a density of approximately six plants per square meter.', '2013-01-01', 'Yield_2013', 'This is a yield trial for 2013', 'Paw paw 2013 yield trial', 'doi:10.155454/fake/12345', 'Phenotyping','location_01', 'trial1');

INSERT INTO contact(id, email, institute_name, "name", orcid, study_db_id, trial_db_id, "type") VALUES('study_contact_1', 'a.breeder@brapi.org', 'Plant Science Institute', 'A. Breeder', '0000-0002-0607-8728', 'study1', null, 'Breeder');
INSERT INTO study_contact (study_db_id, contact_db_id) VALUES('study1', 'study_contact_1');
INSERT INTO data_link (id, data_format, description, file_format, "name", provenance, scientific_type, url, "version", study_id) VALUES('datalink_1', 'Image Archive', 'Raw drone images collected for this study', 'application/zip', 'image-archive.zip', 'Image Processing Pipeline, built at the University of Antarctica: https://github.com/antarctica/pipeline', 'Environmental', 'https://brapi.org/image-archive.zip', '1.0.3', 'study1');
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

INSERT INTO additional_info(id, key, value) VALUES ('study_ai_1', 'dummyData', 'True');
INSERT INTO study_additional_info(study_entity_id, additional_info_id) VALUES ('study1', 'study_ai_1');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('study_er_1', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO study_external_references(study_entity_id, external_references_id) VALUES ('study1', 'study_er_1');
