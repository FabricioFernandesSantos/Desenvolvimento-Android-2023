package com.fstech.applistacurso.controller;

import com.fstech.applistacurso.model.Curso;

import java.util.ArrayList;
import java.util.List;

public class CursoController {

    public List listCursos;

    public List getListaDeCursos(){

        listCursos = new ArrayList<Curso>();


        listCursos.add(new Curso());
        listCursos.add(new Curso());
        listCursos.add(new Curso());
        listCursos.add(new Curso());
        listCursos.add(new Curso());
        listCursos.add(new Curso());

        return listCursos;


    }
}
