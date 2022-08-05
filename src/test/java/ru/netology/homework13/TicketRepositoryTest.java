package ru.netology.homework13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TicketRepositoryTest {

    TicketRepository repo = new TicketRepository();

    Ticket ticket1 = new Ticket(1, 10_000, "DME", "LED", 2);
    Ticket ticket2 = new Ticket(2, 200_000, "DME", "AIA", 20);
    Ticket ticket3 = new Ticket(3, 25_000, "LED", "AJA", 5);
    Ticket ticket4 = new Ticket(4, 20_000, "AJA", "AGA", 15);
    Ticket ticket5 = new Ticket(5, 35_000, "DME", "AGA", 5);

    @Test
    public void shouldSaveTickets() {

        repo.saveTickets(ticket1);

        Ticket[] expected = {ticket1};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldNotSaveTickets() {

        Ticket[] expected = {};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSGetAllTickets() {

        repo.saveTickets(ticket1);
        repo.saveTickets(ticket2);
        repo.saveTickets(ticket3);
        repo.saveTickets(ticket4);
        repo.saveTickets(ticket5);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldAlreadyExistsException() {

        repo.saveTickets(ticket1);
        repo.saveTickets(ticket2);
        repo.saveTickets(ticket3);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.saveTickets(ticket3);
        });
    }

    @Test
    public void shouldRemoveTickets() {

        repo.saveTickets(ticket1);
        repo.saveTickets(ticket2);
        repo.saveTickets(ticket3);
        repo.removeTickets(3);

        Ticket[] expected = {ticket1, ticket2};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void NotFoundException() {

        repo.saveTickets(ticket1);
        repo.saveTickets(ticket2);
        repo.saveTickets(ticket3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeTickets(4);
        });
    }


}
