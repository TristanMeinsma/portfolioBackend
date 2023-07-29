package lumberjxck.portfolio.website.backend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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

    public Artist(String name, String spotifyProfileUrl) {
        this.name = name;
        this.spotifyProfileUrl = spotifyProfileUrl;
    }
}

