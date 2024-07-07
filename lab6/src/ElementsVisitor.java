public interface ElementsVisitor {
    public void visit(Flag flag);
    public void visit(Kid kid);
    public void visit(Lake lake);
    public void visit(Island island);
    public void visit(Composite composite);
    public void visit(Boat boat);
    public void visit(Kite kite);
}
