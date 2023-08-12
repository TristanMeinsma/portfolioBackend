package lumberjxck.portfolio.website.backend.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Tristan Meinsma
 * An artist who wrote or performed on a song
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Artist {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String spotifyProfileUrl;
    private String imageUrl;
    private boolean showOnWebsite = false;
    private int orderNumber = 0;

    @JsonBackReference
    @ManyToOne
    private Song song;

    public Artist(String name, String spotifyProfileUrl, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.spotifyProfileUrl = spotifyProfileUrl;
    }

    public void addSong(Song song) {
        this.song = song;
    }

     public void removeSong() {
        this.song = null;
    }
}

