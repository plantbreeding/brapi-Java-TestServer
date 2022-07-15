
INSERT INTO vendor_order(auth_user_id, id, client_plate_barcode, client_plate_db_id, sample_type, status, status_time_stamp)	VALUES ('anonymousUser', 'vendor_order1', '123456', '123456', 0, 0, '2018-01-01 00:00:00');
INSERT INTO plate_submission (auth_user_id, id, client_id, number_of_samples, sample_type, order_id) VALUES('anonymousUser', 'plate_submission1', '123456', 16, 0, 'vendor_order1');
UPDATE plate SET submission_id = 'plate_submission1' WHERE id = 'plate1';
INSERT INTO vendor_order_entity_service_ids(vendor_order_entity_id, service_ids) VALUES ('vendor_order1', 'vendor_spec_platform1');

INSERT INTO vendor_spec (auth_user_id, id, contact_name, vendor_address, vendor_city, vendor_country, vendor_description, vendor_email, vendor_name, vendor_phone, vendorurl) VALUES('anonymousUser', 'vendor_spec1', 'Bob Smith', '123 Street Ave', 'Townsville', 'USA', 'Example vendor used for testing', 'bsmith@brapi.org', 'Bobs Vendor', '+12345678910', 'https://brapi.org');

INSERT INTO vendor_spec_requirement (id, input_format_details, max_concentration, max_volume, min_concentration, min_sample_number, min_volume, plate_orientation, sample_type_details) VALUES('vendor_spec_requirement1', 'https://brapi.org', '1000ppm', '50ml', '20ppm', '1', '2ml', 'rowFirst', 'https://brapi.org');
INSERT INTO vendor_spec_input_format (id, input_format, vendor_spec_standard_requirement_db_id) VALUES('vsf1', 'Plate_96', 'vendor_spec_requirement1');
INSERT INTO vendor_spec_input_format (id, input_format, vendor_spec_standard_requirement_db_id) VALUES('vsf2', 'Tubes', 'vendor_spec_requirement1');
INSERT INTO vendor_spec_sample_type (id, sample_type, vendor_spec_standard_requirement_db_id) VALUES('vssam1', 'LEAF', 'vendor_spec_requirement1');
INSERT INTO vendor_spec_sample_type (id, sample_type, vendor_spec_standard_requirement_db_id) VALUES('vssam2', 'STEM', 'vendor_spec_requirement1');
INSERT INTO vendor_spec_sample_type (id, sample_type, vendor_spec_standard_requirement_db_id) VALUES('vssam3', 'ROOT', 'vendor_spec_requirement1');
INSERT INTO vendor_spec_well_position (id, "position", vendor_spec_standard_requirement_db_id) VALUES('vswp1', 'random', 'vendor_spec_requirement1');
INSERT INTO vendor_spec_well_position (id, "position", vendor_spec_standard_requirement_db_id) VALUES('vswp2', 'A01', 'vendor_spec_requirement1');
INSERT INTO vendor_spec_well_position (id, "position", vendor_spec_standard_requirement_db_id) VALUES('vswp3', 'H12', 'vendor_spec_requirement1');

INSERT INTO vendor_spec_platform (id, contact_email, contact_name, contact_phone, platform_description, platform_name, platformurl, shipping_address, specific_requirements, taxonomy_id_system_name, taxonomy_id_systemuri, tissue_id_system_name, tissue_id_systemuri, vendor_spec_db_id, standard_requirements_id) VALUES('vendor_spec_platform1', 'plat1@brapi.org', 'Bob Smith', '+12345678910', 'This is an example platform', 'Example Platform', 'https://brapi.org', '123 Street Ave, Townsville, USA', NULL, 'NCBITaxonomyId', 'https://ncbi.org', 'TIS', 'https://tis.org', 'vendor_spec1', 'vendor_spec_requirement1');
INSERT INTO vendor_spec_deliverable (id, description, format, "name", vendor_spec_platform_db_id) VALUES('vsd1', 'An Example Deliverable', 'CSV', 'Example Deliverable', 'vendor_spec_platform1');
INSERT INTO vendor_spec_status (id, status_description, status_name, vendor_spec_platform_db_id) VALUES('vssta1', 'Samples have been recored, but not recieved', 'Created', 'vendor_spec_platform1');
INSERT INTO vendor_spec_status (id, status_description, status_name, vendor_spec_platform_db_id) VALUES('vssta2', 'Physical samples have been received', 'Received', 'vendor_spec_platform1');
INSERT INTO vendor_spec_status (id, status_description, status_name, vendor_spec_platform_db_id) VALUES('vssta3', 'Sample submission has been rejected by the vendor', 'Rejected', 'vendor_spec_platform1');
INSERT INTO vendor_spec_status (id, status_description, status_name, vendor_spec_platform_db_id) VALUES('vssta4', 'Vendor has begun to process the samples', 'Processing', 'vendor_spec_platform1');
INSERT INTO vendor_spec_status (id, status_description, status_name, vendor_spec_platform_db_id) VALUES('vssta5', 'Processing is complete, data is ready to download', 'Completed', 'vendor_spec_platform1');


