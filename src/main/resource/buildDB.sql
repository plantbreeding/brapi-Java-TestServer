-- DROP TABLES

-- Phenotyping related
DROP TABLE IF EXISTS observation;
DROP TABLE IF EXISTS observation_variable;
DROP TABLE IF EXISTS method;
DROP TABLE IF EXISTS scale;
DROP TABLE IF EXISTS trait;
DROP TABLE IF EXISTS ontology;
DROP TABLE IF EXISTS treatment;
DROP TABLE IF EXISTS observation_unit_xref;
DROP TABLE IF EXISTS observation_unit;
DROP TABLE IF EXISTS sample;

-- Study related
DROP TABLE IF EXISTS study_additional_info;
DROP TABLE IF EXISTS study_season;
DROP TABLE IF EXISTS study_data_link;
DROP TABLE IF EXISTS study_contact;
DROP TABLE IF EXISTS study;
DROP TABLE IF EXISTS study_type;
DROP TABLE IF EXISTS location_additional_info;
DROP TABLE IF EXISTS location;
DROP TABLE IF EXISTS trial_additional_info;
DROP TABLE IF EXISTS trial_contact;
DROP TABLE IF EXISTS trial;
DROP TABLE IF EXISTS contact;
DROP TABLE IF EXISTS program;
DROP TABLE IF EXISTS season;

-- Genotyping related
DROP TABLE IF EXISTS map;
DROP TABLE IF EXISTS marker;
DROP TABLE IF EXISTS markerprofile;

-- Germplasm related
DROP TABLE IF EXISTS taxon_xref_germplasm;
DROP TABLE IF EXISTS taxon_xref;
DROP TABLE IF EXISTS pedigree;
DROP TABLE IF EXISTS donor;
DROP TABLE IF EXISTS germplasm_attribute_value;
DROP TABLE IF EXISTS germplasm_attribute;
DROP TABLE IF EXISTS germplasm_attribute_category;
DROP TABLE IF EXISTS germplasm;
DROP TABLE IF EXISTS crop;

drop table if exists call_data_type;
drop table if exists call_method;
drop table if exists call;

-- CREATE TABLES
CREATE TABLE call (
  id text NOT NULL PRIMARY key,
  call text
);

CREATE TABLE call_data_type (
  id text NOT NULL PRIMARY key,
  call_dbid text references call(id),
  data_type text
);

CREATE TABLE call_method (
  id text NOT NULL PRIMARY key,
  call_dbid text references call(id),
  method text
);

CREATE TABLE crop (
  cropDbId text NOT NULL PRIMARY KEY,
  commonName text NOT NULL
);

CREATE TABLE germplasm (
  cropDbId text REFERENCES crop(cropDbId),
  germplasmDbId text NOT NULL PRIMARY KEY,
  germplasmPUI text,
  germplasmName text NOT NULL,
  defaultDisplayName text NOT NULL,
  accessionNumber text,
  pedigree text,
  seedSource text,
  synonyms text, -- text[] ??
  instituteCode text NOT NULL,
  instituteName text,
  biologicalStatusOfAccessionCode text,
  countryOfOriginCode text,
  typeOfGermplasmStorageCode text,
  genus text,
  species text,
  speciesAuthority text,
  subtaxa text,
  subtaxaAuthority text,
  acquisitionDate text -- TODO: use a date format
);

CREATE TABLE germplasm_attribute_category (
  cropDbId text REFERENCES crop(cropDbId),
  attributeCategoryDbId text NOT NULL PRIMARY KEY,
  attributeCategoryName text
);

CREATE TABLE germplasm_attribute (
  cropDbId text REFERENCES crop(cropDbId),
  attributeCategoryDbId text NOT NULL REFERENCES germplasm_attribute_category(attributeCategoryDbId),
  attributeDbId text NOT NULL PRIMARY KEY,
  code text,
  uri text,
  name text NOT NULL,
  description text,
  datatype text,
  values text[] -- All possible values for this germplasm attribute
);

CREATE TABLE germplasm_attribute_value (
  cropDbId text REFERENCES crop(cropDbId),
  germplasmDbId text NOT NULL REFERENCES germplasm(germplasmDbId),
  attributeDbId text NOT NULL REFERENCES germplasm_attribute(attributeDbId),
  determinedDate text, -- TODO: use a date format
  value text NOT NULL -- Actual value for a specific attribute on a specific germplasm
);

