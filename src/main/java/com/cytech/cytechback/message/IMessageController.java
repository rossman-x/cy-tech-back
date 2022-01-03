package com.cytech.cytechback.message;

import com.cytech.cytechback.criteria.CriteriasRequestBody;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IMessageController {

    @Operation(summary = "Create new message")
    @ApiResponses(value = {@ApiResponse(responseCode = "201"), @ApiResponse(responseCode = "404", content = @Content)})
    ResponseEntity<Void> createMessage(@RequestBody MessageDTO messageDTO);


    @Operation(summary = "Get list of received messages")
    @ApiResponses(value = {@ApiResponse(responseCode = "200"), @ApiResponse(responseCode = "404", content = @Content)})
    ResponseEntity<List<MessageDTO>> getReceivedMessage(@RequestParam int user_id);
}
