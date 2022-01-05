/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projekakhirkelasc.projek.akhir.kelas.c;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "namapasien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Namapasien.findAll", query = "SELECT n FROM Namapasien n"),
    @NamedQuery(name = "Namapasien.findById", query = "SELECT n FROM Namapasien n WHERE n.id = :id"),
    @NamedQuery(name = "Namapasien.findByNama", query = "SELECT n FROM Namapasien n WHERE n.nama = :nama"),
    @NamedQuery(name = "Namapasien.findByNomerkamar", query = "SELECT n FROM Namapasien n WHERE n.nomerkamar = :nomerkamar")})
public class Namapasien implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nama")
    private String nama;
    @Column(name = "nomerkamar")
    private Integer nomerkamar;

    public Namapasien() {
    }

    public Namapasien(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getNomerkamar() {
        return nomerkamar;
    }

    public void setNomerkamar(Integer nomerkamar) {
        this.nomerkamar = nomerkamar;
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
        if (!(object instanceof Namapasien)) {
            return false;
        }
        Namapasien other = (Namapasien) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "projekakhirkelasc.projek.akhir.kelas.c.Namapasien[ id=" + id + " ]";
    }
    
}
