/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (4.3.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package ru.randomfqdn.homework.api;

import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;
import ru.randomfqdn.homework.model.Lesson;

import javax.annotation.Generated;
import javax.validation.Valid;
import java.util.Optional;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-02-02T15:48:14.721923900+03:00[Europe/Moscow]")
@Validated
@Api(value = "lesson", description = "the lesson API")
public interface LessonApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * DELETE /lesson/{id} : Delete a lesson
     *
     * @param id  (required)
     * @return Lesson deleted. (status code 200)
     *         or Lesson with such id not found (status code 404)
     *         or Invalid input. (status code 405)
     */
    @ApiOperation(value = "Delete a lesson", nickname = "lessonIdDelete", notes = "", tags={ "lesson", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Lesson deleted."),
        @ApiResponse(code = 404, message = "Lesson with such id not found"),
        @ApiResponse(code = 405, message = "Invalid input.") })
    @RequestMapping(value = "/lesson/{id}",
        method = RequestMethod.DELETE)
    default ResponseEntity<Void> lessonIdDelete(@ApiParam(value = "",required=true) @PathVariable("id") Integer id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /lesson/{id} : Get the lesson object with homework
     *
     * @param id  (required)
     * @return The lesson object with homework (status code 200)
     *         or Lesson with such id not found (status code 404)
     */
    @ApiOperation(value = "Get the lesson object with homework", nickname = "lessonIdGet", notes = "", response = Lesson.class, tags={ "lesson", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The lesson object with homework", response = Lesson.class),
        @ApiResponse(code = 404, message = "Lesson with such id not found") })
    @RequestMapping(value = "/lesson/{id}",
        produces = { "application/json", "application/xml" }, 
        method = RequestMethod.GET)
    default ResponseEntity<Lesson> lessonIdGet(@ApiParam(value = "",required=true) @PathVariable("id") Integer id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"homework\" : [ { \"task\" : \"task\", \"due\" : \"2000-01-23\", \"id\" : 6 }, { \"task\" : \"task\", \"due\" : \"2000-01-23\", \"id\" : 6 } ], \"name\" : \"name\", \"id\" : 0, \"time\" : [ \"time\", \"time\" ], \"day\" : [ \"day\", \"day\" ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/xml"))) {
                    String exampleString = "<lesson> <id>123</id> <name>aeiou</name> <day>aeiou</day> <time>aeiou</time> </lesson>";
                    ApiUtil.setExampleResponse(request, "application/xml", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /lesson/{id} : Update a lesson
     *
     * @param id  (required)
     * @param lesson Lesson object to be added (optional)
     * @return Lesson updated. (status code 200)
     *         or Validation failed (status code 400)
     *         or Lesson with such id not found (status code 404)
     *         or Invalid input. (status code 405)
     */
    @ApiOperation(value = "Update a lesson", nickname = "lessonIdPut", notes = "", response = Lesson.class, tags={ "lesson", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Lesson updated.", response = Lesson.class),
        @ApiResponse(code = 400, message = "Validation failed"),
        @ApiResponse(code = 404, message = "Lesson with such id not found"),
        @ApiResponse(code = 405, message = "Invalid input.") })
    @RequestMapping(value = "/lesson/{id}",
        produces = { "application/json", "application/xml" }, 
        consumes = { "application/json", "application/xml" },
        method = RequestMethod.PUT)
    default ResponseEntity<Lesson> lessonIdPut(@ApiParam(value = "",required=true) @PathVariable("id") Integer id,@ApiParam(value = "Lesson object to be added"  )  @Valid @RequestBody(required = false) Lesson lesson) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"homework\" : [ { \"task\" : \"task\", \"due\" : \"2000-01-23\", \"id\" : 6 }, { \"task\" : \"task\", \"due\" : \"2000-01-23\", \"id\" : 6 } ], \"name\" : \"name\", \"id\" : 0, \"time\" : [ \"time\", \"time\" ], \"day\" : [ \"day\", \"day\" ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/xml"))) {
                    String exampleString = "<lesson> <id>123</id> <name>aeiou</name> <day>aeiou</day> <time>aeiou</time> </lesson>";
                    ApiUtil.setExampleResponse(request, "application/xml", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /lesson : Create new lesson
     *
     * @param lesson Lesson object to be added (optional)
     * @return Lesson added. (status code 200)
     *         or Invalid input. (status code 405)
     */
    @ApiOperation(value = "Create new lesson", nickname = "lessonPost", notes = "", response = Lesson.class, tags={ "lesson", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Lesson added.", response = Lesson.class),
        @ApiResponse(code = 405, message = "Invalid input.") })
    @RequestMapping(value = "/lesson",
        produces = { "application/json", "application/xml" }, 
        consumes = { "application/json", "application/xml" },
        method = RequestMethod.POST)
    default ResponseEntity<Lesson> lessonPost(@ApiParam(value = "Lesson object to be added"  )  @Valid @RequestBody(required = false) Lesson lesson) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"homework\" : [ { \"task\" : \"task\", \"due\" : \"2000-01-23\", \"id\" : 6 }, { \"task\" : \"task\", \"due\" : \"2000-01-23\", \"id\" : 6 } ], \"name\" : \"name\", \"id\" : 0, \"time\" : [ \"time\", \"time\" ], \"day\" : [ \"day\", \"day\" ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/xml"))) {
                    String exampleString = "<null> <id>123</id> <name>aeiou</name> <day>aeiou</day> <time>aeiou</time> </null>";
                    ApiUtil.setExampleResponse(request, "application/xml", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
