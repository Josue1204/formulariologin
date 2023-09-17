package com.spring.formulariologin.service;

import com.spring.formulariologin.models.domain.Pais;

import java.util.List;

public interface PaisService {
    public List<Pais> listar();
    public Pais obtenerPorId(Integer id);

}
