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
@Table(name = "botao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Botao.findAll", query = "SELECT b FROM Botao b")
    , @NamedQuery(name = "Botao.findByIdbotao", query = "SELECT b FROM Botao b WHERE b.idbotao = :idbotao")
    , @NamedQuery(name = "Botao.findByNome", query = "SELECT b FROM Botao b WHERE b.nome = :nome")})
public class Botao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbotao")
    private Integer idbotao;
    @Column(name = "nome")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idbotao")
    private List<TelaBotao> telaBotaoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idbotao")
    private List<Permissao> permissaoList;

    public Botao() {
    }

    public Botao(Integer idbotao) {
        this.idbotao = idbotao;
    }

    public Integer getIdbotao() {
        return idbotao;
    }

    public void setIdbotao(Integer idbotao) {
        this.idbotao = idbotao;
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
        hash += (idbotao != null ? idbotao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Botao)) {
            return false;
        }
        Botao other = (Botao) object;
        if ((this.idbotao == null && other.idbotao != null) || (this.idbotao != null && !this.idbotao.equals(other.idbotao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Botao[ idbotao=" + idbotao + " ]";
    }
    
}
