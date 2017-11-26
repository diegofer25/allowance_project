/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
 * @author diego
 */
@Entity
@Table(name = "regras")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Regra.findAll", query = "SELECT r FROM Regra r")
    , @NamedQuery(name = "Regra.findById", query = "SELECT r FROM Regra r WHERE r.id = :id")
    , @NamedQuery(name = "Regra.findByNomeregra", query = "SELECT r FROM Regra r WHERE r.nomeregra = :nomeregra")
    , @NamedQuery(name = "Regra.findByOcorrencia", query = "SELECT r FROM Regra r WHERE r.ocorrencia = :ocorrencia")
    , @NamedQuery(name = "Regra.findByIdfilho", query = "SELECT r FROM Regra r WHERE r.idfilho = :idfilho")
    , @NamedQuery(name = "Regra.findByValor", query = "SELECT r FROM Regra r WHERE r.valor = :valor")})
public class Regra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nomeregra")
    private String nomeregra;
    @Column(name = "ocorrencia")
    private Integer ocorrencia;
    @Column(name = "idfilho")
    private Integer idfilho;
    @Column(name = "valor")
    private Integer valor;

    public Regra() {
    }

    public Regra(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeregra() {
        return nomeregra;
    }

    public void setNomeregra(String nomeregra) {
        this.nomeregra = nomeregra;
    }

    public Integer getOcorrencia() {
        return ocorrencia;
    }

    public void setOcorrencia(Integer ocorrencia) {
        this.ocorrencia = ocorrencia;
    }

    public Integer getIdfilho() {
        return idfilho;
    }

    public void setIdfilho(Integer idfilho) {
        this.idfilho = idfilho;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Regra)) {
            return false;
        }
        Regra other = (Regra) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Regra[ id=" + id + " ]";
    }
    
}
