public class EquationDecorator extends PaperDecorator {
    public EquationDecorator(Paper paper) {
        super(paper);
    }
    public String write(){
        return super.write() + writeWithEquationDecorator();
    }
    public String writeWithEquationDecorator(){
        return "Equation";
    }
}
