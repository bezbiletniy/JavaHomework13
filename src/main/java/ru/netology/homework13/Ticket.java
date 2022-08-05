package ru.netology.homework13;

public class Ticket implements Comparable<Ticket> {

    private int id;
    private int cost;
    private String airDepart;
    private String airArrive;
    private int time;

    public Ticket(int id, int cost, String airDepart, String airArrive, int time) {
        this.id = id;
        this.cost = cost;
        this.airDepart = airDepart;
        this.airArrive = airArrive;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getAirDepart() {
        return airDepart;
    }

    public void setAirDepart(String airDepart) {
        this.airDepart = airDepart;
    }

    public String getAirArrive() {
        return airArrive;
    }

    public void setAirArrive(String airArrive) {
        this.airArrive = airArrive;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public int compareTo(Ticket o) {
        if (this.cost < o.cost) {
            return -1;
        }
        if (this.cost > o.cost) {
            return 1;
        } else {
            return 0;
        }
    }
}
