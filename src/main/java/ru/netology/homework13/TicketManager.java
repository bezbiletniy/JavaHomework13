package ru.netology.homework13;

import java.util.Arrays;

public class TicketManager {

    private TicketRepository repo;

    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    public void add(Ticket ticket) {
        repo.saveTickets(ticket);
    }

    public Ticket[] searchBy(String from, String to) {
        Ticket[] result = new Ticket[0]; // тут будем хранить подошедшие запросу продукты
        for (Ticket ticket : repo.findAll()) {
            if (matches(ticket, from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;

                Arrays.sort(result);
            }
        }
        return result;
    }

    // метод определения соответствия товара product запросу search
    public boolean matches(Ticket ticket, String searchFrom, String searchTo) {
        if (ticket.getAirDepart().contains(searchFrom)) {
            return true;
        }
        if (ticket.getAirArrive().contains(searchTo)) {
            return true;
        } else {
            return false;
        }
    }

}
