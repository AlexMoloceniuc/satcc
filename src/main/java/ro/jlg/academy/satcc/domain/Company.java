package ro.jlg.academy.satcc.domain;

public class Company {
    private final String id;
    private String name;
    private Integer noOfSatellites;
    public Company(final String id, final String name, final Integer noOfSatellites) {
        this.id = id;
        this.name = name;
        this.noOfSatellites = noOfSatellites;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Integer getNoOfSatellites() {
        return this.noOfSatellites;
    }

    public void update(final String newName, final Integer newNumberOfSatellites){
        this.name = newName;
        this.noOfSatellites = newNumberOfSatellites;
    }
}
