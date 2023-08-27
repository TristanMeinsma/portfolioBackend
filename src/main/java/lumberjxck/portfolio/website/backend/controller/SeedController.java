package lumberjxck.portfolio.website.backend.controller;

import lombok.RequiredArgsConstructor;
import lumberjxck.portfolio.website.backend.model.Artist;
import lumberjxck.portfolio.website.backend.model.FileUtility;
import lumberjxck.portfolio.website.backend.model.Song;
import lumberjxck.portfolio.website.backend.service.ArtistService;
import lumberjxck.portfolio.website.backend.service.SongService;
import org.apache.commons.io.IOUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;


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
    public ResponseEntity<Void> seedDatabase() throws IOException {
        createArtists();
        createSongs();
        return ResponseEntity.ok().build();
    }

    private void createArtists() {
        createArtist("Chaël",
                "https://open.spotify.com/artist/4qUDi25koBiqMb7uhHEOHk?si=SodCi4zkTSamPdEK2oGAXQ",
                "https://yt3.googleusercontent.com/MF13WqnH__CX3CCHWNCDFx_3wOBVW6J8a_M-o91tzxyHH2XGrcEpvzVZBTn_zMJBpWJ-ZxH1=s900-c-k-c0x00ffffff-no-rj",
                1, true);

        createArtist("Chaël2",
                "https://open.spotify.com/artist/4qUDi25koBiqMb7uhHEOHk?si=SodCi4zkTSamPdEK2oGAXQ",
                "https://yt3.googleusercontent.com/MF13WqnH__CX3CCHWNCDFx_3wOBVW6J8a_M-o91tzxyHH2XGrcEpvzVZBTn_zMJBpWJ-ZxH1=s900-c-k-c0x00ffffff-no-rj",
        1, false);

        createArtist("Charlotte Jane",
                "https://open.spotify.com/artist/054xTptvdBhGqiTOHvgUaQ?si=nD5g3u8SQvqrRIIDJORCOA",
                "https://tresamagazine.files.wordpress.com/2021/01/charlotte-jane4-by-lennon-gregory.jpeg", 2, true);

        createArtist("Mougleta",
                "https://open.spotify.com/artist/4gmndqcVVyxmzgOunTiuAD?si=fmyOuh-MQXqttDKpgj46aA",
                "https://i.scdn.co/image/ab6761610000e5eb57b0cbf14daac087ceeff359", 3, true);

        createArtist("Russ",
                "https://open.spotify.com/artist/1z7b1Pr1rSlvWRzsW3HOrS?si=4t2lGl5TQsO9svK0dZWz8w",
                "https://rollingstoneindia.com/wp-content/uploads/2022/04/RUSS-Shaq-Kokumo.jpg", 0, true);
    }

    private void createArtist(String name, String spotifyUrl, String imageUrl, int orderNumber, boolean showOnWebsite) {
        Artist artist = new Artist(name, spotifyUrl, imageUrl, orderNumber, showOnWebsite);
        artistService.addArtist(artist);
    }

    private void createSongs() throws IOException {
        Song underMySkin = createSong("Under My Skin",
                "https://i1.sndcdn.com/artworks-lxsptb1B4heT-0-t500x500.jpg",
                "https://open.spotify.com/track/3heHkofB4rcPXF75FF482N?si=3426f23b06ef4b4d", 1, true,
                "Chaël", "Charlotte Jane");

        underMySkin.setSoundPreview(FileUtility.readFileToByteArray("/Users/tristanmeinsma/MakeITWork/VakantieProjecten/PortfolioWebsite/backend/src/main/resources/static/Under My Skin Preview.mp3"));

        Song cantLetGo = createSong("Can't Let Go",
                "https://i.scdn.co/image/ab67616d0000b2736e0e6c8c795b3637e98f93bd",
                "https://open.spotify.com/track/47fLJgV5DWZXLl6FEvPD28?si=846c60c8ab0249dc", 0, true,
                "Russ");

        cantLetGo.setSoundPreview(FileUtility.readFileToByteArray("/Users/tristanmeinsma/MakeITWork/VakantieProjecten/PortfolioWebsite/backend/src/main/resources/static/Can't Let Go Preview.mp3"));

        Song danceToMyHeartBeat = createSong("Dance To My Heartbeat",
                "https://i.scdn.co/image/ab67616d0000b2735c5b3c0ef6e7dbdf28b26864",
                "https://open.spotify.com/track/0G76SXZghtnNuDyoggumuO?si=6415fdb54fde4bf3", 2, true,
                "Mougleta", "Chaël2");

        danceToMyHeartBeat.setSoundPreview(FileUtility.readFileToByteArray("/Users/tristanmeinsma/MakeITWork/VakantieProjecten/PortfolioWebsite/backend/src/main/resources/static/Mougleta Preview.mp3"));
    }

    private Song createSong(String title, String imageUrl, String spotifyUrl, int orderNumber, boolean showOnWebsite , String... artistNames) {
        Song song = new Song(title, imageUrl, spotifyUrl, orderNumber, showOnWebsite);
        for (String artistName : artistNames) {
            Artist artist = artistService.findByName(artistName);
            if (artist != null) {
                song.addArtist(artist);
                artist.addSong(song);
            }
        }
        songService.addSong(song);
        return song;
    }
}
