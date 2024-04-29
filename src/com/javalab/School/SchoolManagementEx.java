package com.javalab.School;

import java.util.Scanner;

public class SchoolManagementEx {
    private static DataRepository repo = new DataRepository();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("=============================");
            System.out.println("학사 행정관리 프로그램");
            System.out.println("=============================");
            System.out.println("1. 학생 관련 업무");
            System.out.println("2. 교수 관련 업무");
            System.out.println("3. 학과 관련 업무");
            System.out.println("4. 성적 관련 업무");
            System.out.println("5. 종료");
            System.out.println("=============================");
            System.out.print("메뉴 선택: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    studentMenu();
                    break;
                case 2:
                    professorMenu();
                    break;
                case 3:
                    departmentMenu();
                    break;
                case 4:
                    takesMenu();
                    break;
                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
            }
        }
    }

//  교수 업무 관련 메소드
    private static void professorMenu() { // 교수 관련 업무 메소드
        Scanner scanner = new Scanner(System.in);
        System.out.println("=============================");
        System.out.println("1. 교수 등록");
        System.out.println("2. 교수 조회");
        System.out.println("3. 교수 정보 수정");
        System.out.println("4. 교수 정보 삭제");
        System.out.println("5. 메인 메뉴로 가기");
        System.out.println("=============================");
        System.out.print("메뉴 선택: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                registerProfessor(scanner);
                break;
            case 2:
                displayProfessor();
                break;
            case 3:
                updateProfessor(scanner);
                break;
            case 4:
                deleteProfessor(scanner);
                break;
            case 5:
                System.out.println("메인 메뉴로 돌아갑니다");
                scanner.close();
                return;
            default:
                System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
        }
    }

    private static void registerProfessor(Scanner scanner) { // 교수 등록
        System.out.println("교수 ID: ");
        String id = scanner.nextLine();
        System.out.println("주민번호: ");
        String jumin = scanner.nextLine();
        System.out.println("이름: ");
        String name = scanner.nextLine();
        System.out.println("학과 코드: ");
        int department = scanner.nextInt();
        scanner.nextLine();
        System.out.println("직급: ");
        String grade = scanner.nextLine();
        System.out.println("입사일: ");
        String hiredate = scanner.nextLine();
        scanner.nextLine();

        Professor professor = new Professor(id, jumin, name, department, grade, hiredate);
        repo.getProfessors().add(professor);
        System.out.println("교수 정보가 성공적으로 등록되었습니다.");
    }

    private static void displayProfessor() {
        System.out.println("등록된 교수 목록:");
        System.out.println("교수ID 이름 학과코드 직급 입사일");
        for (Professor p : repo.getProfessors()) {
            System.out.println(p.getId() + " " + p.getName() + " " + p.getDepartment() + " " + p.getGrade() + " " + p.getHiredate());
        }
    }

    private static void updateProfessor(Scanner scanner) {
        System.out.println("수정할 교수의 ID를 입력하세요: ");
        String id = scanner.nextLine();
        for (Professor p : repo.getProfessors()) {
            if (p.getId().equals(id)) {
                System.out.println("새 이름: ");
                String name = scanner.nextLine();
                System.out.println("새 주민번호: ");
                String jumin = scanner.nextLine();
                System.out.println("새 직급: ");
                String grade = scanner.nextLine();
                scanner.nextLine();
                System.out.println("새 입사일 : ");
                String hiredate = scanner.nextLine();
                System.out.println("새 학과 코드: ");
                int department = scanner.nextInt();
                scanner.nextLine();

                p.setJumin(jumin);
                p.setName(name);
                p.setGrade(grade);
                p.setHiredate(hiredate);
                p.setDepartment(department);
                System.out.println("교수 정보가 업데이트 되었습니다.");
                return;
            }
        }
        System.out.println("해당 ID의 교수를 찾을 수 없습니다.");
    }

    private static void deleteProfessor(Scanner scanner) {
        System.out.println("삭제할 교수의 ID를 입력하세요: ");
        String id = scanner.nextLine();
        for (int i = 0; i < repo.getProfessors().size(); i++) {
            if (repo.getProfessors().get(i).getId().equals(id)) {
                repo.getProfessors().remove(i);
                System.out.println("교수 정보가 삭제되었습니다.");
                return;
            }
        }
        System.out.println("해당 ID의 교수를 찾을 수 없습니다.");
    }
// 교수 관련 업무 메소드 끝

