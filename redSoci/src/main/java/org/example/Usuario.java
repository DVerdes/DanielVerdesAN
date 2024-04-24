package org.example;

import java.util.List;

public class Usuario {

    private String nombre;
    private List<Usuario> siguiendo;
    private List<Post> posts;

    public Usuario(String nombre, List<Usuario> siguiendo, List<Post> posts) {
        this.nombre = nombre;
        this.siguiendo = siguiendo;
        this.posts = posts;
    }

    public Usuario() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Usuario> getSiguiendo() {
        return siguiendo;
    }

    public void setSiguiendo(List<Usuario> siguiendo) {
        this.siguiendo = siguiendo;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", siguiendo=" + siguiendo +
                ", posts=" + posts +
                '}';
    }

    public void seguirUsuario(Usuario usuarioASeguir){
        this.siguiendo.add(usuarioASeguir);
    }

    public void dejarDeSeguir(Usuario usuario){
        this.siguiendo.remove(usuario);
    }

    public void listarPosts(){
        for(Post post : this.getPosts()){
            System.out.println(post.toString());
        }
    }

    public void listarComentariosAPostsDelUsuario(){
        for(Post post : this.getPosts()){
            for(Comentario c : post.getComentarios()){
                System.out.println(c.toString());
            }
        }
    }


}
