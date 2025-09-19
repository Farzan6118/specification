package com.example.specification.controller.rest;

import com.example.specification.enums.AddressType;
import com.example.specification.model.Address;
import com.example.specification.service.AddressService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/address")
@Tag(
        name = "Address API",
        description = "Operations related to Address management"
)
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

//    // --- Get All ---
@GetMapping
@Operation(summary = "Get all addresses", description = "Retrieve a list of all stored addresses")
public ResponseEntity<List<Address>> selectAll() {
    return ResponseEntity.ok(addressService.findAll());
}

//    // --- Get By Id ---
//    @GetMapping("/{id}")
//    @Operation(summary = "Get address by ID", description = "Retrieve a single address by its ID")
//    public ResponseEntity<Address> getById(@PathVariable Integer id) throws BadRequestException {
//        return ResponseEntity.ok(addressService.getById(id));
//    }

//    // --- Create ---
//    @PostMapping
//    @Operation(summary = "Create a new address", description = "Create a new address in the system")
//    public ResponseEntity<Address> create(@RequestBody Address address) {
//        return ResponseEntity.status(HttpStatus.CREATED).body(addressService.save(address));
//    }

//    // --- Delete ---
//    @DeleteMapping("/{id}")
//    @Operation(summary = "Delete an address", description = "Delete an address by its ID")
//    public ResponseEntity<Void> delete(@PathVariable Integer id) {
//        addressService.deleteById(id);
//        return ResponseEntity.noContent().build();
//    }

    @GetMapping("/search")
    @Operation(
            summary = "Search addresses with pagination and sorting",
            description = "Search addresses by city, province, postal code, type, or default flag. Supports pagination and sorting."
    )
    public ResponseEntity<Page<Address>> search(
            @Parameter(description = "City name (optional)") @RequestParam(required = false) String city,
            @Parameter(description = "Province name (optional)") @RequestParam(required = false) String province,
            @Parameter(description = "Postal code (optional)") @RequestParam(required = false) String postalCode,
            @Parameter(description = "Address type (optional)") @RequestParam(required = false) AddressType addressType,
            @Parameter(description = "Is default address (optional)") @RequestParam(required = false) Boolean isDefault,
            @Parameter(description = "Page number (0-based)") @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "Page size") @RequestParam(defaultValue = "3") int size,
            @Parameter(description = "Sort by field") @RequestParam(defaultValue = "id") String sortBy,
            @Parameter(description = "Sort ascending or descending") @RequestParam(defaultValue = "true") boolean ascending
    ) {
        Page<Address> result = addressService.search(city, province, postalCode, addressType, isDefault, page, size, sortBy, ascending);
        return ResponseEntity.ok(result);
    }
}