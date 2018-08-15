/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author atendimento
 */
@Entity
@Table(name = "pessoa_fisica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PessoaFisica.findAll", query = "SELECT p FROM PessoaFisica p")
    , @NamedQuery(name = "PessoaFisica.findByIdpessoaFisica", query = "SELECT p FROM PessoaFisica p WHERE p.idpessoaFisica = :idpessoaFisica")
    , @NamedQuery(name = "PessoaFisica.findByRg", query = "SELECT p FROM PessoaFisica p WHERE p.rg = :rg")
    , @NamedQuery(name = "PessoaFisica.findByCpf", query = "SELECT p FROM PessoaFisica p WHERE p.cpf = :cpf")
    , @NamedQuery(name = "PessoaFisica.findByDataNascimento", query = "SELECT p FROM PessoaFisica p WHERE p.dataNascimento = :dataNascimento")})
public class PessoaFisica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpessoa_fisica")
    private Integer idpessoaFisica;
    @Basic(optional = false)
    @Column(name = "rg")
    private String rg;
    @Basic(optional = false)
    @Column(name = "cpf")
    private String cpf;
    @Basic(optional = false)
    @Column(name = "data_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @JoinColumn(name = "idcliente", referencedColumnName = "idcliente")
    @ManyToOne(optional = false)
    private Cliente idcliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpessoaFisica")
    private List<Funcionario> funcionarioList;

    public PessoaFisica() {
    }

    public PessoaFisica(Integer idpessoaFisica) {
        this.idpessoaFisica = idpessoaFisica;
    }

    public PessoaFisica(Integer idpessoaFisica, String rg, String cpf, Date dataNascimento) {
        this.idpessoaFisica = idpessoaFisica;
        this.rg = rg;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public Integer getIdpessoaFisica() {
        return idpessoaFisica;
    }

    public void setIdpessoaFisica(Integer idpessoaFisica) {
        this.idpessoaFisica = idpessoaFisica;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Cliente getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Cliente idcliente) {
        this.idcliente = idcliente;
    }

    @XmlTransient
    public List<Funcionario> getFuncionarioList() {
        return funcionarioList;
    }

    public void setFuncionarioList(List<Funcionario> funcionarioList) {
        this.funcionarioList = funcionarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpessoaFisica != null ? idpessoaFisica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PessoaFisica)) {
            return false;
        }
        PessoaFisica other = (PessoaFisica) object;
        if ((this.idpessoaFisica == null && other.idpessoaFisica != null) || (this.idpessoaFisica != null && !this.idpessoaFisica.equals(other.idpessoaFisica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.PessoaFisica[ idpessoaFisica=" + idpessoaFisica + " ]";
    }
    
}
