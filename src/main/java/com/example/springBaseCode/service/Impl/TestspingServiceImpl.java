package com.example.springBaseCode.service.Impl;

import com.example.springBaseCode.entity.Testsping;
import com.example.springBaseCode.repository.TestspingRepository;
import com.example.springBaseCode.service.TestspingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestspingServiceImpl implements TestspingService {

    private final TestspingRepository testspingRepository;

    @Autowired
    public TestspingServiceImpl(TestspingRepository testspingRepository) {
        this.testspingRepository = testspingRepository;
    }

    @Override
    public Testsping addTestsping(String name, String description) {
        // 새로운 Testsping 객체 생성
        Testsping testsping = new Testsping();
        testsping.setName(name);
        testsping.setDescription(description);

        // 데이터베이스에 저장
        return testspingRepository.save(testsping);
    }
}
