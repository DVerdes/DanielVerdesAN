package org.example;

import java.util.Date;
import java.util.List;

public class Comentario {
    private String texto;
    private Date fechaComentario;
    private Usuario propietario;

    public Comentario(String texto, Date fechaComentario, Usuario propietario) {
        this.texto = texto;
        this.fechaComentario = fechaComentario;
        this.propietario = propietario;
    }

    public Comentario() {
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getFechaComentario() {
        return fechaComentario;
    }

    public void setFechaComentario(Date fechaComentario) {
        this.fechaComentario = fechaComentario;
    }

    public Usuario getPropietario() {
        return propietario;
    }

    public void setPropietario(Usuario propietario) {
        this.propietario = propietario;
    }

    @Override
    public String toString() {
        return "Comentario{" +
                "texto='" + texto + '\'' +
                ", fechaComentario=" + fechaComentario +
                ", propietario=" + propietario +
                '}';
    }

    public List<Comentario> listarComentariosUsuario(String nombreUsuario, List<Comentario> comentarios){
        for(Comentario c : comentarios){
            if(!c.propietario.equals("nombreUsuario")){
                comentarios.remove(c);
            }
        }

        return comentarios;

    }


}
