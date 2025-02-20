package com.notas.notas.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.notas.notas.dto.NoteDto;
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
    public List<NoteDto> allNotes() {
        try {
            List<NoteEntity> notes = noteRepository.findAll();
            List<NoteDto> notesDto = new ArrayList<>();
            notes.forEach(note -> {
                notesDto.add(new NoteDto(note.getTitle(), note.getContent()));
            });
            return notesDto;

        } catch (Exception e) {
            throw new CustomException("Error al traes las notas", 500, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
