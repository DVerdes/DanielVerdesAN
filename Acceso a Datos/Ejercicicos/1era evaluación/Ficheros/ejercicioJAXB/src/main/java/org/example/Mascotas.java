package org.example;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "mascotas")
public class Mascotas {
    private ArrayList<Mascota> mascotas;

    public ArrayList<Mascota> getListaMascotas() {
        return mascotas;
    }

    @XmlElement(name="mascota")
    public void setListaMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
}
