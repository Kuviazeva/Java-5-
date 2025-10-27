import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String csvFilePath = "people.csv";
        char separator = ';';

        List<Person> persons = readPersonsFromCsv(csvFilePath, separator);

        System.out.println("===== Список людей =====");
        for (Person h : persons) {
            System.out.println(h);
        }
    }

    public static List<Person> readPersonsFromCsv(String csvFilePath, char separator) {
        List<Person> persons = new ArrayList<>();
        Map<String, Division> departments = new HashMap<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        try (InputStream in = Main.class.getClassLoader().getResourceAsStream(csvFilePath);
             BufferedReader br = new BufferedReader(new InputStreamReader(Objects.requireNonNull(in)))) {

            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(String.valueOf(separator));
                if (parts.length < 6) continue;
                //id;name;gender;BirtDate;Division;Salary
                int id = Integer.parseInt(parts[0].trim());
                String name = parts[1].trim();
                String gender = parts[2].trim();
                LocalDate birthDate = LocalDate.parse(parts[3].trim(), formatter);
                String depName = parts[4].trim();
                double salary = Double.parseDouble(parts[5].trim());

                Division department = departments.computeIfAbsent(depName, Division::new);

                Person person = new Person(id, name, gender, department, salary, birthDate);
                persons.add(person);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return persons;
    }
}