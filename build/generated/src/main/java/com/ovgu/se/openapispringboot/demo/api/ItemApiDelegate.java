package com.ovgu.se.openapispringboot.demo.api;

import java.math.BigDecimal;
import com.ovgu.se.openapispringboot.demo.model.HTTPValidationError;
import com.ovgu.se.openapispringboot.demo.model.Item;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * A delegate to be called by the {@link ItemApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */

public interface ItemApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /item/ : Create Item Handler
     *
     * @param item  (required)
     * @return Successful Response (status code 201)
     *         or Validation Error (status code 422)
     * @see ItemApi#createItem
     */
    default ResponseEntity<Item> createItem(Item item) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"price\" : 0.6027456183070403, \"name\" : \"name\", \"description\" : \"description\", \"tax\" : 0.14658129805029452, \"id\" : 0, \"listed_since\" : \"2000-01-23\", \"manufacturer\" : \"manufacturer\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /item/{id} : Delete Item Handler
     *
     * @param id  (required)
     * @return Successful Response (status code 204)
     *         or Validation Error (status code 422)
     * @see ItemApi#deleteItem
     */
    default ResponseEntity<Void> deleteItem(Integer id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /item/{id} : Get Item Handler
     *
     * @param id  (required)
     * @return Successful Response (status code 200)
     *         or Validation Error (status code 422)
     * @see ItemApi#getItem
     */
    default ResponseEntity<Item> getItem(Integer id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"price\" : 0.6027456183070403, \"name\" : \"name\", \"description\" : \"description\", \"tax\" : 0.14658129805029452, \"id\" : 0, \"listed_since\" : \"2000-01-23\", \"manufacturer\" : \"manufacturer\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /item/ : Get Items Handler
     *
     * @param name  (optional)
     * @param manufacturer  (optional)
     * @param listedStarting  (optional)
     * @param listedEnding  (optional)
     * @param description  (optional)
     * @param priceGe  (optional)
     * @param priceLe  (optional)
     * @return Successful Response (status code 200)
     *         or Validation Error (status code 422)
     * @see ItemApi#getItems
     */
    default ResponseEntity<List<Item>> getItems(String name,
        String manufacturer,
        String listedStarting,
        String listedEnding,
        String description,
        BigDecimal priceGe,
        BigDecimal priceLe) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"price\" : 0.6027456183070403, \"name\" : \"name\", \"description\" : \"description\", \"tax\" : 0.14658129805029452, \"id\" : 0, \"listed_since\" : \"2000-01-23\", \"manufacturer\" : \"manufacturer\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /item/{id} : Update Item Handler
     *
     * @param id  (required)
     * @param item  (required)
     * @return Successful Response (status code 201)
     *         or Validation Error (status code 422)
     * @see ItemApi#updateItem
     */
    default ResponseEntity<Item> updateItem(Integer id,
        Item item) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"price\" : 0.6027456183070403, \"name\" : \"name\", \"description\" : \"description\", \"tax\" : 0.14658129805029452, \"id\" : 0, \"listed_since\" : \"2000-01-23\", \"manufacturer\" : \"manufacturer\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
