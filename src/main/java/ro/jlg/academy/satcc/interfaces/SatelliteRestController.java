package ro.jlg.academy.satcc.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import ro.jlg.academy.satcc.application.SatelliteService;
import ro.jlg.academy.satcc.domain.Satellite;
import ro.jlg.academy.satcc.interfaces.dto.CreateUpdateSatelliteDTO;

import java.util.List;


@RestController
public class SatelliteRestController {
    private SatelliteService satelliteService;
    public SatelliteRestController(SatelliteService satelliteService) {
        this.satelliteService = satelliteService;
    }
    @PostMapping("/satellites")
    public ResponseEntity<Void> create(final @RequestBody CreateUpdateSatelliteDTO dto){
        this.satelliteService.create(dto);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/satellites")
    public ResponseEntity<List<Satellite>> getAll(){
        return ResponseEntity.ok(this.satelliteService.getAll());
    }

    @PatchMapping("/satellites/{satelliteId}")
    public ResponseEntity<Void> update(
            final @PathVariable String satelliteId,
            final @RequestBody CreateUpdateSatelliteDTO dto)
    {
        this.satelliteService.update(satelliteId, dto);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/satellites/{satelliteId}")
    public ResponseEntity<Void> delete (final @PathVariable String satelliteId){
        this.satelliteService.delete(satelliteId);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/satellites/{orbit}")
    public ResponseEntity<List<Satellite>> getAllByOrbit(final @PathVariable Integer orbit){
        return ResponseEntity.ok(this.satelliteService.getByOrbit(orbit));
    }

}