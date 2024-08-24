package com.edu.FirstJobApplication.Companies;

import java.util.List;


public interface CompanyService {

    //Get List of Companies
    List<Company> getAllCompanyList();

    // Add a new Company to List
    long addCompany (Company company);

    // Fetch Company By ID
    Company getCompanyById (long id);

    // Update Company Details by Id
    boolean updateCompanyById(long id, Company company);

    // Delete Company by Id
    boolean deleteCompanyById(long id);



}
