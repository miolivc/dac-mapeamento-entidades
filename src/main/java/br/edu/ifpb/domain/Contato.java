/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.domain;

import br.edu.ifpb.infra.LocalDateConverter;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Lob;

/**
 *
 * @author ifpb
 */

@Entity
@IdClass(ContatoPK.class)
public class Contato implements Serializable {
    
    @Id
    private String nome;
    @Id
    private String sobrenome;
    
    @Column(length = 15)
    private String apelido;
    
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String descricao;
    
    @ElementCollection
    private List<String> emails;
    
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] foto;
    
    @Convert(converter = LocalDateConverter.class)
    private LocalDate criadoEm;
    
    @ElementCollection
    private List<Telefone> telefones;

    {
        this.emails = new ArrayList<>();
        this.criadoEm = LocalDate.now();
        this.telefones = new ArrayList<>();
    }

    public Contato() {
    }

    public Contato(String nome, String sobrenome, String apelido, String descricao) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.apelido = apelido;
        this.descricao = descricao;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public LocalDate getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDate criadoEm) {
        this.criadoEm = criadoEm;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    @Override
    public String toString() {
        return "Contato{" + "nome=" + nome + ", sobrenome=" + sobrenome + 
                ", apelido=" + apelido + ", descricao=" + descricao + ", emails=" 
                + emails + ", criadoEm=" + criadoEm + ", telefones=" + telefones + '}';
    }
    
    
    
}
