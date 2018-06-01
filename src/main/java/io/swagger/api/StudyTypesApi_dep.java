/**
 * NOTE: This class is auto generated by the swagger code generator program (1.0.12-1).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.StudyTypesResponse;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-01T19:24:22.162Z")

@Api(value = "studyTypes", description = "the studyTypes API")
public interface StudyTypesApi_dep {

    @ApiOperation(value = "<strong>Deprecated</strong> List study types", nickname = "studyTypesGet", notes = " Call to retrieve the list of study types. Scope: PHENOTYPING. Implementation target date: PAG2016 ", response = StudyTypesResponse.class, tags={ "Studies","Deprecated", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = StudyTypesResponse.class) })
    @RequestMapping(value = "/studyTypes",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<StudyTypesResponse> studyTypesGet(@ApiParam(value = "The size of the pages to be returned. Default is `1000`.") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,@ApiParam(value = "Which result page is requested. The page indexing starts at 0 (the first page is 'page'= 0). Default is `0`.") @Valid @RequestParam(value = "page", required = false) Integer page);

}
