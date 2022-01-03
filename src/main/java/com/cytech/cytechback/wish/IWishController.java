package com.cytech.cytechback.wish;

import com.cytech.cytechback.user.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IWishController {

    @Operation(summary = "Get a list of wishes for a specific user.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200"), @ApiResponse(responseCode = "404", content = @Content)})
    ResponseEntity<List<WishDTO>> getWishList(@RequestParam("id_user") Long userId);

    @Operation(summary = "Create a list of wishes for one user")
    @ApiResponses(value = {@ApiResponse(responseCode = "200"), @ApiResponse(responseCode = "404", content = @Content)})
    ResponseEntity<Void> createManyWishes(@RequestParam("id_user") Long userId, @RequestParam("first_wish") Long firstWishId, @RequestParam("second_wish") Long secondWishId, @RequestParam("third_wish") Long thirdWishId, @RequestParam("forth_wish")  Long forthWishId);
}
