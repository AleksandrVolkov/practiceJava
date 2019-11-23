package java.impl.interf;

import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.factory.ILabFactory;
import ru.vsu.lab.repository.IPersonRepository;
import ru.vsu.lab.repository.IRepository;

public class Main {
    public static void main(String[] args) {
        ILabFactory labF = new LabFactory();
//        IRepository<IPerson> repository = labF.createRepository(new Class<IPerson>());

//        IRepository rp = new Repository();
    }
}
