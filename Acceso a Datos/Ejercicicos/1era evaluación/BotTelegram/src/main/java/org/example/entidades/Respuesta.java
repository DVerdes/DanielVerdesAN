package org.example.entidades;

import java.util.List;

public class Respuesta {

    private boolean ok;
    private List<Peticion> result;

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public List<Peticion> getResult() {
        return result;
    }

    public void setResult(List<Peticion> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Respuesta{" +
                "ok=" + ok +
                ", result=" + result +
                '}';
    }
}
