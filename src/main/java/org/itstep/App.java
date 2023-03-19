package org.itstep;

import org.itstep.command.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        var commands = new HashMap<String, Command>();
        commands.put("help", new HelpCommand());
        commands.put("echo", new EchoCommand());
        commands.put("now", new NowCommand());
        commands.put("exit", new ExitCommand());
        Command command;
        var arguments = new String[0];
        var scanner = new Scanner(System.in);
        while (true) {
            System.out.print(">>> ");
            arguments = scanner.nextLine().trim().split(" ");
            try {
                command = commands.get(arguments[0]);
                if (command == null) {
                    throw new Exception("Error");
                }
                command.execute(Arrays.copyOfRange(arguments, 1, arguments.length));
            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
