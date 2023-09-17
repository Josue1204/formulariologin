package com.spring.formulariologin.editors;

import com.spring.formulariologin.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

@Component
public class RolesEditor extends PropertyEditorSupport {

    @Autowired
    private RoleService service;

    public void setAsText(String text) throws IllegalArgumentException{
        try{
            Integer id = Integer.parseInt(text);
            setValue(service.obtenerPorId(id));

        }catch (NumberFormatException e){
            setValue(null);
 }}
}
