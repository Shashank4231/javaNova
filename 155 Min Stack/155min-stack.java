class MinStack {
    Stack<Long> st;
    long min;

    public MinStack() {
        st = new Stack<>();
    }

    public void push(int value) {
        if (st.isEmpty()) {
            st.push((long) value);
            min = value;
        } else if (value >= min) {
            st.push((long) value);
        } else {
            st.push(2L * value - min);
            min = value;
        }
    }

    public void pop() {
        long top = st.pop();

        if (top < min) {
            min = 2 * min - top;
        }
    }

    public int top() {
        long top = st.peek();

        if (top >= min)
            return (int) top;

        return (int) min;
    }

    public int getMin() {
        return (int) min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */