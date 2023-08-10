package com.vitu.relationship03.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "alunos")
@Getter
@Setter
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    private String aluno;

    //Um aluno pode participar de varios cursos
    @ManyToMany
    //Se nao fizer o JoinTable abaixo o spring vai criar 2 tabela desnecessaria sendo que poderia ser uma igual faremos abaixo
    @JoinTable(
            //name -> nome tabela
            name = "tabela_auxiliar",

            //@JoinColumn(name = "aluno_id") -> nome da coluna que sera gerada na 'tabela_auxiliar'
            //referencedColumnName -> Qual caracteristica do meu modelo aluno eu to utilizando para gerar o codigo_aluno
            joinColumns = {@JoinColumn(name = "codigo_aluno", referencedColumnName = "codigo")},

            //inverseJoinColumns -> trabalhando com a chave primaria do meu modelo curso
            inverseJoinColumns = {@JoinColumn(name = "codigo_curso", referencedColumnName = "codigo")} //codigo -> o codigo aqui é la do model curso
    )
    private List<Curso> cursos = new ArrayList<>();
}
