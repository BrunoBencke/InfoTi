/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bruno.bencke
 */
@Entity
@Table(name = "tipo_pagamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPagamento.findAll", query = "SELECT t FROM TipoPagamento t")
    , @NamedQuery(name = "TipoPagamento.findByIdtipoPagamento", query = "SELECT t FROM TipoPagamento t WHERE t.idtipoPagamento = :idtipoPagamento")
    , @NamedQuery(name = "TipoPagamento.findByDescricao", query = "SELECT t FROM TipoPagamento t WHERE t.descricao = :descricao")
    , @NamedQuery(name = "TipoPagamento.findByQuantidade", query = "SELECT t FROM TipoPagamento t WHERE t.quantidade = :quantidade")})
public class TipoPagamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipo_pagamento")
    private Integer idtipoPagamento;
    @Basic(optional = false)
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @Column(name = "quantidade")
    private int quantidade;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tipoPagamento")
    private FormaPagamento formaPagamento;

    public TipoPagamento() {
    }

    public TipoPagamento(Integer idtipoPagamento) {
        this.idtipoPagamento = idtipoPagamento;
    }

    public TipoPagamento(Integer idtipoPagamento, String descricao, int quantidade) {
        this.idtipoPagamento = idtipoPagamento;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    public Integer getIdtipoPagamento() {
        return idtipoPagamento;
    }

    public void setIdtipoPagamento(Integer idtipoPagamento) {
        this.idtipoPagamento = idtipoPagamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoPagamento != null ? idtipoPagamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPagamento)) {
            return false;
        }
        TipoPagamento other = (TipoPagamento) object;
        if ((this.idtipoPagamento == null && other.idtipoPagamento != null) || (this.idtipoPagamento != null && !this.idtipoPagamento.equals(other.idtipoPagamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TipoPagamento[ idtipoPagamento=" + idtipoPagamento + " ]";
    }
    
}
