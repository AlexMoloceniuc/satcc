package ro.jlg.academy.satcc.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Satellite {
    private final String id;
    private String companyName;
    private Integer orbitAltitude;
    private LocalDate launchDate;

    public Satellite(
            final String id,
            final String companyName,
            final Integer orbitAltitude,
            final LocalDate launchDate
    ) {
        this.id = id;
        this.companyName = companyName;
        this.orbitAltitude = orbitAltitude;
        this.launchDate = launchDate;
    }

    public String getId() {
        return this.id;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public Integer getOrbitAltitude() {
        return this.orbitAltitude;
    }

    public LocalDate getLaunchDate() {
        return this.launchDate;
    }

    public void update(
            final String companyName,
            final Integer orbitAltitude,
            final LocalDate launchDate
    ) {
        this.companyName = companyName;
        this.orbitAltitude = orbitAltitude;
        this.launchDate = launchDate;
    }
}
