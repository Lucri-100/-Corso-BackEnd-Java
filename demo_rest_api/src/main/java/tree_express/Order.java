package tree_express;

import java.util.Objects;

public class Order {
    private static int id_count;
    private int id;
    //private int id_send;
    //private int id_receiver;
    private User sender, receiver;
    private double weight;
    private State state = State.Sending;

    public Order() {
    }

    public Order(int id, User sender, User receiver, double weight, State state) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.weight = weight;
        this.state = state;
    }

    public static int getId_count() {
        return id_count;
    }

    public static void setId_count(int id_count) {
        Order.id_count = id_count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", sender=" + sender +
                ", receiver=" + receiver +
                ", weight=" + weight +
                ", state=" + state +
                '}';
    }
}
