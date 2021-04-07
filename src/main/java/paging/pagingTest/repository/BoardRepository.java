package paging.pagingTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import paging.pagingTest.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
