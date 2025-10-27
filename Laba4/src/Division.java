
import java.util.concurrent.atomic.AtomicInteger;

public class Division {
    private static final AtomicInteger idGenerator = new AtomicInteger(1);

    private final int id;
    private final String name;

    public Division(String name) {
        this.id = idGenerator.getAndIncrement();
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Division{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}