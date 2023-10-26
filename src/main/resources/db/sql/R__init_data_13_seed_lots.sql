
INSERT INTO seed_lot (auth_user_id, id, amount, created_date, description, last_updated, "name", source_collection, storage_location, units, location_id, program_id) VALUES('anonymousUser', 'seed_lot1', 360, '2020-04-02', 'This is a seed lot', '2020-04-08', 'Seed Lot 1', 'Nursery', 'Onsite Seed Vault', 'seed', 'location_01', 'program1');
INSERT INTO seed_lot_content_mixture(id, mixture_percentage, cross_id, germplasm_id, seed_lot_id) VALUES ('seed_lot_content_mixture1', '100', null, 'germplasm1', 'seed_lot1');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('seed_lot_er_1', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO seed_lot_external_references(seed_lot_entity_id, external_references_id) VALUES ('seed_lot1', 'seed_lot_er_1');

INSERT INTO seed_lot (auth_user_id, id, amount, created_date, description, last_updated, "name", source_collection, storage_location, units, location_id, program_id) VALUES('anonymousUser', 'seed_lot2', 40, '2020-04-02', 'This is another seed lot', '2020-04-08', 'Seed Lot 2', 'Nursery', 'Onsite Seed Vault', 'seed', 'location_01', 'program1');
INSERT INTO seed_lot_content_mixture(id, mixture_percentage, cross_id, germplasm_id, seed_lot_id) VALUES ('seed_lot_content_mixture2', '50', null, 'germplasm3', 'seed_lot2');
INSERT INTO seed_lot_content_mixture(id, mixture_percentage, cross_id, germplasm_id, seed_lot_id) VALUES ('seed_lot_content_mixture3', '50', null, 'germplasm2', 'seed_lot2');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('seed_lot_er_2', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO seed_lot_external_references(seed_lot_entity_id, external_references_id) VALUES ('seed_lot2', 'seed_lot_er_2');

INSERT INTO seed_lot_transaction (auth_user_id, id, amount, description, "timestamp", units, from_seed_lot_id, to_seed_lot_id) VALUES('anonymousUser', 'seed_lot_transaction1', 40, 'start new seed lot', '2020-04-08', 'seed', 'seed_lot1', 'seed_lot2');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('seed_lot_transaction_er_1', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO seed_lot_transaction_external_references(seed_lot_transaction_entity_id, external_references_id) VALUES ('seed_lot_transaction1', 'seed_lot_transaction_er_1');

INSERT INTO seed_lot_transaction (auth_user_id, id, amount, description, "timestamp", units, from_seed_lot_id, to_seed_lot_id) VALUES('anonymousUser', 'seed_lot_transaction2', 40, 'Empty the seed lot', '2020-04-04', 'seed', 'seed_lot2', 'seed_lot1');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('seed_lot_transaction_er_2', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO seed_lot_transaction_external_references(seed_lot_transaction_entity_id, external_references_id) VALUES ('seed_lot_transaction2', 'seed_lot_transaction_er_2');
