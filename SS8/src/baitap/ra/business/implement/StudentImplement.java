package baitap.ra.business.implement;

import baitap.ra.business.config.InputMethods;
import baitap.ra.business.design.CRUD;
import baitap.ra.business.entity.Student;

public class StudentImplement implements CRUD {
    private static Student[] students = new Student[100];
    private int size = 0;
    @Override
    public void create() {
        if (size == 100){
            System.err.println("mảng đầy");
        }else {
            // logic thêm mới
            // ta 1 đối tượng student
            Student newStudent = new Student();
            newStudent.inputData();
            // thêm vào mang
            students[size] = newStudent;
            size++; // tăng số lương
        }
    }

    @Override
    public void display() {
        if (size == 0){
            System.err.println("mảng ko co ptu");
        }else {
            for (int i = 0; i < size; i++) {
                System.out.println(students[i]);
            }
        }
    }

    @Override
    public void edit() {
        System.out.println("Nhập vào mã của sinh vien cần thay đổi");
        int input = InputMethods.getInteger();
        for (int i = 0; i < size; i++) {
            if (input==students[i].getStudentId()) {
                System.out.println(students[i]);;
                students[i].inputData();
                break;
            }
        }
    }

    @Override
    public void delete() {
        int index=-1;
        System.out.println("Nhập vào mã của sinh vien cần xóa");
        int input = InputMethods.getInteger();
        for (int i = 0; i < size; i++) {
            if (input==students[i].getStudentId()) {
                 index=i;
                 break;
            }
        }
        for (int i = index; i < size-1; i++) {
            students[i]=students[i+1];
        }
        students[size-1]=null;
        size--;
    }
}
