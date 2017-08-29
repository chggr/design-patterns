import java.util.List;

public class FedTradeFeed extends AbstractTradeFeed {

    @Override
    List<Trade> filter(List<Trade> trades) {
        return trades;
    }

    @Override
    String getHeader() {
        return "Federal Reserve Bank Trade Feed\n" +
               "TRADE_ID~RIC~QUANTITY\n";
    }

    @Override
    String getBody(List<Trade> trades) {
        StringBuilder body = new StringBuilder();
        for (Trade trade : trades) {
            body.append(trade.getId())
                .append('~')
                .append(trade.getStockCode())
                .append('~')
                .append(trade.getQuantity())
                .append('\n');
        }
        return body.toString();
    }

    @Override
    String getFooter(int feedSize) {
        return "FEED_SIZE:" + feedSize + "\n";
    }
}

