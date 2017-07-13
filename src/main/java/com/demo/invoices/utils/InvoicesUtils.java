package com.demo.invoices.utils;

import com.demo.invoices.domain.DocumentStatus;
import com.demo.invoices.domain.Invoice;
import com.demo.invoices.domain.Invoices;
import com.demo.invoices.domain.TileStatus;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Comparator;
import java.util.function.Predicate;

/**
 * Created by czarek on 13.07.2017.
 */
public final class InvoicesUtils {

    private static Comparator<Invoice> byIssueDate = Comparator.comparing(Invoice::getIssueDate);

    private static Predicate<Invoice> onlyUnpaid = e1 -> e1.getDocumentStatus() != DocumentStatus.PAID;
    private static Predicate<Invoice> onlyUnpaidAfter = e1 -> e1.getDocumentStatus() == DocumentStatus.UNPAID_AFTER_DUE_DATE;
    private static Predicate<Invoice> onlyPaid = e1 -> e1.getDocumentStatus() == DocumentStatus.PAID;
    private static Predicate<Invoice> onlyInvoices = e1 -> e1.getTitle().startsWith("F");
    private static Predicate<Invoice> inPresentBillCycle = e1 -> e1.getIssueDate().get(Calendar.MONTH) >= Calendar.getInstance().get(Calendar.MONTH);
    private static Predicate<Invoice> inProgress = e1 -> e1.getDocumentStatus() == DocumentStatus.IN_PROGRESS;


    public static double getTotalDebt(Invoices invoices) {
        return invoices.getInvoices().stream()
                .map(Invoice::getToPay)
                .reduce(BigDecimal.ZERO, BigDecimal::add).doubleValue();
    }

    public static TileStatus getTileStatus(Invoices invoices) {

        if (getTotalDebt(invoices) > 0) { //sprawdzam czy w ogole jest cos do zaplacenia

            if (isInProgress(invoices)) { //sprawdzam czy jakakolwiek jest in progress
                return TileStatus.IN_PROGRESS;
            } else if (invoices.getInvoices().stream().filter(onlyUnpaid).allMatch(onlyUnpaidAfter)) {
                return TileStatus.DEBT;
            }
            return TileStatus.TO_PAY;
        } else if (getTotalDebt(invoices) == 0) {
            return TileStatus.ALL_PAID;
        } else
            return TileStatus.OVERPAYMENT;
    }

    public static String getStatusText(Invoices invoices) {


        return "";
    }

    private static boolean isInProgress(Invoices invoices) {
        return invoices.getInvoices().stream()
                .anyMatch(inProgress);
    }

    public static boolean getInvoiceFromThisBillCycle(Invoices invoices) {


        invoices.getInvoices().stream()
                .sorted(byIssueDate)
                .filter(onlyInvoices.and(onlyUnpaid))
                .filter(onlyUnpaid)
                .filter(inPresentBillCycle)
                .forEach(System.out::println);

        return false;
    }
}
