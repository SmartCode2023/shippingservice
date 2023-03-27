package dev.abel.springbootredis.domain;

import java.io.Serializable;

public class Envio implements Serializable{

    private String id;
    private String contratoId;
    private String tiempoInicio;
    private String tiempoFin;
    private String estado;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContractId() {
        return contratoId;
    }

    public void setContratoId(String contratoId) {
        this.contratoId = contratoId;
    }

    public String getTiempoInicio() {
        return tiempoInicio;
    }

    public void setTiempoInicio(String tiempoInicio) {
        this.tiempoInicio = tiempoInicio;
    }

    public String getTiempoFin() {
        return tiempoFin;
    }

    public void setTiempoFin(String tiempoFin) {
        this.tiempoFin = tiempoFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
