-- attribute value 1
INSERT INTO germplasm_attribute_value (id, determined_date, value, germplasm_id, attribute_id) VALUES('attribute_val1', '2020-04-07', '200', 'germplasm2', 'attribute1');

INSERT INTO additional_info(id, key, value) VALUES ('attribute_val_ai_1', 'dummyData', 'True');
INSERT INTO germplasm_attribute_value_additional_info(germplasm_attribute_value_entity_id, additional_info_id) VALUES ('attribute_val1', 'attribute_val_ai_1');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('attribute_val_er_1', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO germplasm_attribute_value_external_references(germplasm_attribute_value_entity_id, external_references_id) VALUES ('attribute_val1', 'attribute_val_er_1');

-- attribute value 2
INSERT INTO germplasm_attribute_value (id, determined_date, value, germplasm_id, attribute_id) VALUES('attribute_val2', '2020-04-07', '200', 'germplasm3', 'attribute1');

INSERT INTO additional_info(id, key, value) VALUES ('attribute_val_ai_2', 'dummyData', 'True');
INSERT INTO germplasm_attribute_value_additional_info(germplasm_attribute_value_entity_id, additional_info_id) VALUES ('attribute_val2', 'attribute_val_ai_2');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('attribute_val_er_2', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO germplasm_attribute_value_external_references(germplasm_attribute_value_entity_id, external_references_id) VALUES ('attribute_val2', 'attribute_val_er_2');

-- attribute value 3
INSERT INTO germplasm_attribute_value (id, determined_date, value, germplasm_id, attribute_id) VALUES('attribute_val3', '2020-04-07', '200', 'germplasm3', 'attribute2');

INSERT INTO additional_info(id, key, value) VALUES ('attribute_val_ai_3', 'dummyData', 'True');
INSERT INTO germplasm_attribute_value_additional_info(germplasm_attribute_value_entity_id, additional_info_id) VALUES ('attribute_val3', 'attribute_val_ai_3');
INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('attribute_val_er_3', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO germplasm_attribute_value_external_references(germplasm_attribute_value_entity_id, external_references_id) VALUES ('attribute_val3', 'attribute_val_er_3');
