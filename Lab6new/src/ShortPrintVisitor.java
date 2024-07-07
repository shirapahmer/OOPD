public class ShortPrintVisitor implements ElementsVisitor{
    @Override
    public void visit(Flag flag) {
        System.out.println(flag.getFullName());
    }

    @Override
    public void visit(Kid kid) {
        System.out.println(kid.getFullName());
    }

    @Override
    public void visit(Lake lake) {
        System.out.println(lake.getFullName());
    }

    @Override
    public void visit(Island island) {
        System.out.println(island.getFullName());
    }

    @Override
    public void visit(Composite composite) {
        System.out.println(composite.getFullName());
    }

    @Override
    public void visit(Boat boat) {
        System.out.println(boat.getFullName());
    }

    @Override
    public void visit(Kite kite) {
        System.out.println(kite.getFullName());
    }

    @Override
    public void visit(Tree tree) {
        System.out.println(tree.getFullName());
    }
}
