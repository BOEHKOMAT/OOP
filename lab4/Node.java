package com.company;

import java.io.Serializable;

public class Node<T> implements Serializable
{
        private Node next;
        private T data;

        public Node(){
        }

        public Node getNext() {
            return next;
        }
        public void setNext(Node next) {
            this.next = next;
        }
        public T getData() {
            return data;
        }
        public void setData(T data) {
            this.data = data;
        }
}
