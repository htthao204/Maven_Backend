package com.example.ResManage.service;

import com.example.ResManage.domain.Topic;
import com.example.ResManage.domain.dto.request.TopicCreationRequest;
import com.example.ResManage.domain.dto.request.TopicUpdateRequest;
import com.example.ResManage.domain.dto.response.TopicResponse;
import com.example.ResManage.exception.TopicNotFoundException;
import com.example.ResManage.repository.TopicRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class TopicService {

    TopicRepository topicRepository;

    public TopicResponse createTopic(TopicCreationRequest request) {
        Topic topic = Topic.builder()
                .tenDeTai(request.getTenDeTai())
                .moTa(request.getMoTa())
                .idGiangVien(request.getIdGiangVien())
                .khoa(request.getKhoa())
                .linhVucNghienCuu(request.getLinhVucNghienCuu())
                .ngayBatDau(request.getNgayBatDau())
                .ngayKetThuc(request.getNgayKetThuc())
                .tinhTrang(request.getTinhTrang())
                .idNhom(request.getIdNhom())
                .idSinhVien(request.getIdSinhVien())
                .build();

        topic = topicRepository.save(topic);
        return mapToResponse(topic);
    }

    public TopicResponse updateTopic(Long id, TopicUpdateRequest request) {
        Topic topic = topicRepository.findById(id)
                .orElseThrow(() -> new TopicNotFoundException("Topic not found with id: " + id));

        topic.setTenDeTai(request.getTenDeTai());
        topic.setMoTa(request.getMoTa());
        topic.setIdGiangVien(request.getIdGiangVien());
        topic.setKhoa(request.getKhoa());
        topic.setLinhVucNghienCuu(request.getLinhVucNghienCuu());
        topic.setNgayBatDau(request.getNgayBatDau());
        topic.setNgayKetThuc(request.getNgayKetThuc());
        topic.setTinhTrang(request.getTinhTrang());
        topic.setIdNhom(request.getIdNhom());
        topic.setIdSinhVien(request.getIdSinhVien());

        topic = topicRepository.save(topic);
        return mapToResponse(topic);
    }

    public List<TopicResponse> getAllTopics() {
        return topicRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public TopicResponse getTopicById(Long id) {
        Topic topic = topicRepository.findById(id)
                .orElseThrow(() -> new TopicNotFoundException("Topic not found with id: " + id));
        return mapToResponse(topic);
    }

    public void deleteTopic(Long id) {
        if (!topicRepository.existsById(id)) {
            throw new TopicNotFoundException("Topic not found with id: " + id);
        }
        topicRepository.deleteById(id);
    }

    private TopicResponse mapToResponse(Topic topic) {
        return TopicResponse.builder()
                .Id(topic.getId())
                .tenDeTai(topic.getTenDeTai())
                .moTa(topic.getMoTa())
                .idGiangVien(topic.getIdGiangVien())
                .khoa(topic.getKhoa())
                .linhVucNghienCuu(topic.getLinhVucNghienCuu())
                .ngayBatDau(topic.getNgayBatDau())
                .ngayKetThuc(topic.getNgayKetThuc())
                .tinhTrang(topic.getTinhTrang())
                .idNhom(topic.getIdNhom())
                .idSinhVien(topic.getIdSinhVien())
                .build();
    }
}
