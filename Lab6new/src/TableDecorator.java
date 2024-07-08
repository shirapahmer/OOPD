public class TableDecorator extends PaperDecorator{
    public TableDecorator(Paper paper) {
        super(paper);
    }
    public String write(){
        return super.write() + writeWithTableDecorator();
    }
    public String writeWithTableDecorator(){
        return "Table";
    }

}
