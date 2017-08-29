public final class Trade {

    private final int id;
    private final String stockCode;
    private final double price;
    private final int quantity;

    public Trade(int id, String stockCode, double price, int quantity) {
        this.id = id;
        this.stockCode = stockCode;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return this.id;
    }

    public String getStockCode() {
        return this.stockCode;
    }

    public double getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }
}

