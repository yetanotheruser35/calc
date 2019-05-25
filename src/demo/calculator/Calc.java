package demo.calculator;

public class Calc {

    /**
     * Run generic math operation based on command
     *
     * @param subject double
     * @param command Command
     * @return double
     */
    public double doMath(double subject, Command command)
    {
        Math math = new Math();

        switch (command.getCommand()) {
            case Command.ADD_COMMAND:
                return math.sum(subject, command.getArgument());
            case Command.MULTIPLY_COMMAND:
                return math.mult(subject, command.getArgument());
            case Command.DIVIDE_COMMAND:
                return math.div(subject, command.getArgument());
            case Command.SUBSTRACT_COMMAND:
                return math.subst(subject, command.getArgument());
            default:
                return subject;
        }
    }
}
