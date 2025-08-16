package com.alura.ForoHub.domain.topicos.service;

import com.alura.ForoHub.domain.topicos.dtos.RecordTopico;
import com.alura.ForoHub.domain.topicos.model.TopicosEntity;
import com.alura.ForoHub.domain.topicos.repository.TopicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServiceTopicos {

    @Autowired
    private final TopicosRepository repository;


    public ServiceTopicos(TopicosRepository repository) {
        this.repository = repository;
    }

    public List<TopicosEntity> listarTopicos(){
        return repository.findAll();
    }

    @Transactional
    public TopicosEntity insertarTopico(RecordTopico datosIngresado){
        //System.out.println("depurando: "+datosIngresado);
        return repository.save(new TopicosEntity(datosIngresado));
    }

    @Transactional
    public TopicosEntity actualizarTopico(Integer idIngresado,RecordTopico datosIngresadoActualizar){
        var datos = repository.findById(idIngresado)
                .orElseThrow(()-> new IllegalArgumentException("Topico no encontrado"));

        if (datosIngresadoActualizar.titulo_topico()!=null){
            datos.setTitulo(datosIngresadoActualizar.titulo_topico());
        }
        if (datosIngresadoActualizar.mensaje_topico()!=null){
            datos.setMensaje(datosIngresadoActualizar.mensaje_topico());
        }
        if (datosIngresadoActualizar.status_topico()!=null){
            datos.setStatus(datosIngresadoActualizar.status_topico());
        }
        if (datosIngresadoActualizar.autor_topico()!=null){
            datos.setAutor(datosIngresadoActualizar.autor_topico());
        }
        if (datosIngresadoActualizar.curso_topico()!=null){
            datos.setCurso(datosIngresadoActualizar.curso_topico());
        }
        if (datosIngresadoActualizar.respuestas_topico()!=null){
            datos.setRespuestas(datosIngresadoActualizar.respuestas_topico());
        }

        return datos;
    }

    @Transactional
    public void eliminarTopico(Integer idIngresado){

        if (idIngresado==null){
            throw new RuntimeException("Topico no encontrado");
        }

        repository.deleteById(idIngresado);
    }
    
}
