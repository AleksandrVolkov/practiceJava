package java.impl.interf;

import ru.vsu.lab.entities.IDivision;
import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.factory.ILabFactory;
import ru.vsu.lab.repository.IPersonRepository;
import ru.vsu.lab.repository.IRepository;

import java.lang.reflect.Type;

public class LabFactory implements ILabFactory {
    @Override
    public IPerson createPerson() {
        return new Person();
    }

    @Override
    public IDivision createDivision() {
        return new Division();
    }
//вот тут не понел!
    @Override
    public <T> IRepository<T> createRepository(Class<T> clazz) {
//        Type result =  clazz.getGenericSuperclass();
//        T type = result;
        return new Repository<T>();
    }

    @Override
    public IPersonRepository createPersonRepository() {
        return new PersonRepository();
    }
}
