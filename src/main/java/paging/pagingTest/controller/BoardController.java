package paging.pagingTest.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import paging.pagingTest.domain.Board;
import paging.pagingTest.domain.GetId;
import paging.pagingTest.service.BoardService;
import java.util.*;

@Controller
@Slf4j
public class BoardController {
    private BoardService boardService;

    public BoardController(BoardService boardService) {this.boardService = boardService;}

    @GetMapping("/boards")
    public String boardView(@PageableDefault Pageable pageable, Model model) {

        Page<Board> boardList = boardService.getBoardList(pageable);
        model.addAttribute("boardList", boardList);

        List<Board> getBoardList = boardList.getContent();
        model.addAttribute("getBoardList",getBoardList);//list size가져옴, list size확인용

        List<Board> getTop = boardService.findTop3Board();
        model.addAttribute("findTop3",getTop);

        List<GetId> getTitle = boardService.findBoardTitle("title");//title이 "title"인 데이터 조회
        getTitle.forEach(list -> System.out.println(list.getId()));//title이 "title"인 데이터의 id 출력
        System.out.println(getTitle.size());//전체 크기 출력

        return "board";
    }
}