// 학과 관련 업무 메소드
    private static void departmentMenu() { // 학과 관련 업무 메소드
        Scanner scanner = new Scanner(System.in);
        System.out.println("=============================");
        System.out.println("1. 학과 등록");
        System.out.println("2. 학과 조회");
        System.out.println("3. 학과 정보 수정");
        System.out.println("4. 학과 정보 삭제");
        System.out.println("5. 메인 메뉴로 가기");
        System.out.println("=============================");
        System.out.print("메뉴 선택: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1 :
                registerDepartment(scanner);
            case 2 :
                displayDepartment();
            case 3 :
                updateDepartment(scanner);
            case 4 :
                deleteDepartment(scanner);
            case 5 :
                return;
            default :
                System.out.println("잘못된 입력입니다. 다시 선택해주세요");
        }

    }
    private static void registerDepartment(Scanner scanner) {
        System.out.println("학과 코드: ");
        String id = scanner.nextLine();
        System.out.println("학과명: ");
        String name = scanner.nextLine();
        System.out.println("학과 사무실");
        String office = scanner.nextLine();

        Department department = new Department(id, name, office);
        repo.getDepartments().add(department);
        System.out.println("학과 정보가 성공적으로 등록되었습니다.");
    }
    private static void displayDepartment() {
        System.out.println("등록된 학과 목록");
        System.out.println("학과코드 학과명 학과사무실");
        for(Department d : repo.getDepartments()) {
            System.out.println(d.getId() + " " + d.getName() + " " + d.getOffice());
        }
    }
    private static void updateDepartment(Scanner scanner) { // 학과 정보 수정
        System.out.println("수정할 학과 코드를 입력해주세요");
        String id = scanner.nextLine();
        for(Department d : repo.getDepartments()) {
            if(d.getId().equals(id)) {
                System.out.println("수정할 학과명: ");
                String name = scanner.nextLine();
                System.out.println("수정할 학과 사무실: ");
                String office = scanner.nextLine();

                d.setName(name);
                d.setOffice(office);
                System.out.println("학과 정보가 업데이트 되었습니다.");
                return;
            }
            System.out.println("해당 코드의 학과를 찾을 수 없습니다.");
        }
    }


    private static void deleteDepartment(Scanner scanner) { // 학과 정보 삭제
        System.out.println("삭제할 학과 코드를 입력해주세요");
        String id = scanner.nextLine();
        for ( int i = 0; i < repo.getDepartments().size(); i++) {
            if (repo.getDepartments().get(i).getId().equals(id)) {
                repo.getDepartments().remove(i);
                System.out.println("학과 정보가 삭제되었습니다.");
                return;
            }
        }
        System.out.println("해당 코드의 학과를 찾을 수 없습니다.");
    }

// 학과 관련 업무 메소드 끝
    private static void takesMenu() { // 성적 관련 업무 메소드
        Scanner scanner = new Scanner(System.in);
        System.out.println("=============================");
        System.out.println("1. 성적 등록");
        System.out.println("2. 성적 조회");
        System.out.println("3. 성적 수정");
        System.out.println("4. 메인 메뉴로 가기");
        System.out.println("=============================");
        System.out.print("메뉴 선택: ");
    }

    private static void studentMenu() { // 학생 관련 업무 메소드
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("=============================");
            System.out.println("1. 학생 등록");
            System.out.println("2. 학생 조회");
            System.out.println("3. 학생 정보 수정");
            System.out.println("4. 학생 정보 삭제");
            System.out.println("5. 메인 메뉴로 가기");
            System.out.println("=============================");
            System.out.print("메뉴 선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 버퍼 비우기

            switch (choice) {
                case 1:
                    registerStudent(scanner);
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    updateStudent(scanner);
                    break;
                case 4:
                    deleteStudent(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
            }
        }
    }

    private static void registerStudent(Scanner scanner) {
        System.out.println("학생 ID: ");
        String id = scanner.nextLine();
        System.out.println("주민번호: ");
        String jumin = scanner.nextLine();
        System.out.println("이름: ");
        String name = scanner.nextLine();
        System.out.println("학년: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("주소: ");
        String address = scanner.nextLine();
        System.out.println("학과 코드: ");
        int department = scanner.nextInt();
        scanner.nextLine();

        Student student = new Student(id, jumin, name, year, address, department);
        repo.getStudents().add(student);
        System.out.println("학생 정보가 성공적으로 등록되었습니다.");
    }

    private static void displayStudents() {
        System.out.println("등록된 학생 목록:");
        System.out.println("학생ID 이름 학년 주소 학과코드");
        for (Student s : repo.getStudents()) {
            System.out.println(s.getId() + " " + s.getName() + " " + s.getYear() + " " + s.getAddress() + " " + s.getDepartment());
        }
    }

    private static void updateStudent(Scanner scanner) {
        System.out.println("수정할 학생의 ID를 입력하세요: ");
        String id = scanner.nextLine();
        for (Student s : repo.getStudents()) {
            if (s.getId().equals(id)) {
                System.out.println("새 주민번호: ");
                String jumin = scanner.nextLine();
                System.out.println("새 이름: ");
                String name = scanner.nextLine();
                System.out.println("새 학년: ");
                int year = scanner.nextInt();
                scanner.nextLine();
                System.out.println("새 주소: ");
                String address = scanner.nextLine();
                System.out.println("새 학과 코드: ");
                int department = scanner.nextInt();
                scanner.nextLine();

                s.setJumin(jumin);
                s.setName(name);
                s.setYear(year);
                s.setAddress(address);
                s.setDepartment(department);
                System.out.println("학생 정보가 업데이트 되었습니다.");
                return;
            }
        }
        System.out.println("해당 ID의 학생을 찾을 수 없습니다.");
    }

    private static void deleteStudent(Scanner scanner) {
        System.out.println("삭제할 학생의 ID를 입력하세요: ");
        String id = scanner.nextLine();
        for (int i = 0; i < repo.getStudents().size(); i++) {
            if (repo.getStudents().get(i).getId().equals(id)) {
                repo.getStudents().remove(i);
                System.out.println("학생 정보가 삭제되었습니다.");
                return;
            }
        }
        System.out.println("해당 ID의 학생을 찾을 수 없습니다.");
    }


}   // end of class SchoolManagementEx