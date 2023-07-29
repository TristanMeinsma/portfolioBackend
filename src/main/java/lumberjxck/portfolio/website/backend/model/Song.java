package lumberjxck.portfolio.website.backend.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author Tristan Meinsma
 * A song that had been co-produced by Tristan Meinsma
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Song {

    @Id
    @GeneratedValue
    private Long id;
    private String title;

    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Artist> artists;

    @Column(length = 2048)
    private String imageUrl;

    @Column(length = 2048)
    private String spotifyLink;

    private String soundPreview;

    public Song(String title, List<Artist> artists, String imageUrl, String spotifyLink, String soundPreview) {
        this.title = title;
        this.artists = artists;
        this.imageUrl = imageUrl;
        this.spotifyLink = spotifyLink;
        this.soundPreview = soundPreview;
    }
}
