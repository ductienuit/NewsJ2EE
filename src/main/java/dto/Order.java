package dto;
// Generated May 22, 2019 4:10:30 PM by Hibernate Tools 4.3.1

import dto.common.IDTO;
import dto.common.Pagination;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Order generated by hbm2java
 */
@Entity
@Table(name = "order",
       catalog = "toymanager"
)
public class Order extends Pagination<Order> implements Serializable, IDTO {
    private long id;
    private OrderStatus orderStatus;
    private User user;
    private Date orderDate;
    private Date paymentDate;
    private Date lastModifiedDate;
    private long totalPrice;
    private Set<OrderDetail> orderDetails;

    public Order() {
        this.orderDetails = new HashSet<>(0);
    }

    public Order(long id,
                 OrderStatus orderStatus,
                 User user,
                 Date orderDate,
                 Date lastModifiedDate,
                 long totalPrice) {
        this.orderDetails = new HashSet<>(0);
        this.id = id;
        this.orderStatus = orderStatus;
        this.user = user;
        this.orderDate = orderDate;
        this.lastModifiedDate = lastModifiedDate;
        this.totalPrice = totalPrice;
    }

    public Order(long id,
                 OrderStatus orderStatus,
                 User user,
                 Date orderDate,
                 Date paymentDate,
                 Date lastModifiedDate,
                 long totalPrice,
                 Set<OrderDetail> orderDetails) {
        this.orderDetails = new HashSet<>(0);
        this.id = id;
        this.orderStatus = orderStatus;
        this.user = user;
        this.orderDate = orderDate;
        this.paymentDate = paymentDate;
        this.lastModifiedDate = lastModifiedDate;
        this.totalPrice = totalPrice;
        this.orderDetails = orderDetails;
    }

    @Id
    @Column(name = "Id",
            unique = true,
            nullable = false)
    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OrderStatusId",
                nullable = false)
    public OrderStatus getOrderStatus() {
        return this.orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserId",
                nullable = false)
    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "OrderDate",
            nullable = false,
            length = 26)
    public Date getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PaymentDate",
            length = 26)
    public Date getPaymentDate() {
        return this.paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LastModifiedDate",
            nullable = false,
            length = 26)
    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Column(name = "TotalPrice",
            nullable = false,
            precision = 10,
            scale = 0)
    public long getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    @OneToMany(fetch = FetchType.LAZY,
               mappedBy = "order")
    public Set<OrderDetail> getOrderDetails() {
        return this.orderDetails;
    }

    public void setOrderDetails(Set<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
