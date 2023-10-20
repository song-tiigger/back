package com.go.together.Service;

import com.go.together.Dto.FileDto;
import com.go.together.Mapper.FileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class FileSerive {
    private final FileMapper fileMapper;

    public void register(FileDto fileDto) {
        if (fileDto == null) {
            throw new IllegalArgumentException("파일정보누락");
        }
        fileMapper.insert(fileDto);
    }



    public void remover(Long productNumber){
        if(productNumber == null){
            throw new IllegalArgumentException("상품번호누락");}
        fileMapper.delete(productNumber);
        }

        public List<FileDto> findList(Long productNumber){
        return fileMapper.selectList(productNumber);
        }
    }




