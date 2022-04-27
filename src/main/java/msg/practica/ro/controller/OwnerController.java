package msg.practica.ro.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import msg.practica.ro.exception.OwnerNotFoundException;
import msg.practica.ro.model.Owner;
import msg.practica.ro.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4201", "http://localhost:4202"})
@RequestMapping("/api/owners")
@Tag(name = "Owners", description = "CRUD Operations for Owners")
public class OwnerController {
    @Autowired
    private OwnerRepository ownerRepo;

    @CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4201", "http://localhost:4202"})
    @Operation(summary = "Get all owners")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the list of owners",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Owner.class)))}),
            @ApiResponse(responseCode = "404", description = "List not found",
                    content = @Content)})
    @GetMapping("")
    public List<Owner> findAllApartments() {
        return ownerRepo.findAll();
    }

    @CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4201", "http://localhost:4202"})
    @Operation(summary = "Get an owner by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the owner",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Owner.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Owner not found",
                    content = @Content)})
    @GetMapping("/{id}")
    public Owner findById(@Parameter(description = "id of owner to be searched")
                          @PathVariable long id) {
        return ownerRepo.findById(id)
                .orElseThrow(() -> new OwnerNotFoundException(id));
    }

    @CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4201", "http://localhost:4202"})
    @PostMapping("")
    @Operation(summary = "Add new owner")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Owner persisted successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Owner.class))}),
            @ApiResponse(responseCode = "400", description = "Owner NOT persisted successfully",
                    content = @Content),})
    public Owner createOwner(@RequestBody @Valid Owner onr) {

        return ownerRepo.save(onr);
    }

    @CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4201", "http://localhost:4202"})
    @PutMapping("")
    @Operation(summary = "Update owner")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Owner successfully updated",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Owner.class))}),
            @ApiResponse(responseCode = "400", description = "Owner not successfully updated",
                    content = @Content),})
    public Owner updateOwner(@RequestBody final Owner o) {
        return ownerRepo.save(o);
    }

    @CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4201", "http://localhost:4202"})
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete owner with certain id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Owner successfully deleted",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Owner.class))}),
            @ApiResponse(responseCode = "400", description = "Owner not successfully deleted",
                    content = @Content),})
    public String deleteOwner(@PathVariable Long id) {
        Optional<Owner> owner = ownerRepo.findById(id);
        if (owner.isPresent()) {
            ownerRepo.delete(owner.get());
            return "Owner with id " + id + " was successfully deleted";
        } else
            throw new RuntimeException("Owner with id " + id + " not found");

    }
}
