package ro.jlg.academy.satcc.interfaces.dto;

import ro.jlg.academy.satcc.domain.Company;

import java.time.LocalDateTime;

public class CreateUpdateSatelliteDTO {
    private String companyName;
    private Integer orbitAltitude;
    private String launchDate;

    public String getCompanyName() {
        return this.companyName;
    }

    public Integer getOrbitAltitude() {
        return this.orbitAltitude;
    }

    public String getLaunchDate() {
        return this.launchDate;
    }
}

// de ce facem LocalDateTime string in DTO