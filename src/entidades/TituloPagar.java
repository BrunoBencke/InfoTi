/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "titulo_pagar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TituloPagar.findAll", query = "SELECT t FROM TituloPagar t")
    , @NamedQuery(name = "TituloPagar.findByIdtituloPagar", query = "SELECT t FROM TituloPagar t WHERE t.idtituloPagar = :idtituloPagar")
    , @NamedQuery(name = "TituloPagar.findByDescricao", query = "SELECT t FROM TituloPagar t WHERE t.descricao = :descricao")
    , @NamedQuery(name = "TituloPagar.findByValorPagar", query = "SELECT t FROM TituloPagar t WHERE t.valorPagar = :valorPagar")
    , @NamedQuery(name = "TituloPagar.findByDataVencimento", query = "SELECT t FROM TituloPagar t WHERE t.dataVencimento = :dataVencimento")
    , @NamedQuery(name = "TituloPagar.findBySituacao", query = "SELECT t FROM TituloPagar t WHERE t.situacao = :situacao")})
public class TituloPagar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtitulo_pagar")
    private Integer idtituloPagar;
    @Column(name = "descricao")
    private String descricao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_pagar")
    private BigDecimal valorPagar;
    @Column(name = "data_vencimento")
    @Temporal(TemporalType.DATE)
    private Date dataVencimento;
    @Column(name = "situacao")
    private Boolean situacao;
    @JoinColumn(name = "idcaixa", referencedColumnName = "idcaixa")
    @ManyToOne(optional = false)
    private Caixa idcaixa;

    public TituloPagar() {
    }

    public TituloPagar(Integer idtituloPagar) {
        this.idtituloPagar = idtituloPagar;
    }

    public Integer getIdtituloPagar() {
        return idtituloPagar;
    }

    public void setIdtituloPagar(Integer idtituloPagar) {
        this.idtituloPagar = idtituloPagar;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValorPagar() {
        return valorPagar;
    }

    public void setValorPagar(BigDecimal valorPagar) {
        this.valorPagar = valorPagar;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Boolean getSituacao() {
        return situacao;
    }

    public void setSituacao(Boolean situacao) {
        this.situacao = situacao;
    }

    public Caixa getIdcaixa() {
        return idcaixa;
    }

    public void setIdcaixa(Caixa idcaixa) {
        this.idcaixa = idcaixa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtituloPagar != null ? idtituloPagar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TituloPagar)) {
            return false;
        }
        TituloPagar other = (TituloPagar) object;
        if ((this.idtituloPagar == null && other.idtituloPagar != null) || (this.idtituloPagar != null && !this.idtituloPagar.equals(other.idtituloPagar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TituloPagar[ idtituloPagar=" + idtituloPagar + " ]";
    }
    
}
