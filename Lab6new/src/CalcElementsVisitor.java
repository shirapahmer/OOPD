public class CalcElementsVisitor implements ElementsVisitor{
    private int numElements =0;
    @Override
    public void visit(Flag flag) {
        this.numElements += 1;
    }

    @Override
    public void visit(Kid kid) {
        this.numElements += 1;
    }

    @Override
    public void visit(Lake lake) {
        this.numElements += 1;
    }

    @Override
    public void visit(Island island) {
        this.numElements += 1;
    }

    @Override
    public void visit(Composite composite) {
        this.numElements += 1;
    }

    @Override
    public void visit(Boat boat) {
        this.numElements += 1;
    }

    @Override
    public void visit(Kite kite) {
        this.numElements += 1;
    }

    @Override
    public void visit(Tree tree) {
        this.numElements += 1;
    }

    public int getNumberElements(){
        return this.numElements;
    }
}
