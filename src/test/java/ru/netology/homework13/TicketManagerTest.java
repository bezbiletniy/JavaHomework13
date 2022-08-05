package ru.netology.homework13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicketManagerTest {

    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(1, 10_000, "DME", "LED", 2);
    Ticket ticket2 = new Ticket(2, 200_000, "DME", "AIA", 20);
    Ticket ticket3 = new Ticket(3, 25_000, "LED", "AJA", 5);
    Ticket ticket4 = new Ticket(4, 20_000, "LED", "AJA", 15);
    Ticket ticket5 = new Ticket(5, 35_000, "LED", "AJA", 5);
    Ticket ticket6 = new Ticket(6, 11_000, "DME", "LED", 2);
    Ticket ticket7 = new Ticket(7, 222_000, "DME", "AIA", 20);
    Ticket ticket8 = new Ticket(8, 27_000, "LED", "AJA", 5);
    Ticket ticket9 = new Ticket(9, 19_000, "LED", "AJA", 15);
    Ticket ticket10 = new Ticket(10, 39_000, "LED", "AJA", 5);

    @BeforeEach
    public void setup() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
    }

    @Test
    public void shouldAddTickets() {

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7, ticket8, ticket9, ticket10};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByTickets() {

        Ticket[] expected = {ticket9, ticket4, ticket3, ticket8, ticket5, ticket10};
        Ticket[] actual = manager.searchBy("LED", "AJA");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSearchByTickets() {

        Ticket[] expected = {};
        Ticket[] actual = manager.searchBy("MMA", "KKI");

        Assertions.assertArrayEquals(expected, actual);
    }

}
