INSERT INTO geojson(id, type) VALUES ('location_geo_1', 'Point');
INSERT INTO coordinate(id, altitude, latitude, longitude, geojson_id) VALUES ('location_coor_1', 123, 42.44423, -76.46313, 'location_geo_1');
INSERT INTO location (id, abbreviation, coordinate_description, coordinate_uncertainty, country_code, country_name, documentationurl, environment_type, exposure, institute_address, institute_name, location_name, location_type, site_status, slope, topography, coordinates_id) VALUES ('location_01','L1', 'Northwest corner of greenhouse', '20', 'PER', 'Peru', 'https://brapi.org', 'Climate Control', 'Structure, no exposure', '71 Pilgrim Avenue Chevy Chase MD 20815', 'Plant Science Institute', 'Location 1', 'Storage location', 'Private', '0', 'Structure', 'location_geo_1');
INSERT INTO additional_info(id, key, value) VALUES ('location_ai_00', 'dummyData', decode('ACED000574000454727565','hex'));
INSERT INTO location_additional_info(location_entity_id, additional_info_id) VALUES ('location_01', 'location_ai_00');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('location_er_1', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO location_external_references(location_entity_id, external_references_id) VALUES ('location_01', 'location_er_1');

INSERT INTO geojson(id, type) VALUES ('location_geo_2', 'Polygon');
INSERT INTO coordinate(id, altitude, latitude, longitude, geojson_id) VALUES ('location_coor_2', 123, 42.44556, -76.45888, 'location_geo_2');
INSERT INTO coordinate(id, altitude, latitude, longitude, geojson_id) VALUES ('location_coor_3', 123, 42.44150, -76.45888, 'location_geo_2');
INSERT INTO coordinate(id, altitude, latitude, longitude, geojson_id) VALUES ('location_coor_4', 123, 42.44150, -76.46320, 'location_geo_2');
INSERT INTO coordinate(id, altitude, latitude, longitude, geojson_id) VALUES ('location_coor_5', 123, 42.44556, -76.46320, 'location_geo_2');
INSERT INTO coordinate(id, altitude, latitude, longitude, geojson_id) VALUES ('location_coor_6', 123, 42.44556, -76.45888, 'location_geo_2');
INSERT INTO location (id, abbreviation, coordinate_description, coordinate_uncertainty, country_code, country_name, documentationurl, environment_type, exposure, institute_address, institute_name, location_name, location_type, site_status, slope, topography, coordinates_id) VALUES ('location_02', 'L2', 'Outline of the institute breeding area', '20', 'PER', 'Peru', 'https://brapi.org', 'Wet Field', 'Direct Sunlight', '71 Pilgrim Avenue Chevy Chase MD 20815', 'Plant Science Institute', 'Location 2', 'Breeding location', 'Private', '1%', 'Hill', 'location_geo_2');
INSERT INTO additional_info(id, key, value) VALUES ('location_ai_09', 'dummyData', decode('ACED000574000454727565','hex'));
INSERT INTO location_additional_info(location_entity_id, additional_info_id) VALUES ('location_02', 'location_ai_09');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('location_er_2', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO location_external_references(location_entity_id, external_references_id) VALUES ('location_02', 'location_er_2');

INSERT INTO geojson(id, type) VALUES ('location_geo_3', 'Point');
INSERT INTO coordinate(id, altitude, latitude, longitude, geojson_id) VALUES ('location_coor_7', 123, 42.44506, -76.46251, 'location_geo_3');
INSERT INTO location (id, abbreviation, coordinate_description, coordinate_uncertainty, country_code, country_name, documentationurl, environment_type, exposure, institute_address, institute_name, location_name, location_type, site_status, slope, topography, coordinates_id) VALUES ('location_03', 'L3', 'Northwest corner post', '20', 'PER', 'Peru', 'https://brapi.org', 'Greenhouse', 'Partial Shade', '71 Pilgrim Avenue Chevy Chase MD 20815', 'Plant Science Institute', 'Location 3', 'Nursery location', 'Private', '0', 'Structure', 'location_geo_3');
INSERT INTO additional_info(id, key, value) VALUES ('location_ai_10', 'dummyData', decode('ACED000574000454727565','hex'));
INSERT INTO location_additional_info(location_entity_id, additional_info_id) VALUES ('location_03', 'location_ai_10');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('location_er_3', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO location_external_references(location_entity_id, external_references_id) VALUES ('location_03', 'location_er_3');
