package com.company.eventstructure;

import java.util.Random;

public class Generator {
    private static int mi = 8;
    private double lamba;

    private EventAxis eventAxis;

    public Generator(EventAxis eventAxis, double lamba) {
        this.eventAxis = eventAxis;
        this.lamba = lamba;
    }

    public int startGenerator(int eventsNumber){
        for(int i=0; i<eventsNumber; i++) {
            Random randEvent = new Random();
            double condition = lamba/(mi+lamba);
            double whichEvent = randEvent.nextDouble();

            if(whichEvent < condition) {
                Event event = createEvent();
                eventAxis.putEvent(event);
            }else{
                Event event = eventAxis.getEvent();
                if(event == null)
                    continue;
                eventAxis.updateReferenceTime(event.getTime());
            }
        }
        return eventAxis.getReferenceTime();
    }

    private Event createEvent(){
        int time = (int) generateTime();
        return new Event(time, Event.EventType.PAKET);
    }

    private double generateTime(){
        Random randomizer = new Random();
        Double randNumber = randomizer.nextDouble();
        System.out.println("DOUBLE RAND: "+ randNumber);
        double lamba = 0.5;
        double time = -(1/lamba)* Math.log(1-randNumber);
        System.out.println("CZAS: " + time);
        return time;
    }
}
