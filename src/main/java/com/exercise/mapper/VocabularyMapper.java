package com.exercise.mapper;

import com.exercise.entity.Vocabulary;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VocabularyMapper {

    List<Vocabulary> selectAll();

    List<Vocabulary> search(String keyword);

    Vocabulary searchById(Long id);

    int insert(Vocabulary vocabulary);

    int update(Vocabulary vocabulary);

    int deleteById(Long id);

    long count();

    List<Vocabulary> selectPage(int offset, int size);

}