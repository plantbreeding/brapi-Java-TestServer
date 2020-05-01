
INSERT INTO seed_lot (id, amount, created_date, description, last_updated, "name", source_collection, storage_location, units, germplasm_id, location_id, program_id) VALUES('seed_lot1', 360, '2020-04-02', 'This is a seed lot', '2020-04-08', 'Seed Lot 1', 'Nursery', 'Onsite Seed Vault', 'seed', 'germplasm1', 'location_01', 'program1');
INSERT INTO additional_info(id, key, value) VALUES ('seed_lot_ai_1', 'dummyData', 'True');
INSERT INTO seed_lot_additional_info(seed_lot_entity_id, additional_info_id) VALUES ('seed_lot1', 'seed_lot_ai_1');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('seed_lot_er_1', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO seed_lot_external_references(seed_lot_entity_id, external_references_id) VALUES ('seed_lot1', 'seed_lot_er_1');
INSERT INTO seed_lot (id, amount, created_date, description, last_updated, "name", source_collection, storage_location, units, germplasm_id, location_id, program_id) VALUES('seed_lot2', 40, '2020-04-02', 'This is another seed lot', '2020-04-08', 'Seed Lot 2', 'Nursery', 'Onsite Seed Vault', 'seed', 'germplasm1', 'location_01', 'program1');

INSERT INTO additional_info(id, key, value) VALUES ('seed_lot_ai_2', 'dummyData', 'True');
INSERT INTO seed_lot_additional_info(seed_lot_entity_id, additional_info_id) VALUES ('seed_lot2', 'seed_lot_ai_2');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('seed_lot_er_2', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO seed_lot_external_references(seed_lot_entity_id, external_references_id) VALUES ('seed_lot2', 'seed_lot_er_2');

INSERT INTO seed_lot_transaction (id, amount, description, "timestamp", units, from_seed_lot_id, to_seed_lot_id) VALUES('seed_lot_transaction1', 40, 'start new seed lot', '2020-04-08', 'seed', 'seed_lot1', 'seed_lot2');
INSERT INTO additional_info(id, key, value) VALUES ('seed_lot_transaction_ai_1', 'dummyData', 'True');
INSERT INTO seed_lot_transaction_additional_info(seed_lot_transaction_entity_id, additional_info_id) VALUES ('seed_lot_transaction1', 'seed_lot_transaction_ai_1');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('seed_lot_transaction_er_1', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO seed_lot_transaction_external_references(seed_lot_transaction_entity_id, external_references_id) VALUES ('seed_lot_transaction1', 'seed_lot_transaction_er_1');

INSERT INTO seed_lot_transaction (id, amount, description, "timestamp", units, from_seed_lot_id, to_seed_lot_id) VALUES('seed_lot_transaction2', 40, 'Empty the seed lot', '2020-04-04', 'seed', 'seed_lot2', 'seed_lot1');
INSERT INTO additional_info(id, key, value) VALUES ('seed_lot_transaction_ai_2', 'dummyData', 'True');
INSERT INTO seed_lot_transaction_additional_info(seed_lot_transaction_entity_id, additional_info_id) VALUES ('seed_lot_transaction2', 'seed_lot_transaction_ai_2');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('seed_lot_transaction_er_2', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO seed_lot_transaction_external_references(seed_lot_transaction_entity_id, external_references_id) VALUES ('seed_lot_transaction2', 'seed_lot_transaction_er_2');
