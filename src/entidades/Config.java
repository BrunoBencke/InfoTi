/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Christian
 */
@Entity
@Table(name = "config")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Config.findAll", query = "SELECT c FROM Config c")
    , @NamedQuery(name = "Config.findByIdconfig", query = "SELECT c FROM Config c WHERE c.idconfig = :idconfig")
    , @NamedQuery(name = "Config.findByAuditoria", query = "SELECT c FROM Config c WHERE c.auditoria = :auditoria")})
public class Config implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idconfig")
    private Integer idconfig;
    @Basic(optional = false)
    @Column(name = "auditoria")
    private int auditoria;

    public Config() {
    }

    public Config(Integer idconfig) {
        this.idconfig = idconfig;
    }

    public Config(Integer idconfig, int auditoria) {
        this.idconfig = idconfig;
        this.auditoria = auditoria;
    }

    public Integer getIdconfig() {
        return idconfig;
    }

    public void setIdconfig(Integer idconfig) {
        this.idconfig = idconfig;
    }

    public int getAuditoria() {
        return auditoria;
    }

    public void setAuditoria(int auditoria) {
        this.auditoria = auditoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idconfig != null ? idconfig.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Config)) {
            return false;
        }
        Config other = (Config) object;
        if ((this.idconfig == null && other.idconfig != null) || (this.idconfig != null && !this.idconfig.equals(other.idconfig))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Config[ idconfig=" + idconfig + " ]";
    }
    
}
