package uz.peachdev.gt;

public class UserHelper {
    String name;
    String age;
    String height;
    String weight;

    public UserHelper() {
    }

    public UserHelper(String name) {
        this.name = name;
    }

    public UserHelper(String name, String age, String height, String weight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
