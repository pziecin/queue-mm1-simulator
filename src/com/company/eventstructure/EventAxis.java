package com.company.eventstructure;

import java.util.ArrayList;
import java.util.List;

public class EventAxis {

    private List<Event> eventAxis;
    private int eventsCounter;
    private double referenceTime;

    public int getEventsCounter() {
        return eventsCounter;
    }

    private void addCount () {
        this.eventsCounter += 1;
    }

    public List<Event> getEventAxis() {
        return eventAxis;
    }

    public void setEvent(List<Event> event) {
        this.eventAxis = event;
    }

    public void setReferenceTime(int referenceTime) {
        this.referenceTime = referenceTime;
    }

    public double getReferenceTime() {
        return referenceTime;
    }

    public void updateReferenceTime(double referenceTime) {
        this.referenceTime = this.referenceTime + referenceTime;
    }



    public EventAxis() {
        this.eventAxis = new ArrayList<>();
        this.eventsCounter = 0;
        this.referenceTime = 0;
    }

    public void putEvent(Event event){
        eventAxis.add(event);
        addCount();
    }

    public Event getEvent(){
        if(!eventAxis.isEmpty())
            return eventAxis.remove(0);
        return null;
    }
}
