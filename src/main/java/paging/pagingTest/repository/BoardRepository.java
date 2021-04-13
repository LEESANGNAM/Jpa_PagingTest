package paging.pagingTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import paging.pagingTest.GetId;
import paging.pagingTest.domain.Board;
import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    //List<Board> findByTitle(String title);
    List<GetId> findByTitle(String title);
}
