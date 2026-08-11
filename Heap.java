import java.util.Scanner;

public class Heap {

    static int[] heap;
    static int size = 0;

    static void insert(int value) {
        if (size == heap.length) {
            System.out.println("Heap is full.");
            return;
        }

        heap[size] = value;
        int current = size;
        size++;

        while (current > 0) {
            int parent = (current - 1) / 2;

            if (heap[parent] >= heap[current]) {
                break;
            }

            int temp = heap[parent];
            heap[parent] = heap[current];
            heap[current] = temp;

            current = parent;
        }

        System.out.println("Element inserted successfully.");
    }

    static void display() {
        if (size == 0) {
            System.out.println("Heap is empty.");
            return;
        }

        System.out.print("Heap elements: ");

        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter heap size: ");
        int capacity = sc.nextInt();

        heap = new int[capacity];

        while (true) {
            System.out.println("\n===== MAX HEAP =====");
            System.out.println("1. Insert");
            System.out.println("2. Display");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element: ");
                    insert(sc.nextInt());
                    break;

                case 2:
                    display();
                    break;

                case 3:
                    System.out.println("Program ended.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
