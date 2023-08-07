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
public class ArtistService {

    private final ArtistRepository artistRepository;
    private final SongRepository songRepository;

    public List<Artist> findALlArtists () {
        return artistRepository.findAll();
    }

    public Artist addArtist (Artist artist) {
        return artistRepository.save(artist);
    }

    public Artist updateArtist (Artist artist) {
        return artistRepository.save(artist);
    }

    public Artist findArtistById (Long id) {
        return artistRepository.findById(id)
                .orElseThrow(() -> new SongNotFoundException("Song by id " + id + " not found."));
    }

    public Artist findByName (String name) {
        return artistRepository.findArtistByName(name)
                .orElseThrow(() -> new SongNotFoundException("Artist with name " + name + " not found."));
    }

    public void deleteArtist(Long id) {
        Optional<Artist> artist = artistRepository.findById(id);

        if (artist.isPresent()) {
            for (Song song : artist.get().getSongs()) {
                song.removeArtist(artist.get());
                songRepository.save(song);
            }
        }
        artistRepository.deleteById(id);
    }
}
