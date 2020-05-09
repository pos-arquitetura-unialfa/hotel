package br.com.travelagency.hotel.service;

import br.com.travelagency.hotel.dto.HotelFilterDTO;
import br.com.travelagency.hotel.enums.ServiceStatus;
import br.com.travelagency.hotel.model.Reserve;

import java.time.LocalDate;
import java.util.List;

public interface ReserveService {

    List<Reserve> findByFilter(HotelFilterDTO hotelFilterDTO);

    Reserve reserve(Reserve reserve);

}
