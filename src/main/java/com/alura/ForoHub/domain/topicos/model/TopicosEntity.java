package com.alura.ForoHub.domain.topicos.model;

import com.alura.ForoHub.domain.topicos.dtos.RecordTopico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Entity
@Table(name = "topicos")
public class TopicosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String titulo;

    @Column
    private String mensaje;

    @Column
    private Boolean status;

    @Column
    private String autor;

    @Column
    private String curso;

    @Column
    private String respuestas;

    public TopicosEntity() {
    }

    public TopicosEntity(RecordTopico datosIngresado) {
        this.id = datosIngresado.id_topico();
        this.titulo = datosIngresado.titulo_topico();
        this.mensaje = datosIngresado.mensaje_topico();
        this.status = datosIngresado.status_topico();
        this.autor = datosIngresado.autor_topico();
        this.curso = datosIngresado.curso_topico();
        this.respuestas = datosIngresado.respuestas_topico();
    }

    public TopicosEntity(Integer id, String titulo, String mensaje, Boolean status, String autor, String curso, String respuestas) {
        this.id = id;
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.status = status;
        this.autor = autor;
        this.curso = curso;
        this.respuestas = respuestas;
    }


    public Integer getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public Boolean getStatus() {
        return status;
    }

    public String getAutor() {
        return autor;
    }

    public String getCurso() {
        return curso;
    }

    public String getRespuestas() {
        return respuestas;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setRespuestas(String respuestas) {
        this.respuestas = respuestas;
    }

    @Override
    public String toString() {
        return "TopicosEntity{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", mensaje=" + mensaje +
                ", status='" + status + '\'' +
                ", autor='" + autor + '\'' +
                ", curso='" + curso + '\'' +
                ", respuestas='" + respuestas + '\'' +
                '}';
    }
}
