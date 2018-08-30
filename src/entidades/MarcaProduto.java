package entidades;
import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "marca_produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MarcaProduto.findAll", query = "SELECT m FROM MarcaProduto m")
    , @NamedQuery(name = "MarcaProduto.findByIdmarcaProduto", query = "SELECT m FROM MarcaProduto m WHERE m.idmarcaProduto = :idmarcaProduto")
    , @NamedQuery(name = "MarcaProduto.findByNome", query = "SELECT m FROM MarcaProduto m WHERE m.nome = :nome")
    , @NamedQuery(name = "MarcaProduto.findBySituacao", query = "SELECT m FROM MarcaProduto m WHERE m.situacao = :situacao")})
public class MarcaProduto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmarca_produto")
    private Integer idmarcaProduto;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "situacao")
    private boolean situacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmarcaProduto")
    private List<Produto> produtoList;

    public MarcaProduto() {
    }

    public MarcaProduto(Integer idmarcaProduto) {
        this.idmarcaProduto = idmarcaProduto;
    }

    public MarcaProduto(Integer idmarcaProduto, String nome, boolean situacao) {
        this.idmarcaProduto = idmarcaProduto;
        this.nome = nome;
        this.situacao = situacao;
    }

    public Integer getIdmarcaProduto() {
        return idmarcaProduto;
    }

    public void setIdmarcaProduto(Integer idmarcaProduto) {
        this.idmarcaProduto = idmarcaProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean getSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    @XmlTransient
    public List<Produto> getProdutoList() {
        return produtoList;
    }

    public void setProdutoList(List<Produto> produtoList) {
        this.produtoList = produtoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmarcaProduto != null ? idmarcaProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MarcaProduto)) {
            return false;
        }
        MarcaProduto other = (MarcaProduto) object;
        if ((this.idmarcaProduto == null && other.idmarcaProduto != null) || (this.idmarcaProduto != null && !this.idmarcaProduto.equals(other.idmarcaProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Id Marca:"+idmarcaProduto+" Nome:"+nome+" Situação:"+situacao;
    }
    
}
