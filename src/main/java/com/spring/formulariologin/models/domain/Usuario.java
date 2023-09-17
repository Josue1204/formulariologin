package com.spring.formulariologin.models.domain;

import com.spring.formulariologin.validation.IdentificadorRegex;
import com.spring.formulariologin.validation.Requerido;
import jakarta.validation.constraints.*;

import java.util.Date;
import java.util.List;

public class Usuario {
  @IdentificadorRegex
    private String identificador;
    private String nombre;
    @Requerido
  private String apellido;
    @NotBlank
  @Size(min = 3,max = 8)
  private String username;
    @NotEmpty
  private String password;
    @Requerido
  @Email(message = "correo con formato incorrecto")
  private String email;
    @NotNull
    @Min(5)
    @Max(5000)
    private Integer cuenta;
    @NotNull
  @Past
  private Date fechaNacimiento;
    @NotNull
  private Pais pais;
    @NotEmpty
  private List<Role>roles;

  private boolean habilitar;
  @NotEmpty
  private String genero;
  private String valorSecreto;

  public String getIdentificador() {
    return identificador;
  }

  public void setIdentificador(String identificador) {
    this.identificador = identificador;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Integer getCuenta() {
    return cuenta;
  }

  public void setCuenta(Integer cuenta) {
    this.cuenta = cuenta;
  }

  public Date getFechaNacimiento() {
    return fechaNacimiento;
  }

  public void setFechaNacimiento(Date fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }

  public Pais getPais() {
    return pais;
  }

  public void setPais(Pais pais) {
    this.pais = pais;
  }

  public List<Role> getRoles() {
    return roles;
  }

  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }

  public boolean isHabilitar() {
    return habilitar;
  }

  public void setHabilitar(boolean habilitar) {
    this.habilitar = habilitar;
  }

  public String getGenero() {
    return genero;
  }

  public void setGenero(String genero) {
    this.genero = genero;
  }

  public String getValorSecreto() {
    return valorSecreto;
  }

  public void setValorSecreto(String valorSecreto) {
    this.valorSecreto = valorSecreto;
  }

}
