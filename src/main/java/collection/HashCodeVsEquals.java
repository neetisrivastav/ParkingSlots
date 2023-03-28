package collection;

import java.util.List;

public class HashCodeVsEquals {

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}


class Person{

    private String name;
    private int id;
   // private List<String> address;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public int hashCode() {
        return id + name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;

        // it checks if the argument is of the
        // type Geek by comparing the classes
        // of the passed argument and this object.
        // if(!(obj instanceof Geek)) return false; ---> avoid.
        if(obj == null || obj.getClass()!= this.getClass())
            return false;

        // type casting of the argument.
        Person person = (Person) obj;

        // comparing the state of argument with
        // the state of 'this' Object.
        return (person.name.equals(this.name)  && person.id == this.id);
    }

    public static void main(String[] args) {
        Person p1 = new Person("neeti",1);
        Person p2 = new Person("neeti",1);

        System.out.println(p1.equals(p2));//true
        System.out.println(p1.hashCode()+" "+ p2.hashCode());
    }
}