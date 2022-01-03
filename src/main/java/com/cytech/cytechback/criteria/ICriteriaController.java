package com.cytech.cytechback.criteria;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface ICriteriaController {

    @Operation(summary = "Create new criterias using option id and content")
    @ApiResponses(value = {@ApiResponse(responseCode = "201"), @ApiResponse(responseCode = "404", content = @Content)})
    ResponseEntity<Void> createCriterias(@RequestBody CriteriasRequestBody criteriasRequestBody);
}
