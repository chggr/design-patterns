public final class StockPriceEvent {

    private final String stockCode;
    private final double stockPrice;

    public StockPriceEvent(String stockCode, double stockPrice) {
        this.stockCode = stockCode;
        this.stockPrice = stockPrice;
    }

    public String getStockCode() {
        return this.stockCode;
    }

    public double getStockPrice() {
        return this.stockPrice;
    }
}

