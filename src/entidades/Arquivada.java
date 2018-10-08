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
@Table(name = "arquivada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Arquivada.findAll", query = "SELECT a FROM Arquivada a")
    , @NamedQuery(name = "Arquivada.findByIdarquivada", query = "SELECT a FROM Arquivada a WHERE a.idarquivada = :idarquivada")
    , @NamedQuery(name = "Arquivada.findByIdauditoria", query = "SELECT a FROM Arquivada a WHERE a.idauditoria = :idauditoria")
    , @NamedQuery(name = "Arquivada.findByData", query = "SELECT a FROM Arquivada a WHERE a.data = :data")
    , @NamedQuery(name = "Arquivada.findByHora", query = "SELECT a FROM Arquivada a WHERE a.hora = :hora")
    , @NamedQuery(name = "Arquivada.findByDadoAnterior", query = "SELECT a FROM Arquivada a WHERE a.dadoAnterior = :dadoAnterior")
    , @NamedQuery(name = "Arquivada.findByDadoNovo", query = "SELECT a FROM Arquivada a WHERE a.dadoNovo = :dadoNovo")
    , @NamedQuery(name = "Arquivada.findByOperacao", query = "SELECT a FROM Arquivada a WHERE a.operacao = :operacao")})
public class Arquivada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idarquivada")
    private Integer idarquivada;
    @Basic(optional = false)
    @Column(name = "idauditoria")
    private int idauditoria;
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

    public Arquivada() {
    }

    public Arquivada(Integer idarquivada) {
        this.idarquivada = idarquivada;
    }

    public Arquivada(Integer idarquivada, int idauditoria) {
        this.idarquivada = idarquivada;
        this.idauditoria = idauditoria;
    }

    public Integer getIdarquivada() {
        return idarquivada;
    }

    public void setIdarquivada(Integer idarquivada) {
        this.idarquivada = idarquivada;
    }

    public int getIdauditoria() {
        return idauditoria;
    }

    public void setIdauditoria(int idauditoria) {
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
        hash += (idarquivada != null ? idarquivada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Arquivada)) {
            return false;
        }
        Arquivada other = (Arquivada) object;
        if ((this.idarquivada == null && other.idarquivada != null) || (this.idarquivada != null && !this.idarquivada.equals(other.idarquivada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Arquivada[ idarquivada=" + idarquivada + " ]";
    }
    
}
