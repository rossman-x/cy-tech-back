package com.cytech.cytechback.score;

import com.cytech.cytechback.criteria.CriteriasRequestBody;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IScoreController {

    @Operation(summary = "Create new score for user $user_id and subject $subject_id")
    @ApiResponses(value = {@ApiResponse(responseCode = "201"), @ApiResponse(responseCode = "404", content = @Content)})
    ResponseEntity<Void> createScore(@RequestBody ScoreDTO scoreDTO);

    @Operation(summary = "Get list of scores by user's Id")
    @ApiResponses(value = {@ApiResponse(responseCode = "201"), @ApiResponse(responseCode = "404", content = @Content)})
    ResponseEntity<List<ScoreDTO>> getScoresByUserId(@RequestParam("user_id") int userId);

}
