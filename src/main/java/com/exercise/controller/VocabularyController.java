package com.exercise.controller;

import com.exercise.common.ApiResponse;
import com.exercise.common.PageResult;
import com.exercise.dto.VocabularyDTO;
import com.exercise.entity.Vocabulary;
import com.exercise.service.VocabularyService;
import com.exercise.vo.VocabularyVO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vocabulary")
@RequiredArgsConstructor
public class VocabularyController {

    private final VocabularyService vocabularyService;

    @GetMapping("/list")
    public List<Vocabulary> list() {
        return vocabularyService.list();
    }

    @GetMapping("/search")
    public ApiResponse<List<VocabularyVO>> search(
            @RequestParam(defaultValue = "") String keyword) {
        return ApiResponse.success(vocabularyService.search(keyword));
    }

    @PostMapping("/add")
    public int add(@Valid @RequestBody VocabularyDTO dto) {
        return vocabularyService.add(dto);
    }

    @PutMapping("/update")
    public int update(@RequestBody Vocabulary vocabulary) {
        return vocabularyService.update(vocabulary);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Integer> deleteById(@PathVariable Long id) {

        int result = vocabularyService.deleteById(id);

        return ApiResponse.success(result);
    }

    @GetMapping("/page")
    public PageResult<VocabularyVO> page(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "20") int size
    ) {
        return vocabularyService.page(page, size);
    }

    @GetMapping("/search/{id}")
    public ApiResponse<Vocabulary> searchById(@PathVariable long id) {
        return ApiResponse.success(vocabularyService.searchById(id));
    }
}
