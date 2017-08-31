import java.util.ArrayList;
import java.util.List;

public final class Directory implements Entry {

    private final String name;
    private final List<Entry> entries = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void add(Entry entry) {
        this.entries.add(entry);
    }

    @Override
    public String ls() {
        StringBuilder output = new StringBuilder();
        output.append(name).append(":\n");

        for (Entry entry : entries) {
            for (String line : entry.ls().split("\\n")) {
                output.append("    ").append(line).append('\n');
            }
        }
        return output.toString();
    }
}

