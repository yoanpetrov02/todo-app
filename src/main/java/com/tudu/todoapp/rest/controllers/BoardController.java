package com.tudu.todoapp.rest.controllers;

import com.tudu.todoapp.entities.Board;
import com.tudu.todoapp.exceptions.ResourceConflictException;
import com.tudu.todoapp.exceptions.ResourceNotFoundException;
import com.tudu.todoapp.services.interfaces.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest controller for boards.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/boards")
public class BoardController {

    private final BoardService boardService;

    @GetMapping
    public ResponseEntity<?> getBoards(
        @RequestParam(defaultValue = "1") Integer pageNumber,
        @RequestParam(defaultValue = "10") Integer itemsPerPage
    ) {
       List<Board> boards = boardService.getBoardsPage(pageNumber, itemsPerPage);
       if (boards.isEmpty()) {
           return ResponseEntity.noContent().build();
       }
       return new ResponseEntity<>(boards, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBoardById(@PathVariable Long id) {
        try {
            Board board = boardService.getBoardById(id);
            return new ResponseEntity<>(board, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> createBoard(@RequestBody Board board) {
        try {
            Board created = boardService.createBoard(board);
            return new ResponseEntity<>(created, HttpStatus.CREATED);
        } catch (ResourceConflictException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBoard(@PathVariable Long id, @RequestBody Board newData) {
        try {
            Board updated = boardService.updateBoard(id, newData);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAllBoards() {
        boardService.deleteAllBoards();
        return new ResponseEntity<>("Deleted all boards.", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBoardById(@PathVariable Long id) {
        try {
            boardService.deleteBoardById(id);
            return new ResponseEntity<>("Board deleted.", HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
