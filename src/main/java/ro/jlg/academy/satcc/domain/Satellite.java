package ro.jlg.academy.satcc.domain;

import java.time.LocalDateTime;

public class Satellite {
    private final String id;
    private String companyName;
    private Integer orbitAltitude;
    private LocalDateTime launchDate;

    public Satellite(
            final String id,
            final String companyName,
            final Integer orbitAltitude,
            final LocalDateTime launchDate
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

    public LocalDateTime getLaunchDate() {
        return this.launchDate;
    }

    public void update(
            final String companyName,
            final Integer orbitAltitude,
            final LocalDateTime launchDate
    ) {
        this.companyName = companyName;
        this.orbitAltitude = orbitAltitude;
        this.launchDate = launchDate;
    }
}
