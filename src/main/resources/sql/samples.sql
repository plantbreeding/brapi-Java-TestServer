
INSERT INTO plate (id, client_plate_db_id, client_plate_barcode, plate_name, sample_submission_format, status_time_stamp, submission_id) VALUES('plate1', '123456789', '123456789', 'Plate 1', 0, '2018-01-01 00:00:00', null);
INSERT INTO sample (id, concentration, plate_column, plate_row, sample_barcode, sample_description, sample_group_db_id, sample_name, samplepui, sample_timestamp, sample_type, taken_by, tissue_type, volume, well, observation_unit_id, plate_id, taxon_id_id) VALUES('sample1', '19', 2, 'A', '0123456789', 'This is a description of a fake sample. This sample is fake.', 'sample_group_01', 'Sample 1', 'doi://10.12345/fake/4423', '2018-01-01 00:00:00', 'DNA', 'Bob Robertson (Coordinate App)', 'Leaf', '340ul', 'A2', 'observation_unit1', 'plate1', null);
INSERT INTO additional_info(id, key, value) VALUES ('sample_ai_1', 'dummyData', 'True');
INSERT INTO sample_additional_info(sample_entity_id, additional_info_id) VALUES ('sample1', 'sample_ai_1');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('sample_er_1', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO sample_external_references(sample_entity_id, external_references_id) VALUES ('sample1', 'sample_er_1');
