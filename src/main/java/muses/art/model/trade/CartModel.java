package muses.art.model.trade;

import muses.art.entity.commodity.Commodity;
import muses.art.entity.user.User;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class CartModel {
    private Integer id;
    private Integer number;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    protected Date addTime;
    private User user;
    private Integer userId;
    private Commodity commodity;
    private Integer commodityId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getAddTime() {
        return addTime;
    }


    public void setAddTime(Date addTime) {
        this.addTime = new Date();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

}