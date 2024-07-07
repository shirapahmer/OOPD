
public class Island extends Composite {
    private String name;
    public Island(String name, double diameter, String path) {
        super(path,diameter,diameter);
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Habitat getHabitat() {
        return Habitat.AQUATIC;
    }


}
