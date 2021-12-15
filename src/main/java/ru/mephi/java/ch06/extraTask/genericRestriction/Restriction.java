package ru.mephi.java.ch06.extraTask.genericRestriction;

import ru.mephi.java.ch06.extraTask.contrvar.Filter;
import ru.mephi.java.ch06.task03.Entry;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class Restriction<T> {

    static Integer p;
    //static T pr;

    public static void main(String[] args) {
        // Don't use primitive
        //ArrayList<int> ar = new ArrayList<int>(); no
        ArrayList<Integer> arr = new ArrayList<>();


        // instanceof Arraylist<String> impossible
        ArrayList<String> strings = new ArrayList<>();
        Object obj = strings;
        if(obj instanceof ArrayList){
            List<String> list = Collections.checkedList(new ArrayList<>(), String.class);
            list = (ArrayList<String>) obj;
            //  list = (ArrayList<Object>) obj;
            Class<? extends List<String>> c = (Class<? extends List<String>>) list.getClass(); // don't have sense
            System.out.println(c.getName());// java.util.ArrayList
        }
        //massive of generics is illegal
        // Entry<String, Integer>[] es = new Entry<String, Integer>[5];
        @SuppressWarnings("unchecked")
        Entry<String, Integer>[] es2 = new Entry[5]; // почему нельзя массив дженериков

    }

    /*public static T get(T pr){
        return pr;
    }*/

    // create instance
    public static <T> T getConstr(Class<T> cl) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
       // T t = new T;
        return cl.getDeclaredConstructor().newInstance();
    }
    public <T> void method(){
      //  Class<T> c = T.class;
        // Class<T[]>c2=T[].class;
      //  Class<ArrayList<T>>c3 = ArrayList<T>.class;
    }


    // Exception
    // public class GenericException<T> extends Exception{} (no)
    public static <T extends Throwable> void doWork(Predicate<T> pr, T te) {
    //    try {
    //        pr.test(te);
      //  } catch (T ex) { // Error—can’t catch type variable
       //     ex.printStackTrace();
      //  }
        // почему нельзя делать дженерик эксешн
    }

}
