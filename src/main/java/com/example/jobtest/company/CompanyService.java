package com.example.jobtest.company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();

    boolean updateCompany(Long id,Company company);

    void createCompany(Company company);

    Company getCompany(Long id);

    boolean deleteCompany(Long id);


}
