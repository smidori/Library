package library.utilities;

import java.util.Arrays;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Silvia Shimabuko
 */
public class Queue {

    private String[] data;
    private int front;
    private int back;
    private int capacity;
    private int queueSize;

    public Queue(int capacity) {
        this.capacity = capacity;
        this.data = new String[capacity];
        this.queueSize = 0;
        this.front = -1;
        this.back = -1;
    }

    public boolean Enqueue(String newElement) {
        if (queueSize >= capacity) {
            return false;
        }

        back++;
        if (front == -1) {
            front = back;
        }
        data[back] = newElement;
        queueSize++;
        return true;
    }

    public String Dequeue() {
        if (queueSize <= 0) {
            return null;
        }

        String removed = data[front];
        data[front] = null;
        //front++;
        queueSize--;
        //threat to move the index
        int count = 0;
        while (count < queueSize) {
            data[count] = data[count + 1];
            count++;
        }
        data[back] = null;
        back--;
        return removed;
    }

    public String First() {
        if (queueSize <= 0) {
            return null;
        }
        return data[front];
    }

    public String Last() {
        if (queueSize <= 0) {
            return null;
        }
        return data[back];
    }

    public int size() {
        return queueSize;
    }

    public boolean isEmpty() {
        return queueSize <= 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }

    public int hasElement(String target) {
        if (size() <= 0) {
            return -1;
        }
        for (int i = 0; i < size(); i++) {
            if (data[i].equalsIgnoreCase(target)) {
                return i;
            }
        }
        return -1;
    }

    public String getCSVFormat() {
        StringBuilder sb = new StringBuilder();
        if (size() <= 0) {
            return "";
        }
        boolean addSeparator = false;
        for (int i = 0; i < size(); i++) {
            if (addSeparator) {
                sb.append("|");
            }
            sb.append(data[i]);
            addSeparator = true;
        }
        return sb.toString();
    }
}
