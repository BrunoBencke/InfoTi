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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author bruno.bencke
 */
@Entity
@Table(name = "forma_pagamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FormaPagamento.findAll", query = "SELECT f FROM FormaPagamento f")
    , @NamedQuery(name = "FormaPagamento.findByIdformaPagamento", query = "SELECT f FROM FormaPagamento f WHERE f.idformaPagamento = :idformaPagamento")
    , @NamedQuery(name = "FormaPagamento.findByDescricao", query = "SELECT f FROM FormaPagamento f WHERE f.descricao = :descricao")
    , @NamedQuery(name = "FormaPagamento.findByIdtipoPagamento", query = "SELECT f FROM FormaPagamento f WHERE f.idtipoPagamento = :idtipoPagamento")})
public class FormaPagamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "idforma_pagamento")
    private int idformaPagamento;
    @Basic(optional = false)
    @Column(name = "descricao")
    private String descricao;
    @Id
    @Basic(optional = false)
    @Column(name = "idtipo_pagamento")
    private Integer idtipoPagamento;
    @JoinColumn(name = "idtipo_pagamento", referencedColumnName = "idtipo_pagamento", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private TipoPagamento tipoPagamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idformaPagamento")
    private List<Venda> vendaList;

    public FormaPagamento() {
    }

    public FormaPagamento(Integer idtipoPagamento) {
        this.idtipoPagamento = idtipoPagamento;
    }

    public FormaPagamento(Integer idtipoPagamento, int idformaPagamento, String descricao) {
        this.idtipoPagamento = idtipoPagamento;
        this.idformaPagamento = idformaPagamento;
        this.descricao = descricao;
    }

    public int getIdformaPagamento() {
        return idformaPagamento;
    }

    public void setIdformaPagamento(int idformaPagamento) {
        this.idformaPagamento = idformaPagamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getIdtipoPagamento() {
        return idtipoPagamento;
    }

    public void setIdtipoPagamento(Integer idtipoPagamento) {
        this.idtipoPagamento = idtipoPagamento;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    @XmlTransient
    public List<Venda> getVendaList() {
        return vendaList;
    }

    public void setVendaList(List<Venda> vendaList) {
        this.vendaList = vendaList;
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
        if (!(object instanceof FormaPagamento)) {
            return false;
        }
        FormaPagamento other = (FormaPagamento) object;
        if ((this.idtipoPagamento == null && other.idtipoPagamento != null) || (this.idtipoPagamento != null && !this.idtipoPagamento.equals(other.idtipoPagamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.FormaPagamento[ idtipoPagamento=" + idtipoPagamento + " ]";
    }
    
}
