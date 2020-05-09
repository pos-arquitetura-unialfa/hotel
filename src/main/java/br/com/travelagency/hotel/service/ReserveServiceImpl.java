package br.com.travelagency.hotel.service;

import br.com.travelagency.hotel.dto.HotelFilterDTO;
import br.com.travelagency.hotel.enums.ServiceStatus;
import br.com.travelagency.hotel.model.Reserve;
import br.com.travelagency.hotel.repository.ReserveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReserveServiceImpl implements ReserveService {

    @Autowired
    private ReserveRepository repository;

    @Override
    public List<Reserve> findByFilter(HotelFilterDTO filter) {
        return repository.findByClientNameIgnoreCaseAndInitialDateOrServiceStatus(filter.getClientName(), filter.getInitialDate(), filter.getServiceStatus());
    }

    @Override
    @Transactional
    public Reserve reserve(Reserve reserve) {
        reserve.setServiceStatus(ServiceStatus.REQUEST);
        return repository.save(reserve);
    }
}
