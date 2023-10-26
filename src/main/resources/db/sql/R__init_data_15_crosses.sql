
-- crossing project 1
INSERT INTO crossing_project (auth_user_id, id, description, "name", program_id) VALUES('anonymousUser', 'crossing_project1', 'This is a crossing project', 'Crossing Project', 'program1');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('crossing_project_er_1', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO crossing_project_external_references(crossing_project_entity_id, external_references_id) VALUES ('crossing_project1', 'crossing_project_er_1');

INSERT INTO cross_entity (auth_user_id, id, cross_type, "name", planned, crossing_project_id) VALUES('anonymousUser', 'cross1', 0, 'germ1 X germ2', false, 'crossing_project1');
INSERT INTO cross_entity_cross_attributes (cross_entity_id, cross_attributes) VALUES('cross1', 'maleFloweringDate:2020-04-01');
insert into cross_pollination_event (id, pollination_number, pollination_successful, pollination_time_stamp, cross_id) values ('cross_pollination_event1', 'PN123', true, '2020-04-08', 'cross1');
INSERT INTO cross_parent (id, parent_type, cross_id, crossing_project_id, germplasm_id, observation_unit_id) VALUES('cross_parent1', 0, 'cross1', 'crossing_project1', 'germplasm1', 'observation_unit1');
INSERT INTO cross_parent (id, parent_type, cross_id, crossing_project_id, germplasm_id, observation_unit_id) VALUES('cross_parent2', 1, 'cross1', 'crossing_project1', 'germplasm2', 'observation_unit2');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('cross_er_1', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO cross_entity_external_references(cross_entity_id, external_references_id) VALUES ('cross1', 'cross_er_1');
UPDATE seed_lot_content_mixture SET cross_id = 'cross1' where id = 'seed_lot_content_mixture1';
UPDATE seed_lot_content_mixture SET cross_id = 'cross1' where id = 'seed_lot_content_mixture2';
UPDATE observation_unit SET cross_id = 'cross1' where id = 'observation_unit1';
UPDATE observation_unit SET cross_id = 'cross1' where id = 'observation_unit2';

INSERT INTO cross_entity (auth_user_id, id, cross_type, "name", planned, crossing_project_id, status) VALUES('anonymousUser', 'cross2', 0, 'germ2 X germ3', true, 'crossing_project1', 1);
insert into cross_pollination_event (id, pollination_number, pollination_successful, pollination_time_stamp, cross_id) values ('cross_pollination_event2', 'PN234', true, '2020-05-09', 'cross2');
insert into cross_pollination_event (id, pollination_number, pollination_successful, pollination_time_stamp, cross_id) values ('cross_pollination_event4', 'PN456', false, '2020-04-09', 'cross2');
INSERT INTO cross_parent (id, parent_type, cross_id, crossing_project_id, germplasm_id, observation_unit_id) VALUES('cross_parent3', 0, 'cross2', 'crossing_project1', 'germplasm3', 'observation_unit3');
INSERT INTO cross_parent (id, parent_type, cross_id, crossing_project_id, germplasm_id, observation_unit_id) VALUES('cross_parent4', 1, 'cross2', 'crossing_project1', 'germplasm2', 'observation_unit2');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('cross_er_2', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO cross_entity_external_references(cross_entity_id, external_references_id) VALUES ('cross2', 'cross_er_2');
UPDATE cross_entity SET planned_cross_id = 'cross2' WHERE id = 'cross1';
UPDATE observation_unit SET cross_id = 'cross2' where id = 'observation_unit3';


-- crossing project 2
INSERT INTO crossing_project (auth_user_id, id, description, "name", program_id) VALUES('anonymousUser', 'crossing_project2', 'This is a crossing project', 'Crossing Project', 'program2');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('crossing_project_er_2', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO crossing_project_external_references(crossing_project_entity_id, external_references_id) VALUES ('crossing_project2', 'crossing_project_er_2');

INSERT INTO cross_entity (auth_user_id, id, cross_type, "name", planned, crossing_project_id) VALUES('anonymousUser', 'cross3', 0, 'germ1 X germ2', false, 'crossing_project2');
INSERT INTO cross_entity_cross_attributes (cross_entity_id, cross_attributes) VALUES('cross3', 'maleFloweringDate:2020-04-03');
insert into cross_pollination_event (id, pollination_number, pollination_successful, pollination_time_stamp, cross_id) values ('cross_pollination_event3', 'PN345', true, '2020-04-08', 'cross3');
INSERT INTO cross_parent (id, parent_type, cross_id, crossing_project_id, germplasm_id, observation_unit_id) VALUES('cross_parent5', 0, 'cross3', 'crossing_project2', 'germplasm1', 'observation_unit1');
INSERT INTO cross_parent (id, parent_type, cross_id, crossing_project_id, germplasm_id, observation_unit_id) VALUES('cross_parent6', 1, 'cross3', 'crossing_project2', 'germplasm2', 'observation_unit2');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('cross_er_3', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO cross_entity_external_references(cross_entity_id, external_references_id) VALUES ('cross3', 'cross_er_3');
UPDATE seed_lot_content_mixture SET cross_id = 'cross3' where id = 'seed_lot_content_mixture3';

INSERT INTO cross_entity (auth_user_id, id, cross_type, "name", planned, crossing_project_id, status) VALUES('anonymousUser', 'cross4', 0, 'germ2 X germ3', true, 'crossing_project2', 0);
insert into cross_pollination_event (id, pollination_number, pollination_successful, pollination_time_stamp, cross_id) values ('cross_pollination_event5', 'PN567', true, '2020-05-09', 'cross4');
insert into cross_pollination_event (id, pollination_number, pollination_successful, pollination_time_stamp, cross_id) values ('cross_pollination_event6', 'PN678', false, '2020-04-09', 'cross4');
INSERT INTO cross_parent (id, parent_type, cross_id, crossing_project_id, germplasm_id, observation_unit_id) VALUES('cross_parent7', 0, 'cross4', 'crossing_project2', 'germplasm3', 'observation_unit3');
INSERT INTO cross_parent (id, parent_type, cross_id, crossing_project_id, germplasm_id, observation_unit_id) VALUES('cross_parent8', 1, 'cross4', 'crossing_project2', 'germplasm2', 'observation_unit2');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('cross_er_4', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO cross_entity_external_references(cross_entity_id, external_references_id) VALUES ('cross4', 'cross_er_4');
UPDATE cross_entity SET planned_cross_id = 'cross4' WHERE id = 'cross3';

