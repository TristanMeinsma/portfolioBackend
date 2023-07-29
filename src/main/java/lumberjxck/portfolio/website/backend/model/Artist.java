package lumberjxck.portfolio.website.backend.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
    private Long id;

    private String name;
    private String spotifyProfileUrl;

    @ManyToMany()
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "id")
    private List<Song> songs = new ArrayList<>();

    public Artist(String name, String spotifyProfileUrl) {
        this.name = name;
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

