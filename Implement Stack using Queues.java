class MyStack {
    Queue<Integer> q = new LinkedList<>();
    public MyStack() {
        
    }
    
    public void push(int x) {
        q.add(x);
    }
    
    public int pop() {
        Queue<Integer> top = new LinkedList<>();
        
        int size =  q.size();

        for(int i =0;i<size-1;i++){
            top.add(q.remove());
        }
        int ans =  q.remove();
        

        for(int i =0;i<size-1;i++){
            q.add(top.remove());
        }
        return ans;
        
    }
    
    public int top() {
        Queue<Integer> top = new LinkedList<>();
        int size =  q.size();
        for(int i =0;i<size-1;i++){
            top.add(q.remove());
        }
        int ans =  q.peek();
        top.add(q.remove());

        for(int i =0;i<size;i++){
            q.add(top.remove());
        }
        return ans;
    }
    
    public boolean empty() {
        
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */