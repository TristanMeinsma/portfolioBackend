package lumberjxck.portfolio.website.backend.controller;

import lombok.RequiredArgsConstructor;
import lumberjxck.portfolio.website.backend.model.Artist;
import lumberjxck.portfolio.website.backend.model.Song;
import lumberjxck.portfolio.website.backend.service.ArtistService;
import lumberjxck.portfolio.website.backend.service.SongService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Tristan Meinsma
 * Handles web interactions with artists
 */

@RestController
@RequestMapping("/artist")
@RequiredArgsConstructor
public class ArtistController {
    private final ArtistService artistService;

    @GetMapping("/all")
    public ResponseEntity<List<Artist>> getAllArtists() {
        List<Artist> artists = artistService.findALlArtists();
        return new ResponseEntity<>(artists, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Artist> getArtistById(@PathVariable("id") Long id) {
        Artist artist = artistService.findArtistById(id);
        return new ResponseEntity<>(artist, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Artist> addArtist(@RequestBody Artist artist) {
        Artist newArtist = artistService.addArtist(artist);
        return new ResponseEntity<>(newArtist, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Artist> updateArtist(@RequestBody Artist artist) {
        Artist updateArtist = artistService.updateArtist(artist);
        return new ResponseEntity<>(updateArtist, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteArtist(@PathVariable("id") Long id) {
        artistService.deleteArtist(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
