public class ShortPrintVisitor implements ElementsVisitor{
    private String shortString;
    @Override
    public void visit(Flag flag) {
        shortString+= flag.getFullName()+ "\n";
    }

    @Override
    public void visit(Kid kid) {
        shortString += kid.getFullName() + "\n";
    }

    @Override
    public void visit(Lake lake) {
        shortString += lake.getFullName() + "\n";
    }

    @Override
    public void visit(Island island) {
        shortString += island.getFullName() + "\n";
    }

    @Override
    public void visit(Composite composite) {
        shortString+= composite.getFullName()+ "\n";
    }

    @Override
    public void visit(Boat boat) {
        shortString += boat.getFullName()+ "\n";
    }

    @Override
    public void visit(Kite kite) {
        shortString += kite.getFullName()+ "\n";
    }

    @Override
    public void visit(Tree tree) {
        shortString += tree.getFullName()+ "\n";
    }
    public void printString(){
        System.out.println("");
        System.out.println(shortString);
    }
}
