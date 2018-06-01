/**
 * NOTE: This class is auto generated by the swagger code generator program (1.0.12-1).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.NewObservationDbIdsResponse;
import io.swagger.model.PhenotypesRequest;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-01T19:24:22.162Z")

@Api(value = "phenotypes", description = "the phenotypes API")
public interface PhenotypesApi {

    @ApiOperation(value = "Save Observation Unit Phenotypes", nickname = "phenotypesPost", notes = "Scope: PHENOTYPING.   Notes:  Along with the study specific phenotype saving calls (in the observationUnit and table formats), this call allows phenotypes to be saved and images to optionally be transferred as well.        Call to invoke for saving the measurements (observations) collected from field for all the observation units. Observation timestamp should be ISO 8601 https://www.w3.org/TR/NOTE-datetime In case where JSON data is zipped for faster transfer speed (as in the case of the IRRI handheld implementation), the zipped JSON file will be listed in datafiles. The zipped file contains a JSON file with the same structure as the BrAPI call. In this case a format parameter should be passed as well. Images can be optionally be uploaded using this call by providing a zipfile of all images in the datafiles, along with the actual zipfile in multi-part form data.", response = NewObservationDbIdsResponse.class, tags={ "Phenotypes","Observations", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = NewObservationDbIdsResponse.class),
        @ApiResponse(code = 400, message = "Bad Request") })
    @RequestMapping(value = "/phenotypes",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<NewObservationDbIdsResponse> phenotypesPost(@ApiParam(value = "In case where JSON data is zipped for faster transfer speed (as in the case of the IRRI handheld implementation), the zipped JSON file will be listed in datafiles. The zipped file contains a JSON file with the same structure as the BrAPI call.", allowableValues = "json, zip") @Valid @RequestParam(value = "format", required = false) String format,@ApiParam(value = ""  )  @Valid @RequestBody PhenotypesRequest body);

}
