import java.io.File;
import java.io.IOException;

public class ShellCommandHandler {
        private File currentDirectory;

        public ShellCommandHandler() {
            currentDirectory = new File(System.getProperty("user.dir"));
        }

        public void printWorkingDirectory() {
            System.out.println(currentDirectory.getAbsolutePath());
        }
        
// -----------------------
        
        public void listDirectory() {
            File[] files = currentDirectory.listFiles();
            if (files != null) {
                for (int i = 0; i < files.length; i++) {
                    if (files[i].isDirectory()) {
                        System.out.println("[DIR] " + files[i].getName());
                    } else {
                        System.out.println("[FILE] " + files[i].getName());
                    }
                }
            }
        }

        // ----------------------------
        
        public void changeDirectory(String name) {
            if (name == null) {
                System.out.println("Usage: cd [directory_name]");
            } else if (name.equals("..")) {
                File parent = currentDirectory.getParentFile();
                if (parent != null) {
                    currentDirectory = parent;
                } else {
                    System.out.println("No parent directory");
                }
            } else {
                File newDir = new File(currentDirectory, name);
                if (newDir.exists() && newDir.isDirectory()) {
                    currentDirectory = newDir;
                } else {
                    System.out.println("Directory not found: " + name);
                }
            }
        }
        
// -------------------------------------
        
        public void makeDirectory(String name) {
            if (name == null) {
                System.out.println("Usage: mkdir [directory_name]");
            } else {
                File dir = new File(currentDirectory, name);
                if (dir.exists()) {
                    System.out.println("Directory already exists.");
                } else {
                    boolean made = dir.mkdir();
                    if (made) {
                        System.out.println("Directory created: " + name);
                    } else {
                        System.out.println("Failed to create directory.");
                    }
                }
            }
        }

        // ----------------------------------------------------------------

        public void createFile(String name) {
            if (name == null) {
                System.out.println("Usage: touch [file_name]");
            } else {
                File file = new File(currentDirectory, name);
                if (file.exists()) {
                    System.out.println("File already exists.");
                } else {
                    try {
                        boolean made = file.createNewFile();
                        if (made) {
                            System.out.println("File created: " + name);
                        } else {
                            System.out.println("Failed to create file: " + name);
                        }
                    } catch (IOException e) {
                        System.out.println("Failed to create file: " + name);
                        System.out.println("Error details: " + e.getMessage());
                    }
                }
            }
        }

        // -------------------------------------------------------------

        public void printHelp() {
            System.out.println("Available commands:");
            System.out.println("pwd - Print the current working directory");
            System.out.println("ls - List all files and directories in the current directory");
            System.out.println("cd [dir] - Change directory to [dir] or '..' to go up");
            System.out.println("mkdir [name] - Create a new directory with the given name");
            System.out.println("touch [name] - Create a new empty file with the given name");
            System.out.println("help - Show this help information");
            System.out.println("exit - Exit the shell");
        }

        public File getCurrentDirectory() {
            return currentDirectory;
        }
    }


