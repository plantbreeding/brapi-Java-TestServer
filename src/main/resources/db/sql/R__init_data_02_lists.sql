INSERT INTO person(auth_user_id, id, description, email_address, first_name, last_name, mailing_address, middle_name, phone_number, userid) VALUES ('anonymousUser', 'list_person_1', 'List Owner Person', 'bob@bob.com', 'Bob', 'Robertson', '123 Road Street, City, State, Country, 98765', 'Danger', '+19876543210', 'bdr45');

INSERT INTO list(auth_user_id, id, date_created, date_modified, description, list_name, list_owner_name, list_owner_person_id, list_source, list_type)	VALUES ('anonymousUser', 'list1', '2011-06-14T22:12:51Z', '2011-06-14T22:12:51Z', 'Example List of germplasm', 'Example List 1', 'Bob Robertson', 'list_person_1', 'User Created', 0);
INSERT INTO list_item(id, item, list_id) VALUES ('item01', 'germ1', 'list1');
INSERT INTO list_item(id, item, list_id) VALUES ('item02', 'germ2', 'list1');
INSERT INTO list_item(id, item, list_id) VALUES ('item03', 'germ3', 'list1');

INSERT INTO list(auth_user_id, id, date_created, date_modified, description, list_name, list_owner_name, list_owner_person_id, list_source, list_type)	VALUES ('anonymousUser', 'list2', '2011-06-14T22:12:51Z', '2011-06-14T22:12:51Z', 'Example List of germplasm', 'Example List 2', 'Rob Robertson', 'list_person_1', 'User Created', 0);
INSERT INTO list_item(id, item, list_id) VALUES ('item04', 'germ1', 'list2');
INSERT INTO list_item(id, item, list_id) VALUES ('item05', 'germ2', 'list2');
INSERT INTO list_item(id, item, list_id) VALUES ('item06', 'germ3', 'list2');


INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('list_er_1', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO list_external_references(list_entity_id, external_references_id) VALUES ('list1', 'list_er_1');
INSERT INTO list_external_references(list_entity_id, external_references_id) VALUES ('list2', 'list_er_1');