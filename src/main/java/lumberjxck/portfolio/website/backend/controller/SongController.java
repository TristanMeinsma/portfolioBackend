package lumberjxck.portfolio.website.backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lumberjxck.portfolio.website.backend.model.Artist;
import lumberjxck.portfolio.website.backend.model.Song;
import lumberjxck.portfolio.website.backend.service.SongService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tristan Meinsma
 * Handles web interactions with songs
 */

@RestController
@RequestMapping("/song")
@RequiredArgsConstructor
public class SongController {
    private final SongService songService;

    @GetMapping("/all")
    public ResponseEntity<List<Song>> getAllSongs() {
        List<Song> songs = songService.findALlSongs();
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Song> getSongById(@PathVariable("id") Long id) {
        Song song = songService.findSongById(id);
        return new ResponseEntity<>(song, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Song> addSong(@RequestParam("song") String songJson, @RequestParam("file") MultipartFile file) throws IOException {
        List<Long> artistIds = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();
        Song song = objectMapper.readValue(songJson, Song.class);

        byte[] bytes = file.getBytes();
        song.setSoundPreview(bytes);

        for (Artist artist : song.getArtists()) {
            artistIds.add(artist.getId());
        }
        Song newSong = songService.addSong(song);

        return new ResponseEntity<>(newSong, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Song> updateSong(@RequestParam("song") String songJson, @RequestParam("file") MultipartFile file) throws IOException {
        List<Long> artistIds = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();
        Song song = objectMapper.readValue(songJson, Song.class);

        byte[] bytes = file.getBytes();
        song.setSoundPreview(bytes);

        for (Artist artist : song.getArtists()) {
            artistIds.add(artist.getId());
        }

        Song updateSong = songService.updateSong(song);
        return new ResponseEntity<>(updateSong, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteSong(@PathVariable("id") Long id) {
        songService.deleteSong(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
