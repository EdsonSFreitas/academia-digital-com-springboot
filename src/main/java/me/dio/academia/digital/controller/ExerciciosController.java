package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.Exercicios;
import me.dio.academia.digital.entity.form.ExerciciosForm;
import me.dio.academia.digital.service.impl.ExerciciosServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercicios")
public class ExerciciosController {

    @Autowired
    private ExerciciosServiceImpl service;

    @PostMapping
    public Exercicios create(@RequestBody ExerciciosForm form) {
        return service.create(form);
    }

    @GetMapping
    public List<Exercicios> getAll() {
        return service.getAll();
    }

}