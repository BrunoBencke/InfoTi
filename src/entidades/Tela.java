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
 * @author atendimento
 */
@Entity
@Table(name = "tela")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tela.findAll", query = "SELECT t FROM Tela t")
    , @NamedQuery(name = "Tela.findByIdtela", query = "SELECT t FROM Tela t WHERE t.idtela = :idtela")
    , @NamedQuery(name = "Tela.findByNome", query = "SELECT t FROM Tela t WHERE t.nome = :nome")})
public class Tela implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtela")
    private Integer idtela;
    @Column(name = "nome")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtela")
    private List<TelaBotao> telaBotaoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtela")
    private List<Permissao> permissaoList;

    public Tela() {
    }

    public Tela(Integer idtela) {
        this.idtela = idtela;
    }

    public Integer getIdtela() {
        return idtela;
    }

    public void setIdtela(Integer idtela) {
        this.idtela = idtela;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public List<TelaBotao> getTelaBotaoList() {
        return telaBotaoList;
    }

    public void setTelaBotaoList(List<TelaBotao> telaBotaoList) {
        this.telaBotaoList = telaBotaoList;
    }

    @XmlTransient
    public List<Permissao> getPermissaoList() {
        return permissaoList;
    }

    public void setPermissaoList(List<Permissao> permissaoList) {
        this.permissaoList = permissaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtela != null ? idtela.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tela)) {
            return false;
        }
        Tela other = (Tela) object;
        if ((this.idtela == null && other.idtela != null) || (this.idtela != null && !this.idtela.equals(other.idtela))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Tela[ idtela=" + idtela + " ]";
    }
    
}
