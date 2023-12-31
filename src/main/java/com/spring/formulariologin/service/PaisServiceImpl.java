package com.spring.formulariologin.service;

import com.spring.formulariologin.models.domain.Pais;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PaisServiceImpl implements PaisService {
    private List<Pais> listar;

    public PaisServiceImpl() {
        this.listar = Arrays.asList(
                new Pais(1, "ES", "España"),
                new Pais(2, "MX", "Mexico"),
                new Pais(3, "EQ", "Ecuador"),
                new Pais(4, "AR", "Argentina"),
                new Pais(5, "BR", "Brazil"),
                new Pais(6, "CL", "Colombia"),
                new Pais(7, "EU", "Estados Unidos")
        );

    }


    @Override
    public List<Pais> listar() {
        return listar;
    }

    @Override
    public Pais obtenerPorId(Integer id) {
        Pais resultado = null;
        for (Pais pais : this.listar()) {
            if (id == pais.getId()) {
                resultado = pais;
                break;
            }
        }

        return resultado;
    }
}