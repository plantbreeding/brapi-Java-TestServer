
-- image 1
INSERT INTO geojson(id, type) VALUES ('image_geo_1', 'Point');
INSERT INTO coordinate(id, altitude, latitude, longitude, geojson_id) VALUES ('image_coor_1', 123, 42.44423, -76.46313, 'image_geo_1');
INSERT INTO image (auth_user_id, id, copyright, description, image_file_name, image_file_size, image_height, imagemimetype, imageurl, image_width, "name", time_stamp, coordinates_id, observation_unit_id) VALUES('anonymousUser', 'image1', 'Copyright 2018 Bob Robertson', 'This is an example image', 'tomato.jpg', 50000, 500, 'image/jpg', 'https://wiki.brapi.org/images/tomato.jpg', 500, 'Example Image', '2019-11-02', 'image_geo_1', 'observation_unit1');
INSERT INTO image_entity_descriptive_ontology_terms (image_entity_id, descriptive_ontology_terms) VALUES('image1', 'Fruit');
INSERT INTO image_entity_descriptive_ontology_terms (image_entity_id, descriptive_ontology_terms) VALUES('image1', 'TO:123456');

INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('image_er_1', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO image_external_references(image_entity_id, external_references_id) VALUES ('image1', 'image_er_1');

-- image 2
INSERT INTO geojson(id, type) VALUES ('image_geo_2', 'Point');
INSERT INTO coordinate(id, altitude, latitude, longitude, geojson_id) VALUES ('image_coor_2', 123, 42.44423, -76.46323, 'image_geo_2');
INSERT INTO image (auth_user_id, id, copyright, description, image_file_name, image_file_size, image_height, imagemimetype, imageurl, image_width, "name", time_stamp, coordinates_id, observation_unit_id) VALUES('anonymousUser', 'image2', 'Copyright 2018 Bob Robertson', 'This is an example image', 'tomato.jpg', 50000, 500, 'image/jpg', 'https://wiki.brapi.org/images/tomato.jpg', 500, 'Example Image', '2019-12-02', 'image_geo_2', 'observation_unit2');
INSERT INTO image_entity_descriptive_ontology_terms (image_entity_id, descriptive_ontology_terms) VALUES('image2', 'Fruit');
INSERT INTO image_entity_descriptive_ontology_terms (image_entity_id, descriptive_ontology_terms) VALUES('image2', 'TO:223456');

INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('image_er_2', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO image_external_references(image_entity_id, external_references_id) VALUES ('image2', 'image_er_2');
