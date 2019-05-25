package demo.calculator;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import java.util.ArrayList;
import java.util.List;

/**
 * Generic network listener to perform math operations
 */
public class NetworkReader {

    private static final String EXIT_COMMAND = "bye";

    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("Use port number as argument.");
            return;
        }

        int port = Integer.parseInt(args[0]);

        // math operations
        Calc calculator = new Calc();
        double result;

        // buffered input
        String inputText;

        // commands processing related group
        List<Command> commandStack = new ArrayList<>();

        try (ServerSocket serverSocket = new ServerSocket(port)) {

            System.out.println("Listen on port: " + port);

            while (true) {
                Socket socket = serverSocket.accept();

                // channels init
                InputStream input = socket.getInputStream();
                OutputStream output = socket.getOutputStream();

                // communication buffers
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                PrintWriter writer = new PrintWriter(output, true);

                do {
                    inputText = reader.readLine();

                    if (inputText.equals(EXIT_COMMAND)) {
                        break;
                    }

                    Command command = new Command();
                    Command current;

                    if (!command.fromString(inputText)) {
                        writer.println("Invalid command: " + inputText);
                        continue;
                    }

                    // fill commands stack
                    if (!command.getCommand().equals(Command.APPLY_COMMAND)) {
                        commandStack.add(0, command);
                        writer.println("Command \"" + command.getCommand() + "\" arg: \"" + command.getArgument() + "\"");

                        continue;
                    }

                    // final command "apply" - run commands from stack
                    result = command.getArgument();

                    writer.println("Stack size: " + commandStack.size());
                    while (commandStack.size() > 0) {
                        current = commandStack.get(commandStack.size() - 1);
                        commandStack.remove(commandStack.size() - 1);

                        result = calculator.doMath(result, current);

                        writer.println("Used command \"" + current.getCommand() + "\" result: " + result);
                    }

                    writer.println("Final result: " + result);

                } while (true);

                socket.close();
            }

        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        } catch (NullPointerException ex) {
            System.out.println("Null pointer exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
