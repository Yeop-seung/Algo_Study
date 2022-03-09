import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		while (true)
        {
            if (a >= 0 && a < 24)
            {
                if(b >= 0 && b < 60)
                {
                    for (int i = 0; i < 45; i++)
                    {
                        if (b == 0)
                        {
                            b = 59;
                            if (a == 0)
                            {
                                a = 23;
                            }
                            else
                            a--;

                        }
                        else
                        b--;
                    }
                    break;
                }
                else
                {
                    continue;
                }
            }
            else
            {
                continue;
            }
        }
		System.out.println(a+" "+b);
	}

}
