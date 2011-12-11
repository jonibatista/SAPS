/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cesar
 */
@Entity
@Table(name = "stores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stores.findAll", query = "SELECT s FROM Stores s"),
    @NamedQuery(name = "Stores.findByIds", query = "SELECT s FROM Stores s WHERE s.ids = :ids"),
    @NamedQuery(name = "Stores.findByNamest", query = "SELECT s FROM Stores s WHERE s.namest = :namest"),
    @NamedQuery(name = "Stores.findByAddress", query = "SELECT s FROM Stores s WHERE s.address = :address"),
    @NamedQuery(name = "Stores.findByInfo", query = "SELECT s FROM Stores s WHERE s.info = :info"),
    @NamedQuery(name = "Stores.findByImagec", query = "SELECT s FROM Stores s WHERE s.imagec = :imagec")})
public class Stores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ids")
    private Integer ids;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "namest")
    private String namest;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "address")
    private String address;
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
    @JoinTable(name = "stores_users", joinColumns = {
        @JoinColumn(name = "id_store", referencedColumnName = "ids")}, inverseJoinColumns = {
        @JoinColumn(name = "id_user", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Users> usersCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idS")
    private Collection<Advertisments> advertismentsCollection;

    public Stores() {
    }

    public Stores(Integer ids) {
        this.ids = ids;
    }

    public Stores(Integer ids, String namest, String address, byte[] image, String imagec) {
        this.ids = ids;
        this.namest = namest;
        this.address = address;
        this.image = image;
        this.imagec = imagec;
    }

    public Integer getIds() {
        return ids;
    }

    public void setIds(Integer ids) {
        this.ids = ids;
    }

    public String getNamest() {
        return namest;
    }

    public void setNamest(String namest) {
        this.namest = namest;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    @XmlTransient
    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    @XmlTransient
    public Collection<Advertisments> getAdvertismentsCollection() {
        return advertismentsCollection;
    }

    public void setAdvertismentsCollection(Collection<Advertisments> advertismentsCollection) {
        this.advertismentsCollection = advertismentsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ids != null ? ids.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stores)) {
            return false;
        }
        Stores other = (Stores) object;
        if ((this.ids == null && other.ids != null) || (this.ids != null && !this.ids.equals(other.ids))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Stores[ ids=" + ids + " ]";
    }
    
}
