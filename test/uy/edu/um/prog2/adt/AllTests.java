package uy.edu.um.prog2.adt;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import uy.edu.um.prog2.adt.binarytree.withnode.SearchBinaryTreeImplTest;
import uy.edu.um.prog2.adt.hash.HashImplTest;
import uy.edu.um.prog2.adt.heap.HeapImplTest;
import uy.edu.um.prog2.adt.linkedlist.LinkedListImplTest;
import uy.edu.um.prog2.adt.queue.QueueImplTest;
import uy.edu.um.prog2.adt.stack.StackImplTest;

@RunWith(Suite.class)
@SuiteClasses({QueueImplTest.class, StackImplTest.class, LinkedListImplTest.class, SearchBinaryTreeImplTest.class, HashImplTest.class, HeapImplTest.class})
public class AllTests {

}
