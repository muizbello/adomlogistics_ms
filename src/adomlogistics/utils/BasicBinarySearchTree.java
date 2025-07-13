package adomlogistics.utils;

import adomlogistics.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class BasicBinarySearchTree {
    private Node root;

    class Node {
        Vehicle vehicle;
        Node left, right;

        public Node(Vehicle vehicle) {
            this.vehicle = vehicle;
        }
    }

    public void insert(Vehicle vehicle) {
        root = insertRec(root, vehicle);
    }

    private Node insertRec(Node node, Vehicle vehicle) {
        if (node == null) {
            return new Node(vehicle);
        }

        if (vehicle.mileage < node.vehicle.mileage) {
            node.left = insertRec(node.left, vehicle);
        } else {
            node.right = insertRec(node.right, vehicle);
        }

        return node;
    }

    // In-order traversal returns vehicles sorted by mileage
    public Vehicle[] inOrderTraversal() {
        List<Vehicle> result = new ArrayList<>();
        inOrderRec(root, result);
        return result.toArray(new Vehicle[0]);
    }

    private void inOrderRec(Node node, List<Vehicle> result) {
        if (node != null) {
            inOrderRec(node.left, result);
            result.add(node.vehicle);
            inOrderRec(node.right, result);
        }
    }
}

