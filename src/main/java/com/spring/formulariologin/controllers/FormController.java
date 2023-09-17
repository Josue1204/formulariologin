package com.spring.formulariologin.controllers;

import com.spring.formulariologin.editors.NombreMayusculaEditor;
import com.spring.formulariologin.editors.PaisPropertyEditor;
import com.spring.formulariologin.editors.RolesEditor;
import com.spring.formulariologin.models.domain.Pais;
import com.spring.formulariologin.models.domain.Role;
import com.spring.formulariologin.models.domain.Usuario;
import com.spring.formulariologin.service.PaisService;
import com.spring.formulariologin.service.RoleService;
import com.spring.formulariologin.validation.UsuarioValidador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@SessionAttributes("usuario")

public class FormController {
    @Autowired
    private UsuarioValidador validador;
    @Autowired
    private PaisService paisService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PaisPropertyEditor paisEditor;
    @Autowired
    private RolesEditor rolesEditor;
    @InitBinder
    public  void InitBinder (WebDataBinder binder){
        binder.addValidators(validador);
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class,"fechaNacimiento",new CustomDateEditor(dateFormat,true));
        binder.registerCustomEditor(String.class,"nombre", new NombreMayusculaEditor());
        binder.registerCustomEditor(String.class,"apellido",new NombreMayusculaEditor());

        binder.registerCustomEditor(Pais.class,"pais",paisEditor);
        binder.registerCustomEditor(Role.class,"roles",rolesEditor);
    }
    @ModelAttribute("genero")
    public List<String>genero(){
        return Arrays.asList("Hombre","Mujer");
    }
    @ModelAttribute("listaRoles")
    public List<Role>listaRoles(){
        return this.roleService.listar();
    }
    @ModelAttribute
    public List<Pais>listaPaises(){
        return paisService.listar();
    }
    @ModelAttribute("listaRolesString")
    public List<String>listaRolesString(){
        List<String>roles= new ArrayList<>();
        roles.add("ROLE_ADMIN");
        roles.add("ROLE_USER");
        roles.add("ROLE_MODERADOR");
        return roles;
    }
@ModelAttribute("listaRolesMap")
    public Map<String,String >listaRolesMap(){
        Map<String,String>roles=new HashMap<>();
        roles.put("ROLES_ADMIN","Administrador");
        roles.put("ROLE_USER","Usuario");
        roles.put("ROLE_MODERADOR","Moderador");
        return roles;
}
@ModelAttribute("paises")
    public List<String>paises(){
        return Arrays.asList("España","Mexico","Chile","Argentina","Peru","Colombia","Venezuela");
}

@ModelAttribute("paisesMap")
    public Map<String,String>paisesMap(){
        Map<String,String>paises=new HashMap<>();
        paises.put("ES","España");
        paises.put("MX","Mexico");
        paises.put("CL","Chile");
    paises.put("AR","Argentina");
    paises.put("PE","Peru");
    paises.put("CO","Colombia");
    paises.put("VE","Venezuela");
    return paises;

}
@GetMapping("/form")
    public String form (Model model){
    Usuario usuario=new Usuario();
    usuario.setNombre("John");
    usuario.setApellido("Doe");
    usuario.setIdentificador("123.456.789-k");
    usuario.setHabilitar(true);
    usuario.setValorSecreto("Algun valor secreto***");
}

}

