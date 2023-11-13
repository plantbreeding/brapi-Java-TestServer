INSERT INTO event (auth_user_id, id, event_description, event_type, event_type_db_id, study_id) VALUES('anonymousUser', 'event1', 'Normal field watering', 'Watering', '4e7d691e', 'study1');
INSERT INTO event_entity_dates (event_entity_id, dates) VALUES('event1', '2017-06-01');
INSERT INTO event_entity_dates (event_entity_id, dates) VALUES('event1', '2017-06-03');
INSERT INTO event_entity_dates (event_entity_id, dates) VALUES('event1', '2017-06-05');
INSERT INTO event_entity_dates (event_entity_id, dates) VALUES('event1', '2017-06-07');
INSERT INTO event_entity_dates (event_entity_id, dates) VALUES('event1', '2017-06-09');
INSERT INTO event_param (id, "key", rdf_value, value, event_id) VALUES('event_param1', 'http://www.example.fr/vocabulary/2018#hasContact', 'http://xmlns.com/foaf/0.1/Agent', 'http://www.example.fr/id/agent/marie', 'event1');
INSERT INTO event_param (id, "key", rdf_value, value, event_id) VALUES('event_param2', 'fertilizer', 'http://xmlns.com/foaf/0.1/Agent', 'Nitro+', 'event1');

INSERT INTO external_reference(id, external_reference_id, external_reference_source) VALUES ('event_er_1', 'https://brapi.org/specification', 'BrAPI Doc');
INSERT INTO event_external_references(event_entity_id, external_references_id) VALUES ('event1', 'event_er_1');
