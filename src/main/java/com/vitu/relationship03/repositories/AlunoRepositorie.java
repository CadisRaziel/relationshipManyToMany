package com.vitu.relationship03.repositories;

import com.vitu.relationship03.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepositorie extends JpaRepository<Aluno, Long> {
}
