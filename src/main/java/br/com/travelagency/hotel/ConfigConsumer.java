package br.com.travelagency.hotel;

import static br.com.travelagency.hotel.ActiveMQConfigClient.PAYMENT_RESERVE_HOTEL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import br.com.travelagency.hotel.dto.HotelFilterDTO;
import br.com.travelagency.hotel.service.ReserveServiceImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Configuration
public class ConfigConsumer   {
	
	@Autowired
	private ReserveServiceImpl reserveService;
	
	@JmsListener(destination = PAYMENT_RESERVE_HOTEL)
    public void receiveMessage(@Payload String payladPaymentCar) {
				
        if(!payladPaymentCar.equals(null)) {
        	try {
        		
        		Gson convert = new Gson();
        		
        		HotelFilterDTO objectConverted = convert.fromJson(payladPaymentCar, HotelFilterDTO.class);
        		
        		System.out.println(objectConverted);
        		
        		//reserveService.updateServiceStatus(objectConverted.getId());
        		
        		System.out.println(payladPaymentCar);
			} catch (Exception e) {
				log.error("Erro ao processar..", e);
			}
        }else {
        	
        	log.info("nada encontrado");
        }
    }
}
