package ru.netology.homework13;

import java.lang.annotation.Target;
import java.nio.file.FileAlreadyExistsException;
import java.rmi.AlreadyBoundException;

public class TicketRepository {

    Ticket[] ticket = new Ticket[0];

    public void saveTickets(Ticket newTicket) {

        if (this.findById(newTicket.getId()) != null)
            throw new AlreadyExistsException(
                    "Product with ID " + newTicket.getId() + " already exist"
            );

        Ticket[] tmp = new Ticket[ticket.length + 1];
        for (int i = 0; i < ticket.length; i++) {
            tmp[i] = ticket[i];
        }
        tmp[tmp.length - 1] = newTicket;
        ticket = tmp;
    }

    public Ticket[] getTickets() {
        return ticket;
    }

    public Ticket[] findAll() {
        Ticket[] all = getTickets();
        Ticket[] list = new Ticket[all.length];
        for (int i = 0; i < list.length; i++) {
            list[i] = all[i];
        }
        return list;
    }

    public void removeTickets(int id) {

        Ticket tick = findById(id);
        if (tick == null) {
            throw new NotFoundException(
                    "Elements with ID: " + id + " not found"
            );
        }

        Ticket[] tmp = new Ticket[ticket.length - 1];
        int copyToIndex = 0;
        for (Ticket ticket : ticket) {
            if (ticket.getId() != id) {
                tmp[copyToIndex] = ticket;
                copyToIndex++;
            }
        }
        ticket = tmp;
    }

    public Ticket findById(int id) {
        for (Ticket ticket : ticket) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }


}
