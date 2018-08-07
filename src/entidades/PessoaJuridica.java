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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bruno.bencke
 */
@Entity
@Table(name = "pessoa_juridica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PessoaJuridica.findAll", query = "SELECT p FROM PessoaJuridica p")
    , @NamedQuery(name = "PessoaJuridica.findByIdpessoaJuridica", query = "SELECT p FROM PessoaJuridica p WHERE p.idpessoaJuridica = :idpessoaJuridica")
    , @NamedQuery(name = "PessoaJuridica.findByCnpj", query = "SELECT p FROM PessoaJuridica p WHERE p.cnpj = :cnpj")
    , @NamedQuery(name = "PessoaJuridica.findByRazaoSocial", query = "SELECT p FROM PessoaJuridica p WHERE p.razaoSocial = :razaoSocial")
    , @NamedQuery(name = "PessoaJuridica.findByDataAbertura", query = "SELECT p FROM PessoaJuridica p WHERE p.dataAbertura = :dataAbertura")
    , @NamedQuery(name = "PessoaJuridica.findByInscricaoEstadual", query = "SELECT p FROM PessoaJuridica p WHERE p.inscricaoEstadual = :inscricaoEstadual")})
public class PessoaJuridica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpessoa_juridica")
    private Integer idpessoaJuridica;
    @Basic(optional = false)
    @Column(name = "cnpj")
    private String cnpj;
    @Basic(optional = false)
    @Column(name = "razao_social")
    private String razaoSocial;
    @Basic(optional = false)
    @Column(name = "data_abertura")
    @Temporal(TemporalType.DATE)
    private Date dataAbertura;
    @Column(name = "inscricao_estadual")
    private String inscricaoEstadual;
    @JoinColumn(name = "idcliente", referencedColumnName = "idcliente")
    @ManyToOne(optional = false)
    private Cliente idcliente;

    public PessoaJuridica() {
    }

    public PessoaJuridica(Integer idpessoaJuridica) {
        this.idpessoaJuridica = idpessoaJuridica;
    }

    public PessoaJuridica(Integer idpessoaJuridica, String cnpj, String razaoSocial, Date dataAbertura) {
        this.idpessoaJuridica = idpessoaJuridica;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.dataAbertura = dataAbertura;
    }

    public Integer getIdpessoaJuridica() {
        return idpessoaJuridica;
    }

    public void setIdpessoaJuridica(Integer idpessoaJuridica) {
        this.idpessoaJuridica = idpessoaJuridica;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public Cliente getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Cliente idcliente) {
        this.idcliente = idcliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpessoaJuridica != null ? idpessoaJuridica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PessoaJuridica)) {
            return false;
        }
        PessoaJuridica other = (PessoaJuridica) object;
        if ((this.idpessoaJuridica == null && other.idpessoaJuridica != null) || (this.idpessoaJuridica != null && !this.idpessoaJuridica.equals(other.idpessoaJuridica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.PessoaJuridica[ idpessoaJuridica=" + idpessoaJuridica + " ]";
    }
    
}
