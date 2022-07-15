
INSERT INTO plate (auth_user_id, id, client_plate_db_id, client_plate_barcode, plate_name, plate_barcode, plate_format, sample_type, sample_submission_format, status_time_stamp, submission_id, program_id, trial_id, study_id) VALUES('anonymousUser', 'plate1', '123456789', '123456789', 'Plate 1', '09876543432', 0, 0, 0, '2018-01-01 00:00:00', null, 'program1', 'trial1', 'study1');
INSERT INTO plate (auth_user_id, id, client_plate_db_id, client_plate_barcode, plate_name, plate_barcode, plate_format, sample_type, sample_submission_format, status_time_stamp, submission_id, program_id, trial_id, study_id) VALUES('anonymousUser', 'plate2', '567893342', '789253456', 'Plate 2', '05436786332', 1, 1, 1, '2018-01-01 00:00:00', null, 'program1', 'trial1', 'study1');

INSERT INTO sample (auth_user_id, id, concentration, plate_column, plate_row, sample_barcode, sample_description, sample_group_db_id, sample_name, samplepui, sample_timestamp, sample_type, taken_by, tissue_type, volume, well, observation_unit_id, plate_id, taxon_id_id) VALUES('anonymousUser', 'sample1', '19', 2, 'A', '0123456789', 'This is a description of a fake sample. This sample is fake.', 'sample_group_01', 'Sample 1', 'doi://10.12345/fake/4423', '2018-01-01 00:00:00', 'DNA', 'Bob Robertson (Coordinate App)', 'Leaf', '340', 'A2', 'observation_unit1', 'plate1', null);
INSERT INTO additional_info(id, key, value) VALUES ('sample_ai_1', 'dummyData', decode('ACED000574000454727565','hex'));
INSERT INTO sample_additional_info(sample_entity_id, additional_info_id) VALUES ('sample1', 'sample_ai_1');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('sample_er_1', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO sample_external_references(sample_entity_id, external_references_id) VALUES ('sample1', 'sample_er_1');

INSERT INTO sample (auth_user_id, id, concentration, plate_column, plate_row, sample_barcode, sample_description, sample_group_db_id, sample_name, samplepui, sample_timestamp, sample_type, taken_by, tissue_type, volume, well, observation_unit_id, plate_id, taxon_id_id) VALUES('anonymousUser', 'sample2', '29', 2, 'A', '0223456789', 'This is a description of a fake sample. This sample is fake.', 'sample_group_01', 'Sample 2', 'doi://20.22345/fake/4423', '2018-02-02 00:00:00', 'DNA', 'Bob Robertson (Coordinate App)', 'Leaf', '340', 'A2', 'observation_unit2', 'plate1', null);
INSERT INTO additional_info(id, key, value) VALUES ('sample_ai_2', 'dummyData', decode('ACED000574000454727565','hex'));
INSERT INTO sample_additional_info(sample_entity_id, additional_info_id) VALUES ('sample2', 'sample_ai_2');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('sample_er_2', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO sample_external_references(sample_entity_id, external_references_id) VALUES ('sample2', 'sample_er_2');

INSERT INTO sample (auth_user_id, id, concentration, plate_column, plate_row, sample_barcode, sample_description, sample_group_db_id, sample_name, samplepui, sample_timestamp, sample_type, taken_by, tissue_type, volume, well, observation_unit_id, plate_id, taxon_id_id) VALUES('anonymousUser', 'sample3', '39', 2, 'A', '0323456789', 'This is a description of a fake sample. This sample is fake.', 'sample_group_01', 'Sample 3', 'doi://30.32345/fake/4423', '2018-03-03 00:00:00', 'DNA', 'Bob Robertson (Coordinate App)', 'Leaf', '340', 'A2', 'observation_unit3', 'plate1', null);
INSERT INTO additional_info(id, key, value) VALUES ('sample_ai_3', 'dummyData', decode('ACED000574000454727565','hex'));
INSERT INTO sample_additional_info(sample_entity_id, additional_info_id) VALUES ('sample3', 'sample_ai_3');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('sample_er_3', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO sample_external_references(sample_entity_id, external_references_id) VALUES ('sample3', 'sample_er_3');
