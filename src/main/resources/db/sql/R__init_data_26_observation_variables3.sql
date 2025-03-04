-- Roll Back Changes
delete from ontology_additional_info where ontology_entity_id in ('O_001', 'O_002', 'O_003');
delete from additional_info where id in ('ontology_ai_1', 'ontology_ai_2', 'ontology_ai_3');

INSERT INTO ontology (id, auth_user_id, authors, copyright, description, documentationurl, licence, ontology_name, "version") select 'ontology_attribute1', auth_user_id, authors, copyright, description, documentationurl, licence, ontology_name, "version" from ontology WHERE id='O_001';
UPDATE "method" SET ontology_id='ontology_attribute1' WHERE ontology_id='O_001';
UPDATE "scale" SET ontology_id='ontology_attribute1' WHERE ontology_id='O_001';
UPDATE "trait" SET ontology_id='ontology_attribute1' WHERE ontology_id='O_001';
UPDATE "germplasm_attribute_definition" SET ontology_id='ontology_attribute1' WHERE ontology_id='O_001';
UPDATE "observation_variable" SET ontology_id='ontology_attribute1' WHERE ontology_id='O_001';
delete from ontology where id = 'O_001';

INSERT INTO ontology (id, auth_user_id, authors, copyright, description, documentationurl, licence, ontology_name, "version") select 'ontology_variable1', auth_user_id, authors, copyright, description, documentationurl, licence, ontology_name, "version" from ontology WHERE id='O_002';
UPDATE "method" SET ontology_id='ontology_variable1' WHERE ontology_id='O_002';
UPDATE "scale" SET ontology_id='ontology_variable1' WHERE ontology_id='O_002';
UPDATE "trait" SET ontology_id='ontology_variable1' WHERE ontology_id='O_002';
UPDATE "germplasm_attribute_definition" SET ontology_id='ontology_variable1' WHERE ontology_id='O_002';
UPDATE "observation_variable" SET ontology_id='ontology_variable1' WHERE ontology_id='O_002';
delete from ontology where id = 'O_002';

INSERT INTO ontology (id, auth_user_id, authors, copyright, description, documentationurl, licence, ontology_name, "version") select 'ontology_variable2', auth_user_id, authors, copyright, description, documentationurl, licence, ontology_name, "version" from ontology WHERE id='O_003';
UPDATE "method" SET ontology_id='ontology_variable2' WHERE ontology_id='O_003';
UPDATE "scale" SET ontology_id='ontology_variable2' WHERE ontology_id='O_003';
UPDATE "trait" SET ontology_id='ontology_variable2' WHERE ontology_id='O_003';
UPDATE "germplasm_attribute_definition" SET ontology_id='ontology_variable2' WHERE ontology_id='O_003';
UPDATE "observation_variable" SET ontology_id='ontology_variable2' WHERE ontology_id='O_003';
delete from ontology where id = 'O_003';

update "trait" set trait_class = 'Numeric' where id in ('trait_attribute1', 'trait_attribute2', 'trait_variable1', 'trait_variable2', 'trait_variable3');
update "trait" set trait_class = 'Categorical' where id in ('trait_variable4');


-- Apply Changes
-- shorten ontology DbIds
INSERT INTO ontology (id, auth_user_id, authors, copyright, description, documentationurl, licence, ontology_name, "version") select 'O_001', auth_user_id, authors, copyright, description, documentationurl, licence, ontology_name, "version" from ontology WHERE id='ontology_attribute1';
UPDATE "method" SET ontology_id='O_001' WHERE ontology_id='ontology_attribute1';
UPDATE "scale" SET ontology_id='O_001' WHERE ontology_id='ontology_attribute1';
UPDATE "trait" SET ontology_id='O_001' WHERE ontology_id='ontology_attribute1';
UPDATE "germplasm_attribute_definition" SET ontology_id='O_001' WHERE ontology_id='ontology_attribute1';
UPDATE "observation_variable" SET ontology_id='O_001' WHERE ontology_id='ontology_attribute1';
delete from ontology where id = 'ontology_attribute1';

INSERT INTO ontology (id, auth_user_id, authors, copyright, description, documentationurl, licence, ontology_name, "version") select 'O_002', auth_user_id, authors, copyright, description, documentationurl, licence, ontology_name, "version" from ontology WHERE id='ontology_variable1';
UPDATE "method" SET ontology_id='O_002' WHERE ontology_id='ontology_variable1';
UPDATE "scale" SET ontology_id='O_002' WHERE ontology_id='ontology_variable1';
UPDATE "trait" SET ontology_id='O_002' WHERE ontology_id='ontology_variable1';
UPDATE "germplasm_attribute_definition" SET ontology_id='O_002' WHERE ontology_id='ontology_variable1';
UPDATE "observation_variable" SET ontology_id='O_002' WHERE ontology_id='ontology_variable1';
delete from ontology where id = 'ontology_variable1';

INSERT INTO ontology (id, auth_user_id, authors, copyright, description, documentationurl, licence, ontology_name, "version") select 'O_003', auth_user_id, authors, copyright, description, documentationurl, licence, ontology_name, "version" from ontology WHERE id='ontology_variable2';
UPDATE "method" SET ontology_id='O_003' WHERE ontology_id='ontology_variable2';
UPDATE "scale" SET ontology_id='O_003' WHERE ontology_id='ontology_variable2';
UPDATE "trait" SET ontology_id='O_003' WHERE ontology_id='ontology_variable2';
UPDATE "germplasm_attribute_definition" SET ontology_id='O_003' WHERE ontology_id='ontology_variable2';
UPDATE "observation_variable" SET ontology_id='O_003' WHERE ontology_id='ontology_variable2';
delete from ontology where id = 'ontology_variable2';

-- Add ontology additional info
INSERT INTO additional_info (id, "key", value) VALUES('ontology_ai_1', 'term_names', decode('ACED0005737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A6578700000000277040000000274000C5068656E6F6C6F676963616C7400075175616C69747978','hex'));
INSERT INTO ontology_additional_info (ontology_entity_id, additional_info_id) VALUES('O_001', 'ontology_ai_1');

INSERT INTO additional_info (id, "key", value) VALUES('ontology_ai_2', 'term_names', decode('ACED0005737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A6578700000000277040000000274000C5068656E6F6C6F676963616C7400075175616C69747978','hex'));
INSERT INTO ontology_additional_info (ontology_entity_id, additional_info_id) VALUES('O_002', 'ontology_ai_2');

INSERT INTO additional_info (id, "key", value) VALUES('ontology_ai_3', 'term_names', decode('ACED0005737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A6578700000000277040000000274000C5068656E6F6C6F676963616C7400075175616C69747978','hex'));
INSERT INTO ontology_additional_info (ontology_entity_id, additional_info_id) VALUES('O_003', 'ontology_ai_3');

-- update Trait Classes
update "trait" set trait_class = 'Phenological' where id in ('trait_attribute1', 'trait_attribute2', 'trait_variable1', 'trait_variable2', 'trait_variable3');
update "trait" set trait_class = 'Quality' where id in ('trait_variable4');