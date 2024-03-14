import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age;
    protected String adress;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public boolean hasAge() {
        return getAge().isEmpty() ? false : true;
    }

    public boolean hasAddress() {
        return getAddress() == null ? false : true;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        if (age == 0) {
            return OptionalInt.empty();
        } else {
            return OptionalInt.of(age);
        }
    }

    public String getAddress() {
        return adress;
    }

    public void setAddress(String address) {
        this.adress = address;
    }

    public void happyBirthday() {
        age++;
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder childBuilder = new PersonBuilder();
        childBuilder.setName(name);
        childBuilder.setSurname(this.getSurname());
        childBuilder.setAddress(this.getAddress());
        return childBuilder;
    }

    @Override
    public String toString() {
        if (getAge().isPresent()) {
            return "Имя: " + name +
                    "\nФамилия: " + surname +
                    "\nВозраст: " + age +
                    "\nТекущий город жительства: " + adress;
        } else {
            return "Имя: " + name +
                    "\nФамилия: " + surname +
                    "\nВозраст: " + OptionalInt.empty() +
                    "\nТекущий город жительства: " + adress;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, getAge(), getAddress());
    }
}
