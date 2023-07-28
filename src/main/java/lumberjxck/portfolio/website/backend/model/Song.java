package lumberjxck.portfolio.website.backend.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Tristan Meinsma
 * A song that had been co-produced by Tristan Meinsma
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Song {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String artist;

    @Column(unique = true, length = 2048)
    private String imageUrl;

    @Column(unique = true, length = 2048)
    private String spotifyLink;
}
