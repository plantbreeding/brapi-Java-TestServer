-- map 1
INSERT INTO genome_map (auth_user_id, id, comments, documentationurl, map_name, mappui, published_date, scientific_name, "type", unit, crop_id) VALUES('anonymousUser', 'genome_map1', 'This is a comment', 'https://brapi.org/specifications', 'Primary Paw Paw Map', 'doi://10.12345/fake/6789', '1998-11-29', 'Asimina triloba', 'Physical Map', 'cM', '2');
INSERT INTO additional_info(id, key, value) VALUES ('genome_map_ai_1', 'dummyData', decode('aced0005737200116A6176612E6C616E672E426F6F6C65616ECD207280d59cfaee0200015a000576616C7565787001','hex'));
INSERT INTO genome_map_additional_info(genome_map_entity_id, additional_info_id) VALUES ('genome_map1', 'genome_map_ai_1');

INSERT INTO linkage_group (auth_user_id, id, linkage_group_name, max_marker_position, genome_map_id) VALUES('anonymousUser', 'linkage_group1', 'Chromosome 1', 50000000, 'genome_map1');
INSERT INTO additional_info(id, key, value) VALUES ('linkage_group_ai_1', 'dummyData', decode('aced0005737200116A6176612E6C616E672E426F6F6C65616ECD207280d59cfaee0200015a000576616C7565787001','hex'));
INSERT INTO linkage_group_additional_info(linkage_group_entity_id, additional_info_id) VALUES ('linkage_group1', 'linkage_group_ai_1');

INSERT INTO marker_position (auth_user_id, id, "position", linkage_group_id, variant_id) VALUES('anonymousUser', 'marker_position1', 200, 'linkage_group1', 'variant01');
INSERT INTO additional_info(id, key, value) VALUES ('marker_position_ai_1', 'dummyData', decode('aced0005737200116A6176612E6C616E672E426F6F6C65616ECD207280d59cfaee0200015a000576616C7565787001','hex'));
INSERT INTO marker_position_additional_info(marker_position_entity_id, additional_info_id) VALUES ('marker_position1', 'marker_position_ai_1');

INSERT INTO marker_position (auth_user_id, id, "position", linkage_group_id, variant_id) VALUES('anonymousUser', 'marker_position2', 4000, 'linkage_group1', 'variant02');
INSERT INTO additional_info(id, key, value) VALUES ('marker_position_ai_2', 'dummyData', decode('aced0005737200116A6176612E6C616E672E426F6F6C65616ECD207280d59cfaee0200015a000576616C7565787001','hex'));
INSERT INTO marker_position_additional_info(marker_position_entity_id, additional_info_id) VALUES ('marker_position2', 'marker_position_ai_2');

INSERT INTO marker_position (auth_user_id, id, "position", linkage_group_id, variant_id) VALUES('anonymousUser', 'marker_position3', 60000, 'linkage_group1', 'variant03');
INSERT INTO additional_info(id, key, value) VALUES ('marker_position_ai_3', 'dummyData', decode('aced0005737200116A6176612E6C616E672E426F6F6C65616ECD207280d59cfaee0200015a000576616C7565787001','hex'));
INSERT INTO marker_position_additional_info(marker_position_entity_id, additional_info_id) VALUES ('marker_position3', 'marker_position_ai_3');

-- map 2
INSERT INTO genome_map (auth_user_id, id, comments, documentationurl, map_name, mappui, published_date, scientific_name, "type", unit, crop_id) VALUES('anonymousUser', 'genome_map2', 'This is a comment', 'https://brapi.org/specifications', 'Primary Paw Paw Map', 'doi://10.22345/fake/6789', '1998-12-29', 'Asimina triloba', 'Physical Map', 'cM', '2');
INSERT INTO additional_info(id, key, value) VALUES ('genome_map_ai_2', 'dummyData', decode('aced0005737200116A6176612E6C616E672E426F6F6C65616ECD207280d59cfaee0200015a000576616C7565787001','hex'));
INSERT INTO genome_map_additional_info(genome_map_entity_id, additional_info_id) VALUES ('genome_map2', 'genome_map_ai_2');

INSERT INTO linkage_group (auth_user_id, id, linkage_group_name, max_marker_position, genome_map_id) VALUES('anonymousUser', 'linkage_group2', 'Chromosome 2', 50000000, 'genome_map2');
INSERT INTO additional_info(id, key, value) VALUES ('linkage_group_ai_2', 'dummyData', decode('aced0005737200116A6176612E6C616E672E426F6F6C65616ECD207280d59cfaee0200015a000576616C7565787001','hex'));
INSERT INTO linkage_group_additional_info(linkage_group_entity_id, additional_info_id) VALUES ('linkage_group2', 'linkage_group_ai_2');

INSERT INTO marker_position (auth_user_id, id, "position", linkage_group_id, variant_id) VALUES('anonymousUser', 'marker_position4', 200, 'linkage_group2', 'variant04');
INSERT INTO additional_info(id, key, value) VALUES ('marker_position_ai_4', 'dummyData', decode('aced0005737200116A6176612E6C616E672E426F6F6C65616ECD207280d59cfaee0200015a000576616C7565787001','hex'));
INSERT INTO marker_position_additional_info(marker_position_entity_id, additional_info_id) VALUES ('marker_position4', 'marker_position_ai_4');

INSERT INTO marker_position (auth_user_id, id, "position", linkage_group_id, variant_id) VALUES('anonymousUser', 'marker_position5', 4000, 'linkage_group2', 'variant05');
INSERT INTO additional_info(id, key, value) VALUES ('marker_position_ai_5', 'dummyData', decode('aced0005737200116A6176612E6C616E672E426F6F6C65616ECD207280d59cfaee0200015a000576616C7565787001','hex'));
INSERT INTO marker_position_additional_info(marker_position_entity_id, additional_info_id) VALUES ('marker_position5', 'marker_position_ai_5');

INSERT INTO marker_position (auth_user_id, id, "position", linkage_group_id, variant_id) VALUES('anonymousUser', 'marker_position6', 60000, 'linkage_group2', 'variant06');
INSERT INTO additional_info(id, key, value) VALUES ('marker_position_ai_6', 'dummyData', decode('aced0005737200116A6176612E6C616E672E426F6F6C65616ECD207280d59cfaee0200015a000576616C7565787001','hex'));
INSERT INTO marker_position_additional_info(marker_position_entity_id, additional_info_id) VALUES ('marker_position6', 'marker_position_ai_6');