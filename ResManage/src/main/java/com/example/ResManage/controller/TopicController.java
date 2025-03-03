package com.example.ResManage.controller;
import com.example.ResManage.domain.Topic;
import com.example.ResManage.domain.dto.request.APIResponse;
import com.example.ResManage.domain.dto.request.TopicCreationRequest;
import com.example.ResManage.domain.dto.request.TopicUpdateRequest;
import com.example.ResManage.domain.dto.response.TopicResponse;
import com.example.ResManage.service.TopicService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topics")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TopicController {


    @Autowired
    private TopicService topicService;

    @PostMapping
    public TopicResponse createTopic(@RequestBody TopicCreationRequest request) {
        return topicService.createTopic(request);
    }
    @PutMapping("/{id}")
    public TopicResponse updateTopic(@PathVariable Long id, @RequestBody @Valid TopicUpdateRequest request) {
        return topicService.updateTopic(id, request);
    }

    @GetMapping
    public List<TopicResponse> getAllTopics() {
        return topicService.getAllTopics();
    }

    @GetMapping("/{id}")
    public Optional<TopicResponse> getTopicById(@PathVariable Long id) {
        return topicService.getTopicById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTopic(@PathVariable Long id) {
        topicService.deleteTopic(id);
    }
}

