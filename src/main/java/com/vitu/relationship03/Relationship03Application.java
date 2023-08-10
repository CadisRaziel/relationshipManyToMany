package com.vitu.relationship03;

import com.vitu.relationship03.model.Aluno;
import com.vitu.relationship03.model.Curso;
import com.vitu.relationship03.repositories.AlunoRepositorie;
import com.vitu.relationship03.repositories.CursoRepositorie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class Relationship03Application {
    ///link treinamento
    ///https://ralflima.com/treinamentos/relacionamento_entre_entidades/spring_modulo3_introducao.php

    public static void main(String[] args) {
        SpringApplication.run(Relationship03Application.class, args);
    }


    ///Testando o relacionamento
    @Bean
    public CommandLineRunner mappingDemo(AlunoRepositorie ar, CursoRepositorie cr) {
        return args -> {

            // Criar um aluno
            Aluno aluno = new Aluno();
            aluno.setAluno("Vitor");

            // Cadastrar na tabela alunos
            ar.save(aluno);

            // Criar três cursos
            Curso c1 = new Curso();
            c1.setCurso("Java - Spring Boot");

            Curso c2 = new Curso();
            c2.setCurso("Python - Flask");

            Curso c3 = new Curso();
            c3.setCurso("PHP - Laravel");

            // Cadastrar os cursos na tabela cursos
            cr.saveAll(Arrays.asList(c1, c2, c3));

            // Adicionar os primeiro e o terceiro curso no aluno
            aluno.getCursos().addAll(Arrays.asList(c1, c3));

            // Atualizar a lista de cursos do aluno
            ar.save(aluno);
        };
    }


}
