package com.alura.ForoHub.controller;

import com.alura.ForoHub.domain.topicos.dtos.RecordTopico;
import com.alura.ForoHub.domain.topicos.model.TopicosEntity;
import com.alura.ForoHub.domain.topicos.service.ServiceTopicos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    private final ServiceTopicos serviceTopicos;

    @Autowired
    public TopicoController(ServiceTopicos serviceTopicos) {
        this.serviceTopicos = serviceTopicos;
    }

    @GetMapping
    public List<TopicosEntity> ListarTopicos(){
        System.out.println(serviceTopicos.listarTopicos());
        return serviceTopicos.listarTopicos();
    }

    @PostMapping
    public TopicosEntity IngresarTopico(@RequestBody RecordTopico datosTopico){
        return serviceTopicos.insertarTopico(datosTopico);
    }

    @PatchMapping("/{id}")
    public TopicosEntity ActualizarTopico(@PathVariable Integer id,@RequestBody RecordTopico datosTopicoActualizar){
        return serviceTopicos.actualizarTopico(id,datosTopicoActualizar);
    }

    @DeleteMapping("/{id}")
    public void EliminarTopico(@PathVariable Integer id){
        serviceTopicos.eliminarTopico(id);
    }

}
