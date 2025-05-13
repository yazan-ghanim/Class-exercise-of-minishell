import java.io.File;
import java.io.IOException;

// shell commands handler
public class ShellCommandHandler {
    private File myDir;  

    // constructor
    public ShellCommandHandler() {
        myDir = new File(System.getProperty("user.dir"));
    }

    public void printWorkingDirectory() {
        System.out.println(myDir.getAbsolutePath());
    }

    public void listDirectory() {
       // get all files
       File[] files = myDir.listFiles();
       
       // check if there are files
       if(files != null) {
         for(int i = 0; i < files.length; i++) {
           if(files[i].isDirectory()) {
             System.out.println("[DIR] " + files[i].getName());
           }
           else {
             System.out.println("[FILE] " + files[i].getName());
           }
         }
       }
       else {
           System.out.println("Empty folder or can't read");
       }
    }

    public void changeDirectory(String folder) {
        if(folder == null) {
            System.out.println("Usage: cd [directory_name]");
            return;
        } 
        
        if (folder.equals("..")) {
          // go to parent folder
          File parent = myDir.getParentFile();
          if(parent != null) {
              myDir = parent;
              System.out.println("You are now in: " + myDir.getAbsolutePath());
          }
          else {
              System.out.println("No parent folder exists");
          }
        }
        else {
          // go to specified folder
          File newFolder = new File(myDir, folder);
          if(newFolder.exists() && newFolder.isDirectory()) {
              myDir = newFolder;
              System.out.println("You are now in: " + myDir.getAbsolutePath());
          }
          else {
              System.out.println("Can't find that folder: " + folder);
          }
        }
    }

    public void makeDirectory(String name) {
        // make new directory
        if(name == null) {
            System.out.println("Usage: mkdir [directory_name]");
            return;
        }
        
        File newFolder = new File(myDir, name);
        
        if(newFolder.exists()) {
            System.out.println("That folder already exists!");
        }
        else {
            boolean result = newFolder.mkdir();
            if(result) {
                System.out.println("Made new folder: " + name);
            }
            else {
                System.out.println("Couldn't make the folder");
            }
        }
    }

    public void createFile(String name) {
        // make new file
        if (name == null) {
            System.out.println("Usage: touch [file_name]");
            return;
        }
        
        File newFile = new File(myDir, name);
        
        if (newFile.exists()) {
            System.out.println("That file already exists!");
            return;
        }
        
        try {
            boolean result = newFile.createNewFile();
            if (result) {
                System.out.println("Made new file: " + name);
            } 
            else {
                System.out.println("Couldn't make the file");
            }
        } 
        catch (IOException e) {
            System.out.println("Error making file!");
        }
    }

    public void printHelp() {
        // print all commands
        System.out.println("Commands you can use:");
        System.out.println("pwd = see current folder");
        System.out.println("ls = list files");
        System.out.println("cd [folder] = change folder");
        System.out.println("mkdir [name] = make new folder");
        System.out.println("touch [name] = make new file");
        System.out.println("help = see this message");
        System.out.println("exit = quit program");
    }

    public File getCurrentDirectory() {
        return myDir;
    }
}
