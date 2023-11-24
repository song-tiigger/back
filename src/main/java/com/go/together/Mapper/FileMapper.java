package com.go.together.Mapper;

import com.go.together.Dto.FileDto;
import com.go.together.Dto.ProductDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileMapper {
    public void insert(FileDto fileDto);
    public void delete(Long ProductNumber);
    public List<FileDto> selectList(Long ProductNumber);
    public List<FileDto> selectOldList();

}
