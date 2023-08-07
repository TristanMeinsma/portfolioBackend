package lumberjxck.portfolio.website.backend.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

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
    private Long artistId;

    private String name;
    private String spotifyProfileUrl;
    private String imageUrl;
    private boolean showOnWebsite = false;
    private int orderNumber = 0;

    @JsonBackReference
    @ManyToMany
    private List<Song> songs = new ArrayList<>();

    public Artist(String name, String spotifyProfileUrl, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.spotifyProfileUrl = spotifyProfileUrl;
    }

    public void addSong(Song song) {
        songs.add(song);
    }

     public void removeSong(Song song) {
        if (!songs.contains(song)) {
            throw new IllegalArgumentException("Song not present in this artists repertoire");
        }
        songs.remove(song);
    }
}

