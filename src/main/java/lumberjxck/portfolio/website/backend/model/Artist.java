package lumberjxck.portfolio.website.backend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
    private Long id;

    private String name;
    private String spotifyProfileUrl;

    @ManyToMany
    private List<Song> songs;

    public Artist(String name, String spotifyProfileUrl) {
        this.name = name;
        this.spotifyProfileUrl = spotifyProfileUrl;
    }

     public void removeSong(Song song) {
        if (!songs.contains(song)) {
            throw new IllegalArgumentException("Song not present in this artists repertoire");
        }
        songs.remove(song);
    }
}

