/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * @author bruno.bencke
 */
@Entity
@Table(name = "produto_venda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProdutoVenda.findAll", query = "SELECT p FROM ProdutoVenda p")
    , @NamedQuery(name = "ProdutoVenda.findByIdprodutovenda", query = "SELECT p FROM ProdutoVenda p WHERE p.idprodutovenda = :idprodutovenda")
    , @NamedQuery(name = "ProdutoVenda.findByQuantidade", query = "SELECT p FROM ProdutoVenda p WHERE p.quantidade = :quantidade")
    , @NamedQuery(name = "ProdutoVenda.findByValorUnitario", query = "SELECT p FROM ProdutoVenda p WHERE p.valorUnitario = :valorUnitario")})
public class ProdutoVenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idprodutovenda")
    private Integer idprodutovenda;
    @Basic(optional = false)
    @Column(name = "quantidade")
    private double quantidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "valor_unitario")
    private BigDecimal valorUnitario;
    @JoinColumn(name = "idproduto", referencedColumnName = "idproduto")
    @ManyToOne(optional = false)
    private Produto idproduto;
    @JoinColumn(name = "idvenda", referencedColumnName = "idvenda")
    @ManyToOne(optional = false)
    private Venda idvenda;

    public ProdutoVenda() {
    }

    public ProdutoVenda(Integer idprodutovenda) {
        this.idprodutovenda = idprodutovenda;
    }

    public ProdutoVenda(Integer idprodutovenda, double quantidade, BigDecimal valorUnitario) {
        this.idprodutovenda = idprodutovenda;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
    }

    public Integer getIdprodutovenda() {
        return idprodutovenda;
    }

    public void setIdprodutovenda(Integer idprodutovenda) {
        this.idprodutovenda = idprodutovenda;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Produto getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(Produto idproduto) {
        this.idproduto = idproduto;
    }

    public Venda getIdvenda() {
        return idvenda;
    }

    public void setIdvenda(Venda idvenda) {
        this.idvenda = idvenda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprodutovenda != null ? idprodutovenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProdutoVenda)) {
            return false;
        }
        ProdutoVenda other = (ProdutoVenda) object;
        if ((this.idprodutovenda == null && other.idprodutovenda != null) || (this.idprodutovenda != null && !this.idprodutovenda.equals(other.idprodutovenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.ProdutoVenda[ idprodutovenda=" + idprodutovenda + " ]";
    }
    
}
