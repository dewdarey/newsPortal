package kz.springproject.phoenix.repository;

import jakarta.transaction.Transactional;
import kz.springproject.phoenix.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface NewsRepository extends JpaRepository<News, Long> {
}
