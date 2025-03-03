package com.example.ResManage.domain.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TopicCreationRequest {

     @NotBlank(message = "TOPIC_NAME_REQUIRED")
     @Size(min = 5, message = "TOPIC_NAME_TOO_SHORT")
     String tenDeTai;

     @NotBlank(message = "DESCRIPTION_REQUIRED")
     String moTa;

     @NotBlank(message = "LECTURER_ID_REQUIRED")
     String idGiangVien;

     @NotBlank(message = "DEPARTMENT_REQUIRED")
     String khoa;

     @NotBlank(message = "RESEARCH_FIELD_REQUIRED")
     String linhVucNghienCuu;

     @NotNull(message = "START_DATE_REQUIRED")
     @DateTimeFormat(pattern = "dd/MM/yyyy")
     LocalDate ngayBatDau;

     @NotNull(message = "END_DATE_REQUIRED")
     @FutureOrPresent(message = "END_DATE_MUST_BE_FUTURE")
     @DateTimeFormat(pattern = "dd/MM/yyyy")
     LocalDate ngayKetThuc;

     @NotBlank(message = "STATUS_REQUIRED")
     String tinhTrang;

     @NotBlank(message = "GROUP_ID_REQUIRED")
     String idNhom;

     @NotBlank(message = "STUDENT_ID_REQUIRED")
     String idSinhVien;
}
