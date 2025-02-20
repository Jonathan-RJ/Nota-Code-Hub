package com.notas.notas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notas.notas.dto.NoteResponseDto;
import com.notas.notas.service.NoteService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/notes")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @GetMapping
    public List<NoteResponseDto> getNoteAll() {
        return noteService.allNotes();
    }

    @GetMapping("/{noteId}")
    public NoteResponseDto getNoteById(@PathVariable Long noteId) {
        return noteService.getNoteId(noteId);
    }

}