CREATE TABLE pedigree (
  cropDbId text REFERENCES crop(cropDbId),
  germplasmDbId text NOT NULL REFERENCES germplasm(germplasmDbId),
  pedigree text NOT NULL,
  parent1Id text NOT NULL REFERENCES germplasm(germplasmDbId),
  parent2Id text NOT NULL REFERENCES germplasm(germplasmDbId)
);

CREATE TABLE taxon_xref (
  cropDbId text REFERENCES crop(cropDbId),
  taxonDbId text NOT NULL PRIMARY KEY,
  source text NOT NULL,
  rank text -- very optionnal
);

-- taxonIds in germplasm search & list
CREATE TABLE taxon_xref_germplasm (
  cropDbId text REFERENCES crop(cropDbId),
  taxonDbId text REFERENCES taxon_xref(taxonDbId),
  germplasmDbId text REFERENCES germplasm(germplasmDbId)
);

CREATE TABLE donor (
  cropDbId text REFERENCES crop(cropDbId),
  germplasmDbId text REFERENCES germplasm(germplasmDbId),
  donorAccessionNumber text,
  donorInstituteCode text,
  donorGermplasmPUI text
);

CREATE TABLE location (
  cropDbId text REFERENCES crop(cropDbId),
  locationDbId text NOT NULL PRIMARY KEY,
  type text,
  name text,
  abbreviation text,
  countryCode text,
  countryName text,
  latitude numeric,
  longitude numeric,
  altitude numeric,
  instituteName text,
  instituteAddress text
);

CREATE TABLE location_additional_info (
  cropDbId text REFERENCES crop(cropDbId),
  locationDbId text REFERENCES location(locationDbId),
  key text NOT NULL,
  value text NOT NULL
);

CREATE TABLE contact (
  cropDbId text REFERENCES crop(cropDbId),
  contactDbId text NOT NULL PRIMARY KEY,
  name text,
  email text,
  type text,
  orcid text,
  instituteName text
);

CREATE TABLE program (
  cropDbId text REFERENCES crop(cropDbId),
  programDbId text NOT NULL PRIMARY KEY,
  name text NOT NULL,
  abbreviation text,
  objective text,
  leadPerson text
);

CREATE TABLE trial (
  cropDbId text REFERENCES crop(cropDbId),
  programDbId text REFERENCES program(programDbId),
  trialDbId text NOT NULL PRIMARY KEY,
  name text NOT NULL,
  startDate text, -- TODO: use a date format
  endDate text, -- TODO: use a date format
  active boolean,
  datasetAuthorshipLicence text,
  datasetAuthorshipDatasetPUI text
);

CREATE TABLE trial_additional_info (
  cropDbId text REFERENCES crop(cropDbId),
  trialDbId text REFERENCES trial(trialDbId),
  key text NOT NULL,
  value text NOT NULL
);

CREATE TABLE trial_contact (
  cropDbId text REFERENCES crop(cropDbId),
  trialDbId text REFERENCES trial(trialDbId),
  contactDbId text REFERENCES contact(contactDbId)
);

CREATE TABLE study_type (
  cropDbId text REFERENCES crop(cropDbId),
  name text NOT NULL PRIMARY KEY,
  description text
);

CREATE TABLE study (
  cropDbId text REFERENCES crop(cropDbId),
  trialDbId text NOT NULL REFERENCES trial(trialDbId),
  locationDbId text REFERENCES location(locationDbId),
  studyType text REFERENCES study_type(name),
  studyDbId text NOT NULL PRIMARY KEY,
  name text NOT NULL,
  description text,
  startDate text, -- TODO: use a date format
  endDate text, -- TODO: use a date format
  active boolean,
  license text,
  lastUpdateVersion text,
  lastUpdateTimestamp text -- TODO: use a date format
);

CREATE TABLE study_contact (
  cropDbId text REFERENCES crop(cropDbId),
  studyDbId text NOT NULL REFERENCES study(studyDbId),
  contactDbId text NOT NULL REFERENCES contact(contactDbId)
);

CREATE TABLE study_data_link (
  cropDbId text REFERENCES crop(cropDbId),
  studyDbId text NOT NULL REFERENCES study(studyDbId),
  name text,
  type text,
  url text NOT NULL
);

CREATE TABLE season (
  cropDbId text REFERENCES crop(cropDbId),
  seasonDbId text NOT NULL PRIMARY KEY,
  year text,
  season text
);

CREATE TABLE study_season (
  cropDbId text REFERENCES crop(cropDbId),
  studyDbId text NOT NULL REFERENCES study(studyDbId),
  seasonDbId text NOT NULL REFERENCES season(seasonDbId)
);

