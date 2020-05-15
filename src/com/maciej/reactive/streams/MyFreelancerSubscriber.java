package com.maciej.reactive.streams;

import com.maciej.reactive.streams.model.Employee;
import com.maciej.reactive.streams.model.Freelancer;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class MyFreelancerSubscriber implements Subscriber<Freelancer> {

    private Subscription subscription;
    private int counter;

    @Override
    public void onSubscribe(Subscription subscription) {
        System.out.println("Subscribed for Freelancer");
        this.subscription = subscription;
        this.subscription.request(1); //requesting data from publisher
        System.out.println("onSubscribe requested 1 item for Freelancer");
    }

    @Override
    public void onNext(Freelancer item) {
        System.out.println("Processing Freelancer: " + item);
        System.out.println("Subscriber thread: " + Thread.currentThread().getName());
        counter++;
        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable e) {
        System.out.println("Some error happened");
        e.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("All Processing Done for MyFreelancerSubscriber");
    }

    int getCounter() {
        return counter;
    }
}
