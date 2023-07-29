package lumberjxck.portfolio.website.backend.service;

import lombok.RequiredArgsConstructor;
import lumberjxck.portfolio.website.backend.exception.SongNotFoundException;
import lumberjxck.portfolio.website.backend.model.Artist;
import lumberjxck.portfolio.website.backend.model.Song;
import lumberjxck.portfolio.website.backend.repository.ArtistRepository;
import lumberjxck.portfolio.website.backend.repository.SongRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Tristan Meinsma
 * Handles interaction with the repository
 */
@Service
@RequiredArgsConstructor
public class SongService {
    private final SongRepository songRepository;
    private final ArtistRepository artistRepository;

    public List<Song> findALlSongs () {
        return songRepository.findAll();
    }

    public Song addSong (Song song) {
        return songRepository.save(song);
    }

    public Song updateSong (Song song) {
        return songRepository.save(song);
    }

    public Song findSongById (Long id) {
        return songRepository.findSongById(id)
                .orElseThrow(() -> new SongNotFoundException("Song by id " + id + " not found."));
    }

    public void deleteSong(Long id) {
        Optional<Song> song = songRepository.findById(id);

        if (song.isPresent()) {
            for (Artist artist : song.get().getArtists()) {
                artist.removeSong(song.get());
                artistRepository.save(artist);
            }
        }
        songRepository.deleteById(id);
    }
}
