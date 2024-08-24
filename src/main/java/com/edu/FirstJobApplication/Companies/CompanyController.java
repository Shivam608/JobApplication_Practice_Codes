package com.edu.FirstJobApplication.Companies;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Company_Application")
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    //Get the List of All Companies
    @GetMapping("/getListOfCompanies")
    public ResponseEntity<List<Company>> findAllCompanies() {
        return ResponseEntity.ok(companyService.getAllCompanyList());
    }

    //Find Company By ID
    @GetMapping("/getCompany/{id}")
    public ResponseEntity<?> getCompanyById(@PathVariable long id) {
        Company company = companyService.getCompanyById(id);
        if (company != null){
            return new ResponseEntity<>(company, HttpStatus.OK);
        }
        return new ResponseEntity<>("Company With ID:" + id + "not found ",HttpStatus.NOT_FOUND);
    }

    // Add Company into Repo
    @PostMapping("/AddNewCompany")
    public ResponseEntity<String> createCompany(@RequestBody Company company)  {
        companyService.addCompany(company);
        return new ResponseEntity<>("Created Company Successfully with ID: " + company.getCompanyId(), HttpStatus.CREATED);
    }

    // Delete a Company By ID
    @DeleteMapping("/deleteCompany/{id}")
    public ResponseEntity<String> deleteCompanyById (@PathVariable long id) {
        boolean deleted = companyService.deleteCompanyById(id);
        if (deleted) {
            return new ResponseEntity<>("Company with Specified ID: " + id + " Successfully Deleted", HttpStatus.OK);
        } else return new ResponseEntity<>("Company ID Not Found", HttpStatus.NOT_FOUND);
    }

    //Update Company Details by ID
    @PutMapping("/UpdateCompany/{id}")
    public ResponseEntity<String> updateCompanyById (@PathVariable long id,@RequestBody Company updateCompany) {
        boolean updated = companyService.updateCompanyById(id, updateCompany);
        if (updated) {
            return new ResponseEntity<>("Company Details updated successfully for ID: " + id, HttpStatus.OK);
        }
        String s = "Company Details not found for ID " + id;
        return new ResponseEntity<>(s,HttpStatus.NOT_FOUND);
    }


}
