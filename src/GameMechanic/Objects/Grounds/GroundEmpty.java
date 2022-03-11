package GameMechanic.Objects.Grounds;

public class GroundEmpty extends Ground {
    public GroundEmpty(int xOnWorld, int yOnWorld) {
        super(xOnWorld, yOnWorld);
        this.icon = null;
        this.name = NAME_EMPTY;
    }

    @Override
    public void recovery() {
        icon = null;
    }
}
