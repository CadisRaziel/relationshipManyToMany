package com.vitu.relationship03.repositories;

import com.vitu.relationship03.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepositorie extends JpaRepository<Curso, Long> {
}
