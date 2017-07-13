package com.demo.invoices.service;

import com.demo.invoices.domain.DocumentStatus;
import com.demo.invoices.domain.Invoice;
import com.demo.invoices.domain.Invoices;

import java.math.BigDecimal;
import java.util.GregorianCalendar;

/**
 * Created by czarek on 13.07.2017.
 */
public class InvoiceServiceImpl implements InvoiceService {

    public Invoices getAllInvoices() {

        Invoices invoices = new Invoices();
        invoices.getInvoices().add(new Invoice("F/2017/07", BigDecimal.valueOf(100), BigDecimal.valueOf(43), new GregorianCalendar(2017, 6, 1), DocumentStatus.UNPAID_BEFORE_DUE_DATE));
        invoices.getInvoices().add(new Invoice("F/2017/06", BigDecimal.valueOf(145), BigDecimal.valueOf(10), new GregorianCalendar(2017, 5, 1), DocumentStatus.UNPAID_AFTER_DUE_DATE));
        invoices.getInvoices().add(new Invoice("F/2017/05", BigDecimal.valueOf(100), BigDecimal.valueOf(100), new GregorianCalendar(2017, 4, 1), DocumentStatus.UNPAID_AFTER_DUE_DATE));
        invoices.getInvoices().add(new Invoice("F/2017/04", BigDecimal.valueOf(104), BigDecimal.valueOf(100), new GregorianCalendar(2017, 3, 1), DocumentStatus.UNPAID_AFTER_DUE_DATE));
        invoices.getInvoices().add(new Invoice("F/2017/03", BigDecimal.valueOf(174), BigDecimal.valueOf(0), new GregorianCalendar(2017, 2, 1), DocumentStatus.PAID));

        return invoices;
    }
}
