
🖥️ MiniShell – Java File System Shell

A simple command-line shell written in Java that simulates basic file system operations such as `pwd`, `ls`, `cd`, `mkdir`, and `touch`.

This project was created as part of a university Java programming course. It demonstrates fundamental object-oriented programming, file handling, and user interaction through the console.

📁 Project Structure

📦 MiniShell Project
├── MiniShell.java            // Main class – handles user input and command parsing
├── ShellCommandHandler.java  // Core logic – handles command implementations

🚀 Features

- `pwd` – Print the current working directory.
- `ls` – List all files and directories in the current directory.
- `cd [dir]` – Change directory to `[dir]` or use `..` to move up.
- `mkdir [name]` – Create a new directory with the specified name.
- `touch [name]` – Create a new empty file with the specified name.
- `help` – Display all available commands.
- `exit` – Exit the shell application.

Each command is handled with proper input validation and error handling to ensure smooth usage.

🛠️ Technologies Used

- Programming Language: Java (JDK 8+)
- IDE Used: IntelliJ IDEA / Any Java-supporting IDE
- Libraries: No external libraries used – all standard Java

📦 Installation & Running the Project

1. Clone or Download the repository to your local machine.
2. Navigate to the project folder using the terminal or command prompt.
3. Compile the Java files using:

   javac MiniShell.java ShellCommandHandler.java

4. Run the application using:

   java MiniShell

You will see:

Welcome to MiniShell! Type 'help' for a list of commands.

Now you can start typing commands just like in a real shell.

📚 Example Usage

/home/user > mkdir test
Directory created: test

/home/user > cd test

/home/user/test > touch notes.txt
File created: notes.txt

/home/user/test > ls
[FILE] notes.txt

/home/user/test > pwd
/home/user/test

/home/user/test > help
Available commands:
pwd - Print the current working directory
ls - List all files and directories in the current directory
cd [dir] - Change directory to [dir] or '..' to go up
mkdir [name] - Create a new directory with the given name
touch [name] - Create a new empty file with the given name
help - Show this help information
exit - Exit the shell

📂 Future Improvements

- Add support for `rm` and `rmdir` commands
- Implement copy/move operations
- Add color-coding for files/folders
- Support for command history and autocomplete

👨‍🎓 Author

Yazan Ghanem
Final Project – Java Programming
Instructor: Mr. Hakam Nabulsi
Faculty of Software Engineering

📄 License

This project is for educational purposes.
Feel free to use and modify it with proper attribution.
