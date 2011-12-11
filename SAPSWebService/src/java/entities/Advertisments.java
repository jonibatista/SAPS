/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cesar
 */
@Entity
@Table(name = "advertisments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Advertisments.findAll", query = "SELECT a FROM Advertisments a"),
    @NamedQuery(name = "Advertisments.findByIda", query = "SELECT a FROM Advertisments a WHERE a.ida = :ida"),
    @NamedQuery(name = "Advertisments.findByNameadv", query = "SELECT a FROM Advertisments a WHERE a.nameadv = :nameadv"),
    @NamedQuery(name = "Advertisments.findByInfo", query = "SELECT a FROM Advertisments a WHERE a.info = :info"),
    @NamedQuery(name = "Advertisments.findByImagec", query = "SELECT a FROM Advertisments a WHERE a.imagec = :imagec")})
public class Advertisments implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ida")
    private Integer ida;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "nameadv")
    private String nameadv;
    @Size(max = 255)
    @Column(name = "info")
    private String info;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "image")
    private byte[] image;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "imagec")
    private String imagec;
    @JoinColumn(name = "id_s", referencedColumnName = "ids")
    @ManyToOne(optional = false)
    private Stores idS;

    public Advertisments() {
    }

    public Advertisments(Integer ida) {
        this.ida = ida;
    }

    public Advertisments(Integer ida, String nameadv, byte[] image, String imagec) {
        this.ida = ida;
        this.nameadv = nameadv;
        this.image = image;
        this.imagec = imagec;
    }

    public Integer getIda() {
        return ida;
    }

    public void setIda(Integer ida) {
        this.ida = ida;
    }

    public String getNameadv() {
        return nameadv;
    }

    public void setNameadv(String nameadv) {
        this.nameadv = nameadv;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getImagec() {
        return imagec;
    }

    public void setImagec(String imagec) {
        this.imagec = imagec;
    }

    public Stores getIdS() {
        return idS;
    }

    public void setIdS(Stores idS) {
        this.idS = idS;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ida != null ? ida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Advertisments)) {
            return false;
        }
        Advertisments other = (Advertisments) object;
        if ((this.ida == null && other.ida != null) || (this.ida != null && !this.ida.equals(other.ida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Advertisments[ ida=" + ida + " ]";
    }
    
}
