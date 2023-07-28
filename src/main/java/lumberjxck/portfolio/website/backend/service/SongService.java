package lumberjxck.portfolio.website.backend.service;

import lombok.RequiredArgsConstructor;
import lumberjxck.portfolio.website.backend.exception.SongNotFoundException;
import lumberjxck.portfolio.website.backend.model.Song;
import lumberjxck.portfolio.website.backend.repository.SongRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Tristan Meinsma
 * Handles interaction with the repository
 */
@Service
@RequiredArgsConstructor
public class SongService {
    private final SongRepository songRepository;

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
        songRepository.deleteById(id);
    }
}
