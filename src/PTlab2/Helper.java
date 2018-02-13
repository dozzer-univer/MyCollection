package PTlab2;

//858830
//2080133

//29856
//9797

//40120
//54114
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Helper
{
    void StartProgram()
    {
        System.out.println("Привет, давайте проведем тест для сравнения 2-х коллекций");
        System.out.println("Тест состоит с 3-х этапов: добавление, удаление и поиск");
        System.out.println("Добавление 1000 элементов в коллекцию:");
        addTest();
        System.out.println("Удаление элемента из коллекции:");
        removeTest();
        System.out.println("Поиск элемента в коллекции:");
        findTest();
    }

    void addTest() {
        Double[] _elements = new Double[0];
        List<Double> list = new ArrayList<>();
        MyCollection<Double> myCollection = new MyCollection<>(_elements);
        Random random = new Random();
        _elements = new Double[1000];

        for (int i = 0; i < 1000; i++)
            _elements[i] = random.nextDouble();
/*
        long Start = System.nanoTime();
        for (int i = 0; i < 1000; i++)
            list.add(_elements[i]);
        long End = System.nanoTime();
        long addTime = End - Start;

        System.out.println("Время добавления 1000 элементов для ArrayList = " + addTime);*/

        long Start = System.nanoTime();
        for (int i = 0; i < 1000; i++)
            myCollection.add(_elements[i], 2);
        long End = System.nanoTime();
        long addTime = End - Start;

        System.out.println("Время добавления 1000 элементов для MyCollection = " + addTime);
    }
    void removeTest() {
        Integer[] _elements = {5, 6, 7, 123, 21, 34, 214, 345, 454, 4656, 32, 12, 435, 1245, 35 ,56, 5467, 578, 234, 477, 4666, 10005};
        List<Integer> list = new ArrayList<>();
        MyCollection<Integer> myCollection = new MyCollection<>(_elements);
/*
        for (Integer elem : _elements)
            list.add(elem);

        long Start = System.nanoTime();
        list.remove(9);
        long End = System.nanoTime();
*/
     //   System.out.println("Время удаления элемента из ArrayList = " + (End - Start));

        long Start = System.nanoTime();
        myCollection.remove(9);
        long End = System.nanoTime();

        System.out.println("Время удаления элемента из MyCollection = " + (End - Start));
    }

    void findTest() {
        Integer[] _elements = {5, 6, 7, 123, 21, 34, 214, 345, 454, 4656, 32, 12, 435, 1245, 35 ,56, 5467, 578, 234, 477, 4666, 10005};
        List<Integer> list = new ArrayList<Integer>();
        MyCollection<Integer> myCollection = new MyCollection<>(_elements);

        Integer a;
        Collections.sort(myCollection);
        long Start = System.nanoTime();

        a = myCollection.getIndex(435);

        long End = System.nanoTime();
//17727
        System.out.println("Время поиска элемента в MyCollection = " + (End - Start));
/*
        for (Integer elem : _elements)
            list.add(elem);

        long Start = System.nanoTime();
        list.indexOf(435);
        long End = System.nanoTime();

        System.out.println("Время поиска элемента в ArrayList = " + (End - Start));*/


    }
}
