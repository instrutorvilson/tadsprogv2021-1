/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import models.Contato;

@ManagedBean
@ViewScoped
public class BeanContato {

    private int idcontato;
    private String nome;
    private String fone;
    private String email;
    private String filtro;
    private List<Contato> lista = new ArrayList<>();

    public void consultarById(int id){
        Contato ct = new Contato();
        ct = ct.consultarById(id);
        idcontato = ct.getIdcontato();
        nome = ct.getNome();
        fone = ct.getFone();
        email = ct.getEmail();
    }
    
    public String redirectEditar(int id){
       return "editacontato.jsf?faces-redirect=true&idcontato="+id;      
    }
    
    public void consultar(){      
      lista = new Contato().consultar(nome);  
    }
    
    public int getIdcontato() {
        return idcontato;
    }

    public void setIdcontato(int idcontato) {
        this.idcontato = idcontato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
     public List<Contato> getLista() {
        return lista;
    }
     
    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }     

    public void salvar() {
        FacesContext view = FacesContext.getCurrentInstance();
        FacesMessage msg = null;

        if (nome.equals("")) {
            msg = new FacesMessage("Informe nome");
            view.addMessage(null, msg);
        }

        if (fone.equals("")) {
            msg = new FacesMessage("Informe fone");
            view.addMessage(null, msg);
        } 

        if (email.equals("")) {
            msg = new FacesMessage("Informe email");
            view.addMessage(null, msg);
        }

        if (msg == null) {
            Contato ct = new Contato(this.nome, this.fone, this.email);
            if (ct.salvar()) {
                msg = new FacesMessage("Contato salvo com sucesso");
                view.addMessage(null, msg);
            }
        }
    }  
    
     public void update() {
        FacesContext view = FacesContext.getCurrentInstance();
        FacesMessage msg = null;

        if (nome.equals("")) {
            msg = new FacesMessage("Informe nome");
            view.addMessage(null, msg);
        }

        if (fone.equals("")) {
            msg = new FacesMessage("Informe fone");
            view.addMessage(null, msg);
        } 

        if (email.equals("")) {
            msg = new FacesMessage("Informe email");
            view.addMessage(null, msg);
        }

        if (msg == null) {
            Contato ct = new Contato(this.idcontato, this.nome, this.fone, this.email);
            if (ct.update()) {
                msg = new FacesMessage("Contato salvo com sucesso");
                view.addMessage(null, msg);
            }
        }
    } 

}
