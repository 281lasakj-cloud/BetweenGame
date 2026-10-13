public class LearningLinks {
    public static void main(String[] args){
        Node<Integer> one = new Node<Integer>(20);

        Node<Integer> two = new Node<Integer>(33);
        one.setLink(two);

        Node<Integer> three = new Node<Integer>(1);
        two.setLink(three);

        Node<Integer> four = new Node<Integer>(21);
        three.setLink(four);

        //System.out.println(one);
        //System.out.println(one.next);
        //System.out.println(one.next.next);
        System.out.println(one.next.next.next);
    }
}