package lumberjxck.portfolio.website.backend.repository;

import lumberjxck.portfolio.website.backend.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Tristan Meinsma
 */
public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
