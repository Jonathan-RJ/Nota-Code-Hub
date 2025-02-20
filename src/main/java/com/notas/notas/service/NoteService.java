package com.notas.notas.service;

import java.util.List;

import com.notas.notas.dto.NoteResponseDto;

public interface NoteService {
    public List<NoteResponseDto> allNotes();

    public NoteResponseDto getNoteId(Long noteId);

}
