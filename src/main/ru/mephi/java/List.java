public class List {
    private int len;
    private Item head;

    private class Item {
        private Object value;
        public Item next;

        public Item() {
            next = null;
        }

        public Item(Object value) {
            this.value = value;
            next = null;
        }
        @Override
        public String toString() {
            return " Item [" +
                    "value_=" + value +
                    ']';
        }
    }
    @Override
    public String toString() {
        return " List {" +
                "head=" + head +
                '}';
    }
    public List() {
        len = 0;
        this.head = null;
    }

    public List(Object value) {
        //Catch wrong
        if (value != null) {
            this.head = new Item(value);
            len = 1;
        } else {
            len = 0;
            this.head = null;
        }
    }

    public void add(Object value) {
        if (len > 0) {
            Item ptr = this.head;
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            ptr.next = new Item(value);
        } else {
            head = new Item(value);
        }
        len++;
    }

    public Object remove(int index) {
        //what if give null
        if (index > (this.len - 1) || index < 0) {
            System.out.println("Incorrect index");
            return null;
        }
        Item res;
        if (index == 0) {
            res = this.head;
            this.head = head.next == null ? null : this.head.next;
            res.next = null;
            //Вопрос где уничтожится res
        } else {
            Item ptr = this.head;
            while (index != 1) {
                ptr = ptr.next;
                index--;
            }
            res = ptr.next;
            ptr.next = ptr.next.next;
        }
        len--;
        return res.value;
    }

    public void add(Object value, int index) {
        if (index > (this.len - 1) || index < 0) {
            System.out.println("Incorrect index");
        } else {
            Item res;
            if (index > 0) {
                Item ptr = this.head;
                while (index != 1) {
                    ptr = ptr.next;
                    index--;
                }
                res = new Item(value);
                res.next = ptr.next;
                ptr.next = res;
            } else {
                res = this.head;
                this.head = new Item(value);
                this.head.next = res;
            }
            len++;
        }
    }

    private Item findByIndex(int index) {
        if (index > (this.len - 1) || index < 0) {
            System.out.println("Incorrect index");
            return null;
        }
        Item ptr = this.head;
        while (index != 0) {
            ptr = ptr.next;
            index--;
        }
        return ptr;
    }

    public Object set(int index, Object value) {

        Item ptr = this.findByIndex(index);
        if (ptr == null)
            return null;
        Object old = ptr.value;
        ptr.value = value;
        return old;
    }

    public Object get(int index) {
        Item res = findByIndex(index);
        return res == null ? null : res.value;
    }

    public int indexOf(Object value) {
        Item ptr = this.head;
        if(value == null)
        {
            for(int i = 0; i< len; ++i)
            {
                if(ptr.value == null)
                    return  i;
                ptr = ptr.next;
            }
        }else
        {
            for(int i = 0; i< len; ++i)
            {
                if(value.equals(ptr.value))
                    return  i;
                ptr = ptr.next;
            }
        }
        return  -1;
    }

    public boolean contains(Object value) {
        return indexOf(value)>= 0;
    }

    public int size() {
        return len;
    }

    public boolean isEmpty() {
        return len == 0 ? true : false;
    }
    private  void show ()
    {
        Item ptr= head;
        System.out.println("List {");
        for(int i = 0; i<len; i++ )
        {
            System.out.println(ptr);
            ptr = ptr.next;
        }
        System.out.println("}");
    }
    public static void main(String[] args) {
        List myList = new List();

        myList.add(1);
        myList.add(2);
        myList.add(3);

        myList.show();
        myList.add(4, 0);
        myList.add(6, 2);
        myList.add(8, -1);
        myList.add(5, 9);
        myList.add(7, myList.size());

        myList.show();
        myList.set(0, 9);
        myList.set(2, 41);
        myList.set(-1, 222);
        myList.set(333, 15);
        myList.set(myList.size() - 1,214 );

        myList.show();
        myList.remove(0);
        myList.remove(3);
        myList.remove(-1);
        myList.remove(7);
        myList.remove(myList.size() - 1);

        myList.show();
        System.out.printf(" Size: %d\n Empty: %b\n IndexOf: %d\n Get: %s\n", myList.size(), myList.isEmpty(), myList.indexOf(5), myList.get(3));
    }
}
