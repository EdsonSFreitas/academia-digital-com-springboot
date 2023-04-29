package me.dio.academia.digital.repository;

import me.dio.academia.digital.entity.Exercicios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciciosRepository extends JpaRepository<Exercicios, Long> {

}