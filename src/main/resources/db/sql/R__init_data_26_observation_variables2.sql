-- rollback
update observation_variable ov set crop_id = '1', "name" = 'Plant Height', pui = 'http://dx.doi.org/10.1234/brapi000' where id = 'variable1';
update observation_variable ov set crop_id = '2', "name" = 'Plant Height', pui = 'http://dx.doi.org/10.1234/brapi000', method_id = null, scale_id = null, ontology_id = null where id = 'variable2';

update ontology o set copyright = null, documentationurl = null;
update ontology o set ontology_name = 'Ontology.com', description = 'Ontology.com' where id = 'ontology_variable1';

delete from scale_valid_value_category where scale_id in ('scale_variable4');
delete from variable_base_entity_additional_info where variable_base_entity_id in ('variable3', 'variable4');
delete from additional_info where id  in ('variable_ai_3', 'variable_ai_4');
delete from study_variable where variable_db_id  in ('variable3', 'variable4');
delete from variable_base_entity_synonyms where variable_base_entity_id in ('variable3', 'variable4');
delete from variable_base_entity_context_of_use where variable_base_entity_id in ('variable3', 'variable4');
delete from observation_variable where id in ('variable3', 'variable4');
delete from trait where id in ('trait_variable3', 'trait_variable4');
delete from scale where id in ('scale_variable2', 'scale_variable3', 'scale_variable4');
delete from method where id in ('method_variable2', 'method_variable3', 'method_variable4');
delete from variable_base_entity_synonyms  where variable_base_entity_id = 'variable2';
delete from ontology where id = 'ontology_variable2';

-- changes
update ontology o set copyright = '2017 brapi.org', documentationurl = 'https://brapi.org';
update ontology o set ontology_name = 'Custom Maize Ontology', description = 'Custom Maize Ontology 2025' where id = 'ontology_variable1';
INSERT INTO ontology(auth_user_id, id, authors, copyright, description, licence, ontology_name, version, documentationurl) 
  VALUES ('anonymousUser', 'ontology_variable2', 'Bob', '2017 brapi.org', 'Custom Pawpaw Ontology 2025', 'Apache', 'Custom Pawpaw Ontology', '17', 'https://brapi.org');

update observation_variable ov set crop_id = '3', "name" = 'Corn Stalk Height', pui = 'http://dx.doi.org/10.1234/brapi_v001' where id = 'variable1';
update observation_variable ov set crop_id = '2', "name" = 'Pawpaw Height', pui = 'http://dx.doi.org/10.1234/brapi_v002', method_id = 'method_variable1', scale_id = 'scale_variable1', ontology_id = 'ontology_variable2' where id = 'variable2';

INSERT INTO variable_base_entity_synonyms (variable_base_entity_id, synonyms) VALUES('variable2', 'Pawpaw Canopy');
INSERT INTO variable_base_entity_synonyms (variable_base_entity_id, synonyms) VALUES('variable2', 'Tree Height');
INSERT INTO variable_base_entity_synonyms (variable_base_entity_id, synonyms) VALUES('variable2', 'Pawpaw Fruit Height');

-- new Yeild variable
INSERT INTO trait (auth_user_id, id, attribute, attributepui, entity, entitypui, main_abbreviation, trait_description, trait_name, status, trait_class, ontology_id, traitpui) 
  VALUES ('anonymousUser', 'trait_variable3', 'yield', 'http://dx.doi.org/10.1234/brapi_ta003', 'fruit', 'http://dx.doi.org/10.1234/brapi_te003', 'Y', 'fruit yield', 'Fruit Yield', 'active', 'Numeric', 'ontology_variable1', 'http://dx.doi.org/10.1234/brapi_t003');
INSERT INTO scale (auth_user_id, id, data_type, decimal_places, units, scale_name, valid_value_min, valid_value_max, ontology_id, scalepui) 
  VALUES ('anonymousUser', 'scale_variable3', 4, 1, 'kg/hectare', 'Kilos per Hectare', '0', '99999', 'ontology_variable1', 'http://dx.doi.org/10.1234/brapi_s003');
INSERT INTO method(auth_user_id, id, description, formula, method_class, name, reference, ontology_id, methodpui) 
  VALUES ('anonymousUser', 'method_variable3', 'Weight on a digital scale', 'kg per plot * number of plots per hectare', 'Numeric', 'Digital Scale', 'brapi.org', 'ontology_variable1', 'http://dx.doi.org/10.1234/brapi_m003');


INSERT INTO observation_variable (auth_user_id, id, pui, default_value, documentationurl, growth_stage, institution, "language", scientist, status, submission_timestamp, crop_id, method_id, ontology_id, scale_id, trait_id, "name") 
  VALUES ('anonymousUser', 'variable3', 'http://dx.doi.org/10.1234/brapi_v003', null, 'https://brapi.org', '1', 'Cornell', 'English', 'Bob', 'active', '2025-06-24T22:22:52Z', '2', 'method_variable3', 'ontology_variable2', 'scale_variable3', 'trait_variable3', 'Pawpaw Fruit Yield');
