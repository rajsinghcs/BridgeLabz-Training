package com.strike.fundooNotesApp.controller;

import com.strike.fundooNotesApp.dto.LabelRequest;
import com.strike.fundooNotesApp.dto.LabelResponse;
import com.strike.fundooNotesApp.service.LabelService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/labels")
public class LabelController {
    private final LabelService labelService;

    public LabelController(LabelService labelService){
        this.labelService=labelService;
    }
    @PostMapping("/create")
    public ResponseEntity<LabelResponse> createLabel(@Valid @RequestBody LabelRequest request){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(labelService.createLabel(request));
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<LabelResponse>> getAllLabels() {

        return ResponseEntity.ok(
                labelService.getAllLabels()
        );
    }

    @DeleteMapping("/delete/{labelId}")
    public ResponseEntity<String> deleteLabel(
            @PathVariable Long labelId) {

        labelService.deleteLabel(labelId);

        return ResponseEntity.ok("Label Deleted Successfully");
    }
}
