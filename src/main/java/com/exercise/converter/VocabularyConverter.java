package com.exercise.converter;

import com.exercise.dto.VocabularyDTO;
import com.exercise.entity.Vocabulary;
import com.exercise.vo.VocabularyVO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VocabularyConverter {

    Vocabulary toEntity(VocabularyDTO dto);

    VocabularyVO toVO(Vocabulary vocabulary);

    List<VocabularyVO> toVOList(List<Vocabulary> vocabularies);
}
