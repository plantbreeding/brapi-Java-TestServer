--
-- PostgreSQL database dump
--

-- Dumped from database version 10.0
-- Dumped by pg_dump version 10.0

-- Started on 2023-09-14 12:08:11


--
-- TOC entry 220 (class 1259 OID 2108378)
-- Name: additional_info; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE additional_info (
    id text NOT NULL,
    key text,
    value bytea
);


--
-- TOC entry 197 (class 1259 OID 2048979)
-- Name: allele; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE allele (
    id character varying(255) NOT NULL,
    allele_code character varying(255),
    marker_id character varying(255),
    marker_profile_id character varying(255),
    matrix_id character varying(255),
    sample_id character varying(255)
);


--
-- TOC entry 221 (class 1259 OID 2108386)
-- Name: allele_call; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE allele_call (
    id text NOT NULL,
    auth_user_id text,
    genotype text,
    genotype_likelihood double precision,
    phase_set text,
    read_depth integer,
    call_set_id text,
    variant_id text
);


--
-- TOC entry 222 (class 1259 OID 2108394)
-- Name: allele_call_additional_info; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE allele_call_additional_info (
    call_entity_id text NOT NULL,
    additional_info_id text NOT NULL
);


--
-- TOC entry 223 (class 1259 OID 2108400)
-- Name: allele_call_external_references; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE allele_call_external_references (
    call_entity_id text NOT NULL,
    external_references_id text NOT NULL
);


--
-- TOC entry 198 (class 1259 OID 2048987)
-- Name: allele_matrix; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE allele_matrix (
    id character varying(255) NOT NULL,
    description character varying(255),
    last_updated timestamp without time zone,
    name character varying(255),
    study_id character varying(255)
);


--
-- TOC entry 224 (class 1259 OID 2108406)
-- Name: breeding_method; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE breeding_method (
    id text NOT NULL,
    auth_user_id text,
    abbreviation text,
    description text,
    name text
);


--
-- TOC entry 225 (class 1259 OID 2108414)
-- Name: breeding_method_additional_info; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE breeding_method_additional_info (
    breeding_method_entity_id text NOT NULL,
    additional_info_id text NOT NULL
);


--
-- TOC entry 226 (class 1259 OID 2108420)
-- Name: breeding_method_external_references; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE breeding_method_external_references (
    breeding_method_entity_id text NOT NULL,
    external_references_id text NOT NULL
);


--
-- TOC entry 227 (class 1259 OID 2108426)
-- Name: callset; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE callset (
    id text NOT NULL,
    auth_user_id text,
    call_set_name text,
    created timestamp without time zone,
    updated timestamp without time zone,
    sample_id text
);


--
-- TOC entry 228 (class 1259 OID 2108434)
-- Name: callset_additional_info; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE callset_additional_info (
    call_set_entity_id text NOT NULL,
    additional_info_id text NOT NULL
);


--
-- TOC entry 229 (class 1259 OID 2108440)
-- Name: callset_external_references; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE callset_external_references (
    call_set_entity_id text NOT NULL,
    external_references_id text NOT NULL
);


--
-- TOC entry 230 (class 1259 OID 2108446)
-- Name: callset_variant_sets; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE callset_variant_sets (
    call_sets_id text NOT NULL,
    variant_sets_id text NOT NULL
);


--
-- TOC entry 231 (class 1259 OID 2108452)
-- Name: contact; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE contact (
    id text NOT NULL,
    email text,
    institute_name text,
    name text,
    orcid text,
    study_db_id text,
    trial_db_id text,
    type text
);


--
-- TOC entry 232 (class 1259 OID 2108460)
-- Name: coordinate; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE coordinate (
    id text NOT NULL,
    altitude numeric(9,6),
    latitude numeric(9,6),
    longitude numeric(9,6),
    geojson_id text
);


--
-- TOC entry 233 (class 1259 OID 2108468)
-- Name: crop; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE crop (
    id text NOT NULL,
    auth_user_id text,
    crop_name text
);


--
-- TOC entry 234 (class 1259 OID 2108476)
-- Name: crop_additional_info; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE crop_additional_info (
    crop_entity_id text NOT NULL,
    additional_info_id text NOT NULL
);


--
-- TOC entry 235 (class 1259 OID 2108482)
-- Name: crop_external_references; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE crop_external_references (
    crop_entity_id text NOT NULL,
    external_references_id text NOT NULL
);


--
-- TOC entry 236 (class 1259 OID 2108488)
-- Name: cross_entity; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE cross_entity (
    id text NOT NULL,
    auth_user_id text,
    cross_type integer,
    name text,
    planned boolean,
    status integer,
    crossing_project_id text,
    planned_cross_id text
);


--
-- TOC entry 237 (class 1259 OID 2108496)
-- Name: cross_entity_additional_info; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE cross_entity_additional_info (
    cross_entity_id text NOT NULL,
    additional_info_id text NOT NULL
);


--
-- TOC entry 241 (class 1259 OID 2108524)
-- Name: cross_entity_cross_attributes; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE cross_entity_cross_attributes (
    cross_entity_id text NOT NULL,
    cross_attributes text
);


--
-- TOC entry 238 (class 1259 OID 2108502)
-- Name: cross_entity_external_references; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE cross_entity_external_references (
    cross_entity_id text NOT NULL,
    external_references_id text NOT NULL
);


--
-- TOC entry 239 (class 1259 OID 2108508)
-- Name: cross_parent; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE cross_parent (
    id text NOT NULL,
    parent_type integer,
    cross_id text,
    crossing_project_id text,
    germplasm_id text,
    observation_unit_id text
);


--
-- TOC entry 240 (class 1259 OID 2108516)
-- Name: cross_pollination_event; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE cross_pollination_event (
    id text NOT NULL,
    pollination_number text,
    pollination_successful boolean,
    pollination_time_stamp timestamp without time zone,
    cross_id text
);


--
-- TOC entry 242 (class 1259 OID 2108530)
-- Name: crossing_project; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE crossing_project (
    id text NOT NULL,
    auth_user_id text,
    description text,
    name text,
    program_id text
);


--
-- TOC entry 243 (class 1259 OID 2108538)
-- Name: crossing_project_additional_info; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE crossing_project_additional_info (
    crossing_project_entity_id text NOT NULL,
    additional_info_id text NOT NULL
);


--
-- TOC entry 244 (class 1259 OID 2108544)
-- Name: crossing_project_external_references; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE crossing_project_external_references (
    crossing_project_entity_id text NOT NULL,
    external_references_id text NOT NULL
);


--
-- TOC entry 199 (class 1259 OID 2049019)
-- Name: data_link; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE data_link (
    id character varying(255) NOT NULL,
    name character varying(255),
    study_db_id character varying(255),
    type character varying(255),
    url character varying(255)
);


--
-- TOC entry 200 (class 1259 OID 2049027)
-- Name: donor; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE donor (
    id character varying(255) NOT NULL,
    donor_accession_number character varying(255),
    donor_institute_code character varying(255),
    germplasm_db_id character varying(255),
    germplasmpui character varying(255)
);


--
-- TOC entry 245 (class 1259 OID 2108550)
-- Name: event; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE event (
    id text NOT NULL,
    auth_user_id text,
    event_description text,
    event_type text,
    event_type_db_id text,
    study_id text
);


--
-- TOC entry 246 (class 1259 OID 2108558)
-- Name: event_additional_info; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE event_additional_info (
    event_entity_id text NOT NULL,
    additional_info_id text NOT NULL
);


--
-- TOC entry 250 (class 1259 OID 2108584)
-- Name: event_entity_dates; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE event_entity_dates (
    event_entity_id text NOT NULL,
    dates timestamp without time zone
);


--
-- TOC entry 247 (class 1259 OID 2108564)
-- Name: event_external_references; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE event_external_references (
    event_entity_id text NOT NULL,
    external_references_id text NOT NULL
);


--
-- TOC entry 248 (class 1259 OID 2108570)
-- Name: event_observation_units; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE event_observation_units (
    event_entity_id text NOT NULL,
    observation_units_id text NOT NULL
);


