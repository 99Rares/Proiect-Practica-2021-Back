package msg.practica.ro.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import msg.practica.ro.exception.PictureNotFoundException;
import msg.practica.ro.model.Apartment;
import msg.practica.ro.model.Picture;
import msg.practica.ro.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4201", "http://localhost:4202"})
@RequestMapping("/api/pictures")
@Tag(name = "Pictures", description = "CRUD Operations for Pictures")
public class PictureController {
    @Autowired
    private PictureRepository pictureRepo;

    @Operation(summary = "Get all pictures for the apartments")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the list of pictures",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Picture.class)))}),
            @ApiResponse(responseCode = "404", description = "List not found",
                    content = @Content)})
    @GetMapping("")
    public List<Picture> findAllPictures() {
        return pictureRepo.findAll();
    }

    @Operation(summary = "Get a picture by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the picture",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Picture.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Picture not found",
                    content = @Content)})
    @GetMapping("/{id}")
    public Picture findById(@Parameter(description = "id of picture to be searched")
                              @PathVariable long id) {
        return pictureRepo.findById(id)
                .orElseThrow(() -> new PictureNotFoundException(id));
    }

    @PostMapping("")
    @Operation(summary = "Add new picture")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the picture was persisted successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Apartment.class))}),
            @ApiResponse(responseCode = "400", description = "the picture was NOT persisted",
                    content = @Content),})
    public Picture createPicture(@RequestBody @Valid Picture picture){

        return pictureRepo.save(picture);
    }

    @PutMapping("")
    @Operation(summary = "Update picture")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Picture successfully updated",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Picture.class))}),
            @ApiResponse(responseCode = "400", description = "Picture not successfully updated",
                    content = @Content),})
    public Picture updatePicture(@RequestBody final Picture pic) {
        return pictureRepo.save(pic);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete picture with certain id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Picture successfully deleted",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Picture.class))}),
            @ApiResponse(responseCode = "400", description = "Picture not successfully deleted",
                    content = @Content),})
    public String deletePicture(@PathVariable Long id){
        Optional<Picture> pic = pictureRepo.findById(id);
        if(pic.isPresent()){
            pictureRepo.delete(pic.get());
            return "Picture with id " + id + " was successfully deleted";
        }
        else
            throw new RuntimeException("Picture with id " + id + " not found");

    }
}
