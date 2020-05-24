package com.company;

import com.company.eventstructure.EventAxis;
import com.company.eventstructure.Generator;

public class Main {

    public static void main(String[] args) {

        int serverIterations = 100;
        int eventsNumber = 10000;
        double lamba = 0.5;
        double serverTime = 0.0;
        double serverTimeEvent = 0.0;
        double latencyAverag = 0.0;
        double testavg = 0.0;

        for (int i = 0; i < serverIterations; i++) {
            EventAxis eventAxis = new EventAxis();
            Generator server = new Generator(eventAxis, lamba);
            double servers = server.startGenerator(eventsNumber);
            testavg = testavg + server.test(1000, lamba);
            System.out.println(servers + "servers");
            double serverOneTime = servers / serverIterations;
            double serverOneTimeEventsAverage = servers / eventAxis.getEventsCounter();
            serverTime = serverTime + serverOneTime;
            serverTimeEvent = serverTimeEvent + serverOneTimeEventsAverage;
            double latency = (double) eventAxis.getEventsCounter()/eventsNumber;
            latencyAverag += latency;
            System.out.println("One iteration: " + serverOneTime);
            System.out.println("ServerTIme" + "{" + i + "}: " + serverTime);
            System.out.println("Opoznienie? " + latency);
            System.out.println("EVENT COUNTER: " + eventAxis.getEventsCounter() + " average EVENTS :" + serverOneTimeEventsAverage);
        }
        System.out.println("TEST AVG " + testavg/serverIterations);
        System.out.println("Average Time: " + serverTime / serverIterations);
        System.out.println("Average Time: " + serverTimeEvent / serverIterations);
        System.out.println("Average Latency: " + latencyAverag/ serverIterations);

    }
}
