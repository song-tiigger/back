package com.go.together.Service;

import com.go.together.Dto.FileDto;
import com.go.together.Mapper.FileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class FileService {
    private final FileMapper fileMapper;

    // application.properties에 저장해둔 file.dir 프로퍼티 값을 가져온다 (경로)
    @Value("${file.dir}")
    private String fileDir;

    public void register(FileDto fileDto) {
        if (fileDto == null) {
            throw new IllegalArgumentException("파일정보누락");
        }
        fileMapper.insert(fileDto);
    }



    public void remove(Long productNumber){
        if(productNumber == null){
            throw new IllegalArgumentException("상품번호누락");}
        fileMapper.delete(productNumber);
        }

        public List<FileDto> findList(Long productNumber){
        return fileMapper.selectList(productNumber);
        }

    //파일 저장 처리
    public FileDto saveFile(MultipartFile file)throws IOException{
        //사용자가 올린 파일 이름 (확장자를 포함)
        String originName = file.getOriginalFilename();

        //파일 이름에 붙여줄 uuid 생성(파일 이름 중복이 나오지 않게 처리하기위해)
        UUID uuid=UUID.randomUUID();

        //UUID와 + 사용자가 올린 이름 합친거
        String sysName=uuid.toString() + "_" +originName;

        File uploadPath=new File(fileDir , getUploadPath());


        //경로가 존재하지 않는다면 (폴더가 없다면)
        if(!uploadPath.exists()){
            //경로에 필요한 폴더를 생성한다
            uploadPath.mkdirs();
        }
        //전체 경로와 파일 이름을 연결한다
        File uploadFile=new File(uploadPath ,sysName);

        //매개변수로 받은 파일을 우리가 만든 경로와 이름으로 저장한다 . 
        //파일 매개변수에 transferTo를 사용해 저장하는데 경로를 uplodadFile에 있는 경로를 통해 저장한다
        //transferTO (경로)
        //MultipartFile 객체를 실제로 저장시킨다.
        //저장시킬 경로와 이름을 매개변수로 넘겨주면 된다.
        file.transferTo(uploadFile);


        //productNumber을 제외한 모든 정보를 가진 FileDto를 반환한다.
            FileDto fileDto =new FileDto();
            fileDto.setFileUuid(uuid.toString());
            fileDto.setFileName(originName);
            fileDto.setFileUploadPath(getUploadPath());


        return fileDto;


    }

    /**
     *
     * @param files 여러 파일을 담은 리스트
     * @param productNumber 파일이 속하는 product 상품 번호
     * @throws IOException
     */

    public void registerAndSaveFiles(List<MultipartFile> files ,Long productNumber)throws IOException{
        for(MultipartFile file : files){
            FileDto fileDto=saveFile(file);
            fileDto.setProductNumber(productNumber);
            register(fileDto);
        }
    }


    //파일이 저장되는 하위 경로를 현재 날짜로 설정할 것이기 때문에 현재 날짜를 구한다.
    private String getUploadPath(){return new SimpleDateFormat("yyyy/MM/dd").format(new Date());
    }


    }




