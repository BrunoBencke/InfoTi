
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries(value = {
    @NamedQuery(name = "ParametroSistema.findByCodigo", query = "SELECT c FROM ParametroSistema c WHERE c.codigo = :codigo")
    ,
             @NamedQuery(name = "ParametroSistema.findAll", query = "SELECT c FROM ParametroSistema c")})
@Table(name = "parametro_sistema")
public class ParametroSistema {

    public static final String FIND_BY_CODIGO = "ParametroSistema.findByCodigo";
    public static final String FIND_ALL = "ParametroSistema.findAll";

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

   /* @Override
    public boolean equals(Object obj) {
        return (obj instanceof AbstractBean) && (this.id != null) ? id
                .equals(((AbstractBean) obj).getId()) : (obj == this);
    }
*/
    @Column(length = 255, nullable = false)
    private String codigo;

    @Column(length = 255)
    private String descricao;

    @Column(length = 255, nullable = false)
    private String descricao_campo1;

    @Column(length = 255, nullable = false)
    private String valor_campo1;

    @Column(length = 255)
    private String descricao_campo2;

    @Column(length = 255)
    private String valor_campo2;

    @Column(length = 255)
    private String descricao_campo3;

    @Column(length = 255)
    private String valor_campo3;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo.toUpperCase().trim();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao_campo1() {
        return descricao_campo1;
    }

    public void setDescricao_campo1(String descricao_campo1) {
        this.descricao_campo1 = descricao_campo1;
    }

    public String getValor_campo1() {
        return valor_campo1;
    }

    public void setValor_campo1(String valor_campo1) {
        this.valor_campo1 = valor_campo1;
    }

    public String getDescricao_campo2() {
        return descricao_campo2;
    }

    public void setDescricao_campo2(String descricao_campo2) {
        this.descricao_campo2 = descricao_campo2;
    }

    public String getValor_campo2() {
        return valor_campo2;
    }

    public void setValor_campo2(String valor_campo2) {
        this.valor_campo2 = valor_campo2;
    }

    public String getDescricao_campo3() {
        return descricao_campo3;
    }

    public void setDescricao_campo3(String descricao_campo3) {
        this.descricao_campo3 = descricao_campo3;
    }

    public String getValor_campo3() {
        return valor_campo3;
    }

    public void setValor_campo3(String valor_campo3) {
        this.valor_campo3 = valor_campo3;
    }
}
