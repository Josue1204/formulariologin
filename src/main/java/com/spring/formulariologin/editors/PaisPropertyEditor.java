package com.spring.formulariologin.editors;

import com.spring.formulariologin.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

@Component
public class PaisPropertyEditor extends PropertyEditorSupport {

    @Autowired
    private PaisService service;

    public void setAsText(String idString) throws IllegalArgumentException{
        try{
            Integer id = Integer.parseInt(idString);
            this.setValue(service.obtenerPorId(id));

        }catch (NumberFormatException e){
            setValue(null);
 }}
}
