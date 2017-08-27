import java.util.Stack;

public class TextFormEditor {

    private final TextForm textForm = new TextForm();
    private final Stack<TextForm.Memento> undo = new Stack<>();

    public String getTitle() {
        return textForm.getTitle();
    }

    public String getText() {
        return textForm.getText();
    }

    public String getAuthor() {
        return textForm.getAuthor();
    }

    public void changeTitle(String newTitle) {
        undo.push(this.textForm.getState());
        this.textForm.setTitle(newTitle);
    }

    public void changeText(String newText) {
        undo.push(this.textForm.getState());
        this.textForm.setText(newText);
    }

    public void changeAuthor(String newAuthor) {
        undo.push(this.textForm.getState());
        this.textForm.setAuthor(newAuthor);
    }

    public void appendText(String text) {
        undo.push(this.textForm.getState());
        this.textForm.setText(this.textForm.getText() + text);
    }

    public void undo() {
        if (!undo.empty()) {
            this.textForm.restoreState(undo.pop());
        }
    }
}

