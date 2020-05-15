package com.maciej.reactive.streams;

import com.maciej.reactive.streams.model.Employee;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class MySubscriber implements Subscriber<Employee> {

    private Subscription subscription;
    private int counter;

    @Override
    public void onSubscribe(Subscription subscription) {
        System.out.println("Subscribed");
        this.subscription = subscription;
        this.subscription.request(1); //requesting data from publisher
        System.out.println("onSubscribe requested 1 item");
    }

    @Override
    public void onNext(Employee item) {
        System.out.println("Processing employee: " + item);
        System.out.println("Subscriber thread: " + Thread.currentThread().getName());
        counter++;
//        if (counter == 3) {
//            this.subscription.cancel();
//            return;
//        }
        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable e) {
        System.out.println("Some error happened");
        e.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("All Processing Done");
    }

    int getCounter() {
        return counter;
    }
}
