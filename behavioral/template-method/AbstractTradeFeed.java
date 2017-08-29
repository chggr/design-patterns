import java.util.List;

public abstract class AbstractTradeFeed {

    public String generate(List<Trade> trades) {
        List<Trade> filteredTrades = filter(trades);

        StringBuilder feed = new StringBuilder();
        feed.append(getHeader());
        feed.append(getBody(filteredTrades));
        feed.append(getFooter(filteredTrades.size()));
        return feed.toString();
    }

    abstract String getHeader();
    abstract String getFooter(int feedSize);
    abstract String getBody(List<Trade> trades);
    abstract List<Trade> filter(List<Trade> trades);
}

