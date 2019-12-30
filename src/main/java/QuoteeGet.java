import picocli.CommandLine;
import java.util.Random;

@CommandLine.Command(
        name = "get"
)
public class QuoteeGet implements Runnable {

    Storage storage;


    QuoteeGet(Storage storage) {
        this.storage = storage;

    }

    public void run() {
        Random rand = new Random();
        int index = rand.nextInt(storage.getSize());
        System.out.println("#" + index + " " + storage.getQuote(index));
    }
}
