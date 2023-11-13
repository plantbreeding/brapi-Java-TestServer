--
-- PostgreSQL database dump
--

-- Dumped from database version 11.4 (Debian 11.4-1.pgdg90+1)
-- Dumped by pg_dump version 11.4 (Debian 11.4-1.pgdg90+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: allele_call; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.allele_call (
                                    id text NOT NULL,
                                    additional_info jsonb,
                                    auth_user_id text,
                                    genotype text,
                                    genotype_likelihood double precision,
                                    phase_set text,
                                    read_depth integer,
                                    call_set_id text,
                                    variant_id text
);


ALTER TABLE public.allele_call OWNER TO postgres;

--
-- Name: allele_call_external_references; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.allele_call_external_references (
                                                        call_entity_id text NOT NULL,
                                                        external_references_id text NOT NULL
);


ALTER TABLE public.allele_call_external_references OWNER TO postgres;

--
-- Name: breeding_method; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.breeding_method (
                                        id text NOT NULL,
                                        additional_info jsonb,
                                        auth_user_id text,
                                        abbreviation text,
                                        description text,
                                        name text
);


ALTER TABLE public.breeding_method OWNER TO postgres;

--
-- Name: breeding_method_external_references; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.breeding_method_external_references (
                                                            breeding_method_entity_id text NOT NULL,
                                                            external_references_id text NOT NULL
);


ALTER TABLE public.breeding_method_external_references OWNER TO postgres;

--
-- Name: callset; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.callset (
                                id text NOT NULL,
                                additional_info jsonb,
                                auth_user_id text,
                                call_set_name text,
                                created timestamp without time zone,
                                updated timestamp without time zone,
                                sample_id text
);


ALTER TABLE public.callset OWNER TO postgres;

--
-- Name: callset_external_references; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.callset_external_references (
                                                    call_set_entity_id text NOT NULL,
                                                    external_references_id text NOT NULL
);


ALTER TABLE public.callset_external_references OWNER TO postgres;

--
-- Name: callset_variant_sets; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.callset_variant_sets (
                                             call_sets_id text NOT NULL,
                                             variant_sets_id text NOT NULL
);


ALTER TABLE public.callset_variant_sets OWNER TO postgres;

--
-- Name: contact; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.contact (
                                id text NOT NULL,
                                email text,
                                institute_name text,
                                name text,
                                orcid text,
                                study_db_id text,
                                trial_db_id text,
                                type text
);


ALTER TABLE public.contact OWNER TO postgres;

--
-- Name: coordinate; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.coordinate (
                                   id text NOT NULL,
                                   altitude numeric(9,6),
                                   latitude numeric(9,6),
                                   longitude numeric(9,6),
                                   geojson_id text
);


ALTER TABLE public.coordinate OWNER TO postgres;

--
-- Name: crop; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.crop (
                             id text NOT NULL,
                             additional_info jsonb,
                             auth_user_id text,
                             crop_name text
);


ALTER TABLE public.crop OWNER TO postgres;

--
-- Name: crop_external_references; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.crop_external_references (
                                                 crop_entity_id text NOT NULL,
                                                 external_references_id text NOT NULL
);


ALTER TABLE public.crop_external_references OWNER TO postgres;

--
-- Name: cross_entity; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cross_entity (
                                     id text NOT NULL,
                                     additional_info jsonb,
                                     auth_user_id text,
                                     cross_type integer,
                                     name text,
                                     planned boolean,
                                     status integer,
                                     crossing_project_id text,
                                     planned_cross_id text
);


ALTER TABLE public.cross_entity OWNER TO postgres;

--
-- Name: cross_entity_cross_attributes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cross_entity_cross_attributes (
                                                      cross_entity_id text NOT NULL,
                                                      cross_attributes text
);


ALTER TABLE public.cross_entity_cross_attributes OWNER TO postgres;

--
-- Name: cross_entity_external_references; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cross_entity_external_references (
                                                         cross_entity_id text NOT NULL,
                                                         external_references_id text NOT NULL
);


ALTER TABLE public.cross_entity_external_references OWNER TO postgres;

--
-- Name: cross_parent; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cross_parent (
                                     id text NOT NULL,
                                     parent_type integer,
                                     cross_id text,
                                     crossing_project_id text,
                                     germplasm_id text,
                                     observation_unit_id text
);


ALTER TABLE public.cross_parent OWNER TO postgres;

--
-- Name: cross_pollination_event; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cross_pollination_event (
                                                id text NOT NULL,
                                                pollination_number text,
                                                pollination_successful boolean,
                                                pollination_time_stamp timestamp without time zone,
                                                cross_id text
);


ALTER TABLE public.cross_pollination_event OWNER TO postgres;

--
-- Name: crossing_project; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.crossing_project (
                                         id text NOT NULL,
                                         additional_info jsonb,
                                         auth_user_id text,
                                         description text,
                                         name text,
                                         program_id text
);


ALTER TABLE public.crossing_project OWNER TO postgres;

--
-- Name: crossing_project_external_references; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.crossing_project_external_references (
                                                             crossing_project_entity_id text NOT NULL,
                                                             external_references_id text NOT NULL
);


ALTER TABLE public.crossing_project_external_references OWNER TO postgres;

--
-- Name: event; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.event (
                              id text NOT NULL,
                              additional_info jsonb,
                              auth_user_id text,
                              event_description text,
                              event_type text,
                              event_type_db_id text,
                              study_id text
);


ALTER TABLE public.event OWNER TO postgres;

--
-- Name: event_entity_dates; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.event_entity_dates (
                                           event_entity_id text NOT NULL,
                                           dates timestamp without time zone
);


ALTER TABLE public.event_entity_dates OWNER TO postgres;

--
-- Name: event_external_references; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.event_external_references (
                                                  event_entity_id text NOT NULL,
                                                  external_references_id text NOT NULL
);


ALTER TABLE public.event_external_references OWNER TO postgres;

--
-- Name: event_observation_units; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.event_observation_units (
                                                event_entity_id text NOT NULL,
                                                observation_units_id text NOT NULL
);


ALTER TABLE public.event_observation_units OWNER TO postgres;

--
-- Name: event_param; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.event_param (
                                    id text NOT NULL,
                                    code text,
                                    description text,
                                    key text,
                                    name text,
                                    rdf_value text,
                                    units text,
                                    value text,
                                    value_description text,
                                    event_id text
);


ALTER TABLE public.event_param OWNER TO postgres;

--
-- Name: event_parameter_entity_values_by_date; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.event_parameter_entity_values_by_date (
                                                              event_parameter_entity_id text NOT NULL,
                                                              values_by_date text
);


ALTER TABLE public.event_parameter_entity_values_by_date OWNER TO postgres;

--
-- Name: external_reference; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.external_reference (
                                           id text NOT NULL,
                                           external_reference_id text,
                                           external_reference_source text
);


ALTER TABLE public.external_reference OWNER TO postgres;

--
-- Name: genome_map; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.genome_map (
                                   id text NOT NULL,
                                   additional_info jsonb,
                                   auth_user_id text,
                                   comments text,
                                   documentationurl text,
                                   map_name text,
                                   mappui text,
                                   published_date timestamp without time zone,
                                   scientific_name text,
                                   type text,
                                   unit text,
                                   crop_id text
);


ALTER TABLE public.genome_map OWNER TO postgres;

--
-- Name: genome_map_external_references; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.genome_map_external_references (
                                                       genome_map_entity_id text NOT NULL,
                                                       external_references_id text NOT NULL
);


ALTER TABLE public.genome_map_external_references OWNER TO postgres;

--
-- Name: genome_map_studies; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.genome_map_studies (
                                           genome_map_entity_id text NOT NULL,
                                           studies_id text NOT NULL
);


ALTER TABLE public.genome_map_studies OWNER TO postgres;

--
-- Name: geojson; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.geojson (
                                id text NOT NULL,
                                type text
);


ALTER TABLE public.geojson OWNER TO postgres;

--
-- Name: germplasm; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.germplasm (
                                  id text NOT NULL,
                                  additional_info jsonb,
                                  auth_user_id text,
                                  accession_number text,
                                  acquisition_date timestamp without time zone,
                                  acquisition_source_code integer,
                                  biological_status_of_accession_code integer,
                                  collection text,
                                  country_of_origin_code text,
                                  default_display_name text,
                                  documentationurl text,
                                  genus text,
                                  germplasm_name text,
                                  germplasmpui text,
                                  germplasm_preprocessing text,
                                  mls_status integer,
                                  seed_source text,
                                  seed_source_description text,
                                  species text,
                                  species_authority text,
                                  subtaxa text,
                                  subtaxa_authority text,
                                  breeding_method_id text,
                                  crop_id text
);


ALTER TABLE public.germplasm OWNER TO postgres;

--
-- Name: germplasm_attribute_definition; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.germplasm_attribute_definition (
                                                       id text NOT NULL,
                                                       additional_info jsonb,
                                                       auth_user_id text,
                                                       default_value text,
                                                       documentationurl text,
                                                       growth_stage text,
                                                       institution text,
                                                       language text,
                                                       scientist text,
                                                       status text,
                                                       submission_timestamp timestamp without time zone,
                                                       crop_id text,
                                                       method_id text,
                                                       ontology_id text,
                                                       scale_id text,
                                                       trait_id text,
                                                       attribute_category text,
                                                       code text,
                                                       datatype text,
                                                       description text,
                                                       name text,
                                                       pui text,
                                                       uri text
);


ALTER TABLE public.germplasm_attribute_definition OWNER TO postgres;

--
-- Name: germplasm_attribute_value; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.germplasm_attribute_value (
                                                  id text NOT NULL,
                                                  additional_info jsonb,
                                                  auth_user_id text,
                                                  determined_date timestamp without time zone,
                                                  value text,
                                                  attribute_id text,
                                                  germplasm_id text
);


ALTER TABLE public.germplasm_attribute_value OWNER TO postgres;

--
-- Name: germplasm_attribute_value_external_references; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.germplasm_attribute_value_external_references (
                                                                      germplasm_attribute_value_entity_id text NOT NULL,
                                                                      external_references_id text NOT NULL
);


ALTER TABLE public.germplasm_attribute_value_external_references OWNER TO postgres;

--
-- Name: germplasm_donor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.germplasm_donor (
                                        id text NOT NULL,
                                        additional_info jsonb,
                                        auth_user_id text,
                                        donor_accession_number text,
                                        donor_institute_code text,
                                        donor_institute_name text,
                                        germplasmpui text,
                                        germplasm_id text
);


ALTER TABLE public.germplasm_donor OWNER TO postgres;

--
-- Name: germplasm_donor_external_references; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.germplasm_donor_external_references (
                                                            donor_entity_id text NOT NULL,
                                                            external_references_id text NOT NULL
);


ALTER TABLE public.germplasm_donor_external_references OWNER TO postgres;

--
-- Name: germplasm_entity_type_of_germplasm_storage_code; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.germplasm_entity_type_of_germplasm_storage_code (
                                                                        germplasm_entity_id text NOT NULL,
                                                                        type_of_germplasm_storage_code integer
);


ALTER TABLE public.germplasm_entity_type_of_germplasm_storage_code OWNER TO postgres;

--
-- Name: germplasm_external_references; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.germplasm_external_references (
                                                      germplasm_entity_id text NOT NULL,
                                                      external_references_id text NOT NULL
);


ALTER TABLE public.germplasm_external_references OWNER TO postgres;

--
-- Name: germplasm_institute; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.germplasm_institute (
                                            id text NOT NULL,
                                            institute_address text,
                                            institute_code text,
                                            institute_name text,
                                            institute_type integer,
                                            germplasm_id text
);


ALTER TABLE public.germplasm_institute OWNER TO postgres;

--
-- Name: germplasm_origin; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.germplasm_origin (
                                         id text NOT NULL,
                                         coordinate_uncertainty text,
                                         coordinates_id text,
                                         germplasm_id text
);


ALTER TABLE public.germplasm_origin OWNER TO postgres;

--
-- Name: germplasm_search_results; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.germplasm_search_results (
                                                 germplasm_entity_id text NOT NULL,
                                                 search_results_id text NOT NULL
);


ALTER TABLE public.germplasm_search_results OWNER TO postgres;

--
-- Name: germplasm_synonym; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.germplasm_synonym (
                                          id text NOT NULL,
                                          synonym text,
                                          type text,
                                          germplasm_id text
);


ALTER TABLE public.germplasm_synonym OWNER TO postgres;

--
-- Name: germplasm_taxon; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.germplasm_taxon (
                                        id text NOT NULL,
                                        source_name text,
                                        taxon_id text,
                                        germplasm_id text
);


ALTER TABLE public.germplasm_taxon OWNER TO postgres;

--
-- Name: image; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.image (
                              id text NOT NULL,
                              additional_info jsonb,
                              auth_user_id text,
                              copyright text,
                              description text,
                              image_data bytea,
                              image_file_name text,
                              image_file_size integer,
                              image_height integer,
                              imagemimetype text,
                              imageurl text,
                              image_width integer,
                              name text,
                              time_stamp timestamp without time zone,
                              coordinates_id text,
                              observation_unit_id text
);


ALTER TABLE public.image OWNER TO postgres;

--
-- Name: image_entity_descriptive_ontology_terms; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.image_entity_descriptive_ontology_terms (
                                                                image_entity_id text NOT NULL,
                                                                descriptive_ontology_terms text
);


ALTER TABLE public.image_entity_descriptive_ontology_terms OWNER TO postgres;

--
-- Name: image_external_references; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.image_external_references (
                                                  image_entity_id text NOT NULL,
                                                  external_references_id text NOT NULL
);


ALTER TABLE public.image_external_references OWNER TO postgres;

--
-- Name: image_observations; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.image_observations (
                                           image_entity_id text NOT NULL,
                                           observations_id text NOT NULL
);


ALTER TABLE public.image_observations OWNER TO postgres;

--
-- Name: linkage_group; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.linkage_group (
                                      id text NOT NULL,
                                      additional_info jsonb,
                                      auth_user_id text,
                                      linkage_group_name text,
                                      max_marker_position integer,
                                      genome_map_id text
);


ALTER TABLE public.linkage_group OWNER TO postgres;

--
-- Name: linkage_group_external_references; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.linkage_group_external_references (
                                                          linkage_group_entity_id text NOT NULL,
                                                          external_references_id text NOT NULL
);


ALTER TABLE public.linkage_group_external_references OWNER TO postgres;

--
-- Name: list; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.list (
                             id text NOT NULL,
                             additional_info jsonb,
                             auth_user_id text,
                             date_created timestamp without time zone,
                             date_modified timestamp without time zone,
                             description text,
                             list_name text,
                             list_owner_name text,
                             list_source text,
                             list_type integer,
                             list_owner_person_id text
);


ALTER TABLE public.list OWNER TO postgres;

--
-- Name: list_external_references; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.list_external_references (
                                                 list_entity_id text NOT NULL,
                                                 external_references_id text NOT NULL
);


ALTER TABLE public.list_external_references OWNER TO postgres;

--
-- Name: list_item; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.list_item (
                                  id text NOT NULL,
                                  item text,
                                  list_id text
);


ALTER TABLE public.list_item OWNER TO postgres;

--
-- Name: location; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.location (
                                 id text NOT NULL,
                                 additional_info jsonb,
                                 auth_user_id text,
                                 abbreviation text,
                                 coordinate_description text,
                                 coordinate_uncertainty text,
                                 country_code text,
                                 country_name text,
                                 documentationurl text,
                                 environment_type text,
                                 exposure text,
                                 institute_address text,
                                 institute_name text,
                                 location_name text,
                                 location_type text,
                                 site_status text,
                                 slope text,
                                 topography text,
                                 coordinates_id text,
                                 crop_id text,
                                 parent_location_id text,
                                 program_id text
);


ALTER TABLE public.location OWNER TO postgres;

--
-- Name: location_external_references; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.location_external_references (
                                                     location_entity_id text NOT NULL,
                                                     external_references_id text NOT NULL
);


ALTER TABLE public.location_external_references OWNER TO postgres;

--
-- Name: marker_position; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.marker_position (
                                        id text NOT NULL,
                                        additional_info jsonb,
                                        auth_user_id text,
                                        "position" integer,
                                        linkage_group_id text,
                                        variant_id text
);


ALTER TABLE public.marker_position OWNER TO postgres;

--
-- Name: marker_position_external_references; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.marker_position_external_references (
                                                            marker_position_entity_id text NOT NULL,
                                                            external_references_id text NOT NULL
);


ALTER TABLE public.marker_position_external_references OWNER TO postgres;

--
-- Name: method; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.method (
                               id text NOT NULL,
                               additional_info jsonb,
                               auth_user_id text,
                               description text,
                               formula text,
                               method_class text,
                               methodpui text,
                               name text,
                               reference text,
                               ontology_id text
);


ALTER TABLE public.method OWNER TO postgres;

--
-- Name: method_external_references; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.method_external_references (
                                                   method_entity_id text NOT NULL,
                                                   external_references_id text NOT NULL
);


ALTER TABLE public.method_external_references OWNER TO postgres;

--
-- Name: method_ontology_reference; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.method_ontology_reference (
                                                  method_entity_id text NOT NULL,
                                                  ontology_reference_id text NOT NULL
);


ALTER TABLE public.method_ontology_reference OWNER TO postgres;

--
-- Name: observation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.observation (
                                    id text NOT NULL,
                                    additional_info jsonb,
                                    auth_user_id text,
                                    collector text,
                                    observation_time_stamp timestamp without time zone,
                                    uploaded_by text,
                                    value text,
                                    crop_id text,
                                    geo_coordinates_id text,
                                    observation_unit_id text,
                                    observation_variable_id text,
                                    program_id text,
                                    season_id text,
                                    study_id text,
                                    trial_id text
);


ALTER TABLE public.observation OWNER TO postgres;

--
-- Name: observation_external_references; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.observation_external_references (
                                                        observation_entity_id text NOT NULL,
                                                        external_references_id text NOT NULL
);


ALTER TABLE public.observation_external_references OWNER TO postgres;

--
-- Name: observation_unit; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.observation_unit (
                                         id text NOT NULL,
                                         additional_info jsonb,
                                         auth_user_id text,
                                         observation_unit_name text,
                                         observation_unitpui text,
                                         crop_id text,
                                         cross_id text,
                                         germplasm_id text,
                                         program_id text,
                                         seed_lot_id text,
                                         study_id text,
                                         trial_id text
);


ALTER TABLE public.observation_unit OWNER TO postgres;

--
-- Name: observation_unit_external_references; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.observation_unit_external_references (
                                                             observation_unit_entity_id text NOT NULL,
                                                             external_references_id text NOT NULL
);


ALTER TABLE public.observation_unit_external_references OWNER TO postgres;

--
-- Name: observation_unit_level; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.observation_unit_level (
                                               id text NOT NULL,
                                               level_code text,
                                               level_name integer,
                                               level_order integer,
                                               observation_unit_id text,
                                               position_id text
);


ALTER TABLE public.observation_unit_level OWNER TO postgres;

--
-- Name: observation_unit_position; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.observation_unit_position (
                                                  id text NOT NULL,
                                                  entry_type integer,
                                                  level_code text,
                                                  level_name integer,
                                                  level_order integer,
                                                  position_coordinatex text,
                                                  position_coordinatextype integer,
                                                  position_coordinatey text,
                                                  position_coordinateytype integer,
                                                  geo_coordinates_id text,
                                                  observation_unit_id text
);


ALTER TABLE public.observation_unit_position OWNER TO postgres;

--
-- Name: observation_unit_treatment; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.observation_unit_treatment (
                                                   id text NOT NULL,
                                                   factor text,
                                                   modality text,
                                                   observation_unit_id text
);


ALTER TABLE public.observation_unit_treatment OWNER TO postgres;

--
-- Name: observation_variable; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.observation_variable (
                                             id text NOT NULL,
                                             additional_info jsonb,
                                             auth_user_id text,
                                             default_value text,
                                             documentationurl text,
                                             growth_stage text,
                                             institution text,
                                             language text,
                                             scientist text,
                                             status text,
                                             submission_timestamp timestamp without time zone,
                                             crop_id text,
                                             method_id text,
                                             ontology_id text,
                                             scale_id text,
                                             trait_id text,
                                             name text,
                                             pui text
);


ALTER TABLE public.observation_variable OWNER TO postgres;

--
-- Name: ontology; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ontology (
                                 id text NOT NULL,
                                 additional_info jsonb,
                                 auth_user_id text,
                                 authors text,
                                 copyright text,
                                 description text,
                                 documentationurl text,
                                 licence text,
                                 ontology_name text,
                                 version text
);


ALTER TABLE public.ontology OWNER TO postgres;

--
-- Name: ontology_entity_documentation_links; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ontology_entity_documentation_links (
                                                            ontology_entity_id text NOT NULL,
                                                            documentation_links text
);


ALTER TABLE public.ontology_entity_documentation_links OWNER TO postgres;

--
-- Name: ontology_external_references; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ontology_external_references (
                                                     ontology_entity_id text NOT NULL,
                                                     external_references_id text NOT NULL
);


ALTER TABLE public.ontology_external_references OWNER TO postgres;

--
-- Name: ontology_ref; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ontology_ref (
                                     id text NOT NULL,
                                     url text,
                                     type integer
);


ALTER TABLE public.ontology_ref OWNER TO postgres;

--
-- Name: pedigree_edge; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pedigree_edge (
                                      id text NOT NULL,
                                      additional_info jsonb,
                                      auth_user_id text,
                                      edge_type integer,
                                      parent_type integer,
                                      connceted_node_id text,
                                      this_node_id text
);


ALTER TABLE public.pedigree_edge OWNER TO postgres;

--
-- Name: pedigree_edge_external_references; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pedigree_edge_external_references (
                                                          pedigree_edge_entity_id text NOT NULL,
                                                          external_references_id text NOT NULL
);


ALTER TABLE public.pedigree_edge_external_references OWNER TO postgres;

--
-- Name: pedigree_node; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pedigree_node (
                                      id text NOT NULL,
                                      additional_info jsonb,
                                      auth_user_id text,
                                      crossing_year integer,
                                      family_code text,
                                      pedigree_string text,
                                      crossing_project_id text,
                                      germplasm_id text
);


ALTER TABLE public.pedigree_node OWNER TO postgres;

--
-- Name: pedigree_node_external_references; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pedigree_node_external_references (
                                                          pedigree_node_entity_id text NOT NULL,
                                                          external_references_id text NOT NULL
);


ALTER TABLE public.pedigree_node_external_references OWNER TO postgres;

--
-- Name: person; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.person (
                               id text NOT NULL,
                               additional_info jsonb,
                               auth_user_id text,
                               description text,
                               email_address text,
                               first_name text,
                               institute_name text,
                               last_name text,
                               mailing_address text,
                               middle_name text,
                               phone_number text,
                               userid text
);


ALTER TABLE public.person OWNER TO postgres;

--
-- Name: person_external_references; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.person_external_references (
                                                   person_entity_id text NOT NULL,
                                                   external_references_id text NOT NULL
);


ALTER TABLE public.person_external_references OWNER TO postgres;

--
-- Name: plate; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.plate (
                              id text NOT NULL,
                              additional_info jsonb,
                              auth_user_id text,
                              client_plate_barcode text,
                              client_plate_db_id text,
                              plate_barcode text,
                              plate_format integer,
                              plate_name text,
                              sample_submission_format integer,
                              sample_type integer,
                              status_time_stamp timestamp without time zone,
                              program_id text,
                              study_id text,
                              submission_id text,
                              trial_id text
);


ALTER TABLE public.plate OWNER TO postgres;

--
-- Name: plate_external_references; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.plate_external_references (
                                                  plate_entity_id text NOT NULL,
                                                  external_references_id text NOT NULL
);


ALTER TABLE public.plate_external_references OWNER TO postgres;

--
-- Name: plate_submission; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.plate_submission (
                                         id text NOT NULL,
                                         additional_info jsonb,
                                         auth_user_id text,
                                         client_id text,
                                         number_of_samples integer,
                                         sample_type integer,
                                         order_id text
);


ALTER TABLE public.plate_submission OWNER TO postgres;

--
-- Name: plate_submission_external_references; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.plate_submission_external_references (
                                                             vendor_plate_submission_entity_id text NOT NULL,
                                                             external_references_id text NOT NULL
);


ALTER TABLE public.plate_submission_external_references OWNER TO postgres;

--
-- Name: program; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.program (
                                id text NOT NULL,
                                additional_info jsonb,
                                auth_user_id text,
                                abbreviation text,
                                documentationurl text,
                                funding_information text,
                                name text,
                                objective text,
                                program_type integer,
                                crop_id text,
                                lead_person_id text
);


ALTER TABLE public.program OWNER TO postgres;

--
-- Name: program_external_references; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.program_external_references (
                                                    program_entity_id text NOT NULL,
                                                    external_references_id text NOT NULL
);


ALTER TABLE public.program_external_references OWNER TO postgres;

--
-- Name: reference; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.reference (
                                  id text NOT NULL,
                                  additional_info jsonb,
                                  auth_user_id text,
                                  length integer,
                                  md5checksum text,
                                  reference_name text,
                                  source_divergence numeric(19,2),
                                  reference_set_id text
);


ALTER TABLE public.reference OWNER TO postgres;

--
-- Name: reference_bases; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.reference_bases (
                                        id text NOT NULL,
                                        additional_info jsonb,
                                        auth_user_id text,
                                        bases text,
                                        page_number integer,
                                        reference_id text
);


ALTER TABLE public.reference_bases OWNER TO postgres;

--
-- Name: reference_bases_external_references; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.reference_bases_external_references (
                                                            reference_bases_page_entity_id text NOT NULL,
                                                            external_references_id text NOT NULL
);


ALTER TABLE public.reference_bases_external_references OWNER TO postgres;

--
-- Name: reference_external_references; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.reference_external_references (
                                                      reference_entity_id text NOT NULL,
                                                      external_references_id text NOT NULL
);


ALTER TABLE public.reference_external_references OWNER TO postgres;

--
-- Name: reference_set; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.reference_set (
                                      id text NOT NULL,
                                      additional_info jsonb,
                                      auth_user_id text,
                                      assemblypui text,
                                      description text,
                                      is_derived boolean,
                                      md5checksum text,
                                      reference_set_name text,
                                      sourceuri text,
                                      species_ontology_term text,
                                      species_ontology_termuri text,
                                      source_germplasm_id text
);


ALTER TABLE public.reference_set OWNER TO postgres;

--
-- Name: reference_set_external_references; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.reference_set_external_references (
                                                          reference_set_entity_id text NOT NULL,
                                                          external_references_id text NOT NULL
);


ALTER TABLE public.reference_set_external_references OWNER TO postgres;

--
-- Name: sample; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sample (
                               id text NOT NULL,
                               additional_info jsonb,
                               auth_user_id text,
                               concentration text,
                               plate_column integer,
                               plate_row text,
                               sample_barcode text,
                               sample_description text,
                               sample_group_db_id text,
                               sample_name text,
                               samplepui text,
                               sample_timestamp timestamp without time zone,
                               sample_type text,
                               taken_by text,
                               tissue_type text,
                               volume text,
                               well text,
                               observation_unit_id text,
                               plate_id text,
                               program_id text,
                               study_id text,
                               taxon_id_id text,
                               trial_id text
);


ALTER TABLE public.sample OWNER TO postgres;

--
-- Name: sample_external_references; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sample_external_references (
                                                   sample_entity_id text NOT NULL,
                                                   external_references_id text NOT NULL
);


ALTER TABLE public.sample_external_references OWNER TO postgres;

--
-- Name: scale; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.scale (
                              id text NOT NULL,
                              additional_info jsonb,
                              auth_user_id text,
                              data_type integer,
                              decimal_places integer,
                              scale_name text,
                              scalepui text,
                              units text,
                              valid_value_max text,
                              valid_value_min text,
                              ontology_id text
);


ALTER TABLE public.scale OWNER TO postgres;

--
-- Name: scale_external_references; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.scale_external_references (
                                                  scale_entity_id text NOT NULL,
                                                  external_references_id text NOT NULL
);


ALTER TABLE public.scale_external_references OWNER TO postgres;

--
-- Name: scale_ontology_reference; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.scale_ontology_reference (
                                                 scale_entity_id text NOT NULL,
                                                 ontology_reference_id text NOT NULL
);


ALTER TABLE public.scale_ontology_reference OWNER TO postgres;

--
-- Name: scale_valid_value_category; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.scale_valid_value_category (
                                                   id text NOT NULL,
                                                   label text,
                                                   value text,
                                                   scale_id text
);


ALTER TABLE public.scale_valid_value_category OWNER TO postgres;

--
-- Name: search; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.search (
                               id text NOT NULL,
                               additional_info jsonb,
                               auth_user_id text,
                               parameters text,
                               request_type integer,
                               response_countdown integer
);


ALTER TABLE public.search OWNER TO postgres;

--
-- Name: search_external_references; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.search_external_references (
                                                   search_request_entity_id text NOT NULL,
                                                   external_references_id text NOT NULL
);


ALTER TABLE public.search_external_references OWNER TO postgres;

--
-- Name: season; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.season (
                               id text NOT NULL,
                               additional_info jsonb,
                               auth_user_id text,
                               season text,
                               year integer
);


ALTER TABLE public.season OWNER TO postgres;

--
-- Name: season_external_references; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.season_external_references (
                                                   season_entity_id text NOT NULL,
                                                   external_references_id text NOT NULL
);


ALTER TABLE public.season_external_references OWNER TO postgres;

--
-- Name: seed_lot; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.seed_lot (
                                 id text NOT NULL,
                                 additional_info jsonb,
                                 auth_user_id text,
                                 amount numeric(19,2),
                                 created_date timestamp without time zone,
                                 description text,
                                 last_updated timestamp without time zone,
                                 name text,
                                 source_collection text,
                                 storage_location text,
                                 units text,
                                 location_id text,
                                 program_id text
);


ALTER TABLE public.seed_lot OWNER TO postgres;

--
-- Name: seed_lot_content_mixture; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.seed_lot_content_mixture (
                                                 id text NOT NULL,
                                                 mixture_percentage integer,
                                                 cross_id text,
                                                 germplasm_id text,
                                                 seed_lot_id text
);


ALTER TABLE public.seed_lot_content_mixture OWNER TO postgres;

--
-- Name: seed_lot_external_references; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.seed_lot_external_references (
                                                     seed_lot_entity_id text NOT NULL,
                                                     external_references_id text NOT NULL
);


ALTER TABLE public.seed_lot_external_references OWNER TO postgres;

--
-- Name: seed_lot_transaction; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.seed_lot_transaction (
                                             id text NOT NULL,
                                             additional_info jsonb,
                                             auth_user_id text,
                                             amount numeric(19,2),
                                             description text,
                                             "timestamp" timestamp without time zone,
                                             units text,
                                             from_seed_lot_id text,
                                             to_seed_lot_id text
);


ALTER TABLE public.seed_lot_transaction OWNER TO postgres;

--
-- Name: seed_lot_transaction_external_references; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.seed_lot_transaction_external_references (
                                                                 seed_lot_transaction_entity_id text NOT NULL,
                                                                 external_references_id text NOT NULL
);


ALTER TABLE public.seed_lot_transaction_external_references OWNER TO postgres;

--
-- Name: study; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.study (
                              id text NOT NULL,
                              additional_info jsonb,
                              auth_user_id text,
                              active boolean,
                              cultural_practices text,
                              documentationurl text,
                              end_date timestamp without time zone,
                              license text,
                              observation_units_description text,
                              start_date timestamp without time zone,
                              study_code text,
                              study_description text,
                              study_name text,
                              studypui text,
                              study_type text,
                              crop_id text,
                              location_id text,
                              program_id text,
                              trial_id text
);


ALTER TABLE public.study OWNER TO postgres;

--
-- Name: study_contact; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.study_contact (
                                      study_db_id text NOT NULL,
                                      person_db_id text NOT NULL
);


ALTER TABLE public.study_contact OWNER TO postgres;

--
-- Name: study_data_link; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.study_data_link (
                                        id text NOT NULL,
                                        data_format text,
                                        description text,
                                        file_format text,
                                        name text,
                                        provenance text,
                                        scientific_type text,
                                        url text,
                                        version text,
                                        study_id text
);


ALTER TABLE public.study_data_link OWNER TO postgres;

--
-- Name: study_environment_parameter; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.study_environment_parameter (
                                                    id text NOT NULL,
                                                    description text,
                                                    parameter_name text,
                                                    parameterpui text,
                                                    unit text,
                                                    unitpui text,
                                                    value text,
                                                    valuepui text,
                                                    study_id text
);


ALTER TABLE public.study_environment_parameter OWNER TO postgres;

--
-- Name: study_experimental_design; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.study_experimental_design (
                                                  id text NOT NULL,
                                                  pui text,
                                                  description text,
                                                  study_id text
);


ALTER TABLE public.study_experimental_design OWNER TO postgres;

--
-- Name: study_external_references; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.study_external_references (
                                                  study_entity_id text NOT NULL,
                                                  external_references_id text NOT NULL
);


ALTER TABLE public.study_external_references OWNER TO postgres;

--
-- Name: study_growth_facility; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.study_growth_facility (
                                              id text NOT NULL,
                                              pui text,
                                              description text,
                                              study_id text
);


ALTER TABLE public.study_growth_facility OWNER TO postgres;

--
-- Name: study_last_update; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.study_last_update (
                                          id text NOT NULL,
                                          "timestamp" timestamp without time zone,
                                          version text,
                                          study_id text
);


ALTER TABLE public.study_last_update OWNER TO postgres;

--
-- Name: study_observation_level; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.study_observation_level (
                                                id text NOT NULL,
                                                level_name text,
                                                level_order integer,
                                                study_id text
);


ALTER TABLE public.study_observation_level OWNER TO postgres;

--
-- Name: study_season; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.study_season (
                                     study_db_id text NOT NULL,
                                     season_db_id text NOT NULL
);


ALTER TABLE public.study_season OWNER TO postgres;

--
-- Name: study_variable; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.study_variable (
                                       study_db_id text NOT NULL,
                                       variable_db_id text NOT NULL
);


ALTER TABLE public.study_variable OWNER TO postgres;

--
-- Name: trait; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.trait (
                              id text NOT NULL,
                              additional_info jsonb,
                              auth_user_id text,
                              attribute text,
                              attributepui text,
                              entity text,
                              entitypui text,
                              main_abbreviation text,
                              status text,
                              trait_class text,
                              trait_description text,
                              trait_name text,
                              traitpui text,
                              ontology_id text
);


ALTER TABLE public.trait OWNER TO postgres;

--
-- Name: trait_abbreviation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.trait_abbreviation (
                                           id text NOT NULL,
                                           abbreviation text,
                                           trait_id text
);


ALTER TABLE public.trait_abbreviation OWNER TO postgres;

--
-- Name: trait_entity_alternative_abbreviations; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.trait_entity_alternative_abbreviations (
                                                               trait_entity_id text NOT NULL,
                                                               alternative_abbreviations text
);


ALTER TABLE public.trait_entity_alternative_abbreviations OWNER TO postgres;

--
-- Name: trait_entity_synonyms; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.trait_entity_synonyms (
                                              trait_entity_id text NOT NULL,
                                              synonyms text
);


ALTER TABLE public.trait_entity_synonyms OWNER TO postgres;

--
-- Name: trait_external_references; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.trait_external_references (
                                                  trait_entity_id text NOT NULL,
                                                  external_references_id text NOT NULL
);


ALTER TABLE public.trait_external_references OWNER TO postgres;

--
-- Name: trait_ontology_reference; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.trait_ontology_reference (
                                                 trait_entity_id text NOT NULL,
                                                 ontology_reference_id text NOT NULL
);


ALTER TABLE public.trait_ontology_reference OWNER TO postgres;

--
-- Name: trait_synonym; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.trait_synonym (
                                      id text NOT NULL,
                                      synonym text,
                                      trait_id text
);


ALTER TABLE public.trait_synonym OWNER TO postgres;

--
-- Name: trial; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.trial (
                              id text NOT NULL,
                              additional_info jsonb,
                              auth_user_id text,
                              active boolean,
                              documentationurl text,
                              end_date timestamp without time zone,
                              start_date timestamp without time zone,
                              trial_description text,
                              trial_name text,
                              trialpui text,
                              crop_id text,
                              program_id text
);


ALTER TABLE public.trial OWNER TO postgres;

--
-- Name: trial_contact; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.trial_contact (
                                      trial_db_id text NOT NULL,
                                      person_db_id text NOT NULL
);


ALTER TABLE public.trial_contact OWNER TO postgres;

--
-- Name: trial_dataset_authorship; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.trial_dataset_authorship (
                                                 id text NOT NULL,
                                                 datasetpui text,
                                                 license text,
                                                 public_release_date timestamp without time zone,
                                                 submission_date timestamp without time zone,
                                                 trial_id text
);


ALTER TABLE public.trial_dataset_authorship OWNER TO postgres;

--
-- Name: trial_external_references; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.trial_external_references (
                                                  trial_entity_id text NOT NULL,
                                                  external_references_id text NOT NULL
);


ALTER TABLE public.trial_external_references OWNER TO postgres;

--
-- Name: trial_publication; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.trial_publication (
                                          id text NOT NULL,
                                          publicationpui text,
                                          publication_reference text,
                                          trial_id text
);


ALTER TABLE public.trial_publication OWNER TO postgres;

--
-- Name: variable_base_entity; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.variable_base_entity (
                                             id text NOT NULL,
                                             additional_info jsonb,
                                             auth_user_id text,
                                             default_value text,
                                             documentationurl text,
                                             growth_stage text,
                                             institution text,
                                             language text,
                                             scientist text,
                                             status text,
                                             submission_timestamp timestamp without time zone,
                                             crop_id text,
                                             method_id text,
                                             ontology_id text,
                                             scale_id text,
                                             trait_id text
);


ALTER TABLE public.variable_base_entity OWNER TO postgres;

--
-- Name: variable_base_entity_context_of_use; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.variable_base_entity_context_of_use (
                                                            variable_base_entity_id text NOT NULL,
                                                            context_of_use text
);


ALTER TABLE public.variable_base_entity_context_of_use OWNER TO postgres;

--
-- Name: variable_base_entity_external_references; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.variable_base_entity_external_references (
                                                                 variable_base_entity_id text NOT NULL,
                                                                 external_references_id text NOT NULL
);


ALTER TABLE public.variable_base_entity_external_references OWNER TO postgres;

--
-- Name: variable_base_entity_ontology_reference; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.variable_base_entity_ontology_reference (
                                                                variable_base_entity_id text NOT NULL,
                                                                ontology_reference_id text NOT NULL
);


ALTER TABLE public.variable_base_entity_ontology_reference OWNER TO postgres;

--
-- Name: variable_base_entity_synonyms; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.variable_base_entity_synonyms (
                                                      variable_base_entity_id text NOT NULL,
                                                      synonyms text
);


ALTER TABLE public.variable_base_entity_synonyms OWNER TO postgres;

--
-- Name: variant; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.variant (
                                id text NOT NULL,
                                additional_info jsonb,
                                auth_user_id text,
                                created timestamp without time zone,
                                variant_end integer,
                                filters_applied boolean,
                                filters_passed boolean,
                                reference_bases text,
                                variant_start integer,
                                svlen integer,
                                updated timestamp without time zone,
                                variant_name text,
                                variant_type text,
                                reference_set_id text,
                                variant_set_id text
);


ALTER TABLE public.variant OWNER TO postgres;

--
-- Name: variant_entity_alternate_bases; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.variant_entity_alternate_bases (
                                                       variant_entity_id text NOT NULL,
                                                       alternate_bases text
);


ALTER TABLE public.variant_entity_alternate_bases OWNER TO postgres;

--
-- Name: variant_entity_ciend; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.variant_entity_ciend (
                                             variant_entity_id text NOT NULL,
                                             ciend integer
);


ALTER TABLE public.variant_entity_ciend OWNER TO postgres;

--
-- Name: variant_entity_cipos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.variant_entity_cipos (
                                             variant_entity_id text NOT NULL,
                                             cipos integer
);


ALTER TABLE public.variant_entity_cipos OWNER TO postgres;

--
-- Name: variant_entity_filters_failed; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.variant_entity_filters_failed (
                                                      variant_entity_id text NOT NULL,
                                                      filters_failed text
);


ALTER TABLE public.variant_entity_filters_failed OWNER TO postgres;

--
-- Name: variant_external_references; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.variant_external_references (
                                                    variant_entity_id text NOT NULL,
                                                    external_references_id text NOT NULL
);


ALTER TABLE public.variant_external_references OWNER TO postgres;

--
-- Name: variant_set_analysis_entity_software; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.variant_set_analysis_entity_software (
                                                             variant_set_analysis_entity_id text NOT NULL,
                                                             software text
);


ALTER TABLE public.variant_set_analysis_entity_software OWNER TO postgres;

--
-- Name: variantset; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.variantset (
                                   id text NOT NULL,
                                   additional_info jsonb,
                                   auth_user_id text,
                                   variant_set_name text,
                                   reference_set_id text,
                                   study_id text
);


ALTER TABLE public.variantset OWNER TO postgres;

--
-- Name: variantset_analysis; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.variantset_analysis (
                                            id text NOT NULL,
                                            analysis_name text,
                                            created timestamp without time zone,
                                            description text,
                                            type text,
                                            updated timestamp without time zone,
                                            variant_set_id text
);


ALTER TABLE public.variantset_analysis OWNER TO postgres;

--
-- Name: variantset_external_references; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.variantset_external_references (
                                                       variant_set_entity_id text NOT NULL,
                                                       external_references_id text NOT NULL
);


ALTER TABLE public.variantset_external_references OWNER TO postgres;

--
-- Name: variantset_format; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.variantset_format (
                                          id text NOT NULL,
                                          data_format integer,
                                          expand_homozygotes boolean,
                                          file_format integer,
                                          fileurl text,
                                          sep_phased text,
                                          sep_unphased text,
                                          unknown_string text,
                                          variant_set_id text
);


ALTER TABLE public.variantset_format OWNER TO postgres;

--
-- Name: vendor_file; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.vendor_file (
                                    id text NOT NULL,
                                    url text,
                                    file_type text,
                                    filename text,
                                    md5sum text,
                                    order_id text
);


ALTER TABLE public.vendor_file OWNER TO postgres;

--
-- Name: vendor_file_sample; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.vendor_file_sample (
                                           verndor_file_dbid text NOT NULL,
                                           sample_dbid text NOT NULL
);


ALTER TABLE public.vendor_file_sample OWNER TO postgres;

--
-- Name: vendor_order; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.vendor_order (
                                     id text NOT NULL,
                                     additional_info jsonb,
                                     auth_user_id text,
                                     client_plate_barcode text,
                                     client_plate_db_id text,
                                     sample_type integer,
                                     status integer,
                                     status_time_stamp timestamp without time zone
);


ALTER TABLE public.vendor_order OWNER TO postgres;

--
-- Name: vendor_order_entity_required_service_info; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.vendor_order_entity_required_service_info (
                                                                  vendor_order_entity_id text NOT NULL,
                                                                  required_service_info text,
                                                                  required_service_info_key text NOT NULL
);


ALTER TABLE public.vendor_order_entity_required_service_info OWNER TO postgres;

--
-- Name: vendor_order_entity_service_ids; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.vendor_order_entity_service_ids (
                                                        vendor_order_entity_id text NOT NULL,
                                                        service_ids text
);


ALTER TABLE public.vendor_order_entity_service_ids OWNER TO postgres;

--
-- Name: vendor_order_external_references; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.vendor_order_external_references (
                                                         vendor_order_entity_id text NOT NULL,
                                                         external_references_id text NOT NULL
);


ALTER TABLE public.vendor_order_external_references OWNER TO postgres;

--
-- Name: vendor_spec; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.vendor_spec (
                                    id text NOT NULL,
                                    additional_info jsonb,
                                    auth_user_id text,
                                    contact_name text,
                                    vendor_address text,
                                    vendor_city text,
                                    vendor_country text,
                                    vendor_description text,
                                    vendor_email text,
                                    vendor_name text,
                                    vendor_phone text,
                                    vendorurl text
);


ALTER TABLE public.vendor_spec OWNER TO postgres;

--
-- Name: vendor_spec_deliverable; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.vendor_spec_deliverable (
                                                id text NOT NULL,
                                                description text,
                                                format text,
                                                name text,
                                                vendor_spec_platform_db_id text
);


ALTER TABLE public.vendor_spec_deliverable OWNER TO postgres;

--
-- Name: vendor_spec_external_references; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.vendor_spec_external_references (
                                                        vendor_spec_entity_id text NOT NULL,
                                                        external_references_id text NOT NULL
);


ALTER TABLE public.vendor_spec_external_references OWNER TO postgres;

--
-- Name: vendor_spec_input_format; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.vendor_spec_input_format (
                                                 id text NOT NULL,
                                                 input_format text,
                                                 vendor_spec_standard_requirement_db_id text
);


ALTER TABLE public.vendor_spec_input_format OWNER TO postgres;

--
-- Name: vendor_spec_platform; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.vendor_spec_platform (
                                             id text NOT NULL,
                                             contact_email text,
                                             contact_name text,
                                             contact_phone text,
                                             platform_description text,
                                             platform_name text,
                                             platformurl text,
                                             shipping_address text,
                                             specific_requirements text,
                                             taxonomy_id_system_name text,
                                             taxonomy_id_systemuri text,
                                             tissue_id_system_name text,
                                             tissue_id_systemuri text,
                                             vendor_spec_db_id text,
                                             standard_requirements_id text
);


ALTER TABLE public.vendor_spec_platform OWNER TO postgres;

--
-- Name: vendor_spec_requirement; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.vendor_spec_requirement (
                                                id text NOT NULL,
                                                input_format_details text,
                                                max_concentration text,
                                                max_volume text,
                                                min_concentration text,
                                                min_sample_number text,
                                                min_volume text,
                                                plate_orientation text,
                                                sample_type_details text
);


ALTER TABLE public.vendor_spec_requirement OWNER TO postgres;

--
-- Name: vendor_spec_sample_type; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.vendor_spec_sample_type (
                                                id text NOT NULL,
                                                sample_type text,
                                                vendor_spec_standard_requirement_db_id text
);


ALTER TABLE public.vendor_spec_sample_type OWNER TO postgres;

--
-- Name: vendor_spec_status; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.vendor_spec_status (
                                           id text NOT NULL,
                                           status_description text,
                                           status_name text,
                                           vendor_spec_platform_db_id text
);


ALTER TABLE public.vendor_spec_status OWNER TO postgres;

--
-- Name: vendor_spec_well_position; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.vendor_spec_well_position (
                                                  id text NOT NULL,
                                                  "position" text,
                                                  vendor_spec_standard_requirement_db_id text
);


ALTER TABLE public.vendor_spec_well_position OWNER TO postgres;

--
-- Name: allele_call allele_call_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.allele_call
    ADD CONSTRAINT allele_call_pkey PRIMARY KEY (id);


--
-- Name: breeding_method breeding_method_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.breeding_method
    ADD CONSTRAINT breeding_method_pkey PRIMARY KEY (id);


--
-- Name: callset callset_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.callset
    ADD CONSTRAINT callset_pkey PRIMARY KEY (id);


--
-- Name: contact contact_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contact
    ADD CONSTRAINT contact_pkey PRIMARY KEY (id);


--
-- Name: coordinate coordinate_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.coordinate
    ADD CONSTRAINT coordinate_pkey PRIMARY KEY (id);


--
-- Name: crop crop_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.crop
    ADD CONSTRAINT crop_pkey PRIMARY KEY (id);


--
-- Name: cross_entity cross_entity_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cross_entity
    ADD CONSTRAINT cross_entity_pkey PRIMARY KEY (id);


--
-- Name: cross_parent cross_parent_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cross_parent
    ADD CONSTRAINT cross_parent_pkey PRIMARY KEY (id);


--
-- Name: cross_pollination_event cross_pollination_event_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cross_pollination_event
    ADD CONSTRAINT cross_pollination_event_pkey PRIMARY KEY (id);


--
-- Name: crossing_project crossing_project_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.crossing_project
    ADD CONSTRAINT crossing_project_pkey PRIMARY KEY (id);


--
-- Name: event_param event_param_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.event_param
    ADD CONSTRAINT event_param_pkey PRIMARY KEY (id);


--
-- Name: event event_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.event
    ADD CONSTRAINT event_pkey PRIMARY KEY (id);


--
-- Name: external_reference external_reference_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.external_reference
    ADD CONSTRAINT external_reference_pkey PRIMARY KEY (id);


--
-- Name: genome_map genome_map_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.genome_map
    ADD CONSTRAINT genome_map_pkey PRIMARY KEY (id);


--
-- Name: geojson geojson_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.geojson
    ADD CONSTRAINT geojson_pkey PRIMARY KEY (id);


--
-- Name: germplasm_attribute_definition germplasm_attribute_definition_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.germplasm_attribute_definition
    ADD CONSTRAINT germplasm_attribute_definition_pkey PRIMARY KEY (id);


--
-- Name: germplasm_attribute_value germplasm_attribute_value_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.germplasm_attribute_value
    ADD CONSTRAINT germplasm_attribute_value_pkey PRIMARY KEY (id);


--
-- Name: germplasm_donor germplasm_donor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.germplasm_donor
    ADD CONSTRAINT germplasm_donor_pkey PRIMARY KEY (id);


--
-- Name: germplasm_institute germplasm_institute_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.germplasm_institute
    ADD CONSTRAINT germplasm_institute_pkey PRIMARY KEY (id);


--
-- Name: germplasm_origin germplasm_origin_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.germplasm_origin
    ADD CONSTRAINT germplasm_origin_pkey PRIMARY KEY (id);


--
-- Name: germplasm germplasm_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.germplasm
    ADD CONSTRAINT germplasm_pkey PRIMARY KEY (id);


--
-- Name: germplasm_synonym germplasm_synonym_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.germplasm_synonym
    ADD CONSTRAINT germplasm_synonym_pkey PRIMARY KEY (id);


--
-- Name: germplasm_taxon germplasm_taxon_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.germplasm_taxon
    ADD CONSTRAINT germplasm_taxon_pkey PRIMARY KEY (id);


--
-- Name: image image_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.image
    ADD CONSTRAINT image_pkey PRIMARY KEY (id);


--
-- Name: linkage_group linkage_group_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.linkage_group
    ADD CONSTRAINT linkage_group_pkey PRIMARY KEY (id);


--
-- Name: list_item list_item_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.list_item
    ADD CONSTRAINT list_item_pkey PRIMARY KEY (id);


--
-- Name: list list_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.list
    ADD CONSTRAINT list_pkey PRIMARY KEY (id);


--
-- Name: location location_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.location
    ADD CONSTRAINT location_pkey PRIMARY KEY (id);


--
-- Name: marker_position marker_position_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.marker_position
    ADD CONSTRAINT marker_position_pkey PRIMARY KEY (id);


--
-- Name: method method_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.method
    ADD CONSTRAINT method_pkey PRIMARY KEY (id);


--
-- Name: observation observation_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.observation
    ADD CONSTRAINT observation_pkey PRIMARY KEY (id);


--
-- Name: observation_unit_level observation_unit_level_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.observation_unit_level
    ADD CONSTRAINT observation_unit_level_pkey PRIMARY KEY (id);


--
-- Name: observation_unit observation_unit_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.observation_unit
    ADD CONSTRAINT observation_unit_pkey PRIMARY KEY (id);


--
-- Name: observation_unit_position observation_unit_position_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.observation_unit_position
    ADD CONSTRAINT observation_unit_position_pkey PRIMARY KEY (id);


--
-- Name: observation_unit_treatment observation_unit_treatment_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.observation_unit_treatment
    ADD CONSTRAINT observation_unit_treatment_pkey PRIMARY KEY (id);


--
-- Name: observation_variable observation_variable_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.observation_variable
    ADD CONSTRAINT observation_variable_pkey PRIMARY KEY (id);


--
-- Name: ontology ontology_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ontology
    ADD CONSTRAINT ontology_pkey PRIMARY KEY (id);


--
-- Name: ontology_ref ontology_ref_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ontology_ref
    ADD CONSTRAINT ontology_ref_pkey PRIMARY KEY (id);


--
-- Name: pedigree_edge pedigree_edge_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedigree_edge
    ADD CONSTRAINT pedigree_edge_pkey PRIMARY KEY (id);


--
-- Name: pedigree_node pedigree_node_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedigree_node
    ADD CONSTRAINT pedigree_node_pkey PRIMARY KEY (id);


--
-- Name: person person_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.person
    ADD CONSTRAINT person_pkey PRIMARY KEY (id);


--
-- Name: plate plate_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.plate
    ADD CONSTRAINT plate_pkey PRIMARY KEY (id);


--
-- Name: plate_submission plate_submission_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.plate_submission
    ADD CONSTRAINT plate_submission_pkey PRIMARY KEY (id);


--
-- Name: program program_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.program
    ADD CONSTRAINT program_pkey PRIMARY KEY (id);


--
-- Name: reference_bases reference_bases_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reference_bases
    ADD CONSTRAINT reference_bases_pkey PRIMARY KEY (id);


--
-- Name: reference reference_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reference
    ADD CONSTRAINT reference_pkey PRIMARY KEY (id);


--
-- Name: reference_set reference_set_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reference_set
    ADD CONSTRAINT reference_set_pkey PRIMARY KEY (id);


--
-- Name: sample sample_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sample
    ADD CONSTRAINT sample_pkey PRIMARY KEY (id);


--
-- Name: scale scale_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.scale
    ADD CONSTRAINT scale_pkey PRIMARY KEY (id);


--
-- Name: scale_valid_value_category scale_valid_value_category_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.scale_valid_value_category
    ADD CONSTRAINT scale_valid_value_category_pkey PRIMARY KEY (id);


--
-- Name: search search_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.search
    ADD CONSTRAINT search_pkey PRIMARY KEY (id);


--
-- Name: season season_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.season
    ADD CONSTRAINT season_pkey PRIMARY KEY (id);


--
-- Name: seed_lot_content_mixture seed_lot_content_mixture_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.seed_lot_content_mixture
    ADD CONSTRAINT seed_lot_content_mixture_pkey PRIMARY KEY (id);


--
-- Name: seed_lot seed_lot_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.seed_lot
    ADD CONSTRAINT seed_lot_pkey PRIMARY KEY (id);


--
-- Name: seed_lot_transaction seed_lot_transaction_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.seed_lot_transaction
    ADD CONSTRAINT seed_lot_transaction_pkey PRIMARY KEY (id);


--
-- Name: study_data_link study_data_link_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.study_data_link
    ADD CONSTRAINT study_data_link_pkey PRIMARY KEY (id);


--
-- Name: study_environment_parameter study_environment_parameter_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.study_environment_parameter
    ADD CONSTRAINT study_environment_parameter_pkey PRIMARY KEY (id);


--
-- Name: study_experimental_design study_experimental_design_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.study_experimental_design
    ADD CONSTRAINT study_experimental_design_pkey PRIMARY KEY (id);


--
-- Name: study_growth_facility study_growth_facility_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.study_growth_facility
    ADD CONSTRAINT study_growth_facility_pkey PRIMARY KEY (id);


--
-- Name: study_last_update study_last_update_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.study_last_update
    ADD CONSTRAINT study_last_update_pkey PRIMARY KEY (id);


--
-- Name: study_observation_level study_observation_level_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.study_observation_level
    ADD CONSTRAINT study_observation_level_pkey PRIMARY KEY (id);


--
-- Name: study study_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.study
    ADD CONSTRAINT study_pkey PRIMARY KEY (id);


--
-- Name: trait_abbreviation trait_abbreviation_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.trait_abbreviation
    ADD CONSTRAINT trait_abbreviation_pkey PRIMARY KEY (id);


--
-- Name: trait trait_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.trait
    ADD CONSTRAINT trait_pkey PRIMARY KEY (id);


--
-- Name: trait_synonym trait_synonym_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.trait_synonym
    ADD CONSTRAINT trait_synonym_pkey PRIMARY KEY (id);


--
-- Name: trial_dataset_authorship trial_dataset_authorship_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.trial_dataset_authorship
    ADD CONSTRAINT trial_dataset_authorship_pkey PRIMARY KEY (id);


--
-- Name: trial trial_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.trial
    ADD CONSTRAINT trial_pkey PRIMARY KEY (id);


--
-- Name: trial_publication trial_publication_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.trial_publication
    ADD CONSTRAINT trial_publication_pkey PRIMARY KEY (id);


--
-- Name: method_ontology_reference uk_2o2ygrws59ot8awt3bespoboe; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.method_ontology_reference
    ADD CONSTRAINT uk_2o2ygrws59ot8awt3bespoboe UNIQUE (ontology_reference_id);


--
-- Name: trait_ontology_reference uk_6dpui3np8x0r3x6lku3jyuyts; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.trait_ontology_reference
    ADD CONSTRAINT uk_6dpui3np8x0r3x6lku3jyuyts UNIQUE (ontology_reference_id);


--
-- Name: scale_ontology_reference uk_ac9pepdho097g1h1uvpqspcdk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.scale_ontology_reference
    ADD CONSTRAINT uk_ac9pepdho097g1h1uvpqspcdk UNIQUE (ontology_reference_id);


--
-- Name: variable_base_entity_ontology_reference uk_b01mhfwes5mno4yqnews4dxht; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.variable_base_entity_ontology_reference
    ADD CONSTRAINT uk_b01mhfwes5mno4yqnews4dxht UNIQUE (ontology_reference_id);


--
-- Name: variable_base_entity variable_base_entity_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.variable_base_entity
    ADD CONSTRAINT variable_base_entity_pkey PRIMARY KEY (id);


--
-- Name: variant variant_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.variant
    ADD CONSTRAINT variant_pkey PRIMARY KEY (id);


--
-- Name: variantset_analysis variantset_analysis_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.variantset_analysis
    ADD CONSTRAINT variantset_analysis_pkey PRIMARY KEY (id);


--
-- Name: variantset_format variantset_format_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.variantset_format
    ADD CONSTRAINT variantset_format_pkey PRIMARY KEY (id);


--
-- Name: variantset variantset_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.variantset
    ADD CONSTRAINT variantset_pkey PRIMARY KEY (id);


--
-- Name: vendor_file vendor_file_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vendor_file
    ADD CONSTRAINT vendor_file_pkey PRIMARY KEY (id);


--
-- Name: vendor_order_entity_required_service_info vendor_order_entity_required_service_info_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vendor_order_entity_required_service_info
    ADD CONSTRAINT vendor_order_entity_required_service_info_pkey PRIMARY KEY (vendor_order_entity_id, required_service_info_key);


--
-- Name: vendor_order vendor_order_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vendor_order
    ADD CONSTRAINT vendor_order_pkey PRIMARY KEY (id);


--
-- Name: vendor_spec_deliverable vendor_spec_deliverable_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vendor_spec_deliverable
    ADD CONSTRAINT vendor_spec_deliverable_pkey PRIMARY KEY (id);


--
-- Name: vendor_spec_input_format vendor_spec_input_format_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vendor_spec_input_format
    ADD CONSTRAINT vendor_spec_input_format_pkey PRIMARY KEY (id);


--
-- Name: vendor_spec vendor_spec_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vendor_spec
    ADD CONSTRAINT vendor_spec_pkey PRIMARY KEY (id);


--
-- Name: vendor_spec_platform vendor_spec_platform_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vendor_spec_platform
    ADD CONSTRAINT vendor_spec_platform_pkey PRIMARY KEY (id);


--
-- Name: vendor_spec_requirement vendor_spec_requirement_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vendor_spec_requirement
    ADD CONSTRAINT vendor_spec_requirement_pkey PRIMARY KEY (id);


--
-- Name: vendor_spec_sample_type vendor_spec_sample_type_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vendor_spec_sample_type
    ADD CONSTRAINT vendor_spec_sample_type_pkey PRIMARY KEY (id);


--
-- Name: vendor_spec_status vendor_spec_status_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vendor_spec_status
    ADD CONSTRAINT vendor_spec_status_pkey PRIMARY KEY (id);


--
-- Name: vendor_spec_well_position vendor_spec_well_position_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vendor_spec_well_position
    ADD CONSTRAINT vendor_spec_well_position_pkey PRIMARY KEY (id);


--
-- Name: external_reference_composite; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX external_reference_composite ON public.external_reference USING btree (external_reference_source, external_reference_id);


--
-- Name: germplasm_external_references_germplasm_entity_id; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX germplasm_external_references_germplasm_entity_id ON public.germplasm_external_references USING btree (germplasm_entity_id);


--
-- Name: germplasm_synonym_germplasm_id; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX germplasm_synonym_germplasm_id ON public.germplasm_synonym USING btree (germplasm_id);


--
-- Name: germplasm_taxon_germplasm_id; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX germplasm_taxon_germplasm_id ON public.germplasm_taxon USING btree (germplasm_id);


--
-- Name: list_list_name; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX list_list_name ON public.list USING btree (list_name);


--
-- Name: pedigree_edge_connected_node_id; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX pedigree_edge_connected_node_id ON public.pedigree_edge USING btree (connceted_node_id);


--
-- Name: pedigree_edge_edge_type; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX pedigree_edge_edge_type ON public.pedigree_edge USING btree (edge_type);


--
-- Name: pedigree_edge_this_node_id; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX pedigree_edge_this_node_id ON public.pedigree_edge USING btree (this_node_id);


--
-- Name: pedigree_node_germplasm_id; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX pedigree_node_germplasm_id ON public.pedigree_node USING btree (germplasm_id);


--
-- Name: program_external_references_program_entity_id; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX program_external_references_program_entity_id ON public.program_external_references USING btree (program_entity_id);


--
-- Name: trial_external_references fk155y3dfx5kbikdaea1ev83f2q; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.trial_external_references
    ADD CONSTRAINT fk155y3dfx5kbikdaea1ev83f2q FOREIGN KEY (trial_entity_id) REFERENCES public.trial(id);


--
-- Name: vendor_order_external_references fk16n0vjl5dqid2b3q1q7jv2jrp; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vendor_order_external_references
    ADD CONSTRAINT fk16n0vjl5dqid2b3q1q7jv2jrp FOREIGN KEY (vendor_order_entity_id) REFERENCES public.vendor_order(id);


--
-- Name: linkage_group_external_references fk16nwhdphvsrkfo7ldgnsiikq4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.linkage_group_external_references
    ADD CONSTRAINT fk16nwhdphvsrkfo7ldgnsiikq4 FOREIGN KEY (external_references_id) REFERENCES public.external_reference(id);


--
-- Name: scale_ontology_reference fk1baxxkxrgpqqd5inp7rdl2ww6; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.scale_ontology_reference
    ADD CONSTRAINT fk1baxxkxrgpqqd5inp7rdl2ww6 FOREIGN KEY (ontology_reference_id) REFERENCES public.ontology_ref(id);


--
-- Name: observation_unit fk1bj7oq9sdtdy9sy73gj3lvxrg; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.observation_unit
    ADD CONSTRAINT fk1bj7oq9sdtdy9sy73gj3lvxrg FOREIGN KEY (trial_id) REFERENCES public.trial(id);


--
-- Name: sample fk1bqip06xsj05fdvhodjwta4i2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sample
    ADD CONSTRAINT fk1bqip06xsj05fdvhodjwta4i2 FOREIGN KEY (program_id) REFERENCES public.program(id);


--
-- Name: list_item fk1ddq3ct1ulogjn5ijs8ert7hw; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.list_item
    ADD CONSTRAINT fk1ddq3ct1ulogjn5ijs8ert7hw FOREIGN KEY (list_id) REFERENCES public.list(id);


--
-- Name: observation fk1hq66wld7ivshnikvlh2e3aal; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.observation
    ADD CONSTRAINT fk1hq66wld7ivshnikvlh2e3aal FOREIGN KEY (observation_variable_id) REFERENCES public.observation_variable(id);


--
-- Name: germplasm_origin fk1m54g844qt69f241brkregk05; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.germplasm_origin
    ADD CONSTRAINT fk1m54g844qt69f241brkregk05 FOREIGN KEY (germplasm_id) REFERENCES public.germplasm(id);


--
-- Name: study_season fk1r2518mglhwijy5mk31cfxh3h; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.study_season
    ADD CONSTRAINT fk1r2518mglhwijy5mk31cfxh3h FOREIGN KEY (study_db_id) REFERENCES public.study(id);


--
-- Name: observation fk1x98o95hroreu8udh810pyrsp; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.observation
    ADD CONSTRAINT fk1x98o95hroreu8udh810pyrsp FOREIGN KEY (geo_coordinates_id) REFERENCES public.geojson(id);


--
-- Name: cross_pollination_event fk1ypb9s2niakjr3ihaphptv091; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cross_pollination_event
    ADD CONSTRAINT fk1ypb9s2niakjr3ihaphptv091 FOREIGN KEY (cross_id) REFERENCES public.cross_entity(id);


--
-- Name: allele_call_external_references fk21j9fleiujdbdh1le1qxgvu76; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.allele_call_external_references
    ADD CONSTRAINT fk21j9fleiujdbdh1le1qxgvu76 FOREIGN KEY (external_references_id) REFERENCES public.external_reference(id);


--
-- Name: scale_ontology_reference fk23l4o7tx5iov7l8x61ektcvig; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.scale_ontology_reference
    ADD CONSTRAINT fk23l4o7tx5iov7l8x61ektcvig FOREIGN KEY (scale_entity_id) REFERENCES public.scale(id);


--
-- Name: event_observation_units fk24gave7q07chv8pklo27ffjvq; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.event_observation_units
    ADD CONSTRAINT fk24gave7q07chv8pklo27ffjvq FOREIGN KEY (event_entity_id) REFERENCES public.event(id);


--
-- Name: trait_external_references fk26xyvg9wub4k3iv7519mi4fm6; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.trait_external_references
    ADD CONSTRAINT fk26xyvg9wub4k3iv7519mi4fm6 FOREIGN KEY (trait_entity_id) REFERENCES public.trait(id);


--
-- Name: seed_lot_content_mixture fk27vg35ttok90l5a06j0pkcacm; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.seed_lot_content_mixture
    ADD CONSTRAINT fk27vg35ttok90l5a06j0pkcacm FOREIGN KEY (seed_lot_id) REFERENCES public.seed_lot(id);


--
-- Name: germplasm_attribute_value_external_references fk2c187mbrv5ib1a0cpdq82i2aw; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.germplasm_attribute_value_external_references
    ADD CONSTRAINT fk2c187mbrv5ib1a0cpdq82i2aw FOREIGN KEY (external_references_id) REFERENCES public.external_reference(id);


--
-- Name: plate_external_references fk2k8s555m1pytepl5wq7ajgyu; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.plate_external_references
    ADD CONSTRAINT fk2k8s555m1pytepl5wq7ajgyu FOREIGN KEY (external_references_id) REFERENCES public.external_reference(id);


--
-- Name: observation_unit_position fk2mpgvaq1ppb8kjp3jk0ecpdyr; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.observation_unit_position
    ADD CONSTRAINT fk2mpgvaq1ppb8kjp3jk0ecpdyr FOREIGN KEY (observation_unit_id) REFERENCES public.observation_unit(id);


--
-- Name: linkage_group_external_references fk2ngce8lv4jokyjhp72idxc4wp; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.linkage_group_external_references
    ADD CONSTRAINT fk2ngce8lv4jokyjhp72idxc4wp FOREIGN KEY (linkage_group_entity_id) REFERENCES public.linkage_group(id);


--
-- Name: genome_map fk2qfrqxw83mn6f9s4j6pl018s4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.genome_map
    ADD CONSTRAINT fk2qfrqxw83mn6f9s4j6pl018s4 FOREIGN KEY (crop_id) REFERENCES public.crop(id);


--
-- Name: vendor_file fk2sn16vflr7mjc9riwq7ee7fxk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vendor_file
    ADD CONSTRAINT fk2sn16vflr7mjc9riwq7ee7fxk FOREIGN KEY (order_id) REFERENCES public.vendor_order(id);


--
-- Name: observation_unit fk2u88bau3wx0bpb3f4lq0309vt; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.observation_unit
    ADD CONSTRAINT fk2u88bau3wx0bpb3f4lq0309vt FOREIGN KEY (seed_lot_id) REFERENCES public.seed_lot(id);


--
-- Name: cross_parent fk31xx5db8iq2y9mtv110qxvfwg; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cross_parent
    ADD CONSTRAINT fk31xx5db8iq2y9mtv110qxvfwg FOREIGN KEY (cross_id) REFERENCES public.cross_entity(id);


--
-- Name: image_external_references fk33bdd9xb6yxr8bnvov4shkx5a; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.image_external_references
    ADD CONSTRAINT fk33bdd9xb6yxr8bnvov4shkx5a FOREIGN KEY (external_references_id) REFERENCES public.external_reference(id);


--
-- Name: event_observation_units fk3ecq9fb2rd3qampc61hunr7sw; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.event_observation_units
    ADD CONSTRAINT fk3ecq9fb2rd3qampc61hunr7sw FOREIGN KEY (observation_units_id) REFERENCES public.observation_unit(id);


--
-- Name: germplasm_donor_external_references fk3hdirn24cor15lmm3syjj9pag; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.germplasm_donor_external_references
    ADD CONSTRAINT fk3hdirn24cor15lmm3syjj9pag FOREIGN KEY (external_references_id) REFERENCES public.external_reference(id);


--
-- Name: trial_publication fk3mtl83xv18xwseiuvrog2crft; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.trial_publication
    ADD CONSTRAINT fk3mtl83xv18xwseiuvrog2crft FOREIGN KEY (trial_id) REFERENCES public.trial(id);


--
-- Name: crop_external_references fk3nlkk7gvg1523b3lbsy2q1eec; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.crop_external_references
    ADD CONSTRAINT fk3nlkk7gvg1523b3lbsy2q1eec FOREIGN KEY (external_references_id) REFERENCES public.external_reference(id);


--
-- Name: marker_position_external_references fk3pnhmjxx9bqp3rl5lo3pgos1g; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.marker_position_external_references
    ADD CONSTRAINT fk3pnhmjxx9bqp3rl5lo3pgos1g FOREIGN KEY (external_references_id) REFERENCES public.external_reference(id);


--
-- Name: variable_base_entity fk3qk7upe0cpk9r8vkjwn82bigc; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.variable_base_entity
    ADD CONSTRAINT fk3qk7upe0cpk9r8vkjwn82bigc FOREIGN KEY (ontology_id) REFERENCES public.ontology(id);


--
-- Name: trial fk3qx9s6f3fgimmnmcw95djunib; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.trial
    ADD CONSTRAINT fk3qx9s6f3fgimmnmcw95djunib FOREIGN KEY (program_id) REFERENCES public.program(id);


--
-- Name: germplasm_attribute_value fk46y58bqrvcn0gymou6h0ypka8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.germplasm_attribute_value
    ADD CONSTRAINT fk46y58bqrvcn0gymou6h0ypka8 FOREIGN KEY (attribute_id) REFERENCES public.germplasm_attribute_definition(id);


--
-- Name: marker_position_external_references fk4akvkw4j7xa9xc3cwa8cr60if; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.marker_position_external_references
    ADD CONSTRAINT fk4akvkw4j7xa9xc3cwa8cr60if FOREIGN KEY (marker_position_entity_id) REFERENCES public.marker_position(id);


--
-- Name: cross_entity fk4f1fo4874si5ggfcpi8ui1p8x; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cross_entity
    ADD CONSTRAINT fk4f1fo4874si5ggfcpi8ui1p8x FOREIGN KEY (planned_cross_id) REFERENCES public.cross_entity(id);


--
-- Name: plate_submission_external_references fk4jlk3xi2ifr0b4jna9w4eu22u; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.plate_submission_external_references
    ADD CONSTRAINT fk4jlk3xi2ifr0b4jna9w4eu22u FOREIGN KEY (external_references_id) REFERENCES public.external_reference(id);


--
-- Name: vendor_spec_platform fk4jodgfv6misu1xqyo5j4285mm; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vendor_spec_platform
    ADD CONSTRAINT fk4jodgfv6misu1xqyo5j4285mm FOREIGN KEY (standard_requirements_id) REFERENCES public.vendor_spec_requirement(id);


--
-- Name: variable_base_entity_ontology_reference fk4kfhpym5gotqg7ebh9rxs7pli; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.variable_base_entity_ontology_reference
    ADD CONSTRAINT fk4kfhpym5gotqg7ebh9rxs7pli FOREIGN KEY (ontology_reference_id) REFERENCES public.ontology_ref(id);


--
-- Name: plate_submission_external_references fk4qkh6qsuqtjrp8hj73kn6h0su; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.plate_submission_external_references
    ADD CONSTRAINT fk4qkh6qsuqtjrp8hj73kn6h0su FOREIGN KEY (vendor_plate_submission_entity_id) REFERENCES public.plate_submission(id);


--
-- Name: variable_base_entity fk57jt68g5lrxm88511ytte8wgs; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.variable_base_entity
    ADD CONSTRAINT fk57jt68g5lrxm88511ytte8wgs FOREIGN KEY (method_id) REFERENCES public.method(id);


--
-- Name: genome_map_external_references fk59wyewdtq53rnxkn55grh1nin; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.genome_map_external_references
    ADD CONSTRAINT fk59wyewdtq53rnxkn55grh1nin FOREIGN KEY (external_references_id) REFERENCES public.external_reference(id);


--
-- Name: location_external_references fk5bqkr4t3ly4sxsx13i76iw55f; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.location_external_references
    ADD CONSTRAINT fk5bqkr4t3ly4sxsx13i76iw55f FOREIGN KEY (external_references_id) REFERENCES public.external_reference(id);


--
-- Name: pedigree_node fk5dmsm0lvenioadacb4gdvrv2q; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedigree_node
    ADD CONSTRAINT fk5dmsm0lvenioadacb4gdvrv2q FOREIGN KEY (crossing_project_id) REFERENCES public.crossing_project(id);


--
-- Name: pedigree_edge fk5ds4uo4f3tsurnjtc8dxb7w6r; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedigree_edge
    ADD CONSTRAINT fk5ds4uo4f3tsurnjtc8dxb7w6r FOREIGN KEY (connceted_node_id) REFERENCES public.pedigree_node(id);


--
-- Name: reference_external_references fk5nv26mmefckw1a3tilk3jvd58; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reference_external_references
    ADD CONSTRAINT fk5nv26mmefckw1a3tilk3jvd58 FOREIGN KEY (external_references_id) REFERENCES public.external_reference(id);


--
-- Name: allele_call fk5or2m3i1fuaq8btgm1dncqwqy; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.allele_call
    ADD CONSTRAINT fk5or2m3i1fuaq8btgm1dncqwqy FOREIGN KEY (variant_id) REFERENCES public.variant(id);


--
-- Name: method_external_references fk5sxdvhf5m5gvh04f4f1vubgh8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.method_external_references
    ADD CONSTRAINT fk5sxdvhf5m5gvh04f4f1vubgh8 FOREIGN KEY (method_entity_id) REFERENCES public.method(id);


--
-- Name: observation_unit fk5w9953xfgu6ktfwude521yhaj; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.observation_unit
    ADD CONSTRAINT fk5w9953xfgu6ktfwude521yhaj FOREIGN KEY (program_id) REFERENCES public.program(id);


--
-- Name: ontology_external_references fk60ha4xhme1qcj9qlef16x5uf4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ontology_external_references
    ADD CONSTRAINT fk60ha4xhme1qcj9qlef16x5uf4 FOREIGN KEY (ontology_entity_id) REFERENCES public.ontology(id);


--
-- Name: variable_base_entity_external_references fk61jsniwx483plyg24f7avmtbf; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.variable_base_entity_external_references
    ADD CONSTRAINT fk61jsniwx483plyg24f7avmtbf FOREIGN KEY (external_references_id) REFERENCES public.external_reference(id);


--
-- Name: germplasm_donor fk6e02we60r9ut32qqhxb86ca72; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.germplasm_donor
    ADD CONSTRAINT fk6e02we60r9ut32qqhxb86ca72 FOREIGN KEY (germplasm_id) REFERENCES public.germplasm(id);


--
-- Name: germplasm_search_results fk6ett5g30uvf3d4101e7ndoj8c; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.germplasm_search_results
    ADD CONSTRAINT fk6ett5g30uvf3d4101e7ndoj8c FOREIGN KEY (germplasm_entity_id) REFERENCES public.germplasm(id);


--
-- Name: study_experimental_design fk6p1eig0ibi880tu9yr3vd8yfn; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.study_experimental_design
    ADD CONSTRAINT fk6p1eig0ibi880tu9yr3vd8yfn FOREIGN KEY (study_id) REFERENCES public.study(id);


--
-- Name: sample fk6pcuvra9s7ysh4yn2tb6wq17c; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sample
    ADD CONSTRAINT fk6pcuvra9s7ysh4yn2tb6wq17c FOREIGN KEY (observation_unit_id) REFERENCES public.observation_unit(id);


--
-- Name: germplasm_search_results fk723l9hcq17n2o9ugya6acumrp; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.germplasm_search_results
    ADD CONSTRAINT fk723l9hcq17n2o9ugya6acumrp FOREIGN KEY (search_results_id) REFERENCES public.search(id);


--
-- Name: location fk736fp12vj9i045h2cky7v50ex; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.location
    ADD CONSTRAINT fk736fp12vj9i045h2cky7v50ex FOREIGN KEY (crop_id) REFERENCES public.crop(id);


--
-- Name: location_external_references fk74i4il2jg8ce0gi8evy3m9qto; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.location_external_references
    ADD CONSTRAINT fk74i4il2jg8ce0gi8evy3m9qto FOREIGN KEY (location_entity_id) REFERENCES public.location(id);


--
-- Name: observation_external_references fk7bawm29wrk4oska2qqc9pv01p; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.observation_external_references
    ADD CONSTRAINT fk7bawm29wrk4oska2qqc9pv01p FOREIGN KEY (observation_entity_id) REFERENCES public.observation(id);


--
-- Name: method fk7i2hysyf1rsfk7bmeh50hfqrm; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.method
    ADD CONSTRAINT fk7i2hysyf1rsfk7bmeh50hfqrm FOREIGN KEY (ontology_id) REFERENCES public.ontology(id);


--
-- Name: event_param fk7laguc0whfp46br0goxgkw6ry; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.event_param
    ADD CONSTRAINT fk7laguc0whfp46br0goxgkw6ry FOREIGN KEY (event_id) REFERENCES public.event(id);


--
-- Name: plate_external_references fk7waq4smg9jdsn9v87ovfn0irl; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.plate_external_references
    ADD CONSTRAINT fk7waq4smg9jdsn9v87ovfn0irl FOREIGN KEY (plate_entity_id) REFERENCES public.plate(id);


--
-- Name: program fk820kbw8w9s0ibrsfvw3apo6d2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.program
    ADD CONSTRAINT fk820kbw8w9s0ibrsfvw3apo6d2 FOREIGN KEY (crop_id) REFERENCES public.crop(id);


--
-- Name: trait_external_references fk83qwc6no22xekj3qoky28fjr; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.trait_external_references
    ADD CONSTRAINT fk83qwc6no22xekj3qoky28fjr FOREIGN KEY (external_references_id) REFERENCES public.external_reference(id);


--
-- Name: pedigree_edge_external_references fk89dwa6f22etyvwsl2r3hc56cj; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedigree_edge_external_references
    ADD CONSTRAINT fk89dwa6f22etyvwsl2r3hc56cj FOREIGN KEY (external_references_id) REFERENCES public.external_reference(id);


--
-- Name: pedigree_edge fk89pdbyb8xx3eua9b9i5cu5ltq; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedigree_edge
    ADD CONSTRAINT fk89pdbyb8xx3eua9b9i5cu5ltq FOREIGN KEY (this_node_id) REFERENCES public.pedigree_node(id);


--
-- Name: pedigree_edge_external_references fk8b66j4ff2axcsuosr5erotn8e; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedigree_edge_external_references
    ADD CONSTRAINT fk8b66j4ff2axcsuosr5erotn8e FOREIGN KEY (pedigree_edge_entity_id) REFERENCES public.pedigree_edge(id);


--
-- Name: observation_unit_level fk8iqhtkmddjbc4vhhf26ayx3b4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.observation_unit_level
    ADD CONSTRAINT fk8iqhtkmddjbc4vhhf26ayx3b4 FOREIGN KEY (observation_unit_id) REFERENCES public.observation_unit(id);


--
-- Name: observation_unit_position fk8nvp3yajleyeovdpi81pmrv82; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.observation_unit_position
    ADD CONSTRAINT fk8nvp3yajleyeovdpi81pmrv82 FOREIGN KEY (geo_coordinates_id) REFERENCES public.geojson(id);


--
-- Name: sample fk8p8p683y5axjauvbt4bgp0lly; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sample
    ADD CONSTRAINT fk8p8p683y5axjauvbt4bgp0lly FOREIGN KEY (trial_id) REFERENCES public.trial(id);


--
-- Name: seed_lot_transaction fk93w5dw8nj2fxxsow0ck0ila4w; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.seed_lot_transaction
    ADD CONSTRAINT fk93w5dw8nj2fxxsow0ck0ila4w FOREIGN KEY (from_seed_lot_id) REFERENCES public.seed_lot(id);


--
-- Name: observation_unit_treatment fk9aok9thr8d6dgqveur46e5985; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.observation_unit_treatment
    ADD CONSTRAINT fk9aok9thr8d6dgqveur46e5985 FOREIGN KEY (observation_unit_id) REFERENCES public.observation_unit(id);


--
-- Name: germplasm_donor_external_references fk9au08uldnexgd3f00hvq2rg8k; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.germplasm_donor_external_references
    ADD CONSTRAINT fk9au08uldnexgd3f00hvq2rg8k FOREIGN KEY (donor_entity_id) REFERENCES public.germplasm_donor(id);


--
-- Name: variant_entity_ciend fk9dsm85o8qltahmd03symbgohp; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.variant_entity_ciend
    ADD CONSTRAINT fk9dsm85o8qltahmd03symbgohp FOREIGN KEY (variant_entity_id) REFERENCES public.variant(id);


--
-- Name: reference_set_external_references fk9fslipqtjg4u9xj1wsx1tc1va; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reference_set_external_references
    ADD CONSTRAINT fk9fslipqtjg4u9xj1wsx1tc1va FOREIGN KEY (external_references_id) REFERENCES public.external_reference(id);


--
-- Name: germplasm_origin fk9i55glxpdu439oja1tx8mg8ia; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.germplasm_origin
    ADD CONSTRAINT fk9i55glxpdu439oja1tx8mg8ia FOREIGN KEY (coordinates_id) REFERENCES public.geojson(id);


--
-- Name: program_external_references fk9k5htwyl0rrhadlr2bvtb4ewh; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.program_external_references
    ADD CONSTRAINT fk9k5htwyl0rrhadlr2bvtb4ewh FOREIGN KEY (program_entity_id) REFERENCES public.program(id);


--
-- Name: location fk9s1sco601u8l6ptdxf432h4kb; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.location
    ADD CONSTRAINT fk9s1sco601u8l6ptdxf432h4kb FOREIGN KEY (parent_location_id) REFERENCES public.location(id);


--
-- Name: crossing_project_external_references fk9t5w8cd5pxjih4ipygqcs6rwo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.crossing_project_external_references
    ADD CONSTRAINT fk9t5w8cd5pxjih4ipygqcs6rwo FOREIGN KEY (crossing_project_entity_id) REFERENCES public.crossing_project(id);


--
-- Name: study fk9voefp8el048ula850imkkuiq; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.study
    ADD CONSTRAINT fk9voefp8el048ula850imkkuiq FOREIGN KEY (trial_id) REFERENCES public.trial(id);


--
-- Name: observation_variable fk_30b5d7sqaviwsotg5oayomelh; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.observation_variable
    ADD CONSTRAINT fk_30b5d7sqaviwsotg5oayomelh FOREIGN KEY (method_id) REFERENCES public.method(id);


--
-- Name: observation_variable fk_3ju23xr9v8171w7wesin5dqxw; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.observation_variable
    ADD CONSTRAINT fk_3ju23xr9v8171w7wesin5dqxw FOREIGN KEY (ontology_id) REFERENCES public.ontology(id);


--
-- Name: germplasm_attribute_definition fk_80yoy5kaofonf13682hspj62t; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.germplasm_attribute_definition
    ADD CONSTRAINT fk_80yoy5kaofonf13682hspj62t FOREIGN KEY (trait_id) REFERENCES public.trait(id);


--
-- Name: germplasm_attribute_definition fk_am7p3efyrwwysvpxl0ccj8mni; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.germplasm_attribute_definition
    ADD CONSTRAINT fk_am7p3efyrwwysvpxl0ccj8mni FOREIGN KEY (ontology_id) REFERENCES public.ontology(id);


--
-- Name: observation_variable fk_f0m8ifjjlmoym2p2abs0efk6j; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.observation_variable
    ADD CONSTRAINT fk_f0m8ifjjlmoym2p2abs0efk6j FOREIGN KEY (trait_id) REFERENCES public.trait(id);


--
-- Name: observation_variable fk_f98l70i69jgso1yousworitle; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.observation_variable
    ADD CONSTRAINT fk_f98l70i69jgso1yousworitle FOREIGN KEY (scale_id) REFERENCES public.scale(id);


--
-- Name: observation_variable fk_mns5ll4ybilsyxg20ksq514pk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.observation_variable
    ADD CONSTRAINT fk_mns5ll4ybilsyxg20ksq514pk FOREIGN KEY (crop_id) REFERENCES public.crop(id);


--
-- Name: germplasm_attribute_definition fk_nynfiem725rgq65kg99031j78; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.germplasm_attribute_definition
    ADD CONSTRAINT fk_nynfiem725rgq65kg99031j78 FOREIGN KEY (method_id) REFERENCES public.method(id);


--
-- Name: germplasm_attribute_definition fk_rs20ylp9ibjagoavfko13uq9n; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.germplasm_attribute_definition
    ADD CONSTRAINT fk_rs20ylp9ibjagoavfko13uq9n FOREIGN KEY (crop_id) REFERENCES public.crop(id);


--
-- Name: germplasm_attribute_definition fk_smngmu0eaqhppp1d4nqb9cy8o; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.germplasm_attribute_definition
    ADD CONSTRAINT fk_smngmu0eaqhppp1d4nqb9cy8o FOREIGN KEY (scale_id) REFERENCES public.scale(id);


--
-- Name: variable_base_entity fka5x8r7mfq04ttwj9ssls0uft4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.variable_base_entity
    ADD CONSTRAINT fka5x8r7mfq04ttwj9ssls0uft4 FOREIGN KEY (trait_id) REFERENCES public.trait(id);


--
-- Name: ontology_external_references fkajcue8iujp37clk05ly7huxus; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ontology_external_references
    ADD CONSTRAINT fkajcue8iujp37clk05ly7huxus FOREIGN KEY (external_references_id) REFERENCES public.external_reference(id);


--
-- Name: search_external_references fkasoj2adq9bhxyymm4cpukjhnw; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.search_external_references
    ADD CONSTRAINT fkasoj2adq9bhxyymm4cpukjhnw FOREIGN KEY (external_references_id) REFERENCES public.external_reference(id);


--
-- Name: event fkb21n9vqs7iyptt7vx6v6s2e07; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.event
    ADD CONSTRAINT fkb21n9vqs7iyptt7vx6v6s2e07 FOREIGN KEY (study_id) REFERENCES public.study(id);


--
-- Name: crop_external_references fkbin2gayn9sl8khd07gf1tv0j; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.crop_external_references
    ADD CONSTRAINT fkbin2gayn9sl8khd07gf1tv0j FOREIGN KEY (crop_entity_id) REFERENCES public.crop(id);


--
-- Name: reference_set_external_references fkbk2b1k68f0drytr6pkncudxoh; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reference_set_external_references
    ADD CONSTRAINT fkbk2b1k68f0drytr6pkncudxoh FOREIGN KEY (reference_set_entity_id) REFERENCES public.reference_set(id);


--
-- Name: breeding_method_external_references fkboc2lii67kdtey1frkcsatps6; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.breeding_method_external_references
    ADD CONSTRAINT fkboc2lii67kdtey1frkcsatps6 FOREIGN KEY (breeding_method_entity_id) REFERENCES public.breeding_method(id);


--
-- Name: trial_contact fkbpd4t24op9qhsh3vnljww0eo8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.trial_contact
    ADD CONSTRAINT fkbpd4t24op9qhsh3vnljww0eo8 FOREIGN KEY (person_db_id) REFERENCES public.person(id);


--
-- Name: sample_external_references fkbqjbcfol1ok5eci7kq2tyjx17; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sample_external_references
    ADD CONSTRAINT fkbqjbcfol1ok5eci7kq2tyjx17 FOREIGN KEY (external_references_id) REFERENCES public.external_reference(id);


--
-- Name: cross_entity_cross_attributes fkbunrh906gnkig3w246cxx037c; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cross_entity_cross_attributes
    ADD CONSTRAINT fkbunrh906gnkig3w246cxx037c FOREIGN KEY (cross_entity_id) REFERENCES public.cross_entity(id);


--
-- Name: image_observations fkbwiawjcj7mihofl5puuq7k2ws; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.image_observations
    ADD CONSTRAINT fkbwiawjcj7mihofl5puuq7k2ws FOREIGN KEY (image_entity_id) REFERENCES public.image(id);


--
-- Name: seed_lot_content_mixture fkc1gnrmj6ceuu1o4s6ffs4yjt3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.seed_lot_content_mixture
    ADD CONSTRAINT fkc1gnrmj6ceuu1o4s6ffs4yjt3 FOREIGN KEY (germplasm_id) REFERENCES public.germplasm(id);


--
-- Name: vendor_spec_external_references fkc3usn08w7ld6ii26stfy3acwn; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vendor_spec_external_references
    ADD CONSTRAINT fkc3usn08w7ld6ii26stfy3acwn FOREIGN KEY (external_references_id) REFERENCES public.external_reference(id);


--
-- Name: event_parameter_entity_values_by_date fkc45rvhmlblcxqdr96qm58cg45; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.event_parameter_entity_values_by_date
    ADD CONSTRAINT fkc45rvhmlblcxqdr96qm58cg45 FOREIGN KEY (event_parameter_entity_id) REFERENCES public.event_param(id);


--
-- Name: seed_lot fkc5lijily7i4rlqqgg6f0c11um; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.seed_lot
    ADD CONSTRAINT fkc5lijily7i4rlqqgg6f0c11um FOREIGN KEY (location_id) REFERENCES public.location(id);


--
-- Name: seed_lot_external_references fkcbgmrnalhithf1ba1usguxia3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.seed_lot_external_references
    ADD CONSTRAINT fkcbgmrnalhithf1ba1usguxia3 FOREIGN KEY (seed_lot_entity_id) REFERENCES public.seed_lot(id);


--
-- Name: image_entity_descriptive_ontology_terms fkce2lade5kp0pnd7dkps05s494; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.image_entity_descriptive_ontology_terms
    ADD CONSTRAINT fkce2lade5kp0pnd7dkps05s494 FOREIGN KEY (image_entity_id) REFERENCES public.image(id);


--
-- Name: study fkcgg6j1kp9h2noravxy8v0yfc0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.study
    ADD CONSTRAINT fkcgg6j1kp9h2noravxy8v0yfc0 FOREIGN KEY (program_id) REFERENCES public.program(id);


--
-- Name: variantset_external_references fkckhrweboc7ktl0e7obei7731f; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.variantset_external_references
    ADD CONSTRAINT fkckhrweboc7ktl0e7obei7731f FOREIGN KEY (variant_set_entity_id) REFERENCES public.variantset(id);


--
-- Name: seed_lot_transaction_external_references fkcmeans75yxjouc0a6t2ahsl6g; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.seed_lot_transaction_external_references
    ADD CONSTRAINT fkcmeans75yxjouc0a6t2ahsl6g FOREIGN KEY (external_references_id) REFERENCES public.external_reference(id);


--
-- Name: callset_external_references fkcmhdlkwcanmd21p8gepoi0n0u; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.callset_external_references
    ADD CONSTRAINT fkcmhdlkwcanmd21p8gepoi0n0u FOREIGN KEY (external_references_id) REFERENCES public.external_reference(id);


--
-- Name: observation fkcviusg5q0avmk5xv7nix9gxh0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.observation
    ADD CONSTRAINT fkcviusg5q0avmk5xv7nix9gxh0 FOREIGN KEY (trial_id) REFERENCES public.trial(id);


--
-- Name: germplasm_external_references fkd0ih09ntorrw8erucyh5m6sp2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.germplasm_external_references
    ADD CONSTRAINT fkd0ih09ntorrw8erucyh5m6sp2 FOREIGN KEY (germplasm_entity_id) REFERENCES public.germplasm(id);


--
-- Name: trial_dataset_authorship fkd13q53ipjrr22rkelycgxjio4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.trial_dataset_authorship
    ADD CONSTRAINT fkd13q53ipjrr22rkelycgxjio4 FOREIGN KEY (trial_id) REFERENCES public.trial(id);


--
-- Name: observation_unit fkdbndn6ma22quuinicrkjqofim; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.observation_unit
    ADD CONSTRAINT fkdbndn6ma22quuinicrkjqofim FOREIGN KEY (cross_id) REFERENCES public.cross_entity(id);


--
-- Name: coordinate fkdexqh6fwkb6wlewagkp7v1k98; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.coordinate
    ADD CONSTRAINT fkdexqh6fwkb6wlewagkp7v1k98 FOREIGN KEY (geojson_id) REFERENCES public.geojson(id);


--
-- Name: study_variable fkdg1qfle74hjs7s6a31j6poxs; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.study_variable
    ADD CONSTRAINT fkdg1qfle74hjs7s6a31j6poxs FOREIGN KEY (study_db_id) REFERENCES public.study(id);


--
-- Name: sample_external_references fkdjnhuxmo83frqm5o5bbkbnyxq; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sample_external_references
    ADD CONSTRAINT fkdjnhuxmo83frqm5o5bbkbnyxq FOREIGN KEY (sample_entity_id) REFERENCES public.sample(id);


--
-- Name: variant_external_references fkdnw738um7f4ikcxp1iq4jsbw6; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.variant_external_references
    ADD CONSTRAINT fkdnw738um7f4ikcxp1iq4jsbw6 FOREIGN KEY (external_references_id) REFERENCES public.external_reference(id);


--
-- Name: vendor_file_sample fke3tnyn895kve2kgixku4j7htb; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vendor_file_sample
    ADD CONSTRAINT fke3tnyn895kve2kgixku4j7htb FOREIGN KEY (sample_dbid) REFERENCES public.sample(id);


--
-- Name: event_external_references fke6ojv2849d07tagl2eslcujg9; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.event_external_references
    ADD CONSTRAINT fke6ojv2849d07tagl2eslcujg9 FOREIGN KEY (event_entity_id) REFERENCES public.event(id);


--
-- Name: observation_unit_external_references fkel9v1egnbmp20dpbkt1831ljq; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.observation_unit_external_references
    ADD CONSTRAINT fkel9v1egnbmp20dpbkt1831ljq FOREIGN KEY (observation_unit_entity_id) REFERENCES public.observation_unit(id);


--
-- Name: crossing_project fkellju38wp5gf7191sv55r9kxe; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.crossing_project
    ADD CONSTRAINT fkellju38wp5gf7191sv55r9kxe FOREIGN KEY (program_id) REFERENCES public.program(id);


--
-- Name: genome_map_studies fkemp13kog5jy1924s59shmweug; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.genome_map_studies
    ADD CONSTRAINT fkemp13kog5jy1924s59shmweug FOREIGN KEY (genome_map_entity_id) REFERENCES public.genome_map(id);


--
-- Name: trial_contact fkeqh9256ey5a136uatx4hu6gc4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.trial_contact
    ADD CONSTRAINT fkeqh9256ey5a136uatx4hu6gc4 FOREIGN KEY (trial_db_id) REFERENCES public.trial(id);


--
-- Name: observation fkf2si37d28257vfoa753hu5x1v; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.observation
    ADD CONSTRAINT fkf2si37d28257vfoa753hu5x1v FOREIGN KEY (program_id) REFERENCES public.program(id);


--
-- Name: observation_unit_external_references fkf3v8fqkjowvjos0ssmm2w8l30; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.observation_unit_external_references
    ADD CONSTRAINT fkf3v8fqkjowvjos0ssmm2w8l30 FOREIGN KEY (external_references_id) REFERENCES public.external_reference(id);


--
-- Name: reference_bases_external_references fkf6sny2j9k3hugyrp6iut22oo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reference_bases_external_references
    ADD CONSTRAINT fkf6sny2j9k3hugyrp6iut22oo FOREIGN KEY (reference_bases_page_entity_id) REFERENCES public.reference_bases(id);


--
-- Name: crossing_project_external_references fkfckwn44o1i8htq592o0s8hgac; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.crossing_project_external_references
    ADD CONSTRAINT fkfckwn44o1i8htq592o0s8hgac FOREIGN KEY (external_references_id) REFERENCES public.external_reference(id);


--
-- Name: pedigree_node_external_references fkfg0jmv1958u8qmsd796xft78w; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedigree_node_external_references
    ADD CONSTRAINT fkfg0jmv1958u8qmsd796xft78w FOREIGN KEY (pedigree_node_entity_id) REFERENCES public.pedigree_node(id);


--
-- Name: program fkfi6d6cc591slcqibawxp0m1pd; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.program
    ADD CONSTRAINT fkfi6d6cc591slcqibawxp0m1pd FOREIGN KEY (lead_person_id) REFERENCES public.person(id);


--
-- Name: season_external_references fkfpgrbaopdh4pg1x0v785g8kl9; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.season_external_references
    ADD CONSTRAINT fkfpgrbaopdh4pg1x0v785g8kl9 FOREIGN KEY (external_references_id) REFERENCES public.external_reference(id);


--
-- Name: observation fkfqw685lfh2uxxbgi60vne24jr; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.observation
    ADD CONSTRAINT fkfqw685lfh2uxxbgi60vne24jr FOREIGN KEY (observation_unit_id) REFERENCES public.observation_unit(id);


--
-- Name: scale fkfuvpau9fbqw8ukt0hpr1coxxb; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.scale
    ADD CONSTRAINT fkfuvpau9fbqw8ukt0hpr1coxxb FOREIGN KEY (ontology_id) REFERENCES public.ontology(id);


--
-- Name: person_external_references fkfxl2xseolst0sb8pci7o7yxy; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.person_external_references
    ADD CONSTRAINT fkfxl2xseolst0sb8pci7o7yxy FOREIGN KEY (person_entity_id) REFERENCES public.person(id);


--
-- Name: trait fkfy6vs593as3gs6tadmey5s2ad; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.trait
    ADD CONSTRAINT fkfy6vs593as3gs6tadmey5s2ad FOREIGN KEY (ontology_id) REFERENCES public.ontology(id);


--
-- Name: trial fkg0ovktlcm3w66xxj0m880rur9; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.trial
    ADD CONSTRAINT fkg0ovktlcm3w66xxj0m880rur9 FOREIGN KEY (crop_id) REFERENCES public.crop(id);


--
-- Name: variant_external_references fkgoibfri9bvwfh4jd8snqwcw5u; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.variant_external_references
    ADD CONSTRAINT fkgoibfri9bvwfh4jd8snqwcw5u FOREIGN KEY (variant_entity_id) REFERENCES public.variant(id);


--
-- Name: plate fkgt7xe0jip2aekvx0nei3t3s67; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.plate
    ADD CONSTRAINT fkgt7xe0jip2aekvx0nei3t3s67 FOREIGN KEY (submission_id) REFERENCES public.plate_submission(id);


--
-- Name: cross_parent fkgwne8ni7iqgxeu5qvnjskbkvj; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cross_parent
    ADD CONSTRAINT fkgwne8ni7iqgxeu5qvnjskbkvj FOREIGN KEY (germplasm_id) REFERENCES public.germplasm(id);


--
-- Name: sample fkgxtnyp78l7na5g0li648fy82u; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sample
    ADD CONSTRAINT fkgxtnyp78l7na5g0li648fy82u FOREIGN KEY (plate_id) REFERENCES public.plate(id);


--
-- Name: observation_unit fkgykwn3x9wx8m77wy67juqlxab; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.observation_unit
    ADD CONSTRAINT fkgykwn3x9wx8m77wy67juqlxab FOREIGN KEY (germplasm_id) REFERENCES public.germplasm(id);


--
-- Name: variant fkh523hkn6t8iurf19bb19o7px7; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.variant
    ADD CONSTRAINT fkh523hkn6t8iurf19bb19o7px7 FOREIGN KEY (reference_set_id) REFERENCES public.reference_set(id);


--
-- Name: observation_unit_level fkh70bs6tax01tl04ha9qjqo19; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.observation_unit_level
    ADD CONSTRAINT fkh70bs6tax01tl04ha9qjqo19 FOREIGN KEY (position_id) REFERENCES public.observation_unit_position(id);


--
-- Name: variant_entity_cipos fkh94uec6mbay6eld1uxk1m2xbi; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.variant_entity_cipos
    ADD CONSTRAINT fkh94uec6mbay6eld1uxk1m2xbi FOREIGN KEY (variant_entity_id) REFERENCES public.variant(id);


--
-- Name: trait_entity_alternative_abbreviations fkhattlnir8onuakl31y2yjxs4n; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.trait_entity_alternative_abbreviations
    ADD CONSTRAINT fkhattlnir8onuakl31y2yjxs4n FOREIGN KEY (trait_entity_id) REFERENCES public.trait(id);


--
-- Name: vendor_file_sample fkhb1jmpjfglf5idqj5rrkqvkg1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vendor_file_sample
    ADD CONSTRAINT fkhb1jmpjfglf5idqj5rrkqvkg1 FOREIGN KEY (verndor_file_dbid) REFERENCES public.vendor_file(id);


--
-- Name: vendor_order_entity_service_ids fkhh2skywan2uev483rj1gye45b; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vendor_order_entity_service_ids
    ADD CONSTRAINT fkhh2skywan2uev483rj1gye45b FOREIGN KEY (vendor_order_entity_id) REFERENCES public.vendor_order(id);


--
-- Name: study_growth_facility fkhie58olkxqm2t1ht6k5hl4wu5; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.study_growth_facility
    ADD CONSTRAINT fkhie58olkxqm2t1ht6k5hl4wu5 FOREIGN KEY (study_id) REFERENCES public.study(id);


--
-- Name: study_environment_parameter fkhkcbdh997uw56v7orukh2hssm; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.study_environment_parameter
    ADD CONSTRAINT fkhkcbdh997uw56v7orukh2hssm FOREIGN KEY (study_id) REFERENCES public.study(id);


--
-- Name: vendor_spec_external_references fkhnqmgqyaofwey1vm3ly1kr46k; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vendor_spec_external_references
    ADD CONSTRAINT fkhnqmgqyaofwey1vm3ly1kr46k FOREIGN KEY (vendor_spec_entity_id) REFERENCES public.vendor_spec(id);


--
-- Name: callset fkhreq22htrftm3dul7nfsg1agk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.callset
    ADD CONSTRAINT fkhreq22htrftm3dul7nfsg1agk FOREIGN KEY (sample_id) REFERENCES public.sample(id);


--
-- Name: genome_map_studies fkhs0xcw9lqe8ef55rotrlcr8o9; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.genome_map_studies
    ADD CONSTRAINT fkhs0xcw9lqe8ef55rotrlcr8o9 FOREIGN KEY (studies_id) REFERENCES public.study(id);


--
-- Name: seed_lot fkhwgjxt97ds2usyh8wmk4ec4qu; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.seed_lot
    ADD CONSTRAINT fkhwgjxt97ds2usyh8wmk4ec4qu FOREIGN KEY (program_id) REFERENCES public.program(id);


--
-- Name: variant fkhxdkan6bx84xlww89gy9wr9q8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.variant
    ADD CONSTRAINT fkhxdkan6bx84xlww89gy9wr9q8 FOREIGN KEY (variant_set_id) REFERENCES public.variantset(id);


--
-- Name: variant_entity_filters_failed fki10kljn84l12s881v3bxdh34n; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.variant_entity_filters_failed
    ADD CONSTRAINT fki10kljn84l12s881v3bxdh34n FOREIGN KEY (variant_entity_id) REFERENCES public.variant(id);


--
-- Name: marker_position fki54u4vxhiuwfqt3kxev1wdkvc; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.marker_position
    ADD CONSTRAINT fki54u4vxhiuwfqt3kxev1wdkvc FOREIGN KEY (linkage_group_id) REFERENCES public.linkage_group(id);


--
-- Name: study_season fki5yn2nqtqrw3mh1qoeyxxmyvp; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.study_season
    ADD CONSTRAINT fki5yn2nqtqrw3mh1qoeyxxmyvp FOREIGN KEY (season_db_id) REFERENCES public.season(id);


--
-- Name: trait_ontology_reference fki80mf7yhx7xoh3nt4tb0ptxg0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.trait_ontology_reference
    ADD CONSTRAINT fki80mf7yhx7xoh3nt4tb0ptxg0 FOREIGN KEY (ontology_reference_id) REFERENCES public.ontology_ref(id);


--
-- Name: germplasm_attribute_value_external_references fki9jmov5fpss3lmix8fvknrp84; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.germplasm_attribute_value_external_references
    ADD CONSTRAINT fki9jmov5fpss3lmix8fvknrp84 FOREIGN KEY (germplasm_attribute_value_entity_id) REFERENCES public.germplasm_attribute_value(id);


--
-- Name: germplasm_external_references fkibd3k0wfmkkjf2budoeothsub; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.germplasm_external_references
    ADD CONSTRAINT fkibd3k0wfmkkjf2budoeothsub FOREIGN KEY (external_references_id) REFERENCES public.external_reference(id);


--
-- Name: germplasm fkifyh81snysy9bac2tus48jfs5; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.germplasm
    ADD CONSTRAINT fkifyh81snysy9bac2tus48jfs5 FOREIGN KEY (crop_id) REFERENCES public.crop(id);


--
-- Name: event_external_references fkig2468c6y0c60t4e0coso0ap2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.event_external_references
    ADD CONSTRAINT fkig2468c6y0c60t4e0coso0ap2 FOREIGN KEY (external_references_id) REFERENCES public.external_reference(id);


--
-- Name: observation fkigyb0oa6sjfhgmtlspflau9hb; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.observation
    ADD CONSTRAINT fkigyb0oa6sjfhgmtlspflau9hb FOREIGN KEY (crop_id) REFERENCES public.crop(id);


--
-- Name: plate fkihx8xx6p59h4rkgsd2qa5vyia; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.plate
    ADD CONSTRAINT fkihx8xx6p59h4rkgsd2qa5vyia FOREIGN KEY (study_id) REFERENCES public.study(id);


--
-- Name: list fkimr1m8xoms2ntm15lmaruf04u; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.list
    ADD CONSTRAINT fkimr1m8xoms2ntm15lmaruf04u FOREIGN KEY (list_owner_person_id) REFERENCES public.person(id);


--
-- Name: scale_valid_value_category fkjhq7himmbn2jaku9qvpfq3vkd; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.scale_valid_value_category
    ADD CONSTRAINT fkjhq7himmbn2jaku9qvpfq3vkd FOREIGN KEY (scale_id) REFERENCES public.scale(id);


--
-- Name: seed_lot_transaction_external_references fkjsg1potilwjdyt0uk3jmx5nv0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.seed_lot_transaction_external_references
    ADD CONSTRAINT fkjsg1potilwjdyt0uk3jmx5nv0 FOREIGN KEY (seed_lot_transaction_entity_id) REFERENCES public.seed_lot_transaction(id);


--
-- Name: cross_entity_external_references fkjumsck59h4jv2ph2fhwfmbi2d; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cross_entity_external_references
    ADD CONSTRAINT fkjumsck59h4jv2ph2fhwfmbi2d FOREIGN KEY (external_references_id) REFERENCES public.external_reference(id);


--
-- Name: cross_entity fkjyf7evdes66v72l9add0i7ukj; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cross_entity
    ADD CONSTRAINT fkjyf7evdes66v72l9add0i7ukj FOREIGN KEY (crossing_project_id) REFERENCES public.crossing_project(id);


--
-- Name: observation fkk47naotiec0cw7kpboyfbu4b1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.observation
    ADD CONSTRAINT fkk47naotiec0cw7kpboyfbu4b1 FOREIGN KEY (season_id) REFERENCES public.season(id);


--
-- Name: image_observations fkk8m5ehyf7axe6q7u560kvm68s; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.image_observations
    ADD CONSTRAINT fkk8m5ehyf7axe6q7u560kvm68s FOREIGN KEY (observations_id) REFERENCES public.observation(id);


--
-- Name: germplasm_institute fkk9yp3d2siqb14sw6gvvrcspo6; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.germplasm_institute
    ADD CONSTRAINT fkk9yp3d2siqb14sw6gvvrcspo6 FOREIGN KEY (germplasm_id) REFERENCES public.germplasm(id);


--
-- Name: sample fkkbdme00c5ep0xx088cjvgh4i7; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sample
    ADD CONSTRAINT fkkbdme00c5ep0xx088cjvgh4i7 FOREIGN KEY (study_id) REFERENCES public.study(id);


--
-- Name: search_external_references fkkkrkct3cg8r8tdjpdagavq98l; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.search_external_references
    ADD CONSTRAINT fkkkrkct3cg8r8tdjpdagavq98l FOREIGN KEY (search_request_entity_id) REFERENCES public.search(id);


--
-- Name: genome_map_external_references fkklkrodon3modvk940abdpec5w; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.genome_map_external_references
    ADD CONSTRAINT fkklkrodon3modvk940abdpec5w FOREIGN KEY (genome_map_entity_id) REFERENCES public.genome_map(id);


--
-- Name: pedigree_node fkkll27h6pngksanbpu2dnnldbt; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedigree_node
    ADD CONSTRAINT fkkll27h6pngksanbpu2dnnldbt FOREIGN KEY (germplasm_id) REFERENCES public.germplasm(id);


--
-- Name: germplasm_synonym fkkm9j9i32axrnrs34qr9q6a63n; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.germplasm_synonym
    ADD CONSTRAINT fkkm9j9i32axrnrs34qr9q6a63n FOREIGN KEY (germplasm_id) REFERENCES public.germplasm(id);


--
-- Name: plate fkky4n35tyqgvf2hwq6958yo765; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.plate
    ADD CONSTRAINT fkky4n35tyqgvf2hwq6958yo765 FOREIGN KEY (trial_id) REFERENCES public.trial(id);


--
-- Name: scale_external_references fkl6qe8r2q05fnm5qdkpn694ii5; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.scale_external_references
    ADD CONSTRAINT fkl6qe8r2q05fnm5qdkpn694ii5 FOREIGN KEY (external_references_id) REFERENCES public.external_reference(id);


--
-- Name: method_external_references fkl88hj87dhueu846uo3qpqq4kt; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.method_external_references
    ADD CONSTRAINT fkl88hj87dhueu846uo3qpqq4kt FOREIGN KEY (external_references_id) REFERENCES public.external_reference(id);


--
-- Name: list_external_references fkl9fy5r4gkrlqm2woq1rh896vy; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.list_external_references
    ADD CONSTRAINT fkl9fy5r4gkrlqm2woq1rh896vy FOREIGN KEY (external_references_id) REFERENCES public.external_reference(id);


--
-- Name: trait_entity_synonyms fkla1w2g0gglyqr1gk7s4v59y7m; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.trait_entity_synonyms
    ADD CONSTRAINT fkla1w2g0gglyqr1gk7s4v59y7m FOREIGN KEY (trait_entity_id) REFERENCES public.trait(id);


--
-- Name: study_contact fklcxxwlmhrlueccix1jwq3i4ul; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.study_contact
    ADD CONSTRAINT fklcxxwlmhrlueccix1jwq3i4ul FOREIGN KEY (person_db_id) REFERENCES public.person(id);


--
-- Name: cross_entity_external_references fklk5hdqw7j3kqrpxivdt9yk05o; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cross_entity_external_references
    ADD CONSTRAINT fklk5hdqw7j3kqrpxivdt9yk05o FOREIGN KEY (cross_entity_id) REFERENCES public.cross_entity(id);


--
-- Name: allele_call fklqve9ddl8olner2kkr6rd4003; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.allele_call
    ADD CONSTRAINT fklqve9ddl8olner2kkr6rd4003 FOREIGN KEY (call_set_id) REFERENCES public.callset(id);


--
-- Name: callset_variant_sets fklr5bx5nvhchf67cioqakfbu9v; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.callset_variant_sets
    ADD CONSTRAINT fklr5bx5nvhchf67cioqakfbu9v FOREIGN KEY (call_sets_id) REFERENCES public.callset(id);


--
-- Name: person_external_references fklwdf8wu424ly5u7umqsn20tnc; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.person_external_references
    ADD CONSTRAINT fklwdf8wu424ly5u7umqsn20tnc FOREIGN KEY (external_references_id) REFERENCES public.external_reference(id);


--
-- Name: ontology_entity_documentation_links fkm0elv2jxmknlgb0ov2q7cv5e7; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ontology_entity_documentation_links
    ADD CONSTRAINT fkm0elv2jxmknlgb0ov2q7cv5e7 FOREIGN KEY (ontology_entity_id) REFERENCES public.ontology(id);


--
-- Name: seed_lot_external_references fkm5uee4kohmp1o1lrv9v9ah0d4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.seed_lot_external_references
    ADD CONSTRAINT fkm5uee4kohmp1o1lrv9v9ah0d4 FOREIGN KEY (external_references_id) REFERENCES public.external_reference(id);


--
-- Name: vendor_order_external_references fkm75b25x59xcl6u06ovhqd4ag1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vendor_order_external_references
    ADD CONSTRAINT fkm75b25x59xcl6u06ovhqd4ag1 FOREIGN KEY (external_references_id) REFERENCES public.external_reference(id);


--
-- Name: seed_lot_content_mixture fkmg21xechkkguugmc975qwm7u0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.seed_lot_content_mixture
    ADD CONSTRAINT fkmg21xechkkguugmc975qwm7u0 FOREIGN KEY (cross_id) REFERENCES public.cross_entity(id);


--
-- Name: sample fkmr8ueym2af0w8udonxhb8odix; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sample
    ADD CONSTRAINT fkmr8ueym2af0w8udonxhb8odix FOREIGN KEY (taxon_id_id) REFERENCES public.germplasm_taxon(id);


--
-- Name: study fkmw17bwnsc3wjy5emvknrepdha; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.study
    ADD CONSTRAINT fkmw17bwnsc3wjy5emvknrepdha FOREIGN KEY (crop_id) REFERENCES public.crop(id);


--
-- Name: variantset fkmycnt85wyf9x7q45h9wjy0ehj; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.variantset
    ADD CONSTRAINT fkmycnt85wyf9x7q45h9wjy0ehj FOREIGN KEY (study_id) REFERENCES public.study(id);


--
-- Name: program_external_references fkn3popdlu288xgpk4wdokwqhhi; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.program_external_references
    ADD CONSTRAINT fkn3popdlu288xgpk4wdokwqhhi FOREIGN KEY (external_references_id) REFERENCES public.external_reference(id);


--
-- Name: callset_variant_sets fkn62gqkvd24fje4tsoy7i64gyc; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.callset_variant_sets
    ADD CONSTRAINT fkn62gqkvd24fje4tsoy7i64gyc FOREIGN KEY (variant_sets_id) REFERENCES public.variantset(id);


--
-- Name: study_variable fkn8qb3ddd0tshid66qlgdxgssc; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.study_variable
    ADD CONSTRAINT fkn8qb3ddd0tshid66qlgdxgssc FOREIGN KEY (variable_db_id) REFERENCES public.observation_variable(id);


--
-- Name: cross_parent fknc44kejsxwb41pqybibfkrfgd; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cross_parent
    ADD CONSTRAINT fknc44kejsxwb41pqybibfkrfgd FOREIGN KEY (observation_unit_id) REFERENCES public.observation_unit(id);


--
-- Name: reference_bases_external_references fkndb5wyyy87tyaa9g6k0rkxbf3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reference_bases_external_references
    ADD CONSTRAINT fkndb5wyyy87tyaa9g6k0rkxbf3 FOREIGN KEY (external_references_id) REFERENCES public.external_reference(id);


--
-- Name: vendor_order_entity_required_service_info fkneogvedbrwyxf523kexb0wvh8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vendor_order_entity_required_service_info
    ADD CONSTRAINT fkneogvedbrwyxf523kexb0wvh8 FOREIGN KEY (vendor_order_entity_id) REFERENCES public.vendor_order(id);


--
-- Name: study_data_link fknhgb2dwb4ffbsmydrhmephyyd; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.study_data_link
    ADD CONSTRAINT fknhgb2dwb4ffbsmydrhmephyyd FOREIGN KEY (study_id) REFERENCES public.study(id);


--
-- Name: variant_set_analysis_entity_software fknx3gnntbonjgjc55csk4bqejb; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.variant_set_analysis_entity_software
    ADD CONSTRAINT fknx3gnntbonjgjc55csk4bqejb FOREIGN KEY (variant_set_analysis_entity_id) REFERENCES public.variantset_analysis(id);


--
-- Name: germplasm fknyyqkkcjus7hj9jmhu0k6xa83; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.germplasm
    ADD CONSTRAINT fknyyqkkcjus7hj9jmhu0k6xa83 FOREIGN KEY (breeding_method_id) REFERENCES public.breeding_method(id);


--
-- Name: reference_set fko1ndd24soyk8191bqhg7fegdg; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reference_set
    ADD CONSTRAINT fko1ndd24soyk8191bqhg7fegdg FOREIGN KEY (source_germplasm_id) REFERENCES public.germplasm(id);


--
-- Name: variantset_analysis fko9jtegpt029eaca8mifd8yrm4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.variantset_analysis
    ADD CONSTRAINT fko9jtegpt029eaca8mifd8yrm4 FOREIGN KEY (variant_set_id) REFERENCES public.variantset(id);


--
-- Name: image fkob3t0l8jr07byg0p3vd06yig4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.image
    ADD CONSTRAINT fkob3t0l8jr07byg0p3vd06yig4 FOREIGN KEY (observation_unit_id) REFERENCES public.observation_unit(id);


--
-- Name: marker_position fkocqa1yc7162ddvaivrsuun0mb; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.marker_position
    ADD CONSTRAINT fkocqa1yc7162ddvaivrsuun0mb FOREIGN KEY (variant_id) REFERENCES public.variant(id);


--
-- Name: variable_base_entity fkoe75mtivumaw982qae8jqwkjl; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.variable_base_entity
    ADD CONSTRAINT fkoe75mtivumaw982qae8jqwkjl FOREIGN KEY (crop_id) REFERENCES public.crop(id);


--
-- Name: study_last_update fkogmwhwbr1qx6vr1qr1nh6owpp; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.study_last_update
    ADD CONSTRAINT fkogmwhwbr1qx6vr1qr1nh6owpp FOREIGN KEY (study_id) REFERENCES public.study(id);


--
-- Name: study_contact fkojmdovj11j3s8qxewlfjuw08y; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.study_contact
    ADD CONSTRAINT fkojmdovj11j3s8qxewlfjuw08y FOREIGN KEY (study_db_id) REFERENCES public.study(id);


--
-- Name: germplasm_taxon fkokfpuhyosimp5gdloucr73vja; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.germplasm_taxon
    ADD CONSTRAINT fkokfpuhyosimp5gdloucr73vja FOREIGN KEY (germplasm_id) REFERENCES public.germplasm(id);


--
-- Name: method_ontology_reference fkolyxojh3ugs13hjipaycjfkmv; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.method_ontology_reference
    ADD CONSTRAINT fkolyxojh3ugs13hjipaycjfkmv FOREIGN KEY (method_entity_id) REFERENCES public.method(id);


--
-- Name: location fkow7as0lg8ttlh4d5chs81y46; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.location
    ADD CONSTRAINT fkow7as0lg8ttlh4d5chs81y46 FOREIGN KEY (program_id) REFERENCES public.program(id);


--
-- Name: variantset fkoy17h5s7f83vl8rfcpeqduhp3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.variantset
    ADD CONSTRAINT fkoy17h5s7f83vl8rfcpeqduhp3 FOREIGN KEY (reference_set_id) REFERENCES public.reference_set(id);


--
-- Name: plate_submission fkp6b3ib0xl55upbyhk3fm15r1q; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.plate_submission
    ADD CONSTRAINT fkp6b3ib0xl55upbyhk3fm15r1q FOREIGN KEY (order_id) REFERENCES public.vendor_order(id);


--
-- Name: scale_external_references fkp6jdfm8j68sdcffih55dq6ypb; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.scale_external_references
    ADD CONSTRAINT fkp6jdfm8j68sdcffih55dq6ypb FOREIGN KEY (scale_entity_id) REFERENCES public.scale(id);


--
-- Name: breeding_method_external_references fkpm6iyumy3nlcpp2ja4djklvge; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.breeding_method_external_references
    ADD CONSTRAINT fkpm6iyumy3nlcpp2ja4djklvge FOREIGN KEY (external_references_id) REFERENCES public.external_reference(id);


--
-- Name: observation fkpq3oyu9tuqcttfj2dutdvgv4d; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.observation
    ADD CONSTRAINT fkpq3oyu9tuqcttfj2dutdvgv4d FOREIGN KEY (study_id) REFERENCES public.study(id);


--
-- Name: reference fkpr6hqcaxgwgl0uom9wo22om65; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reference
    ADD CONSTRAINT fkpr6hqcaxgwgl0uom9wo22om65 FOREIGN KEY (reference_set_id) REFERENCES public.reference_set(id);


--
-- Name: list_external_references fkpumhc5eurjfeva73tg03qo5s4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.list_external_references
    ADD CONSTRAINT fkpumhc5eurjfeva73tg03qo5s4 FOREIGN KEY (list_entity_id) REFERENCES public.list(id);


--
-- Name: cross_parent fkq11y3b8pxp3whpa8vihf9yr7; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cross_parent
    ADD CONSTRAINT fkq11y3b8pxp3whpa8vihf9yr7 FOREIGN KEY (crossing_project_id) REFERENCES public.crossing_project(id);


--
-- Name: study_observation_level fkq886b0f9213w91opmlha96b0g; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.study_observation_level
    ADD CONSTRAINT fkq886b0f9213w91opmlha96b0g FOREIGN KEY (study_id) REFERENCES public.study(id);


--
-- Name: callset_external_references fkq8ectsigj1r23lx3isjwrxqml; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.callset_external_references
    ADD CONSTRAINT fkq8ectsigj1r23lx3isjwrxqml FOREIGN KEY (call_set_entity_id) REFERENCES public.callset(id);


--
-- Name: trial_external_references fkq93pukjnqegcdixpqb54jdjbl; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.trial_external_references
    ADD CONSTRAINT fkq93pukjnqegcdixpqb54jdjbl FOREIGN KEY (external_references_id) REFERENCES public.external_reference(id);


--
-- Name: seed_lot_transaction fkqbk3jxmv73a38qv214gf2awq7; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.seed_lot_transaction
    ADD CONSTRAINT fkqbk3jxmv73a38qv214gf2awq7 FOREIGN KEY (to_seed_lot_id) REFERENCES public.seed_lot(id);


--
-- Name: image fkqgoqu922hdv3ggb0amnct2muc; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.image
    ADD CONSTRAINT fkqgoqu922hdv3ggb0amnct2muc FOREIGN KEY (coordinates_id) REFERENCES public.geojson(id);


--
-- Name: study_external_references fkqpn1n6famc9dkaf5bjalj914d; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.study_external_references
    ADD CONSTRAINT fkqpn1n6famc9dkaf5bjalj914d FOREIGN KEY (external_references_id) REFERENCES public.external_reference(id);


--
-- Name: germplasm_attribute_value fkqqry5v3us53yf0o4dlcd7dxg8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.germplasm_attribute_value
    ADD CONSTRAINT fkqqry5v3us53yf0o4dlcd7dxg8 FOREIGN KEY (germplasm_id) REFERENCES public.germplasm(id);


--
-- Name: event_entity_dates fkqu00khnwvqd2wgxdxa0kp7th0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.event_entity_dates
    ADD CONSTRAINT fkqu00khnwvqd2wgxdxa0kp7th0 FOREIGN KEY (event_entity_id) REFERENCES public.event(id);


--
-- Name: plate fkquqjxsw3cp462nlrpcb9dp6d7; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.plate
    ADD CONSTRAINT fkquqjxsw3cp462nlrpcb9dp6d7 FOREIGN KEY (program_id) REFERENCES public.program(id);


--
-- Name: reference_external_references fkr0nxjwbpehkbp8vfg3xyql5vy; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reference_external_references
    ADD CONSTRAINT fkr0nxjwbpehkbp8vfg3xyql5vy FOREIGN KEY (reference_entity_id) REFERENCES public.reference(id);


--
-- Name: observation_unit fkra6qtii65bohk2l3hu14ocb91; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.observation_unit
    ADD CONSTRAINT fkra6qtii65bohk2l3hu14ocb91 FOREIGN KEY (study_id) REFERENCES public.study(id);


--
-- Name: trait_abbreviation fkrar3erhikad78x1vsh6uvp2aw; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.trait_abbreviation
    ADD CONSTRAINT fkrar3erhikad78x1vsh6uvp2aw FOREIGN KEY (trait_id) REFERENCES public.trait(id);


--
-- Name: trait_synonym fkrdvotrungvhk06df1kx4bo7mb; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.trait_synonym
    ADD CONSTRAINT fkrdvotrungvhk06df1kx4bo7mb FOREIGN KEY (trait_id) REFERENCES public.trait(id);


--
-- Name: observation_external_references fkrfoobkjhj680bao4o0o1f96ke; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.observation_external_references
    ADD CONSTRAINT fkrfoobkjhj680bao4o0o1f96ke FOREIGN KEY (external_references_id) REFERENCES public.external_reference(id);


--
-- Name: reference_bases fkro4r722mjgl8huj88soea80le; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reference_bases
    ADD CONSTRAINT fkro4r722mjgl8huj88soea80le FOREIGN KEY (reference_id) REFERENCES public.reference(id);


--
-- Name: linkage_group fkrogxv436q8e7entpcc94q7x2k; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.linkage_group
    ADD CONSTRAINT fkrogxv436q8e7entpcc94q7x2k FOREIGN KEY (genome_map_id) REFERENCES public.genome_map(id);


--
-- Name: location fks18k8b2w156hg5m57b7r35fp9; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.location
    ADD CONSTRAINT fks18k8b2w156hg5m57b7r35fp9 FOREIGN KEY (coordinates_id) REFERENCES public.geojson(id);


--
-- Name: allele_call_external_references fks1ixxwy7h24uq46yj7tfuc0o4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.allele_call_external_references
    ADD CONSTRAINT fks1ixxwy7h24uq46yj7tfuc0o4 FOREIGN KEY (call_entity_id) REFERENCES public.allele_call(id);


--
-- Name: variantset_external_references fks1o96o9fb86ulu0el5om4nkmd; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.variantset_external_references
    ADD CONSTRAINT fks1o96o9fb86ulu0el5om4nkmd FOREIGN KEY (external_references_id) REFERENCES public.external_reference(id);


--
-- Name: variantset_format fkse2qx2lkfhnb00nnoexcpa1fu; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.variantset_format
    ADD CONSTRAINT fkse2qx2lkfhnb00nnoexcpa1fu FOREIGN KEY (variant_set_id) REFERENCES public.variantset(id);


--
-- Name: study fksfltd06jhrx1cyh72tpyh2d5r; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.study
    ADD CONSTRAINT fksfltd06jhrx1cyh72tpyh2d5r FOREIGN KEY (location_id) REFERENCES public.location(id);


--
-- Name: study_external_references fksj8raswfnpyuh1fwf8yfu53qk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.study_external_references
    ADD CONSTRAINT fksj8raswfnpyuh1fwf8yfu53qk FOREIGN KEY (study_entity_id) REFERENCES public.study(id);


--
-- Name: pedigree_node_external_references fksoj94vfgyng2d5bhwkautd8nl; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedigree_node_external_references
    ADD CONSTRAINT fksoj94vfgyng2d5bhwkautd8nl FOREIGN KEY (external_references_id) REFERENCES public.external_reference(id);


--
-- Name: trait_ontology_reference fksxd4d5p4m8xhvsguxfxonqck; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.trait_ontology_reference
    ADD CONSTRAINT fksxd4d5p4m8xhvsguxfxonqck FOREIGN KEY (trait_entity_id) REFERENCES public.trait(id);


--
-- Name: method_ontology_reference fkt187lniiq4ulw2hbyd7jrxkii; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.method_ontology_reference
    ADD CONSTRAINT fkt187lniiq4ulw2hbyd7jrxkii FOREIGN KEY (ontology_reference_id) REFERENCES public.ontology_ref(id);


--
-- Name: variable_base_entity fkt231xoex97i7luntla7du6guv; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.variable_base_entity
    ADD CONSTRAINT fkt231xoex97i7luntla7du6guv FOREIGN KEY (scale_id) REFERENCES public.scale(id);


--
-- Name: image_external_references fkt3uy354jynflg06911dxjlu1i; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.image_external_references
    ADD CONSTRAINT fkt3uy354jynflg06911dxjlu1i FOREIGN KEY (image_entity_id) REFERENCES public.image(id);


--
-- Name: germplasm_entity_type_of_germplasm_storage_code fktahnvan5u79myt3kbqkijra78; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.germplasm_entity_type_of_germplasm_storage_code
    ADD CONSTRAINT fktahnvan5u79myt3kbqkijra78 FOREIGN KEY (germplasm_entity_id) REFERENCES public.germplasm(id);


--
-- Name: season_external_references fktd03hbghqblpq7ril3on0tbvk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.season_external_references
    ADD CONSTRAINT fktd03hbghqblpq7ril3on0tbvk FOREIGN KEY (season_entity_id) REFERENCES public.season(id);


--
-- Name: observation_unit fkueu3tfebsye6drsenqw297bi; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.observation_unit
    ADD CONSTRAINT fkueu3tfebsye6drsenqw297bi FOREIGN KEY (crop_id) REFERENCES public.crop(id);


--
-- Name: variant_entity_alternate_bases fkv6ptn907aedytbh5w8mc6t3r; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.variant_entity_alternate_bases
    ADD CONSTRAINT fkv6ptn907aedytbh5w8mc6t3r FOREIGN KEY (variant_entity_id) REFERENCES public.variant(id);


--
-- PostgreSQL database dump complete
--