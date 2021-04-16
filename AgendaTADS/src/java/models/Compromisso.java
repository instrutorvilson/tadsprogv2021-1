/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;

/**
 *
 * @author vilso
 */
public class Compromisso {
    private int idcompromisso;
    private Date data;
    private String local;
    private int idcontato;

    public Compromisso() {
    }

    public Compromisso(int idcompromisso, Date data, String local, int idcontato) {
        this.idcompromisso = idcompromisso;
        this.data = data;
        this.local = local;
        this.idcontato = idcontato;
    }

    public int getIdcontato() {
        return idcontato;
    }

    public void setIdcontato(int idcontato) {
        this.idcontato = idcontato;
    }

    public int getIdcompromisso() {
        return idcompromisso;
    }

    public void setIdcompromisso(int idcompromisso) {
        this.idcompromisso = idcompromisso;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
    
    
    
}
