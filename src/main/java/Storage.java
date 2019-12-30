import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.Serializer;

import java.util.List;
import java.util.concurrent.ConcurrentMap;


public class Storage {

    DB db;
    ConcurrentMap<Integer, Quote> quotes;

    public Storage() {
        db = DBMaker
                .fileDB("file.db")
                .fileMmapEnable()
                .make();
        quotes = db
                .hashMap("quotes", Serializer.INTEGER, Serializer.JAVA)
                .createOrOpen();
    }

    public void addQuote(String quote) {
        quotes.put(quotes.size(), new Quote(quote));
    }

    public void addQuote(String quote, List<String> tags) {
        quotes.put(quotes.size(), new Quote(quote, tags));
    }

    public int getSize() {
        return quotes.size();
    }

    public String getQuote(int i) {
        return quotes.get(i).getQuote();
    }

    public void close() {
        db.close();
    }
}
