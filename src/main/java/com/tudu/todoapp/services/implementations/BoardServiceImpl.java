package com.tudu.todoapp.services.implementations;

import com.tudu.todoapp.entities.Board;
import com.tudu.todoapp.entities.User;
import com.tudu.todoapp.exceptions.ResourceConflictException;
import com.tudu.todoapp.exceptions.ResourceNotFoundException;
import com.tudu.todoapp.services.interfaces.BoardService;

import java.util.List;

public class BoardServiceImpl implements BoardService {

    @Override
    public List<Board> getAllBoards() {
        return null;
    }

    @Override
    public List<Board> getBoardsPage(int pageNumber, int perPage) {
        return null;
    }

    @Override
    public Board getBoardById(Long boardId) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public Board createBoard(Board board) throws ResourceConflictException {
        return null;
    }

    @Override
    public Board updateBoard(Long boardId, User newData) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public void deleteAllBoards() {

    }

    @Override
    public void deleteBoardById(Long boardId) throws ResourceNotFoundException {

    }
}
