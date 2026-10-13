public class LearningLinks {
    public static void main(String[] args){
        Node<Integer> one = new Node<Integer>(20);

        Node<Integer> two = new Node<Integer>(33);
        one.setLink(two);

        Node<Integer> three = new Node<Integer>(1);
        two.setLink(three);

        Node<Integer> four = new Node<Integer>(5);
        three.setLink(four);

        //System.out.println(one);
        //System.out.println(one.next);
        //System.out.println(one.next.next);
        //System.out.println(one.getNext().getNext().getNext());
        
        Node temp = one;
        while(temp != null){
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
        
        temp = one;
        while(temp.getNext() != null){
            temp = temp.getNext();
        }
        temp.setLink(new Node<Integer>(5));

        temp = one;
        while(temp != null){
            System.out.println(temp.getData());
            temp = temp.getNext();
        }

        Node newNode = new Node<Integer>(4);
        newNode.setLink(one);

        while(temp.getNext().getNext() != null){
            temp = temp.getNext();
        }
        temp.setLink(null);
        
        temp = newNode;
        while(temp != null){
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }
}