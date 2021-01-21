package gachostyle.magazine.models;

import javax.persistence.*;

@Entity
@Table(name="image")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INt(10) UNSIGNED")
    private long id;

    @Column(length = 50, nullable = true)
    private String image;

    @Column(length = 255, nullable = true)
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
