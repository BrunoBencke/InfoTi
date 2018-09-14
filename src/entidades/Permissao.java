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
 * @author atendimento
 */
@Entity
@Table(name = "permissao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permissao.findAll", query = "SELECT p FROM Permissao p")
    , @NamedQuery(name = "Permissao.findByIdpermissao", query = "SELECT p FROM Permissao p WHERE p.idpermissao = :idpermissao")
    , @NamedQuery(name = "Permissao.findBySituacao", query = "SELECT p FROM Permissao p WHERE p.situacao = :situacao")})
public class Permissao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpermissao")
    private Integer idpermissao;
    @Basic(optional = false)
    @Column(name = "situacao")
    private boolean situacao;
    @JoinColumn(name = "idbotao", referencedColumnName = "idbotao")
    @ManyToOne(optional = false)
    private Botao idbotao;
    @JoinColumn(name = "idtela", referencedColumnName = "idtela")
    @ManyToOne(optional = false)
    private Tela idtela;
    @JoinColumn(name = "idtelabotao", referencedColumnName = "idtelabotao")
    @ManyToOne(optional = false)
    private TelaBotao idtelabotao;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idusuario;

    public Permissao() {
    }

    public Permissao(Integer idpermissao) {
        this.idpermissao = idpermissao;
    }

    public Permissao(Integer idpermissao, boolean situacao) {
        this.idpermissao = idpermissao;
        this.situacao = situacao;
    }

    public Integer getIdpermissao() {
        return idpermissao;
    }

    public void setIdpermissao(Integer idpermissao) {
        this.idpermissao = idpermissao;
    }

    public boolean getSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
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

    public TelaBotao getIdtelabotao() {
        return idtelabotao;
    }

    public void setIdtelabotao(TelaBotao idtelabotao) {
        this.idtelabotao = idtelabotao;
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
        hash += (idpermissao != null ? idpermissao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permissao)) {
            return false;
        }
        Permissao other = (Permissao) object;
        if ((this.idpermissao == null && other.idpermissao != null) || (this.idpermissao != null && !this.idpermissao.equals(other.idpermissao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Permissao[ idpermissao=" + idpermissao + " ]";
    }
    
}
