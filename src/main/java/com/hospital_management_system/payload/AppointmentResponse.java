package com.hospital_management_system.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor


public class AppointmentResponse {                                      //        ……………………..(pagination)


    private List<AppointmentDTO> reasonForVisit;
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;


    public static AppointmentResponse build(List<AppointmentDTO> reasonForVisit, int pageNo, int pageSize, long totalElements, int totalPages, boolean last) {
        return new AppointmentResponse(reasonForVisit, pageNo, pageSize, totalElements, totalPages, last);
    }
}
