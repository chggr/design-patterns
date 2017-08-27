public final class TextForm {

    private String title = "";
    private String text = "";
    private String author = "";

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Memento getState() {
        return new Memento(title, text, author);
    }

    public void restoreState(Memento memento) {
        this.title = memento.title;
        this.text = memento.text;
        this.author = memento.author;
    }

    public static final class Memento {

        private final String title;
        private final String text;
        private final String author;

        public Memento(String title, String text, String author) {
            this.title = title;
            this.text = text;
            this.author = author;
        }
    }
}