--
-- TOC entry 249 (class 1259 OID 2108576)
-- Name: event_param; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE event_param (
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


--
-- TOC entry 251 (class 1259 OID 2108590)
-- Name: event_parameter_entity_values_by_date; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE event_parameter_entity_values_by_date (
    event_parameter_entity_id text NOT NULL,
    values_by_date text
);


--
-- TOC entry 252 (class 1259 OID 2108596)
-- Name: external_reference; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE external_reference (
    id text NOT NULL,
    external_reference_id text,
    external_reference_source text
);


--
-- TOC entry 253 (class 1259 OID 2108604)
-- Name: genome_map; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE genome_map (
    id text NOT NULL,
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


--
-- TOC entry 254 (class 1259 OID 2108612)
-- Name: genome_map_additional_info; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE genome_map_additional_info (
    genome_map_entity_id text NOT NULL,
    additional_info_id text NOT NULL
);


--
-- TOC entry 255 (class 1259 OID 2108618)
-- Name: genome_map_external_references; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE genome_map_external_references (
    genome_map_entity_id text NOT NULL,
    external_references_id text NOT NULL
);


--
-- TOC entry 256 (class 1259 OID 2108624)
-- Name: genome_map_studies; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE genome_map_studies (
    genome_map_entity_id text NOT NULL,
    studies_id text NOT NULL
);


--
-- TOC entry 257 (class 1259 OID 2108630)
-- Name: geojson; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE geojson (
    id text NOT NULL,
    type text
);


--
-- TOC entry 258 (class 1259 OID 2108638)
-- Name: germplasm; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE germplasm (
    id text NOT NULL,
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


--
-- TOC entry 259 (class 1259 OID 2108646)
-- Name: germplasm_additional_info; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE germplasm_additional_info (
    germplasm_entity_id text NOT NULL,
    additional_info_id text NOT NULL
);


--
-- TOC entry 201 (class 1259 OID 2049051)
-- Name: germplasm_attribute_category; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE germplasm_attribute_category (
    id character varying(255) NOT NULL,
    name character varying(255)
);


--
-- TOC entry 260 (class 1259 OID 2108652)
-- Name: germplasm_attribute_definition; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE germplasm_attribute_definition (
    id text NOT NULL,
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


--
-- TOC entry 261 (class 1259 OID 2108660)
-- Name: germplasm_attribute_value; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE germplasm_attribute_value (
    id text NOT NULL,
    auth_user_id text,
    determined_date timestamp without time zone,
    value text,
    attribute_id text,
    germplasm_id text
);


--
-- TOC entry 262 (class 1259 OID 2108668)
-- Name: germplasm_attribute_value_additional_info; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE germplasm_attribute_value_additional_info (
    germplasm_attribute_value_entity_id text NOT NULL,
    additional_info_id text NOT NULL
);


--
-- TOC entry 263 (class 1259 OID 2108674)
-- Name: germplasm_attribute_value_external_references; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE germplasm_attribute_value_external_references (
    germplasm_attribute_value_entity_id text NOT NULL,
    external_references_id text NOT NULL
);


--
-- TOC entry 264 (class 1259 OID 2108680)
-- Name: germplasm_donor; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE germplasm_donor (
    id text NOT NULL,
    auth_user_id text,
    donor_accession_number text,
    donor_institute_code text,
    donor_institute_name text,
    germplasmpui text,
    germplasm_id text
);


--
-- TOC entry 265 (class 1259 OID 2108688)
-- Name: germplasm_donor_additional_info; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE germplasm_donor_additional_info (
    donor_entity_id text NOT NULL,
    additional_info_id text NOT NULL
);


--
-- TOC entry 266 (class 1259 OID 2108694)
-- Name: germplasm_donor_external_references; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE germplasm_donor_external_references (
    donor_entity_id text NOT NULL,
    external_references_id text NOT NULL
);


--
-- TOC entry 273 (class 1259 OID 2108744)
-- Name: germplasm_entity_type_of_germplasm_storage_code; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE germplasm_entity_type_of_germplasm_storage_code (
    germplasm_entity_id text NOT NULL,
    type_of_germplasm_storage_code integer
);


--
-- TOC entry 267 (class 1259 OID 2108700)
-- Name: germplasm_external_references; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE germplasm_external_references (
    germplasm_entity_id text NOT NULL,
    external_references_id text NOT NULL
);


--
-- TOC entry 202 (class 1259 OID 2049075)
-- Name: germplasm_germplasm_type_storage_code; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE germplasm_germplasm_type_storage_code (
    germplasm_dbid character varying(255) NOT NULL,
    germplasm_type_storage_code_dbid character varying(255) NOT NULL
);


--
-- TOC entry 268 (class 1259 OID 2108706)
-- Name: germplasm_institute; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE germplasm_institute (
    id text NOT NULL,
    institute_address text,
    institute_code text,
    institute_name text,
    institute_type integer,
    germplasm_id text
);


--
-- TOC entry 269 (class 1259 OID 2108714)
-- Name: germplasm_origin; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE germplasm_origin (
    id text NOT NULL,
    coordinate_uncertainty text,
    coordinates_id text,
    germplasm_id text
);


--
-- TOC entry 270 (class 1259 OID 2108722)
-- Name: germplasm_search_results; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE germplasm_search_results (
    germplasm_entity_id text NOT NULL,
    search_results_id text NOT NULL
);


--
-- TOC entry 271 (class 1259 OID 2108728)
-- Name: germplasm_synonym; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE germplasm_synonym (
    id text NOT NULL,
    synonym text,
    type text,
    germplasm_id text
);


--
-- TOC entry 272 (class 1259 OID 2108736)
-- Name: germplasm_taxon; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE germplasm_taxon (
    id text NOT NULL,
    source_name text,
    taxon_id text,
    germplasm_id text
);


--
-- TOC entry 203 (class 1259 OID 2049093)
-- Name: germplasm_type_storage_code; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE germplasm_type_storage_code (
    id character varying(255) NOT NULL,
    storage_code integer
);


--
-- TOC entry 196 (class 1259 OID 122239)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 274 (class 1259 OID 2108750)
-- Name: image; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE image (
    id text NOT NULL,
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


--
-- TOC entry 275 (class 1259 OID 2108758)
-- Name: image_additional_info; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE image_additional_info (
    image_entity_id text NOT NULL,
    additional_info_id text NOT NULL
);


--
-- TOC entry 204 (class 1259 OID 2049106)
-- Name: image_entity_additional_info; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE image_entity_additional_info (
    image_entity_id character varying(255) NOT NULL,
    additional_info character varying(255)
);


--
-- TOC entry 278 (class 1259 OID 2108776)
-- Name: image_entity_descriptive_ontology_terms; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE image_entity_descriptive_ontology_terms (
    image_entity_id text NOT NULL,
    descriptive_ontology_terms text
);


--
-- TOC entry 276 (class 1259 OID 2108764)
-- Name: image_external_references; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE image_external_references (
    image_entity_id text NOT NULL,
    external_references_id text NOT NULL
);


--
-- TOC entry 277 (class 1259 OID 2108770)
-- Name: image_observations; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE image_observations (
    image_entity_id text NOT NULL,
    observations_id text NOT NULL
);


--
-- TOC entry 279 (class 1259 OID 2108782)
-- Name: linkage_group; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE linkage_group (
    id text NOT NULL,
    auth_user_id text,
    linkage_group_name text,
    max_marker_position integer,
    genome_map_id text
);


--
-- TOC entry 280 (class 1259 OID 2108790)
-- Name: linkage_group_additional_info; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE linkage_group_additional_info (
    linkage_group_entity_id text NOT NULL,
    additional_info_id text NOT NULL
);


--
-- TOC entry 281 (class 1259 OID 2108796)
-- Name: linkage_group_external_references; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE linkage_group_external_references (
    linkage_group_entity_id text NOT NULL,
    external_references_id text NOT NULL
);


--
-- TOC entry 282 (class 1259 OID 2108802)
-- Name: list; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE list (
    id text NOT NULL,
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


--
-- TOC entry 283 (class 1259 OID 2108810)
-- Name: list_additional_info; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE list_additional_info (
    list_entity_id text NOT NULL,
    additional_info_id text NOT NULL
);


--
-- TOC entry 284 (class 1259 OID 2108816)
-- Name: list_external_references; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE list_external_references (
    list_entity_id text NOT NULL,
    external_references_id text NOT NULL
);


--
-- TOC entry 285 (class 1259 OID 2108822)
-- Name: list_item; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE list_item (
    id text NOT NULL,
    item text,
    list_id text
);


--
-- TOC entry 286 (class 1259 OID 2108830)
-- Name: location; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE location (
    id text NOT NULL,
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


--
-- TOC entry 287 (class 1259 OID 2108838)
-- Name: location_additional_info; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE location_additional_info (
    location_entity_id text NOT NULL,
    additional_info_id text NOT NULL
);


--
-- TOC entry 288 (class 1259 OID 2108844)
-- Name: location_external_references; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE location_external_references (
    location_entity_id text NOT NULL,
    external_references_id text NOT NULL
);


--
-- TOC entry 205 (class 1259 OID 2049152)
-- Name: marker; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE marker (
    id character varying(255) NOT NULL,
    location integer,
    marker_name character varying(255),
    type character varying(255),
    linkage_group_id character varying(255)
);


--
-- TOC entry 206 (class 1259 OID 2049160)
-- Name: marker_analysis_method; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE marker_analysis_method (
    id character varying(255) NOT NULL,
    method_name character varying(255)
);


--
-- TOC entry 207 (class 1259 OID 2049168)
-- Name: marker_marker_analysis_method; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE marker_marker_analysis_method (
    marker_db_id character varying(255) NOT NULL,
    marker_analysis_method_db_id character varying(255) NOT NULL
);


--
-- TOC entry 289 (class 1259 OID 2108850)
-- Name: marker_position; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE marker_position (
    id text NOT NULL,
    auth_user_id text,
    "position" integer,
    linkage_group_id text,
    variant_id text
);


--
-- TOC entry 290 (class 1259 OID 2108858)
-- Name: marker_position_additional_info; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE marker_position_additional_info (
    marker_position_entity_id text NOT NULL,
    additional_info_id text NOT NULL
);


--
-- TOC entry 291 (class 1259 OID 2108864)
-- Name: marker_position_external_references; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE marker_position_external_references (
    marker_position_entity_id text NOT NULL,
    external_references_id text NOT NULL
);


--
-- TOC entry 208 (class 1259 OID 2049174)
-- Name: marker_profile; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE marker_profile (
    id character varying(255) NOT NULL,
    analysis_method character varying(255),
    extract_db_id character varying(255),
    germplasm_db_id character varying(255),
    sample_db_id character varying(255),
    unique_display_name character varying(255)
);


--
-- TOC entry 209 (class 1259 OID 2049182)
-- Name: marker_reference; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE marker_reference (
    id character varying(255) NOT NULL,
    alternative boolean,
    marker_db_id character varying(255),
    reference character varying(255)
);


--
-- TOC entry 210 (class 1259 OID 2049190)
-- Name: marker_synonym; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE marker_synonym (
    id character varying(255) NOT NULL,
    marker_db_id character varying(255),
    synonym character varying(255)
);


--
-- TOC entry 292 (class 1259 OID 2108870)
-- Name: method; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE method (
    id text NOT NULL,
    auth_user_id text,
    description text,
    formula text,
    method_class text,
    methodpui text,
    name text,
    reference text,
    ontology_id text
);


--
-- TOC entry 293 (class 1259 OID 2108878)
-- Name: method_additional_info; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE method_additional_info (
    method_entity_id text NOT NULL,
    additional_info_id text NOT NULL
);


--
-- TOC entry 294 (class 1259 OID 2108884)
-- Name: method_external_references; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE method_external_references (
    method_entity_id text NOT NULL,
    external_references_id text NOT NULL
);


--
-- TOC entry 295 (class 1259 OID 2108890)
-- Name: method_ontology_reference; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE method_ontology_reference (
    method_entity_id text NOT NULL,
    ontology_reference_id text NOT NULL
);


--
-- TOC entry 296 (class 1259 OID 2108896)
-- Name: observation; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE observation (
    id text NOT NULL,
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


--
-- TOC entry 297 (class 1259 OID 2108904)
-- Name: observation_additional_info; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE observation_additional_info (
    observation_entity_id text NOT NULL,
    additional_info_id text NOT NULL
);


--
-- TOC entry 298 (class 1259 OID 2108910)
-- Name: observation_external_references; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE observation_external_references (
    observation_entity_id text NOT NULL,
    external_references_id text NOT NULL
);


--
-- TOC entry 299 (class 1259 OID 2108916)
-- Name: observation_unit; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE observation_unit (
    id text NOT NULL,
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


--
-- TOC entry 300 (class 1259 OID 2108924)
-- Name: observation_unit_additional_info; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE observation_unit_additional_info (
    observation_unit_entity_id text NOT NULL,
    additional_info_id text NOT NULL
);


--
-- TOC entry 301 (class 1259 OID 2108930)
-- Name: observation_unit_external_references; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE observation_unit_external_references (
    observation_unit_entity_id text NOT NULL,
    external_references_id text NOT NULL
);


--
-- TOC entry 302 (class 1259 OID 2108936)
-- Name: observation_unit_level; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE observation_unit_level (
    id text NOT NULL,
    level_code text,
    level_name integer,
    level_order integer,
    observation_unit_id text,
    position_id text
);


--
-- TOC entry 303 (class 1259 OID 2108944)
-- Name: observation_unit_position; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE observation_unit_position (
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


--
-- TOC entry 304 (class 1259 OID 2108952)
-- Name: observation_unit_treatment; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE observation_unit_treatment (
    id text NOT NULL,
    factor text,
    modality text,
    observation_unit_id text
);


--
-- TOC entry 211 (class 1259 OID 2049228)
-- Name: observation_unit_xref; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE observation_unit_xref (
    id character varying(255) NOT NULL,
    observation_unit_db_id character varying(255),
    source character varying(255),
    xref character varying(255)
);


--
-- TOC entry 305 (class 1259 OID 2108960)
-- Name: observation_variable; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE observation_variable (
    id text NOT NULL,
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


--
-- TOC entry 212 (class 1259 OID 2049244)
-- Name: observation_variable_context; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE observation_variable_context (
    id character varying(255) NOT NULL,
    context character varying(255),
    observation_variable_db_id character varying(255)
);


--
-- TOC entry 213 (class 1259 OID 2049252)
-- Name: observation_variable_synonym; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE observation_variable_synonym (
    id character varying(255) NOT NULL,
    observation_variable_db_id character varying(255),
    synonym character varying(255)
);


--
-- TOC entry 306 (class 1259 OID 2108968)
-- Name: ontology; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE ontology (
    id text NOT NULL,
    auth_user_id text,
    authors text,
    copyright text,
    description text,
    documentationurl text,
    licence text,
    ontology_name text,
    version text
);


--
-- TOC entry 307 (class 1259 OID 2108976)
-- Name: ontology_additional_info; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE ontology_additional_info (
    ontology_entity_id text NOT NULL,
    additional_info_id text NOT NULL
);


--
-- TOC entry 310 (class 1259 OID 2108996)
-- Name: ontology_entity_documentation_links; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE ontology_entity_documentation_links (
    ontology_entity_id text NOT NULL,
    documentation_links text
);


--
-- TOC entry 308 (class 1259 OID 2108982)
-- Name: ontology_external_references; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE ontology_external_references (
    ontology_entity_id text NOT NULL,
    external_references_id text NOT NULL
);


--
-- TOC entry 309 (class 1259 OID 2108988)
-- Name: ontology_ref; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE ontology_ref (
    id text NOT NULL,
    url text,
    type integer
);


--
-- TOC entry 214 (class 1259 OID 2049276)
-- Name: pedigree; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE pedigree (
    id character varying(255) NOT NULL,
    crossing_plan character varying(255),
    crossing_year integer,
    family_code character varying(255),
    notation character varying(255),
    parent1type character varying(255),
    parent2type character varying(255),
    pedigree character varying(255),
    germplasm_db_id character varying(255),
    parent1_db_id character varying(255),
    parent2_db_id character varying(255)
);


--
-- TOC entry 311 (class 1259 OID 2109002)
-- Name: pedigree_edge; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE pedigree_edge (
    id text NOT NULL,
    auth_user_id text,
    edge_type integer,
    parent_type integer,
    connceted_node_id text,
    this_node_id text
);


--
-- TOC entry 312 (class 1259 OID 2109010)
-- Name: pedigree_edge_additional_info; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE pedigree_edge_additional_info (
    pedigree_edge_entity_id text NOT NULL,
    additional_info_id text NOT NULL
);


--
-- TOC entry 313 (class 1259 OID 2109016)
-- Name: pedigree_edge_external_references; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE pedigree_edge_external_references (
    pedigree_edge_entity_id text NOT NULL,
    external_references_id text NOT NULL
);


--
-- TOC entry 314 (class 1259 OID 2109022)
-- Name: pedigree_node; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE pedigree_node (
    id text NOT NULL,
    auth_user_id text,
    crossing_year integer,
    family_code text,
    pedigree_string text,
    crossing_project_id text,
    germplasm_id text
);


--
-- TOC entry 315 (class 1259 OID 2109030)
-- Name: pedigree_node_additional_info; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE pedigree_node_additional_info (
    pedigree_node_entity_id text NOT NULL,
    additional_info_id text NOT NULL
);


--
-- TOC entry 316 (class 1259 OID 2109036)
-- Name: pedigree_node_external_references; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE pedigree_node_external_references (
    pedigree_node_entity_id text NOT NULL,
    external_references_id text NOT NULL
);


--
-- TOC entry 317 (class 1259 OID 2109042)
-- Name: person; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE person (
    id text NOT NULL,
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


--
-- TOC entry 318 (class 1259 OID 2109050)
-- Name: person_additional_info; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE person_additional_info (
    person_entity_id text NOT NULL,
    additional_info_id text NOT NULL
);


--
-- TOC entry 319 (class 1259 OID 2109056)
-- Name: person_external_references; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE person_external_references (
    person_entity_id text NOT NULL,
    external_references_id text NOT NULL
);


--
-- TOC entry 320 (class 1259 OID 2109062)
-- Name: plate; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE plate (
    id text NOT NULL,
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


--
-- TOC entry 321 (class 1259 OID 2109070)
-- Name: plate_additional_info; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE plate_additional_info (
    plate_entity_id text NOT NULL,
    additional_info_id text NOT NULL
);


--
-- TOC entry 322 (class 1259 OID 2109076)
-- Name: plate_external_references; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE plate_external_references (
    plate_entity_id text NOT NULL,
    external_references_id text NOT NULL
);


--
-- TOC entry 323 (class 1259 OID 2109082)
-- Name: plate_submission; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE plate_submission (
    id text NOT NULL,
    auth_user_id text,
    client_id text,
    number_of_samples integer,
    sample_type integer,
    order_id text
);


--
-- TOC entry 324 (class 1259 OID 2109090)
-- Name: plate_submission_additional_info; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE plate_submission_additional_info (
    vendor_plate_submission_entity_id text NOT NULL,
    additional_info_id text NOT NULL
);


--
-- TOC entry 325 (class 1259 OID 2109096)
-- Name: plate_submission_external_references; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE plate_submission_external_references (
    vendor_plate_submission_entity_id text NOT NULL,
    external_references_id text NOT NULL
);


--
-- TOC entry 326 (class 1259 OID 2109102)
-- Name: program; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE program (
    id text NOT NULL,
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


--
-- TOC entry 327 (class 1259 OID 2109110)
-- Name: program_additional_info; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE program_additional_info (
    program_entity_id text NOT NULL,
    additional_info_id text NOT NULL
);


--
-- TOC entry 328 (class 1259 OID 2109116)
-- Name: program_external_references; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE program_external_references (
    program_entity_id text NOT NULL,
    external_references_id text NOT NULL
);


--
-- TOC entry 329 (class 1259 OID 2109122)
-- Name: reference; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE reference (
    id text NOT NULL,
    auth_user_id text,
    length integer,
    md5checksum text,
    reference_name text,
    source_divergence numeric(19,2),
    reference_set_id text
);


--
-- TOC entry 330 (class 1259 OID 2109130)
-- Name: reference_additional_info; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE reference_additional_info (
    reference_entity_id text NOT NULL,
    additional_info_id text NOT NULL
);


--
-- TOC entry 331 (class 1259 OID 2109136)
-- Name: reference_bases; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE reference_bases (
    id text NOT NULL,
    auth_user_id text,
    bases text,
    page_number integer,
    reference_id text
);


--
-- TOC entry 332 (class 1259 OID 2109144)
-- Name: reference_bases_additional_info; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE reference_bases_additional_info (
    reference_bases_page_entity_id text NOT NULL,
    additional_info_id text NOT NULL
);


--
-- TOC entry 333 (class 1259 OID 2109150)
-- Name: reference_bases_external_references; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE reference_bases_external_references (
    reference_bases_page_entity_id text NOT NULL,
    external_references_id text NOT NULL
);


--
-- TOC entry 334 (class 1259 OID 2109156)
-- Name: reference_external_references; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE reference_external_references (
    reference_entity_id text NOT NULL,
    external_references_id text NOT NULL
);


--
-- TOC entry 335 (class 1259 OID 2109162)
-- Name: reference_set; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE reference_set (
    id text NOT NULL,
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


--
-- TOC entry 336 (class 1259 OID 2109170)
-- Name: reference_set_additional_info; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE reference_set_additional_info (
    reference_set_entity_id text NOT NULL,
    additional_info_id text NOT NULL
);


--
-- TOC entry 337 (class 1259 OID 2109176)
-- Name: reference_set_external_references; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE reference_set_external_references (
    reference_set_entity_id text NOT NULL,
    external_references_id text NOT NULL
);


--
-- TOC entry 338 (class 1259 OID 2109182)
-- Name: sample; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE sample (
    id text NOT NULL,
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


--
-- TOC entry 339 (class 1259 OID 2109190)
-- Name: sample_additional_info; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE sample_additional_info (
    sample_entity_id text NOT NULL,
    additional_info_id text NOT NULL
);


--
-- TOC entry 340 (class 1259 OID 2109196)
-- Name: sample_external_references; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE sample_external_references (
    sample_entity_id text NOT NULL,
    external_references_id text NOT NULL
);


--
-- TOC entry 341 (class 1259 OID 2109202)
-- Name: scale; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE scale (
    id text NOT NULL,
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


--
-- TOC entry 342 (class 1259 OID 2109210)
-- Name: scale_additional_info; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE scale_additional_info (
    scale_entity_id text NOT NULL,
    additional_info_id text NOT NULL
);


--
-- TOC entry 215 (class 1259 OID 2049338)
-- Name: scale_entity_valid_value_categories; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE scale_entity_valid_value_categories (
    scale_entity_id character varying(255) NOT NULL,
    valid_value_categories character varying(255)
);


--
-- TOC entry 343 (class 1259 OID 2109216)
-- Name: scale_external_references; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE scale_external_references (
    scale_entity_id text NOT NULL,
    external_references_id text NOT NULL
);


--
-- TOC entry 344 (class 1259 OID 2109222)
-- Name: scale_ontology_reference; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE scale_ontology_reference (
    scale_entity_id text NOT NULL,
    ontology_reference_id text NOT NULL
);


--
-- TOC entry 345 (class 1259 OID 2109228)
-- Name: scale_valid_value_category; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE scale_valid_value_category (
    id text NOT NULL,
    label text,
    value text,
    scale_id text
);


--
-- TOC entry 346 (class 1259 OID 2109236)
-- Name: search; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE search (
    id text NOT NULL,
    auth_user_id text,
    parameters text,
    request_type integer,
    response_countdown integer
);


--
-- TOC entry 347 (class 1259 OID 2109244)
-- Name: search_additional_info; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE search_additional_info (
    search_request_entity_id text NOT NULL,
    additional_info_id text NOT NULL
);


--
-- TOC entry 348 (class 1259 OID 2109250)
-- Name: search_external_references; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE search_external_references (
    search_request_entity_id text NOT NULL,
    external_references_id text NOT NULL
);


--
-- TOC entry 349 (class 1259 OID 2109256)
-- Name: season; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE season (
    id text NOT NULL,
    auth_user_id text,
    season text,
    year integer
);


--
-- TOC entry 350 (class 1259 OID 2109264)
-- Name: season_additional_info; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE season_additional_info (
    season_entity_id text NOT NULL,
    additional_info_id text NOT NULL
);


--
-- TOC entry 351 (class 1259 OID 2109270)
-- Name: season_external_references; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE season_external_references (
    season_entity_id text NOT NULL,
    external_references_id text NOT NULL
);


--
-- TOC entry 352 (class 1259 OID 2109276)
-- Name: seed_lot; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE seed_lot (
    id text NOT NULL,
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


--
-- TOC entry 353 (class 1259 OID 2109284)
-- Name: seed_lot_additional_info; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE seed_lot_additional_info (
    seed_lot_entity_id text NOT NULL,
    additional_info_id text NOT NULL
);


--
-- TOC entry 354 (class 1259 OID 2109290)
-- Name: seed_lot_content_mixture; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE seed_lot_content_mixture (
    id text NOT NULL,
    mixture_percentage integer,
    cross_id text,
    germplasm_id text,
    seed_lot_id text
);


--
-- TOC entry 355 (class 1259 OID 2109298)
-- Name: seed_lot_external_references; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE seed_lot_external_references (
    seed_lot_entity_id text NOT NULL,
    external_references_id text NOT NULL
);


--
-- TOC entry 356 (class 1259 OID 2109304)
-- Name: seed_lot_transaction; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE seed_lot_transaction (
    id text NOT NULL,
    auth_user_id text,
    amount numeric(19,2),
    description text,
    "timestamp" timestamp without time zone,
    units text,
    from_seed_lot_id text,
    to_seed_lot_id text
);


--
-- TOC entry 357 (class 1259 OID 2109312)
-- Name: seed_lot_transaction_additional_info; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE seed_lot_transaction_additional_info (
    seed_lot_transaction_entity_id text NOT NULL,
    additional_info_id text NOT NULL
);


--
-- TOC entry 358 (class 1259 OID 2109318)
-- Name: seed_lot_transaction_external_references; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE seed_lot_transaction_external_references (
    seed_lot_transaction_entity_id text NOT NULL,
    external_references_id text NOT NULL
);


--
-- TOC entry 359 (class 1259 OID 2109324)
-- Name: study; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE study (
    id text NOT NULL,
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


--
-- TOC entry 360 (class 1259 OID 2109332)
-- Name: study_additional_info; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE study_additional_info (
    study_entity_id text NOT NULL,
    additional_info_id text NOT NULL
);


--
-- TOC entry 361 (class 1259 OID 2109338)
-- Name: study_contact; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE study_contact (
    study_db_id text NOT NULL,
    person_db_id text NOT NULL
);


--
-- TOC entry 362 (class 1259 OID 2109344)
-- Name: study_data_link; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE study_data_link (
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


--
-- TOC entry 363 (class 1259 OID 2109352)
-- Name: study_environment_parameter; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE study_environment_parameter (
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


--
-- TOC entry 364 (class 1259 OID 2109360)
-- Name: study_experimental_design; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE study_experimental_design (
    id text NOT NULL,
    pui text,
    description text,
    study_id text
);


--
-- TOC entry 365 (class 1259 OID 2109368)
-- Name: study_external_references; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE study_external_references (
    study_entity_id text NOT NULL,
    external_references_id text NOT NULL
);


--
-- TOC entry 366 (class 1259 OID 2109374)
-- Name: study_growth_facility; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE study_growth_facility (
    id text NOT NULL,
    pui text,
    description text,
    study_id text
);


--
-- TOC entry 367 (class 1259 OID 2109382)
-- Name: study_last_update; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE study_last_update (
    id text NOT NULL,
    "timestamp" timestamp without time zone,
    version text,
    study_id text
);


--
-- TOC entry 216 (class 1259 OID 2049382)
-- Name: study_marker_profile; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE study_marker_profile (
    marker_profile_db_id character varying(255) NOT NULL,
    study_db_id character varying(255) NOT NULL
);


--
-- TOC entry 368 (class 1259 OID 2109390)
-- Name: study_observation_level; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE study_observation_level (
    id text NOT NULL,
    level_name text,
    level_order integer,
    study_id text
);


--
-- TOC entry 369 (class 1259 OID 2109398)
-- Name: study_season; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE study_season (
    study_db_id text NOT NULL,
    season_db_id text NOT NULL
);


--
-- TOC entry 217 (class 1259 OID 2049394)
-- Name: study_type; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE study_type (
    id character varying(255) NOT NULL,
    description character varying(255),
    name character varying(255)
);


--
-- TOC entry 370 (class 1259 OID 2109404)
-- Name: study_variable; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE study_variable (
    study_db_id text NOT NULL,
    variable_db_id text NOT NULL
);


--
-- TOC entry 218 (class 1259 OID 2049402)
-- Name: taxon; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE taxon (
    id character varying(255) NOT NULL,
    source_name character varying(255),
    taxon_id character varying(255)
);


--
-- TOC entry 371 (class 1259 OID 2109410)
-- Name: trait; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE trait (
    id text NOT NULL,
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


--
-- TOC entry 372 (class 1259 OID 2109418)
-- Name: trait_abbreviation; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE trait_abbreviation (
    id text NOT NULL,
    abbreviation text,
    trait_id text
);


--
-- TOC entry 373 (class 1259 OID 2109426)
-- Name: trait_additional_info; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE trait_additional_info (
    trait_entity_id text NOT NULL,
    additional_info_id text NOT NULL
);


--
-- TOC entry 377 (class 1259 OID 2109452)
-- Name: trait_entity_alternative_abbreviations; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE trait_entity_alternative_abbreviations (
    trait_entity_id text NOT NULL,
    alternative_abbreviations text
);


--
-- TOC entry 378 (class 1259 OID 2109458)
-- Name: trait_entity_synonyms; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE trait_entity_synonyms (
    trait_entity_id text NOT NULL,
    synonyms text
);


--
-- TOC entry 374 (class 1259 OID 2109432)
-- Name: trait_external_references; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE trait_external_references (
    trait_entity_id text NOT NULL,
    external_references_id text NOT NULL
);


--
-- TOC entry 375 (class 1259 OID 2109438)
-- Name: trait_ontology_reference; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE trait_ontology_reference (
    trait_entity_id text NOT NULL,
    ontology_reference_id text NOT NULL
);


--
-- TOC entry 376 (class 1259 OID 2109444)
-- Name: trait_synonym; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE trait_synonym (
    id text NOT NULL,
    synonym text,
    trait_id text
);


--
-- TOC entry 219 (class 1259 OID 2049440)
-- Name: treatment; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE treatment (
    id character varying(255) NOT NULL,
    factor character varying(255),
    modality character varying(255),
    observation_unit_db_id character varying(255)
);


--
-- TOC entry 379 (class 1259 OID 2109464)
-- Name: trial; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE trial (
    id text NOT NULL,
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


--
-- TOC entry 380 (class 1259 OID 2109472)
-- Name: trial_additional_info; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE trial_additional_info (
    trial_entity_id text NOT NULL,
    additional_info_id text NOT NULL
);


--
-- TOC entry 381 (class 1259 OID 2109478)
-- Name: trial_contact; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE trial_contact (
    trial_db_id text NOT NULL,
    person_db_id text NOT NULL
);


--
-- TOC entry 382 (class 1259 OID 2109484)
-- Name: trial_dataset_authorship; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE trial_dataset_authorship (
    id text NOT NULL,
    datasetpui text,
    license text,
    public_release_date timestamp without time zone,
    submission_date timestamp without time zone,
    trial_id text
);


--
-- TOC entry 383 (class 1259 OID 2109492)
-- Name: trial_external_references; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE trial_external_references (
    trial_entity_id text NOT NULL,
    external_references_id text NOT NULL
);


--
-- TOC entry 384 (class 1259 OID 2109498)
-- Name: trial_publication; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE trial_publication (
    id text NOT NULL,
    publicationpui text,
    publication_reference text,
    trial_id text
);


--
-- TOC entry 385 (class 1259 OID 2109506)
-- Name: variable_base_entity; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE variable_base_entity (
    id text NOT NULL,
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


--
-- TOC entry 386 (class 1259 OID 2109514)
-- Name: variable_base_entity_additional_info; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE variable_base_entity_additional_info (
    variable_base_entity_id text NOT NULL,
    additional_info_id text NOT NULL
);


--
-- TOC entry 387 (class 1259 OID 2109520)
-- Name: variable_base_entity_context_of_use; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE variable_base_entity_context_of_use (
    variable_base_entity_id text NOT NULL,
    context_of_use text
);


--
-- TOC entry 388 (class 1259 OID 2109526)
-- Name: variable_base_entity_external_references; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE variable_base_entity_external_references (
    variable_base_entity_id text NOT NULL,
    external_references_id text NOT NULL
);


--
-- TOC entry 389 (class 1259 OID 2109532)
-- Name: variable_base_entity_ontology_reference; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE variable_base_entity_ontology_reference (
    variable_base_entity_id text NOT NULL,
    ontology_reference_id text NOT NULL
);


--
-- TOC entry 390 (class 1259 OID 2109538)
-- Name: variable_base_entity_synonyms; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE variable_base_entity_synonyms (
    variable_base_entity_id text NOT NULL,
    synonyms text
);


--
-- TOC entry 391 (class 1259 OID 2109544)
-- Name: variant; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE variant (
    id text NOT NULL,
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


--
-- TOC entry 392 (class 1259 OID 2109552)
-- Name: variant_additional_info; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE variant_additional_info (
    variant_entity_id text NOT NULL,
    additional_info_id text NOT NULL
);


--
-- TOC entry 394 (class 1259 OID 2109564)
-- Name: variant_entity_alternate_bases; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE variant_entity_alternate_bases (
    variant_entity_id text NOT NULL,
    alternate_bases text
);


--
-- TOC entry 395 (class 1259 OID 2109570)
-- Name: variant_entity_ciend; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE variant_entity_ciend (
    variant_entity_id text NOT NULL,
    ciend integer
);


--
-- TOC entry 396 (class 1259 OID 2109576)
-- Name: variant_entity_cipos; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE variant_entity_cipos (
    variant_entity_id text NOT NULL,
    cipos integer
);


--
-- TOC entry 397 (class 1259 OID 2109582)
-- Name: variant_entity_filters_failed; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE variant_entity_filters_failed (
    variant_entity_id text NOT NULL,
    filters_failed text
);


--
-- TOC entry 393 (class 1259 OID 2109558)
-- Name: variant_external_references; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE variant_external_references (
    variant_entity_id text NOT NULL,
    external_references_id text NOT NULL
);


--
-- TOC entry 403 (class 1259 OID 2109624)
-- Name: variant_set_analysis_entity_software; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE variant_set_analysis_entity_software (
    variant_set_analysis_entity_id text NOT NULL,
    software text
);


--
-- TOC entry 398 (class 1259 OID 2109588)
-- Name: variantset; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE variantset (
    id text NOT NULL,
    auth_user_id text,
    variant_set_name text,
    reference_set_id text,
    study_id text
);


--
-- TOC entry 399 (class 1259 OID 2109596)
-- Name: variantset_additional_info; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE variantset_additional_info (
    variant_set_entity_id text NOT NULL,
    additional_info_id text NOT NULL
);


--
-- TOC entry 400 (class 1259 OID 2109602)
-- Name: variantset_analysis; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE variantset_analysis (
    id text NOT NULL,
    analysis_name text,
    created timestamp without time zone,
    description text,
    type text,
    updated timestamp without time zone,
    variant_set_id text
);


--
-- TOC entry 401 (class 1259 OID 2109610)
-- Name: variantset_external_references; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE variantset_external_references (
    variant_set_entity_id text NOT NULL,
    external_references_id text NOT NULL
);


--
-- TOC entry 402 (class 1259 OID 2109616)
-- Name: variantset_format; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE variantset_format (
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


--
-- TOC entry 404 (class 1259 OID 2109630)
-- Name: vendor_file; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE vendor_file (
    id text NOT NULL,
    url text,
    file_type text,
    filename text,
    md5sum text,
    order_id text
);


--
-- TOC entry 405 (class 1259 OID 2109638)
-- Name: vendor_file_sample; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE vendor_file_sample (
    verndor_file_dbid text NOT NULL,
    sample_dbid text NOT NULL
);


--
-- TOC entry 406 (class 1259 OID 2109644)
-- Name: vendor_order; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE vendor_order (
    id text NOT NULL,
    auth_user_id text,
    client_plate_barcode text,
    client_plate_db_id text,
    sample_type integer,
    status integer,
    status_time_stamp timestamp without time zone
);


--
-- TOC entry 407 (class 1259 OID 2109652)
-- Name: vendor_order_additional_info; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE vendor_order_additional_info (
    vendor_order_entity_id text NOT NULL,
    additional_info_id text NOT NULL
);


--
-- TOC entry 419 (class 1259 OID 2109740)
-- Name: vendor_order_entity_required_service_info; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE vendor_order_entity_required_service_info (
    vendor_order_entity_id text NOT NULL,
    required_service_info text,
    required_service_info_key text NOT NULL
);


--
-- TOC entry 420 (class 1259 OID 2109748)
-- Name: vendor_order_entity_service_ids; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE vendor_order_entity_service_ids (
    vendor_order_entity_id text NOT NULL,
    service_ids text
);


--
-- TOC entry 408 (class 1259 OID 2109658)
-- Name: vendor_order_external_references; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE vendor_order_external_references (
    vendor_order_entity_id text NOT NULL,
    external_references_id text NOT NULL
);


--
-- TOC entry 409 (class 1259 OID 2109664)
-- Name: vendor_spec; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE vendor_spec (
    id text NOT NULL,
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


--
-- TOC entry 410 (class 1259 OID 2109672)
-- Name: vendor_spec_additional_info; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE vendor_spec_additional_info (
    vendor_spec_entity_id text NOT NULL,
    additional_info_id text NOT NULL
);


--
-- TOC entry 411 (class 1259 OID 2109678)
-- Name: vendor_spec_deliverable; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE vendor_spec_deliverable (
    id text NOT NULL,
    description text,
    format text,
    name text,
    vendor_spec_platform_db_id text
);


--
-- TOC entry 412 (class 1259 OID 2109686)
-- Name: vendor_spec_external_references; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE vendor_spec_external_references (
    vendor_spec_entity_id text NOT NULL,
    external_references_id text NOT NULL
);


--
-- TOC entry 413 (class 1259 OID 2109692)
-- Name: vendor_spec_input_format; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE vendor_spec_input_format (
    id text NOT NULL,
    input_format text,
    vendor_spec_standard_requirement_db_id text
);


--
-- TOC entry 414 (class 1259 OID 2109700)
-- Name: vendor_spec_platform; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE vendor_spec_platform (
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


--
-- TOC entry 415 (class 1259 OID 2109708)
-- Name: vendor_spec_requirement; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE vendor_spec_requirement (
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


--
-- TOC entry 416 (class 1259 OID 2109716)
-- Name: vendor_spec_sample_type; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE vendor_spec_sample_type (
    id text NOT NULL,
    sample_type text,
    vendor_spec_standard_requirement_db_id text
);


--
-- TOC entry 417 (class 1259 OID 2109724)
-- Name: vendor_spec_status; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE vendor_spec_status (
    id text NOT NULL,
    status_description text,
    status_name text,
    vendor_spec_platform_db_id text
);


--
-- TOC entry 418 (class 1259 OID 2109732)
-- Name: vendor_spec_well_position; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE vendor_spec_well_position (
    id text NOT NULL,
    "position" text,
    vendor_spec_standard_requirement_db_id text
);


--
-- TOC entry 4696 (class 0 OID 0)
-- Dependencies: 196
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('hibernate_sequence', 1, false);


--
-- TOC entry 3822 (class 2606 OID 2108385)
-- Name: additional_info additional_info_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY additional_info
    ADD CONSTRAINT additional_info_pkey PRIMARY KEY (id);


--
-- TOC entry 3824 (class 2606 OID 2108393)
-- Name: allele_call allele_call_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY allele_call
    ADD CONSTRAINT allele_call_pkey PRIMARY KEY (id);


--
-- TOC entry 3788 (class 2606 OID 2048994)
-- Name: allele_matrix allele_matrix_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY allele_matrix
    ADD CONSTRAINT allele_matrix_pkey PRIMARY KEY (id);


--
-- TOC entry 3786 (class 2606 OID 2048986)
-- Name: allele allele_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY allele
    ADD CONSTRAINT allele_pkey PRIMARY KEY (id);


--
-- TOC entry 3826 (class 2606 OID 2108413)
-- Name: breeding_method breeding_method_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY breeding_method
    ADD CONSTRAINT breeding_method_pkey PRIMARY KEY (id);


--
-- TOC entry 3828 (class 2606 OID 2108433)
-- Name: callset callset_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY callset
    ADD CONSTRAINT callset_pkey PRIMARY KEY (id);


--
-- TOC entry 3830 (class 2606 OID 2108459)
-- Name: contact contact_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY contact
    ADD CONSTRAINT contact_pkey PRIMARY KEY (id);


--
-- TOC entry 3832 (class 2606 OID 2108467)
-- Name: coordinate coordinate_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY coordinate
    ADD CONSTRAINT coordinate_pkey PRIMARY KEY (id);


--
-- TOC entry 3834 (class 2606 OID 2108475)
-- Name: crop crop_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY crop
    ADD CONSTRAINT crop_pkey PRIMARY KEY (id);


--
-- TOC entry 3836 (class 2606 OID 2108495)
-- Name: cross_entity cross_entity_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY cross_entity
    ADD CONSTRAINT cross_entity_pkey PRIMARY KEY (id);


--
-- TOC entry 3838 (class 2606 OID 2108515)
-- Name: cross_parent cross_parent_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY cross_parent
    ADD CONSTRAINT cross_parent_pkey PRIMARY KEY (id);


--
-- TOC entry 3840 (class 2606 OID 2108523)
-- Name: cross_pollination_event cross_pollination_event_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY cross_pollination_event
    ADD CONSTRAINT cross_pollination_event_pkey PRIMARY KEY (id);


--
-- TOC entry 3842 (class 2606 OID 2108537)
-- Name: crossing_project crossing_project_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY crossing_project
    ADD CONSTRAINT crossing_project_pkey PRIMARY KEY (id);


--
-- TOC entry 3790 (class 2606 OID 2049026)
-- Name: data_link data_link_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY data_link
    ADD CONSTRAINT data_link_pkey PRIMARY KEY (id);


--
-- TOC entry 3792 (class 2606 OID 2049034)
-- Name: donor donor_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY donor
    ADD CONSTRAINT donor_pkey PRIMARY KEY (id);


--
-- TOC entry 3846 (class 2606 OID 2108583)
-- Name: event_param event_param_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY event_param
    ADD CONSTRAINT event_param_pkey PRIMARY KEY (id);


--
-- TOC entry 3844 (class 2606 OID 2108557)
-- Name: event event_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY event
    ADD CONSTRAINT event_pkey PRIMARY KEY (id);


--
-- TOC entry 3848 (class 2606 OID 2108603)
-- Name: external_reference external_reference_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY external_reference
    ADD CONSTRAINT external_reference_pkey PRIMARY KEY (id);


--
-- TOC entry 3850 (class 2606 OID 2108611)
-- Name: genome_map genome_map_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY genome_map
    ADD CONSTRAINT genome_map_pkey PRIMARY KEY (id);


--
-- TOC entry 3852 (class 2606 OID 2108637)
-- Name: geojson geojson_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY geojson
    ADD CONSTRAINT geojson_pkey PRIMARY KEY (id);


--
-- TOC entry 3794 (class 2606 OID 2049058)
-- Name: germplasm_attribute_category germplasm_attribute_category_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY germplasm_attribute_category
    ADD CONSTRAINT germplasm_attribute_category_pkey PRIMARY KEY (id);


--
-- TOC entry 3856 (class 2606 OID 2108659)
-- Name: germplasm_attribute_definition germplasm_attribute_definition_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY germplasm_attribute_definition
    ADD CONSTRAINT germplasm_attribute_definition_pkey PRIMARY KEY (id);


--
-- TOC entry 3858 (class 2606 OID 2108667)
-- Name: germplasm_attribute_value germplasm_attribute_value_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY germplasm_attribute_value
    ADD CONSTRAINT germplasm_attribute_value_pkey PRIMARY KEY (id);


--
-- TOC entry 3860 (class 2606 OID 2108687)
-- Name: germplasm_donor germplasm_donor_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY germplasm_donor
    ADD CONSTRAINT germplasm_donor_pkey PRIMARY KEY (id);


--
-- TOC entry 3862 (class 2606 OID 2108713)
-- Name: germplasm_institute germplasm_institute_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY germplasm_institute
    ADD CONSTRAINT germplasm_institute_pkey PRIMARY KEY (id);


--
-- TOC entry 3864 (class 2606 OID 2108721)
-- Name: germplasm_origin germplasm_origin_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY germplasm_origin
    ADD CONSTRAINT germplasm_origin_pkey PRIMARY KEY (id);


--
-- TOC entry 3854 (class 2606 OID 2108645)
-- Name: germplasm germplasm_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY germplasm
    ADD CONSTRAINT germplasm_pkey PRIMARY KEY (id);


--
-- TOC entry 3866 (class 2606 OID 2108735)
-- Name: germplasm_synonym germplasm_synonym_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY germplasm_synonym
    ADD CONSTRAINT germplasm_synonym_pkey PRIMARY KEY (id);


--
-- TOC entry 3868 (class 2606 OID 2108743)
-- Name: germplasm_taxon germplasm_taxon_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY germplasm_taxon
    ADD CONSTRAINT germplasm_taxon_pkey PRIMARY KEY (id);


--
-- TOC entry 3796 (class 2606 OID 2049097)
-- Name: germplasm_type_storage_code germplasm_type_storage_code_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY germplasm_type_storage_code
    ADD CONSTRAINT germplasm_type_storage_code_pkey PRIMARY KEY (id);


--
-- TOC entry 3870 (class 2606 OID 2108757)
-- Name: image image_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY image
    ADD CONSTRAINT image_pkey PRIMARY KEY (id);


--
-- TOC entry 3872 (class 2606 OID 2108789)
-- Name: linkage_group linkage_group_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY linkage_group
    ADD CONSTRAINT linkage_group_pkey PRIMARY KEY (id);


--
-- TOC entry 3876 (class 2606 OID 2108829)
-- Name: list_item list_item_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY list_item
    ADD CONSTRAINT list_item_pkey PRIMARY KEY (id);


--
-- TOC entry 3874 (class 2606 OID 2108809)
-- Name: list list_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY list
    ADD CONSTRAINT list_pkey PRIMARY KEY (id);


--
-- TOC entry 3878 (class 2606 OID 2108837)
-- Name: location location_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY location
    ADD CONSTRAINT location_pkey PRIMARY KEY (id);


--
-- TOC entry 3800 (class 2606 OID 2049167)
-- Name: marker_analysis_method marker_analysis_method_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY marker_analysis_method
    ADD CONSTRAINT marker_analysis_method_pkey PRIMARY KEY (id);


--
-- TOC entry 3798 (class 2606 OID 2049159)
-- Name: marker marker_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY marker
    ADD CONSTRAINT marker_pkey PRIMARY KEY (id);


--
-- TOC entry 3880 (class 2606 OID 2108857)
-- Name: marker_position marker_position_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY marker_position
    ADD CONSTRAINT marker_position_pkey PRIMARY KEY (id);


--
-- TOC entry 3802 (class 2606 OID 2049181)
-- Name: marker_profile marker_profile_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY marker_profile
    ADD CONSTRAINT marker_profile_pkey PRIMARY KEY (id);


--
-- TOC entry 3804 (class 2606 OID 2049189)
-- Name: marker_reference marker_reference_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY marker_reference
    ADD CONSTRAINT marker_reference_pkey PRIMARY KEY (id);


--
-- TOC entry 3806 (class 2606 OID 2049197)
-- Name: marker_synonym marker_synonym_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY marker_synonym
    ADD CONSTRAINT marker_synonym_pkey PRIMARY KEY (id);


--
-- TOC entry 3882 (class 2606 OID 2108877)
-- Name: method method_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY method
    ADD CONSTRAINT method_pkey PRIMARY KEY (id);


--
-- TOC entry 3886 (class 2606 OID 2108903)
-- Name: observation observation_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY observation
    ADD CONSTRAINT observation_pkey PRIMARY KEY (id);


--
-- TOC entry 3890 (class 2606 OID 2108943)
-- Name: observation_unit_level observation_unit_level_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY observation_unit_level
    ADD CONSTRAINT observation_unit_level_pkey PRIMARY KEY (id);


--
-- TOC entry 3888 (class 2606 OID 2108923)
-- Name: observation_unit observation_unit_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY observation_unit
    ADD CONSTRAINT observation_unit_pkey PRIMARY KEY (id);


--
-- TOC entry 3892 (class 2606 OID 2108951)
-- Name: observation_unit_position observation_unit_position_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY observation_unit_position
    ADD CONSTRAINT observation_unit_position_pkey PRIMARY KEY (id);


--
-- TOC entry 3894 (class 2606 OID 2108959)
-- Name: observation_unit_treatment observation_unit_treatment_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY observation_unit_treatment
    ADD CONSTRAINT observation_unit_treatment_pkey PRIMARY KEY (id);


--
-- TOC entry 3808 (class 2606 OID 2049235)
-- Name: observation_unit_xref observation_unit_xref_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY observation_unit_xref
    ADD CONSTRAINT observation_unit_xref_pkey PRIMARY KEY (id);


--
-- TOC entry 3810 (class 2606 OID 2049251)
-- Name: observation_variable_context observation_variable_context_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY observation_variable_context
    ADD CONSTRAINT observation_variable_context_pkey PRIMARY KEY (id);


--
-- TOC entry 3896 (class 2606 OID 2108967)
-- Name: observation_variable observation_variable_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY observation_variable
    ADD CONSTRAINT observation_variable_pkey PRIMARY KEY (id);


--
-- TOC entry 3812 (class 2606 OID 2049259)
-- Name: observation_variable_synonym observation_variable_synonym_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY observation_variable_synonym
    ADD CONSTRAINT observation_variable_synonym_pkey PRIMARY KEY (id);


--
-- TOC entry 3898 (class 2606 OID 2108975)
-- Name: ontology ontology_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY ontology
    ADD CONSTRAINT ontology_pkey PRIMARY KEY (id);


--
-- TOC entry 3900 (class 2606 OID 2108995)
-- Name: ontology_ref ontology_ref_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY ontology_ref
    ADD CONSTRAINT ontology_ref_pkey PRIMARY KEY (id);


--
-- TOC entry 3902 (class 2606 OID 2109009)
-- Name: pedigree_edge pedigree_edge_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY pedigree_edge
    ADD CONSTRAINT pedigree_edge_pkey PRIMARY KEY (id);


--
-- TOC entry 3904 (class 2606 OID 2109029)
-- Name: pedigree_node pedigree_node_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY pedigree_node
    ADD CONSTRAINT pedigree_node_pkey PRIMARY KEY (id);


--
-- TOC entry 3814 (class 2606 OID 2049283)
-- Name: pedigree pedigree_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY pedigree
    ADD CONSTRAINT pedigree_pkey PRIMARY KEY (id);


--
-- TOC entry 3906 (class 2606 OID 2109049)
-- Name: person person_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY person
    ADD CONSTRAINT person_pkey PRIMARY KEY (id);


--
-- TOC entry 3908 (class 2606 OID 2109069)
-- Name: plate plate_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY plate
    ADD CONSTRAINT plate_pkey PRIMARY KEY (id);


--
-- TOC entry 3910 (class 2606 OID 2109089)
-- Name: plate_submission plate_submission_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY plate_submission
    ADD CONSTRAINT plate_submission_pkey PRIMARY KEY (id);


--
-- TOC entry 3912 (class 2606 OID 2109109)
-- Name: program program_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY program
    ADD CONSTRAINT program_pkey PRIMARY KEY (id);


--
-- TOC entry 3916 (class 2606 OID 2109143)
-- Name: reference_bases reference_bases_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY reference_bases
    ADD CONSTRAINT reference_bases_pkey PRIMARY KEY (id);


--
-- TOC entry 3914 (class 2606 OID 2109129)
-- Name: reference reference_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY reference
    ADD CONSTRAINT reference_pkey PRIMARY KEY (id);


--
-- TOC entry 3918 (class 2606 OID 2109169)
-- Name: reference_set reference_set_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY reference_set
    ADD CONSTRAINT reference_set_pkey PRIMARY KEY (id);


--
-- TOC entry 3920 (class 2606 OID 2109189)
-- Name: sample sample_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY sample
    ADD CONSTRAINT sample_pkey PRIMARY KEY (id);


--
-- TOC entry 3922 (class 2606 OID 2109209)
-- Name: scale scale_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY scale
    ADD CONSTRAINT scale_pkey PRIMARY KEY (id);


--
-- TOC entry 3926 (class 2606 OID 2109235)
-- Name: scale_valid_value_category scale_valid_value_category_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY scale_valid_value_category
    ADD CONSTRAINT scale_valid_value_category_pkey PRIMARY KEY (id);


--
-- TOC entry 3928 (class 2606 OID 2109243)
-- Name: search search_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY search
    ADD CONSTRAINT search_pkey PRIMARY KEY (id);


--
-- TOC entry 3930 (class 2606 OID 2109263)
-- Name: season season_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY season
    ADD CONSTRAINT season_pkey PRIMARY KEY (id);


--
-- TOC entry 3934 (class 2606 OID 2109297)
-- Name: seed_lot_content_mixture seed_lot_content_mixture_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY seed_lot_content_mixture
    ADD CONSTRAINT seed_lot_content_mixture_pkey PRIMARY KEY (id);


--
-- TOC entry 3932 (class 2606 OID 2109283)
-- Name: seed_lot seed_lot_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY seed_lot
    ADD CONSTRAINT seed_lot_pkey PRIMARY KEY (id);


--
-- TOC entry 3936 (class 2606 OID 2109311)
-- Name: seed_lot_transaction seed_lot_transaction_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY seed_lot_transaction
    ADD CONSTRAINT seed_lot_transaction_pkey PRIMARY KEY (id);


--
-- TOC entry 3940 (class 2606 OID 2109351)
-- Name: study_data_link study_data_link_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY study_data_link
    ADD CONSTRAINT study_data_link_pkey PRIMARY KEY (id);


--
-- TOC entry 3942 (class 2606 OID 2109359)
-- Name: study_environment_parameter study_environment_parameter_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY study_environment_parameter
    ADD CONSTRAINT study_environment_parameter_pkey PRIMARY KEY (id);


--
-- TOC entry 3944 (class 2606 OID 2109367)
-- Name: study_experimental_design study_experimental_design_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY study_experimental_design
    ADD CONSTRAINT study_experimental_design_pkey PRIMARY KEY (id);


--
-- TOC entry 3946 (class 2606 OID 2109381)
-- Name: study_growth_facility study_growth_facility_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY study_growth_facility
    ADD CONSTRAINT study_growth_facility_pkey PRIMARY KEY (id);


--
-- TOC entry 3948 (class 2606 OID 2109389)
-- Name: study_last_update study_last_update_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY study_last_update
    ADD CONSTRAINT study_last_update_pkey PRIMARY KEY (id);


--
-- TOC entry 3950 (class 2606 OID 2109397)
-- Name: study_observation_level study_observation_level_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY study_observation_level
    ADD CONSTRAINT study_observation_level_pkey PRIMARY KEY (id);


--
-- TOC entry 3938 (class 2606 OID 2109331)
-- Name: study study_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY study
    ADD CONSTRAINT study_pkey PRIMARY KEY (id);


--
-- TOC entry 3816 (class 2606 OID 2049401)
-- Name: study_type study_type_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY study_type
    ADD CONSTRAINT study_type_pkey PRIMARY KEY (id);


--
-- TOC entry 3818 (class 2606 OID 2049409)
-- Name: taxon taxon_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY taxon
    ADD CONSTRAINT taxon_pkey PRIMARY KEY (id);


--
-- TOC entry 3954 (class 2606 OID 2109425)
-- Name: trait_abbreviation trait_abbreviation_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY trait_abbreviation
    ADD CONSTRAINT trait_abbreviation_pkey PRIMARY KEY (id);


--
-- TOC entry 3952 (class 2606 OID 2109417)
-- Name: trait trait_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY trait
    ADD CONSTRAINT trait_pkey PRIMARY KEY (id);


--
-- TOC entry 3958 (class 2606 OID 2109451)
-- Name: trait_synonym trait_synonym_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY trait_synonym
    ADD CONSTRAINT trait_synonym_pkey PRIMARY KEY (id);


--
-- TOC entry 3820 (class 2606 OID 2049447)
-- Name: treatment treatment_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY treatment
    ADD CONSTRAINT treatment_pkey PRIMARY KEY (id);


--
-- TOC entry 3962 (class 2606 OID 2109491)
-- Name: trial_dataset_authorship trial_dataset_authorship_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY trial_dataset_authorship
    ADD CONSTRAINT trial_dataset_authorship_pkey PRIMARY KEY (id);


--
-- TOC entry 3960 (class 2606 OID 2109471)
-- Name: trial trial_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY trial
    ADD CONSTRAINT trial_pkey PRIMARY KEY (id);


--
-- TOC entry 3964 (class 2606 OID 2109505)
-- Name: trial_publication trial_publication_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY trial_publication
    ADD CONSTRAINT trial_publication_pkey PRIMARY KEY (id);


--
-- TOC entry 3884 (class 2606 OID 2109755)
-- Name: method_ontology_reference uk_2o2ygrws59ot8awt3bespoboe; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY method_ontology_reference
    ADD CONSTRAINT uk_2o2ygrws59ot8awt3bespoboe UNIQUE (ontology_reference_id);


--
-- TOC entry 3956 (class 2606 OID 2109759)
-- Name: trait_ontology_reference uk_6dpui3np8x0r3x6lku3jyuyts; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY trait_ontology_reference
    ADD CONSTRAINT uk_6dpui3np8x0r3x6lku3jyuyts UNIQUE (ontology_reference_id);


--
-- TOC entry 3924 (class 2606 OID 2109757)
-- Name: scale_ontology_reference uk_ac9pepdho097g1h1uvpqspcdk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY scale_ontology_reference
    ADD CONSTRAINT uk_ac9pepdho097g1h1uvpqspcdk UNIQUE (ontology_reference_id);


--
-- TOC entry 3968 (class 2606 OID 2109761)
-- Name: variable_base_entity_ontology_reference uk_b01mhfwes5mno4yqnews4dxht; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY variable_base_entity_ontology_reference
    ADD CONSTRAINT uk_b01mhfwes5mno4yqnews4dxht UNIQUE (ontology_reference_id);


--
-- TOC entry 3966 (class 2606 OID 2109513)
-- Name: variable_base_entity variable_base_entity_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY variable_base_entity
    ADD CONSTRAINT variable_base_entity_pkey PRIMARY KEY (id);


--
-- TOC entry 3970 (class 2606 OID 2109551)
-- Name: variant variant_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY variant
    ADD CONSTRAINT variant_pkey PRIMARY KEY (id);


--
-- TOC entry 3974 (class 2606 OID 2109609)
-- Name: variantset_analysis variantset_analysis_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY variantset_analysis
    ADD CONSTRAINT variantset_analysis_pkey PRIMARY KEY (id);


--
-- TOC entry 3976 (class 2606 OID 2109623)
-- Name: variantset_format variantset_format_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY variantset_format
    ADD CONSTRAINT variantset_format_pkey PRIMARY KEY (id);


--
-- TOC entry 3972 (class 2606 OID 2109595)
-- Name: variantset variantset_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY variantset
    ADD CONSTRAINT variantset_pkey PRIMARY KEY (id);


--
-- TOC entry 3978 (class 2606 OID 2109637)
-- Name: vendor_file vendor_file_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY vendor_file
    ADD CONSTRAINT vendor_file_pkey PRIMARY KEY (id);


--
-- TOC entry 3998 (class 2606 OID 2109747)
-- Name: vendor_order_entity_required_service_info vendor_order_entity_required_service_info_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY vendor_order_entity_required_service_info
    ADD CONSTRAINT vendor_order_entity_required_service_info_pkey PRIMARY KEY (vendor_order_entity_id, required_service_info_key);


--
-- TOC entry 3980 (class 2606 OID 2109651)
-- Name: vendor_order vendor_order_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY vendor_order
    ADD CONSTRAINT vendor_order_pkey PRIMARY KEY (id);


--
-- TOC entry 3984 (class 2606 OID 2109685)
-- Name: vendor_spec_deliverable vendor_spec_deliverable_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY vendor_spec_deliverable
    ADD CONSTRAINT vendor_spec_deliverable_pkey PRIMARY KEY (id);


--
-- TOC entry 3986 (class 2606 OID 2109699)
-- Name: vendor_spec_input_format vendor_spec_input_format_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY vendor_spec_input_format
    ADD CONSTRAINT vendor_spec_input_format_pkey PRIMARY KEY (id);


--
-- TOC entry 3982 (class 2606 OID 2109671)
-- Name: vendor_spec vendor_spec_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY vendor_spec
    ADD CONSTRAINT vendor_spec_pkey PRIMARY KEY (id);


--
-- TOC entry 3988 (class 2606 OID 2109707)
-- Name: vendor_spec_platform vendor_spec_platform_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY vendor_spec_platform
    ADD CONSTRAINT vendor_spec_platform_pkey PRIMARY KEY (id);


--
-- TOC entry 3990 (class 2606 OID 2109715)
-- Name: vendor_spec_requirement vendor_spec_requirement_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY vendor_spec_requirement
    ADD CONSTRAINT vendor_spec_requirement_pkey PRIMARY KEY (id);


--
-- TOC entry 3992 (class 2606 OID 2109723)
-- Name: vendor_spec_sample_type vendor_spec_sample_type_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY vendor_spec_sample_type
    ADD CONSTRAINT vendor_spec_sample_type_pkey PRIMARY KEY (id);


--
-- TOC entry 3994 (class 2606 OID 2109731)
-- Name: vendor_spec_status vendor_spec_status_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY vendor_spec_status
    ADD CONSTRAINT vendor_spec_status_pkey PRIMARY KEY (id);


--
-- TOC entry 3996 (class 2606 OID 2109739)
-- Name: vendor_spec_well_position vendor_spec_well_position_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY vendor_spec_well_position
    ADD CONSTRAINT vendor_spec_well_position_pkey PRIMARY KEY (id);


--
-- TOC entry 4302 (class 2606 OID 2111237)
-- Name: trial_external_references fk155y3dfx5kbikdaea1ev83f2q; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY trial_external_references
    ADD CONSTRAINT fk155y3dfx5kbikdaea1ev83f2q FOREIGN KEY (trial_entity_id) REFERENCES trial(id);


--
-- TOC entry 4213 (class 2606 OID 2110782)
-- Name: reference_bases_additional_info fk15msc1p6ecwt2epe5hlnpjps; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY reference_bases_additional_info
    ADD CONSTRAINT fk15msc1p6ecwt2epe5hlnpjps FOREIGN KEY (additional_info_id) REFERENCES additional_info(id);


--
-- TOC entry 4337 (class 2606 OID 2111412)
-- Name: vendor_order_external_references fk16n0vjl5dqid2b3q1q7jv2jrp; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY vendor_order_external_references
    ADD CONSTRAINT fk16n0vjl5dqid2b3q1q7jv2jrp FOREIGN KEY (vendor_order_entity_id) REFERENCES vendor_order(id);


--
-- TOC entry 4107 (class 2606 OID 2110252)
-- Name: linkage_group_external_references fk16nwhdphvsrkfo7ldgnsiikq4; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY linkage_group_external_references
    ADD CONSTRAINT fk16nwhdphvsrkfo7ldgnsiikq4 FOREIGN KEY (external_references_id) REFERENCES external_reference(id);


--
-- TOC entry 4239 (class 2606 OID 2110912)
-- Name: scale_ontology_reference fk1baxxkxrgpqqd5inp7rdl2ww6; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY scale_ontology_reference
    ADD CONSTRAINT fk1baxxkxrgpqqd5inp7rdl2ww6 FOREIGN KEY (ontology_reference_id) REFERENCES ontology_ref(id);


--
-- TOC entry 4153 (class 2606 OID 2110487)
-- Name: observation_unit fk1bj7oq9sdtdy9sy73gj3lvxrg; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY observation_unit
    ADD CONSTRAINT fk1bj7oq9sdtdy9sy73gj3lvxrg FOREIGN KEY (trial_id) REFERENCES trial(id);


--
-- TOC entry 4225 (class 2606 OID 2110847)
-- Name: sample fk1bqip06xsj05fdvhodjwta4i2; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY sample
    ADD CONSTRAINT fk1bqip06xsj05fdvhodjwta4i2 FOREIGN KEY (program_id) REFERENCES program(id);


--
-- TOC entry 4113 (class 2606 OID 2110287)
-- Name: list_item fk1ddq3ct1ulogjn5ijs8ert7hw; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY list_item
    ADD CONSTRAINT fk1ddq3ct1ulogjn5ijs8ert7hw FOREIGN KEY (list_id) REFERENCES list(id);


--
-- TOC entry 4059 (class 2606 OID 2110012)
-- Name: genome_map_additional_info fk1hawjjuuobdeiqip746d0n84t; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY genome_map_additional_info
    ADD CONSTRAINT fk1hawjjuuobdeiqip746d0n84t FOREIGN KEY (additional_info_id) REFERENCES additional_info(id);


--
-- TOC entry 4138 (class 2606 OID 2110412)
-- Name: observation fk1hq66wld7ivshnikvlh2e3aal; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY observation
    ADD CONSTRAINT fk1hq66wld7ivshnikvlh2e3aal FOREIGN KEY (observation_variable_id) REFERENCES observation_variable(id);


--
-- TOC entry 4066 (class 2606 OID 2110057)
-- Name: germplasm_additional_info fk1i1cs1yjfqsapf370hkdowskf; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY germplasm_additional_info
    ADD CONSTRAINT fk1i1cs1yjfqsapf370hkdowskf FOREIGN KEY (germplasm_entity_id) REFERENCES germplasm(id);


--
-- TOC entry 4087 (class 2606 OID 2110162)
-- Name: germplasm_origin fk1m54g844qt69f241brkregk05; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY germplasm_origin
    ADD CONSTRAINT fk1m54g844qt69f241brkregk05 FOREIGN KEY (germplasm_id) REFERENCES germplasm(id);


--
-- TOC entry 4280 (class 2606 OID 2111127)
-- Name: study_season fk1r2518mglhwijy5mk31cfxh3h; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY study_season
    ADD CONSTRAINT fk1r2518mglhwijy5mk31cfxh3h FOREIGN KEY (study_db_id) REFERENCES study(id);


--
-- TOC entry 4181 (class 2606 OID 2110632)
-- Name: pedigree_node_additional_info fk1t5n6ki879po879s67awvsm8y; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY pedigree_node_additional_info
    ADD CONSTRAINT fk1t5n6ki879po879s67awvsm8y FOREIGN KEY (pedigree_node_entity_id) REFERENCES pedigree_node(id);


--
-- TOC entry 4136 (class 2606 OID 2110402)
-- Name: observation fk1x98o95hroreu8udh810pyrsp; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY observation
    ADD CONSTRAINT fk1x98o95hroreu8udh810pyrsp FOREIGN KEY (geo_coordinates_id) REFERENCES geojson(id);


--
-- TOC entry 4040 (class 2606 OID 2109922)
-- Name: cross_pollination_event fk1ypb9s2niakjr3ihaphptv091; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY cross_pollination_event
    ADD CONSTRAINT fk1ypb9s2niakjr3ihaphptv091 FOREIGN KEY (cross_id) REFERENCES cross_entity(id);


--
-- TOC entry 4013 (class 2606 OID 2109782)
-- Name: allele_call_external_references fk21j9fleiujdbdh1le1qxgvu76; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY allele_call_external_references
    ADD CONSTRAINT fk21j9fleiujdbdh1le1qxgvu76 FOREIGN KEY (external_references_id) REFERENCES external_reference(id);


--
-- TOC entry 4238 (class 2606 OID 2110917)
-- Name: scale_ontology_reference fk23l4o7tx5iov7l8x61ektcvig; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY scale_ontology_reference
    ADD CONSTRAINT fk23l4o7tx5iov7l8x61ektcvig FOREIGN KEY (scale_entity_id) REFERENCES scale(id);


--
-- TOC entry 4052 (class 2606 OID 2109987)
-- Name: event_observation_units fk24gave7q07chv8pklo27ffjvq; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY event_observation_units
    ADD CONSTRAINT fk24gave7q07chv8pklo27ffjvq FOREIGN KEY (event_entity_id) REFERENCES event(id);


--
-- TOC entry 4288 (class 2606 OID 2111167)
-- Name: trait_external_references fk26xyvg9wub4k3iv7519mi4fm6; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY trait_external_references
    ADD CONSTRAINT fk26xyvg9wub4k3iv7519mi4fm6 FOREIGN KEY (trait_entity_id) REFERENCES trait(id);


--
-- TOC entry 4253 (class 2606 OID 2110997)
-- Name: seed_lot_content_mixture fk27vg35ttok90l5a06j0pkcacm; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY seed_lot_content_mixture
    ADD CONSTRAINT fk27vg35ttok90l5a06j0pkcacm FOREIGN KEY (seed_lot_id) REFERENCES seed_lot(id);


--
-- TOC entry 4078 (class 2606 OID 2110107)
-- Name: germplasm_attribute_value_external_references fk2c187mbrv5ib1a0cpdq82i2aw; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY germplasm_attribute_value_external_references
    ADD CONSTRAINT fk2c187mbrv5ib1a0cpdq82i2aw FOREIGN KEY (external_references_id) REFERENCES external_reference(id);


--
-- TOC entry 4297 (class 2606 OID 2111212)
-- Name: trial_additional_info fk2eb8mjd3rilh4qrwgivoocg70; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY trial_additional_info
    ADD CONSTRAINT fk2eb8mjd3rilh4qrwgivoocg70 FOREIGN KEY (trial_entity_id) REFERENCES trial(id);


--
-- TOC entry 4105 (class 2606 OID 2110242)
-- Name: linkage_group_additional_info fk2k54io95dt7kw0t4vla1lexty; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY linkage_group_additional_info
    ADD CONSTRAINT fk2k54io95dt7kw0t4vla1lexty FOREIGN KEY (additional_info_id) REFERENCES additional_info(id);


--
-- TOC entry 4196 (class 2606 OID 2110697)
-- Name: plate_external_references fk2k8s555m1pytepl5wq7ajgyu; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY plate_external_references
    ADD CONSTRAINT fk2k8s555m1pytepl5wq7ajgyu FOREIGN KEY (external_references_id) REFERENCES external_reference(id);


--
-- TOC entry 4160 (class 2606 OID 2110527)
-- Name: observation_unit_position fk2mpgvaq1ppb8kjp3jk0ecpdyr; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY observation_unit_position
    ADD CONSTRAINT fk2mpgvaq1ppb8kjp3jk0ecpdyr FOREIGN KEY (observation_unit_id) REFERENCES observation_unit(id);


--
-- TOC entry 4106 (class 2606 OID 2110257)
-- Name: linkage_group_external_references fk2ngce8lv4jokyjhp72idxc4wp; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY linkage_group_external_references
    ADD CONSTRAINT fk2ngce8lv4jokyjhp72idxc4wp FOREIGN KEY (linkage_group_entity_id) REFERENCES linkage_group(id);


--
-- TOC entry 4057 (class 2606 OID 2110007)
-- Name: genome_map fk2qfrqxw83mn6f9s4j6pl018s4; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY genome_map
    ADD CONSTRAINT fk2qfrqxw83mn6f9s4j6pl018s4 FOREIGN KEY (crop_id) REFERENCES crop(id);


--
-- TOC entry 4332 (class 2606 OID 2111382)
-- Name: vendor_file fk2sn16vflr7mjc9riwq7ee7fxk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY vendor_file
    ADD CONSTRAINT fk2sn16vflr7mjc9riwq7ee7fxk FOREIGN KEY (order_id) REFERENCES vendor_order(id);


--
-- TOC entry 4151 (class 2606 OID 2110477)
-- Name: observation_unit fk2u88bau3wx0bpb3f4lq0309vt; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY observation_unit
    ADD CONSTRAINT fk2u88bau3wx0bpb3f4lq0309vt FOREIGN KEY (seed_lot_id) REFERENCES seed_lot(id);


--
-- TOC entry 4048 (class 2606 OID 2109967)
-- Name: event_additional_info fk2xgtj0io4e3cvq3t4xpoukf5v; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY event_additional_info
    ADD CONSTRAINT fk2xgtj0io4e3cvq3t4xpoukf5v FOREIGN KEY (event_entity_id) REFERENCES event(id);


--
-- TOC entry 4039 (class 2606 OID 2109902)
-- Name: cross_parent fk31xx5db8iq2y9mtv110qxvfwg; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY cross_parent
    ADD CONSTRAINT fk31xx5db8iq2y9mtv110qxvfwg FOREIGN KEY (cross_id) REFERENCES cross_entity(id);


--
-- TOC entry 4099 (class 2606 OID 2110212)
-- Name: image_external_references fk33bdd9xb6yxr8bnvov4shkx5a; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY image_external_references
    ADD CONSTRAINT fk33bdd9xb6yxr8bnvov4shkx5a FOREIGN KEY (external_references_id) REFERENCES external_reference(id);


--
-- TOC entry 4053 (class 2606 OID 2109982)
-- Name: event_observation_units fk3ecq9fb2rd3qampc61hunr7sw; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY event_observation_units
    ADD CONSTRAINT fk3ecq9fb2rd3qampc61hunr7sw FOREIGN KEY (observation_units_id) REFERENCES observation_unit(id);


--
-- TOC entry 4083 (class 2606 OID 2110132)
-- Name: germplasm_donor_external_references fk3hdirn24cor15lmm3syjj9pag; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY germplasm_donor_external_references
    ADD CONSTRAINT fk3hdirn24cor15lmm3syjj9pag FOREIGN KEY (external_references_id) REFERENCES external_reference(id);


--
-- TOC entry 4080 (class 2606 OID 2110127)
-- Name: germplasm_donor_additional_info fk3mg5891rrdo0bnnwvw4775er6; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY germplasm_donor_additional_info
    ADD CONSTRAINT fk3mg5891rrdo0bnnwvw4775er6 FOREIGN KEY (donor_entity_id) REFERENCES germplasm_donor(id);


--
-- TOC entry 4304 (class 2606 OID 2111242)
-- Name: trial_publication fk3mtl83xv18xwseiuvrog2crft; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY trial_publication
    ADD CONSTRAINT fk3mtl83xv18xwseiuvrog2crft FOREIGN KEY (trial_id) REFERENCES trial(id);


--
-- TOC entry 4029 (class 2606 OID 2109862)
-- Name: crop_external_references fk3nlkk7gvg1523b3lbsy2q1eec; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY crop_external_references
    ADD CONSTRAINT fk3nlkk7gvg1523b3lbsy2q1eec FOREIGN KEY (external_references_id) REFERENCES external_reference(id);


--
-- TOC entry 4127 (class 2606 OID 2110352)
-- Name: marker_position_external_references fk3pnhmjxx9bqp3rl5lo3pgos1g; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY marker_position_external_references
    ADD CONSTRAINT fk3pnhmjxx9bqp3rl5lo3pgos1g FOREIGN KEY (external_references_id) REFERENCES external_reference(id);


--
-- TOC entry 4307 (class 2606 OID 2111257)
-- Name: variable_base_entity fk3qk7upe0cpk9r8vkjwn82bigc; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY variable_base_entity
    ADD CONSTRAINT fk3qk7upe0cpk9r8vkjwn82bigc FOREIGN KEY (ontology_id) REFERENCES ontology(id);


--
-- TOC entry 4295 (class 2606 OID 2111202)
-- Name: trial fk3qx9s6f3fgimmnmcw95djunib; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY trial
    ADD CONSTRAINT fk3qx9s6f3fgimmnmcw95djunib FOREIGN KEY (program_id) REFERENCES program(id);


--
-- TOC entry 4074 (class 2606 OID 2110087)
-- Name: germplasm_attribute_value fk46y58bqrvcn0gymou6h0ypka8; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY germplasm_attribute_value
    ADD CONSTRAINT fk46y58bqrvcn0gymou6h0ypka8 FOREIGN KEY (attribute_id) REFERENCES germplasm_attribute_definition(id);


--
-- TOC entry 4126 (class 2606 OID 2110357)
-- Name: marker_position_external_references fk4akvkw4j7xa9xc3cwa8cr60if; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY marker_position_external_references
    ADD CONSTRAINT fk4akvkw4j7xa9xc3cwa8cr60if FOREIGN KEY (marker_position_entity_id) REFERENCES marker_position(id);


--
-- TOC entry 4019 (class 2606 OID 2109822)
-- Name: callset_additional_info fk4d8ped8ryq98f5rxf29ooya4f; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY callset_additional_info
    ADD CONSTRAINT fk4d8ped8ryq98f5rxf29ooya4f FOREIGN KEY (call_set_entity_id) REFERENCES callset(id);


--
-- TOC entry 4260 (class 2606 OID 2111027)
-- Name: seed_lot_transaction_additional_info fk4e883texgqul3lmwtu2gujwpx; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY seed_lot_transaction_additional_info
    ADD CONSTRAINT fk4e883texgqul3lmwtu2gujwpx FOREIGN KEY (seed_lot_transaction_entity_id) REFERENCES seed_lot_transaction(id);


--
-- TOC entry 4110 (class 2606 OID 2110267)
-- Name: list_additional_info fk4eeibramx6al3t1gswwmdr47k; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY list_additional_info
    ADD CONSTRAINT fk4eeibramx6al3t1gswwmdr47k FOREIGN KEY (additional_info_id) REFERENCES additional_info(id);


--
-- TOC entry 4030 (class 2606 OID 2109877)
-- Name: cross_entity fk4f1fo4874si5ggfcpi8ui1p8x; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY cross_entity
    ADD CONSTRAINT fk4f1fo4874si5ggfcpi8ui1p8x FOREIGN KEY (planned_cross_id) REFERENCES cross_entity(id);


--
-- TOC entry 4326 (class 2606 OID 2111347)
-- Name: variantset_additional_info fk4fye0aosi1a6m8hcd9lmmo5b7; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY variantset_additional_info
    ADD CONSTRAINT fk4fye0aosi1a6m8hcd9lmmo5b7 FOREIGN KEY (additional_info_id) REFERENCES additional_info(id);


--
-- TOC entry 4204 (class 2606 OID 2110747)
-- Name: program_additional_info fk4g2ai4vsbheaqta3lgxtlnslh; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY program_additional_info
    ADD CONSTRAINT fk4g2ai4vsbheaqta3lgxtlnslh FOREIGN KEY (program_entity_id) REFERENCES program(id);


--
-- TOC entry 4201 (class 2606 OID 2110722)
-- Name: plate_submission_external_references fk4jlk3xi2ifr0b4jna9w4eu22u; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY plate_submission_external_references
    ADD CONSTRAINT fk4jlk3xi2ifr0b4jna9w4eu22u FOREIGN KEY (external_references_id) REFERENCES external_reference(id);


--
-- TOC entry 4343 (class 2606 OID 2111437)
-- Name: vendor_spec_platform fk4jodgfv6misu1xqyo5j4285mm; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY vendor_spec_platform
    ADD CONSTRAINT fk4jodgfv6misu1xqyo5j4285mm FOREIGN KEY (standard_requirements_id) REFERENCES vendor_spec_requirement(id);


--
-- TOC entry 4312 (class 2606 OID 2111282)
-- Name: variable_base_entity_ontology_reference fk4kfhpym5gotqg7ebh9rxs7pli; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY variable_base_entity_ontology_reference
    ADD CONSTRAINT fk4kfhpym5gotqg7ebh9rxs7pli FOREIGN KEY (ontology_reference_id) REFERENCES ontology_ref(id);


--
-- TOC entry 4200 (class 2606 OID 2110727)
-- Name: plate_submission_external_references fk4qkh6qsuqtjrp8hj73kn6h0su; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY plate_submission_external_references
    ADD CONSTRAINT fk4qkh6qsuqtjrp8hj73kn6h0su FOREIGN KEY (vendor_plate_submission_entity_id) REFERENCES plate_submission(id);


--
-- TOC entry 4143 (class 2606 OID 2110442)
-- Name: observation_additional_info fk4y4b5emdnydsykk68m9h7u5yn; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY observation_additional_info
    ADD CONSTRAINT fk4y4b5emdnydsykk68m9h7u5yn FOREIGN KEY (observation_entity_id) REFERENCES observation(id);


--
-- TOC entry 4252 (class 2606 OID 2110977)
-- Name: seed_lot_additional_info fk54dkn5sk0ojmksu6lrwxlj581; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY seed_lot_additional_info
    ADD CONSTRAINT fk54dkn5sk0ojmksu6lrwxlj581 FOREIGN KEY (additional_info_id) REFERENCES additional_info(id);


--
-- TOC entry 4306 (class 2606 OID 2111252)
-- Name: variable_base_entity fk57jt68g5lrxm88511ytte8wgs; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY variable_base_entity
    ADD CONSTRAINT fk57jt68g5lrxm88511ytte8wgs FOREIGN KEY (method_id) REFERENCES method(id);


--
-- TOC entry 4061 (class 2606 OID 2110022)
-- Name: genome_map_external_references fk59wyewdtq53rnxkn55grh1nin; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY genome_map_external_references
    ADD CONSTRAINT fk59wyewdtq53rnxkn55grh1nin FOREIGN KEY (external_references_id) REFERENCES external_reference(id);


--
-- TOC entry 4121 (class 2606 OID 2110322)
-- Name: location_external_references fk5bqkr4t3ly4sxsx13i76iw55f; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY location_external_references
    ADD CONSTRAINT fk5bqkr4t3ly4sxsx13i76iw55f FOREIGN KEY (external_references_id) REFERENCES external_reference(id);


--
-- TOC entry 4180 (class 2606 OID 2110617)
-- Name: pedigree_node fk5dmsm0lvenioadacb4gdvrv2q; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY pedigree_node
    ADD CONSTRAINT fk5dmsm0lvenioadacb4gdvrv2q FOREIGN KEY (crossing_project_id) REFERENCES crossing_project(id);


--
-- TOC entry 4174 (class 2606 OID 2110587)
-- Name: pedigree_edge fk5ds4uo4f3tsurnjtc8dxb7w6r; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY pedigree_edge
    ADD CONSTRAINT fk5ds4uo4f3tsurnjtc8dxb7w6r FOREIGN KEY (connceted_node_id) REFERENCES pedigree_node(id);


--
-- TOC entry 4229 (class 2606 OID 2110872)
-- Name: sample_additional_info fk5jvdgvkhrsxdhp87673niumtp; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY sample_additional_info
    ADD CONSTRAINT fk5jvdgvkhrsxdhp87673niumtp FOREIGN KEY (sample_entity_id) REFERENCES sample(id);


--
-- TOC entry 4217 (class 2606 OID 2110802)
-- Name: reference_external_references fk5nv26mmefckw1a3tilk3jvd58; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY reference_external_references
    ADD CONSTRAINT fk5nv26mmefckw1a3tilk3jvd58 FOREIGN KEY (external_references_id) REFERENCES external_reference(id);


--
-- TOC entry 4008 (class 2606 OID 2109767)
-- Name: allele_call fk5or2m3i1fuaq8btgm1dncqwqy; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY allele_call
    ADD CONSTRAINT fk5or2m3i1fuaq8btgm1dncqwqy FOREIGN KEY (variant_id) REFERENCES variant(id);


--
-- TOC entry 4287 (class 2606 OID 2111152)
-- Name: trait_additional_info fk5sac9abi3nn6lwlt0p68yjg9b; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY trait_additional_info
    ADD CONSTRAINT fk5sac9abi3nn6lwlt0p68yjg9b FOREIGN KEY (additional_info_id) REFERENCES additional_info(id);


--
-- TOC entry 4199 (class 2606 OID 2110712)
-- Name: plate_submission_additional_info fk5splfe3pqyuyg27n7i4vexmxa; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY plate_submission_additional_info
    ADD CONSTRAINT fk5splfe3pqyuyg27n7i4vexmxa FOREIGN KEY (additional_info_id) REFERENCES additional_info(id);


--
-- TOC entry 4131 (class 2606 OID 2110382)
-- Name: method_external_references fk5sxdvhf5m5gvh04f4f1vubgh8; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY method_external_references
    ADD CONSTRAINT fk5sxdvhf5m5gvh04f4f1vubgh8 FOREIGN KEY (method_entity_id) REFERENCES method(id);


--
-- TOC entry 4168 (class 2606 OID 2110567)
-- Name: ontology_additional_info fk5vn4w4w53dh5jbvp3jg35tpy2; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY ontology_additional_info
    ADD CONSTRAINT fk5vn4w4w53dh5jbvp3jg35tpy2 FOREIGN KEY (ontology_entity_id) REFERENCES ontology(id);


--
-- TOC entry 4150 (class 2606 OID 2110472)
-- Name: observation_unit fk5w9953xfgu6ktfwude521yhaj; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY observation_unit
    ADD CONSTRAINT fk5w9953xfgu6ktfwude521yhaj FOREIGN KEY (program_id) REFERENCES program(id);


--
-- TOC entry 4209 (class 2606 OID 2110772)
-- Name: reference_additional_info fk5yu6dt6n29x5le3bsncfgtih2; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY reference_additional_info
    ADD CONSTRAINT fk5yu6dt6n29x5le3bsncfgtih2 FOREIGN KEY (reference_entity_id) REFERENCES reference(id);


--
-- TOC entry 4170 (class 2606 OID 2110577)
-- Name: ontology_external_references fk60ha4xhme1qcj9qlef16x5uf4; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY ontology_external_references
    ADD CONSTRAINT fk60ha4xhme1qcj9qlef16x5uf4 FOREIGN KEY (ontology_entity_id) REFERENCES ontology(id);


--
-- TOC entry 4311 (class 2606 OID 2111277)
-- Name: variable_base_entity_external_references fk61jsniwx483plyg24f7avmtbf; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY variable_base_entity_external_references
    ADD CONSTRAINT fk61jsniwx483plyg24f7avmtbf FOREIGN KEY (external_references_id) REFERENCES external_reference(id);


--
-- TOC entry 4104 (class 2606 OID 2110247)
-- Name: linkage_group_additional_info fk66sqs3iw3hqvtjgtkvoysja10; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY linkage_group_additional_info
    ADD CONSTRAINT fk66sqs3iw3hqvtjgtkvoysja10 FOREIGN KEY (linkage_group_entity_id) REFERENCES linkage_group(id);


--
-- TOC entry 4079 (class 2606 OID 2110117)
-- Name: germplasm_donor fk6e02we60r9ut32qqhxb86ca72; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY germplasm_donor
    ADD CONSTRAINT fk6e02we60r9ut32qqhxb86ca72 FOREIGN KEY (germplasm_id) REFERENCES germplasm(id);


--
-- TOC entry 4089 (class 2606 OID 2110172)
-- Name: germplasm_search_results fk6ett5g30uvf3d4101e7ndoj8c; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY germplasm_search_results
    ADD CONSTRAINT fk6ett5g30uvf3d4101e7ndoj8c FOREIGN KEY (germplasm_entity_id) REFERENCES germplasm(id);


--
-- TOC entry 4274 (class 2606 OID 2111092)
-- Name: study_experimental_design fk6p1eig0ibi880tu9yr3vd8yfn; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY study_experimental_design
    ADD CONSTRAINT fk6p1eig0ibi880tu9yr3vd8yfn FOREIGN KEY (study_id) REFERENCES study(id);


--
-- TOC entry 4223 (class 2606 OID 2110837)
-- Name: sample fk6pcuvra9s7ysh4yn2tb6wq17c; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY sample
    ADD CONSTRAINT fk6pcuvra9s7ysh4yn2tb6wq17c FOREIGN KEY (observation_unit_id) REFERENCES observation_unit(id);


--
-- TOC entry 4090 (class 2606 OID 2110167)
-- Name: germplasm_search_results fk723l9hcq17n2o9ugya6acumrp; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY germplasm_search_results
    ADD CONSTRAINT fk723l9hcq17n2o9ugya6acumrp FOREIGN KEY (search_results_id) REFERENCES search(id);


--
-- TOC entry 4269 (class 2606 OID 2111062)
-- Name: study_additional_info fk72shuems686re1rmmt7fkgn02; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY study_additional_info
    ADD CONSTRAINT fk72shuems686re1rmmt7fkgn02 FOREIGN KEY (additional_info_id) REFERENCES additional_info(id);


--
-- TOC entry 4076 (class 2606 OID 2110097)
-- Name: germplasm_attribute_value_additional_info fk72yvh7709xknefvu6w32la2px; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY germplasm_attribute_value_additional_info
    ADD CONSTRAINT fk72yvh7709xknefvu6w32la2px FOREIGN KEY (additional_info_id) REFERENCES additional_info(id);


--
-- TOC entry 4116 (class 2606 OID 2110297)
-- Name: location fk736fp12vj9i045h2cky7v50ex; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY location
    ADD CONSTRAINT fk736fp12vj9i045h2cky7v50ex FOREIGN KEY (crop_id) REFERENCES crop(id);


--
-- TOC entry 4001 (class 2606 OID 2049592)
-- Name: allele fk7438rbsgpvpdlc46u1akn2pwr; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY allele
    ADD CONSTRAINT fk7438rbsgpvpdlc46u1akn2pwr FOREIGN KEY (marker_id) REFERENCES marker(id);


--
-- TOC entry 4120 (class 2606 OID 2110327)
-- Name: location_external_references fk74i4il2jg8ce0gi8evy3m9qto; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY location_external_references
    ADD CONSTRAINT fk74i4il2jg8ce0gi8evy3m9qto FOREIGN KEY (location_entity_id) REFERENCES location(id);


--
-- TOC entry 4020 (class 2606 OID 2109817)
-- Name: callset_additional_info fk7946n9h72ghfopq9trg4cd8jy; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY callset_additional_info
    ADD CONSTRAINT fk7946n9h72ghfopq9trg4cd8jy FOREIGN KEY (additional_info_id) REFERENCES additional_info(id);


--
-- TOC entry 4145 (class 2606 OID 2110452)
-- Name: observation_external_references fk7bawm29wrk4oska2qqc9pv01p; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY observation_external_references
    ADD CONSTRAINT fk7bawm29wrk4oska2qqc9pv01p FOREIGN KEY (observation_entity_id) REFERENCES observation(id);


--
-- TOC entry 3999 (class 2606 OID 2049602)
-- Name: allele fk7fhkq0vxoekubgoraxv18efyt; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY allele
    ADD CONSTRAINT fk7fhkq0vxoekubgoraxv18efyt FOREIGN KEY (matrix_id) REFERENCES allele_matrix(id);


--
-- TOC entry 4234 (class 2606 OID 2110897)
-- Name: scale_additional_info fk7gl7xa8xao4g810motmx4gy5m; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY scale_additional_info
    ADD CONSTRAINT fk7gl7xa8xao4g810motmx4gy5m FOREIGN KEY (scale_entity_id) REFERENCES scale(id);


--
-- TOC entry 4128 (class 2606 OID 2110362)
-- Name: method fk7i2hysyf1rsfk7bmeh50hfqrm; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY method
    ADD CONSTRAINT fk7i2hysyf1rsfk7bmeh50hfqrm FOREIGN KEY (ontology_id) REFERENCES ontology(id);


--
-- TOC entry 4054 (class 2606 OID 2109992)
-- Name: event_param fk7laguc0whfp46br0goxgkw6ry; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY event_param
    ADD CONSTRAINT fk7laguc0whfp46br0goxgkw6ry FOREIGN KEY (event_id) REFERENCES event(id);


--
-- TOC entry 4175 (class 2606 OID 2110602)
-- Name: pedigree_edge_additional_info fk7oyompkxdf9qfdw5vhi7jwob7; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY pedigree_edge_additional_info
    ADD CONSTRAINT fk7oyompkxdf9qfdw5vhi7jwob7 FOREIGN KEY (pedigree_edge_entity_id) REFERENCES pedigree_edge(id);


--
-- TOC entry 4043 (class 2606 OID 2109942)
-- Name: crossing_project_additional_info fk7vigpn4dgl764ntoukgsv9uvn; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY crossing_project_additional_info
    ADD CONSTRAINT fk7vigpn4dgl764ntoukgsv9uvn FOREIGN KEY (crossing_project_entity_id) REFERENCES crossing_project(id);


--
-- TOC entry 4195 (class 2606 OID 2110702)
-- Name: plate_external_references fk7waq4smg9jdsn9v87ovfn0irl; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY plate_external_references
    ADD CONSTRAINT fk7waq4smg9jdsn9v87ovfn0irl FOREIGN KEY (plate_entity_id) REFERENCES plate(id);


--
-- TOC entry 4210 (class 2606 OID 2110767)
-- Name: reference_additional_info fk7y0oio2jmojk6v8sbslsgodct; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY reference_additional_info
    ADD CONSTRAINT fk7y0oio2jmojk6v8sbslsgodct FOREIGN KEY (additional_info_id) REFERENCES additional_info(id);


--
-- TOC entry 4203 (class 2606 OID 2110732)
-- Name: program fk820kbw8w9s0ibrsfvw3apo6d2; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY program
    ADD CONSTRAINT fk820kbw8w9s0ibrsfvw3apo6d2 FOREIGN KEY (crop_id) REFERENCES crop(id);


--
-- TOC entry 4289 (class 2606 OID 2111162)
-- Name: trait_external_references fk83qwc6no22xekj3qoky28fjr; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY trait_external_references
    ADD CONSTRAINT fk83qwc6no22xekj3qoky28fjr FOREIGN KEY (external_references_id) REFERENCES external_reference(id);


--
-- TOC entry 4339 (class 2606 OID 2111422)
-- Name: vendor_spec_additional_info fk85b7ucavy6aw04xlh2sq091xp; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY vendor_spec_additional_info
    ADD CONSTRAINT fk85b7ucavy6aw04xlh2sq091xp FOREIGN KEY (vendor_spec_entity_id) REFERENCES vendor_spec(id);


--
-- TOC entry 4212 (class 2606 OID 2110787)
-- Name: reference_bases_additional_info fk86atf2yqcpk85idvuina9l1ro; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY reference_bases_additional_info
    ADD CONSTRAINT fk86atf2yqcpk85idvuina9l1ro FOREIGN KEY (reference_bases_page_entity_id) REFERENCES reference_bases(id);


--
-- TOC entry 4178 (class 2606 OID 2110607)
-- Name: pedigree_edge_external_references fk89dwa6f22etyvwsl2r3hc56cj; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY pedigree_edge_external_references
    ADD CONSTRAINT fk89dwa6f22etyvwsl2r3hc56cj FOREIGN KEY (external_references_id) REFERENCES external_reference(id);


--
-- TOC entry 4173 (class 2606 OID 2110592)
-- Name: pedigree_edge fk89pdbyb8xx3eua9b9i5cu5ltq; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY pedigree_edge
    ADD CONSTRAINT fk89pdbyb8xx3eua9b9i5cu5ltq FOREIGN KEY (this_node_id) REFERENCES pedigree_node(id);


--
-- TOC entry 4177 (class 2606 OID 2110612)
-- Name: pedigree_edge_external_references fk8b66j4ff2axcsuosr5erotn8e; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY pedigree_edge_external_references
    ADD CONSTRAINT fk8b66j4ff2axcsuosr5erotn8e FOREIGN KEY (pedigree_edge_entity_id) REFERENCES pedigree_edge(id);


--
-- TOC entry 4205 (class 2606 OID 2110742)
-- Name: program_additional_info fk8edlew8r5esn74g77aouynrv4; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY program_additional_info
    ADD CONSTRAINT fk8edlew8r5esn74g77aouynrv4 FOREIGN KEY (additional_info_id) REFERENCES additional_info(id);


--
-- TOC entry 4159 (class 2606 OID 2110512)
-- Name: observation_unit_level fk8iqhtkmddjbc4vhhf26ayx3b4; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY observation_unit_level
    ADD CONSTRAINT fk8iqhtkmddjbc4vhhf26ayx3b4 FOREIGN KEY (observation_unit_id) REFERENCES observation_unit(id);


--
-- TOC entry 4161 (class 2606 OID 2110522)
-- Name: observation_unit_position fk8nvp3yajleyeovdpi81pmrv82; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY observation_unit_position
    ADD CONSTRAINT fk8nvp3yajleyeovdpi81pmrv82 FOREIGN KEY (geo_coordinates_id) REFERENCES geojson(id);


--
-- TOC entry 4228 (class 2606 OID 2110862)
-- Name: sample fk8p8p683y5axjauvbt4bgp0lly; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY sample
    ADD CONSTRAINT fk8p8p683y5axjauvbt4bgp0lly FOREIGN KEY (trial_id) REFERENCES trial(id);


--
-- TOC entry 4186 (class 2606 OID 2110647)
-- Name: person_additional_info fk8qn2futvwxmyyp0mh1nfia1ax; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY person_additional_info
    ADD CONSTRAINT fk8qn2futvwxmyyp0mh1nfia1ax FOREIGN KEY (additional_info_id) REFERENCES additional_info(id);


--
-- TOC entry 4325 (class 2606 OID 2111352)
-- Name: variantset_additional_info fk8qu019buvb5xnd6fotaswf30q; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY variantset_additional_info
    ADD CONSTRAINT fk8qu019buvb5xnd6fotaswf30q FOREIGN KEY (variant_set_entity_id) REFERENCES variantset(id);


--
-- TOC entry 4000 (class 2606 OID 2049597)
-- Name: allele fk8qwjc3e6tnpyfbkmsi65vjlep; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY allele
    ADD CONSTRAINT fk8qwjc3e6tnpyfbkmsi65vjlep FOREIGN KEY (marker_profile_id) REFERENCES marker_profile(id);


--
-- TOC entry 4259 (class 2606 OID 2111012)
-- Name: seed_lot_transaction fk93w5dw8nj2fxxsow0ck0ila4w; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY seed_lot_transaction
    ADD CONSTRAINT fk93w5dw8nj2fxxsow0ck0ila4w FOREIGN KEY (from_seed_lot_id) REFERENCES seed_lot(id);


--
-- TOC entry 4081 (class 2606 OID 2110122)
-- Name: germplasm_donor_additional_info fk954n0e8pg58e8dy2gm52e9cpc; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY germplasm_donor_additional_info
    ADD CONSTRAINT fk954n0e8pg58e8dy2gm52e9cpc FOREIGN KEY (additional_info_id) REFERENCES additional_info(id);


--
-- TOC entry 4162 (class 2606 OID 2110532)
-- Name: observation_unit_treatment fk9aok9thr8d6dgqveur46e5985; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY observation_unit_treatment
    ADD CONSTRAINT fk9aok9thr8d6dgqveur46e5985 FOREIGN KEY (observation_unit_id) REFERENCES observation_unit(id);


--
-- TOC entry 4082 (class 2606 OID 2110137)
-- Name: germplasm_donor_external_references fk9au08uldnexgd3f00hvq2rg8k; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY germplasm_donor_external_references
    ADD CONSTRAINT fk9au08uldnexgd3f00hvq2rg8k FOREIGN KEY (donor_entity_id) REFERENCES germplasm_donor(id);


--
-- TOC entry 4320 (class 2606 OID 2111322)
-- Name: variant_entity_ciend fk9dsm85o8qltahmd03symbgohp; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY variant_entity_ciend
    ADD CONSTRAINT fk9dsm85o8qltahmd03symbgohp FOREIGN KEY (variant_entity_id) REFERENCES variant(id);


--
-- TOC entry 4182 (class 2606 OID 2110627)
-- Name: pedigree_node_additional_info fk9euom4xovmbho8f8munr3yo8u; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY pedigree_node_additional_info
    ADD CONSTRAINT fk9euom4xovmbho8f8munr3yo8u FOREIGN KEY (additional_info_id) REFERENCES additional_info(id);


--
-- TOC entry 4222 (class 2606 OID 2110827)
-- Name: reference_set_external_references fk9fslipqtjg4u9xj1wsx1tc1va; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY reference_set_external_references
    ADD CONSTRAINT fk9fslipqtjg4u9xj1wsx1tc1va FOREIGN KEY (external_references_id) REFERENCES external_reference(id);


--
-- TOC entry 4088 (class 2606 OID 2110157)
-- Name: germplasm_origin fk9i55glxpdu439oja1tx8mg8ia; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY germplasm_origin
    ADD CONSTRAINT fk9i55glxpdu439oja1tx8mg8ia FOREIGN KEY (coordinates_id) REFERENCES geojson(id);


--
-- TOC entry 4206 (class 2606 OID 2110757)
-- Name: program_external_references fk9k5htwyl0rrhadlr2bvtb4ewh; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY program_external_references
    ADD CONSTRAINT fk9k5htwyl0rrhadlr2bvtb4ewh FOREIGN KEY (program_entity_id) REFERENCES program(id);


--
-- TOC entry 4115 (class 2606 OID 2110302)
-- Name: location fk9s1sco601u8l6ptdxf432h4kb; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY location
    ADD CONSTRAINT fk9s1sco601u8l6ptdxf432h4kb FOREIGN KEY (parent_location_id) REFERENCES location(id);


--
-- TOC entry 4045 (class 2606 OID 2109952)
-- Name: crossing_project_external_references fk9t5w8cd5pxjih4ipygqcs6rwo; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY crossing_project_external_references
    ADD CONSTRAINT fk9t5w8cd5pxjih4ipygqcs6rwo FOREIGN KEY (crossing_project_entity_id) REFERENCES crossing_project(id);


--
-- TOC entry 4044 (class 2606 OID 2109937)
-- Name: crossing_project_additional_info fk9twarovit5p4n80u3p949rast; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY crossing_project_additional_info
    ADD CONSTRAINT fk9twarovit5p4n80u3p949rast FOREIGN KEY (additional_info_id) REFERENCES additional_info(id);


--
-- TOC entry 4264 (class 2606 OID 2111057)
-- Name: study fk9voefp8el048ula850imkkuiq; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY study
    ADD CONSTRAINT fk9voefp8el048ula850imkkuiq FOREIGN KEY (trial_id) REFERENCES trial(id);


--
-- TOC entry 4164 (class 2606 OID 2110542)
-- Name: observation_variable fk_30b5d7sqaviwsotg5oayomelh; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY observation_variable
    ADD CONSTRAINT fk_30b5d7sqaviwsotg5oayomelh FOREIGN KEY (method_id) REFERENCES method(id);


--
-- TOC entry 4165 (class 2606 OID 2110547)
-- Name: observation_variable fk_3ju23xr9v8171w7wesin5dqxw; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY observation_variable
    ADD CONSTRAINT fk_3ju23xr9v8171w7wesin5dqxw FOREIGN KEY (ontology_id) REFERENCES ontology(id);


--
-- TOC entry 4072 (class 2606 OID 2110082)
-- Name: germplasm_attribute_definition fk_80yoy5kaofonf13682hspj62t; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY germplasm_attribute_definition
    ADD CONSTRAINT fk_80yoy5kaofonf13682hspj62t FOREIGN KEY (trait_id) REFERENCES trait(id);


--
-- TOC entry 4070 (class 2606 OID 2110072)
-- Name: germplasm_attribute_definition fk_am7p3efyrwwysvpxl0ccj8mni; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY germplasm_attribute_definition
    ADD CONSTRAINT fk_am7p3efyrwwysvpxl0ccj8mni FOREIGN KEY (ontology_id) REFERENCES ontology(id);


--
-- TOC entry 4167 (class 2606 OID 2110557)
-- Name: observation_variable fk_f0m8ifjjlmoym2p2abs0efk6j; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY observation_variable
    ADD CONSTRAINT fk_f0m8ifjjlmoym2p2abs0efk6j FOREIGN KEY (trait_id) REFERENCES trait(id);


--
-- TOC entry 4166 (class 2606 OID 2110552)
-- Name: observation_variable fk_f98l70i69jgso1yousworitle; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY observation_variable
    ADD CONSTRAINT fk_f98l70i69jgso1yousworitle FOREIGN KEY (scale_id) REFERENCES scale(id);


--
-- TOC entry 4163 (class 2606 OID 2110537)
-- Name: observation_variable fk_mns5ll4ybilsyxg20ksq514pk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY observation_variable
    ADD CONSTRAINT fk_mns5ll4ybilsyxg20ksq514pk FOREIGN KEY (crop_id) REFERENCES crop(id);


--
-- TOC entry 4069 (class 2606 OID 2110067)
-- Name: germplasm_attribute_definition fk_nynfiem725rgq65kg99031j78; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY germplasm_attribute_definition
    ADD CONSTRAINT fk_nynfiem725rgq65kg99031j78 FOREIGN KEY (method_id) REFERENCES method(id);


--
-- TOC entry 4068 (class 2606 OID 2110062)
-- Name: germplasm_attribute_definition fk_rs20ylp9ibjagoavfko13uq9n; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY germplasm_attribute_definition
    ADD CONSTRAINT fk_rs20ylp9ibjagoavfko13uq9n FOREIGN KEY (crop_id) REFERENCES crop(id);


--
-- TOC entry 4071 (class 2606 OID 2110077)
-- Name: germplasm_attribute_definition fk_smngmu0eaqhppp1d4nqb9cy8o; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY germplasm_attribute_definition
    ADD CONSTRAINT fk_smngmu0eaqhppp1d4nqb9cy8o FOREIGN KEY (scale_id) REFERENCES scale(id);


--
-- TOC entry 4309 (class 2606 OID 2111267)
-- Name: variable_base_entity fka5x8r7mfq04ttwj9ssls0uft4; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY variable_base_entity
    ADD CONSTRAINT fka5x8r7mfq04ttwj9ssls0uft4 FOREIGN KEY (trait_id) REFERENCES trait(id);


--
-- TOC entry 4298 (class 2606 OID 2111207)
-- Name: trial_additional_info fkacx2nuhy8i9gso9c5qv6norea; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY trial_additional_info
    ADD CONSTRAINT fkacx2nuhy8i9gso9c5qv6norea FOREIGN KEY (additional_info_id) REFERENCES additional_info(id);


--
-- TOC entry 4171 (class 2606 OID 2110572)
-- Name: ontology_external_references fkajcue8iujp37clk05ly7huxus; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY ontology_external_references
    ADD CONSTRAINT fkajcue8iujp37clk05ly7huxus FOREIGN KEY (external_references_id) REFERENCES external_reference(id);


--
-- TOC entry 4032 (class 2606 OID 2109887)
-- Name: cross_entity_additional_info fkajtg8v6usq228dwowobih89ev; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY cross_entity_additional_info
    ADD CONSTRAINT fkajtg8v6usq228dwowobih89ev FOREIGN KEY (cross_entity_id) REFERENCES cross_entity(id);


--
-- TOC entry 4244 (class 2606 OID 2110937)
-- Name: search_external_references fkasoj2adq9bhxyymm4cpukjhnw; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY search_external_references
    ADD CONSTRAINT fkasoj2adq9bhxyymm4cpukjhnw FOREIGN KEY (external_references_id) REFERENCES external_reference(id);


--
-- TOC entry 4014 (class 2606 OID 2109797)
-- Name: breeding_method_additional_info fkb0nay4eudi0w8g5g31v4extav; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY breeding_method_additional_info
    ADD CONSTRAINT fkb0nay4eudi0w8g5g31v4extav FOREIGN KEY (breeding_method_entity_id) REFERENCES breeding_method(id);


--
-- TOC entry 4336 (class 2606 OID 2111397)
-- Name: vendor_order_additional_info fkb0qucuwj937qoftj3hhucilkl; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY vendor_order_additional_info
    ADD CONSTRAINT fkb0qucuwj937qoftj3hhucilkl FOREIGN KEY (additional_info_id) REFERENCES additional_info(id);


--
-- TOC entry 4047 (class 2606 OID 2109957)
-- Name: event fkb21n9vqs7iyptt7vx6v6s2e07; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY event
    ADD CONSTRAINT fkb21n9vqs7iyptt7vx6v6s2e07 FOREIGN KEY (study_id) REFERENCES study(id);


--
-- TOC entry 4144 (class 2606 OID 2110437)
-- Name: observation_additional_info fkb5f2e9tgwcnsl6khhk9dq8g9g; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY observation_additional_info
    ADD CONSTRAINT fkb5f2e9tgwcnsl6khhk9dq8g9g FOREIGN KEY (additional_info_id) REFERENCES additional_info(id);


--
-- TOC entry 4033 (class 2606 OID 2109882)
-- Name: cross_entity_additional_info fkbeoyvggungwxcs0dnbe8fl8tc; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY cross_entity_additional_info
    ADD CONSTRAINT fkbeoyvggungwxcs0dnbe8fl8tc FOREIGN KEY (additional_info_id) REFERENCES additional_info(id);


--
-- TOC entry 4028 (class 2606 OID 2109867)
-- Name: crop_external_references fkbin2gayn9sl8khd07gf1tv0j; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY crop_external_references
    ADD CONSTRAINT fkbin2gayn9sl8khd07gf1tv0j FOREIGN KEY (crop_entity_id) REFERENCES crop(id);


--
-- TOC entry 4221 (class 2606 OID 2110832)
-- Name: reference_set_external_references fkbk2b1k68f0drytr6pkncudxoh; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY reference_set_external_references
    ADD CONSTRAINT fkbk2b1k68f0drytr6pkncudxoh FOREIGN KEY (reference_set_entity_id) REFERENCES reference_set(id);


--
-- TOC entry 4220 (class 2606 OID 2110817)
-- Name: reference_set_additional_info fkbkxd7m8yi6lkapc6xwi8k68e4; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY reference_set_additional_info
    ADD CONSTRAINT fkbkxd7m8yi6lkapc6xwi8k68e4 FOREIGN KEY (additional_info_id) REFERENCES additional_info(id);


--
-- TOC entry 4016 (class 2606 OID 2109807)
-- Name: breeding_method_external_references fkboc2lii67kdtey1frkcsatps6; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY breeding_method_external_references
    ADD CONSTRAINT fkboc2lii67kdtey1frkcsatps6 FOREIGN KEY (breeding_method_entity_id) REFERENCES breeding_method(id);


--
-- TOC entry 4300 (class 2606 OID 2111217)
-- Name: trial_contact fkbpd4t24op9qhsh3vnljww0eo8; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY trial_contact
    ADD CONSTRAINT fkbpd4t24op9qhsh3vnljww0eo8 FOREIGN KEY (person_db_id) REFERENCES person(id);


--
-- TOC entry 4232 (class 2606 OID 2110877)
-- Name: sample_external_references fkbqjbcfol1ok5eci7kq2tyjx17; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY sample_external_references
    ADD CONSTRAINT fkbqjbcfol1ok5eci7kq2tyjx17 FOREIGN KEY (external_references_id) REFERENCES external_reference(id);


--
-- TOC entry 4041 (class 2606 OID 2109927)
-- Name: cross_entity_cross_attributes fkbunrh906gnkig3w246cxx037c; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY cross_entity_cross_attributes
    ADD CONSTRAINT fkbunrh906gnkig3w246cxx037c FOREIGN KEY (cross_entity_id) REFERENCES cross_entity(id);


--
-- TOC entry 4100 (class 2606 OID 2110227)
-- Name: image_observations fkbwiawjcj7mihofl5puuq7k2ws; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY image_observations
    ADD CONSTRAINT fkbwiawjcj7mihofl5puuq7k2ws FOREIGN KEY (image_entity_id) REFERENCES image(id);


--
-- TOC entry 4007 (class 2606 OID 2049882)
-- Name: study_marker_profile fkbynfwygpt639u6pof9whjkxfv; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY study_marker_profile
    ADD CONSTRAINT fkbynfwygpt639u6pof9whjkxfv FOREIGN KEY (marker_profile_db_id) REFERENCES marker_profile(id);


--
-- TOC entry 4254 (class 2606 OID 2110992)
-- Name: seed_lot_content_mixture fkc1gnrmj6ceuu1o4s6ffs4yjt3; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY seed_lot_content_mixture
    ADD CONSTRAINT fkc1gnrmj6ceuu1o4s6ffs4yjt3 FOREIGN KEY (germplasm_id) REFERENCES germplasm(id);


--
-- TOC entry 4342 (class 2606 OID 2111427)
-- Name: vendor_spec_external_references fkc3usn08w7ld6ii26stfy3acwn; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY vendor_spec_external_references
    ADD CONSTRAINT fkc3usn08w7ld6ii26stfy3acwn FOREIGN KEY (external_references_id) REFERENCES external_reference(id);


--
-- TOC entry 4056 (class 2606 OID 2110002)
-- Name: event_parameter_entity_values_by_date fkc45rvhmlblcxqdr96qm58cg45; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY event_parameter_entity_values_by_date
    ADD CONSTRAINT fkc45rvhmlblcxqdr96qm58cg45 FOREIGN KEY (event_parameter_entity_id) REFERENCES event_param(id);


--
-- TOC entry 4250 (class 2606 OID 2110967)
-- Name: seed_lot fkc5lijily7i4rlqqgg6f0c11um; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY seed_lot
    ADD CONSTRAINT fkc5lijily7i4rlqqgg6f0c11um FOREIGN KEY (location_id) REFERENCES location(id);


--
-- TOC entry 4242 (class 2606 OID 2110927)
-- Name: search_additional_info fkc607lmbugih02njrqn5won5de; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY search_additional_info
    ADD CONSTRAINT fkc607lmbugih02njrqn5won5de FOREIGN KEY (additional_info_id) REFERENCES additional_info(id);


--
-- TOC entry 4256 (class 2606 OID 2111007)
-- Name: seed_lot_external_references fkcbgmrnalhithf1ba1usguxia3; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY seed_lot_external_references
    ADD CONSTRAINT fkcbgmrnalhithf1ba1usguxia3 FOREIGN KEY (seed_lot_entity_id) REFERENCES seed_lot(id);


--
-- TOC entry 4102 (class 2606 OID 2110232)
-- Name: image_entity_descriptive_ontology_terms fkce2lade5kp0pnd7dkps05s494; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY image_entity_descriptive_ontology_terms
    ADD CONSTRAINT fkce2lade5kp0pnd7dkps05s494 FOREIGN KEY (image_entity_id) REFERENCES image(id);


--
-- TOC entry 4265 (class 2606 OID 2111052)
-- Name: study fkcgg6j1kp9h2noravxy8v0yfc0; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY study
    ADD CONSTRAINT fkcgg6j1kp9h2noravxy8v0yfc0 FOREIGN KEY (program_id) REFERENCES program(id);


--
-- TOC entry 4328 (class 2606 OID 2111367)
-- Name: variantset_external_references fkckhrweboc7ktl0e7obei7731f; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY variantset_external_references
    ADD CONSTRAINT fkckhrweboc7ktl0e7obei7731f FOREIGN KEY (variant_set_entity_id) REFERENCES variantset(id);


--
-- TOC entry 4263 (class 2606 OID 2111032)
-- Name: seed_lot_transaction_external_references fkcmeans75yxjouc0a6t2ahsl6g; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY seed_lot_transaction_external_references
    ADD CONSTRAINT fkcmeans75yxjouc0a6t2ahsl6g FOREIGN KEY (external_references_id) REFERENCES external_reference(id);


--
-- TOC entry 4022 (class 2606 OID 2109827)
-- Name: callset_external_references fkcmhdlkwcanmd21p8gepoi0n0u; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY callset_external_references
    ADD CONSTRAINT fkcmhdlkwcanmd21p8gepoi0n0u FOREIGN KEY (external_references_id) REFERENCES external_reference(id);


--
-- TOC entry 4142 (class 2606 OID 2110432)
-- Name: observation fkcviusg5q0avmk5xv7nix9gxh0; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY observation
    ADD CONSTRAINT fkcviusg5q0avmk5xv7nix9gxh0 FOREIGN KEY (trial_id) REFERENCES trial(id);


--
-- TOC entry 4084 (class 2606 OID 2110147)
-- Name: germplasm_external_references fkd0ih09ntorrw8erucyh5m6sp2; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY germplasm_external_references
    ADD CONSTRAINT fkd0ih09ntorrw8erucyh5m6sp2 FOREIGN KEY (germplasm_entity_id) REFERENCES germplasm(id);


--
-- TOC entry 4301 (class 2606 OID 2111227)
-- Name: trial_dataset_authorship fkd13q53ipjrr22rkelycgxjio4; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY trial_dataset_authorship
    ADD CONSTRAINT fkd13q53ipjrr22rkelycgxjio4 FOREIGN KEY (trial_id) REFERENCES trial(id);


--
-- TOC entry 4148 (class 2606 OID 2110462)
-- Name: observation_unit fkdbndn6ma22quuinicrkjqofim; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY observation_unit
    ADD CONSTRAINT fkdbndn6ma22quuinicrkjqofim FOREIGN KEY (cross_id) REFERENCES cross_entity(id);


--
-- TOC entry 4025 (class 2606 OID 2109847)
-- Name: coordinate fkdexqh6fwkb6wlewagkp7v1k98; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY coordinate
    ADD CONSTRAINT fkdexqh6fwkb6wlewagkp7v1k98 FOREIGN KEY (geojson_id) REFERENCES geojson(id);


--
-- TOC entry 4282 (class 2606 OID 2111137)
-- Name: study_variable fkdg1qfle74hjs7s6a31j6poxs; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY study_variable
    ADD CONSTRAINT fkdg1qfle74hjs7s6a31j6poxs FOREIGN KEY (study_db_id) REFERENCES study(id);


--
-- TOC entry 4231 (class 2606 OID 2110882)
-- Name: sample_external_references fkdjnhuxmo83frqm5o5bbkbnyxq; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY sample_external_references
    ADD CONSTRAINT fkdjnhuxmo83frqm5o5bbkbnyxq FOREIGN KEY (sample_entity_id) REFERENCES sample(id);


--
-- TOC entry 4318 (class 2606 OID 2111307)
-- Name: variant_external_references fkdnw738um7f4ikcxp1iq4jsbw6; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY variant_external_references
    ADD CONSTRAINT fkdnw738um7f4ikcxp1iq4jsbw6 FOREIGN KEY (external_references_id) REFERENCES external_reference(id);


--
-- TOC entry 4198 (class 2606 OID 2110717)
-- Name: plate_submission_additional_info fkdpithbfhkpwgeh1w4owmbbvao; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY plate_submission_additional_info
    ADD CONSTRAINT fkdpithbfhkpwgeh1w4owmbbvao FOREIGN KEY (vendor_plate_submission_entity_id) REFERENCES plate_submission(id);


--
-- TOC entry 4176 (class 2606 OID 2110597)
-- Name: pedigree_edge_additional_info fke0dmer2vi4gws6tobq2g48fqt; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY pedigree_edge_additional_info
    ADD CONSTRAINT fke0dmer2vi4gws6tobq2g48fqt FOREIGN KEY (additional_info_id) REFERENCES additional_info(id);


--
-- TOC entry 4334 (class 2606 OID 2111387)
-- Name: vendor_file_sample fke3tnyn895kve2kgixku4j7htb; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY vendor_file_sample
    ADD CONSTRAINT fke3tnyn895kve2kgixku4j7htb FOREIGN KEY (sample_dbid) REFERENCES sample(id);


--
-- TOC entry 4050 (class 2606 OID 2109977)
-- Name: event_external_references fke6ojv2849d07tagl2eslcujg9; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY event_external_references
    ADD CONSTRAINT fke6ojv2849d07tagl2eslcujg9 FOREIGN KEY (event_entity_id) REFERENCES event(id);


--
-- TOC entry 4155 (class 2606 OID 2110492)
-- Name: observation_unit_additional_info fke96np5kap7n8ewbtvduvi3xi5; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY observation_unit_additional_info
    ADD CONSTRAINT fke96np5kap7n8ewbtvduvi3xi5 FOREIGN KEY (additional_info_id) REFERENCES additional_info(id);


--
-- TOC entry 4058 (class 2606 OID 2110017)
-- Name: genome_map_additional_info fkeavq3jiy14vghritt37ydxasa; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY genome_map_additional_info
    ADD CONSTRAINT fkeavq3jiy14vghritt37ydxasa FOREIGN KEY (genome_map_entity_id) REFERENCES genome_map(id);


--
-- TOC entry 4156 (class 2606 OID 2110507)
-- Name: observation_unit_external_references fkel9v1egnbmp20dpbkt1831ljq; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY observation_unit_external_references
    ADD CONSTRAINT fkel9v1egnbmp20dpbkt1831ljq FOREIGN KEY (observation_unit_entity_id) REFERENCES observation_unit(id);


--
-- TOC entry 4042 (class 2606 OID 2109932)
-- Name: crossing_project fkellju38wp5gf7191sv55r9kxe; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY crossing_project
    ADD CONSTRAINT fkellju38wp5gf7191sv55r9kxe FOREIGN KEY (program_id) REFERENCES program(id);


--
-- TOC entry 4062 (class 2606 OID 2110037)
-- Name: genome_map_studies fkemp13kog5jy1924s59shmweug; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY genome_map_studies
    ADD CONSTRAINT fkemp13kog5jy1924s59shmweug FOREIGN KEY (genome_map_entity_id) REFERENCES genome_map(id);


--
-- TOC entry 4010 (class 2606 OID 2109777)
-- Name: allele_call_additional_info fken1loe2e0brxlqvkdv444egfm; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY allele_call_additional_info
    ADD CONSTRAINT fken1loe2e0brxlqvkdv444egfm FOREIGN KEY (call_entity_id) REFERENCES allele_call(id);


--
-- TOC entry 4335 (class 2606 OID 2111402)
-- Name: vendor_order_additional_info fkeoruo4p69iln0k4f6ovod6my3; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY vendor_order_additional_info
    ADD CONSTRAINT fkeoruo4p69iln0k4f6ovod6my3 FOREIGN KEY (vendor_order_entity_id) REFERENCES vendor_order(id);


--
-- TOC entry 4299 (class 2606 OID 2111222)
-- Name: trial_contact fkeqh9256ey5a136uatx4hu6gc4; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY trial_contact
    ADD CONSTRAINT fkeqh9256ey5a136uatx4hu6gc4 FOREIGN KEY (trial_db_id) REFERENCES trial(id);


--
-- TOC entry 4139 (class 2606 OID 2110417)
-- Name: observation fkf2si37d28257vfoa753hu5x1v; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY observation
    ADD CONSTRAINT fkf2si37d28257vfoa753hu5x1v FOREIGN KEY (program_id) REFERENCES program(id);


--
-- TOC entry 4157 (class 2606 OID 2110502)
-- Name: observation_unit_external_references fkf3v8fqkjowvjos0ssmm2w8l30; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY observation_unit_external_references
    ADD CONSTRAINT fkf3v8fqkjowvjos0ssmm2w8l30 FOREIGN KEY (external_references_id) REFERENCES external_reference(id);


--
-- TOC entry 4214 (class 2606 OID 2110797)
-- Name: reference_bases_external_references fkf6sny2j9k3hugyrp6iut22oo; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY reference_bases_external_references
    ADD CONSTRAINT fkf6sny2j9k3hugyrp6iut22oo FOREIGN KEY (reference_bases_page_entity_id) REFERENCES reference_bases(id);


--
-- TOC entry 4046 (class 2606 OID 2109947)
-- Name: crossing_project_external_references fkfckwn44o1i8htq592o0s8hgac; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY crossing_project_external_references
    ADD CONSTRAINT fkfckwn44o1i8htq592o0s8hgac FOREIGN KEY (external_references_id) REFERENCES external_reference(id);


--
-- TOC entry 4286 (class 2606 OID 2111157)
-- Name: trait_additional_info fkfdo433yeiqekt02djxvwqjqna; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY trait_additional_info
    ADD CONSTRAINT fkfdo433yeiqekt02djxvwqjqna FOREIGN KEY (trait_entity_id) REFERENCES trait(id);


--
-- TOC entry 4183 (class 2606 OID 2110642)
-- Name: pedigree_node_external_references fkfg0jmv1958u8qmsd796xft78w; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY pedigree_node_external_references
    ADD CONSTRAINT fkfg0jmv1958u8qmsd796xft78w FOREIGN KEY (pedigree_node_entity_id) REFERENCES pedigree_node(id);


--
-- TOC entry 4202 (class 2606 OID 2110737)
-- Name: program fkfi6d6cc591slcqibawxp0m1pd; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY program
    ADD CONSTRAINT fkfi6d6cc591slcqibawxp0m1pd FOREIGN KEY (lead_person_id) REFERENCES person(id);


--
-- TOC entry 4248 (class 2606 OID 2110957)
-- Name: season_external_references fkfpgrbaopdh4pg1x0v785g8kl9; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY season_external_references
    ADD CONSTRAINT fkfpgrbaopdh4pg1x0v785g8kl9 FOREIGN KEY (external_references_id) REFERENCES external_reference(id);


--
-- TOC entry 4137 (class 2606 OID 2110407)
-- Name: observation fkfqw685lfh2uxxbgi60vne24jr; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY observation
    ADD CONSTRAINT fkfqw685lfh2uxxbgi60vne24jr FOREIGN KEY (observation_unit_id) REFERENCES observation_unit(id);


--
-- TOC entry 4233 (class 2606 OID 2110887)
-- Name: scale fkfuvpau9fbqw8ukt0hpr1coxxb; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY scale
    ADD CONSTRAINT fkfuvpau9fbqw8ukt0hpr1coxxb FOREIGN KEY (ontology_id) REFERENCES ontology(id);


--
-- TOC entry 4187 (class 2606 OID 2110662)
-- Name: person_external_references fkfxl2xseolst0sb8pci7o7yxy; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY person_external_references
    ADD CONSTRAINT fkfxl2xseolst0sb8pci7o7yxy FOREIGN KEY (person_entity_id) REFERENCES person(id);


--
-- TOC entry 4284 (class 2606 OID 2111142)
-- Name: trait fkfy6vs593as3gs6tadmey5s2ad; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY trait
    ADD CONSTRAINT fkfy6vs593as3gs6tadmey5s2ad FOREIGN KEY (ontology_id) REFERENCES ontology(id);


--
-- TOC entry 4296 (class 2606 OID 2111197)
-- Name: trial fkg0ovktlcm3w66xxj0m880rur9; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY trial
    ADD CONSTRAINT fkg0ovktlcm3w66xxj0m880rur9 FOREIGN KEY (crop_id) REFERENCES crop(id);


--
-- TOC entry 4075 (class 2606 OID 2110102)
-- Name: germplasm_attribute_value_additional_info fkg5fc788jirqx5dq7oyuvh1xlk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY germplasm_attribute_value_additional_info
    ADD CONSTRAINT fkg5fc788jirqx5dq7oyuvh1xlk FOREIGN KEY (germplasm_attribute_value_entity_id) REFERENCES germplasm_attribute_value(id);


--
-- TOC entry 4268 (class 2606 OID 2111067)
-- Name: study_additional_info fkg741lptjnoyu2sg5dngulq9gn; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY study_additional_info
    ADD CONSTRAINT fkg741lptjnoyu2sg5dngulq9gn FOREIGN KEY (study_entity_id) REFERENCES study(id);


--
-- TOC entry 4003 (class 2606 OID 2049712)
-- Name: marker_marker_analysis_method fkgarxih3kj3ujt0tpai9vvdb0o; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY marker_marker_analysis_method
    ADD CONSTRAINT fkgarxih3kj3ujt0tpai9vvdb0o FOREIGN KEY (marker_db_id) REFERENCES marker(id);


--
-- TOC entry 4193 (class 2606 OID 2110692)
-- Name: plate_additional_info fkgb681lp8w3b31kwwi25wrdjpw; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY plate_additional_info
    ADD CONSTRAINT fkgb681lp8w3b31kwwi25wrdjpw FOREIGN KEY (plate_entity_id) REFERENCES plate(id);


--
-- TOC entry 4246 (class 2606 OID 2110947)
-- Name: season_additional_info fkgfda9n0n1nru5jfdau93d7rvi; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY season_additional_info
    ADD CONSTRAINT fkgfda9n0n1nru5jfdau93d7rvi FOREIGN KEY (additional_info_id) REFERENCES additional_info(id);


--
-- TOC entry 4317 (class 2606 OID 2111312)
-- Name: variant_external_references fkgoibfri9bvwfh4jd8snqwcw5u; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY variant_external_references
    ADD CONSTRAINT fkgoibfri9bvwfh4jd8snqwcw5u FOREIGN KEY (variant_entity_id) REFERENCES variant(id);


--
-- TOC entry 4027 (class 2606 OID 2109852)
-- Name: crop_additional_info fkgsa806ghdfmb2jibt6yj0at93; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY crop_additional_info
    ADD CONSTRAINT fkgsa806ghdfmb2jibt6yj0at93 FOREIGN KEY (additional_info_id) REFERENCES additional_info(id);


--
-- TOC entry 4190 (class 2606 OID 2110677)
-- Name: plate fkgt7xe0jip2aekvx0nei3t3s67; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY plate
    ADD CONSTRAINT fkgt7xe0jip2aekvx0nei3t3s67 FOREIGN KEY (submission_id) REFERENCES plate_submission(id);


--
-- TOC entry 4037 (class 2606 OID 2109912)
-- Name: cross_parent fkgwne8ni7iqgxeu5qvnjskbkvj; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY cross_parent
    ADD CONSTRAINT fkgwne8ni7iqgxeu5qvnjskbkvj FOREIGN KEY (germplasm_id) REFERENCES germplasm(id);


--
-- TOC entry 4224 (class 2606 OID 2110842)
-- Name: sample fkgxtnyp78l7na5g0li648fy82u; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY sample
    ADD CONSTRAINT fkgxtnyp78l7na5g0li648fy82u FOREIGN KEY (plate_id) REFERENCES plate(id);


--
-- TOC entry 4149 (class 2606 OID 2110467)
-- Name: observation_unit fkgykwn3x9wx8m77wy67juqlxab; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY observation_unit
    ADD CONSTRAINT fkgykwn3x9wx8m77wy67juqlxab FOREIGN KEY (germplasm_id) REFERENCES germplasm(id);


--
-- TOC entry 4314 (class 2606 OID 2111287)
-- Name: variant fkh523hkn6t8iurf19bb19o7px7; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY variant
    ADD CONSTRAINT fkh523hkn6t8iurf19bb19o7px7 FOREIGN KEY (reference_set_id) REFERENCES reference_set(id);


--
-- TOC entry 4158 (class 2606 OID 2110517)
-- Name: observation_unit_level fkh70bs6tax01tl04ha9qjqo19; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY observation_unit_level
    ADD CONSTRAINT fkh70bs6tax01tl04ha9qjqo19 FOREIGN KEY (position_id) REFERENCES observation_unit_position(id);


--
-- TOC entry 4321 (class 2606 OID 2111327)
-- Name: variant_entity_cipos fkh94uec6mbay6eld1uxk1m2xbi; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY variant_entity_cipos
    ADD CONSTRAINT fkh94uec6mbay6eld1uxk1m2xbi FOREIGN KEY (variant_entity_id) REFERENCES variant(id);


--
-- TOC entry 4293 (class 2606 OID 2111187)
-- Name: trait_entity_alternative_abbreviations fkhattlnir8onuakl31y2yjxs4n; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY trait_entity_alternative_abbreviations
    ADD CONSTRAINT fkhattlnir8onuakl31y2yjxs4n FOREIGN KEY (trait_entity_id) REFERENCES trait(id);


--
-- TOC entry 4333 (class 2606 OID 2111392)
-- Name: vendor_file_sample fkhb1jmpjfglf5idqj5rrkqvkg1; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY vendor_file_sample
    ADD CONSTRAINT fkhb1jmpjfglf5idqj5rrkqvkg1 FOREIGN KEY (verndor_file_dbid) REFERENCES vendor_file(id);


--
-- TOC entry 4345 (class 2606 OID 2111447)
-- Name: vendor_order_entity_service_ids fkhh2skywan2uev483rj1gye45b; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY vendor_order_entity_service_ids
    ADD CONSTRAINT fkhh2skywan2uev483rj1gye45b FOREIGN KEY (vendor_order_entity_id) REFERENCES vendor_order(id);


--
-- TOC entry 4277 (class 2606 OID 2111107)
-- Name: study_growth_facility fkhie58olkxqm2t1ht6k5hl4wu5; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY study_growth_facility
    ADD CONSTRAINT fkhie58olkxqm2t1ht6k5hl4wu5 FOREIGN KEY (study_id) REFERENCES study(id);


--
-- TOC entry 4273 (class 2606 OID 2111087)
-- Name: study_environment_parameter fkhkcbdh997uw56v7orukh2hssm; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY study_environment_parameter
    ADD CONSTRAINT fkhkcbdh997uw56v7orukh2hssm FOREIGN KEY (study_id) REFERENCES study(id);


--
-- TOC entry 4341 (class 2606 OID 2111432)
-- Name: vendor_spec_external_references fkhnqmgqyaofwey1vm3ly1kr46k; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY vendor_spec_external_references
    ADD CONSTRAINT fkhnqmgqyaofwey1vm3ly1kr46k FOREIGN KEY (vendor_spec_entity_id) REFERENCES vendor_spec(id);


--
-- TOC entry 4018 (class 2606 OID 2109812)
-- Name: callset fkhreq22htrftm3dul7nfsg1agk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY callset
    ADD CONSTRAINT fkhreq22htrftm3dul7nfsg1agk FOREIGN KEY (sample_id) REFERENCES sample(id);


--
-- TOC entry 4063 (class 2606 OID 2110032)
-- Name: genome_map_studies fkhs0xcw9lqe8ef55rotrlcr8o9; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY genome_map_studies
    ADD CONSTRAINT fkhs0xcw9lqe8ef55rotrlcr8o9 FOREIGN KEY (studies_id) REFERENCES study(id);


--
-- TOC entry 4249 (class 2606 OID 2110972)
-- Name: seed_lot fkhwgjxt97ds2usyh8wmk4ec4qu; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY seed_lot
    ADD CONSTRAINT fkhwgjxt97ds2usyh8wmk4ec4qu FOREIGN KEY (program_id) REFERENCES program(id);


--
-- TOC entry 4241 (class 2606 OID 2110932)
-- Name: search_additional_info fkhwvys4ofud3pffy75khmerbxy; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY search_additional_info
    ADD CONSTRAINT fkhwvys4ofud3pffy75khmerbxy FOREIGN KEY (search_request_entity_id) REFERENCES search(id);


--
-- TOC entry 4313 (class 2606 OID 2111292)
-- Name: variant fkhxdkan6bx84xlww89gy9wr9q8; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY variant
    ADD CONSTRAINT fkhxdkan6bx84xlww89gy9wr9q8 FOREIGN KEY (variant_set_id) REFERENCES variantset(id);


--
-- TOC entry 4322 (class 2606 OID 2111332)
-- Name: variant_entity_filters_failed fki10kljn84l12s881v3bxdh34n; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY variant_entity_filters_failed
    ADD CONSTRAINT fki10kljn84l12s881v3bxdh34n FOREIGN KEY (variant_entity_id) REFERENCES variant(id);


--
-- TOC entry 4123 (class 2606 OID 2110332)
-- Name: marker_position fki54u4vxhiuwfqt3kxev1wdkvc; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY marker_position
    ADD CONSTRAINT fki54u4vxhiuwfqt3kxev1wdkvc FOREIGN KEY (linkage_group_id) REFERENCES linkage_group(id);


--
-- TOC entry 4281 (class 2606 OID 2111122)
-- Name: study_season fki5yn2nqtqrw3mh1qoeyxxmyvp; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY study_season
    ADD CONSTRAINT fki5yn2nqtqrw3mh1qoeyxxmyvp FOREIGN KEY (season_db_id) REFERENCES season(id);


--
-- TOC entry 4291 (class 2606 OID 2111172)
-- Name: trait_ontology_reference fki80mf7yhx7xoh3nt4tb0ptxg0; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY trait_ontology_reference
    ADD CONSTRAINT fki80mf7yhx7xoh3nt4tb0ptxg0 FOREIGN KEY (ontology_reference_id) REFERENCES ontology_ref(id);


--
-- TOC entry 4077 (class 2606 OID 2110112)
-- Name: germplasm_attribute_value_external_references fki9jmov5fpss3lmix8fvknrp84; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY germplasm_attribute_value_external_references
    ADD CONSTRAINT fki9jmov5fpss3lmix8fvknrp84 FOREIGN KEY (germplasm_attribute_value_entity_id) REFERENCES germplasm_attribute_value(id);


--
-- TOC entry 4085 (class 2606 OID 2110142)
-- Name: germplasm_external_references fkibd3k0wfmkkjf2budoeothsub; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY germplasm_external_references
    ADD CONSTRAINT fkibd3k0wfmkkjf2budoeothsub FOREIGN KEY (external_references_id) REFERENCES external_reference(id);


--
-- TOC entry 4064 (class 2606 OID 2110047)
-- Name: germplasm fkifyh81snysy9bac2tus48jfs5; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY germplasm
    ADD CONSTRAINT fkifyh81snysy9bac2tus48jfs5 FOREIGN KEY (crop_id) REFERENCES crop(id);


--
-- TOC entry 4051 (class 2606 OID 2109972)
-- Name: event_external_references fkig2468c6y0c60t4e0coso0ap2; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY event_external_references
    ADD CONSTRAINT fkig2468c6y0c60t4e0coso0ap2 FOREIGN KEY (external_references_id) REFERENCES external_reference(id);


--
-- TOC entry 4135 (class 2606 OID 2110397)
-- Name: observation fkigyb0oa6sjfhgmtlspflau9hb; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY observation
    ADD CONSTRAINT fkigyb0oa6sjfhgmtlspflau9hb FOREIGN KEY (crop_id) REFERENCES crop(id);


--
-- TOC entry 4191 (class 2606 OID 2110672)
-- Name: plate fkihx8xx6p59h4rkgsd2qa5vyia; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY plate
    ADD CONSTRAINT fkihx8xx6p59h4rkgsd2qa5vyia FOREIGN KEY (study_id) REFERENCES study(id);


--
-- TOC entry 4108 (class 2606 OID 2110262)
-- Name: list fkimr1m8xoms2ntm15lmaruf04u; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY list
    ADD CONSTRAINT fkimr1m8xoms2ntm15lmaruf04u FOREIGN KEY (list_owner_person_id) REFERENCES person(id);


--
-- TOC entry 4004 (class 2606 OID 2049707)
-- Name: marker_marker_analysis_method fkiqerxveljj6ol9xpam32lpwlh; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY marker_marker_analysis_method
    ADD CONSTRAINT fkiqerxveljj6ol9xpam32lpwlh FOREIGN KEY (marker_analysis_method_db_id) REFERENCES marker_analysis_method(id);


--
-- TOC entry 4124 (class 2606 OID 2110347)
-- Name: marker_position_additional_info fkitpgrueaxbd8s0qgf8ejxsmbc; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY marker_position_additional_info
    ADD CONSTRAINT fkitpgrueaxbd8s0qgf8ejxsmbc FOREIGN KEY (marker_position_entity_id) REFERENCES marker_position(id);


--
-- TOC entry 4240 (class 2606 OID 2110922)
-- Name: scale_valid_value_category fkjhq7himmbn2jaku9qvpfq3vkd; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY scale_valid_value_category
    ADD CONSTRAINT fkjhq7himmbn2jaku9qvpfq3vkd FOREIGN KEY (scale_id) REFERENCES scale(id);


--
-- TOC entry 4262 (class 2606 OID 2111037)
-- Name: seed_lot_transaction_external_references fkjsg1potilwjdyt0uk3jmx5nv0; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY seed_lot_transaction_external_references
    ADD CONSTRAINT fkjsg1potilwjdyt0uk3jmx5nv0 FOREIGN KEY (seed_lot_transaction_entity_id) REFERENCES seed_lot_transaction(id);


--
-- TOC entry 4035 (class 2606 OID 2109892)
-- Name: cross_entity_external_references fkjumsck59h4jv2ph2fhwfmbi2d; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY cross_entity_external_references
    ADD CONSTRAINT fkjumsck59h4jv2ph2fhwfmbi2d FOREIGN KEY (external_references_id) REFERENCES external_reference(id);


--
-- TOC entry 4031 (class 2606 OID 2109872)
-- Name: cross_entity fkjyf7evdes66v72l9add0i7ukj; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY cross_entity
    ADD CONSTRAINT fkjyf7evdes66v72l9add0i7ukj FOREIGN KEY (crossing_project_id) REFERENCES crossing_project(id);


--
-- TOC entry 4049 (class 2606 OID 2109962)
-- Name: event_additional_info fkk0b8t9ltd9pen3qtflg5fcid8; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY event_additional_info
    ADD CONSTRAINT fkk0b8t9ltd9pen3qtflg5fcid8 FOREIGN KEY (additional_info_id) REFERENCES additional_info(id);


--
-- TOC entry 4002 (class 2606 OID 2049657)
-- Name: germplasm_germplasm_type_storage_code fkk16u51uagu9ruepck38qr89js; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY germplasm_germplasm_type_storage_code
    ADD CONSTRAINT fkk16u51uagu9ruepck38qr89js FOREIGN KEY (germplasm_type_storage_code_dbid) REFERENCES germplasm_type_storage_code(id);


--
-- TOC entry 4011 (class 2606 OID 2109772)
-- Name: allele_call_additional_info fkk3eqlbxna5bu1ghw2lvd659so; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY allele_call_additional_info
    ADD CONSTRAINT fkk3eqlbxna5bu1ghw2lvd659so FOREIGN KEY (additional_info_id) REFERENCES additional_info(id);


--
-- TOC entry 4140 (class 2606 OID 2110422)
-- Name: observation fkk47naotiec0cw7kpboyfbu4b1; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY observation
    ADD CONSTRAINT fkk47naotiec0cw7kpboyfbu4b1 FOREIGN KEY (season_id) REFERENCES season(id);


--
-- TOC entry 4101 (class 2606 OID 2110222)
-- Name: image_observations fkk8m5ehyf7axe6q7u560kvm68s; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY image_observations
    ADD CONSTRAINT fkk8m5ehyf7axe6q7u560kvm68s FOREIGN KEY (observations_id) REFERENCES observation(id);


--
-- TOC entry 4086 (class 2606 OID 2110152)
-- Name: germplasm_institute fkk9yp3d2siqb14sw6gvvrcspo6; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY germplasm_institute
    ADD CONSTRAINT fkk9yp3d2siqb14sw6gvvrcspo6 FOREIGN KEY (germplasm_id) REFERENCES germplasm(id);


--
-- TOC entry 4226 (class 2606 OID 2110852)
-- Name: sample fkkbdme00c5ep0xx088cjvgh4i7; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY sample
    ADD CONSTRAINT fkkbdme00c5ep0xx088cjvgh4i7 FOREIGN KEY (study_id) REFERENCES study(id);


--
-- TOC entry 4251 (class 2606 OID 2110982)
-- Name: seed_lot_additional_info fkkc24okl66lvimenfnd9m5ofrp; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY seed_lot_additional_info
    ADD CONSTRAINT fkkc24okl66lvimenfnd9m5ofrp FOREIGN KEY (seed_lot_entity_id) REFERENCES seed_lot(id);


--
-- TOC entry 4109 (class 2606 OID 2110272)
-- Name: list_additional_info fkke1isjiev4pwqrykkmft0iubd; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY list_additional_info
    ADD CONSTRAINT fkke1isjiev4pwqrykkmft0iubd FOREIGN KEY (list_entity_id) REFERENCES list(id);


--
-- TOC entry 4243 (class 2606 OID 2110942)
-- Name: search_external_references fkkkrkct3cg8r8tdjpdagavq98l; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY search_external_references
    ADD CONSTRAINT fkkkrkct3cg8r8tdjpdagavq98l FOREIGN KEY (search_request_entity_id) REFERENCES search(id);


--
-- TOC entry 4060 (class 2606 OID 2110027)
-- Name: genome_map_external_references fkklkrodon3modvk940abdpec5w; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY genome_map_external_references
    ADD CONSTRAINT fkklkrodon3modvk940abdpec5w FOREIGN KEY (genome_map_entity_id) REFERENCES genome_map(id);


--
-- TOC entry 4179 (class 2606 OID 2110622)
-- Name: pedigree_node fkkll27h6pngksanbpu2dnnldbt; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY pedigree_node
    ADD CONSTRAINT fkkll27h6pngksanbpu2dnnldbt FOREIGN KEY (germplasm_id) REFERENCES germplasm(id);


--
-- TOC entry 4091 (class 2606 OID 2110177)
-- Name: germplasm_synonym fkkm9j9i32axrnrs34qr9q6a63n; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY germplasm_synonym
    ADD CONSTRAINT fkkm9j9i32axrnrs34qr9q6a63n FOREIGN KEY (germplasm_id) REFERENCES germplasm(id);


--
-- TOC entry 4026 (class 2606 OID 2109857)
-- Name: crop_additional_info fkkmruulm21s38bld3137rutbs5; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY crop_additional_info
    ADD CONSTRAINT fkkmruulm21s38bld3137rutbs5 FOREIGN KEY (crop_entity_id) REFERENCES crop(id);


--
-- TOC entry 4189 (class 2606 OID 2110682)
-- Name: plate fkky4n35tyqgvf2hwq6958yo765; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY plate
    ADD CONSTRAINT fkky4n35tyqgvf2hwq6958yo765 FOREIGN KEY (trial_id) REFERENCES trial(id);


--
-- TOC entry 4237 (class 2606 OID 2110902)
-- Name: scale_external_references fkl6qe8r2q05fnm5qdkpn694ii5; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY scale_external_references
    ADD CONSTRAINT fkl6qe8r2q05fnm5qdkpn694ii5 FOREIGN KEY (external_references_id) REFERENCES external_reference(id);


--
-- TOC entry 4132 (class 2606 OID 2110377)
-- Name: method_external_references fkl88hj87dhueu846uo3qpqq4kt; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY method_external_references
    ADD CONSTRAINT fkl88hj87dhueu846uo3qpqq4kt FOREIGN KEY (external_references_id) REFERENCES external_reference(id);


--
-- TOC entry 4112 (class 2606 OID 2110277)
-- Name: list_external_references fkl9fy5r4gkrlqm2woq1rh896vy; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY list_external_references
    ADD CONSTRAINT fkl9fy5r4gkrlqm2woq1rh896vy FOREIGN KEY (external_references_id) REFERENCES external_reference(id);


--
-- TOC entry 4294 (class 2606 OID 2111192)
-- Name: trait_entity_synonyms fkla1w2g0gglyqr1gk7s4v59y7m; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY trait_entity_synonyms
    ADD CONSTRAINT fkla1w2g0gglyqr1gk7s4v59y7m FOREIGN KEY (trait_entity_id) REFERENCES trait(id);


--
-- TOC entry 4271 (class 2606 OID 2111072)
-- Name: study_contact fklcxxwlmhrlueccix1jwq3i4ul; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY study_contact
    ADD CONSTRAINT fklcxxwlmhrlueccix1jwq3i4ul FOREIGN KEY (person_db_id) REFERENCES person(id);


--
-- TOC entry 4034 (class 2606 OID 2109897)
-- Name: cross_entity_external_references fklk5hdqw7j3kqrpxivdt9yk05o; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY cross_entity_external_references
    ADD CONSTRAINT fklk5hdqw7j3kqrpxivdt9yk05o FOREIGN KEY (cross_entity_id) REFERENCES cross_entity(id);


--
-- TOC entry 4009 (class 2606 OID 2109762)
-- Name: allele_call fklqve9ddl8olner2kkr6rd4003; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY allele_call
    ADD CONSTRAINT fklqve9ddl8olner2kkr6rd4003 FOREIGN KEY (call_set_id) REFERENCES callset(id);


--
-- TOC entry 4023 (class 2606 OID 2109842)
-- Name: callset_variant_sets fklr5bx5nvhchf67cioqakfbu9v; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY callset_variant_sets
    ADD CONSTRAINT fklr5bx5nvhchf67cioqakfbu9v FOREIGN KEY (call_sets_id) REFERENCES callset(id);


--
-- TOC entry 4188 (class 2606 OID 2110657)
-- Name: person_external_references fklwdf8wu424ly5u7umqsn20tnc; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY person_external_references
    ADD CONSTRAINT fklwdf8wu424ly5u7umqsn20tnc FOREIGN KEY (external_references_id) REFERENCES external_reference(id);


--
-- TOC entry 4172 (class 2606 OID 2110582)
-- Name: ontology_entity_documentation_links fkm0elv2jxmknlgb0ov2q7cv5e7; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY ontology_entity_documentation_links
    ADD CONSTRAINT fkm0elv2jxmknlgb0ov2q7cv5e7 FOREIGN KEY (ontology_entity_id) REFERENCES ontology(id);


--
-- TOC entry 4118 (class 2606 OID 2110317)
-- Name: location_additional_info fkm1j1alvjyeot6agm927kka3dj; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY location_additional_info
    ADD CONSTRAINT fkm1j1alvjyeot6agm927kka3dj FOREIGN KEY (location_entity_id) REFERENCES location(id);


--
-- TOC entry 4005 (class 2606 OID 2049792)
-- Name: pedigree fkm3fw6jl9fdir0lu8dgop2glgb; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY pedigree
    ADD CONSTRAINT fkm3fw6jl9fdir0lu8dgop2glgb FOREIGN KEY (parent2_db_id) REFERENCES pedigree(id);


--
-- TOC entry 4257 (class 2606 OID 2111002)
-- Name: seed_lot_external_references fkm5uee4kohmp1o1lrv9v9ah0d4; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY seed_lot_external_references
    ADD CONSTRAINT fkm5uee4kohmp1o1lrv9v9ah0d4 FOREIGN KEY (external_references_id) REFERENCES external_reference(id);


--
-- TOC entry 4338 (class 2606 OID 2111407)
-- Name: vendor_order_external_references fkm75b25x59xcl6u06ovhqd4ag1; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY vendor_order_external_references
    ADD CONSTRAINT fkm75b25x59xcl6u06ovhqd4ag1 FOREIGN KEY (external_references_id) REFERENCES external_reference(id);


--
-- TOC entry 4219 (class 2606 OID 2110822)
-- Name: reference_set_additional_info fkmc0tpp535gohxpoiroeyqlr4e; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY reference_set_additional_info
    ADD CONSTRAINT fkmc0tpp535gohxpoiroeyqlr4e FOREIGN KEY (reference_set_entity_id) REFERENCES reference_set(id);


--
-- TOC entry 4255 (class 2606 OID 2110987)
-- Name: seed_lot_content_mixture fkmg21xechkkguugmc975qwm7u0; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY seed_lot_content_mixture
    ADD CONSTRAINT fkmg21xechkkguugmc975qwm7u0 FOREIGN KEY (cross_id) REFERENCES cross_entity(id);


--
-- TOC entry 4097 (class 2606 OID 2110202)
-- Name: image_additional_info fkmhmpvdrmh69ht54eh9ctoepge; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY image_additional_info
    ADD CONSTRAINT fkmhmpvdrmh69ht54eh9ctoepge FOREIGN KEY (additional_info_id) REFERENCES additional_info(id);


--
-- TOC entry 4015 (class 2606 OID 2109792)
-- Name: breeding_method_additional_info fkmpeq29821uki8lu5bpshbe4yy; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY breeding_method_additional_info
    ADD CONSTRAINT fkmpeq29821uki8lu5bpshbe4yy FOREIGN KEY (additional_info_id) REFERENCES additional_info(id);


--
-- TOC entry 4227 (class 2606 OID 2110857)
-- Name: sample fkmr8ueym2af0w8udonxhb8odix; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY sample
    ADD CONSTRAINT fkmr8ueym2af0w8udonxhb8odix FOREIGN KEY (taxon_id_id) REFERENCES germplasm_taxon(id);


--
-- TOC entry 4235 (class 2606 OID 2110892)
-- Name: scale_additional_info fkmtoj4hkjnb1tyist5q85qr2g9; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY scale_additional_info
    ADD CONSTRAINT fkmtoj4hkjnb1tyist5q85qr2g9 FOREIGN KEY (additional_info_id) REFERENCES additional_info(id);


--
-- TOC entry 4067 (class 2606 OID 2110052)
-- Name: germplasm_additional_info fkmtyhxh8nywe41gltkodjco0qq; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY germplasm_additional_info
    ADD CONSTRAINT fkmtyhxh8nywe41gltkodjco0qq FOREIGN KEY (additional_info_id) REFERENCES additional_info(id);


--
-- TOC entry 4267 (class 2606 OID 2111042)
-- Name: study fkmw17bwnsc3wjy5emvknrepdha; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY study
    ADD CONSTRAINT fkmw17bwnsc3wjy5emvknrepdha FOREIGN KEY (crop_id) REFERENCES crop(id);


--
-- TOC entry 4154 (class 2606 OID 2110497)
-- Name: observation_unit_additional_info fkmxg4u33203ati7ties5a20w2b; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY observation_unit_additional_info
    ADD CONSTRAINT fkmxg4u33203ati7ties5a20w2b FOREIGN KEY (observation_unit_entity_id) REFERENCES observation_unit(id);


--
-- TOC entry 4323 (class 2606 OID 2111342)
-- Name: variantset fkmycnt85wyf9x7q45h9wjy0ehj; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY variantset
    ADD CONSTRAINT fkmycnt85wyf9x7q45h9wjy0ehj FOREIGN KEY (study_id) REFERENCES study(id);


--
-- TOC entry 4207 (class 2606 OID 2110752)
-- Name: program_external_references fkn3popdlu288xgpk4wdokwqhhi; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY program_external_references
    ADD CONSTRAINT fkn3popdlu288xgpk4wdokwqhhi FOREIGN KEY (external_references_id) REFERENCES external_reference(id);


--
-- TOC entry 4024 (class 2606 OID 2109837)
-- Name: callset_variant_sets fkn62gqkvd24fje4tsoy7i64gyc; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY callset_variant_sets
    ADD CONSTRAINT fkn62gqkvd24fje4tsoy7i64gyc FOREIGN KEY (variant_sets_id) REFERENCES variantset(id);


--
-- TOC entry 4283 (class 2606 OID 2111132)
-- Name: study_variable fkn8qb3ddd0tshid66qlgdxgssc; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY study_variable
    ADD CONSTRAINT fkn8qb3ddd0tshid66qlgdxgssc FOREIGN KEY (variable_db_id) REFERENCES observation_variable(id);


--
-- TOC entry 4036 (class 2606 OID 2109917)
-- Name: cross_parent fknc44kejsxwb41pqybibfkrfgd; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY cross_parent
    ADD CONSTRAINT fknc44kejsxwb41pqybibfkrfgd FOREIGN KEY (observation_unit_id) REFERENCES observation_unit(id);


--
-- TOC entry 4129 (class 2606 OID 2110372)
-- Name: method_additional_info fkncxdbq0uav0lsoetp8jdhfnf5; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY method_additional_info
    ADD CONSTRAINT fkncxdbq0uav0lsoetp8jdhfnf5 FOREIGN KEY (method_entity_id) REFERENCES method(id);


--
-- TOC entry 4215 (class 2606 OID 2110792)
-- Name: reference_bases_external_references fkndb5wyyy87tyaa9g6k0rkxbf3; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY reference_bases_external_references
    ADD CONSTRAINT fkndb5wyyy87tyaa9g6k0rkxbf3 FOREIGN KEY (external_references_id) REFERENCES external_reference(id);


--
-- TOC entry 4344 (class 2606 OID 2111442)
-- Name: vendor_order_entity_required_service_info fkneogvedbrwyxf523kexb0wvh8; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY vendor_order_entity_required_service_info
    ADD CONSTRAINT fkneogvedbrwyxf523kexb0wvh8 FOREIGN KEY (vendor_order_entity_id) REFERENCES vendor_order(id);


--
-- TOC entry 4272 (class 2606 OID 2111082)
-- Name: study_data_link fknhgb2dwb4ffbsmydrhmephyyd; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY study_data_link
    ADD CONSTRAINT fknhgb2dwb4ffbsmydrhmephyyd FOREIGN KEY (study_id) REFERENCES study(id);


--
-- TOC entry 4315 (class 2606 OID 2111302)
-- Name: variant_additional_info fknkg21jfw2m15nrt5wsg0j05kn; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY variant_additional_info
    ADD CONSTRAINT fknkg21jfw2m15nrt5wsg0j05kn FOREIGN KEY (variant_entity_id) REFERENCES variant(id);


--
-- TOC entry 4331 (class 2606 OID 2111377)
-- Name: variant_set_analysis_entity_software fknx3gnntbonjgjc55csk4bqejb; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY variant_set_analysis_entity_software
    ADD CONSTRAINT fknx3gnntbonjgjc55csk4bqejb FOREIGN KEY (variant_set_analysis_entity_id) REFERENCES variantset_analysis(id);


--
-- TOC entry 4065 (class 2606 OID 2110042)
-- Name: germplasm fknyyqkkcjus7hj9jmhu0k6xa83; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY germplasm
    ADD CONSTRAINT fknyyqkkcjus7hj9jmhu0k6xa83 FOREIGN KEY (breeding_method_id) REFERENCES breeding_method(id);


--
-- TOC entry 4218 (class 2606 OID 2110812)
-- Name: reference_set fko1ndd24soyk8191bqhg7fegdg; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY reference_set
    ADD CONSTRAINT fko1ndd24soyk8191bqhg7fegdg FOREIGN KEY (source_germplasm_id) REFERENCES germplasm(id);


--
-- TOC entry 4245 (class 2606 OID 2110952)
-- Name: season_additional_info fko2ck6c1svnhopldbgb3w4f8mr; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY season_additional_info
    ADD CONSTRAINT fko2ck6c1svnhopldbgb3w4f8mr FOREIGN KEY (season_entity_id) REFERENCES season(id);


--
-- TOC entry 4130 (class 2606 OID 2110367)
-- Name: method_additional_info fko2ye8bg2c965oarcgjpbwiivq; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY method_additional_info
    ADD CONSTRAINT fko2ye8bg2c965oarcgjpbwiivq FOREIGN KEY (additional_info_id) REFERENCES additional_info(id);


--
-- TOC entry 4169 (class 2606 OID 2110562)
-- Name: ontology_additional_info fko7f8sbm28vc1kdujwm3lq7g04; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY ontology_additional_info
    ADD CONSTRAINT fko7f8sbm28vc1kdujwm3lq7g04 FOREIGN KEY (additional_info_id) REFERENCES additional_info(id);


--
-- TOC entry 4327 (class 2606 OID 2111357)
-- Name: variantset_analysis fko9jtegpt029eaca8mifd8yrm4; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY variantset_analysis
    ADD CONSTRAINT fko9jtegpt029eaca8mifd8yrm4 FOREIGN KEY (variant_set_id) REFERENCES variantset(id);


--
-- TOC entry 4094 (class 2606 OID 2110197)
-- Name: image fkob3t0l8jr07byg0p3vd06yig4; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY image
    ADD CONSTRAINT fkob3t0l8jr07byg0p3vd06yig4 FOREIGN KEY (observation_unit_id) REFERENCES observation_unit(id);


--
-- TOC entry 4122 (class 2606 OID 2110337)
-- Name: marker_position fkocqa1yc7162ddvaivrsuun0mb; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY marker_position
    ADD CONSTRAINT fkocqa1yc7162ddvaivrsuun0mb FOREIGN KEY (variant_id) REFERENCES variant(id);


--
-- TOC entry 4305 (class 2606 OID 2111247)
-- Name: variable_base_entity fkoe75mtivumaw982qae8jqwkjl; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY variable_base_entity
    ADD CONSTRAINT fkoe75mtivumaw982qae8jqwkjl FOREIGN KEY (crop_id) REFERENCES crop(id);


--
-- TOC entry 4278 (class 2606 OID 2111112)
-- Name: study_last_update fkogmwhwbr1qx6vr1qr1nh6owpp; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY study_last_update
    ADD CONSTRAINT fkogmwhwbr1qx6vr1qr1nh6owpp FOREIGN KEY (study_id) REFERENCES study(id);


--
-- TOC entry 4270 (class 2606 OID 2111077)
-- Name: study_contact fkojmdovj11j3s8qxewlfjuw08y; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY study_contact
    ADD CONSTRAINT fkojmdovj11j3s8qxewlfjuw08y FOREIGN KEY (study_db_id) REFERENCES study(id);


--
-- TOC entry 4092 (class 2606 OID 2110182)
-- Name: germplasm_taxon fkokfpuhyosimp5gdloucr73vja; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY germplasm_taxon
    ADD CONSTRAINT fkokfpuhyosimp5gdloucr73vja FOREIGN KEY (germplasm_id) REFERENCES germplasm(id);


--
-- TOC entry 4133 (class 2606 OID 2110392)
-- Name: method_ontology_reference fkolyxojh3ugs13hjipaycjfkmv; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY method_ontology_reference
    ADD CONSTRAINT fkolyxojh3ugs13hjipaycjfkmv FOREIGN KEY (method_entity_id) REFERENCES method(id);


--
-- TOC entry 4316 (class 2606 OID 2111297)
-- Name: variant_additional_info fkornm8f4smmrmdvii8bxhs8fa6; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY variant_additional_info
    ADD CONSTRAINT fkornm8f4smmrmdvii8bxhs8fa6 FOREIGN KEY (additional_info_id) REFERENCES additional_info(id);


--
-- TOC entry 4119 (class 2606 OID 2110312)
-- Name: location_additional_info fkos7ifwhk5c6e5hs79on5dfss9; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY location_additional_info
    ADD CONSTRAINT fkos7ifwhk5c6e5hs79on5dfss9 FOREIGN KEY (additional_info_id) REFERENCES additional_info(id);


--
-- TOC entry 4114 (class 2606 OID 2110307)
-- Name: location fkow7as0lg8ttlh4d5chs81y46; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY location
    ADD CONSTRAINT fkow7as0lg8ttlh4d5chs81y46 FOREIGN KEY (program_id) REFERENCES program(id);


--
-- TOC entry 4324 (class 2606 OID 2111337)
-- Name: variantset fkoy17h5s7f83vl8rfcpeqduhp3; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY variantset
    ADD CONSTRAINT fkoy17h5s7f83vl8rfcpeqduhp3 FOREIGN KEY (reference_set_id) REFERENCES reference_set(id);


--
-- TOC entry 4197 (class 2606 OID 2110707)
-- Name: plate_submission fkp6b3ib0xl55upbyhk3fm15r1q; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY plate_submission
    ADD CONSTRAINT fkp6b3ib0xl55upbyhk3fm15r1q FOREIGN KEY (order_id) REFERENCES vendor_order(id);


--
-- TOC entry 4194 (class 2606 OID 2110687)
-- Name: plate_additional_info fkp6ilw523vmukl8s757dfa996c; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY plate_additional_info
    ADD CONSTRAINT fkp6ilw523vmukl8s757dfa996c FOREIGN KEY (additional_info_id) REFERENCES additional_info(id);


--
-- TOC entry 4236 (class 2606 OID 2110907)
-- Name: scale_external_references fkp6jdfm8j68sdcffih55dq6ypb; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY scale_external_references
    ADD CONSTRAINT fkp6jdfm8j68sdcffih55dq6ypb FOREIGN KEY (scale_entity_id) REFERENCES scale(id);


--
-- TOC entry 4017 (class 2606 OID 2109802)
-- Name: breeding_method_external_references fkpm6iyumy3nlcpp2ja4djklvge; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY breeding_method_external_references
    ADD CONSTRAINT fkpm6iyumy3nlcpp2ja4djklvge FOREIGN KEY (external_references_id) REFERENCES external_reference(id);


--
-- TOC entry 4141 (class 2606 OID 2110427)
-- Name: observation fkpq3oyu9tuqcttfj2dutdvgv4d; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY observation
    ADD CONSTRAINT fkpq3oyu9tuqcttfj2dutdvgv4d FOREIGN KEY (study_id) REFERENCES study(id);


--
-- TOC entry 4208 (class 2606 OID 2110762)
-- Name: reference fkpr6hqcaxgwgl0uom9wo22om65; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY reference
    ADD CONSTRAINT fkpr6hqcaxgwgl0uom9wo22om65 FOREIGN KEY (reference_set_id) REFERENCES reference_set(id);


--
-- TOC entry 4111 (class 2606 OID 2110282)
-- Name: list_external_references fkpumhc5eurjfeva73tg03qo5s4; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY list_external_references
    ADD CONSTRAINT fkpumhc5eurjfeva73tg03qo5s4 FOREIGN KEY (list_entity_id) REFERENCES list(id);


--
-- TOC entry 4185 (class 2606 OID 2110652)
-- Name: person_additional_info fkpxbki7aent2sujme4k2hkxipq; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY person_additional_info
    ADD CONSTRAINT fkpxbki7aent2sujme4k2hkxipq FOREIGN KEY (person_entity_id) REFERENCES person(id);


--
-- TOC entry 4038 (class 2606 OID 2109907)
-- Name: cross_parent fkq11y3b8pxp3whpa8vihf9yr7; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY cross_parent
    ADD CONSTRAINT fkq11y3b8pxp3whpa8vihf9yr7 FOREIGN KEY (crossing_project_id) REFERENCES crossing_project(id);


--
-- TOC entry 4279 (class 2606 OID 2111117)
-- Name: study_observation_level fkq886b0f9213w91opmlha96b0g; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY study_observation_level
    ADD CONSTRAINT fkq886b0f9213w91opmlha96b0g FOREIGN KEY (study_id) REFERENCES study(id);


--
-- TOC entry 4021 (class 2606 OID 2109832)
-- Name: callset_external_references fkq8ectsigj1r23lx3isjwrxqml; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY callset_external_references
    ADD CONSTRAINT fkq8ectsigj1r23lx3isjwrxqml FOREIGN KEY (call_set_entity_id) REFERENCES callset(id);


--
-- TOC entry 4303 (class 2606 OID 2111232)
-- Name: trial_external_references fkq93pukjnqegcdixpqb54jdjbl; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY trial_external_references
    ADD CONSTRAINT fkq93pukjnqegcdixpqb54jdjbl FOREIGN KEY (external_references_id) REFERENCES external_reference(id);


--
-- TOC entry 4258 (class 2606 OID 2111017)
-- Name: seed_lot_transaction fkqbk3jxmv73a38qv214gf2awq7; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY seed_lot_transaction
    ADD CONSTRAINT fkqbk3jxmv73a38qv214gf2awq7 FOREIGN KEY (to_seed_lot_id) REFERENCES seed_lot(id);


--
-- TOC entry 4095 (class 2606 OID 2110192)
-- Name: image fkqgoqu922hdv3ggb0amnct2muc; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY image
    ADD CONSTRAINT fkqgoqu922hdv3ggb0amnct2muc FOREIGN KEY (coordinates_id) REFERENCES geojson(id);


--
-- TOC entry 4276 (class 2606 OID 2111097)
-- Name: study_external_references fkqpn1n6famc9dkaf5bjalj914d; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY study_external_references
    ADD CONSTRAINT fkqpn1n6famc9dkaf5bjalj914d FOREIGN KEY (external_references_id) REFERENCES external_reference(id);


--
-- TOC entry 4073 (class 2606 OID 2110092)
-- Name: germplasm_attribute_value fkqqry5v3us53yf0o4dlcd7dxg8; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY germplasm_attribute_value
    ADD CONSTRAINT fkqqry5v3us53yf0o4dlcd7dxg8 FOREIGN KEY (germplasm_id) REFERENCES germplasm(id);


--
-- TOC entry 4055 (class 2606 OID 2109997)
-- Name: event_entity_dates fkqu00khnwvqd2wgxdxa0kp7th0; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY event_entity_dates
    ADD CONSTRAINT fkqu00khnwvqd2wgxdxa0kp7th0 FOREIGN KEY (event_entity_id) REFERENCES event(id);


--
-- TOC entry 4192 (class 2606 OID 2110667)
-- Name: plate fkquqjxsw3cp462nlrpcb9dp6d7; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY plate
    ADD CONSTRAINT fkquqjxsw3cp462nlrpcb9dp6d7 FOREIGN KEY (program_id) REFERENCES program(id);


--
-- TOC entry 4216 (class 2606 OID 2110807)
-- Name: reference_external_references fkr0nxjwbpehkbp8vfg3xyql5vy; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY reference_external_references
    ADD CONSTRAINT fkr0nxjwbpehkbp8vfg3xyql5vy FOREIGN KEY (reference_entity_id) REFERENCES reference(id);


--
-- TOC entry 4006 (class 2606 OID 2049787)
-- Name: pedigree fkr4crrn7ql4t6drjo91qew7mhr; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY pedigree
    ADD CONSTRAINT fkr4crrn7ql4t6drjo91qew7mhr FOREIGN KEY (parent1_db_id) REFERENCES pedigree(id);


--
-- TOC entry 4310 (class 2606 OID 2111272)
-- Name: variable_base_entity_additional_info fkr7wswlsc1oglxrkx53a6gsqny; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY variable_base_entity_additional_info
    ADD CONSTRAINT fkr7wswlsc1oglxrkx53a6gsqny FOREIGN KEY (additional_info_id) REFERENCES additional_info(id);


--
-- TOC entry 4152 (class 2606 OID 2110482)
-- Name: observation_unit fkra6qtii65bohk2l3hu14ocb91; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY observation_unit
    ADD CONSTRAINT fkra6qtii65bohk2l3hu14ocb91 FOREIGN KEY (study_id) REFERENCES study(id);


--
-- TOC entry 4285 (class 2606 OID 2111147)
-- Name: trait_abbreviation fkrar3erhikad78x1vsh6uvp2aw; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY trait_abbreviation
    ADD CONSTRAINT fkrar3erhikad78x1vsh6uvp2aw FOREIGN KEY (trait_id) REFERENCES trait(id);


--
-- TOC entry 4292 (class 2606 OID 2111182)
-- Name: trait_synonym fkrdvotrungvhk06df1kx4bo7mb; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY trait_synonym
    ADD CONSTRAINT fkrdvotrungvhk06df1kx4bo7mb FOREIGN KEY (trait_id) REFERENCES trait(id);


--
-- TOC entry 4146 (class 2606 OID 2110447)
-- Name: observation_external_references fkrfoobkjhj680bao4o0o1f96ke; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY observation_external_references
    ADD CONSTRAINT fkrfoobkjhj680bao4o0o1f96ke FOREIGN KEY (external_references_id) REFERENCES external_reference(id);


--
-- TOC entry 4211 (class 2606 OID 2110777)
-- Name: reference_bases fkro4r722mjgl8huj88soea80le; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY reference_bases
    ADD CONSTRAINT fkro4r722mjgl8huj88soea80le FOREIGN KEY (reference_id) REFERENCES reference(id);


--
-- TOC entry 4103 (class 2606 OID 2110237)
-- Name: linkage_group fkrogxv436q8e7entpcc94q7x2k; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY linkage_group
    ADD CONSTRAINT fkrogxv436q8e7entpcc94q7x2k FOREIGN KEY (genome_map_id) REFERENCES genome_map(id);


--
-- TOC entry 4117 (class 2606 OID 2110292)
-- Name: location fks18k8b2w156hg5m57b7r35fp9; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY location
    ADD CONSTRAINT fks18k8b2w156hg5m57b7r35fp9 FOREIGN KEY (coordinates_id) REFERENCES geojson(id);


--
-- TOC entry 4012 (class 2606 OID 2109787)
-- Name: allele_call_external_references fks1ixxwy7h24uq46yj7tfuc0o4; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY allele_call_external_references
    ADD CONSTRAINT fks1ixxwy7h24uq46yj7tfuc0o4 FOREIGN KEY (call_entity_id) REFERENCES allele_call(id);


--
-- TOC entry 4329 (class 2606 OID 2111362)
-- Name: variantset_external_references fks1o96o9fb86ulu0el5om4nkmd; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY variantset_external_references
    ADD CONSTRAINT fks1o96o9fb86ulu0el5om4nkmd FOREIGN KEY (external_references_id) REFERENCES external_reference(id);


--
-- TOC entry 4330 (class 2606 OID 2111372)
-- Name: variantset_format fkse2qx2lkfhnb00nnoexcpa1fu; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY variantset_format
    ADD CONSTRAINT fkse2qx2lkfhnb00nnoexcpa1fu FOREIGN KEY (variant_set_id) REFERENCES variantset(id);


--
-- TOC entry 4266 (class 2606 OID 2111047)
-- Name: study fksfltd06jhrx1cyh72tpyh2d5r; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY study
    ADD CONSTRAINT fksfltd06jhrx1cyh72tpyh2d5r FOREIGN KEY (location_id) REFERENCES location(id);


--
-- TOC entry 4275 (class 2606 OID 2111102)
-- Name: study_external_references fksj8raswfnpyuh1fwf8yfu53qk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY study_external_references
    ADD CONSTRAINT fksj8raswfnpyuh1fwf8yfu53qk FOREIGN KEY (study_entity_id) REFERENCES study(id);


--
-- TOC entry 4125 (class 2606 OID 2110342)
-- Name: marker_position_additional_info fkskhha4yhni28yjy44eei6cn1m; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY marker_position_additional_info
    ADD CONSTRAINT fkskhha4yhni28yjy44eei6cn1m FOREIGN KEY (additional_info_id) REFERENCES additional_info(id);


--
-- TOC entry 4184 (class 2606 OID 2110637)
-- Name: pedigree_node_external_references fksoj94vfgyng2d5bhwkautd8nl; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY pedigree_node_external_references
    ADD CONSTRAINT fksoj94vfgyng2d5bhwkautd8nl FOREIGN KEY (external_references_id) REFERENCES external_reference(id);


--
-- TOC entry 4290 (class 2606 OID 2111177)
-- Name: trait_ontology_reference fksxd4d5p4m8xhvsguxfxonqck; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY trait_ontology_reference
    ADD CONSTRAINT fksxd4d5p4m8xhvsguxfxonqck FOREIGN KEY (trait_entity_id) REFERENCES trait(id);


--
-- TOC entry 4134 (class 2606 OID 2110387)
-- Name: method_ontology_reference fkt187lniiq4ulw2hbyd7jrxkii; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY method_ontology_reference
    ADD CONSTRAINT fkt187lniiq4ulw2hbyd7jrxkii FOREIGN KEY (ontology_reference_id) REFERENCES ontology_ref(id);


--
-- TOC entry 4308 (class 2606 OID 2111262)
-- Name: variable_base_entity fkt231xoex97i7luntla7du6guv; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY variable_base_entity
    ADD CONSTRAINT fkt231xoex97i7luntla7du6guv FOREIGN KEY (scale_id) REFERENCES scale(id);


--
-- TOC entry 4098 (class 2606 OID 2110217)
-- Name: image_external_references fkt3uy354jynflg06911dxjlu1i; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY image_external_references
    ADD CONSTRAINT fkt3uy354jynflg06911dxjlu1i FOREIGN KEY (image_entity_id) REFERENCES image(id);


--
-- TOC entry 4230 (class 2606 OID 2110867)
-- Name: sample_additional_info fkt756x10ijfwncx2h2b7arcfwk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY sample_additional_info
    ADD CONSTRAINT fkt756x10ijfwncx2h2b7arcfwk FOREIGN KEY (additional_info_id) REFERENCES additional_info(id);


--
-- TOC entry 4093 (class 2606 OID 2110187)
-- Name: germplasm_entity_type_of_germplasm_storage_code fktahnvan5u79myt3kbqkijra78; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY germplasm_entity_type_of_germplasm_storage_code
    ADD CONSTRAINT fktahnvan5u79myt3kbqkijra78 FOREIGN KEY (germplasm_entity_id) REFERENCES germplasm(id);


--
-- TOC entry 4247 (class 2606 OID 2110962)
-- Name: season_external_references fktd03hbghqblpq7ril3on0tbvk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY season_external_references
    ADD CONSTRAINT fktd03hbghqblpq7ril3on0tbvk FOREIGN KEY (season_entity_id) REFERENCES season(id);


--
-- TOC entry 4096 (class 2606 OID 2110207)
-- Name: image_additional_info fktgob5bja63ncdvs3apqpkaiel; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY image_additional_info
    ADD CONSTRAINT fktgob5bja63ncdvs3apqpkaiel FOREIGN KEY (image_entity_id) REFERENCES image(id);


--
-- TOC entry 4261 (class 2606 OID 2111022)
-- Name: seed_lot_transaction_additional_info fktoleq2k6deoeemvobenjpdir2; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY seed_lot_transaction_additional_info
    ADD CONSTRAINT fktoleq2k6deoeemvobenjpdir2 FOREIGN KEY (additional_info_id) REFERENCES additional_info(id);


--
-- TOC entry 4340 (class 2606 OID 2111417)
-- Name: vendor_spec_additional_info fktpypusyxppcuv845ww67cxgly; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY vendor_spec_additional_info
    ADD CONSTRAINT fktpypusyxppcuv845ww67cxgly FOREIGN KEY (additional_info_id) REFERENCES additional_info(id);


--
-- TOC entry 4147 (class 2606 OID 2110457)
-- Name: observation_unit fkueu3tfebsye6drsenqw297bi; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY observation_unit
    ADD CONSTRAINT fkueu3tfebsye6drsenqw297bi FOREIGN KEY (crop_id) REFERENCES crop(id);


--
-- TOC entry 4319 (class 2606 OID 2111317)
-- Name: variant_entity_alternate_bases fkv6ptn907aedytbh5w8mc6t3r; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY variant_entity_alternate_bases
    ADD CONSTRAINT fkv6ptn907aedytbh5w8mc6t3r FOREIGN KEY (variant_entity_id) REFERENCES variant(id);


-- Completed on 2023-09-14 12:08:14

--
-- PostgreSQL database dump complete
--

