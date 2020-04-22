-- observation 1
INSERT INTO observation (id, collector, observation_time_stamp, uploaded_by, value, observation_unit_id, observation_variable_id, season_id) VALUES('observation1', 'Bob', '2013-05-13T09:09:09.999Z', 'Bob (Field Book)', '10', 'observation_unit1', 'variable1', 'spring_2013');

INSERT INTO additional_info(id, key, value) VALUES ('observation_ai_1', 'dummyData', 'True');
INSERT INTO observation_additional_info(observation_entity_id, additional_info_id) VALUES ('observation1', 'observation_ai_1');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('observation_er_1', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO observation_external_references(observation_entity_id, external_references_id) VALUES ('observation1', 'observation_er_1');

-- observation 2
INSERT INTO observation (id, collector, observation_time_stamp, uploaded_by, value, observation_unit_id, observation_variable_id, season_id) VALUES('observation2', 'Bob', '2013-05-13T09:09:09.999Z', 'Bob (Field Book)', '20', 'observation_unit1', 'variable1', 'spring_2013');

INSERT INTO additional_info(id, key, value) VALUES ('observation_ai_2', 'dummyData', 'True');
INSERT INTO observation_additional_info(observation_entity_id, additional_info_id) VALUES ('observation2', 'observation_ai_2');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('observation_er_2', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO observation_external_references(observation_entity_id, external_references_id) VALUES ('observation2', 'observation_er_2');

-- observation 3
INSERT INTO observation (id, collector, observation_time_stamp, uploaded_by, value, observation_unit_id, observation_variable_id, season_id) VALUES('observation3', 'Bob', '2013-05-13T09:09:09.999Z', 'Bob (Field Book)', '30', 'observation_unit2', 'variable1', 'spring_2013');

INSERT INTO additional_info(id, key, value) VALUES ('observation_ai_3', 'dummyData', 'True');
INSERT INTO observation_additional_info(observation_entity_id, additional_info_id) VALUES ('observation3', 'observation_ai_3');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('observation_er_3', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO observation_external_references(observation_entity_id, external_references_id) VALUES ('observation3', 'observation_er_3');

-- observation 4
INSERT INTO observation (id, collector, observation_time_stamp, uploaded_by, value, observation_unit_id, observation_variable_id, season_id) VALUES('observation4', 'Bob', '2013-05-13T09:09:09.999Z', 'Bob (Field Book)', '40', 'observation_unit2', 'variable1', 'spring_2013');

INSERT INTO additional_info(id, key, value) VALUES ('observation_ai_4', 'dummyData', 'True');
INSERT INTO observation_additional_info(observation_entity_id, additional_info_id) VALUES ('observation4', 'observation_ai_4');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('observation_er_4', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO observation_external_references(observation_entity_id, external_references_id) VALUES ('observation4', 'observation_er_4');