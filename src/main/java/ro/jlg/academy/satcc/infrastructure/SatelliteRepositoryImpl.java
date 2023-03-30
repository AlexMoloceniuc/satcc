package ro.jlg.academy.satcc.infrastructure;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import ro.jlg.academy.satcc.domain.Company;
import ro.jlg.academy.satcc.domain.Satellite;

import javax.swing.table.TableRowSorter;
import java.util.List;

@Repository
public class SatelliteRepositoryImpl {
    private MongoTemplate mongoTemplate;

    public SatelliteRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
    public void save(final Satellite satellite){
        this.mongoTemplate.save(satellite);
    }
    public List<Satellite> findAll() {
        return this.mongoTemplate.findAll(Satellite.class);
    }
    public Satellite findById(final String id) {
        return this.mongoTemplate.findById(id, Satellite.class);
    }
    public void delete(final String satelliteId) {
        final Query query = new Query(Criteria.where("_id").is(satelliteId));
        this.mongoTemplate.remove(query, Satellite.class);
    }

    public List<Satellite> findByOrbit(final Integer orbit) {
        final Query query = new Query();
        query.addCriteria(Criteria.where("orbitAltitude").is(orbit));
        return this.mongoTemplate.find(query, Satellite.class);
    }

}
