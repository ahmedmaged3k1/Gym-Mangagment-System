package GUI.Controllers.emp;

public class tablemodel {
    String id,name,email,gender,phoneNumber;
    float weight , height ;
    int age;

    public tablemodel(String id, String name, String email, String gender, String phoneNumber, float weight, float height, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.weight = weight;
        this.height = height;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public float getWeight() {
        return weight;
    }

    public float getHeight() {
        return height;
    }
}
