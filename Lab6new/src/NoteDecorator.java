public class NoteDecorator extends PaperDecorator{
    public NoteDecorator(Paper paper) {
        super(paper);
    }
    public String write(){
        return super.write() + writeWithNoteDecorator();
    }
    public String writeWithNoteDecorator(){
        return " Note";
    }
}
