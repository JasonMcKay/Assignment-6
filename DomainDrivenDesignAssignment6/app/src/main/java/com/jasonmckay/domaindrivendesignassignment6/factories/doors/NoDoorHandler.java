package com.jasonmckay.domaindrivendesignassignment6.factories.doors;

/**
 * Created by JasonMckay on 16-Apr-16.
 */
public class NoDoorHandler extends DoorHandler {
    @Override
    public String handleRequest(String request) {
        if(request.equalsIgnoreCase("No doors"))
        {
            return "No doors";
        }
        else
        {
            return successor.handleRequest(request);
        }
    }
}
