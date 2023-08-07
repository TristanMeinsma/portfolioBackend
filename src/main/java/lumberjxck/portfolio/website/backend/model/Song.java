package lumberjxck.portfolio.website.backend.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tristan Meinsma
 * A song that had been co-produced by Tristan Meinsma
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class,
  property = "songId")
public class Song {

    @Id
    @GeneratedValue
    private Long songId;
    private String title;

    @JsonManagedReference
    @ManyToMany(mappedBy = "songs")
    private List<Artist> artists = new ArrayList<>();

    @Column(length = 2048)
    private String imageUrl;

    @Column(length = 2048)
    private String spotifyLink;

    private String soundPreview;

    private boolean showOnWebsite = false;
    private int orderNumber = 0;

    public Song(String title, String imageUrl, String spotifyLink) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.spotifyLink = spotifyLink;
    }

    public void addArtist(Artist artist) {
        artists.add(artist);
    }

    public void removeArtist(Artist artist) {
        if (!artists.contains(artist)) {
            throw new IllegalArgumentException("Artist not present on this song");
        }
        artists.remove(artist);
    }
}
