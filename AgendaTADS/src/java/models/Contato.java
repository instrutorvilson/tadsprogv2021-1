/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.utils.Conexao;

public class Contato {

    private int idcontato;
    private String nome;
    private String fone;
    private String email;

    public Contato() {
    }

    public Contato(int idcontato, String nome, String fone, String email) {
        this.idcontato = idcontato;
        this.nome = nome;
        this.fone = fone;
        this.email = email;
    }

    public Contato(String nome, String fone, String email) {
        this.nome = nome;
        this.fone = fone;
        this.email = email;
    }
    
    public Contato consultarById(int id){
       ResultSet rs = null;
       Contato ct = null;
       try {
            String sql = "select * from contato"
                      + " where idcontato = ? ";
            Connection con = Conexao.conectar();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            if(rs.next()){
              ct = new Contato(
                      rs.getInt("idcontato"),
                      rs.getString("nome"),
                      rs.getString("fone"),
                      rs.getString("email"));
            }
            
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
       return ct;
    }
    
    public List<Contato> consultar(String filtro){
        ResultSet rs = null;
        List<Contato> lista = new ArrayList<>();
        try {
            String sql = "select * from contato"
                      + " where nome like '%"+filtro+"%'";
            Connection con = Conexao.conectar();
            PreparedStatement stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while(rs.next()){
              lista.add(new Contato(
                      rs.getInt("idcontato"),
                      rs.getString("nome"),
                      rs.getString("fone"),
                      rs.getString("email")));
            }
            
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return lista;
    }
    
    public boolean salvar(){
        try {
            String sql = "insert into contato(nome, fone, email)" +
                    "values(?,?,?)";
            Connection con = Conexao.conectar();
            PreparedStatement stm = con.prepareStatement(sql); 
            stm.setString(1, this.nome);
            stm.setString(2, this.fone);
            stm.setString(3, this.email);
            stm.execute();
            
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return true;
    }

    public boolean update(){
        try {
            String sql = "update contato set "
                     + " nome = ?, "
                     + " fone = ?, "
                     + " email = ? " 
                     + " where idcontato = ?";
            Connection con = Conexao.conectar();
            PreparedStatement stm = con.prepareStatement(sql); 
            stm.setString(1, this.nome);
            stm.setString(2, this.fone);
            stm.setString(3, this.email);
            stm.setInt(4, this.idcontato);
            stm.execute();
            
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return true;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    
}
