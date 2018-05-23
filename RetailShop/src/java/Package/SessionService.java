package Package;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import javax.servlet.http.HttpSession;

/**
 *
 * @author junnguyen
 */
public class SessionService {

    private final HttpSession httpSession;

    public SessionService(HttpSession httpSession) {
        this.httpSession = httpSession;
    }

    public ArrayList<Product> getCart() {
        ArrayList<Product> cartList = (ArrayList<Product>) httpSession.getAttribute("cart");

        if (cartList == null) {
            cartList = new ArrayList<Product>();
        }
        return cartList;
    }

    public void addCart(Product p) {
        p.setQuantityProduct(1);
        ArrayList<Product> cartList = (ArrayList<Product>) httpSession.getAttribute("cart");
        if (cartList == null) {
            cartList = new ArrayList<Product>();
            cartList.add(p);
        } else {
            for (Product tmpP : cartList) {
                if (tmpP.getIdProduct() == p.getIdProduct()) {
                    removeItemFromCart(tmpP.getIdProduct(), cartList);
                    Integer newQuantitty = tmpP.getQuantityProduct() + 1;
                    p.setQuantityProduct(newQuantitty);
                    break;
                }
            }
            cartList.add(p);
        }
        httpSession.setAttribute("cart", cartList);
    }

    public void removeItemFromCart(Integer pid, ArrayList<Product> cart) {
        ArrayList<Product> itemBin = new ArrayList<Product>();
        for (Product p : cart) {
            if (p.getIdProduct() == pid) {
                itemBin.add(p);
            }
        }
        cart.removeAll(itemBin);
        httpSession.setAttribute("cart", cart);
    }
}
