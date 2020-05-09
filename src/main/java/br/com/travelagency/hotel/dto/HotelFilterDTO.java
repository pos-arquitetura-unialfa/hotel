package br.com.travelagency.hotel.dto;

import br.com.travelagency.hotel.enums.ServiceStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class HotelFilterDTO {

    private String clientName;
    private LocalDate initialDate;
    private ServiceStatus serviceStatus;

}
