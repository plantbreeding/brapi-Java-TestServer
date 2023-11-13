
INSERT INTO ontology(auth_user_id, id, authors, copyright, description, licence, ontology_name, version, documentationurl) VALUES ('anonymousUser', 'ontology_variable1', 'Bob', '2017 Ontology.org', 'Ontology.org', 'Apache', 'Ontology.org', '17', 'https://ontology.org');

INSERT INTO scale (auth_user_id, id, data_type, decimal_places, units, scale_name, valid_value_min, valid_value_max, ontology_id, scalepui) VALUES ('anonymousUser', 'scale_variable1', 4, 1, 'cm', 'Centimeter', '0', '99999', 'ontology_variable1', 'http://dx.doi.org/10.1234/brapi000');
INSERT INTO method(auth_user_id, id, description, formula, method_class, name, reference, ontology_id, methodpui) VALUES ('anonymousUser', 'method_variable1', 'Standard rolled measuring tape', 'a^2 + b^2 = c^2', 'Numeric', 'Tape Measure', 'google.com', 'ontology_variable1', 'http://dx.doi.org/10.1234/brapi000');
INSERT INTO trait (auth_user_id, id, attribute, attributepui, entity, entitypui, main_abbreviation, trait_description, trait_name, status, trait_class, ontology_id, traitpui) VALUES ('anonymousUser', 'trait_variable1', 'height', 'http://dx.doi.org/10.1234/brapi000', 'stalk', 'http://dx.doi.org/10.1234/brapi000', 'H', 'plant height', 'Plant Height', 'active', 'Numeric', 'ontology_variable1', 'http://dx.doi.org/10.1234/brapi000');

INSERT INTO observation_variable (auth_user_id, id, pui, default_value, documentationurl, growth_stage, institution, "language", scientist, status, submission_timestamp, crop_id, method_id, ontology_id, scale_id, trait_id, "name") VALUES ('anonymousUser', 'variable1', 'http://dx.doi.org/10.1234/brapi000', '10', 'https://brapi.org', '1', 'Cornell', 'English', 'Bob', 'active', '2011-06-14T22:12:51Z', '1', 'method_variable1', 'ontology_variable1', 'scale_variable1', 'trait_variable1', 'Plant Height');
INSERT INTO variable_base_entity_context_of_use (variable_base_entity_id, context_of_use) VALUES('variable1', 'Trial evaluation');
INSERT INTO variable_base_entity_context_of_use (variable_base_entity_id, context_of_use) VALUES('variable1', 'Nursery evaluation');
INSERT INTO variable_base_entity_synonyms (variable_base_entity_id, synonyms) VALUES('variable1', 'Maize Height');
INSERT INTO variable_base_entity_synonyms (variable_base_entity_id, synonyms) VALUES('variable1', 'Stalk Height');
INSERT INTO variable_base_entity_synonyms (variable_base_entity_id, synonyms) VALUES('variable1', 'Corn Height');
INSERT INTO study_variable (study_db_id, variable_db_id) VALUES('study1', 'variable1');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('variable_er_1', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO variable_base_entity_external_references(variable_base_entity_id, external_references_id) VALUES ('variable1', 'variable_er_1');


INSERT INTO scale (auth_user_id, id, data_type, decimal_places, units, scale_name, valid_value_min, valid_value_max, ontology_id, scalepui) VALUES ('anonymousUser', 'scale_variable2', 4, 1, 'cm', 'Centimeter', '0', '99999', 'ontology_variable1', 'http://dx.doi.org/10.1234/brapi000');
INSERT INTO method(auth_user_id, id, description, formula, method_class, name, reference, ontology_id, methodpui) VALUES ('anonymousUser', 'method_variable2', 'Standard rolled measuring tape', 'a^2 + b^2 = c^2', 'Numeric', 'Tape Measure', 'google.com', 'ontology_variable1', 'http://dx.doi.org/10.1234/brapi000');
INSERT INTO trait (auth_user_id, id, attribute, attributepui, entity, entitypui, main_abbreviation, trait_description, trait_name, status, trait_class, ontology_id, traitpui) VALUES ('anonymousUser', 'trait_variable2', 'height', 'http://dx.doi.org/10.1234/brapi000', 'stalk', 'http://dx.doi.org/10.1234/brapi000', 'H', 'plant height', 'Plant Height', 'active', 'Numeric', 'ontology_variable1', 'http://dx.doi.org/10.1234/brapi000');

INSERT INTO observation_variable (auth_user_id, id, pui, default_value, documentationurl, growth_stage, institution, "language", scientist, status, submission_timestamp, crop_id, method_id, ontology_id, scale_id, trait_id, "name") VALUES ('anonymousUser', 'variable2', 'http://dx.doi.org/10.1234/brapi000', '20', 'https://brapi.org', '1', 'Cornell', 'English', 'Bob', 'active', '2012-06-24T22:22:52Z', '1', 'method_variable2', 'ontology_variable1', 'scale_variable2', 'trait_variable2', 'Plant Height');
INSERT INTO variable_base_entity_context_of_use (variable_base_entity_id, context_of_use) VALUES('variable2', 'Trial evaluation');
INSERT INTO variable_base_entity_context_of_use (variable_base_entity_id, context_of_use) VALUES('variable2', 'Nursery evaluation');
INSERT INTO variable_base_entity_synonyms (variable_base_entity_id, synonyms) VALUES('variable2', 'Maize Height');
INSERT INTO variable_base_entity_synonyms (variable_base_entity_id, synonyms) VALUES('variable2', 'Stalk Height');
INSERT INTO variable_base_entity_synonyms (variable_base_entity_id, synonyms) VALUES('variable2', 'Corn Height');
INSERT INTO study_variable (study_db_id, variable_db_id) VALUES('study2', 'variable2');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('variable_er_2', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO variable_base_entity_external_references(variable_base_entity_id, external_references_id) VALUES ('variable2', 'variable_er_2');