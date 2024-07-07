public class calcAreaVisitor implements ElementsVisitor{
    private double totalArea = 0;

    public void visit(Flag flag){
        double area = flag.length * flag.width;
        totalArea += area;
    }
    public void visit(Kid kid){
        double bodyLength = kid.length - kid.width;
        double headRadius = kid.width /2;
        totalArea += (bodyLength*kid.width) + (Math.PI * (headRadius * headRadius));
    }
    public void visit(Lake lake){
        double radius = lake.length / 2;
        double area = Math.PI * radius * radius;
        totalArea += area;
    }
    public void visit(Island island){
        totalArea += Math.PI * (island.length/2) * (island.length/2);
    }
    public void visit(Composite composite){
        if(composite.getClass() == Island.class) {
            visit((Island)composite);
        }
        else if(composite.getClass() == Lake.class) {
            visit((Lake)composite);
        }
    }

    public void visit(Boat boat){
        double radius = boat.width / 2;
        double SemiCircleArea = (Math.PI * radius * radius)/2;
        double rectangleLength = boat.length - radius;
        double rectangleArea = rectangleLength * boat.width;
        totalArea += rectangleArea+SemiCircleArea;
    }
    public void visit(Kite kite){
        totalArea += (kite.length * kite.width)/2;
    }

    @Override
    public void visit(Tree tree) {
        totalArea += (tree.length * tree.width)/2;
    }

    public double getTotalArea(){
        return (int) Math.round(totalArea);
    }
}
