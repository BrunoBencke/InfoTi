/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author atendimento
 */
@Entity
@Table(name = "caixa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Caixa.findAll", query = "SELECT c FROM Caixa c")
    , @NamedQuery(name = "Caixa.findByIdcaixa", query = "SELECT c FROM Caixa c WHERE c.idcaixa = :idcaixa")
    , @NamedQuery(name = "Caixa.findByRegistroEntrada", query = "SELECT c FROM Caixa c WHERE c.registroEntrada = :registroEntrada")
    , @NamedQuery(name = "Caixa.findByRegistroSaida", query = "SELECT c FROM Caixa c WHERE c.registroSaida = :registroSaida")})
public class Caixa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idcaixa")
    private Integer idcaixa;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "registro_entrada")
    private BigDecimal registroEntrada;
    @Column(name = "registro_saida")
    private BigDecimal registroSaida;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcaixa")
    private List<TituloPagar> tituloPagarList;
    @JoinColumn(name = "idtitulo", referencedColumnName = "idtitulo")
    @ManyToOne(optional = false)
    private Titulo idtitulo;

    public Caixa() {
    }

    public Caixa(Integer idcaixa) {
        this.idcaixa = idcaixa;
    }

    public Integer getIdcaixa() {
        return idcaixa;
    }

    public void setIdcaixa(Integer idcaixa) {
        this.idcaixa = idcaixa;
    }

    public BigDecimal getRegistroEntrada() {
        return registroEntrada;
    }

    public void setRegistroEntrada(BigDecimal registroEntrada) {
        this.registroEntrada = registroEntrada;
    }

    public BigDecimal getRegistroSaida() {
        return registroSaida;
    }

    public void setRegistroSaida(BigDecimal registroSaida) {
        this.registroSaida = registroSaida;
    }

    @XmlTransient
    public List<TituloPagar> getTituloPagarList() {
        return tituloPagarList;
    }

    public void setTituloPagarList(List<TituloPagar> tituloPagarList) {
        this.tituloPagarList = tituloPagarList;
    }

    public Titulo getIdtitulo() {
        return idtitulo;
    }

    public void setIdtitulo(Titulo idtitulo) {
        this.idtitulo = idtitulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcaixa != null ? idcaixa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Caixa)) {
            return false;
        }
        Caixa other = (Caixa) object;
        if ((this.idcaixa == null && other.idcaixa != null) || (this.idcaixa != null && !this.idcaixa.equals(other.idcaixa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Caixa[ idcaixa=" + idcaixa + " ]";
    }
    
}
