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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tela_botao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TelaBotao.findAll", query = "SELECT t FROM TelaBotao t")
    , @NamedQuery(name = "TelaBotao.findByIdtelabotao", query = "SELECT t FROM TelaBotao t WHERE t.idtelabotao = :idtelabotao")})
public class TelaBotao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtelabotao")
    private Integer idtelabotao;
    @JoinColumn(name = "idbotao", referencedColumnName = "idbotao")
    @ManyToOne(optional = false)
    private Botao idbotao;
    @JoinColumn(name = "idtela", referencedColumnName = "idtela")
    @ManyToOne(optional = false)
    private Tela idtela;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtelabotao")
    private List<Permissao> permissaoList;

    public TelaBotao() {
    }

    public TelaBotao(Integer idtelabotao) {
        this.idtelabotao = idtelabotao;
    }

    public Integer getIdtelabotao() {
        return idtelabotao;
    }

    public void setIdtelabotao(Integer idtelabotao) {
        this.idtelabotao = idtelabotao;
    }

    public Botao getIdbotao() {
        return idbotao;
    }

    public void setIdbotao(Botao idbotao) {
        this.idbotao = idbotao;
    }

    public Tela getIdtela() {
        return idtela;
    }

    public void setIdtela(Tela idtela) {
        this.idtela = idtela;
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
        hash += (idtelabotao != null ? idtelabotao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TelaBotao)) {
            return false;
        }
        TelaBotao other = (TelaBotao) object;
        if ((this.idtelabotao == null && other.idtelabotao != null) || (this.idtelabotao != null && !this.idtelabotao.equals(other.idtelabotao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TelaBotao[ idtelabotao=" + idtelabotao + " ]";
    }
    
}
