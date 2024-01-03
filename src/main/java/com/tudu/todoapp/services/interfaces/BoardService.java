package com.tudu.todoapp.services.interfaces;

import com.tudu.todoapp.entities.Board;
import com.tudu.todoapp.entities.User;
import com.tudu.todoapp.exceptions.ResourceConflictException;
import com.tudu.todoapp.exceptions.ResourceNotFoundException;

import java.util.List;

/**
 * Business logic related to {@code Board} entities.
 */
public interface BoardService {

    /**
     * Returns all boards.
     */
    List<Board> getAllBoards();

    /**
     * Returns the page with the amount of boards per page, or as many as there are on that page in the database.
     *
     * @param pageNumber the number of the page.
     *                   This value gets converted to an index by subtracting 1 from it,
     *                   so don't modify the value before passing it to this method.
     * @param perPage the amount of boards on each page.
     * @return the page as a {@code List}.
     */
    List<Board> getBoardsPage(int pageNumber, int perPage);

    /**
     * Returns the board with that id.
     *
     * @throws ResourceNotFoundException if the board was not found.
     */
    Board getBoardById(Long boardId) throws ResourceNotFoundException;

    /**
     * Creates the new board in the database.
     *
     * @param board the board's information.
     * @return the saved {@code Board}.
     * @throws ResourceConflictException if a board with the same id already exists.
     */
    Board createBoard(Board board) throws ResourceConflictException;

    /**
     * Updates the board with the given id with the new data.
     *
     * @param boardId the id of the board.
     * @param newData the new data of the board.
     * @return the updated {@code Board}.
     * @throws ResourceNotFoundException if the board was not found.
     */
    Board updateBoard(Long boardId, Board newData) throws ResourceNotFoundException;

    /**
     * Deletes all boards from the database.
     */
    void deleteAllBoards();

    /**
     * Deletes the board with the given id.
     *
     * @param boardId the id of the board.
     */
    void deleteBoardById(Long boardId) throws ResourceNotFoundException;
}
