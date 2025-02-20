package com.notas.notas.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.notas.notas.dto.NoteDto;
import com.notas.notas.dto.NoteResponseDto;
import com.notas.notas.entity.NoteEntity;
import com.notas.notas.handlerException.CustomException;
import com.notas.notas.repository.NoteRepository;
import com.notas.notas.service.NoteService;

@Service
public class NoteServiceImpl implements NoteService {

    private NoteRepository noteRepository;

    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public List<NoteResponseDto> allNotes() {
        try {
            List<NoteEntity> notes = noteRepository.findAll();
            List<NoteResponseDto> notesDto = new ArrayList<>();
            notes.forEach(note -> {
                notesDto.add(new NoteResponseDto(note.getId(), note.getTitle()));
            });
            return notesDto;

        } catch (Exception e) {
            throw new CustomException("Error al consultar" + e, 500, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public NoteResponseDto getNoteId(Long noteId) {
        try {
            NoteEntity note = noteRepository.findById(1L).orElse(null);
            if (note == null) {
                throw new CustomException("La nota no existe", 404, HttpStatus.NOT_FOUND);
            }
            return new NoteResponseDto(note.getId(), note.getTitle(), note.getContent(), note.getCreatedAt(),
                    note.getUpdatedAt());
        } catch (Exception e) {
            throw new CustomException("Error al consultar" + e, 500, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
