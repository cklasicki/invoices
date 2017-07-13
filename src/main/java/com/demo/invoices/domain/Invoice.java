package com.demo.invoices.domain;

import java.math.BigDecimal;
import java.util.Calendar;

/**
 * Created by czarek on 13.07.2017.
 */
public class Invoice {

    private String title;
    private BigDecimal totalAmount;
    private BigDecimal toPay;

    private Calendar issueDate;

    private DocumentStatus documentStatus;
    public Invoice(String title, BigDecimal totalAmount, BigDecimal toPay, Calendar issueDate, DocumentStatus documentStatus) {
        this.title = title;
        this.totalAmount = totalAmount;
        this.toPay = toPay;
        this.issueDate = issueDate;
        this.documentStatus = documentStatus;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "title='" + title + '\'' +
                ", totalAmount=" + totalAmount +
                ", toPay=" + toPay +
                ", issueDate=" + issueDate.getTime().toString() +
                ", documentStatus=" + documentStatus +
                '}';
    }

    public Calendar getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Calendar issueDate) {
        this.issueDate = issueDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getToPay() {
        return toPay;
    }

    public void setToPay(BigDecimal toPay) {
        this.toPay = toPay;
    }

    public DocumentStatus getDocumentStatus() {
        return documentStatus;
    }

    public void setDocumentStatus(DocumentStatus documentStatus) {
        this.documentStatus = documentStatus;
    }
}
