package test;

import demo.calculator.Calc;
import demo.calculator.Command;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CalcTest {
    private String commandName;
    private double subject;
    private double argument;
    private double expected;

    private Calc instance;

    @Before
    public void setUp()
    {
        instance = new Calc();
    }

    @Test
    public void doMath()
    {
        Command command = new Command();
        boolean convertResult = command.fromString(commandName + " " + argument);

        assertEquals(expected, instance.doMath(subject, command), 0.0);
    }

    public CalcTest(String commandName, double subject, double argument, double expected)
    {
        this.commandName = commandName;
        this.subject = subject;
        this.argument = argument;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection primeNumbers()
    {
        return Arrays.asList(new Object[][] {
                { Command.ADD_COMMAND, 5, 7, 12},
                { Command.MULTIPLY_COMMAND, 5, 7, 35},
                { Command.DIVIDE_COMMAND, 10, 5, 2},
                { Command.SUBSTRACT_COMMAND, 5, 7, -2},
                { Command.APPLY_COMMAND, 5, 7, 5},
                // @todo unexpected command - shouldn't be here
                //{ "any", 8, 9, 8 },
        });
    }
}