package org.itstep.command;

public class NowCommand implements Command {
    @Override
    public void execute(String... args) throws Exception {
        if (args.length != 0) {
            throw new Exception("Error: Unknown args");
        }
        System.out.println(System.currentTimeMillis());
    }
}
