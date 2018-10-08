/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bruno.bencke
 */
@Entity
@Table(name = "auditoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Auditoria.findAll", query = "SELECT a FROM Auditoria a")
    , @NamedQuery(name = "Auditoria.findByIdauditoria", query = "SELECT a FROM Auditoria a WHERE a.idauditoria = :idauditoria")
    , @NamedQuery(name = "Auditoria.findByData", query = "SELECT a FROM Auditoria a WHERE a.data = :data")
    , @NamedQuery(name = "Auditoria.findByHora", query = "SELECT a FROM Auditoria a WHERE a.hora = :hora")
    , @NamedQuery(name = "Auditoria.findByDadoAnterior", query = "SELECT a FROM Auditoria a WHERE a.dadoAnterior = :dadoAnterior")
    , @NamedQuery(name = "Auditoria.findByDadoNovo", query = "SELECT a FROM Auditoria a WHERE a.dadoNovo = :dadoNovo")
    , @NamedQuery(name = "Auditoria.findByOperacao", query = "SELECT a FROM Auditoria a WHERE a.operacao = :operacao")})
public class Auditoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idauditoria")
    private Integer idauditoria;
    @Column(name = "data")
    private String data;
    @Column(name = "hora")
    private String hora;
    @Column(name = "dado_anterior")
    private String dadoAnterior;
    @Column(name = "dado_novo")
    private String dadoNovo;
    @Column(name = "operacao")
    private String operacao;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idusuario;

    public Auditoria() {
    }

    public Auditoria(Integer idauditoria) {
        this.idauditoria = idauditoria;
    }

    public Integer getIdauditoria() {
        return idauditoria;
    }

    public void setIdauditoria(Integer idauditoria) {
        this.idauditoria = idauditoria;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDadoAnterior() {
        return dadoAnterior;
    }

    public void setDadoAnterior(String dadoAnterior) {
        this.dadoAnterior = dadoAnterior;
    }

    public String getDadoNovo() {
        return dadoNovo;
    }

    public void setDadoNovo(String dadoNovo) {
        this.dadoNovo = dadoNovo;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idauditoria != null ? idauditoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auditoria)) {
            return false;
        }
        Auditoria other = (Auditoria) object;
        if ((this.idauditoria == null && other.idauditoria != null) || (this.idauditoria != null && !this.idauditoria.equals(other.idauditoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Auditoria[ idauditoria=" + idauditoria + " ]";
    }
    
}
