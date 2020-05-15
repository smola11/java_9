package com.maciej.reactive.streams;

import com.maciej.reactive.streams.model.EmpHelper;
import com.maciej.reactive.streams.model.Employee;
import com.maciej.reactive.streams.model.Freelancer;

import java.util.List;
import java.util.concurrent.SubmissionPublisher;

public class MyReactiveAppWithProcessor {

    public static void main(String[] args) throws InterruptedException {

        // Create End Publisher
        SubmissionPublisher<Employee> publisher = new SubmissionPublisher<>();

        // Create Processor
        MyProcessor transformProcessor = new MyProcessor(employee -> {
            return new Freelancer(employee.getId(), employee.getId() + 100, employee.getName());
        });

        // Create end Subscriber
        MyFreelancerSubscriber subscriber = new MyFreelancerSubscriber();

        //Create chain of publisher, processor and subscriber
        publisher.subscribe(transformProcessor); // publisher to processor
        transformProcessor.subscribe(subscriber); // processor to subscriber

        List<Employee> employeeList = EmpHelper.getEmps();

        // Publish items
        System.out.println("Publishing items to Subscriber");
        employeeList.forEach(publisher::submit);

        // logic to wait till processing of all messages are over
        while (employeeList.size() != subscriber.getCounter()) {
            Thread.sleep(10);
        }

        // close publisher
        publisher.close();

        System.out.println("Exiting the app");
    }
}
