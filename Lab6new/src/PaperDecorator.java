public abstract class PaperDecorator implements Paper {
    private Paper paper;
    public PaperDecorator(Paper paper) {
        this.paper = paper;
    }
    public String write(){
        return paper.write();
    }



}
