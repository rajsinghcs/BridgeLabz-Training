package com.strike.fundooNotesApp.service;

import com.strike.fundooNotesApp.dto.LabelRequest;
import com.strike.fundooNotesApp.dto.LabelResponse;
import com.strike.fundooNotesApp.entity.Label;
import com.strike.fundooNotesApp.entity.User;
import com.strike.fundooNotesApp.exception.LabelAlreadyExistException;
import com.strike.fundooNotesApp.repository.LabelRepository;
import com.strike.fundooNotesApp.repository.NoteRepository;
import com.strike.fundooNotesApp.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabelService {
    private final LabelRepository labelRepository;
    private final UserRepository userRepository;
    public LabelService(LabelRepository labelRepository,UserRepository userRepository){
        this.labelRepository=labelRepository;
        this.userRepository=userRepository;
    }
    private User getLoggedInUser() {

        String email = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        return userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));
    }


    public LabelResponse createLabel(LabelRequest request){
        User user=getLoggedInUser();
        if(labelRepository.findByLabelNameAndUser(request.getLabelName(),user).isPresent()){
            throw new LabelAlreadyExistException("Label already exists");
        }

 Label label=new Label();
        label.setLabelName(request.getLabelName());
        label.setUser(user);

        return mapToResponse(labelRepository.save(label));
    }

    private LabelResponse mapToResponse(Label label){
        return  new LabelResponse(
                label.getLabelId(),
                label.getLabelName()
        );

    }
    public List<LabelResponse> getAllLabels() {

        User user = getLoggedInUser();

        return labelRepository.findByUser(user)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }
    public void deleteLabel(Long labelId) {

        User user = getLoggedInUser();

        Label label = labelRepository
                .findByLabelIdAndUser(labelId, user)
                .orElseThrow(() ->
                        new RuntimeException("Label not found"));

        labelRepository.delete(label);
    }
}