INSERT INTO variable_base_entity_context_of_use (variable_base_entity_id, context_of_use) VALUES('variable3', 'Trial evaluation');
INSERT INTO variable_base_entity_context_of_use (variable_base_entity_id, context_of_use) VALUES('variable3', 'Nursery evaluation');
INSERT INTO variable_base_entity_synonyms (variable_base_entity_id, synonyms) VALUES('variable3', 'Yield');
INSERT INTO variable_base_entity_synonyms (variable_base_entity_id, synonyms) VALUES('variable3', 'Pawpaw yield');
INSERT INTO variable_base_entity_synonyms (variable_base_entity_id, synonyms) VALUES('variable3', 'wet yield');
INSERT INTO study_variable (study_db_id, variable_db_id) VALUES('study2', 'variable3');
INSERT INTO additional_info(id, key, value) VALUES ('variable_ai_3', 'dummyData', decode('aced0005737200116A6176612E6C616E672E426F6F6C65616ECD207280d59cfaee0200015a000576616C7565787001','hex'));
INSERT INTO variable_base_entity_additional_info(variable_base_entity_id, additional_info_id) VALUES ('variable3', 'variable_ai_3');


-- new fruit color
INSERT INTO trait (auth_user_id, id, attribute, attributepui, entity, entitypui, main_abbreviation, trait_description, trait_name, status, trait_class, ontology_id, traitpui) 
  VALUES ('anonymousUser', 'trait_variable4', 'color', 'http://dx.doi.org/10.1234/brapi_ta004', 'fruit', 'http://dx.doi.org/10.1234/brapi_te004', 'C', 'Fruit Color', 'Fruit Color', 'active', 'Categorical', 'ontology_variable2', 'http://dx.doi.org/10.1234/brapi_t004');
INSERT INTO scale (auth_user_id, id, data_type, decimal_places, units, scale_name, valid_value_min, valid_value_max, ontology_id, scalepui) 
  VALUES ('anonymousUser', 'scale_variable4', 0, null, 'color code', 'Color Code', null, null, 'ontology_variable2', 'http://dx.doi.org/10.1234/brapi_s004');
INSERT INTO scale_valid_value_category (id, "label", value, scale_id)  VALUES('valid_value1', 'Green 001', 'G001', 'scale_variable4');
INSERT INTO scale_valid_value_category (id, "label", value, scale_id)  VALUES('valid_value2', 'Green 002', 'G002', 'scale_variable4');
INSERT INTO scale_valid_value_category (id, "label", value, scale_id)  VALUES('valid_value3', 'Green 003', 'G003', 'scale_variable4');
INSERT INTO method(auth_user_id, id, description, formula, method_class, name, reference, ontology_id, methodpui) 
  VALUES ('anonymousUser', 'method_variable4', 'Match to a color code template', null, 'Categorical', 'Color Code', 'brapi.org', 'ontology_variable2', 'http://dx.doi.org/10.1234/brapi_m004');


INSERT INTO observation_variable (auth_user_id, id, pui, default_value, documentationurl, growth_stage, institution, "language", scientist, status, submission_timestamp, crop_id, method_id, ontology_id, scale_id, trait_id, "name") 
  VALUES ('anonymousUser', 'variable4', 'http://dx.doi.org/10.1234/brapi_v004', null, 'https://brapi.org', '1', 'Cornell', 'English', 'Bob', 'active', '2025-06-24T22:22:52Z', '2', 'method_variable4', 'ontology_variable2', 'scale_variable4', 'trait_variable4', 'Pawpaw Fruit Color');
INSERT INTO variable_base_entity_context_of_use (variable_base_entity_id, context_of_use) VALUES('variable4', 'Trial evaluation');
INSERT INTO variable_base_entity_synonyms (variable_base_entity_id, synonyms) VALUES('variable4', 'Color');
INSERT INTO variable_base_entity_synonyms (variable_base_entity_id, synonyms) VALUES('variable4', 'Pawpaw Color');
INSERT INTO variable_base_entity_synonyms (variable_base_entity_id, synonyms) VALUES('variable4', 'Greenness');
INSERT INTO study_variable (study_db_id, variable_db_id) VALUES('study2', 'variable4');
INSERT INTO additional_info(id, key, value) VALUES ('variable_ai_4', 'dummyData', decode('aced0005737200116A6176612E6C616E672E426F6F6C65616ECD207280d59cfaee0200015a000576616C7565787001','hex'));
INSERT INTO variable_base_entity_additional_info(variable_base_entity_id, additional_info_id) VALUES ('variable4', 'variable_ai_4');