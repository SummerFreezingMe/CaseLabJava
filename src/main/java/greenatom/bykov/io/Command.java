package greenatom.bykov.io;

public class Command {
    private final CommandType type;
    private final String path;
    private final String args;

    public Command(String nextLine) {
        String[] inputs = nextLine.split(" ");
        this.path = inputs[0];
        this.type = CommandType.getType(inputs[1]);
        if (type == CommandType.WRITE) {
            this.args = inputs[2];
        } else {
            this.args = "";
        }
    }

    public void process() {
    type.process(path,args);
    }
}
