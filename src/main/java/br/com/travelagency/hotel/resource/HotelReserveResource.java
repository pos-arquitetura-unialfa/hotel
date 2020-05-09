package br.com.travelagency.hotel.resource;

import br.com.travelagency.hotel.dto.HotelFilterDTO;
import br.com.travelagency.hotel.enums.ServiceStatus;
import br.com.travelagency.hotel.model.Reserve;
import br.com.travelagency.hotel.service.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/hotelReserves")
public class HotelReserveResource {

    @Autowired
    private ReserveService reserveService;

    @GetMapping
    private List<Reserve> find(@RequestParam String clientName, @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate initialDate, @RequestParam(required = false) ServiceStatus serviceStatus) {
        return this.reserveService.findByFilter(new HotelFilterDTO(clientName, initialDate, serviceStatus));
    }

    @PostMapping
    public Reserve reserve(@RequestBody Reserve reserve){
        return this.reserveService.reserve(reserve);
    }



}
