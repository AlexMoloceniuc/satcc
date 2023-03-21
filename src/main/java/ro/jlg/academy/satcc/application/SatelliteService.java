package ro.jlg.academy.satcc.application;

import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Service;
import ro.jlg.academy.satcc.domain.Satellite;
import ro.jlg.academy.satcc.infrastructure.SatelliteRepositoryImpl;
import ro.jlg.academy.satcc.interfaces.dto.CreateUpdateSatelliteDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class SatelliteService {
    private SatelliteRepositoryImpl satelliteRepository;

    public SatelliteService(SatelliteRepositoryImpl satelliteRepository) {
        this.satelliteRepository = satelliteRepository;
    }

    public void create(final CreateUpdateSatelliteDTO dto) {
        final Satellite satellite = new Satellite(
                UUID.randomUUID().toString(),
                dto.getCompanyName(),
                dto.getOrbitAltitude(),
                LocalDateTime.parse(dto.getLaunchDate())
        );
        this.satelliteRepository.save(satellite);
    }
    public List<Satellite> getAll() {
        return this.satelliteRepository.findAll();
    }
    public void update(final String satelliteId, final CreateUpdateSatelliteDTO dto) {
        // 1. Find the satellite by id in the DB
        final Satellite satellite = this.satelliteRepository.findById(satelliteId);
        // 2. Update the satellite object
        satellite.update(dto.getCompanyName(),dto.getOrbitAltitude(), LocalDateTime.parse(dto.getLaunchDate()));
        // 3. Save the changes
        this.satelliteRepository.save(satellite);
        // update the company

    }
    public void delete(final String satelliteId) {
        this.satelliteRepository.delete(satelliteId);
    }

}
