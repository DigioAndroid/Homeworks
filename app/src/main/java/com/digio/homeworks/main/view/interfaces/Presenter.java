package com.digio.homeworks.main.view.interfaces;

/**
 * Created by Isidoro on 1/3/17.
 */

public interface Presenter {

    void create();

    /**
     * Start method from presenter's lifecycle
     */
    void start();

    void stop();

    void destroy();
}
