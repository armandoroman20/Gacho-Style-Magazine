package gachostyle.magazine.models;

import javax.persistence.*;

@Entity
@Table(name="image")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INt(10) UNSIGNED")
    private long id;

    @Column(length = 250, nullable = true)
    private String image;

    @Column(length = 255, nullable = true)
    private String title;

    @Column(length = 255, nullable = true)
    private String description;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Image() {
    }

    public Image(long id, String image, String title, String description, User user) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.description = description;
        this.user = user;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
