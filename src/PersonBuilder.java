import java.util.OptionalInt;

public class PersonBuilder {
    private Person newPerson;
    protected String name;
    protected String surname;
    protected int age;
    protected String adress;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.adress = address;
        return this;
    }

    public Person build() {
        if (name == null) {
            throw new IllegalStateException("Заполните имя");
        }
        if (surname == null) {
            throw new IllegalStateException("Заполните фамилию");
        }
        if (OptionalInt.of(age).isPresent()) {
            if (age < 0) {
                throw new IllegalArgumentException("Возраст не может быть отрицательным");
            } else {
                newPerson = new Person(name, surname, age);
            }
        } else {
            newPerson = new Person(name, surname);
        }
        if (adress != null) {
            newPerson.setAddress(adress);
        }
        return newPerson;
    }
}
