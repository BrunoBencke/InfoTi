/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author bruno.bencke
 */
@Entity
@Table(name = "regiao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Regiao.findAll", query = "SELECT r FROM Regiao r")
    , @NamedQuery(name = "Regiao.findByIdregiao", query = "SELECT r FROM Regiao r WHERE r.idregiao = :idregiao")
    , @NamedQuery(name = "Regiao.findByNome", query = "SELECT r FROM Regiao r WHERE r.nome = :nome")})
public class Regiao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idregiao")
    private Integer idregiao;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idregiao")
    private List<Estado> estadoList;

    public Regiao() {
    }

    public Regiao(Integer idregiao) {
        this.idregiao = idregiao;
    }

    public Regiao(Integer idregiao, String nome) {
        this.idregiao = idregiao;
        this.nome = nome;
    }

    public Integer getIdregiao() {
        return idregiao;
    }

    public void setIdregiao(Integer idregiao) {
        this.idregiao = idregiao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public List<Estado> getEstadoList() {
        return estadoList;
    }

    public void setEstadoList(List<Estado> estadoList) {
        this.estadoList = estadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idregiao != null ? idregiao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Regiao)) {
            return false;
        }
        Regiao other = (Regiao) object;
        if ((this.idregiao == null && other.idregiao != null) || (this.idregiao != null && !this.idregiao.equals(other.idregiao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Regiao[ idregiao=" + idregiao + " ]";
    }
    
}
