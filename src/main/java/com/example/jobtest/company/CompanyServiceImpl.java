package com.example.jobtest.company;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;


    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Long id, Company company) {
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if (optionalCompany.isPresent()) {
            Company oldCompany = optionalCompany.get();
            oldCompany.setName(company.getName());
            oldCompany.setDescription(company.getDescription());
            oldCompany.setJobs(company.getJobs());
            companyRepository.save(oldCompany);
            return true;
        }
        return false;
    }

    @Override
    public void createCompany(Company company) {

        companyRepository.save(company);
    }

    @Override
    public Company getCompany(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteCompany(Long id) {
        try{
            companyRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }


}
