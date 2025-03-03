package com.example.ResManage.domain.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TopicUpdateRequest {
    String tenDeTai;
    String moTa;
    String idGiangVien;
    String khoa;
    String linhVucNghienCuu;
    LocalDate ngayBatDau;
    LocalDate ngayKetThuc;
    String tinhTrang;
    String idNhom;
    String idSinhVien;
}
