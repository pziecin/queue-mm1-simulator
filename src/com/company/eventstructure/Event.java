package com.company.eventstructure;

public class Event {

    public enum EventType {
        PAKET,
        BREAK,
        END
    }

    private int time;
    private EventType eventType;

    public Event(int time, EventType eventType) {
        this.time = time;
        this.eventType = eventType;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }
}
