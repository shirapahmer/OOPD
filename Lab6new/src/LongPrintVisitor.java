import java.time.Year;

public class LongPrintVisitor implements ElementsVisitor{
    @Override
    public void visit(Flag flag) {
        System.out.print("A flag with color: " +flag.getColor().toString().toLowerCase()+" of height "+(int)(flag.getCarrierHeight())+". ");
    }

    @Override
    public void visit(Kid kid) {
        int age = Year.now().getValue() - kid.getBirthYear();
        System.out.print("A "+ age + " year old kid with "+(kid.getHairColor()).toString().toLowerCase()+" hair. ");
    }

    @Override
    public void visit(Lake lake) {
        if (lake.getElementsList().isEmpty()) {
            System.out.print("A empty lake named "+lake.getName()+". ");
        }
        else {
            System.out.print("A lake named "+lake.getName() +" containing: ");
        }
    }

    @Override
    public void visit(Island island) {
        if (island.getElementsList().isEmpty()) {
            System.out.print("An empty island named "+island.getName()+". ");
        }
        else {
            System.out.print("An island named "+island.getName() +" containing: ");
        }
    }

    @Override
    public void visit(Composite composite) {
        if(composite.getClass() == Island.class) {
            visit((Island)composite);
        }
        else if(composite.getClass() == Lake.class) {
            visit((Lake)composite);
        }
    }

    @Override
    public void visit(Boat boat) {
        System.out.print("A boat made of "+boat.getMaterial().toString().toLowerCase() + " material. ");
    }

    @Override
    public void visit(Kite kite) {
        System.out.print("A kite of color: " +kite.getColor().toString().toLowerCase() + ". ");
    }

    @Override
    public void visit(Tree tree) {
        System.out.print("A tree with an amount of "+ tree.leavesAmount+" leaves. ");
    }
}
