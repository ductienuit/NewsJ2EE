package dto;
// Generated May 20, 2019 12:22:56 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Toy generated by hbm2java
 */
@Entity
@Table(name = "toy",
       catalog = "toymanager"
)
public class Toy implements java.io.Serializable {
    private long id;
    private Category category;
    private String name;
    private long price;
    private byte gender;
    private String imageUri;
    private String description;
    private Set<OrderDetail> orderDetails;

    public Toy() {
        this.orderDetails = new HashSet<>(0);
    }

    public Toy(long id,
               Category category,
               String name,
               long price,
               byte gender,
               String imageUri,
               String description) {
        this.orderDetails = new HashSet<>(0);
        this.id = id;
        this.category = category;
        this.name = name;
        this.price = price;
        this.gender = gender;
        this.imageUri = imageUri;
        this.description = description;
    }

    public Toy(long id,
               Category category,
               String name,
               long price,
               byte gender,
               String imageUri,
               String description,
               Set<OrderDetail> orderdetails) {
        this.orderDetails = new HashSet<>(0);
        this.id = id;
        this.category = category;
        this.name = name;
        this.price = price;
        this.gender = gender;
        this.imageUri = imageUri;
        this.description = description;
        this.orderDetails = orderdetails;
    }

    @Id
    @Column(name = "Id",
            unique = true,
            nullable = false)
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CategoryId",
                nullable = false)
    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Column(name = "Name",
            nullable = false)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "Price",
            nullable = false,
            precision = 10,
            scale = 0)
    public long getPrice() {
        return this.price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Column(name = "Gender",
            nullable = false)
    public byte getGender() {
        return this.gender;
    }

    public void setGender(byte gender) {
        this.gender = gender;
    }

    @Column(name = "ImageURI",
            nullable = false)
    public String getImageUri() {
        return this.imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    @Column(name = "Description",
            nullable = false)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(fetch = FetchType.LAZY,
               mappedBy = "toy")
    public Set<OrderDetail> getOrderDetails() {
        return this.orderDetails;
    }

    public void setOrderDetails(Set<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
