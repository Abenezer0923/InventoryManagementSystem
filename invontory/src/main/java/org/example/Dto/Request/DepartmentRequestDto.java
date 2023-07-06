package org.example.Dto.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentRequestDto {
   // private Long id;
    private String name;
    private String status;
}
