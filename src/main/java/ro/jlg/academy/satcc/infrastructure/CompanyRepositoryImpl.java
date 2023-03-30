package ro.jlg.academy.satcc.infrastructure;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import ro.jlg.academy.satcc.domain.Company;

import java.util.List;

@Repository
public class CompanyRepositoryImpl {
    private MongoTemplate mongoTemplate;

    public CompanyRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
    public void save(final Company company){
        this.mongoTemplate.save(company);
    }

    public List<Company> findAll() {
        return this.mongoTemplate.findAll(Company.class);
    }
    public Company findById(final String id) {
        return this.mongoTemplate.findById(id, Company.class);
    }

    public Company findByName(final String companyName) {
        final Query query = new Query();
        query.addCriteria(Criteria.where("name").is(companyName));

        return this.mongoTemplate.findOne(query, Company.class);
    }
    public void delete(final String id) {
        final Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
    }
}
