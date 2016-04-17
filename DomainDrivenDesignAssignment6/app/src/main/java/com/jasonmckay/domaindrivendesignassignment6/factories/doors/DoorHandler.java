package com.jasonmckay.domaindrivendesignassignment6.factories.doors;

/**
 * Created by JasonMckay on 16-Apr-16.
 */
public abstract class DoorHandler {
    DoorHandler successor;

    public void setSuccessor(DoorHandler successor)
    {
        this.successor = successor;
    }

    public abstract String handleRequest(String request);
}
