package lumberjxck.portfolio.website.backend;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lumberjxck.portfolio.website.backend.model.Artist;
import lumberjxck.portfolio.website.backend.model.Song;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author Tristan Meinsma
 * test JSON serialization artist and song
 */
public class ArtistTest {

    @Test
    @DisplayName("Song should contain Artist")
    public void songShouldContainArtist() throws JsonProcessingException {
        final Artist artist = new Artist("Artist", "url", "url");
        final Song song = new Song("Song", "url", "url");
        song.addArtist(artist);

        final String songJson = new ObjectMapper().writeValueAsString(song);

        assertThat(songJson).contains("Artist");
    }

    @Test
    @DisplayName("Artist should not contain Song")
    void artistShouldNotContainSong() throws JsonProcessingException {
        final Artist artist = new Artist("Artist", "url", "url");
        final Song song = new Song("Song", "url", "url");
        artist.addSong(song);

        final String artistJson = new ObjectMapper().writeValueAsString(artist);

        assertThat(artistJson).doesNotContain("Song");
    }
}
