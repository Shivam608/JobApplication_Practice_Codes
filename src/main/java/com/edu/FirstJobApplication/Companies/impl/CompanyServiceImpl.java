package com.edu.FirstJobApplication.Companies.impl;

import com.edu.FirstJobApplication.Companies.Company;
import com.edu.FirstJobApplication.Companies.CompanyRepository;
import com.edu.FirstJobApplication.Companies.CompanyService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;
    Random randomNumber = new Random();
    private Set<Long> usedIDs = new HashSet<>();

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanyList() {
        return companyRepository.findAll();
    }

    @Override
    public long addCompany(Company company) {
        long uniqueId;
        do {
            uniqueId = Long.parseLong(String.format("%04d", randomNumber.nextLong(10000)));
        } while (usedIDs.contains(uniqueId));

        usedIDs.add(uniqueId);
        company.setCompanyId(uniqueId);
        companyRepository.save(company);
        System.out.println("Generated Unique ID: " + uniqueId);
        return uniqueId;
    }

    @Override
    public Company getCompanyById(long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public boolean updateCompanyById(long id, Company updateCompany) {
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if (optionalCompany.isPresent()) {
            Company company = optionalCompany.get();
            company.setName(updateCompany.getName());
            company.setDescription(updateCompany.getDescription());
            companyRepository.save(company);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCompanyById(long id) {
        if (companyRepository.existsById(id)) {
            try {
                companyRepository.deleteById(id);
                return true;
            } catch (Exception e) {
                System.out.println("No Such Company Available by ID:" + id);
            }
        } else
            System.out.println("No Such Company Available by ID:" + id);
        return false;
    }
}
