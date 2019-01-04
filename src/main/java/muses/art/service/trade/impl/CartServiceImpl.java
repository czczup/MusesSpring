package muses.art.service.trade.impl;

import muses.art.dao.commodity.CommodityDao;
import muses.art.dao.trade.CartDao;
import muses.art.entity.commodity.Commodity;
import muses.art.entity.trade.Cart;
import muses.art.model.trade.CartModel;
import muses.art.service.trade.CartService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.print.attribute.standard.Destination;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;
    @Autowired
    private CommodityDao commodityDao;

    @Override
    public Boolean addToCart(Integer userId, Integer commodityId, String detail, Integer number) {
        Cart cart = findCartExist(userId, commodityId, detail);
        if (commodityDao.get(Commodity.class, commodityId) == null) return false;
        if (cart != null) {
            cart.setNumber(cart.getNumber() + 1);
            cartDao.update(cart);
            return true;
        }
        cart = new Cart();
        cart.setUserId(userId);
        cart.setCommodityId(commodityId);
        cart.setNumber(number);
        cart.setDetail(detail);
        cart.setAddTime(new Timestamp(System.currentTimeMillis()));
        cartDao.save(cart);
        return true;
    }

    @Override
    public Boolean deleteFromCart(Integer id) {
        Cart cart = cartDao.get(Cart.class, id);
        if (cart == null) return false;
        cartDao.delete(cart);
        return true;
    }

    @Override
    public Boolean updateCart(Integer id, Integer number) {
        Cart cart = cartDao.get(Cart.class, id);
        if (cart == null) return false;
        cart.setNumber(number);
        cartDao.update(cart);
        return true;
    }

    @Override
    public List<CartModel> listCart(Integer userId) {
        String SQL = "from Cart where userId=:id";
        Map<String, Object> map = new HashMap<>();
        map.put("id", userId);
        List<Cart> carts = cartDao.find(SQL, map);
        List<CartModel> cartModels = new ArrayList<>();
        carts.forEach(cart->cartModels.add(cartDao.getModelMapper().map(cart, CartModel.class)));
        return cartModels;
    }

    @Override
    public Cart findCartExist(Integer userId, Integer commodityId, String detail) {
        String SQL = "from Cart where userId=:uid and commodityId=:cid and detail=:detail";
        Map<String, Object> map = new HashMap<>();
        map.put("uid", userId);
        map.put("cid", commodityId);
        map.put("detail", detail);
        List<Cart> carts = cartDao.find(SQL, map);
        return carts.isEmpty() ? null : carts.get(0);
    }



}
