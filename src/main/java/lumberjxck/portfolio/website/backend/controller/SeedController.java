package lumberjxck.portfolio.website.backend.controller;

import lombok.RequiredArgsConstructor;
import lumberjxck.portfolio.website.backend.model.Artist;
import lumberjxck.portfolio.website.backend.model.Song;
import lumberjxck.portfolio.website.backend.service.ArtistService;
import lumberjxck.portfolio.website.backend.service.SongService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tristan Meinsma
 * Loads the app with some initial data
 */

@Controller
@RequiredArgsConstructor
public class SeedController {
    private final SongService songService;
    private final ArtistService artistService;

    @GetMapping("/seed")
    public ResponseEntity<Void> seedDatabase() {
        Artist chael = new Artist("Chaël",
                "https://open.spotify.com/artist/4qUDi25koBiqMb7uhHEOHk?si=SodCi4zkTSamPdEK2oGAXQ");

        Artist charlotteJane = new Artist("Charlotte Jane",
                "https://open.spotify.com/artist/054xTptvdBhGqiTOHvgUaQ?si=nD5g3u8SQvqrRIIDJORCOA");

        Song underMySkin = new Song("Under My Skin",
                "https://i1.sndcdn.com/artworks-lxsptb1B4heT-0-t500x500.jpg",
                "https://open.spotify.com/track/3heHkofB4rcPXF75FF482N?si=3426f23b06ef4b4d",
                "will be implemented later");

        underMySkin.addArtist(chael);
        underMySkin.addArtist(charlotteJane);

        songService.addSong(underMySkin);

        chael.addSong(underMySkin);
        charlotteJane.addSong(underMySkin);

        artistService.addArtist(chael);
        artistService.addArtist(charlotteJane);

        return ResponseEntity.ok().build();
    }
}
