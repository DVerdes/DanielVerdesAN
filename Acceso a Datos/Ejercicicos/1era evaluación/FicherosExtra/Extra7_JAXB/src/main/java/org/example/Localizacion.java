package org.example;

import java.io.Serializable;

public class Localizacion implements Serializable {
    private String ciudad;

    private String region;

    public Localizacion() {
    }

    public Localizacion(String ciudad, String region) {
        this.ciudad = ciudad;
        this.region = region;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "Localizacion{" +
                "ciudad='" + ciudad + '\'' +
                ", region='" + region + '\'' +
                '}';
    }
}
