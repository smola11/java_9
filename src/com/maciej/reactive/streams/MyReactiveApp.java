package com.maciej.reactive.streams;

import com.maciej.reactive.streams.model.EmpHelper;
import com.maciej.reactive.streams.model.Employee;

import java.util.List;
import java.util.concurrent.SubmissionPublisher;

public class MyReactiveApp {

    public static void main(String[] args) throws InterruptedException {

        // Create Publisher
        SubmissionPublisher<Employee> publisher = new SubmissionPublisher<>();

        // Register Subscriber
        MySubscriber subscriber = new MySubscriber();
        publisher.subscribe(subscriber);

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
