package org.example;

import java.util.Date;
import java.util.List;

public abstract class Post {

    private Date fechaPost;
    private List<Comentario> comentarios;

    public Post(Date fechaPost, List<Comentario> comentarios) {
        this.fechaPost = fechaPost;
        this.comentarios = comentarios;
    }

    public Post() {
    }

    public Date getFechaPost() {
        return fechaPost;
    }

    public void setFechaPost(Date fechaPost) {
        this.fechaPost = fechaPost;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    @Override
    public String toString() {
        return "Post{" +
                "fechaPost=" + fechaPost +
                ", comentarios=" + comentarios +
                '}';
    }

    public int mostrarNumComentarios(){
        return this.comentarios.size();
    }
}
