package core;

import core.beans.Client;
import core.loggers.EventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    private Client client;
    private EventLogger eventLogger;

    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        App app = (App) context.getBean("app");

        app.logEvent("Event 1: ");
        app.logEvent("Event 2: ");
    }

    public void logEvent(String msg) {
        String message = msg + client.getId() + " " + client.getFullName();
        eventLogger.logEvent(message);
    }
}
