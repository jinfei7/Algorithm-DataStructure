package linkedlist;

public class SingleLinkList<T> {


    private Node<T> head;//头节点

    private int length;//链表长度

    public SingleLinkList(){
        head = new Node<>();
        length = 0;
    }


    //插入尾部
    public boolean add(T data){
        Node<T> node = new Node<>();
        node.setData(data);

        Node<T> temp = head;
        while (temp.getNext() != null){
            temp = temp.getNext();
        }

        temp.setNext(node);
        length++;
        return true;

    }


    public boolean addByIndex(int index, T data){
        //位置不合理就直接添加到最后
        if (index <0 || index > length -1){
            add(data);
            return true;
        }


        Node<T> temp = head;
        while (index != 0){
            temp = temp.getNext();
            index --;
        }

        Node<T> tempNext = temp.getNext();
        Node<T> newNode = new Node<>();
        newNode.setData(data);
        newNode.setNext(tempNext);
        temp.setNext(newNode);
        length++;


        return true;
    }


    //获取数据
    public T getByIndex(int index){

        if (index <0 || index > length -1){
            System.out.println("index <0 or > length -1");
            return null;
        }

        Node<T> temp = head;

        while (index !=0){
            temp = temp.getNext();
            index --;
        }

        return temp.getNext().getData();

    }




    //根据索引删除
    public boolean removeByIndex(int index){
        if (index <0 || index > length -1){
            System.out.println("index <0 or > length -1");
            return false;
        }

        Node<T> temp = head;
        while (index != 0){
            temp = temp.getNext();
            index --;
        }

        temp.setNext(temp.getNext().getNext());
        length --;


        return true;
    }


    //遍历单链表
    public void inverse(){

        Node<T> temp = head;
        while (temp.getNext() != null){
            temp = temp.getNext();
            System.out.println("节点: "+temp.getData());

        }

    }


    public static void main(String[] args) {
        SingleLinkList<Integer> linkList = new SingleLinkList<>();
        int length = 2;
        for (int i = 0; i < length; i++) {
            linkList.add(i);
        }
        System.out.println("SingleLinkList 初始化成功 length="+length);
        System.out.println("======测试getByIndex======");
        for (int i = 0; i < linkList.length; i++) {
            System.out.println(linkList.getByIndex(i));
        }

        int index = 1;
        System.out.println("======测试removeByIndex(index="+index+")======");
        linkList.removeByIndex(index);
        for (int i = 0; i < linkList.length; i++) {
            System.out.println(linkList.getByIndex(i));
        }


        System.out.println("======测试addByIndex(index="+index+")======");
        linkList.addByIndex(index,7);
        for (int i = 0; i < linkList.length; i++) {
            System.out.println(linkList.getByIndex(i));
        }
    }







    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public long getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public class Node<T>{

        T data;
        Node<T> next;


        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}
