import picocli.CommandLine;
import java.util.Random;

@CommandLine.Command
public class Quotee {
    Storage storage;
    Random rand;

    Quotee(Storage storage) {
        this.storage = storage;
    }

    public static void main(String[] args) {
        Storage storage = new Storage();
        CommandLine commandLine = new CommandLine(new Quotee(storage));
        commandLine.addSubcommand("add", new QuoteeAdd(storage));
        commandLine.addSubcommand("get", new QuoteeGet(storage));
        commandLine.execute(args);
        storage.close();
    }
}
