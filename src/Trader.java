public class Trader implements Seller {

    @Override
    public String sell(Trader.Goods goods) {
        String result = "";
        if (goods == Goods.POTION) {
            return "potion";
        } else return result;
    }

    public enum Goods {
        POTION
    }
}
