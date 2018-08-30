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
@Table(name = "funcionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f")
    , @NamedQuery(name = "Funcionario.findByIdfuncionario", query = "SELECT f FROM Funcionario f WHERE f.idfuncionario = :idfuncionario")
    , @NamedQuery(name = "Funcionario.findByCtps", query = "SELECT f FROM Funcionario f WHERE f.ctps = :ctps")
    , @NamedQuery(name = "Funcionario.findByPis", query = "SELECT f FROM Funcionario f WHERE f.pis = :pis")
    , @NamedQuery(name = "Funcionario.findBySalario", query = "SELECT f FROM Funcionario f WHERE f.salario = :salario")
    , @NamedQuery(name = "Funcionario.findByCargo", query = "SELECT f FROM Funcionario f WHERE f.cargo = :cargo")
    , @NamedQuery(name = "Funcionario.findByIdusuario", query = "SELECT f FROM Funcionario f WHERE f.idusuario = :idusuario")})
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfuncionario")
    private Integer idfuncionario;
    @Basic(optional = false)
    @Column(name = "ctps")
    private String ctps;
    @Basic(optional = false)
    @Column(name = "pis")
    private String pis;
    @Basic(optional = false)
    @Column(name = "salario")
    @Temporal(TemporalType.DATE)
    private Date salario;
    @Basic(optional = false)
    @Column(name = "cargo")
    private String cargo;
    @Basic(optional = false)
    @Column(name = "idusuario")
    private int idusuario;
    @JoinColumn(name = "idpessoa_fisica", referencedColumnName = "idpessoa_fisica")
    @ManyToOne(optional = false)
    private PessoaFisica idpessoaFisica;

    public Funcionario() {
    }

    public Funcionario(Integer idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public Funcionario(Integer idfuncionario, String ctps, String pis, Date salario, String cargo, int idusuario) {
        this.idfuncionario = idfuncionario;
        this.ctps = ctps;
        this.pis = pis;
        this.salario = salario;
        this.cargo = cargo;
        this.idusuario = idusuario;
    }

    public Integer getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(Integer idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }

    public Date getSalario() {
        return salario;
    }

    public void setSalario(Date salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public PessoaFisica getIdpessoaFisica() {
        return idpessoaFisica;
    }

    public void setIdpessoaFisica(PessoaFisica idpessoaFisica) {
        this.idpessoaFisica = idpessoaFisica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfuncionario != null ? idfuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.idfuncionario == null && other.idfuncionario != null) || (this.idfuncionario != null && !this.idfuncionario.equals(other.idfuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Id Funcionário:"+idfuncionario+" Ctps:"+ctps+" Pis:"+pis+" Salário:"+salario+" Cargo:"+cargo+" Id PessoaFísica:"+idpessoaFisica+" Id Usuário:"+idusuario;
    }
    
}
