drop table if exists germplasm_attribute;
drop table if exists germplasm_attribute_category;


create table germplasm_attribute_category(
	attributeCategoryDbId char(20) primary key not null,
	attributeCategoryName text
);

insert into germplasm_attribute_category (attributeCategoryDbId,attributeCategoryName) values ('1','Morphological');
insert into germplasm_attribute_category (attributeCategoryDbId,attributeCategoryName) values ('2','Agronomic');
insert into germplasm_attribute_category (attributeCategoryDbId,attributeCategoryName) values ('3','Biotic stress');

select * from germplasm_attribute_category;

CREATE TABLE germplasm_attribute(
	attributeDbId char(20) primary key not null,
	code text,
	uri text,
	name text,
	description text,
	attributeCategoryDbId char(20) references germplasm_attribute_category(attributeCategoryDbId),
	attributeCategoryName text,
	datatype text,
	values text
);