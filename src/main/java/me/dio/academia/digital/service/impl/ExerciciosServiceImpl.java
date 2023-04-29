package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.Exercicios;
import me.dio.academia.digital.entity.form.ExerciciosForm;
import me.dio.academia.digital.entity.form.ExerciciosUpdateForm;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.ExerciciosRepository;
import me.dio.academia.digital.service.IExerciciosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciciosServiceImpl implements IExerciciosService {

    @Autowired
    private ExerciciosRepository exerciciosRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public Exercicios create(ExerciciosForm form) {
        Exercicios exercicios = new Exercicios();
        Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();

        exercicios.setAluno(aluno);
        exercicios.setExercicio(form.getExercicio());
        exercicios.setPeso(form.getPeso());
        exercicios.setSerie(form.getSerie());

        return exerciciosRepository.save(exercicios);
    }

    @Override
    public Exercicios get(Long id) {
        return null;
    }

    @Override
    public List<Exercicios> getAll() {

        return exerciciosRepository.findAll();
    }

    @Override
    public Exercicios update(Long id, ExerciciosUpdateForm formUpdate) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}