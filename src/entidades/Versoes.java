/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author atendimento
 */
@Entity
@Table(name = "versoes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Versoes.findAll", query = "SELECT v FROM Versoes v")
    , @NamedQuery(name = "Versoes.findByIdversao", query = "SELECT v FROM Versoes v WHERE v.idversao = :idversao")
    , @NamedQuery(name = "Versoes.findByDescricao", query = "SELECT v FROM Versoes v WHERE v.descricao = :descricao")
    , @NamedQuery(name = "Versoes.findByData", query = "SELECT v FROM Versoes v WHERE v.data = :data")
    , @NamedQuery(name = "Versoes.findByVersao", query = "SELECT v FROM Versoes v WHERE v.versao = :versao")})
public class Versoes implements Serializable {

    @Column(name = "atual")
    private Integer atual;
    @Column(name = "lido")
    private Integer lido;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idversao")
    private Integer idversao;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Column(name = "versao")
    private String versao;

    public Versoes() {
    }

    public Versoes(Integer idversao) {
        this.idversao = idversao;
    }

    public Integer getIdversao() {
        return idversao;
    }

    public void setIdversao(Integer idversao) {
        this.idversao = idversao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idversao != null ? idversao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Versoes)) {
            return false;
        }
        Versoes other = (Versoes) object;
        if ((this.idversao == null && other.idversao != null) || (this.idversao != null && !this.idversao.equals(other.idversao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Versoes[ idversao=" + idversao + " ]";
    }

    public Integer getAtual() {
        return atual;
    }

    public void setAtual(Integer atual) {
        this.atual = atual;
    }

    public Integer getLido() {
        return lido;
    }

    public void setLido(Integer lido) {
        this.lido = lido;
    }
    
}
