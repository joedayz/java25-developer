package org.example;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Test {

    private static Logger logger =
            Logger.getLogger(org.example.Test.class.getName());


    public static void main(String[] args) {
        logger.setLevel(Level.FINE);


        Logger rootLogger = Logger.getLogger("");
        for (Handler handler : rootLogger.getHandlers()) {
            handler.setLevel(Level.FINE);
        }


        try {
            /* actions */
            int id = 5;
            logger.log(Level.FINE, "Product " + id + " has been selected");

            if(logger.isLoggable(Level.FINER)){
                logger.log(Level.FINE, "Product " + id + " has been selected");
            }

            logger.log(Level.FINE, "Product {0} has been selected", id);

        } catch(Exception e){
            logger.log(Level.SEVERE, "Your message error", e);
        }
        logger.log(Level.INFO, "Your message style 1");
        logger.info("Your message style 2");
    }
}
