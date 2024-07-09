public class DiagramDecorator extends PaperDecorator {
    public DiagramDecorator(Paper paper) {
        super(paper);
    }
    public String write(){
        return super.write() + writeWithDiagramDecorator();
    }
    public String writeWithDiagramDecorator(){
        return " Diagram";
    }
}
