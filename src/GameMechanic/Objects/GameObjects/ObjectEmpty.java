package GameMechanic.Objects.GameObjects;

public class ObjectEmpty extends GameObject {
    public ObjectEmpty(int xOnWorld, int yOnWorld) {
        this.xOnWorld = xOnWorld;
        this.yOnWorld = yOnWorld;
        this.name = NAME_EMPTY;
        System.out.println("Created object "+name+" [width: "+width+", height: "+height+", xOnWorld: "+this.xOnWorld+", yOnWorld: "+this.yOnWorld+", color: "+color+", iconOfFar: "+iconOfFar+", iconOfNearby: "+iconOfNearby+"]");
    }

    @Override
    public void recovery() {
        iconOfFar = null;
        iconOfNearby = null;
    }
}
