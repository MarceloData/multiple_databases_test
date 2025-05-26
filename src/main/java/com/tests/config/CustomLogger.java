package com.tests.config;

import org.jboss.logging.Logger;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CustomLogger {

    private static final Logger log = Logger.getLogger(CustomLogger.class);

    public void info(String msg) {
        log.info(msg);
    }

    public void warn(String msg) {
        log.warn(msg);
    }

    public void error(String msg, Throwable t) {
        log.error(msg, t);
    }

    public void debug(String msg) {
        log.debug(msg);
    }
}
