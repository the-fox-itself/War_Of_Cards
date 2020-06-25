package Client.Objects.GameObjects;

import Client.Mechanic.MainGUIVariables;

import static Client.Mechanic.MainGUIVariables.COLOR_OBJECT_BARRIER;

public class ObjectBarrier extends GameObject {
    public ObjectBarrier(int xOnFrame, int yOnFrame) {
        System.out.println("Creating object of class ObjectBarrier...");
        width = 8;
        height = 8;
        this.xOnFrame = xOnFrame;
        this.yOnFrame = yOnFrame;
        xOnWorld = xOnFrame - MainGUIVariables.playerXFrame;
        yOnWorld = yOnFrame - MainGUIVariables.playerYFrame;
        color = COLOR_OBJECT_BARRIER;
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
