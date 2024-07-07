 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Painting {
    Map<String, Element> pathToElementMap;
    List<Element> elementList;
    Painting(){
        elementList=new ArrayList<>();
        pathToElementMap = new HashMap<>();
    }
    public void addElement(Element element){
        pathToElementMap.put(element.getFullName(), element);
        if (element.getPath().isEmpty()){
            elementList.add(element);
        }
        else {
            Element containingElement = pathToElementMap.get(element.getPath());
			if (element.getHabitat() == Habitat.AQUATIC && containingElement.getClass() == Lake.class){
                    ((Lake) containingElement).getElementsList().add(element);
                }
            else if( element.getHabitat() == Habitat.TERRESTRIAL && containingElement.getClass() == Island.class){
                ((Island) containingElement).getElementsList().add(element);
            }
            //TEST THIS WITH CONTAINIGELEM IS A COMPOSITE
            else if( element.getHabitat() == Habitat.AMPHIBIAN && (containingElement.getClass() == Lake.class || containingElement.getClass() == Island.class)){
                ((Composite) containingElement).getElementsList().add(element);
            }
        }
    }

    public String getName() {
        return Painting.class.getSimpleName().toLowerCase();
    }


}
