package paging.pagingTest.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import paging.pagingTest.GetId;

import java.util.List;

@SpringBootTest
class BoardServiceTest {
    @Autowired BoardService boardService;

    @Test
    public void 번호_가져오기v1(){
        List<GetId> findTitle = boardService.findBoardTitle("testTitle");
        System.out.println("============findTitleNumber============");
        findTitle.forEach(getId -> System.out.println(getId.getId()));
    }
    /*
    @Test
    public void 번호_가져오기v2(){
        List<Long> findTitle = boardService.findBoardTitles("testTitle");
        System.out.println("============findTitleNumber============");
        System.out.println(findTitle);
    }
    */
}