package Stream.Execises;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Exercise4 {
    public static void main(String[] args) {
        record LogEntry(String endpoint, long responseMs, int statusCode) {
            @Override
            public String endpoint() {
                return endpoint;
            }

            @Override
            public long responseMs() {
                return responseMs;
            }

            @Override
            public int statusCode() {
                return statusCode;
            }
        }

        List<LogEntry> logs = List.of(
                new LogEntry("/api/users",    120, 200),
                new LogEntry("/api/products", 350, 200),
                new LogEntry("/api/users",    480, 500),
                new LogEntry("/api/orders",    90, 200),
                new LogEntry("/api/products", 210, 200),
                new LogEntry("/api/orders",   150, 200)
        );

        Map<String, Double> ex4 = logs.stream().collect(Collectors.groupingBy(LogEntry::endpoint, Collectors.averagingLong(LogEntry::responseMs)))
                .entrySet().stream()
                .filter(e -> e.getValue() > 200)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(ex4);
    }
}
