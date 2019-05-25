package test;

import demo.calculator.Command;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CommandTest {
    private String commandString;
    private boolean expectedResult;
    private String expectedCommand;
    private double expectedArgument;

    @Test
    public void fromString()
    {
        Command command = new Command();
        boolean result = command.fromString(commandString);

        assertEquals(expectedResult, result);
        assertEquals(expectedCommand, command.getCommand());
        assertEquals(expectedArgument, command.getArgument(), 0.0);
    }

    public CommandTest(String commandString, boolean expectedResult, String expectedCommand, double expectedArgument)
    {
        this.commandString = commandString;
        this.expectedResult = expectedResult;
        this.expectedCommand = expectedCommand;
        this.expectedArgument = expectedArgument;
    }

    @Parameterized.Parameters
    public static Collection commandStack() {
        return Arrays.asList(new Object[][] {
                { "some 5 another", false, null, 0 },
                { "add 5 another", true, "add", 5 },
                { "multiply 5 another", true, "multiply", 5 },
                { "apply 5 another", true, "apply", 5 },
                { "divide 58.3 another", true, "divide", 58.3 },
                { "substract 58.3 another", true, "substract", 58.3 },
        });
    }
}