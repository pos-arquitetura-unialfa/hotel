package br.com.travelagency.hotel;

import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@Configuration
public class ActiveMQConfigClient {

    public static final String PAYMENT_RESERVE_HOTEL = "PagamentoReservahHotel";
    
}
