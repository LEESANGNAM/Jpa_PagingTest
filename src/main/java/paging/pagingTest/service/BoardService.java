package paging.pagingTest.service;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import paging.pagingTest.domain.GetId;
import paging.pagingTest.domain.Board;
import paging.pagingTest.repository.BoardRepository;

@Service
@Slf4j
public class BoardService {
    private BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    public Page<Board> getBoardList(Pageable pageable){
        int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber()-1);
        pageable = PageRequest.of(page,2, Sort.Direction.DESC,"id");
        return boardRepository.findAll(pageable);
    }
    public List<GetId> findBoardTitle(String title){
        List<GetId> getId = boardRepository.findByTitle(title);
        return getId;
    }
    public List<Board> findTop3Board(){
        List<Board> getTop = boardRepository.findTop3ByOrderByIdDesc();
        return getTop;
    }
    /*
    public List<Long> findBoardTitles(String title){
        List<Board> findBoardTitle = boardRepository.findByTitle(title);
        List<Long> getTitle = new ArrayList<>();
        for(int i=0;i<=findBoardTitle.size()-1;i++){
            getTitle.add(findBoardTitle.get(i).getId());
        }
        return getTitle;
    }*/
}
