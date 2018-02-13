package PTlab2;

import java.util.*;
//Посмотреть что наследует ЭррейЛист от чего наследует и что реализует
//добавить методы сюда
//сделать сортировку обобщенной, сортировка из Коллектион(с)
//сделать чтобы реализоввывались обобщенные методы
public class MyCollection<T>  implements Collection, List
{

    private T[] elements;
    private int index = 0;

    MyCollection(T[] elements)
    {
        if (!(elements.length == 0))
        {
            this.elements = elements;
            index = elements.length;
        }
        else
            this.elements = (T[]) new Object[1];
    }

    public int size()
    {
        return elements.length;
    }

    public boolean isEmpty() {
        if (elements.length == 0)
            return true;
        else
            return false;
    }

    public boolean contains(Object key) {
        for (T elem : elements)
            if (elem.equals(key))
                return true;

        return false;
    }

    public T[] toArray() {
        return (T[]) new Object[0];
    }

    public T[] toArray(Object[] a) {
        return  (T[]) new Object[0]; //???????????????????????????????????????
    }

    public boolean add(Object elem) {
        try {
            if (this.size() == index + 1)
                this.elements = (T[]) new Object[this.size() + 5];

            elements[index] = (T) elem;
            index++;

            return true;
        }
        catch(Exception e) {
            return false;
        }
    }

    public boolean add(T elem, int option)
    {
        try
        {
            if (this.size() == index + 1)
                if (option == 1)
                    this.elements = (T[]) new Object[this.size() + 5];
                else
                    this.elements = (T[]) new Object[this.size() * 2 + 50];

            elements[index] = elem;
            index++;
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    public boolean remove(Object key) {
        try {
            if (this.getIndex((T) key) == -1)
                return false;

            T[] newElements = (T[]) new Object[this.size()];
            for (int i = 0; i < this.getIndex((T) key); i++)
                newElements[i] = this.elements[i];

            for (int i = this.getIndex((T) key) + 1; i < this.size(); i++)
                newElements[i - 1] = this.elements[i];

            elements = newElements;
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public boolean addAll(Collection c)
    {
        try {
            for (Object elem : c)
                this.add(elem);

            return true;
        }
        catch(Exception e) {
            return false;
        }
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    public void clear() {
        this.elements = (T[]) new Object[1];
    }

    @Override
    public Object get(int index) {
        return elements[index];
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < elements.length; i++)
        {
            if (elements[i] == o)
                return i;
        }
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    public boolean retainAll(Collection coll) {
        try {
            for (Object elem : coll)
                if (!this.contains(coll))
                    this.remove(coll);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    public boolean removeAll(Collection c) {
        try {
            for (Object elem : c)
                if (this.contains(elem))
                    this.remove(elem);

            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean containsAll(Collection c) {
        for (Object elem : c)
            if (!(this.contains(elem)))
                return false;

        return true;
    }

    public Iterator<T> iterator() {
        return Arrays.asList(elements).iterator();
    }

    public int getIndex(T key)
    {
        for (int _index = 0; _index < this.size(); _index++)
        {
            if (this.contains(elements[_index]))
                return _index;
        }

        return -1;
    }
}
