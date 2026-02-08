package com.activosseguridad.activos_seguridad.model;

import jakarta.persistence.*;

@Entity
@Table(name = "activos")
public class activos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "version_port", nullable = false)
    private String version_port;

    @Column(name = "nivel_riesgo", nullable = false)
    private String nivel_riesgo;

    @Column(name = "code_cve", nullable = false)
    private String code_cve;

    @Column(name = "recomendacion", nullable = false)
    private String recomendacion;

    @Column(name = "descripcion", nullable = true)
    private String descripcion;

    public activos() {}

    public activos(String nombre, String version_port, String nivel_riesgo, String code_cve, String recomendacion, String descripcion) {
        this.nombre = nombre;
        this.version_port = version_port;
        this.nivel_riesgo = nivel_riesgo;
        this.code_cve = code_cve;
        this.recomendacion = recomendacion;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }   
    public void setId(Long id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getVersion_port() {
        return version_port;
    }
    public void setVersion_port(String version_port) {
        this.version_port = version_port;
    }


    public String getNivel_riesgo() {
        return nivel_riesgo;
    }
    public void setNivel_riesgo(String nivel_riesgo) {
        this.nivel_riesgo = nivel_riesgo;
    }


    public String getCode_cve() {
        return code_cve;
    }
    public void setCode_cve(String code_cve) {
        this.code_cve = code_cve;
    }


    public String getRecomendacion() {
        return recomendacion;
    }
    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }


    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
