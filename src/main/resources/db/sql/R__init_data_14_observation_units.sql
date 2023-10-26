
-- unit 1
INSERT INTO observation_unit(auth_user_id, id, observation_unit_name, observation_unitpui, germplasm_id, cross_id, seed_lot_id, study_id) VALUES('anonymousUser', 'observation_unit1', 'Plot 1', 'doi:10.12345/plot/1a9afc14', 'germplasm1', null, 'seed_lot1', 'study1');
INSERT INTO observation_unit_treatment (id, factor, modality, observation_unit_id) VALUES('observation_unit_treatment1', 'fertilizer', 'low fertilizer', 'observation_unit1');
INSERT INTO geojson(id, type) VALUES ('observation_unit_geo_1', 'Point');
INSERT INTO coordinate(id, altitude, latitude, longitude, geojson_id) VALUES ('observation_unit_coor_1', 123, 42.44423, -76.46313, 'observation_unit_geo_1');
INSERT INTO observation_unit_position (id, entry_type, level_code, level_name, level_order, position_coordinatex, position_coordinatextype, position_coordinatey, position_coordinateytype, geo_coordinates_id, observation_unit_id) VALUES('observation_unit_position1', 1, 'plot_1', 6, 4, '1', 2, '1', 3, 'observation_unit_geo_1', 'observation_unit1');
INSERT INTO observation_unit_level (id, level_code, level_name, level_order, position_id, observation_unit_id)VALUES('observation_unit_level1', 'fieldA', 1, 1, 'observation_unit_position1', null);
INSERT INTO observation_unit_level (id, level_code, level_name, level_order, position_id, observation_unit_id)VALUES('observation_unit_level2', 'rep1', 3, 2, 'observation_unit_position1', null);
INSERT INTO observation_unit_level (id, level_code, level_name, level_order, position_id, observation_unit_id)VALUES('observation_unit_level3', 'block1', 4, 3, 'observation_unit_position1', null);

INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('observation_unit_er_1', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO observation_unit_external_references(observation_unit_entity_id, external_references_id) VALUES ('observation_unit1', 'observation_unit_er_1');


-- unit 2
INSERT INTO observation_unit(auth_user_id, id, observation_unit_name, observation_unitpui, germplasm_id, cross_id, seed_lot_id, study_id) VALUES('anonymousUser', 'observation_unit2', 'Plot 2', 'doi:10.12345/plot/2a9afc24', 'germplasm2', null, 'seed_lot1', 'study1');
INSERT INTO observation_unit_treatment (id, factor, modality, observation_unit_id) VALUES('observation_unit_treatment2', 'fertilizer', 'low fertilizer', 'observation_unit2');
INSERT INTO geojson(id, type) VALUES ('observation_unit_geo_2', 'Point');
INSERT INTO coordinate(id, altitude, latitude, longitude, geojson_id) VALUES ('observation_unit_coor_2', 123, 42.44423, -76.46313, 'observation_unit_geo_2');
INSERT INTO observation_unit_position (id, entry_type, level_code, level_name, level_order, position_coordinatex, position_coordinatextype, position_coordinatey, position_coordinateytype, geo_coordinates_id, observation_unit_id) VALUES('observation_unit_position2', 1, 'plot_2', 6, 4, '1', 2, '2', 3, 'observation_unit_geo_2', 'observation_unit2');
INSERT INTO observation_unit_level (id, level_code, level_name, level_order, position_id, observation_unit_id)VALUES('observation_unit_level4', 'fieldA', 1, 1, 'observation_unit_position2', null);
INSERT INTO observation_unit_level (id, level_code, level_name, level_order, position_id, observation_unit_id)VALUES('observation_unit_level5', 'rep1', 3, 2, 'observation_unit_position2', null);
INSERT INTO observation_unit_level (id, level_code, level_name, level_order, position_id, observation_unit_id)VALUES('observation_unit_level6', 'block2', 4, 3, 'observation_unit_position2', null);

INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('observation_unit_er_2', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO observation_unit_external_references(observation_unit_entity_id, external_references_id) VALUES ('observation_unit2', 'observation_unit_er_2');


-- unit 3
INSERT INTO observation_unit(auth_user_id, id, observation_unit_name, observation_unitpui, germplasm_id, cross_id, seed_lot_id, study_id) VALUES('anonymousUser', 'observation_unit3', 'Plot 3', 'doi:10.12345/plot/3a9afc34', 'germplasm3', null, 'seed_lot1', 'study1');
INSERT INTO observation_unit_treatment (id, factor, modality, observation_unit_id) VALUES('observation_unit_treatment3', 'fertilizer', 'low fertilizer', 'observation_unit3');
INSERT INTO geojson(id, type) VALUES ('observation_unit_geo_3', 'Point');
INSERT INTO coordinate(id, altitude, latitude, longitude, geojson_id) VALUES ('observation_unit_coor_3', 123, 42.44423, -76.46313, 'observation_unit_geo_3');
INSERT INTO observation_unit_position (id, entry_type, level_code, level_name, level_order, position_coordinatex, position_coordinatextype, position_coordinatey, position_coordinateytype, geo_coordinates_id, observation_unit_id) VALUES('observation_unit_position3', 1, 'plot_3', 6, 4, '1', 2, '3', 3, 'observation_unit_geo_3', 'observation_unit3');
INSERT INTO observation_unit_level (id, level_code, level_name, level_order, position_id, observation_unit_id)VALUES('observation_unit_level7', 'fieldA', 1, 1, 'observation_unit_position3', null);
INSERT INTO observation_unit_level (id, level_code, level_name, level_order, position_id, observation_unit_id)VALUES('observation_unit_level8', 'rep2', 3, 2, 'observation_unit_position3', null);
INSERT INTO observation_unit_level (id, level_code, level_name, level_order, position_id, observation_unit_id)VALUES('observation_unit_level9', 'block1', 4, 3, 'observation_unit_position3', null);

INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('observation_unit_er_3', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO observation_unit_external_references(observation_unit_entity_id, external_references_id) VALUES ('observation_unit3', 'observation_unit_er_3');