CREATE TABLE study_additional_info (
  cropDbId text REFERENCES crop(cropDbId),
  studyDbId text REFERENCES study(studyDbId),
  key text NOT NULL,
  value text NOT NULL
);

CREATE TABLE observation_unit (
  cropDbId text REFERENCES crop(cropDbId),
  studyDbId text NOT NULL REFERENCES study(studyDbId),
  germplasmDbId text NOT NULL REFERENCES germplasm(germplasmDbId),
  observationUnitDbId text NOT NULL PRIMARY KEY,
  name text NOT NULL,
  observationLevel text,
  observationLevels text,
  entryNumber text,
  entryType text,
  plotNumber text,
  blockNumber text,
  plantNumber text,
  x text,
  y text,
  replicate text
);

CREATE TABLE treatment (
  cropDbId text REFERENCES crop(cropDbId),
  observationUnitDbId text NOT NULL REFERENCES observation_unit(observationUnitDbId),
  factor text NOT NULL,
  modality text NOT NULL
);

CREATE TABLE observation_unit_xref (
  cropDbId text REFERENCES crop(cropDbId),
  observationUnitDbId text NOT NULL REFERENCES observation_unit(observationUnitDbId),
  source text NOT NULL,
  id text NOT NULL
);

-- TODO: add detailed fields
CREATE TABLE ontology (
  cropDbId text REFERENCES crop(cropDbId),
  ontologyDbId text NOT NULL PRIMARY KEY
);

-- TODO: add detailed fields
CREATE TABLE trait (
  cropDbId text REFERENCES crop(cropDbId),
  traitDbId text NOT NULL PRIMARY KEY
);

-- TODO: add detailed fields
CREATE TABLE method (
  cropDbId text REFERENCES crop(cropDbId),
  methodDbId text NOT NULL PRIMARY KEY
);

-- TODO: add detailed fields
CREATE TABLE scale (
  cropDbId text REFERENCES crop(cropDbId),
  scaleDbId text NOT NULL PRIMARY KEY
);

-- TODO: add detailed fields
CREATE TABLE observation_variable (
  cropDbId text REFERENCES crop(cropDbId),
  ontologyDbId text NOT NULL REFERENCES ontology(ontologyDbId),
  observationVariableDbId text NOT NULL PRIMARY KEY,
  observationVariableName text,
  traitDbId text REFERENCES trait(traitDbId),
  methodDbId text REFERENCES method(methodDbId),
  scaleDbId text REFERENCES scale(scaleDbId)
);

-- TODO: add detailed fields
CREATE TABLE observation (
  cropDbId text REFERENCES crop(cropDbId),
  observationUnitDbId text REFERENCES observation_unit(observationUnitDbId),
  observationVariableDbId text REFERENCES observation_variable(observationVariableDbId),
  observationDbId text NOT NULL PRIMARY KEY,
  observationTimeStamp text, -- TODO: use a date format
  seasonDbId text REFERENCES season(seasonDbId),
  collector text,
  value text
);

-- TODO: add detailed fields
CREATE TABLE map (
  cropDbId text REFERENCES crop(cropDbId),
  mapDbId text NOT NULL PRIMARY KEY
);

-- TODO: add detailed fields
CREATE TABLE marker (
  cropDbId text REFERENCES crop(cropDbId),
  markerDbId text NOT NULL,
  defaultDisplayName text,
  type text,
  synonyms text,
  refAlt text,
  analysisMethods text
);

-- TODO: add detailed fields
CREATE TABLE markerprofile (
  cropDbId text REFERENCES crop(cropDbId),
  markerProfileDbId text NOT NULL PRIMARY KEY
);

-- TODO: add detailed fields
CREATE TABLE sample (
  cropDbId text REFERENCES crop(cropDbId),
  sampleDbId text NOT NULL PRIMARY KEY
);


