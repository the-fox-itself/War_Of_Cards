package Client.Objects.GameObjects;

import static Client.Mechanic.MainVariables.colorStartPictureRed;

public class ObjectBarrier extends GameObject {
    public ObjectBarrier() {
        System.out.println("Creating object of class ObjectBarrier...");
        width = 8;
        height = 8;
        color = colorStartPictureRed;
        name = "Barrier";
        System.out.println("Finished creating object of class ObjectBarrier.");
        System.out.println("Created object " + name + ": xOnFrame: " + xOnFrame + ", yOnFrame: " + yOnFrame + ", width: " + width + ", height: " + height + ", color: " + color + ", iconOfFar: " + iconOfFar + ", iconOfNearby: " + iconOfNearby);
    }

    @Override
    public void recovery() {
        iconOfFar = null;
        iconOfNearby = null;
    }
}
