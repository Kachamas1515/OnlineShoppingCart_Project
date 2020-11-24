/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author amam
 */
@Entity
@Table(name = "DVDCATALOG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dvdcatalog.findAll", query = "SELECT d FROM Dvdcatalog d"),
    @NamedQuery(name = "Dvdcatalog.findByDvdid", query = "SELECT d FROM Dvdcatalog d WHERE d.dvdid = :dvdid"),
    @NamedQuery(name = "Dvdcatalog.findByDvdname", query = "SELECT d FROM Dvdcatalog d WHERE d.dvdname = :dvdname"),
    @NamedQuery(name = "Dvdcatalog.findByRate", query = "SELECT d FROM Dvdcatalog d WHERE d.rate = :rate"),
    @NamedQuery(name = "Dvdcatalog.findByYears", query = "SELECT d FROM Dvdcatalog d WHERE d.years = :years"),
    @NamedQuery(name = "Dvdcatalog.findByPrice", query = "SELECT d FROM Dvdcatalog d WHERE d.price = :price")})
public class Dvdcatalog implements Serializable {

    @Size(max = 80)
    @Column(name = "DVDNAME")
    private String dvdname;
    @Size(max = 80)
    @Column(name = "RATE")
    private String rate;
    @Size(max = 4)
    @Column(name = "YEARS")
    private String years;
    @OneToMany(mappedBy = "dvdid")
    private Collection<Cart> cartCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DVDID")
    private Integer dvdid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRICE")
    private Double price;

    public Dvdcatalog() {
    }

    public Dvdcatalog(Integer dvdid) {
        this.dvdid = dvdid;
    }

    public Integer getDvdid() {
        return dvdid;
    }

    public void setDvdid(Integer dvdid) {
        this.dvdid = dvdid;
    }


    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dvdid != null ? dvdid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dvdcatalog)) {
            return false;
        }
        Dvdcatalog other = (Dvdcatalog) object;
        if ((this.dvdid == null && other.dvdid != null) || (this.dvdid != null && !this.dvdid.equals(other.dvdid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Dvdcatalog[ dvdid=" + dvdid + " ]";
    }


    @XmlTransient
    public Collection<Cart> getCartCollection() {
        return cartCollection;
    }

    public void setCartCollection(Collection<Cart> cartCollection) {
        this.cartCollection = cartCollection;
    }

    public String getDvdname() {
        return dvdname;
    }

    public void setDvdname(String dvdname) {
        this.dvdname = dvdname;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }
    
}
