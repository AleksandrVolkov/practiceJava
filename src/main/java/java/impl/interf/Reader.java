package java.impl.interf;

import reader.IReader;
import ru.vsu.lab.entities.IDivision;
import ru.vsu.lab.entities.enums.Gender;
import ru.vsu.lab.repository.IRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class Reader implements IReader {
    IRepository repository;
    String path;

    public Reader(IRepository repository, String path) {
        this.repository = repository;
        this.path = path;
    }

    @Override
    public IRepository read() {
        Map<String ,IDivision> mapDivision = new HashMap<>();
        String line = "";
        int i =0;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) { // ".\\src\\main\\resources\\persons.csv"
            br.readLine();
            while ((line = br.readLine()) != null) {
                if(20==i++)break;

                String[] el = line.split(";");
                Integer id = new Integer(el[0]);
                String firstName = el[1];
                String lastName = "";
                LocalDate birthday = LocalDate.parse(el[3], DateTimeFormatter.ofPattern("d.MM.yyyy"));
                Integer age = Period.between(birthday, LocalDate.now()).getYears();
                Gender gender = "Male".equals(el[2]) ? Gender.MALE : Gender.FEMALE;
                IDivision division;
                if( !mapDivision.containsKey(el[4]) || mapDivision.isEmpty()) {
                    mapDivision.put(el[4], new Division(id, el[4]));
                    division = mapDivision.get(el[4]);
                }
                else
                    division = mapDivision.get(el[4]);
                BigDecimal salary = new BigDecimal(el[5]);

                repository.add(new Person(id, firstName, lastName, birthday, gender, division, salary));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return repository;
    }
}
