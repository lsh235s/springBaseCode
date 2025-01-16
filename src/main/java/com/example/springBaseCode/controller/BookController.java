package com.example.springBaseCode.controller;

import com.example.springBaseCode.dto.SearchRequest; // SearchRequest 클래스 임포트
import com.example.springBaseCode.repository.TestspingRepository;
import com.example.springBaseCode.service.TestspingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import com.example.springBaseCode.entity.Testsping;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private TestspingRepository testspingRepository;


    private final TestspingService testspingService;

    @Autowired
    public BookController(TestspingService testspingService) {
        this.testspingService = testspingService;
    }

    @PostMapping("/search")
    public ResponseEntity<String> helloWorld(@RequestBody SearchRequest request) {
        // Google Books API URL
        String apiUrl = "https://www.googleapis.com/books/v1/volumes?q=subject:" + request.getCondition();

        // RestTemplate을 사용하여 API 호출
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(apiUrl, String.class);

        // 결과 반환
        return ResponseEntity.ok(response);
    }

    // GET 요청 - Testsping에 데이터 추가
    @GetMapping("/add")
    public ResponseEntity<String> addTestSpingData() {
        // Testsping 엔티티 생성
        Testsping newEntry = new Testsping();
        newEntry.setName("Sample Name");
        newEntry.setDescription("This is a sample description");

        // 데이터베이스에 저장
        testspingRepository.save(newEntry);

        // 결과 반환
        return ResponseEntity.ok("Testsping 데이터가 추가되었습니다!");
    }

    // GET 요청 - Testsping 데이터 추가
    @GetMapping("/addMVC")
    public ResponseEntity<String> addTestMVCSpingData() {
        // 서비스 호출로 데이터 추가
        testspingService.addTestsping("Sample MVC Name", "This is a sample MVC description");
        return ResponseEntity.ok("Testsping MVC 데이터가 추가되었습니다!");
    }
}