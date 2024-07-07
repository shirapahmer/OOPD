 
public class Lake extends Composite {
    private String name;
    public Lake(String name, double diameter, String path) {
        super(path,diameter,diameter);
        this.name = name;

    }

    @Override
    public String getName() {
        return this.name;

    }

    @Override
    public Habitat getHabitat() {
        return Habitat.TERRESTRIAL;
    }

}
