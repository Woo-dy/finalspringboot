package com.ict.finalspringboot.domain.boardrecords.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ict.finalspringboot.domain.boardrecords.service.BoardRecordsService;
import com.ict.finalspringboot.domain.boardrecords.vo.BoardRecordsVO;
import com.ict.finalspringboot.domain.boardrecords.vo.DataVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/boardrecords")
public class BoardRecordsController {
    @Autowired
    private BoardRecordsService boardRecordsService;

    @GetMapping("/list")
    public DataVO getBoardRecordsList() {
        DataVO dataVO = new DataVO();
    
        try {
            log.info("Controller: getBoardRecordsList 호출");
            List<BoardRecordsVO> list = boardRecordsService.getBoardRecordsList();
            log.info("Controller: list : " + list);
            dataVO.setSuccess(true);
            dataVO.setMessage("게스트북 조회 성공");
            dataVO.setData(list);
        } catch (Exception e) {
            dataVO.setSuccess(false);
            dataVO.setMessage("게스트북 조회 실패: " + e.getMessage());
            dataVO.setData(null);
            e.printStackTrace();
        }
    
        return dataVO;
    }

    @PostMapping("/mybasicboardrecordswrite")
    public DataVO createBoardRecord(
        @ModelAttribute("data") BoardRecordsVO brvo,
        Authentication authentication) {
    DataVO dataVO = new DataVO();

            log.info("환영합니다. 사실 환영 못해요ㅜㅜ");


            try {
                // 처리 로직
                MultipartFile file = brvo.getFile();
                if (file.isEmpty()) {
                    brvo.setRx_photo("");
                } else {
                    UUID uuid = UUID.randomUUID();
                    String f_name = uuid.toString() + "_" + file.getOriginalFilename();
                    brvo.setRx_photo(f_name);


                    // Windows 외부 경로 설정
                    String path = "C:\\upload";
                    File uploadDir = new File(path);
                    // application.yml 수정 : file.upload.dir=D:/upload

                    // 프로젝트 내부의 resources/static/upload 경로
                    // String path = new File("src/main/resources/static/upload").getAbsolutePath();

                    // 디렉토리가 없으면 생성
                    if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                    }

                    // 파일 저장
                    file.transferTo(new File(uploadDir, f_name));
                }

                // 게스트북 쓰기
                int result = boardRecordsService.getBoardRecordsWrite(brvo);

                if (result == 0) {
                    dataVO.setSuccess(false);
                    dataVO.setMessage("게스트북 쓰기 실패");
                    return dataVO;
                }
                dataVO.setSuccess(true);
                dataVO.setMessage("게스트북 쓰기 성공");
                 // dataVO.setData(result);
            } catch (Exception e) {
                log.error("오류 발생:", e);
            }

            return dataVO;
    }

    // 업로드 경로 설정
    private static final String UPLOAD_DIR = "uploads/";

    // 파일 업로드 API
    @PostMapping("/upload")
    public ResponseEntity<Object> uploadFile(@RequestParam("upload") MultipartFile file) {
        try {
            // 파일 이름 생성
            String fileName = file.getOriginalFilename();
            Path path = Paths.get(UPLOAD_DIR + fileName);
            
            // 업로드 디렉토리 확인 및 생성
            File uploadDir = new File(UPLOAD_DIR);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }

            // 파일을 지정한 경로로 저장
            Files.write(path, file.getBytes());

            // 업로드된 파일 URL 생성
            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/uploads/")
                    .path(fileName)
                    .toUriString();

            // 파일 URL을 반환
            return ResponseEntity.ok().body(new ImageUploadResponse(fileDownloadUri));
        } catch (IOException e) {
            return ResponseEntity.status(500).body("파일 업로드 실패: " + e.getMessage());
        }
    }

    // 이미지 업로드 응답 클래스
    public static class ImageUploadResponse {
        private String url;

        public ImageUploadResponse(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
