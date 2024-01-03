package com.tudu.todoapp.services.implementations;

import com.tudu.todoapp.entities.Board;
import com.tudu.todoapp.exceptions.ResourceConflictException;
import com.tudu.todoapp.exceptions.ResourceNotFoundException;
import com.tudu.todoapp.repositories.BoardRepository;
import com.tudu.todoapp.services.interfaces.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Board Service implementation.
 *
 * @see BoardService
 */
@RequiredArgsConstructor
@Service
class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }

    @Override
    public List<Board> getBoardsPage(int pageNumber, int perPage) {
        int pageIndex = pageNumber - 1;
        Pageable page = PageRequest.of(pageIndex, perPage);
        return boardRepository.findAll(page).toList();
    }

    @Override
    public Board getBoardById(Long boardId) {
        return boardRepository.findById(boardId)
            .orElseThrow(() -> new ResourceNotFoundException("The board with the specified id was not found."));
    }

    @Override
    public Board createBoard(Board board) {
        if (board.getBoardId() != null && boardRepository.existsById(board.getBoardId())) {
            throw new ResourceConflictException("A board with the same id already exists.");
        }
        return boardRepository.save(board);
    }

    @Override
    public Board updateBoard(Long boardId, Board newData) {
        Board dbBoard = boardRepository.findById(boardId)
            .orElseThrow(() -> new ResourceNotFoundException("The board with the specified id was not found."));
        dbBoard.setTitle(newData.getTitle());
        dbBoard.setDescription(newData.getDescription());
        return boardRepository.save(dbBoard);
    }

    @Override
    public void deleteAllBoards() {
        boardRepository.deleteAll();
    }

    @Override
    public void deleteBoardById(Long boardId) {
        if (!boardRepository.existsById(boardId)) {
            throw new ResourceNotFoundException("The board with the specified id was not found.");
        }
        boardRepository.deleteById(boardId);
    }
}
