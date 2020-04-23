
INSERT INTO genome_map (id, comments, documentationurl, map_name, mappui, published_date, scientific_name, "type", unit, crop_id) VALUES('genome_map1', 'This is a comment', 'https://brapi.org/specifications', 'Primary Paw Paw Map', 'doi://10.12345/fake/6789', '1998-11-29', 'Asimina triloba', 'Physical Map', 'cM', '2');
INSERT INTO additional_info(id, key, value) VALUES ('genome_map_ai_1', 'dummyData', 'True');
INSERT INTO genome_map_additional_info(genome_map_entity_id, additional_info_id) VALUES ('genome_map1', 'genome_map_ai_1');

INSERT INTO linkage_group (id, linkage_group_name, max_marker_position, genome_map_id) VALUES('linkage_group1', 'Chromosome 1', 50000000, 'genome_map1');
INSERT INTO additional_info(id, key, value) VALUES ('linkage_group_ai_1', 'dummyData', 'True');
INSERT INTO linkage_group_additional_info(linkage_group_entity_id, additional_info_id) VALUES ('linkage_group1', 'linkage_group_ai_1');
