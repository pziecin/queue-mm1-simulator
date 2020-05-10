package com.company;

import com.company.eventstructure.EventAxis;
import com.company.eventstructure.Generator;

public class Main {

    public static void main(String[] args) {

        int serverIterations = 10;
        int eventsNumber = 100;
        double serverTime = 0.0;
        for(int i=0; i<serverIterations; i++) {
            EventAxis eventAxis = new EventAxis();
            Generator server = new Generator(eventAxis, 0.5);
            double serverOneTime = (double) server.startGenerator(eventsNumber) / serverIterations;
            serverTime = serverTime + serverOneTime;
            System.out.println("ServerTIme: " + serverTime);
            System.out.println("One iteration: " + serverOneTime);
        }
        System.out.println("Average Time: " + serverTime / serverIterations);
    }
}
