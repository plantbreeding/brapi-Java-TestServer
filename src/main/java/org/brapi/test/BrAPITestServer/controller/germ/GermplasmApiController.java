package org.brapi.test.BrAPITestServer.controller.germ;

import io.swagger.model.germ.GermplasmListResponse;
import io.swagger.model.germ.GermplasmMCPDResponse;
import io.swagger.model.germ.GermplasmNewRequest;
import io.swagger.model.germ.GermplasmPedigreeResponse;
import io.swagger.model.germ.GermplasmSingleResponse;
import io.swagger.model.germ.ProgenyResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.api.germ.GermplasmApi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:33:36.513Z[GMT]")
@Controller
public class GermplasmApiController implements GermplasmApi {

    private static final Logger log = LoggerFactory.getLogger(GermplasmApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public GermplasmApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<GermplasmSingleResponse> germplasmGermplasmDbIdGet(@ApiParam(value = "The internal id of the germplasm",required=true) @PathVariable("germplasmDbId") String germplasmDbId
,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<GermplasmSingleResponse>(objectMapper.readValue("{\n  \"result\" : \"\",\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}", GermplasmSingleResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<GermplasmSingleResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<GermplasmSingleResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<GermplasmMCPDResponse> germplasmGermplasmDbIdMcpdGet(@ApiParam(value = "the internal id of the germplasm",required=true) @PathVariable("germplasmDbId") String germplasmDbId
,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<GermplasmMCPDResponse>(objectMapper.readValue("{\n  \"result\" : {\n    \"commonCropName\" : \"malting barley\",\n    \"acquisitionDate\" : \"2000-01-23\",\n    \"breedingInstitutes\" : [ {\n      \"instituteCode\" : \"PER001\",\n      \"instituteName\" : \"The BrAPI Institute\"\n    }, {\n      \"instituteCode\" : \"PER001\",\n      \"instituteName\" : \"The BrAPI Institute\"\n    } ],\n    \"subtaxon\" : \"Aspergillus fructus A\",\n    \"alternateIDs\" : [ \"3\", \"http://pui.per/accession/A0000003\", \"A0000003\" ],\n    \"germplasmPUI\" : \"http://pui.per/accession/A0403652\",\n    \"acquisitionSourceCode\" : \"26\",\n    \"mlsStatus\" : \"0\",\n    \"instituteCode\" : \"PER001\",\n    \"collectingInfo\" : {\n      \"collectingMissionIdentifier\" : \"CIATFOR_052\",\n      \"collectingNumber\" : \"ab109909\",\n      \"collectingInstitutes\" : [ {\n        \"instituteCode\" : \"PER001\",\n        \"instituteAddress\" : \"123 Main Street, Lima, Peru, 5555\",\n        \"instituteName\" : \"The BrAPI Institute\"\n      }, {\n        \"instituteCode\" : \"PER001\",\n        \"instituteAddress\" : \"123 Main Street, Lima, Peru, 5555\",\n        \"instituteName\" : \"The BrAPI Institute\"\n      } ],\n      \"collectingDate\" : \"2000-01-23\",\n      \"collectingSite\" : {\n        \"elevation\" : \"35\",\n        \"latitudeDegrees\" : \"42 26 43.1 N\",\n        \"longitudeDecimal\" : \"-076.471934\",\n        \"georeferencingMethod\" : \"WGS84\",\n        \"locationDescription\" : \"South east hill near institute buildings\",\n        \"latitudeDecimal\" : \"+42.445295\",\n        \"longitudeDegrees\" : \"76 28 19.0 W\",\n        \"coordinateUncertainty\" : \"20\",\n        \"spatialReferenceSystem\" : \"WGS84\"\n      }\n    },\n    \"donorInfo\" : {\n      \"donorAccessionPui\" : \"http://pui.per/accession/A0010025\",\n      \"donorInstitute\" : {\n        \"instituteCode\" : \"PER001\",\n        \"instituteName\" : \"The BrAPI Institute\"\n      },\n      \"donorAccessionNumber\" : \"A0090204\"\n    },\n    \"germplasmDbId\" : \"31c4efbc\",\n    \"speciesAuthority\" : \"Smith, 1822\",\n    \"storageTypeCodes\" : [ \"11\", \"13\" ],\n    \"accessionNumber\" : \"A0000003\",\n    \"genus\" : \"Aspergillus\",\n    \"species\" : \"fructus\",\n    \"safetyDuplicateInstitutes\" : [ {\n      \"instituteCode\" : \"PER001\",\n      \"instituteName\" : \"The BrAPI Institute\"\n    }, {\n      \"instituteCode\" : \"PER001\",\n      \"instituteName\" : \"The BrAPI Institute\"\n    } ],\n    \"subtaxonAuthority\" : \"Smith, 1822\",\n    \"countryOfOrigin\" : \"Peru\",\n    \"ancestralData\" : \"A0000001/A0000002\",\n    \"biologicalStatusOfAccessionCode\" : \"421\",\n    \"remarks\" : \"This is an example remark to demonstrate that any notable information can be put here\",\n    \"accessionNames\" : [ \"Symphony\", \"Emma\" ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}", GermplasmMCPDResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<GermplasmMCPDResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<GermplasmMCPDResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<GermplasmPedigreeResponse> germplasmGermplasmDbIdPedigreeGet(@ApiParam(value = "the internal id of the germplasm",required=true) @PathVariable("germplasmDbId") String germplasmDbId
,@ApiParam(value = "text representation of the pedigree") @Valid @RequestParam(value = "notation", required = false) String notation
,@ApiParam(value = "include array of siblings in response") @Valid @RequestParam(value = "includeSiblings", required = false) Boolean includeSiblings
,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<GermplasmPedigreeResponse>(objectMapper.readValue("{\n  \"result\" : {\n    \"pedigree\" : \"A0000001/A0000002\",\n    \"siblings\" : [ {\n      \"germplasmDbId\" : \"334f53a3\",\n      \"germplasmName\" : \"A0021005\"\n    }, {\n      \"germplasmDbId\" : \"7bbbda8c\",\n      \"germplasmName\" : \"A0021006\"\n    }, {\n      \"germplasmDbId\" : \"ab1d9b26\",\n      \"germplasmName\" : \"A0021007\"\n    } ],\n    \"crossingProjectDbId\" : \"625e745a\",\n    \"familyCode\" : \"F0000203\",\n    \"germplasmName\" : \"A0021004\",\n    \"germplasmDbId\" : \"1098ebaf\",\n    \"crossingYear\" : 2005,\n    \"parents\" : [ {\n      \"germplasmDbId\" : \"b66958de\",\n      \"germplasmName\" : \"A0000592\",\n      \"parentType\" : \"MALE\"\n    }, {\n      \"germplasmDbId\" : \"a55847ed\",\n      \"germplasmName\" : \"A0000592\",\n      \"parentType\" : \"FEMALE\"\n    } ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}", GermplasmPedigreeResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<GermplasmPedigreeResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<GermplasmPedigreeResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ProgenyResponse> germplasmGermplasmDbIdProgenyGet(@ApiParam(value = "the internal id of the germplasm",required=true) @PathVariable("germplasmDbId") String germplasmDbId
,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ProgenyResponse>(objectMapper.readValue("{\n  \"result\" : {\n    \"progeny\" : [ {\n      \"germplasmDbId\" : \"e8d5dad7\",\n      \"germplasmName\" : \"A0021011\",\n      \"parentType\" : \"FEMALE\"\n    }, {\n      \"germplasmDbId\" : \"ac07fbd8\",\n      \"germplasmName\" : \"A0021012\",\n      \"parentType\" : \"FEMALE\"\n    }, {\n      \"germplasmDbId\" : \"07f45f67\",\n      \"germplasmName\" : \"A0021013\",\n      \"parentType\" : \"FEMALE\"\n    } ],\n    \"germplasmName\" : \"A0021004\",\n    \"germplasmDbId\" : \"01b974dc\"\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}", ProgenyResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ProgenyResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ProgenyResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<GermplasmSingleResponse> germplasmGermplasmDbIdPut(@ApiParam(value = "The internal id of the germplasm",required=true) @PathVariable("germplasmDbId") String germplasmDbId
,@ApiParam(value = ""  )  @Valid @RequestBody GermplasmNewRequest body
,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<GermplasmSingleResponse>(objectMapper.readValue("{\n  \"result\" : \"\",\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}", GermplasmSingleResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<GermplasmSingleResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<GermplasmSingleResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<GermplasmListResponse> germplasmGet(@ApiParam(value = "Permanent unique identifier (DOI, URI, etc.)") @Valid @RequestParam(value = "germplasmPUI", required = false) String germplasmPUI
,@ApiParam(value = "Internal database identifier") @Valid @RequestParam(value = "germplasmDbId", required = false) String germplasmDbId
,@ApiParam(value = "Name of the germplasm") @Valid @RequestParam(value = "germplasmName", required = false) String germplasmName
,@ApiParam(value = "The common crop name related to this germplasm") @Valid @RequestParam(value = "commonCropName", required = false) String commonCropName
,@ApiParam(value = "Unique identifiers for accessions within a genebank") @Valid @RequestParam(value = "accessionNumber", required = false) String accessionNumber
,@ApiParam(value = "A specific panel/collection/population name this germplasm belongs to.") @Valid @RequestParam(value = "collection", required = false) String collection
,@ApiParam(value = "Genus name to identify germplasm") @Valid @RequestParam(value = "genus", required = false) String genus
,@ApiParam(value = "Species name to identify germplasm") @Valid @RequestParam(value = "species", required = false) String species
,@ApiParam(value = "Search for Germplasm that are associated with a particular Study") @Valid @RequestParam(value = "studyDbId", required = false) String studyDbId
,@ApiParam(value = "Alternative name or ID used to reference this germplasm") @Valid @RequestParam(value = "synonym", required = false) String synonym
,@ApiParam(value = "Search for Germplasm with this parent") @Valid @RequestParam(value = "parentDbId", required = false) String parentDbId
,@ApiParam(value = "Search for Germplasm with this child") @Valid @RequestParam(value = "progenyDbId", required = false) String progenyDbId
,@ApiParam(value = "Search for Germplasm by an external reference") @Valid @RequestParam(value = "externalReferenceID", required = false) String externalReferenceID
,@ApiParam(value = "Search for Germplasm by an external reference") @Valid @RequestParam(value = "externalReferenceSource", required = false) String externalReferenceSource
,@ApiParam(value = "Used to request a specific page of data to be returned.  The page indexing starts at 0 (the first page is 'page'= 0). Default is `0`.") @Valid @RequestParam(value = "page", required = false) Integer page
,@ApiParam(value = "The size of the pages to be returned. Default is `1000`.") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize
,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<GermplasmListResponse>(objectMapper.readValue("{\n  \"result\" : {\n    \"data\" : [ \"\", \"\" ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}", GermplasmListResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<GermplasmListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<GermplasmListResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<GermplasmListResponse> germplasmPost(@ApiParam(value = ""  )  @Valid @RequestBody List<GermplasmNewRequest> body
,@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>" ) @RequestHeader(value="Authorization", required=false) String authorization
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<GermplasmListResponse>(objectMapper.readValue("{\n  \"result\" : {\n    \"data\" : [ \"\", \"\" ]\n  },\n  \"metadata\" : \"\",\n  \"@context\" : [ \"https://brapi.org/jsonld/context/metadata.jsonld\" ]\n}", GermplasmListResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<GermplasmListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<GermplasmListResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

}
