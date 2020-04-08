INSERT INTO crossing_project (id, description, "name", program_id) VALUES('crossing_project1', 'This is a crossing project', 'Crossing Project', 'program1');
INSERT INTO additional_info(id, key, value) VALUES ('crossing_project_ai_1', 'dummyData', 'True');
INSERT INTO crossing_project_additional_info(crossing_project_entity_id, additional_info_id) VALUES ('crossing_project1', 'crossing_project_ai_1');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('crossing_project_er_1', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO crossing_project_external_references(crossing_project_entity_id, external_references_id) VALUES ('crossing_project1', 'crossing_project_er_1');

INSERT INTO cross_entity (id, cross_type, "name", planned, pollination_time_stamp, crossing_project_id) VALUES('cross1', 0, 'germ1 X germ2', false, '2020-04-08', 'crossing_project1');
INSERT INTO cross_entity_cross_attributes (cross_entity_id, cross_attributes) VALUES('cross1', 'maleFloweringDate:2020-04-01');
INSERT INTO cross_parent (id, parent_type, cross_id, germplasm_id, observation_unit_id) VALUES('cross_parent1', 0, 'cross1', 'germplasm1', 'observation_unit1');
INSERT INTO cross_parent (id, parent_type, cross_id, germplasm_id, observation_unit_id) VALUES('cross_parent2', 1, 'cross1', 'germplasm2', 'observation_unit2');
INSERT INTO additional_info(id, key, value) VALUES ('cross_ai_1', 'dummyData', 'True');
INSERT INTO cross_entity_additional_info(cross_entity_id, additional_info_id) VALUES ('cross1', 'cross_ai_1');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('cross_er_1', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO cross_entity_external_references(cross_entity_id, external_references_id) VALUES ('cross1', 'cross_er_1');

INSERT INTO cross_entity (id, cross_type, "name", planned, pollination_time_stamp, crossing_project_id) VALUES('cross2', 0, 'germ2 X germ3', true, null, 'crossing_project1');
INSERT INTO cross_parent (id, parent_type, cross_id, germplasm_id, observation_unit_id) VALUES('cross_parent3', 0, 'cross2', 'germplasm3', 'observation_unit3');
INSERT INTO cross_parent (id, parent_type, cross_id, germplasm_id, observation_unit_id) VALUES('cross_parent4', 1, 'cross2', 'germplasm2', 'observation_unit2');
INSERT INTO additional_info(id, key, value) VALUES ('cross_ai_2', 'dummyData', 'True');
INSERT INTO cross_entity_additional_info(cross_entity_id, additional_info_id) VALUES ('cross2', 'cross_ai_2');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('cross_er_2', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO cross_entity_external_references(cross_entity_id, external_references_id) VALUES ('cross2', 'cross_er_2');