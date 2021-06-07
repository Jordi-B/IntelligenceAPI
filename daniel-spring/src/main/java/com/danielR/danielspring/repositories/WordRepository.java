package com.danielR.danielspring.repositories;

        import com.danielR.danielspring.models.Word;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

        import java.util.List;

@Repository
public interface WordRepository extends JpaRepository<Word, String> {
        List<Word> findAll();
}
