import java.util.List;

public class EcbTradeFeed extends AbstractTradeFeed {

    @Override
    List<Trade> filter(List<Trade> trades) {
        return trades;
    }

    @Override
    String getHeader() {
        return "European Central Bank Trade Feed\n" +
               "TRADE_ID,RIC,PRICE,QUANTITY\n";
    }

    @Override
    String getBody(List<Trade> trades) {
        StringBuilder body = new StringBuilder();
        for (Trade trade : trades) {
            body.append(trade.getId())
                .append(',')
                .append(trade.getStockCode())
                .append(',')
                .append(trade.getPrice())
                .append(',')
                .append(trade.getQuantity())
                .append('\n');
        }
        return body.toString();
    }

    @Override
    String getFooter(int feedSize) {
        return "RECORD_COUNT:" + feedSize + "\n";
    }
}

