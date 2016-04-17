package com.jasonmckay.domaindrivendesignassignment6.factories.doors;

/**
 * Created by JasonMckay on 16-Apr-16.
 */
public class FourDoorHandler extends DoorHandler {
    @Override
    public String handleRequest(String request) {
        if(request.equalsIgnoreCase("Four door"))
        {
            return "Four door";
        }
        else
        {
            return successor.handleRequest(request);
        }
    }
}
