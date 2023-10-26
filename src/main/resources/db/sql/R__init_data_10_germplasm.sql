
-- germplasm1
INSERT INTO germplasm (auth_user_id, id, accession_number, acquisition_date, acquisition_source_code, biological_status_of_accession_code, collection, country_of_origin_code, default_display_name, documentationurl, genus, germplasm_name, germplasmpui, germplasm_preprocessing, mls_status, seed_source, seed_source_description, species, species_authority, subtaxa, subtaxa_authority, breeding_method_id, crop_id) VALUES('anonymousUser', 'germplasm1', 'A0000001', '2000-04-09', 2, 2, 'Fake Foods Collection', 'USA', 'Fantastico', 'https://wiki.brapi.org', 'Aspergillus', 'Tomatillo Fantastico', 'doi:10.12345/A0000001', 'EO:0007210; transplanted from study 2351 observation unit ID: pot:894', 0, 'Root Stock', 'Branches were collected from a 10-year-old tree growing in a progeny trial established in a loamy brown earth soil.', 'fructus', 'Smith, 1822', 'Aspergillus fructus A', 'Smith, 1822', 'breeding_method1', '1');

INSERT INTO germplasm_donor (id, donor_accession_number, donor_institute_code, donor_institute_name, germplasmpui, germplasm_id) VALUES('germplasm_donor1', 'A1111111', 'USA999', 'BrAPI Science Institute', 'doi:10.12345/A1111111', 'germplasm1');
INSERT INTO geojson(id, type) VALUES ('germplasm_origin_geo_1', 'Point');
INSERT INTO coordinate(id, altitude, latitude, longitude, geojson_id) VALUES ('germplasm_origin_coor_1', 123.0998, 42.53514, -76.55404, 'germplasm_origin_geo_1');
INSERT INTO germplasm_origin (id, coordinate_uncertainty, coordinates_id, germplasm_id) VALUES('germplasm_origin1', '20', 'germplasm_origin_geo_1', 'germplasm1');
INSERT INTO germplasm_institute (id, institute_address, institute_code, institute_name, institute_type, germplasm_id) VALUES('germplasm_institute00', '123 Main St, Freeville, New York, USA', 'USA999', 'BrAPI Science Institute', 0, 'germplasm1');
INSERT INTO germplasm_institute (id, institute_address, institute_code, institute_name, institute_type, germplasm_id) VALUES('germplasm_institute01', '123 Main St, Freeville, New York, USA', 'USA999', 'BrAPI Science Institute', 1, 'germplasm1');
INSERT INTO germplasm_institute (id, institute_address, institute_code, institute_name, institute_type, germplasm_id) VALUES('germplasm_institute02', '123 Main St, Freeville, New York, USA', 'USA999', 'BrAPI Science Institute', 2, 'germplasm1');
INSERT INTO germplasm_institute (id, institute_address, institute_code, institute_name, institute_type, germplasm_id) VALUES('germplasm_institute03', '123 Main St, Freeville, New York, USA', 'USA999', 'BrAPI Science Institute', 3, 'germplasm1');
INSERT INTO germplasm_institute (id, institute_address, institute_code, institute_name, institute_type, germplasm_id) VALUES('germplasm_institute04', '123 Main St, Freeville, New York, USA', 'USA999', 'BrAPI Science Institute', 4, 'germplasm1');
INSERT INTO germplasm_entity_type_of_germplasm_storage_code (germplasm_entity_id, type_of_germplasm_storage_code) VALUES('germplasm1', 0);
INSERT INTO germplasm_synonym (id, synonym, "type", germplasm_id) VALUES('germplasm_synonym1', 'Variety 123', 'Pre-Code', 'germplasm1');
INSERT INTO germplasm_taxon (id, source_name, taxon_id, germplasm_id) VALUES('germplasm_taxon1', 'NCBI', '2026747', 'germplasm1');

INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('germplasm_er_1', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO germplasm_external_references(germplasm_entity_id, external_references_id) VALUES ('germplasm1', 'germplasm_er_1');

--germplasm2
INSERT INTO germplasm (auth_user_id, id, accession_number, acquisition_date, acquisition_source_code, biological_status_of_accession_code, collection, country_of_origin_code, default_display_name, documentationurl, genus, germplasm_name, germplasmpui, germplasm_preprocessing, mls_status, seed_source, seed_source_description, species, species_authority, subtaxa, subtaxa_authority, breeding_method_id, crop_id) VALUES('anonymousUser', 'germplasm2', 'A0000002', '2000-04-09', 2, 2, 'Fake Foods Collection', 'USA', 'Fantastico', 'https://wiki.brapi.org', 'Aspergillus', 'Tomatillo Fantastico', 'doi:10.12345/A0000002', 'EO:0007210; transplanted from study 2351 observation unit ID: pot:894', 0, 'Root Stock', 'Branches were collected from a 10-year-old tree growing in a progeny trial established in a loamy brown earth soil.', 'fructus', 'Smith, 1822', 'Aspergillus fructus A', 'Smith, 1822', 'breeding_method1', '1');

INSERT INTO germplasm_donor (id, donor_accession_number, donor_institute_code, donor_institute_name, germplasmpui, germplasm_id) VALUES('germplasm_donor2', 'A2222222', 'USA999', 'BrAPI Science Institute', 'doi:10.12345/A2222222', 'germplasm2');
INSERT INTO geojson(id, type) VALUES ('germplasm_origin_geo_2', 'Point');
INSERT INTO coordinate(id, altitude, latitude, longitude, geojson_id) VALUES ('germplasm_origin_coor_2', 123.0998, 42.53514, -76.55404, 'germplasm_origin_geo_2');
INSERT INTO germplasm_origin (id, coordinate_uncertainty, coordinates_id, germplasm_id) VALUES('germplasm_origin2', '20', 'germplasm_origin_geo_2', 'germplasm2');
INSERT INTO germplasm_institute (id, institute_address, institute_code, institute_name, institute_type, germplasm_id) VALUES('germplasm_institute10', '123 Main St, Freeville, New York, USA', 'USA999', 'BrAPI Science Institute', 0, 'germplasm2');
INSERT INTO germplasm_institute (id, institute_address, institute_code, institute_name, institute_type, germplasm_id) VALUES('germplasm_institute11', '123 Main St, Freeville, New York, USA', 'USA999', 'BrAPI Science Institute', 1, 'germplasm2');
INSERT INTO germplasm_institute (id, institute_address, institute_code, institute_name, institute_type, germplasm_id) VALUES('germplasm_institute12', '123 Main St, Freeville, New York, USA', 'USA999', 'BrAPI Science Institute', 2, 'germplasm2');
INSERT INTO germplasm_institute (id, institute_address, institute_code, institute_name, institute_type, germplasm_id) VALUES('germplasm_institute13', '123 Main St, Freeville, New York, USA', 'USA999', 'BrAPI Science Institute', 3, 'germplasm2');
INSERT INTO germplasm_institute (id, institute_address, institute_code, institute_name, institute_type, germplasm_id) VALUES('germplasm_institute14', '123 Main St, Freeville, New York, USA', 'USA999', 'BrAPI Science Institute', 4, 'germplasm2');
INSERT INTO germplasm_entity_type_of_germplasm_storage_code (germplasm_entity_id, type_of_germplasm_storage_code) VALUES('germplasm2', 0);
INSERT INTO germplasm_synonym (id, synonym, "type", germplasm_id) VALUES('germplasm_synonym2', 'Variety 234', 'Pre-Code', 'germplasm2');
INSERT INTO germplasm_taxon (id, source_name, taxon_id, germplasm_id) VALUES('germplasm_taxon2', 'NCBI', '2026747', 'germplasm2');

INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('germplasm_er_2', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO germplasm_external_references(germplasm_entity_id, external_references_id) VALUES ('germplasm2', 'germplasm_er_2');

-- germplasm3
INSERT INTO germplasm (auth_user_id, id, accession_number, acquisition_date, acquisition_source_code, biological_status_of_accession_code, collection, country_of_origin_code, default_display_name, documentationurl, genus, germplasm_name, germplasmpui, germplasm_preprocessing, mls_status, seed_source, seed_source_description, species, species_authority, subtaxa, subtaxa_authority, breeding_method_id, crop_id) VALUES('anonymousUser', 'germplasm3', 'A0000003', '2000-04-09', 2, 2, 'Fake Foods Collection', 'USA', 'Fantastico', 'https://wiki.brapi.org', 'Aspergillus', 'Tomatillo Fantastico', 'doi:10.12345/A0000003', 'EO:0007210; transplanted from study 2351 observation unit ID: pot:894', 0, 'Root Stock', 'Branches were collected from a 10-year-old tree growing in a progeny trial established in a loamy brown earth soil.', 'fructus', 'Smith, 1822', 'Aspergillus fructus A', 'Smith, 1822', 'breeding_method1', '1');

INSERT INTO germplasm_donor (id, donor_accession_number, donor_institute_code, donor_institute_name, germplasmpui, germplasm_id) VALUES('germplasm_donor3', 'A3333333', 'USA999', 'BrAPI Science Institute', 'doi:10.12345/A3333333', 'germplasm3');
INSERT INTO geojson(id, type) VALUES ('germplasm_origin_geo_3', 'Point');
INSERT INTO coordinate(id, altitude, latitude, longitude, geojson_id) VALUES ('germplasm_origin_coor_3', 123.0998, 42.53514, -76.55404, 'germplasm_origin_geo_3');
INSERT INTO germplasm_origin (id, coordinate_uncertainty, coordinates_id, germplasm_id) VALUES('germplasm_origin3', '20', 'germplasm_origin_geo_3', 'germplasm3');
INSERT INTO germplasm_institute (id, institute_address, institute_code, institute_name, institute_type, germplasm_id) VALUES('germplasm_institute20', '123 Main St, Freeville, New York, USA', 'USA999', 'BrAPI Science Institute', 0, 'germplasm3');
INSERT INTO germplasm_institute (id, institute_address, institute_code, institute_name, institute_type, germplasm_id) VALUES('germplasm_institute21', '123 Main St, Freeville, New York, USA', 'USA999', 'BrAPI Science Institute', 1, 'germplasm3');
INSERT INTO germplasm_institute (id, institute_address, institute_code, institute_name, institute_type, germplasm_id) VALUES('germplasm_institute22', '123 Main St, Freeville, New York, USA', 'USA999', 'BrAPI Science Institute', 2, 'germplasm3');
INSERT INTO germplasm_institute (id, institute_address, institute_code, institute_name, institute_type, germplasm_id) VALUES('germplasm_institute23', '123 Main St, Freeville, New York, USA', 'USA999', 'BrAPI Science Institute', 3, 'germplasm3');
INSERT INTO germplasm_institute (id, institute_address, institute_code, institute_name, institute_type, germplasm_id) VALUES('germplasm_institute24', '123 Main St, Freeville, New York, USA', 'USA999', 'BrAPI Science Institute', 4, 'germplasm3');
INSERT INTO germplasm_entity_type_of_germplasm_storage_code (germplasm_entity_id, type_of_germplasm_storage_code) VALUES('germplasm3', 0);
INSERT INTO germplasm_synonym (id, synonym, "type", germplasm_id) VALUES('germplasm_synonym3', 'Variety 345', 'Pre-Code', 'germplasm3');
INSERT INTO germplasm_taxon (id, source_name, taxon_id, germplasm_id) VALUES('germplasm_taxon3', 'NCBI', '2026747', 'germplasm3');

INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('germplasm_er_3', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO germplasm_external_references(germplasm_entity_id, external_references_id) VALUES ('germplasm3', 'germplasm_er_3');

