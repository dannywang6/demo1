package com.exercise.service;


import com.exercise.common.PageResult;
import com.exercise.converter.VocabularyConverter;
import com.exercise.dto.VocabularyDTO;
import com.exercise.entity.Vocabulary;
import com.exercise.mapper.VocabularyMapper;
import com.exercise.vo.VocabularyVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VocabularyService {

    private final VocabularyMapper vocabularyMapper;

    private final VocabularyConverter vocabularyConverter;



    public List<Vocabulary> list() {
        return vocabularyMapper.selectAll();
    }

    public List<VocabularyVO> search(String keyword) {

        List<Vocabulary> vocabularies = vocabularyMapper.search(keyword);

        return vocabularyConverter.toVOList(vocabularies);
    }

    public int add(VocabularyDTO dto) {
        Vocabulary vocabulary = vocabularyConverter.toEntity(dto);

        return vocabularyMapper.insert(vocabulary);
    }

    public int update(Vocabulary vocabulary) {

        if (vocabulary.getId() == null) {
            throw new RuntimeException("ID 不能为空");
        }
        int rows = vocabularyMapper.update(vocabulary);
        if (rows == 0) {
            throw new RuntimeException("词汇不存在");
        }
        return rows;
    }

    public int deleteById(Long id) {

        int rows = vocabularyMapper.deleteById(id);
        if (rows == 0) {
            throw new RuntimeException("词汇不存在");
        }
        return rows;
    }

    public Vocabulary searchById(long id) {
        return vocabularyMapper.searchById(id);
    }

    public PageResult<VocabularyVO> page(int page, int size) {
        int offset = (page - 1) * size;
        long total = vocabularyMapper.count();
        List<Vocabulary> list = vocabularyMapper.selectPage(offset, size);
        return new PageResult<>(total, vocabularyConverter.toVOList(list));
    }

}
