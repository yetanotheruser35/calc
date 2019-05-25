package demo.calculator;

import java.util.Arrays;
import java.util.List;

public class Command {
    public static final String ADD_COMMAND = "add";
    public static final String MULTIPLY_COMMAND = "multiply";
    public static final String DIVIDE_COMMAND = "divide";
    public static final String SUBSTRACT_COMMAND = "substract";
    public static final String APPLY_COMMAND = "apply";

    private String command;
    private double argument;

    /**
     * Strictly defined commands stack
     */
    private String[] registeredCommands = new String[]{
            ADD_COMMAND,
            MULTIPLY_COMMAND,
            DIVIDE_COMMAND,
            SUBSTRACT_COMMAND,
            APPLY_COMMAND,
    };

    /**
     * Getter for command name
     *
     * @return String
     */
    public String getCommand()
    {
        return command;
    }

    /**
     * Getter for command argument
     * @return double
     */
    public double getArgument()
    {
        return argument;
    }

    /**
     * Converts general string to normalized command
     *
     * @param inputText String
     * @return boolean
     */
    public boolean fromString(String inputText)
    {

        List<String> list = Arrays.asList(registeredCommands);
        String buffer;

        // delimiter is any space
        String[] parts = inputText.split("\\s+");

        for (int i = 0; i < parts.length; i++) {
            // convert anyway - numbers won't be converted
            buffer = parts[i].toLowerCase();

            // first part - command name
            if (i == 0) {
                if (!list.contains(buffer)) {
                    return false;
                }
                this.command = buffer;

                continue;
            }

            // second parameter is any floating point number
            if (i == 1) {
                if (!buffer.matches("^\\d+(\\.\\d+)?$")) {
                    return false;
                }

                this.argument = Double.valueOf(buffer);
            }

            // any other comment in command line is ok
            break;
        }

        return true;
    }
}
