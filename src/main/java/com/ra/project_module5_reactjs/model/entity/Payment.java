package com.ra.project_module5_reactjs.model.entity;

import com.ra.project_module5_reactjs.constant.PaymentStatusEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "payment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Payment
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private Double amount;
    private Date paymentDate;
    private String paymentMethod;
    @Enumerated(EnumType.STRING)
    private PaymentStatusEnum paymentStatus;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "booking_id", referencedColumnName = "id")
    private Booking booking;
}
