import java.util.List;
import java.util.stream.Collectors;

public class FcaTradeFeed extends AbstractTradeFeed {

    @Override
    List<Trade> filter(List<Trade> trades) {
        return trades.stream().filter(t -> t.getStockCode().endsWith(".L"))
                              .collect(Collectors.toList());
    }

    @Override
    String getHeader() {
        return "Financial Conduct Authority Trade Feed\n" +
               "TRADE_ID^STOCK_CODE^AMOUNT\n";
    }

    @Override
    String getBody(List<Trade> trades) {
        StringBuilder body = new StringBuilder();
        for (Trade trade : trades) {
            body.append(trade.getId())
                .append('^')
                .append(trade.getStockCode())
                .append('^')
                .append(trade.getQuantity() * trade.getPrice())
                .append('\n');
        }
        return body.toString();
    }

    @Override
    String getFooter(int feedSize) {
        return "TOTAL_COUNT:" + feedSize + "\n";
    }
}

