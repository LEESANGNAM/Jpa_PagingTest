package paging.pagingTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import paging.pagingTest.domain.GetId;
import paging.pagingTest.domain.Board;
import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    //List<Board> findByTitle(String title);
    List<GetId> findByTitle(String title);

    List<Board> findTop3ByOrderByIdDesc();//데이터3개만 가져오기

}
