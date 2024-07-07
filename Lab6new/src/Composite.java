import java.util.ArrayList;
import java.util.List;

public class Composite extends Element{
    private List<Element> elementsList;
    public Composite(String path, double width, double length) {
        super(width, length, path);
        elementsList = new ArrayList<Element>();
    }
    public String getName() {
        return "Composite";
    }

    @Override
    public Habitat getHabitat() {
        return null;
    }

    public List<Element> getElementsList(){
        return this.elementsList;
    }

    @Override
    public void accept(ElementsVisitor v) {
        v.visit(this);
        for( Element e: elementsList){
            e.accept(v);
        }
    }
}
