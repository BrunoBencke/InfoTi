/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author bruno.bencke
 */
@Entity
@Table(name = "conta_pagar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContaPagar.findAll", query = "SELECT c FROM ContaPagar c")
    , @NamedQuery(name = "ContaPagar.findByIdcontaPagar", query = "SELECT c FROM ContaPagar c WHERE c.idcontaPagar = :idcontaPagar")
    , @NamedQuery(name = "ContaPagar.findByNome", query = "SELECT c FROM ContaPagar c WHERE c.nome = :nome")
    , @NamedQuery(name = "ContaPagar.findByValor", query = "SELECT c FROM ContaPagar c WHERE c.valor = :valor")
    , @NamedQuery(name = "ContaPagar.findByValorpago", query = "SELECT c FROM ContaPagar c WHERE c.valorpago = :valorpago")
    , @NamedQuery(name = "ContaPagar.findByDataVencimento", query = "SELECT c FROM ContaPagar c WHERE c.dataVencimento = :dataVencimento")
    , @NamedQuery(name = "ContaPagar.findByDataPagamento", query = "SELECT c FROM ContaPagar c WHERE c.dataPagamento = :dataPagamento")
    , @NamedQuery(name = "ContaPagar.findBySituacao", query = "SELECT c FROM ContaPagar c WHERE c.situacao = :situacao")})
public class ContaPagar implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcontapagar")
    private List<Arquivo> arquivoList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idconta_pagar")
    private Integer idcontaPagar;
    @Column(name = "nome")
    private String nome;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private BigDecimal valor;
    @Column(name = "valorpago")
    private BigDecimal valorpago;
    @Column(name = "data_vencimento")
    @Temporal(TemporalType.DATE)
    private Date dataVencimento;
    @Column(name = "data_pagamento")
    @Temporal(TemporalType.DATE)
    private Date dataPagamento;
    @Column(name = "situacao")
    private Boolean situacao;

    public ContaPagar() {
    }

    public ContaPagar(Integer idcontaPagar) {
        this.idcontaPagar = idcontaPagar;
    }

    public Integer getIdcontaPagar() {
        return idcontaPagar;
    }

    public void setIdcontaPagar(Integer idcontaPagar) {
        this.idcontaPagar = idcontaPagar;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValorpago() {
        return valorpago;
    }

    public void setValorpago(BigDecimal valorpago) {
        this.valorpago = valorpago;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Boolean getSituacao() {
        return situacao;
    }

    public void setSituacao(Boolean situacao) {
        this.situacao = situacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcontaPagar != null ? idcontaPagar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContaPagar)) {
            return false;
        }
        ContaPagar other = (ContaPagar) object;
        if ((this.idcontaPagar == null && other.idcontaPagar != null) || (this.idcontaPagar != null && !this.idcontaPagar.equals(other.idcontaPagar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.ContaPagar[ idcontaPagar=" + idcontaPagar + " ]";
    }

    @XmlTransient
    public List<Arquivo> getArquivoList() {
        return arquivoList;
    }

    public void setArquivoList(List<Arquivo> arquivoList) {
        this.arquivoList = arquivoList;
    }
    
}