insert into call (id, call) values ('1','/calls');
insert into call (id, call) values ('2','/germplasm-search');
insert into call (id, call) values ('4','/germplasm/{germplasmDbId}');
insert into call (id, call) values ('5','/germplasm/{germplasmDbId}/pedigree');
insert into call (id, call) values ('6','/germplasm/{germplasmDbId}/markerprofiles');
insert into call (id, call) values ('7','/attributes');
insert into call (id, call) values ('8','/attributes/categories');
insert into call (id, call) values ('9','/germplasm/{germplasmDbId}/attributes');
insert into call (id, call) values ('10','/markers');
insert into call (id, call) values ('11','/markers/{markerDbId}');
insert into call (id, call) values ('12','/markerprofiles');
insert into call (id, call) values ('13','/markerprofiles/{markerprofileDbId}');
insert into call (id, call) values ('14','/allelmatrix-search');
insert into call (id, call) values ('16','/programs');
insert into call (id, call) values ('17','/crops');
insert into call (id, call) values ('18','/trials');
insert into call (id, call) values ('19','/trials/{trialsDbId}');
insert into call (id, call) values ('20','/seasons');
insert into call (id, call) values ('21','/studyTypes');
insert into call (id, call) values ('22','/studies-search');
insert into call (id, call) values ('24','/studies/{studiesDbId}');
insert into call (id, call) values ('25','/studies/{studiesDbId}/observationVariables');
insert into call (id, call) values ('26','/studies/{studiesDbId}/germplasm');
insert into call (id, call) values ('27','/observationLevels');
insert into call (id, call) values ('28','/studies/{studiesDbId}/observationunits');
insert into call (id, call) values ('30','/studies/{studiesDbId}/table');
insert into call (id, call) values ('32','/studies/{studiesDbId}/layout');
insert into call (id, call) values ('33','/studies/{studiesDbId}/observarions');
insert into call (id, call) values ('34','/phenotypes-search');
insert into call (id, call) values ('35','/traits');
insert into call (id, call) values ('36','/traits/{traitDbId}');
insert into call (id, call) values ('37','/variables/datatypes');
insert into call (id, call) values ('38','/variables');
insert into call (id, call) values ('39','/variables/{observationVariableDbId}');
insert into call (id, call) values ('40','/variables-search');
insert into call (id, call) values ('41','/ontologies');
insert into call (id, call) values ('42','/maps');
insert into call (id, call) values ('43','/maps/{mapDbId}');
insert into call (id, call) values ('44','/maps/{mapDbId}/positions');
insert into call (id, call) values ('45','/maps/{mapDbId}/positions/{linkageGroupId}');
insert into call (id, call) values ('46','/locations');
insert into call (id, call) values ('47','/locations/{locationsDbId}');
insert into call (id, call) values ('48','/samples');
insert into call (id, call) values ('49','/samples/{samplesDbId}');


insert into call_method (id, call_dbid, method) values ('11','1','GET');
insert into call_method (id, call_dbid, method) values ('12','2','GET');
insert into call_method (id, call_dbid, method) values ('13','2','POST');
insert into call_method (id, call_dbid, method) values ('14','4','GET');
insert into call_method (id, call_dbid, method) values ('15','5','GET');
insert into call_method (id, call_dbid, method) values ('16','6','GET');
insert into call_method (id, call_dbid, method) values ('17','7','GET');
insert into call_method (id, call_dbid, method) values ('18','8','GET');
insert into call_method (id, call_dbid, method) values ('19','9','GET');
insert into call_method (id, call_dbid, method) values ('110','10','GET');
insert into call_method (id, call_dbid, method) values ('111','11','GET');
insert into call_method (id, call_dbid, method) values ('112','12','GET');
insert into call_method (id, call_dbid, method) values ('113','13','GET');
insert into call_method (id, call_dbid, method) values ('114','14','GET');
insert into call_method (id, call_dbid, method) values ('115','14','POST');
insert into call_method (id, call_dbid, method) values ('116','16','GET');
insert into call_method (id, call_dbid, method) values ('117','17','GET');
insert into call_method (id, call_dbid, method) values ('118','18','GET');
insert into call_method (id, call_dbid, method) values ('119','19','GET');
insert into call_method (id, call_dbid, method) values ('120','20','GET');
insert into call_method (id, call_dbid, method) values ('121','21','GET');
insert into call_method (id, call_dbid, method) values ('122','22','GET');
insert into call_method (id, call_dbid, method) values ('123','22','POST');
insert into call_method (id, call_dbid, method) values ('124','24','GET');
insert into call_method (id, call_dbid, method) values ('125','25','GET');
insert into call_method (id, call_dbid, method) values ('126','26','GET');
insert into call_method (id, call_dbid, method) values ('127','27','GET');
insert into call_method (id, call_dbid, method) values ('128','28','GET');
insert into call_method (id, call_dbid, method) values ('129','28','POST');
insert into call_method (id, call_dbid, method) values ('130','30','GET');
insert into call_method (id, call_dbid, method) values ('131','30','POST');
insert into call_method (id, call_dbid, method) values ('132','32','GET');
insert into call_method (id, call_dbid, method) values ('133','33','GET');
insert into call_method (id, call_dbid, method) values ('134','34','POST');
insert into call_method (id, call_dbid, method) values ('135','35','GET');
insert into call_method (id, call_dbid, method) values ('136','36','GET');
insert into call_method (id, call_dbid, method) values ('137','37','GET');
insert into call_method (id, call_dbid, method) values ('138','38','GET');
insert into call_method (id, call_dbid, method) values ('139','39','GET');
insert into call_method (id, call_dbid, method) values ('140','40','POST');
insert into call_method (id, call_dbid, method) values ('141','41','GET');
insert into call_method (id, call_dbid, method) values ('142','42','GET');
insert into call_method (id, call_dbid, method) values ('143','43','GET');
insert into call_method (id, call_dbid, method) values ('144','44','GET');
insert into call_method (id, call_dbid, method) values ('145','45','GET');
insert into call_method (id, call_dbid, method) values ('146','46','GET');
insert into call_method (id, call_dbid, method) values ('147','47','GET');
insert into call_method (id, call_dbid, method) values ('148','48','PUT');
insert into call_method (id, call_dbid, method) values ('149','49','GET');


