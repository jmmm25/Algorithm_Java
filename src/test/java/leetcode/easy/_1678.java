package leetcode.easy;

//1678. Goal Parser Interpretation

public class _1678 {
    public String interpret(String command) {
        command = command.replace("()", "o");
        command = command.replace("(al)", "al");

        return command;
    }
}
