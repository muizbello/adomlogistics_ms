package adomlogistics.utils;
import adomlogistics.model.Delivery;

public class DeliveryQueue {
    private Delivery[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public DeliveryQueue(int capacity) {
        this.capacity = capacity;
        queue = new Delivery[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(Delivery delivery) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        rear = (rear + 1) % capacity;
        queue[rear] = delivery;
        size++;
    }

    public Delivery dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        Delivery delivery = queue[front];
        front = (front + 1) % capacity;
        size--;
        return delivery;
    }

    public Delivery peek() {
        if (isEmpty()) {
            return null;
        }
        return queue[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int size() {
        return size;
    }

    public Delivery[] getAllDeliveries() {
        Delivery[] deliveries = new Delivery[size];
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            deliveries[i] = queue[index];
        }
        return deliveries;
    }
}