insert into call_data_type (id, call_dbid, data_type) values ('21','1','json');
insert into call_data_type (id, call_dbid, data_type) values ('22','2','json');
insert into call_data_type (id, call_dbid, data_type) values ('24','4','json');
insert into call_data_type (id, call_dbid, data_type) values ('25','5','json');
insert into call_data_type (id, call_dbid, data_type) values ('26','6','json');
insert into call_data_type (id, call_dbid, data_type) values ('27','7','json');
insert into call_data_type (id, call_dbid, data_type) values ('28','8','json');
insert into call_data_type (id, call_dbid, data_type) values ('29','9','json');
insert into call_data_type (id, call_dbid, data_type) values ('210','10','json');
insert into call_data_type (id, call_dbid, data_type) values ('211','11','json');
insert into call_data_type (id, call_dbid, data_type) values ('212','12','json');
insert into call_data_type (id, call_dbid, data_type) values ('213','13','json');
insert into call_data_type (id, call_dbid, data_type) values ('214','14','json');
insert into call_data_type (id, call_dbid, data_type) values ('216','16','json');
insert into call_data_type (id, call_dbid, data_type) values ('217','17','json');
insert into call_data_type (id, call_dbid, data_type) values ('218','18','json');
insert into call_data_type (id, call_dbid, data_type) values ('219','19','json');
insert into call_data_type (id, call_dbid, data_type) values ('220','20','json');
insert into call_data_type (id, call_dbid, data_type) values ('221','21','json');
insert into call_data_type (id, call_dbid, data_type) values ('222','22','json');
insert into call_data_type (id, call_dbid, data_type) values ('224','24','json');
insert into call_data_type (id, call_dbid, data_type) values ('225','25','json');
insert into call_data_type (id, call_dbid, data_type) values ('226','26','json');
insert into call_data_type (id, call_dbid, data_type) values ('227','27','json');
insert into call_data_type (id, call_dbid, data_type) values ('228','28','json');
insert into call_data_type (id, call_dbid, data_type) values ('230','30','json');
insert into call_data_type (id, call_dbid, data_type) values ('232','32','json');
insert into call_data_type (id, call_dbid, data_type) values ('233','33','json');
insert into call_data_type (id, call_dbid, data_type) values ('234','34','json');
insert into call_data_type (id, call_dbid, data_type) values ('235','35','json');
insert into call_data_type (id, call_dbid, data_type) values ('236','36','json');
insert into call_data_type (id, call_dbid, data_type) values ('237','37','json');
insert into call_data_type (id, call_dbid, data_type) values ('238','38','json');
insert into call_data_type (id, call_dbid, data_type) values ('239','39','json');
insert into call_data_type (id, call_dbid, data_type) values ('240','40','json');
insert into call_data_type (id, call_dbid, data_type) values ('241','41','json');
insert into call_data_type (id, call_dbid, data_type) values ('242','42','json');
insert into call_data_type (id, call_dbid, data_type) values ('243','43','json');
insert into call_data_type (id, call_dbid, data_type) values ('244','44','json');
insert into call_data_type (id, call_dbid, data_type) values ('245','45','json');
insert into call_data_type (id, call_dbid, data_type) values ('246','46','json');
insert into call_data_type (id, call_dbid, data_type) values ('247','47','json');
insert into call_data_type (id, call_dbid, data_type) values ('248','48','json');
insert into call_data_type (id, call_dbid, data_type) values ('249','49','json');
