package com.example.specification.controller.rest;

import com.example.specification.model.Employee;
import com.example.specification.service.EmployeeService;
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
@RequestMapping("api/v1/employee")
@Tag(
        name = "Employee API",
        description = "Operations related to Employee management"
)
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

//    // --- Get All ---
@GetMapping
@Operation(summary = "Get all employees", description = "Retrieve a list of all employees")
public ResponseEntity<List<Employee>> selectAll() {
    return ResponseEntity.ok(employeeService.findAll());
}

//    // --- Get By Id ---
//    @GetMapping("/{id}")
//    @Operation(summary = "Get employee by ID", description = "Retrieve a single employee by its ID")
//    public ResponseEntity<Employee> getById(@PathVariable Integer id) throws BadRequestException {
//        return ResponseEntity.ok(employeeService.getById(id));
//    }

//    // --- Create ---
//    @PostMapping
//    @Operation(summary = "Create a new employee", description = "Create a new employee in the system")
//    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
//        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.save(employee));
//    }

//    // --- Delete ---
//    @DeleteMapping("/{id}")
//    @Operation(summary = "Delete an employee", description = "Delete an employee by its ID")
//    public ResponseEntity<Void> delete(@PathVariable Integer id) {
//        employeeService.deleteById(id);
//        return ResponseEntity.noContent().build();
//    }

    // --- Search ---
    @GetMapping("/search")
    @Operation(summary = "Search employees", description = "Search employees by firstname, lastname or national code")
    public ResponseEntity<Page<Employee>> search(
            @Parameter(description = "Firstname of employee (optional)") @RequestParam(required = false) String firstname,
            @Parameter(description = "Lastname of employee (optional)") @RequestParam(required = false) String lastname,
            @Parameter(description = "National code of employee (optional)") @RequestParam(required = false) String nationalCode,
            @Parameter(description = "Page number (0-based)") @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "Page size") @RequestParam(defaultValue = "3") int size,
            @Parameter(description = "Sort by field") @RequestParam(defaultValue = "id") String sortBy,
            @Parameter(description = "Sort ascending or descending") @RequestParam(defaultValue = "true") boolean ascending
    ) {
        Page<Employee> result = employeeService.search(firstname, lastname, nationalCode, page, size, sortBy, ascending);
        return ResponseEntity.ok(result);
    }
}
