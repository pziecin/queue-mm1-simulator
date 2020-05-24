package com.company.eventstructure;

import java.util.Random;

public class Generator {
    private static int mi = 8;
    private static int miTime = 125;
    private double lamba;

    private EventAxis eventAxis;

    public Generator(EventAxis eventAxis, double lamba) {
        this.eventAxis = eventAxis;
        this.lamba = lamba;
    }

    public double startGenerator(int eventsNumber){
        for(int i=0; i<eventsNumber; i++) {
            Random randEvent = new Random();
            double condition = lamba/(mi+lamba);
            double whichEvent = randEvent.nextDouble();

            if(i == 10000){
                eventAxis.setReferenceTime(0);
            }
            if(whichEvent < condition) {
                Event event = createEvent();
                eventAxis.putEvent(event);
            }else{
                Event event = eventAxis.getEvent();
                if(event == null)
                    continue;
                eventAxis.updateReferenceTime(event.getTime() + generateTime(mi));
            }

        }
        return eventAxis.getReferenceTime();
    }

    private Event createEvent(){
        double time = generateTime(lamba);
//        System.out.println("CZAS: " + time);
        return new Event(time, Event.EventType.PAKET);
    }

    public double test(int seires, double lamba){
        double time = 0.0;
        for(int i =0;i<100;i++) {
            time = time + generateTime(lamba);
        }
        return time;
    }

    private double generateTime(double lamba){
        Random randomizer = new Random();
        Double randNumber = randomizer.nextDouble();
//        System.out.println("DOUBLE RAND: "+ randNumber);
        double time = -(1/lamba)* Math.log(1-randNumber);
        return time;
    }
}
