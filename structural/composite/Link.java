public final class Link implements Entry {

    private final String name;
    private final String target;

    public Link(String name, String target) {
        this.name = name;
        this.target = target;
    }

    @Override
    public String ls() {
        return name + " => " + target;
    }
}

