public final class File implements Entry {

    private final String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public String ls() {
        return name;
    }
}

