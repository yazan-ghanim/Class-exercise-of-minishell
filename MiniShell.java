import java.util.Scanner;

public class MiniShell {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShellCommandHandler handler = new ShellCommandHandler();

        System.out.println("Welcome to MiniShell! Type 'help' for a list of commands.");

   while (true) {
            System.out.print(handler.getCurrentDirectory().getAbsolutePath() + " > ");
            String input = scanner.nextLine().trim();
            String[] parts = input.split(" ", 2);
            String command = parts[0];
            String argument = parts.length > 1 ? parts[1] : null;
       
// ----------------------------------------------
       
            if (command.equals("pwd")) {
                handler.printWorkingDirectory();
            } else if (command.equals("ls")) {
                handler.listDirectory();
            } else if (command.equals("cd")) {
                handler.changeDirectory(argument);
            } else if (command.equals("mkdir")) {
                handler.makeDirectory(argument);
            } else if (command.equals("touch")) {
                handler.createFile(argument);
            } else if (command.equals("help")) {
                handler.printHelp();
            } else if (command.equals("exit")) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Unknown command. Type 'help' to see available commands.");
            }
        }
                 // Your code should call the appropriate methods from the ShellCommandHandler class

            if (command.equals("exit")) {
                System.out.println("Goodbye!");
                return;
            }
        }
    }
}
