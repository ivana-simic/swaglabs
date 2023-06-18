package pages;

public class CartButton {

    public static String generateAddToCartButtonName(String itemName){
        return "add-to-cart-" + itemName.toLowerCase().replace(" ","-");
    }

    public static String generateRemoveFromCartButtonName(String itemName){
        return "remove-"+ itemName.toLowerCase().replace(" ","-");
    }

}
