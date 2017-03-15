package obochuk.vlad.entites;

public class User {
    private String name;
    private String password;
    private String description;
    private int id;

    public User(){}

    public User(User user){
        setName(user.name);
        setPassword(user.password);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
