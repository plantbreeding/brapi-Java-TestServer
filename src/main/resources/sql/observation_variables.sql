
INSERT INTO ontology(id, authors, copyright, description, licence, ontology_name, version, documentationurl) VALUES ('ontology_variable1', 'Bob', '2017 Ontology.org', 'Ontology.org', 'Apache', 'Ontology.org', '17', 'https://ontology.org');

INSERT INTO scale (id, data_type, decimal_places, scale_name, valid_value_min, valid_value_max, ontology_id) VALUES ('scale_variable1', 4, 1, 'Centimeter', '0', '99999', 'ontology_variable1');
INSERT INTO method(id, description, formula, method_class, name, reference, ontology_id) VALUES ('method_variable1', 'Standard rolled measuring tape', 'a^2 + b^2 = c^2', 'Numeric', 'Tape Measure', 'google.com', 'ontology_variable1');
INSERT INTO trait (id, attribute, entity, main_abbreviation, trait_description, trait_name, status, trait_class, ontology_id) VALUES ('trait_variable1', 'height', 'stalk', 'H', 'plant height', 'Plant Height', 'active', 'Numeric', 'ontology_variable1');

INSERT INTO observation_variable (id, default_value, documentationurl, growth_stage, institution, "language", scientist, status, submission_timestamp, crop_id, method_id, ontology_id, scale_id, trait_id, "name") VALUES ('variable1', '10', 'https://brapi.org', '1', 'Cornell', 'English', 'Bob', 'active', '2011-06-14T22:12:51Z', '1', 'method_variable1', 'ontology_variable1', 'scale_variable1', 'trait_variable1', 'Plant Height');
INSERT INTO variable_base_entity_context_of_use (variable_base_entity_id, context_of_use) VALUES('variable1', 'Trial evaluation');
INSERT INTO variable_base_entity_context_of_use (variable_base_entity_id, context_of_use) VALUES('variable1', 'Nursery evaluation');
INSERT INTO variable_base_entity_synonyms (variable_base_entity_id, synonyms) VALUES('variable1', 'Maize Height');
INSERT INTO variable_base_entity_synonyms (variable_base_entity_id, synonyms) VALUES('variable1', 'Stalk Height');
INSERT INTO variable_base_entity_synonyms (variable_base_entity_id, synonyms) VALUES('variable1', 'Corn Height');
INSERT INTO additional_info(id, key, value) VALUES ('variable_ai_1', 'dummyData', 'True');
INSERT INTO variable_base_entity_additional_info(variable_base_entity_id, additional_info_id) VALUES ('variable1', 'variable_ai_1');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('variable_er_1', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO variable_base_entity_external_references(variable_base_entity_id, external_references_id) VALUES ('variable1', 'variable_er_1');


INSERT INTO scale (id, data_type, decimal_places, scale_name, valid_value_min, valid_value_max, ontology_id) VALUES ('scale_variable2', 4, 1, 'Centimeter', '0', '99999', 'ontology_variable1');
INSERT INTO method(id, description, formula, method_class, name, reference, ontology_id) VALUES ('method_variable2', 'Standard rolled measuring tape', 'a^2 + b^2 = c^2', 'Numeric', 'Tape Measure', 'google.com', 'ontology_variable1');
INSERT INTO trait (id, attribute, entity, main_abbreviation, trait_description, trait_name, status, trait_class, ontology_id) VALUES ('trait_variable2', 'height', 'stalk', 'H', 'plant height', 'Plant Height', 'active', 'Numeric', 'ontology_variable1');

INSERT INTO observation_variable (id, default_value, documentationurl, growth_stage, institution, "language", scientist, status, submission_timestamp, crop_id, method_id, ontology_id, scale_id, trait_id, "name") VALUES ('variable2', '20', 'https://brapi.org', '1', 'Cornell', 'English', 'Bob', 'active', '2012-06-24T22:22:52Z', '1', 'method_variable2', 'ontology_variable1', 'scale_variable2', 'trait_variable2', 'Plant Height');
INSERT INTO variable_base_entity_context_of_use (variable_base_entity_id, context_of_use) VALUES('variable2', 'Trial evaluation');
INSERT INTO variable_base_entity_context_of_use (variable_base_entity_id, context_of_use) VALUES('variable2', 'Nursery evaluation');
INSERT INTO variable_base_entity_synonyms (variable_base_entity_id, synonyms) VALUES('variable2', 'Maize Height');
INSERT INTO variable_base_entity_synonyms (variable_base_entity_id, synonyms) VALUES('variable2', 'Stalk Height');
INSERT INTO variable_base_entity_synonyms (variable_base_entity_id, synonyms) VALUES('variable2', 'Corn Height');
INSERT INTO additional_info(id, key, value) VALUES ('variable_ai_2', 'dummyData', 'True');
INSERT INTO variable_base_entity_additional_info(variable_base_entity_id, additional_info_id) VALUES ('variable2', 'variable_ai_2');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('variable_er_2', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO variable_base_entity_external_references(variable_base_entity_id, external_references_id) VALUES ('variable2', 'variable_er_2');