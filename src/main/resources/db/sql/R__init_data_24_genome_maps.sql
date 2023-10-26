-- map 1
INSERT INTO genome_map (auth_user_id, id, comments, documentationurl, map_name, mappui, published_date, scientific_name, "type", unit, crop_id) VALUES('anonymousUser', 'genome_map1', 'This is a comment', 'https://brapi.org/specifications', 'Primary Paw Paw Map', 'doi://10.12345/fake/6789', '1998-11-29', 'Asimina triloba', 'Physical Map', 'cM', '2');

INSERT INTO linkage_group (auth_user_id, id, linkage_group_name, max_marker_position, genome_map_id) VALUES('anonymousUser', 'linkage_group1', 'Chromosome 1', 50000000, 'genome_map1');

INSERT INTO marker_position (auth_user_id, id, "position", linkage_group_id, variant_id) VALUES('anonymousUser', 'marker_position1', 200, 'linkage_group1', 'variant01');

INSERT INTO marker_position (auth_user_id, id, "position", linkage_group_id, variant_id) VALUES('anonymousUser', 'marker_position2', 4000, 'linkage_group1', 'variant02');

INSERT INTO marker_position (auth_user_id, id, "position", linkage_group_id, variant_id) VALUES('anonymousUser', 'marker_position3', 60000, 'linkage_group1', 'variant03');

-- map 2
INSERT INTO genome_map (auth_user_id, id, comments, documentationurl, map_name, mappui, published_date, scientific_name, "type", unit, crop_id) VALUES('anonymousUser', 'genome_map2', 'This is a comment', 'https://brapi.org/specifications', 'Primary Paw Paw Map', 'doi://10.22345/fake/6789', '1998-12-29', 'Asimina triloba', 'Physical Map', 'cM', '2');

INSERT INTO linkage_group (auth_user_id, id, linkage_group_name, max_marker_position, genome_map_id) VALUES('anonymousUser', 'linkage_group2', 'Chromosome 2', 50000000, 'genome_map2');

INSERT INTO marker_position (auth_user_id, id, "position", linkage_group_id, variant_id) VALUES('anonymousUser', 'marker_position4', 200, 'linkage_group2', 'variant04');

INSERT INTO marker_position (auth_user_id, id, "position", linkage_group_id, variant_id) VALUES('anonymousUser', 'marker_position5', 4000, 'linkage_group2', 'variant05');

INSERT INTO marker_position (auth_user_id, id, "position", linkage_group_id, variant_id) VALUES('anonymousUser', 'marker_position6', 60000, 'linkage_group2', 'variant06');