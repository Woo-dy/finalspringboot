package com.ict.finalspringboot.domain.userrxtbl.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ict.finalspringboot.domain.userrxtbl.service.UserRxTblService;
import com.ict.finalspringboot.domain.userrxtbl.vo.UserRxTblVO;
import com.ict.finalspringboot.domain.userrxtbl.vo.DataVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/userrxtbl")
public class UserRxTblController {
    @Autowired
    private UserRxTblService userRxTblService;

    @GetMapping("/list")
    public DataVO getUserRxTblList() {
        DataVO dataVO = new DataVO();
    
        try {
            log.info("Controller: getUserRxTblList 호출");
            List<UserRxTblVO> list = userRxTblService.getUserRxTblList();
            log.info("Controller: list : " + list);
            dataVO.setSuccess(true);
            dataVO.setMessage("진료 기록 조회 성공");
            dataVO.setData(list);
        } catch (Exception e) {
            dataVO.setSuccess(false);
            dataVO.setMessage("진료 기록 조회 실패: " + e.getMessage());
            dataVO.setData(null);
            e.printStackTrace();
        }
    
        return dataVO;
    }
    
    @PostMapping("/detail")
    public DataVO getUserRxTblDetail(@RequestBody Map<String, String> requestBody) {
        DataVO dataVO = new DataVO();
        String post_num = requestBody.get("post_num"); // POST 요청 본문에서 rx_idx를 가져옴
        try {
            log.info("post_num : " + post_num);
            
            List<UserRxTblVO> urvo = userRxTblService.getUserRxTblById(post_num);

            if (urvo == null) {

                log.info("brvonull1 : " + urvo);
                log.info("brvonull2 : " + dataVO);

                dataVO.setSuccess(false);
                dataVO.setMessage("진료 기록 상세보기 실패1");
                return dataVO;
            }

            log.info("brvoTrue1 : " + urvo);
            log.info("brvoTrue2 : " + dataVO);

            dataVO.setSuccess(true);
            dataVO.setMessage("진료 기록 상세보기 성공");
            dataVO.setData(urvo);
        } catch (Exception e) {
            dataVO.setSuccess(false);
            dataVO.setMessage("진료 기록 상세보기 실패2: " + e.getMessage());
        }
        return dataVO;
    }

    @DeleteMapping("/delete/{post_num}")
    public DataVO getUserRxTblDelete(@PathVariable("post_num") String post_num) {
        DataVO dataVO = new DataVO();

        try {
            int result = userRxTblService.getUserRxTblDelete(post_num);
            if (result == 0) {
                dataVO.setSuccess(false);
                dataVO.setMessage("진료 기록 삭제 실패");
                return dataVO;
            }
            dataVO.setSuccess(true);
            dataVO.setMessage("진료 기록 삭제 성공");
            // dataVO.setData(result);
        } catch (Exception e) {
            dataVO.setSuccess(false);
            dataVO.setMessage("진료 기록 삭제 오류 발생");
        }

        return dataVO;
    }

    @PostMapping("/write")
    public DataVO createBoardRecord(
        @ModelAttribute("data") String data, UserRxTblVO urvo,
        Authentication authentication) {
    
        DataVO dataVO = new DataVO();
    
        log.info("환영합니다. 사실 환영 못해요ㅜㅜ");
        
        // JSON 문자열을 파싱하여 필요한 데이터 추출
        ObjectMapper objectMapper = new ObjectMapper();
    
        try {
            // JSON 문자열을 Map으로 변환
            Map<String, Object> payload = objectMapper.readValue(data, new TypeReference<Map<String, Object>>() {});
    
            // editorContent 값 추출
            String editorContent = (String) payload.get("editorContent");
            System.out.println("Editor Content: " + editorContent); // 로그로 출력
            
            // 처리 로직
            MultipartFile file = urvo.getFile();
            if (file.isEmpty()) {
                urvo.setRx_photo("");
            } else {
                UUID uuid = UUID.randomUUID();
                String f_name = uuid.toString() + "_" + file.getOriginalFilename();
                urvo.setRx_photo(f_name);
    
                // Windows 외부 경로 설정
                String path = "C:\\upload";
                File uploadDir = new File(path);
    
                // 디렉토리가 없으면 생성
                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                }
    
                // 파일 저장
                file.transferTo(new File(uploadDir, f_name));
            }
    
            // 게스트북 쓰기
            int result = userRxTblService.getUserRxTblWrite(urvo);
    
            if (result == 0) {
                dataVO.setSuccess(false);
                dataVO.setMessage("게스트북 쓰기 실패");
                return dataVO;
            }
            
            // 성공 시 editorContent를 DataVO에 설정
            dataVO.setSuccess(true);
            dataVO.setMessage("게스트북 쓰기 성공");
            // dataVO.setData(result); // 필요 시 추가
    
        } catch (Exception e) {
            log.error("오류 발생:", e);
            dataVO.setSuccess(false);
            dataVO.setMessage("오류 발생: " + e.getMessage());
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
