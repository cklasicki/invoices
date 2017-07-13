package com.demo.invoices.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by czarek on 13.07.2017.
 */
public class Invoices {

    private List<Invoice> invoices;

    public Invoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public Invoices() {
        this.invoices = new ArrayList<Invoice>();
    }

    @Override
    public String toString() {
        return "Invoices{" +
                "invoices=" + invoices +
                '}';
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }
}
