package com.observer;

public class Main {
    public static void main(String[] args) {
        // Crear el sujeto
        ConcreteSubject subject = new ConcreteSubject();
        //observersss
        ConcreteObserver observer1 = new ConcreteObserver("Observer 1");
        ConcreteObserver observer2 = new ConcreteObserver("Observer 2");

        // add subs to subjets
        subject.addObserver(observer1);
        subject.addObserver(observer2);

        // change state of subject
        subject.setState("New State 1");
        subject.setState("New State 2");
    }
}
