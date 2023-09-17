package com.spring.formulariologin.service;

import com.spring.formulariologin.models.domain.Role;

import java.util.List;

public interface RoleService {
public List<Role> listar();
public Role obtenerPorId(Integer id);

}
