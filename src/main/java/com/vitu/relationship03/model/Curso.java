package com.vitu.relationship03.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cursos")
@Getter
@Setter
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    private String curso;

    //Um curso pode ter varios alunos
    //mappedBy -> o spring entende que e esse nosso 'alunos', ele nao vai gerar uma nova tabela, mas porque ? porque ja criamos la no alunos uma tabela pré definida que esta em nossa lista de 'cursos'
    //o nome e o mesmo da lista de cursos que esta em alunos
    @ManyToMany(mappedBy = "cursos")
    private List<Aluno> alunos = new ArrayList<>();
}
