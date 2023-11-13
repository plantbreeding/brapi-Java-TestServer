-- observation 1
INSERT INTO geojson(id, type) VALUES ('observation_geo_1', 'Point');
INSERT INTO coordinate(id, altitude, latitude, longitude, geojson_id) VALUES ('observation_coor_1', 123, 42.41423, -76.44313, 'observation_geo_1');
INSERT INTO observation (auth_user_id, id, collector, observation_time_stamp, uploaded_by, value, observation_unit_id, observation_variable_id, season_id, geo_coordinates_id) VALUES('anonymousUser', 'observation1', 'Bob', '2013-05-13T09:09:09.999Z', 'Bob (Field Book)', '10', 'observation_unit1', 'variable1', 'spring_2013', 'observation_geo_1');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('observation_er_1', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO observation_external_references(observation_entity_id, external_references_id) VALUES ('observation1', 'observation_er_1');

-- observation 2
INSERT INTO geojson(id, type) VALUES ('observation_geo_2', 'Point');
INSERT INTO coordinate(id, altitude, latitude, longitude, geojson_id) VALUES ('observation_coor_2', 123, 42.42423, -76.43313, 'observation_geo_2');
INSERT INTO observation (auth_user_id, id, collector, observation_time_stamp, uploaded_by, value, observation_unit_id, observation_variable_id, season_id, geo_coordinates_id) VALUES('anonymousUser', 'observation2', 'Bob', '2013-05-13T09:09:09.999Z', 'Bob (Field Book)', '20', 'observation_unit1', 'variable1', 'spring_2013', 'observation_geo_2');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('observation_er_2', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO observation_external_references(observation_entity_id, external_references_id) VALUES ('observation2', 'observation_er_2');

-- observation 3
INSERT INTO geojson(id, type) VALUES ('observation_geo_3', 'Point');
INSERT INTO coordinate(id, altitude, latitude, longitude, geojson_id) VALUES ('observation_coor_3', 123, 42.43423, -76.42313, 'observation_geo_3');
INSERT INTO observation (auth_user_id, id, collector, observation_time_stamp, uploaded_by, value, observation_unit_id, observation_variable_id, season_id, geo_coordinates_id) VALUES('anonymousUser', 'observation3', 'Bob', '2013-05-13T09:09:09.999Z', 'Bob (Field Book)', '30', 'observation_unit2', 'variable1', 'spring_2013', 'observation_geo_3');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('observation_er_3', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO observation_external_references(observation_entity_id, external_references_id) VALUES ('observation3', 'observation_er_3');

-- observation 4
INSERT INTO geojson(id, type) VALUES ('observation_geo_4', 'Point');
INSERT INTO coordinate(id, altitude, latitude, longitude, geojson_id) VALUES ('observation_coor_4', 123, 42.44423, -76.41313, 'observation_geo_4');
INSERT INTO observation (auth_user_id, id, collector, observation_time_stamp, uploaded_by, value, observation_unit_id, observation_variable_id, season_id, geo_coordinates_id) VALUES('anonymousUser', 'observation4', 'Bob', '2013-05-13T09:09:09.999Z', 'Bob (Field Book)', '40', 'observation_unit2', 'variable1', 'spring_2013', 'observation_geo_4');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('observation_er_4', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO observation_external_references(observation_entity_id, external_references_id) VALUES ('observation4', 'observation_er_4');