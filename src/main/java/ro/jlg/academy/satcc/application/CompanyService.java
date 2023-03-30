package ro.jlg.academy.satcc.application;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import ro.jlg.academy.satcc.domain.Company;
import ro.jlg.academy.satcc.domain.Satellite;
import ro.jlg.academy.satcc.infrastructure.CompanyRepositoryImpl;
import ro.jlg.academy.satcc.interfaces.dto.CreateUpdateCompanyDTO;

import java.util.List;
import java.util.UUID;

@Service
public class CompanyService {
    private CompanyRepositoryImpl companyRepository;

    public CompanyService(CompanyRepositoryImpl companyRepository) {
        this.companyRepository = companyRepository;
    }

    public void  create(final CreateUpdateCompanyDTO dto){
        final Company company =new Company(
                UUID.randomUUID().toString(),
                dto.getName(),
                dto.getNoOfSatellites()
        );
        this.companyRepository.save(company);
    }

    public List<Company> getAll(){
        return this.companyRepository.findAll();
    }


    public void update(final String companyId, final CreateUpdateCompanyDTO dto) {
        final Company company = this.companyRepository.findById(companyId);
        company.update(dto.getName(),dto.getNoOfSatellites());
        this.companyRepository.save(company);
    }

    public void delete(final String id) {
        this.companyRepository.delete(id);
    }


}
