package com.alura.ForoHub.domain.topicos.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;

public record RecordTopico(
        @JsonProperty("id") Integer id_topico,

        @JsonProperty("titulo") String titulo_topico,

        @JsonProperty("mensaje") String mensaje_topico,

        @JsonProperty("status") Boolean status_topico,

        @JsonProperty("autor") String autor_topico,

        @JsonProperty("curso") String curso_topico,

        @JsonProperty("respuestas") String respuestas_topico
) {
}
