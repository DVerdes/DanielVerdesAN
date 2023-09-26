package org.example;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class PersonaMapping implements Serializable {

    private ArrayList <Persona> personas;

    public PersonaMapping(ArrayList<Persona> personas) {
        this.personas = personas;
    }


    public PersonaMapping() {
    }

    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }

    public void leerObjeto(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.readObject();
    }

}
