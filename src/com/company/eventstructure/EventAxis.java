package com.company.eventstructure;

import java.util.ArrayList;
import java.util.List;

public class EventAxis {

    private List<Event> eventAxis;
    private int referenceTime;

    public List<Event> getEventAxis() {
        return eventAxis;
    }

    public void setEvent(List<Event> event) {
        this.eventAxis = event;
    }

    public void setReferenceTime(int referenceTime) {
        this.referenceTime = referenceTime;
    }

    public int getReferenceTime() {
        return referenceTime;
    }

    public void updateReferenceTime(int referenceTime) {
        this.referenceTime = this.referenceTime + referenceTime;
    }



    public EventAxis() {
        this.eventAxis = new ArrayList<>();
        this.referenceTime = 0;
    }

    public void putEvent(Event event){
        eventAxis.add(event);
    }

    public Event getEvent(){
        if(!eventAxis.isEmpty())
            return eventAxis.remove(0);
        return null;
    }
}
