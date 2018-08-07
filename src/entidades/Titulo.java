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
 * @author bruno.bencke
 */
@Entity
@Table(name = "titulo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Titulo.findAll", query = "SELECT t FROM Titulo t")
    , @NamedQuery(name = "Titulo.findByIdtitulo", query = "SELECT t FROM Titulo t WHERE t.idtitulo = :idtitulo")
    , @NamedQuery(name = "Titulo.findByDataVencimento", query = "SELECT t FROM Titulo t WHERE t.dataVencimento = :dataVencimento")
    , @NamedQuery(name = "Titulo.findByValor", query = "SELECT t FROM Titulo t WHERE t.valor = :valor")
    , @NamedQuery(name = "Titulo.findByValorPago", query = "SELECT t FROM Titulo t WHERE t.valorPago = :valorPago")
    , @NamedQuery(name = "Titulo.findByDataPagamento", query = "SELECT t FROM Titulo t WHERE t.dataPagamento = :dataPagamento")
    , @NamedQuery(name = "Titulo.findBySituacao", query = "SELECT t FROM Titulo t WHERE t.situacao = :situacao")})
public class Titulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idtitulo")
    private Integer idtitulo;
    @Basic(optional = false)
    @Column(name = "data_vencimento")
    @Temporal(TemporalType.DATE)
    private Date dataVencimento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "valor")
    private BigDecimal valor;
    @Column(name = "valor_pago")
    private BigDecimal valorPago;
    @Column(name = "data_pagamento")
    @Temporal(TemporalType.DATE)
    private Date dataPagamento;
    @Basic(optional = false)
    @Column(name = "situacao")
    private boolean situacao;
    @JoinColumn(name = "idvenda", referencedColumnName = "idvenda")
    @ManyToOne(optional = false)
    private Venda idvenda;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtitulo")
    private List<Caixa> caixaList;

    public Titulo() {
    }

    public Titulo(Integer idtitulo) {
        this.idtitulo = idtitulo;
    }

    public Titulo(Integer idtitulo, Date dataVencimento, BigDecimal valor, boolean situacao) {
        this.idtitulo = idtitulo;
        this.dataVencimento = dataVencimento;
        this.valor = valor;
        this.situacao = situacao;
    }

    public Integer getIdtitulo() {
        return idtitulo;
    }

    public void setIdtitulo(Integer idtitulo) {
        this.idtitulo = idtitulo;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValorPago() {
        return valorPago;
    }

    public void setValorPago(BigDecimal valorPago) {
        this.valorPago = valorPago;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public boolean getSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    public Venda getIdvenda() {
        return idvenda;
    }

    public void setIdvenda(Venda idvenda) {
        this.idvenda = idvenda;
    }

    @XmlTransient
    public List<Caixa> getCaixaList() {
        return caixaList;
    }

    public void setCaixaList(List<Caixa> caixaList) {
        this.caixaList = caixaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtitulo != null ? idtitulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Titulo)) {
            return false;
        }
        Titulo other = (Titulo) object;
        if ((this.idtitulo == null && other.idtitulo != null) || (this.idtitulo != null && !this.idtitulo.equals(other.idtitulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Titulo[ idtitulo=" + idtitulo + " ]";
    }
    
}
