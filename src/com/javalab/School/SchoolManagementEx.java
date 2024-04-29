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

//    학생 관련 업무 메소드
    private static void studentMenu() {
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
                    registerStudent(scanner); // 학생 등록 메소드
                    break;
                case 2:
                    displayStudents(); // 학생 조회 메소드
                    break;
                case 3:
                    updateStudent(scanner); // 학생 정보 수정 메소드
                    break;
                case 4:
                    deleteStudent(scanner); // 학생 정보 삭제
                    break;
                case 5:
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
            }
        }
    }

    private static void registerStudent(Scanner scanner) { // 학생 등록 메소드
        System.out.println("학번: ");
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

    private static void displayStudents() { // 학생 조회 목록
        System.out.println("등록된 학생 목록:");
        System.out.println("학번 \t 주민번호 \t 이름 학년 주소 학과코드");
        for (Student s : repo.getStudents()) {
            System.out.println(s.getId() + " " + s.getJumin() + " " + s.getName() + " " + s.getYear() + " " + s.getAddress() + " " + s.getDepartment());
        }
    }

    private static void updateStudent(Scanner scanner) { // 학생 정보 수정 메소드
        System.out.println("수정할 학생의 학번을 입력하세요: ");
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
        System.out.println("해당 학번의 학생을 찾을 수 없습니다.");
    }

    private static void deleteStudent(Scanner scanner) { // 학생 정보 삭제 메소드
        System.out.println("삭제할 학생의 학번을 입력하세요: ");
        String id = scanner.nextLine();
        for (int i = 0; i < repo.getStudents().size(); i++) {
            if (repo.getStudents().get(i).getId().equals(id)) {
                repo.getStudents().remove(i);
                System.out.println("학생 정보가 삭제되었습니다.");
                return;
            }
        }
        System.out.println("해당 학번의 학생을 찾을 수 없습니다.");
    }

//  교수 업무 관련 메소드
    private static void professorMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("=============================");
            System.out.println("1. 교수 등록");
            System.out.println("2. 교수 조회");
            System.out.println("3. 교수 정보 수정");
            System.out.println("4. 교수 정보 삭제");
            System.out.println("5. 메인 메뉴로 가기");
            System.out.println("=============================");
            System.out.print("메뉴 선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 버퍼 비우기
            switch (choice) {
                case 1:
                    registerProfessor(scanner); // 교수 등록 메소드
                    break;
                case 2:
                    displayProfessor(); // 교수 조회 메소드
                    break;
                case 3:
                    updateProfessor(scanner); // 교수 정보 수정 메소드
                    break;
                case 4:
                    deleteProfessor(scanner); // 교수 정보 삭제 메소드
                    break;
                case 5:
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
            }
        }
    }

    private static void registerProfessor(Scanner scanner) { // 교수 등록 메소드
        System.out.println("교수 ID: ");
        String id = scanner.nextLine(); // 교수의 ID 입력 받음
        System.out.println("주민번호: ");
        String jumin = scanner.nextLine(); // 교수의 주민번호 입력 받음
        System.out.println("이름: ");
        String name = scanner.nextLine(); // 교수의 이름 입력 받음
        System.out.println("학과 코드: ");
        int department = scanner.nextInt(); // 교수의 학과 코드 입력 받음
        scanner.nextLine();
        System.out.println("직급: ");
        String grade = scanner.nextLine(); // 교수의 직급 입력 받음
        System.out.println("입사일: ");
        String hiredate = scanner.nextLine(); // 교수의 입사일 입력 받음

        Professor professor = new Professor(id, jumin, name, department, grade, hiredate); // 입력 받은 값들 professor에 저장
        repo.getProfessors().add(professor); // repo.getProfessors에 professor 추가
        System.out.println("교수 정보가 성공적으로 등록되었습니다.");
    }

    private static void displayProfessor() { // 교수 조회 메소드
        System.out.println("등록된 교수 목록:");
        System.out.println("교수ID 주민번호 \t\t 이름 학과코드 직급 입사일");
        for (Professor p : repo.getProfessors()) { // repo.getProfessors 데이터를 자료형이 Professor인 변수 p에 넣고 반복
            System.out.println(p.getId() + " " + p.getJumin() + " " + p.getName() + " " + p.getDepartment() + " " + p.getGrade() + " " + p.getHiredate());
        }
    }

    private static void updateProfessor(Scanner scanner) { // 교수 정보 수정 메소드
        System.out.println("수정할 교수의 ID를 입력하세요: ");
        String id = scanner.nextLine();
        for (Professor p : repo.getProfessors()) {
            if (p.getId().equals(id)) { // Professor의 getId와 수정할 교수의 ID에 입력된 id와 같으면 아래를 실행한다.
                System.out.println("새 이름: ");
                String name = scanner.nextLine();
                System.out.println("새 주민번호: ");
                String jumin = scanner.nextLine();
                System.out.println("새 직급: ");
                String grade = scanner.nextLine();
                System.out.println("새 입사일 : ");
                String hiredate = scanner.nextLine();
                System.out.println("새 학과 코드: ");
                int department = scanner.nextInt();
                scanner.nextLine();

                p.setName(name);
                p.setJumin(jumin);
                p.setGrade(grade);
                p.setHiredate(hiredate);
                p.setDepartment(department);
                // 입력 받은 name jumin grade hiredate department 값을 각각 p.set__데이터에 저장
                System.out.println("교수 정보가 업데이트 되었습니다.");
                return;
            }
        }
        System.out.println("해당 ID의 교수를 찾을 수 없습니다.");
    }

    private static void deleteProfessor(Scanner scanner) { // 교수 삭제 메소드
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
        while (true) {
            System.out.println("=============================");
            System.out.println("1. 학과 등록");
            System.out.println("2. 학과 조회");
            System.out.println("3. 학과 정보 수정");
            System.out.println("4. 학과 정보 삭제");
            System.out.println("5. 메인 메뉴로 가기");
            System.out.println("=============================");
            System.out.print("메뉴 선택: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // 버퍼 비우기

            switch (choice) {
                case 1 :
                    registerDepartment(scanner); // 학과 등록 메소드
                    break;
                case 2 :
                    displayDepartment(); // 학과 조회 메소드
                    break;
                case 3 :
                    updateDepartment(scanner);
                    break;
                case 4 :
                    deleteDepartment(scanner);
                    break;
                case 5 :
                    return;
                default :
                    System.out.println("잘못된 입력입니다. 다시 선택해주세요");
            }
        }
    }

    private static void registerDepartment(Scanner scanner) { // 학과 등록 메소드
        System.out.println("학과 코드: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // 버퍼 비우기
        System.out.println("학과명: ");
        String name = scanner.nextLine();
        System.out.println("학과 사무실: ");
        String office = scanner.nextLine();

        Department department = new Department(id, name, office);
        repo.getDepartments().add(department);
        System.out.println("학과 정보가 성공적으로 등록되었습니다.");
    }

    private static void displayDepartment() { // 학과 조회 메소드
        System.out.println("등록된 학과 목록");
        System.out.println("학과코드 학과명 학과사무실");
        for(Department d : repo.getDepartments()) {
            System.out.println(d.getId() + " " + d.getName() + " " + d.getOffice());
        }
    }

    private static void updateDepartment(Scanner scanner) { // 학과 정보 수정
        System.out.println("수정할 학과 코드를 입력해주세요");
        int id = scanner.nextInt();
        scanner.nextLine(); // 버퍼 비우기
        for(Department d : repo.getDepartments()) {
            if(d.getId() == id) {
                System.out.println("수정할 학과명: ");
                String name = scanner.nextLine();
                System.out.println("수정할 학과 사무실: ");
                String office = scanner.nextLine();

                d.setName(name);
                d.setOffice(office);
                System.out.println("학과 정보가 업데이트 되었습니다.");
                return;
            }
        }
        System.out.println("해당 코드의 학과를 찾을 수 없습니다.");
    }


    private static void deleteDepartment(Scanner scanner) { // 학과 정보 삭제
        System.out.println("삭제할 학과 코드를 입력해주세요");
        int id = scanner.nextInt();
        for ( int i = 0; i < repo.getDepartments().size(); i++) { // i = 0부터 반복
            if (repo.getDepartments().get(i).getId() == id) { // repo.getDepartments().get(i).getId()의 값과 입력된 id값이 같으면
                repo.getDepartments().remove(i); // remove(i) i 번째 값 삭제
                System.out.println("학과 정보가 삭제되었습니다.");
                return;
            }
        }
        System.out.println("해당 코드의 학과를 찾을 수 없습니다.");
    }

// 학과 관련 업무 메소드 끝

// 성적 관련 업무 메소드 시작
    private static void takesMenu() { // 성적 관련 업무 메소드
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("=============================");
            System.out.println("1. 성적 등록");
            System.out.println("2. 성적 조회");
            System.out.println("3. 성적 수정");
            System.out.println("4. 메인 메뉴로 가기");
            System.out.println("=============================");
            System.out.print("메뉴 선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    registerTakes(scanner);
                    break;
                case 2:
                    displayTakes();
                    break;
                case 3:
                    updateTakes(scanner);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 선택해주세요");
            }
        }
    }
    private static void registerTakes (Scanner scanner){
        System.out.println("학번: ");
        String id = scanner.nextLine();
        System.out.println("과목코드: ");
        String subject = scanner.nextLine();
        System.out.println("학점");
        String score = scanner.nextLine();
        Takes takes = new Takes(id, subject, score);
        repo.getTakes().add(takes);
        System.out.println("성적 정보가 성공적으로 등록되었습니다.");
    }
    private static void displayTakes () {
        System.out.println("등록된 성적 목록");
        System.out.println("학번 과목코드 점수");
        for (Takes t : repo.getTakes()) {
            System.out.println(t.getId() + " " + t.getSubject() + " " + t.getScore());
        }
    }
    private static void updateTakes (Scanner scanner){ // 학과 정보 수정
        System.out.println("학번을 입력해주세요");
        String id = scanner.nextLine();
        System.out.println("해당 학생의 수정할 과목코드를 입력하세요: ");
        String subject = scanner.nextLine();
        for (Takes t : repo.getTakes()) {
            if (t.getId().equals(id)) {
                if(t.getSubject().equals(subject)) {
                    System.out.println("수정할 학점: ");
                    String score = scanner.nextLine();
                    t.setSubject(subject);
                    t.setScore(score);
                    System.out.println("성적 정보가 업데이트 되었습니다.");
                    return;
                }
            }
        }
        System.out.println("해당 학번 및 학생의 과목코드에 해당하는 성적을 찾을 수 없습니다.");
    }


}   // end of class SchoolManagementEx