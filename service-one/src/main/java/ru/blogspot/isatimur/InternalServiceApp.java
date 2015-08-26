package ru.blogspot.isatimur;


import org.apache.camel.main.Main;

/**
 * A Camel Application Entry Point
 * Created by tisachenko on 25.08.15.
 */
public class InternalServiceApp {

    public static void main(String... args) throws Exception {
        Main main = new Main();
        main.enableHangupSupport();

        main.addRouteBuilder(new InternalRoute());
        main.run(args);
    }
}
