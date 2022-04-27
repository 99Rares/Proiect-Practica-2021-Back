package msg.practica.ro.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import msg.practica.ro.exception.ApartmentNotFoundException;
import msg.practica.ro.model.Apartment;
import msg.practica.ro.repository.ApartmentRepository;
import msg.practica.ro.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4201", "http://localhost:4202"})
@RequestMapping("/api/apartments")
@Tag(name = "Apartments", description = "CRUD Operations for Apartments")
public class ApartmentController {
    @Autowired
    private ApartmentRepository apartmentRepo;

    @Autowired
    private OwnerRepository ownerRepo;

    @CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4201", "http://localhost:4202"})
    @Operation(summary = "Get all apartments")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the list of apartments",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Apartment.class)))}),
            @ApiResponse(responseCode = "404", description = "List not found",
                    content = @Content)})
    @GetMapping("")
    public List<Apartment> findAllApartments() {
        return apartmentRepo.findAll();
    }

    @CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4201", "http://localhost:4202"})
    @Operation(summary = "Get an apartment by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the apartment",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Apartment.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Apartment not found",
                    content = @Content)})
    @GetMapping("/{id}")
    public Apartment findById(@Parameter(description = "id of apartment to be searched")
                              @PathVariable long id) {
        return apartmentRepo.findById(id)
                .orElseThrow(() -> new ApartmentNotFoundException(id));
    }

    @CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4201", "http://localhost:4202"})
    @Operation(summary = "Get the apartments by owner id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the apartment",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Apartment.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Apartment not found",
                    content = @Content)})
    @GetMapping("/getByOwner/{ownerId}")
    public List<Apartment> findByOwnerId(@Parameter(description = "id of owner to be searched")
                              @PathVariable long ownerId) {
        return apartmentRepo.findApartmentsByOwner(ownerId);
    }


    @PostMapping("")
    @CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4201", "http://localhost:4202"})
    @Operation(summary = "Add new apartment")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "the apartment was persisted successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Apartment.class))}),
            @ApiResponse(responseCode = "400", description = "the apartment was NOT persisted",
                    content = @Content),})
    public Apartment createApartment(@RequestBody @Valid Apartment apartment) {
        try {
            ownerRepo.save(apartment.getOwner());
        } catch (Exception e) {
            System.out.println("Something went wrong!");
        }
        return apartmentRepo.save(apartment);
    }

    @PutMapping("")
    @CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4201", "http://localhost:4202"})
    @Operation(summary = "Update apartment")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Apartment successfully updated",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Apartment.class))}),
            @ApiResponse(responseCode = "400", description = "Apartment not successfully updated",
                    content = @Content),})
    public Apartment updateApartment(@RequestBody final Apartment ap) {
        return apartmentRepo.save(ap);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4201", "http://localhost:4202"})
    @Operation(summary = "Delete apartment with certain id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Apartment successfully deleted",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Apartment.class))}),
            @ApiResponse(responseCode = "400", description = "Apartment not successfully deleted",
                    content = @Content),})
    public String deleteApartment(@PathVariable Long id) {
        Optional<Apartment> ap = apartmentRepo.findById(id);
        if (ap.isPresent()) {
            apartmentRepo.delete(ap.get());
            return "Apartment with id " + id + " was successfully deleted";
        } else
            throw new RuntimeException("Apartment with id " + id + " not found");

    }
}
