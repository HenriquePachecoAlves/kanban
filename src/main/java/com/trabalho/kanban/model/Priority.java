package com.trabalho.kanban.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Priority {
    HIGH("alta"),
    MEDIUM("média"),
    LOW("baixa");

    private final String descricao;

    Priority(String descricao) {
        this.descricao = descricao;
    }

    @JsonValue
    public String getDescricao() {
        return descricao;
    }

    @JsonCreator
    public static Priority fromDescricao(String descricao) {
        for (Priority priority : Priority.values()) {
            if (priority.descricao.equalsIgnoreCase(descricao)) {
                return priority;
            }
        }
        throw new IllegalArgumentException("Valor inválido para Priority: " + descricao);
    }
}
