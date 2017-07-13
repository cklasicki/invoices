package com.demo.invoices;

import com.demo.invoices.service.InvoiceServiceImpl;
import com.demo.invoices.service.InvoicesService;
import com.demo.invoices.utils.InvoicesUtils;

/**
 * Created by czarek on 13.07.2017.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Rozpoczęcie aplikacji");

        InvoicesService invoicesService = new InvoiceServiceImpl();

        System.out.println(InvoicesUtils.getTotalDebt(invoicesService.getAllInvoices()));

        System.out.println(InvoicesUtils.getTileStatus(invoicesService.getAllInvoices()));

    }
}
