package com.userservice;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {


private long payment_id;
private int bookingid;
private Date paymentDate;
private String user_id;
private double amount;
private String paymentStatus;


}
