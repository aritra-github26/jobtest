package com.example.jobtest.company;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Company>> getAllCompanies() {
        return new ResponseEntity<>(companyService.getAllCompanies(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Company> getCompanyById(@RequestParam Long id) {
        return new ResponseEntity<>(companyService.getCompany(id), HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company company) {
        boolean res = companyService.updateCompany(id, company);
        if (res)
            return new ResponseEntity<>("Company updated.", HttpStatus.OK);
        else
            return new ResponseEntity<>("Company not found", HttpStatus.BAD_REQUEST);
    }

    @PostMapping
    public ResponseEntity<Company> addCompany(@RequestBody Company company) {
        companyService.createCompany(company);
        return new ResponseEntity<>(company, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteCompany(@RequestParam Long id) {
        boolean res = companyService.deleteCompany(id);
        if(res)
            return new ResponseEntity<>("Company deleted.", HttpStatus.OK);
        else
            return new ResponseEntity<>("Company not found.", HttpStatus.NOT_FOUND);
    }


}
