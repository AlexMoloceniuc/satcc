package ro.jlg.academy.satcc.interfaces.dto;

public class CreateUpdateCompanyDTO {
    private String name;
    private Integer noOfSatellites;

    public String getName() {
        return this.name;
    }

    public Integer getNoOfSatellites() {
        return this.noOfSatellites;
    }
}
