package cs544;

public class App {
	private static StudentDAO studentdao;
    public static void main(String[] args) {
		studentdao = new StudentDAO();
        System.out.println("stu--------");
		
		System.out.println("FROM DB "+studentdao.load(12345));
    }
}
