package com.paymentservice;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

@Id
private long payment_id;
private int bookingid;
private Date paymentDate;
private String user_id;
private double amount;
private String paymentStatus;


}
