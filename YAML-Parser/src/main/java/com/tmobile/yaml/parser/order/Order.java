package com.tmobile.yaml.parser.order;

import java.time.LocalDate;
import java.util.List;

public class Order {
    private String orderNo;
    private LocalDate date;
    private String customerName;
    private List<OrderLine> orderLines;



    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < orderLines.size(); i++) {
            s += "-item:" + orderLines.get(i).getItem() +
                    "quantity:" + orderLines.get(i).getQuantity() +
                    "unitPrice:" + orderLines.get(i).getUnitPrice();
        }
        return "Orders{" +
                "orderNo:" + orderNo +
                "date:" + date +
                "customerName:" + customerName +
                "orderLines:" + s + "}";
    }
}