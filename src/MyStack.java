public class MyStack {
    MyListO myList = new MyListO();

    static void main() {
        MyStack myStack = new MyStack();
        myStack.push(2);
        System.out.println(myStack.peek());
        myStack.push(3);
        System.out.println(myStack);
        System.out.println(myStack.size());
        myStack.push(4);
        System.out.println(myStack);
        myStack.push(5);
        System.out.println(myStack);
        myStack.pop();
        System.out.println(myStack);
        myStack.clear();
        System.out.println(myStack.size());
    }

    public void push(double x) {
        myList.add(x);
    }

    public double pop() {
        myList.remove(myList.size() - 1);
        return myList.size() - 1;
    }

    public double peek() {
        return myList.size() - 1;
    }

    public int size() {
        return myList.size();
    }

    public void clear() {
        myList.clear();
    }

    public String toString() {
        return myList.toString();
    }
}