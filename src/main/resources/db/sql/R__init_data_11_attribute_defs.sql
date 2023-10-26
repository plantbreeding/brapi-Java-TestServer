
INSERT INTO ontology(auth_user_id, id, authors, copyright, description, licence, ontology_name, version, documentationurl) VALUES ('anonymousUser', 'ontology_attribute1', 'Bob', '2017 Ontology.org', 'Ontology.org', 'Apache', 'Ontology.org', '17', 'https://ontology.org');

-- attribute def 1
INSERT INTO scale (auth_user_id, id, data_type, decimal_places, units, scale_name, valid_value_min, valid_value_max, ontology_id, scalepui) VALUES ('anonymousUser', 'scale_attribute1', 4, 1, 'cm', 'Centimeter', '0', '99999', 'ontology_attribute1', 'http://dx.doi.org/10.1234/brapi000');
INSERT INTO method(auth_user_id, id, description, formula, method_class, name, reference, ontology_id, methodpui) VALUES ('anonymousUser', 'method_attribute1', 'Standard rolled measuring tape', 'a^2 + b^2 = c^2', 'Numeric', 'Tape Measure', 'google.com', 'ontology_attribute1', 'http://dx.doi.org/10.1234/brapi000');
INSERT INTO trait (auth_user_id, id, attribute, attributepui, entity, entitypui, main_abbreviation, trait_description, trait_name, status, trait_class, ontology_id, traitpui) VALUES ('anonymousUser', 'trait_attribute1', 'height', 'http://dx.doi.org/10.1234/brapi000', 'stalk', 'http://dx.doi.org/10.1234/brapi000', 'H', 'plant height', 'Plant Height', 'active', 'Numeric', 'ontology_attribute1', 'http://dx.doi.org/10.1234/brapi000');
INSERT INTO germplasm_attribute_definition (auth_user_id, id, pui, default_value, documentationurl, growth_stage, institution, "language", scientist, status, submission_timestamp, crop_id, method_id, ontology_id, scale_id, trait_id, attribute_category, code, "datatype", description, "name", uri) VALUES ('anonymousUser', 'attribute1', 'http://dx.doi.org/10.1234/brapi000', '10', 'https://brapi.org', '1', 'Cornell', 'English', 'Bob', 'active', '2011-06-14T22:12:51Z', '1', 'method_attribute1', 'ontology_attribute1', 'scale_attribute1', 'trait_attribute1', 'Morphological', 'RHT', 'Categorical', 'Allele of marker 11_4769', 'Rht-B1b', 'http://www.brapi.org/ontology/MO_123:1000001');

INSERT INTO variable_base_entity_context_of_use (variable_base_entity_id, context_of_use) VALUES('attribute1', 'Trial evaluation');
INSERT INTO variable_base_entity_context_of_use (variable_base_entity_id, context_of_use) VALUES('attribute1', 'Nursery evaluation');
INSERT INTO variable_base_entity_synonyms (variable_base_entity_id, synonyms) VALUES('attribute1', 'Maize Height');
INSERT INTO variable_base_entity_synonyms (variable_base_entity_id, synonyms) VALUES('attribute1', 'Stalk Height');
INSERT INTO variable_base_entity_synonyms (variable_base_entity_id, synonyms) VALUES('attribute1', 'Corn Height');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('attribute_er_1', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO variable_base_entity_external_references(variable_base_entity_id, external_references_id) VALUES ('attribute1', 'attribute_er_1');


-- attribute def 2
INSERT INTO scale (auth_user_id, id, data_type, decimal_places, units, scale_name, valid_value_min, valid_value_max, ontology_id, scalepui) VALUES ('anonymousUser', 'scale_attribute2', 4, 2, 'cm', 'Centimeter', '0', '99999', 'ontology_attribute1', 'http://dx.doi.org/10.1234/brapi000');
INSERT INTO method(auth_user_id, id, description, formula, method_class, name, reference, ontology_id, methodpui) VALUES ('anonymousUser', 'method_attribute2', 'Standard rolled measuring tape', 'a^2 + b^2 = c^2', 'Numeric', 'Tape Measure', 'google.com', 'ontology_attribute1', 'http://dx.doi.org/10.1234/brapi000');
INSERT INTO trait (auth_user_id, id, attribute, attributepui, entity, entitypui, main_abbreviation, trait_description, trait_name, status, trait_class, ontology_id, traitpui) VALUES ('anonymousUser', 'trait_attribute2', 'height', 'http://dx.doi.org/10.1234/brapi000', 'stalk', 'http://dx.doi.org/10.1234/brapi000', 'H', 'plant height', 'Plant Height', 'active', 'Numeric', 'ontology_attribute1', 'http://dx.doi.org/10.1234/brapi000');
INSERT INTO germplasm_attribute_definition (auth_user_id, id, pui, default_value, documentationurl, growth_stage, institution, "language", scientist, status, submission_timestamp, crop_id, method_id, ontology_id, scale_id, trait_id, attribute_category, code, "datatype", description, "name", uri) VALUES ('anonymousUser', 'attribute2', 'http://dx.doi.org/10.1234/brapi000', '20', 'https://brapi.org', '1', 'Cornell', 'English', 'Bob', 'active', '2011-06-24T22:22:52Z', '1', 'method_attribute2', 'ontology_attribute1', 'scale_attribute2', 'trait_attribute2', 'Morphological', 'RHT', 'Categorical', 'Allele of marker 22_4769', 'Rht-B2b', 'http://www.brapi.org/ontology/MO_223:2000002');

INSERT INTO variable_base_entity_context_of_use (variable_base_entity_id, context_of_use) VALUES('attribute2', 'Trial evaluation');
INSERT INTO variable_base_entity_context_of_use (variable_base_entity_id, context_of_use) VALUES('attribute2', 'Nursery evaluation');
INSERT INTO variable_base_entity_synonyms (variable_base_entity_id, synonyms) VALUES('attribute2', 'Maize Height');
INSERT INTO variable_base_entity_synonyms (variable_base_entity_id, synonyms) VALUES('attribute2', 'Stalk Height');
INSERT INTO variable_base_entity_synonyms (variable_base_entity_id, synonyms) VALUES('attribute2', 'Corn Height');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('attribute_er_2', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO variable_base_entity_external_references(variable_base_entity_id, external_references_id) VALUES ('attribute2', 'attribute_er_2');

