package com.go.together.Mapper;

import com.go.together.Dto.FileDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileMapper {
    public void insert(FileDto fileDto);

    public void delete(Long fileNumber);

    public List<FileDto> selectList(Long productNumber);

    public List<FileDto> selectOldList();

}
