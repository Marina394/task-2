package ru.ccfit.idrisova.task2;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;
import java.util.logging.Logger;

public class Calculator {
    private static Logger logger = Logger.getLogger(Main.class.getName());

    public void calculate(BufferedReader reader){
        Fabric fabric;
        try {
            fabric = new Fabric();
            logger.info("Created map commands");
        }catch (Exception exp){
            logger.info(exp.getMessage());
            return;
        }
        String line;
        Context context = new Context();
        while(true) {
            try {
                if((line = reader.readLine()) == null)
                    break;
                if(line.isEmpty())
                    break;
                logger.info("Read command");
                if (line.startsWith("#"))
                    continue;
                String[] commandLine = line.split(" ");
                Command command = fabric.createCommand(commandLine);
                logger.info("Created command");
                List<String> list = Arrays.asList(commandLine);
                command.calculate(context, list);
                logger.info("Command executed");
            }catch (Exception exp) {
                logger.info(exp.getMessage());
            }
        }
    }
}