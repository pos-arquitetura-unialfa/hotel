package br.com.travelagency.hotel.model;

import br.com.travelagency.hotel.enums.ServiceStatus;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "RESERVAS")
public class Reserve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOME_CLIENTE")
    private String clientName;

    @Column(name = "NOME_CIDADE")
    private String cityName;

    @Column(name = "NOME_HOTEL")
    private String hotelName;

    @Column(name = "PRECO")
    private BigDecimal price;

    @Column(name = "DATA_INICIO")
    private LocalDate initialDate;

    @Column(name = "DATA_FIM")
    private LocalDate endDate;

    @Column(name = "STATUS_SERVICO")
    private ServiceStatus serviceStatus;

    @Override
    public String toString() {
        return "Reserve{" +
                "id=" + id +
                ", cityName='" + cityName + '\'' +
                ", hotelName='" + hotelName + '\'' +
                ", price=" + price +
                ", initialDate=" + initialDate +
                ", endDate=" + endDate +
                ", serviceStatus=" + serviceStatus +
                '}';
    }
}
