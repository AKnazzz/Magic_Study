package org.workwork.g_spring.homework_g6.work_1.example.listeners;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;

public class LogAttributeChanges implements ServletContextAttributeListener {

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        event.getServletContext().log(String.format("[LogAttributeChanges] Added new value of %s: %s", event.getName(), event.getValue()));
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        event.getServletContext().log(String.format("[LogAttributeChanges] New value of %s: %s", event.getName(), event.getValue()));
    }

}